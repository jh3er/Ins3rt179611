package com.insertco.insert;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Jeremy Adam on 21/05/2017.
 */

public class storageActivity extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_storage, container, false);

        String uri = getActivity().getIntent().getStringExtra("URI_pass");
        if(uri !=null){
            ((globalClass)getActivity().getApplication()).addStorageName(uri);
        }
        ArrayList<String> arStorage = ((globalClass) getActivity().getApplication()).getStorageName();
        if(!arStorage.isEmpty()) {
           ListView li = (ListView) view.findViewById(R.id.listViewStorage);
           ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, arStorage);
           li.setAdapter(listViewAdapter);

        }
       return view;
    }
}
