package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.delaroystudios.studentmgt.R;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Students> {

    public ListAdapter(Context context, ArrayList<Students>studentsArrayList){
        super(context,R.layout.list_item,studentsArrayList);
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        Students students=getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }

//        ImageView imageView = convertView.findViewById(R.id.profile_pic);
        TextView studentname= convertView.findViewById(R.id.personName);
        TextView registration= convertView.findViewById(R.id.RegistrationET);
        TextView year= convertView.findViewById(R.id.yearET);


        studentname.setText(students.getName());

        return super.getView(position, convertView, parent);
    }
}
