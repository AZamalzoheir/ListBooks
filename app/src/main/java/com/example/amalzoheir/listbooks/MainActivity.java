package com.example.amalzoheir.listbooks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String URL_BOOK_SEARCh="https://www.googleapis.com/books/v1/volumes?q=math";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listBookListView=(ListView)findViewById(R.id.list);
        ArrayList<ListBook> listbooks=new ArrayList<>();
        try {
            listbooks=QueryUtils.fetchEarthquakeData(URL_BOOK_SEARCh);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ListBookAdapter mAdapter=new ListBookAdapter(this,listbooks);
        listBookListView.setAdapter(mAdapter);
    }
}
