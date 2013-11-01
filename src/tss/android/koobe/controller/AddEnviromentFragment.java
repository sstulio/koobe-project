package tss.android.koobe.controller;

import tss.android.koobe.R;
import tss.android.koobe.adapter.ConfigurationListAdapter;
import tss.android.koobe.service.KoobeService;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class AddEnviromentFragment extends Fragment {

	public static final String TAG = "add_enviroment";
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    		Bundle savedInstanceState) {
    	
    	KoobeService service = KoobeService.getInstance();
    	View view = inflater.inflate(R.layout.fragment_add_enviroment, null);
    	ListView equipmentList = (ListView) view.findViewById(R.id.enviroments);
    	equipmentList.setAdapter(new ConfigurationListAdapter(getActivity(), service.getEnviromentList()));
    	
    	return view;
    }

}
