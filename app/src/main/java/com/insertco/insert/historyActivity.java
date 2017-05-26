package com.insertco.insert;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;


public class historyActivity extends Fragment{
//
//    ArrayList<String> historyDocumentName = new ArrayList<String>();
//    ArrayList<String> historyDate = new ArrayList<String>();
    historyAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_history, container, false);
        ListView l1=(ListView)view.findViewById(R.id.listViewHistory);
        String typeSelected = getActivity().getIntent().getStringExtra("typeSelected");
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());


        ArrayList<String> hisDocName = ((globalClass) getActivity().getApplication()).getHistoryDocumentName();
        ArrayList<String> hisDate = ((globalClass) getActivity().getApplication()).getHistoryDate();

        if(typeSelected != null) {
            ((globalClass)  getActivity().getApplication()).addHistoryDocumentName(((globalClass) getActivity().getApplication()).getDocumentName());
            ((globalClass)  getActivity().getApplication()).addHistoryDate(currentDateTimeString);
        }
        adapter = new historyAdapter(getActivity(),hisDocName,hisDate);
        l1.setAdapter(adapter);

        adapter.notifyDataSetChanged();
        ((globalClass)  getActivity().getApplication()).setDocumentName(null);
        return view;

    }
}

class historyAdapter extends BaseAdapter{
    ArrayList<String> name,date;
    Context context;

    public historyAdapter(Context context, ArrayList<String> n,ArrayList<String> d){
        this.context = context;
        name = n;
        date = d;

    }

    @Override
    public int getCount() {
        return name.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.row_history, viewGroup, false);
        TextView nameTV, dateTV;
        nameTV = (TextView) row.findViewById(R.id.textViewDocumentName);
        dateTV = (TextView) row.findViewById(R.id.textViewDate);
        nameTV.setText(name.get(i));
        dateTV.setText(date.get(i));

        return row;
    }
}

