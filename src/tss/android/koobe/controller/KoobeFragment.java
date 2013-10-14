package tss.android.koobe.controller;

import tss.android.koobe.R;
import tss.android.koobe.model.Equipment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public abstract class KoobeFragment extends Fragment {

    protected Equipment mEquipment;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(getFragmentLayout(), null);
        
        TextView name = (TextView) view.findViewById(R.id.equipment_name);
        name.setText(mEquipment.getName());
        
        return view;
    }
    
    public Equipment getEquipment() {
        return mEquipment;
    }

    public void setEquipment(Equipment equipment) {
        this.mEquipment = equipment;
    }
    
    protected abstract int getFragmentLayout();
}
