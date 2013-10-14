package tss.android.koobe.model;

public class Environment {

    private long   mId;
    private String mName;

    public Environment(long id, String name) {
        this.mId = id;
        mName = name;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        this.mId = id;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

}
