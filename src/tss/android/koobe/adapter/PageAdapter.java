package tss.android.koobe.adapter;

import java.util.List;

import tss.android.koobe.controller.AirFragment;
import tss.android.koobe.controller.KoobeFragment;
import tss.android.koobe.controller.LampFragment;
import tss.android.koobe.controller.TvFragment;
import tss.android.koobe.model.Equipment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {

    List<Equipment> mEquipments;
    
    public PageAdapter(FragmentManager fm, List<Equipment> equipments) {
        super(fm);
        mEquipments = equipments;
    }

    @Override
    public Fragment getItem(int position) {
        Equipment equipment = mEquipments.get(position);
        return getFragment(equipment);
    }

    @Override
    public int getCount() {
        return mEquipments.size();
    }
    
    public void setEquipments(List<Equipment> equipments){
        mEquipments = equipments;
    }
    
    private Fragment getFragment(Equipment equipment){
        
        KoobeFragment result = null;
        
        switch (equipment.getType()) {
            case ADJUSTABLE_LAMP:
                result = new AirFragment();
                break;
            case AIR_CONDITIONER:
                result = new AirFragment();
                break;
            case LAMP:
                result = new LampFragment();
                break;
            case TV_CONTROL:
                result = new TvFragment();
                break;
            default:
                result = new LampFragment();
                break;
        }
        
        result.setEquipment(equipment);
        
        return result;
    }

}
