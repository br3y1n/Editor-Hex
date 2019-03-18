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
            this.updateItems();
            this.loadDataInCells();
        }
    }

    public void updateItems() {
        getView().getTable1().setVisible(true);
        getView().getTable2().setVisible(true);
        getView().getTable3().setVisible(true);
        getView().getBigEndian().setVisible(true);
        getView().getLittleEndian().setVisible(true);
    }

    public void loadDataInCells() {

        String Offset = "";
        long ScrollSize = getLogic().getData().getScrollSize();
        
        if (ScrollSize > 20) {
            getView().getScroll().setMaximum((int) ScrollSize);
        } else {
            getView().getScroll().setMaximum(20);
        }
        
        int PosPointer = getView().getScroll().getValue() * 16;
        byte[] ValueCell = getLogic().getData().getDataString(PosPointer);

        for (int j = 0; j < 20; j++) {
            Offset = String.format("%08X", ((getView().getScroll().getValue() + j) * 16));
            getView().getTable1().setValueAt(Offset, j, 0);

            for (int i = 0; i < 16; i++) {

                int Int = Integer.parseInt(String.format("%d", ValueCell[i + (j * 16)] & 0xFF));
                if (Int >= 0 && Int <= 32 || Int == 127) {
                    Int = 46;
                }
                String ValueHex = String.format("%02x", ValueCell[i + (j * 16)]);
                String Char = String.valueOf((char) Int);
                getView().getTable2().setValueAt(ValueHex, j, i);
                getView().getTable3().setValueAt(Char, j, i);
            }
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

        int PosPointer = getView().getScroll().getValue() * 16;
        Value = getLogic().getData().getValuesToConvert(PosPointer, Row, Column);

        String[] DataPrint = getLogic().Convert(Value);

        getView().getLabelU8().setText(DataPrint[0]);
        getView().getLabelS8().setText(DataPrint[4]);
        getView().getLabelU16().setText(DataPrint[1]);
        getView().getLabelS16().setText(DataPrint[5]);
        getView().getLabelU32().setText(DataPrint[2]);
        getView().getLabelS32().setText(DataPrint[6]);
        getView().getLabelU64().setText(DataPrint[3]);
        getView().getLabelS64().setText(DataPrint[7]);
        getView().getLabelF32().setText(DataPrint[8]);
        getView().getLabelF64().setText(DataPrint[9]);
    }
}
