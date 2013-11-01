package tss.android.koobe.adapter;

import tss.android.koobe.controller.AddEnviromentFragment;
import tss.android.koobe.controller.AddEquipmentFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ConfigurationPagerAdapter extends FragmentStatePagerAdapter {

    public ConfigurationPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
    	Fragment fragment = null;
    	
    	switch (position) {
		case 0:
			fragment = new AddEquipmentFragment();
			break;

		case 1:
			fragment = new AddEnviromentFragment();
			break;
		}    	
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
    
}
