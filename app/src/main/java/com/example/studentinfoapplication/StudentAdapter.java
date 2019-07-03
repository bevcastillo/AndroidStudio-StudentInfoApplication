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
            holder.name = (TextView) convertView.findViewById(R.id.textName);
            holder.course = (TextView) convertView.findViewById(R.id.textCourse);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        //
        holder.image.setImageResource(studentArrayList.get(position).getImage());
        holder.name.setText(studentArrayList.get(position).getName());
        holder.course.setText(studentArrayList.get(position).getCourse());

        return convertView;
    }

    private static class ViewHolder{
        ImageView image;
        TextView name, course;
    }
}
