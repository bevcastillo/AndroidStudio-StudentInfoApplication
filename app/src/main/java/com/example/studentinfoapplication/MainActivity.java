package com.example.studentinfoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    StudentAdapter studentAdapter;
    ListView listView;
    TextView emptyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);
        emptyText = (TextView) findViewById(R.id.empty);

        listView.setEmptyView(emptyText);

        if (Student.studentArrayList != null) {
//            emptyText.setVisibility(View.GONE);
            studentAdapter = new StudentAdapter(this, Student.studentArrayList);
            listView.setAdapter(studentAdapter);
        }else{
            listView.setVisibility(View.INVISIBLE);
            emptyText.setVisibility(View.VISIBLE);
        }
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
