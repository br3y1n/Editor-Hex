package presentacion;

import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JFileChooser;
import logica.logic;

public class Model implements Runnable {

    private vista Vista;
    private logic Logica;
    private Thread Hilos;
    private int Column;
    private int Row;
    private int Counter1;

    @Override
    public void run() {
    }

    public void start() {
        getVista().setSize(1350, 650);
        getVista().setVisible(true);
        Hilos = new Thread(this);
        Hilos.start();
    }

    public vista getVista() {
        if (Vista == null) {
            Vista = new vista(this);
        }
        return Vista;
    }

    public logic getLogica() {
        if (Logica == null) {
            Logica = new logic();
        }
        return Logica;
    }

    public void AddressCell() {
        Column = getVista().getTable2().getSelectedColumn();
        Row = getVista().getTable2().getSelectedRow();
        if (Column < 16) {
            getVista().getTable3().changeSelection(Row, Column, false, false);
            getVista().getTable1().changeSelection(Row, 0, false, false);
            this.MapOut();
        }
    }

    public void MapOut() {
        if (Column < 16) {
            String[] Value = new String[8];
            if (Column > 8) {

                int h = 16 - Column;
                int m = 0;

                for (int i = 0; i < h; i++) {
                    Value[m] = (String) getVista().getTable2().getValueAt(Row, Column + i);
                    m++;
                }
                for (int i = 0; i < (8 - h); i++) {
                    if (Row != 19) {
                        Value[m] = (String) getVista().getTable2().getValueAt(Row + 1, 2 + i);

                    } else {
                        Value[m] = null;
                    }
                    m++;
                }
            } else {
                for (int i = 0; i < 8; i++) {
                    Value[i] = (String) getVista().getTable2().getValueAt(Row, Column + i);
                }
            }

            int Val = 0, Val2 = 0, Val3 = 0;
            long Val4 = 0;
            String h, j, m;

            if (getVista().getEndian().isSelected()) {
                if (Value[0] != null) {
                    Val = Integer.parseUnsignedInt(Value[0], 16);
                }
                if (Value[1] != null) {
                    h = Value[0] + Value[1];
                    Val2 = Integer.parseUnsignedInt(h, 16);
                }
                if (Value[3] != null) {
                    j = Value[0] + Value[1] + Value[2] + Value[3];
                    Val3 = Integer.parseUnsignedInt(j, 16);
                }
                if (Value[7] != null) {
                    m = Value[0] + Value[1] + Value[2] + Value[3] + Value[4] + Value[5] + Value[6] + Value[7];
                    Val4 = Long.parseUnsignedLong(m, 16);
                }

            } else {
                if (Value[0] != null) {
                    Val = Integer.parseUnsignedInt(Value[0], 16);
                }
                if (Value[1] != null) {
                    h = Value[1] + Value[0];
                    Val2 = Integer.parseUnsignedInt(h, 16);
                }
                if (Value[3] != null) {
                    j = Value[3] + Value[2] + Value[1] + Value[0];
                    Val3 = Integer.parseUnsignedInt(j, 16);
                }
                if (Value[7] != null) {
                    m = Value[7] + Value[6] + Value[5] + Value[4] + Value[3] + Value[2] + Value[1] + Value[0];
                    Val4 = Long.parseUnsignedLong(m, 16);
                }
            }

            byte l = (byte) Val;
            short l2 = (short) Val2;
            int l3 = (int) Val3;
            long l4 = (long) Val4;
            float x = Float.intBitsToFloat(Val3);
            double u = Double.longBitsToDouble(Val4);
            getVista().getLabelU8().setText(String.valueOf(Val));
            getVista().getLabelS8().setText(String.valueOf(l));
            getVista().getLabelU16().setText(String.valueOf(Val2));
            getVista().getLabelS16().setText(String.valueOf(l2));
            getVista().getLabelU32().setText(Integer.toUnsignedString(Val3));
            getVista().getLabelS32().setText(String.valueOf(l3));
            getVista().getLabelU64().setText(Long.toUnsignedString(Val4));
            getVista().getLabelS64().setText(String.valueOf(l4));
            getVista().getLabelF32().setText(String.valueOf(x));
            getVista().getLabelF64().setText(String.valueOf(u));
        }
    }

    public void Open() {
        JFileChooser WinPop = new JFileChooser();
        int option = WinPop.showOpenDialog(getVista());
        if (option == JFileChooser.APPROVE_OPTION) {
            String File = WinPop.getSelectedFile().getPath();
            getLogica().getDatos().setURL(File);
            getVista().getRuta().setText("Selecciono un archivo de: " + File);
            this.leerDatos();
        } else {
            getVista().getRuta().setText("No ha seleccionado un archivo");
        }
    }

    public void leerDatos() {
        String Offset = "";
        try {
            RandomAccessFile Data = new RandomAccessFile(getLogica().getDatos().getURL(),"r");
            long Length = Data.length();
            long TamaScroll = Data.length()/16;
            long colMore = Data.length() -TamaScroll*16;
            if (colMore != 0){
                TamaScroll++;
            }
            Counter1 = (int) TamaScroll + 20;
            if (TamaScroll > 20){
            getVista().getScroll().setMaximum((int)TamaScroll);
            }
            
            Data.seek((getVista().getScroll().getValue())*16);
            byte [] Input = new byte [336];       
            Data.read(Input, 0, 336);
            for (int j= 0; j < 20;j++){
                        Offset = String.format("%08X", ((getVista().getScroll().getValue()+j) * 16));
                        getVista().getTable1().setValueAt(Offset, j, 0);
            
                    for (int i = 0; i < 16; i++) {
   
          
                        int Int = Integer.parseInt(String.format("%d", Input[i+(j*16)] & 0xFF));
                        if (Int >= 0 && Int <= 32 || Int == 127) {
                            Int = 46;
                        }
                        String ValueHex = String.format("%02x", Input[i+(j*16)]);
                        String Char = String.valueOf((char) Int);
                        getVista().getTable2().setValueAt(ValueHex, j, i);
                        getVista().getTable3().setValueAt(Char, j, i);
                    }
            }
 Data.close();
                
        } catch (IOException e) {
            System.out.println("Error  " + e.toString());
            
        }
    }
}
