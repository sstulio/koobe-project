package tss.android.koobe.model;

import tss.android.koobe.model.Type.EquipmentType;

public class Equipment extends BaseModel {

    private long          mEnvironmentId;
    private EquipmentType mType;

    public Equipment(String name, EquipmentType type, long enviromentId) {
    	super(0, name, 0);
        mType = type;
        mEnvironmentId = enviromentId;
    }

    public long getEnvironmentId() {
        return mEnvironmentId;
    }

    public void setEnvironmentId(long environmentId) {
        this.mEnvironmentId = environmentId;
    }

    public EquipmentType getType() {
        return mType;
    }

    public void setType(EquipmentType type) {
        this.mType = type;
    }
}
