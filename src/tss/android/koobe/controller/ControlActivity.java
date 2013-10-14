package tss.android.koobe.controller;

import java.util.List;

import tss.android.koobe.R;
import tss.android.koobe.adapter.CategoryAdapter;
import tss.android.koobe.adapter.EquipmentAdapter;
import tss.android.koobe.adapter.PageAdapter;
import tss.android.koobe.model.Equipment;
import tss.android.koobe.model.Type.EquipmentType;
import tss.android.koobe.service.KoobeService;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ControlActivity extends FragmentActivity implements OnItemClickListener {

    private final int[]      CATEGORYS = new int[] { R.string.ambient, R.string.equipment };

    private ListView         mDrawerList;
    private ListView         mEquipmentsList;

    private KoobeService     mService;

    private DrawerLayout     mDrawerLayout;
    private EquipmentAdapter mAdapter;
    private PageAdapter      mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        mService = KoobeService.getInstance();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mDrawerList = (ListView) findViewById(R.id.category_list);

        mDrawerList.setAdapter(new CategoryAdapter(this, CATEGORYS));
        mDrawerList.setOnItemClickListener(onCategorySelected);

        mAdapter = new EquipmentAdapter(this, mService.getEnviromentList());

        mEquipmentsList = (ListView) findViewById(R.id.equipments_list);
        mEquipmentsList.setAdapter(mAdapter);
        mEquipmentsList.setOnItemClickListener(this);

        if (!mService.getEnviromentList().isEmpty()) {
            long fId = mService.getEnviromentList().get(0).getId();

            ViewPager pager = (ViewPager) findViewById(R.id.pager);
            mPagerAdapter = new PageAdapter(getSupportFragmentManager(), mService.getEquipmentsByEnviroment(fId));
            pager.setAdapter(mPagerAdapter);
        }

        mDrawerLayout.openDrawer(Gravity.LEFT);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.control, menu);
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        EquipmentAdapter adapter = (EquipmentAdapter) adapterView.getAdapter();
        adapter.setSelected(position);
        
        List<Equipment> equipments = null;
        if(mAdapter.getType() == EquipmentAdapter.TYPE_ENVIROMENT){
            equipments = mService.getEquipmentsByEnviroment(id);
        }
        else{
            equipments = mService.getEquipmentsByType((EquipmentType) mAdapter.getItem(position));
        }
        
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter.setEquipments(equipments);
        
        pager.setAdapter(mPagerAdapter);
        mPagerAdapter.notifyDataSetChanged();
        
        adapter.notifyDataSetChanged();

        mDrawerLayout.closeDrawers();
    }

    OnItemClickListener onCategorySelected = new OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view,
                int position, long id) {
            
            CategoryAdapter adapter = (CategoryAdapter) adapterView.getAdapter();
            
            if (adapter.getSelected() != position) {
                fadeAnimation();
                
                int type = (position == 0) ? EquipmentAdapter.TYPE_ENVIROMENT : EquipmentAdapter.TYPE_EQUIPMENT;
                mAdapter.setType(type);
                    
                adapter.notifyDataSetChanged();
                mAdapter.notifyDataSetChanged();
            }   

            adapter.setSelected(position);
        }
    };
    
    private void fadeAnimation() {
        Animation anim = new AlphaAnimation(0, 1);
        anim.setDuration(500);
        mEquipmentsList.startAnimation(anim);
    }

}
