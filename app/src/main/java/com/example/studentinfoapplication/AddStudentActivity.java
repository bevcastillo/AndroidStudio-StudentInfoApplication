package com.example.studentinfoapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AddStudentActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    ListView listView;
    ImageView studentImage;
    EditText studLname, studFname;
    Button btnSave, btnCancel;
    Spinner cboCourse;
    String selectedCourse;
    Uri imageUri;
    private static final int PICK_IMAGE = 100;
    ArrayList<Student> studentArrayList = new ArrayList<Student>();
    StudentAdapter studentAdapter;
    Student student = new Student();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        //
        studentImage = (ImageView) findViewById(R.id.imageView2);
        studLname = (EditText) findViewById(R.id.editText1);
        studFname = (EditText) findViewById(R.id.editText2);
        cboCourse = (Spinner) findViewById(R.id.spinner);
        btnSave = (Button) findViewById(R.id.btnsave);
        btnCancel = (Button) findViewById(R.id.btncancel);
        listView = (ListView) findViewById(R.id.listview);

        cboCourse.setOnItemSelectedListener(this);
        studentImage.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        studentAdapter = new StudentAdapter(this, studentArrayList);

    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Unsaved Changes");
        builder.setMessage("Are you sure you want to leave?");
        builder.setPositiveButton("LEAVE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home){
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();

        String lname = studLname.getText().toString();
        String fname = studFname.getText().toString();
        String course = cboCourse.getSelectedItem().toString();

        switch (id){
            case R.id.imageView2:
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, PICK_IMAGE);
                break;
            case R.id.btnsave:
                if(!studentImage.equals(R.drawable.user) && !studLname.getText().toString().trim().equals("") && !studFname.getText().toString().trim().equals("") && !cboCourse.getSelectedItem().toString().trim().equals(0)){

                    student.setLname(lname);
                    student.setFname(fname);
                    student.setCourse(course);

                    Student.studentArrayList.add(student); //Global arraylist

//                    Log.d("test", "students:" + Student.studentArrayList);

                    Toast.makeText(getApplicationContext(), "Item successfully added!", Toast.LENGTH_SHORT).show();
                    Intent home = new Intent(AddStudentActivity.this, MainActivity.class);
                    startActivity(home);
                    studentAdapter.notifyDataSetChanged();
                    break;
                }else{
                    Toast.makeText(getApplicationContext(), "Fields can not be empty!", Toast.LENGTH_SHORT).show();
                    break;
                }

            case R.id.btncancel:
                studentImage.setImageResource(R.drawable.user);
                studLname.setText("");
                studFname.setText("");
                cboCourse.setSelection(0);
                break;
        }
    }

    //handles opening the camera

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            if (data != null) {
                imageUri = data.getData();
            }
            student.setImage(imageUri);
            studentImage.setImageURI(imageUri);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //for the spinner
        int sid = parent.getId();

        switch (sid){
            case R.id.spinner:
                selectedCourse = this.cboCourse.getItemAtPosition(position).toString();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
