package tss.android.koobe.model;

import tss.android.koobe.model.Type.EquipmentType;

public class Equipment {

    private long          mId;
    private long          mEnvironmentId;
    private EquipmentType mType;
    private String        mName;

    public Equipment(String name, EquipmentType type, long enviromentId) {
        mName = name;
        mType = type;
        mEnvironmentId = enviromentId;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        this.mId = id;
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

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

}
