package com.example.intentschallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
//implements
public class Activity2 extends AppCompatActivity implements View.OnClickListener {
    EditText etName,etPhone,etLocation,etWeb;
    ImageView img1,img2,img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        etName=findViewById(R.id.etName);
        etPhone=findViewById(R.id.etPhone);
        etLocation=findViewById(R.id.etLocation);
        etWeb=findViewById(R.id.etWeb);
        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        img3=findViewById(R.id.img3);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(etName.getText().toString().isEmpty()||etLocation.getText().toString().isEmpty()||etPhone.getText().toString().isEmpty()||etWeb.getText().toString().isEmpty()){
            Toast.makeText(Activity2.this,"Please enter all fields",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent=new Intent(Activity2.this,MainActivity.class);
            intent.putExtra("name",etName.getText().toString().trim());
            intent.putExtra("phone",etPhone.getText().toString().trim());
            intent.putExtra("location",etLocation.getText().toString().trim());
            intent.putExtra("web",etWeb.getText().toString().trim());
            ///
            if(view.getId()==R.id.img1){
            intent.putExtra("img","happy");
            }else if(view.getId()==R.id.img2){
                intent.putExtra("img","normal");
            }if(view.getId()==R.id.img3){
                intent.putExtra("img","sad");
            }
            ///
            setResult(RESULT_OK,intent);
            ////
            Activity2.this.finish();

        }
    }
}
