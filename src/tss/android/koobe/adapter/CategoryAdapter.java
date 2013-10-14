package tss.android.koobe.adapter;

import tss.android.koobe.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CategoryAdapter extends BaseAdapter {

    private int[]   mCategorys;
    private Context mContext;
    private int     mSelectedItem;

    public CategoryAdapter(Context context, int[] categorys) {
        mCategorys = categorys;
        mContext = context;
        mSelectedItem = 0;
    }

    @Override
    public int getCount() {
        return mCategorys.length;
    }

    @Override
    public Object getItem(int position) {
        return mCategorys[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        int backgroundColor = android.R.color.transparent;
        int textColor = getColor(R.color.GREEN_TEXT);

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.category_item, null);
            holder = new ViewHolder();

            holder.background = (LinearLayout) convertView;
            holder.categoryView = (TextView) convertView.findViewById(R.id.categoryName);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (position == mSelectedItem) {
            backgroundColor = R.color.GREEN_DARK_1;
            textColor = getColor(R.color.WHITE_TEXT);
        }

        holder.categoryView.setText(mCategorys[position]);
        holder.categoryView.setTextColor(textColor);
        holder.background.setBackgroundColor(backgroundColor);

        return convertView;
    }

    public class ViewHolder {
        LinearLayout background;
        TextView     categoryView;
    }

    public void setSelected(int position) {
        mSelectedItem = position;
    }

    public int getSelected() {
        return mSelectedItem;
    }

    private int getColor(int color) {
        return mContext.getResources().getColor(color);
    }

}
