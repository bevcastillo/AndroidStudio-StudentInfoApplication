package com.example.studentinfoapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {

    Context context;
    ArrayList<Student> studentArrayList;
    LayoutInflater inflater;

    //contructor


    public StudentAdapter(Context context, ArrayList<Student> studentArrayList) {
        this.context = context;
        this.studentArrayList = studentArrayList;
    }

    @Override
    public int getCount() {
        return studentArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_layout, parent, false);
            holder.image = (ImageView) convertView.findViewById(R.id.imageView);
            holder.lname = (TextView) convertView.findViewById(R.id.textLName);
            holder.fname = (TextView) convertView.findViewById(R.id.textFName);
            holder.course = (TextView) convertView.findViewById(R.id.textCourse);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        //
        holder.lname.setText(studentArrayList.get(position).getLname());
        holder.fname.setText(studentArrayList.get(position).getFname());
        holder.image.setImageURI(studentArrayList.get(position).getImage());
        holder.course.setText(studentArrayList.get(position).getCourse());

        return convertView;
    }

    private static class ViewHolder{
        ImageView image;
        TextView lname, fname, course;
    }
}
