package com.example.surya.samplesqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by surya on 12/11/16.
 */
public class StudentAdapter extends ArrayAdapter<Student> {

    private Context context;
    public StudentAdapter(Context context, ArrayList<Student> student) {
        super(context,0,student);
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Student student=getItem(position);
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.layout_listview_item,parent,false);
        TextView txtListViewItem=(TextView) convertView.findViewById(R.id.listview_item);
        txtListViewItem.setText(student.getFirstName());
        return txtListViewItem;
    }
}
