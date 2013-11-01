package tss.android.koobe.controller;

import tss.android.koobe.R;
import tss.android.koobe.adapter.EquipmentAdapter;
import tss.android.koobe.adapter.ConfigurationListAdapter;
import tss.android.koobe.model.Equipment;
import tss.android.koobe.service.KoobeService;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AddEquipmentFragment extends Fragment {

	public static final String TAG = "add_equipment";
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    		Bundle savedInstanceState) {
    	
    	KoobeService service = KoobeService.getInstance();
    	View view = inflater.inflate(R.layout.fragment_add_equipment, null);
    	ListView equipmentList = (ListView) view.findViewById(R.id.equipments);
    	equipmentList.setAdapter(new ConfigurationListAdapter(getActivity(), service.getEquipments()));
    	
    	return view;
    }

}
