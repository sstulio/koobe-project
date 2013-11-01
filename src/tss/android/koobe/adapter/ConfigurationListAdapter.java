package tss.android.koobe.adapter;

import java.util.List;

import tss.android.koobe.R;
import tss.android.koobe.model.BaseModel;
import tss.android.koobe.model.Equipment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ConfigurationListAdapter extends BaseAdapter {

    private Context mContext;
	private List<? extends BaseModel> mList;

    public ConfigurationListAdapter(Context context, List<? extends BaseModel> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.equipament_item, null);
            holder = new ViewHolder();

            holder.equipmentIcon = (ImageView) convertView.findViewById(R.id.equipmentIcon);
            holder.equipmentName = (TextView) convertView.findViewById(R.id.equipment_name);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.equipmentName.setText(mList.get(position).getName());
        holder.equipmentName.setTextColor(getColor(android.R.color.background_light));
        
        return convertView;
    }

    public class ViewHolder {
        ImageView equipmentIcon;
        TextView  equipmentName;
    }

    private int getColor(int color) {
        return mContext.getResources().getColor(color);
    }
}
