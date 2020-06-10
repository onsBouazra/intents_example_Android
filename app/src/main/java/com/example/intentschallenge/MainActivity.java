package com.example.intentschallenge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnCreate;
    LinearLayout layout;
    ImageView imgFace,imgPhone,imgNavigation,imgMaps;
    public static final int ACTIVITY2=2;
    String name="",phone="",location="",web="",face="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreate=findViewById(R.id.btnCreate);
        layout=findViewById(R.id.layout);
        imgFace=findViewById(R.id.imgFace);
        imgPhone=findViewById(R.id.imgPhone);
        imgNavigation=findViewById(R.id.imgNavigation);
        imgMaps=findViewById(R.id.imgMaps);

        //
        layout.setVisibility(View.GONE);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,Activity2.class);
                //
                startActivityForResult(intent,ACTIVITY2);
            }
        });

        imgPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + phone));
                startActivity(intent);
            }
        });

        imgNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://" + web));
                startActivity(intent);
            }
        });


        imgMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q=" + location));
                startActivity(intent);
            }
        });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ACTIVITY2){
            if(resultCode==RESULT_OK){
                //
                layout.setVisibility(View.VISIBLE);
                name=data.getStringExtra("name");
                phone=data.getStringExtra("phone");
                location=data.getStringExtra("location");
                web=data.getStringExtra("web");
                face=data.getStringExtra("img");
                //
                if(face.equals("happy")){
                    imgFace.setImageResource(R.drawable.happyface);
                }else if(face.equals("normal")){
                    imgFace.setImageResource(R.drawable.neutre);
                }else if(face.equals("sad")){
                    imgFace.setImageResource(R.drawable.ic_sentiment_dissatisfied_black_24dp);
                }

            }
            else{
                Toast.makeText(MainActivity.this,"YOU HAVE BEEN CANCELED THE OPERATION", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
