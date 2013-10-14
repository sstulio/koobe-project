package tss.android.koobe.model;

import tss.android.koobe.R;

public class Type {

    public static final int LAMP_NAME            = R.string.lamp;
    public static final int ADJUSTABLE_LAMP_NAME = R.string.adjustable_lamp;
    public static final int AIR_CONDITIONER_NAME = R.string.air_conditioner;
    public static final int TV_CONTROL_NAME      = R.string.tv_control;

    public enum EquipmentType {
        LAMP, ADJUSTABLE_LAMP, AIR_CONDITIONER, TV_CONTROL;
    }

    public static int[] getTypeList() {
        return new int[] { LAMP_NAME, ADJUSTABLE_LAMP_NAME, AIR_CONDITIONER_NAME, TV_CONTROL_NAME };
    }

    public static int Count() {
        return getTypeList().length;
    }
}
