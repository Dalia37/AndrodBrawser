package com.example.androidbrawser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.agrawalsuneet.dotsloader.loaders.CircularDotsLoader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button search_btn ;
    private EditText search_ed;
    private Button facebook , instagram , google ,yahoo , youtube , snapchat ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialVariable();

        search_btn.setOnClickListener(this);
        facebook.setOnClickListener(this);
        instagram.setOnClickListener(this);
        google.setOnClickListener(this);
        yahoo.setOnClickListener(this);
        snapchat.setOnClickListener(this);



    }


    private void initialVariable() {
        search_btn=findViewById(R.id.search_btn);
        search_ed=findViewById(R.id.search_ed);
        facebook=findViewById(R.id.facebook);
        instagram=findViewById(R.id.instagram);
        youtube=findViewById(R.id.youtube);
        yahoo=findViewById(R.id.yahoo);
        google=findViewById(R.id.google);
        snapchat=findViewById(R.id.snapchat);
    }

    @Override
    public void onClick(View view) {
        if (view == search_btn){

            openWebSite();

        }
        if (view == facebook){
            Intent openface = new Intent(getApplicationContext(),URLSearch.class);
            openface.putExtra("url","http://www.facebook.com");
            startActivity(openface);
        }
        if (view == google){
            Intent opengoogle = new Intent(getApplicationContext(),URLSearch.class);
            opengoogle.putExtra("url","https://www.google.com/");
            startActivity(opengoogle);
        }
        if (view == instagram){
            Intent openinstagram = new Intent(getApplicationContext(),URLSearch.class);
            openinstagram.putExtra("url","https://www.instagram.com/");

            startActivity(openinstagram);
        }
        if (view == snapchat){
            Intent opensnap = new Intent(getApplicationContext(),URLSearch.class);
            opensnap.putExtra("url","http://www.snapchat.com");
            startActivity(opensnap);
        }
        if (view == yahoo){
            Intent openyahoo = new Intent(getApplicationContext(),URLSearch.class);
            openyahoo.putExtra("url","http://www.yahoo.com/");
            startActivity(openyahoo);
        }
        if (view == youtube){
            Intent openyoutube = new Intent(getApplicationContext(),URLSearch.class);
            openyoutube.putExtra("url","http://www.youtube.com/");
            startActivity(openyoutube);
        }

    }

    private void openWebSite() {
        String url_address = search_ed.getText().toString();

        if (TextUtils.isEmpty(url_address)){
            search_ed.setError("Enter your url");
        }
        else {
            String url_without_http = url_address.replaceAll("https://www.","");
            String htpps = "https://";
            String www = "www.";
            Intent intent = new Intent(MainActivity.this,URLSearch.class);
            intent.putExtra("url",htpps+www+url_without_http);
            startActivity(intent);
            search_ed.setText("");
            search_ed.requestFocus();


        }
    }

}
