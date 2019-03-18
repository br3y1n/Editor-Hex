package Persistence;

import Logic.Logic;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Data {

    private String URL;
    private Logic logic;

    public Data(Logic get) {
        logic = get;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }

    public Long getScrollSize() {
        long ScrollSize = 0;
        try {
            RandomAccessFile DataString = new RandomAccessFile(URL, "r");
            ScrollSize = DataString.length() / 16;
            long colMore = DataString.length() - ScrollSize * 16;
            if (colMore != 0) {
                ScrollSize++;
            }
            DataString.close();
        } catch (IOException e) {
            System.out.println("Error  " + e.toString());
        }
        return ScrollSize;
    }

    public byte[] getDataString(int PosPointer) {

        byte[] Input = null;
        try {
            RandomAccessFile DataString = new RandomAccessFile(URL, "r");
            DataString.seek(PosPointer);
            Input = new byte[336];
            DataString.read(Input, 0, 336);
            DataString.close();
        } catch (IOException e) {
            System.out.println("Error  " + e.toString());
        }
        return Input;
    }

    public String[] getValuesToConvert(int PosPointer, int Row, int Column) {

        String[] Value = new String[8];
        long pointerOffset = 0;
        long dif = 0;
        byte[] Input = null;

        try {
            RandomAccessFile DataString = new RandomAccessFile(URL, "r");
            pointerOffset = (PosPointer + (Row * 16)) + Column;
            dif = DataString.length() - pointerOffset;
            if (dif > 7) {
                DataString.seek(pointerOffset);
                Input = new byte[8];
                DataString.read(Input, 0, 8);
                for (int i = 0; i < 8; i++) {
                    Value[i] = String.format("%02x", Input[i]);
                }

            } else if (DataString.length() >= pointerOffset) {

                DataString.seek(pointerOffset);
                Input = new byte[8];
                DataString.read(Input, 0, (int) dif);
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
            DataString.close();
        } catch (IOException e) {
            System.out.println("Error  " + e.toString());

        }
        return Value;
    }
}
