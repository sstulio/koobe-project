package tss.android.koobe.model;


public class BaseModel {

	private long mId;
	private String mName;
	private int mIcon;

	public BaseModel(long id, String name, int iconRes) {
		mId = id;
		mName = name;
		setIcon(iconRes);
	}

	public long getId() {
		return mId;
	}

	public void setId(long id) {
		this.mId = id;
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		this.mName = name;
	}

	public int getIcon() {
		return mIcon;
	}

	public void setIcon(int icon) {
		this.mIcon = icon;
	}

}
