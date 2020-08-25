package com.example.androidbrawser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class URLSearch extends AppCompatActivity {

    private Button search_btn ;
    private EditText uriInput ;
    private WebView search_webview ;
    private String url ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urlsearch);

        initialVariable();

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000080")));
        getSupportActionBar().setTitle(getResources().getString(R.string.URLSearch));

        search_webview.setWebChromeClient(new WebChromeClient());
        search_webview.loadUrl(url);

        searchbtn_listener();



    }

    private void searchbtn_listener() {
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchWebAdress();

            }
        });
    }

    private void searchWebAdress() {

        String url_address = uriInput.getText().toString();

        if (TextUtils.isEmpty(url_address)){
            uriInput.setError("Enter your url");
        }
        else {
            String url_without_http = url_address.replaceAll("https://www.","");
            String htpps = "https://";
            String www = "www.";
            Intent intent = new Intent(URLSearch.this,URLSearch.class);
            intent.putExtra("url",htpps+www+url_without_http);
            startActivity(intent);
            uriInput.setText("");
            uriInput.requestFocus();

        }

    }

    private void initialVariable() {
        search_btn=findViewById(R.id.search_btn);
        uriInput=findViewById(R.id.search_ed);
        search_webview=findViewById(R.id.search_webview);

        url=getIntent().getExtras().get("url").toString();
        uriInput.setText(url);
    }


    @Override
    public void onBackPressed() {
        if (search_webview.canGoBack()){
            search_webview.goBack();
        }
        else
        super.onBackPressed();
    }
}
