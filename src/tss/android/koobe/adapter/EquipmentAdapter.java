package tss.android.koobe.adapter;

import java.util.List;

import tss.android.koobe.R;
import tss.android.koobe.model.Environment;
import tss.android.koobe.model.Type;
import tss.android.koobe.model.Type.EquipmentType;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class EquipmentAdapter extends BaseAdapter {

    public static final int   TYPE_ENVIROMENT = 0;
    public static final int   TYPE_EQUIPMENT  = 1;

    private List<Environment> mEnvironments;
    private Context           mContext;
    private int               mSelectedItem;
    private int               mType;

    public EquipmentAdapter(Context context, List<Environment> environments) {
        mEnvironments = environments;
        mContext = context;
        mSelectedItem = 0;
        mType = TYPE_ENVIROMENT;
    }

    @Override
    public int getCount() {
        return (mType == TYPE_ENVIROMENT) ? mEnvironments.size() : Type.Count();
    }

    @Override
    public Object getItem(int position) {
        return (mType == TYPE_ENVIROMENT) ? mEnvironments.get(position) : EquipmentType.values()[position];
    }

    @Override
    public long getItemId(int position) {
        return mEnvironments.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        int textColor = getColor(R.color.GREEN_TEXT);

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.equipament_item, null);
            holder = new ViewHolder();

            holder.equipmentName = (TextView) convertView.findViewById(R.id.equipment_name);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (position == mSelectedItem) {
            textColor = getColor(R.color.WHITE_TEXT);
        }

        String name;

        if (mType == TYPE_ENVIROMENT) {
            name = mEnvironments.get(position).getName();
        } else {
            name = mContext.getString(Type.getTypeList()[position]);
        }

        holder.equipmentName.setText(name);
        holder.equipmentName.setTextColor(textColor);

        return convertView;
    }

    private class ViewHolder {
        TextView equipmentName;
    }

    public void setSelected(int position) {
        mSelectedItem = position;
    }

    public void setType(int type) {
        mType = type;
    }
    
    public int getType(){
        return mType;
    }

    private int getColor(int color) {
        return mContext.getResources().getColor(color);
    }

}
