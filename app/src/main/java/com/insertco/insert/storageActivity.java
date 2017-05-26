package com.insertco.insert;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        final ListView li = (ListView) view.findViewById(R.id.listViewStorage);
        if(!arStorage.isEmpty()) {
           ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, arStorage);
           li.setAdapter(listViewAdapter);
        }

        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {
                String selectedFromList =(String) (li.getItemAtPosition(myItemInt));
                Toast.makeText(getActivity(), selectedFromList, Toast.LENGTH_SHORT).show();
                if(selectedFromList !=null){
                    ((globalClass)getActivity().getApplication()).setDocumentName(selectedFromList);
                }
            }
        });

        return view;
    }

}
