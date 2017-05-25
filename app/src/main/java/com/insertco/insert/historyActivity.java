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

import java.util.ArrayList;


public class historyActivity extends Fragment{

    ArrayList<String> historyDocumentName = new ArrayList<String>();
    ArrayList<String> historyDate = new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_history, container, false);

        historyDocumentName.add("doc1.docx");
        historyDocumentName.add("doc2.docx");
        historyDate.add("25 May 2017");
        historyDate.add("20 May 2017");

        ListView l1=(ListView)view.findViewById(R.id.listViewHistory);
        l1.setAdapter(new historyAdapter(getActivity(),historyDocumentName,historyDate));

//        ListView listViewHistory = (ListView) view.findViewById(R.id.listViewHistory);
//        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1,test);
//        listViewHistory.setAdapter(listViewAdapter);
        return view;
    }
}

class historyItem{

    String nameDoc;
    String date;
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

