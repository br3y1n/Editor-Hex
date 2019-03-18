package Logic;

import Persistence.Data;
import Presentation.Model;

public class Logic {

    private Data data;
    private Model model;

    public Logic(Model get) {
        model = get;
    }

    public Data getData() {
        if (data == null) {
            data = new Data(this);
        }
        return data;
    }

    public String[] Convert(String[] Value) {

        String[] DataPrint = new String[10];
        int Val = 0, Val2 = 0, Val3 = 0;
        long Val4 = 0;
        String sVal2, sVal3, sVal4;

        if (model.getView().getBigEndian().isSelected()) {
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

        DataPrint[0] = String.valueOf(Val);
        DataPrint[1] = String.valueOf(Val2);
        DataPrint[2] = Integer.toUnsignedString(Val3);
        DataPrint[3] = Long.toUnsignedString(Val4);
        DataPrint[4] = String.valueOf(byteVal);
        DataPrint[5] = String.valueOf(shortVal2);
        DataPrint[6] = String.valueOf(intVal3);
        DataPrint[7] = String.valueOf(longVal4);
        DataPrint[8] = String.valueOf(floatVal3);
        DataPrint[9] = String.valueOf(doubleVal4);

        return DataPrint;
    }

}
