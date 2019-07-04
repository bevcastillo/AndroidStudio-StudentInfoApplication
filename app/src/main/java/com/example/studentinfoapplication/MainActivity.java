package com.example.studentinfoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> studentArrayList = new ArrayList<Student>();
    StudentAdapter studentAdapter;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);

        studentAdapter = new StudentAdapter(this, studentArrayList);
        listView.setAdapter(studentAdapter);
    }


    //back button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home){
            onBackPressed();
            return true;
        }else if(id == R.id.action_add){
            Intent add = new Intent(MainActivity.this, AddStudentActivity.class);
            startActivity(add);
        }
        return super.onOptionsItemSelected(item);
    }

    //show add menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu, menu);
        return true;
    }


}
