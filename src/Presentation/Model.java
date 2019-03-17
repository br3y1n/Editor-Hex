package Presentation;

import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JFileChooser;
import Logic.Logic;

public class Model implements Runnable {

    private View view;
    private Logic logic;
    private int Column;
    private int Row;

    @Override
    public void run() {
    }

    public void start() {
        getView().setSize(1350, 650);
        getView().setVisible(true);
        getView().getTable1().setVisible(false);
        getView().getTable2().setVisible(false);
        getView().getTable3().setVisible(false);
        getView().getBigEndian().setVisible(false);
        getView().getLittleEndian().setVisible(false);

    }

    public View getView() {
        if (view == null) {
            view = new View(this);
        }
        return view;
    }

    public Logic getLogic() {
        if (logic == null) {
            logic = new Logic(this);
        }
        return logic;
    }

    public void Open() {
        JFileChooser WinPop = new JFileChooser();
        int option = WinPop.showOpenDialog(getView());
        if (option == JFileChooser.APPROVE_OPTION) {
            String File = WinPop.getSelectedFile().getPath();
            getLogic().getData().setURL(File);
            getView().getRoute().setText("Selecciono un archivo de: " + File);
            this.update();
            this.readData();
        } 
    }
    
    public void update() {
        getView().getTable1().setVisible(true);
        getView().getTable2().setVisible(true);
        getView().getTable3().setVisible(true);
        getView().getBigEndian().setVisible(true);
        getView().getLittleEndian().setVisible(true);
    }
    
    public void readData() {
        String Offset = "";
        try {
            RandomAccessFile Data = new RandomAccessFile(getLogic().getData().getURL(), "r");
            long Length = Data.length();
            long TamaScroll = Data.length() / 16;
            long colMore = Data.length() - TamaScroll * 16;
            if (colMore != 0) {
                TamaScroll++;
            }
            if (TamaScroll > 20) {
                getView().getScroll().setMaximum((int) TamaScroll);
            }else{
                getView().getScroll().setMaximum(20);
            }

            Data.seek((getView().getScroll().getValue()) * 16);
            byte[] Input = new byte[336];
            Data.read(Input, 0, 336);
            for (int j = 0; j < 20; j++) {
                Offset = String.format("%08X", ((getView().getScroll().getValue() + j) * 16));
                getView().getTable1().setValueAt(Offset, j, 0);

                for (int i = 0; i < 16; i++) {

                    int Int = Integer.parseInt(String.format("%d", Input[i + (j * 16)] & 0xFF));
                    if (Int >= 0 && Int <= 32 || Int == 127) {
                        Int = 46;
                    }
                    String ValueHex = String.format("%02x", Input[i + (j * 16)]);
                    String Char = String.valueOf((char) Int);
                    getView().getTable2().setValueAt(ValueHex, j, i);
                    getView().getTable3().setValueAt(Char, j, i);
                }
            }
            Data.close();

        } catch (IOException e) {
            System.out.println("Error  " + e.toString());

        }
    }

    public void AddressCellTab2() {
        Column = getView().getTable2().getSelectedColumn();
        Row = getView().getTable2().getSelectedRow();
        this.MapOut();
    }

    public void AddressCellTab3() {
        Column = getView().getTable3().getSelectedColumn();
        Row = getView().getTable3().getSelectedRow();
        this.MapOut();
    }

    public void MapOut() {
        getView().getTable3().changeSelection(Row, Column, false, false);
        getView().getTable1().changeSelection(Row, 0, false, false);
        getView().getTable2().changeSelection(Row, Column, false, false);
        String[] Value = new String[8];
        long Length = 0;
        long pointerOffset = 0;
        long dif = 0;

        try {
            RandomAccessFile Data = new RandomAccessFile(getLogic().getData().getURL(), "r");
            Length = Data.length();
            pointerOffset = (((getView().getScroll().getValue()) * 16) + (Row * 16)) + Column;
            dif = Length - pointerOffset;
            if (dif > 7) {
                Data.seek(pointerOffset);
                byte[] Input = new byte[8];
                Data.read(Input, 0, 8);
                for (int i = 0; i < 8; i++) {
                    Value[i] = String.format("%02x", Input[i]);
                }

            } else if (Length >= pointerOffset) {

                Data.seek(pointerOffset);
                byte[] Input = new byte[8];
                Data.read(Input, 0, (int) dif);
                for (int i = 0; i < dif; i++) {
                    Value[i] = String.format("%02x", Input[i]);
                }
                for (int i = 0; i < (8 - dif); i++) {
                    Value[7 - i] = null;
                }

            } else {
                for (int i = 0; i < 8; i++) {
                    Value[i] = null;
                }
            }

        } catch (IOException e) {
            System.out.println("Error  " + e.toString());

        }

        int Val = 0, Val2 = 0, Val3 = 0;
        long Val4 = 0;
        String sVal2, sVal3, sVal4;

        if (getView().getBigEndian().isSelected()) {
            if (Value[0] != null) {
                Val = Integer.parseUnsignedInt(Value[0], 16);
            }
            if (Value[1] != null) {
                sVal2 = Value[0] + Value[1];
                Val2 = Integer.parseUnsignedInt(sVal2, 16);
            }
            if (Value[3] != null) {
                sVal3 = Value[0] + Value[1] + Value[2] + Value[3];
                Val3 = Integer.parseUnsignedInt(sVal3, 16);
            }
            if (Value[7] != null) {
                sVal4 = Value[0] + Value[1] + Value[2] + Value[3] + Value[4] + Value[5] + Value[6] + Value[7];
                Val4 = Long.parseUnsignedLong(sVal4, 16);
            }

        } else {
            if (Value[0] != null) {
                Val = Integer.parseUnsignedInt(Value[0], 16);
            }
            if (Value[1] != null) {
                sVal2 = Value[1] + Value[0];
                Val2 = Integer.parseUnsignedInt(sVal2, 16);
            }
            if (Value[3] != null) {
                sVal3 = Value[3] + Value[2] + Value[1] + Value[0];
                Val3 = Integer.parseUnsignedInt(sVal3, 16);
            }
            if (Value[7] != null) {
                sVal4 = Value[7] + Value[6] + Value[5] + Value[4] + Value[3] + Value[2] + Value[1] + Value[0];
                Val4 = Long.parseUnsignedLong(sVal4, 16);
            }
        }

        byte byteVal = (byte) Val;
        short shortVal2 = (short) Val2;
        int intVal3 = (int) Val3;
        long longVal4 = (long) Val4;
        float floatVal3 = Float.intBitsToFloat(Val3);
        double doubleVal4 = Double.longBitsToDouble(Val4);
        getView().getLabelU8().setText(String.valueOf(Val));
        getView().getLabelS8().setText(String.valueOf(byteVal));
        getView().getLabelU16().setText(String.valueOf(Val2));
        getView().getLabelS16().setText(String.valueOf(shortVal2));
        getView().getLabelU32().setText(Integer.toUnsignedString(Val3));
        getView().getLabelS32().setText(String.valueOf(intVal3));
        getView().getLabelU64().setText(Long.toUnsignedString(Val4));
        getView().getLabelS64().setText(String.valueOf(longVal4));
        getView().getLabelF32().setText(String.valueOf(floatVal3));
        getView().getLabelF64().setText(String.valueOf(doubleVal4));
    }
}
