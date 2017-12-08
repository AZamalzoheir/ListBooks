package com.example.amalzoheir.listbooks;

import android.app.LoaderManager;
;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button search=(Button)findViewById(R.id.search);
        final EditText searchText=(EditText) findViewById(R.id.search_text);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String searchQuery=searchText.getText().toString();
                Intent listBookPage=new Intent(MainActivity.this,ListBookActivity.class);
                listBookPage.putExtra("query",searchQuery);
                startActivity(listBookPage);
            }
        });
    }

}