package com.example.amalzoheir.listbooks;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.app.LoaderManager.LoaderCallbacks;
import android.widget.TextView;

import java.util.ArrayList;

public class ListBookActivity extends AppCompatActivity implements LoaderCallbacks<ArrayList<ListBook>>{

    String query="";
    public String URL_BOOK_SEARCh;
    ListBookAdapter mAdapter;
    TextView emptyListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_book);
        Intent intent=getIntent();
        query=intent.getStringExtra("query");
        URL_BOOK_SEARCh = "https://www.googleapis.com/books/v1/volumes?q="+query;
        ListView listBookListView = (ListView) findViewById(R.id.list);
        emptyListView=(TextView)findViewById(R.id.empty);
        ArrayList<ListBook> listbooks = new ArrayList<>();
        listBookListView.setEmptyView(emptyListView);
        mAdapter = new ListBookAdapter(this, listbooks);
        listBookListView.setAdapter(mAdapter);
        ConnectivityManager cm=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi=cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if(wifi.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(1, null, this);
        }
        else {
            View progressBar=findViewById(R.id.loading);
            progressBar.setVisibility(View.GONE);
            emptyListView.setText(R.string.no_internet);
        }
    }

    @Override
    public Loader<ArrayList<ListBook>> onCreateLoader(int id, Bundle bundle) {
        return new ListbookLoader(this,URL_BOOK_SEARCh);
    }

    @Override
    public void onLoadFinished(android.content.Loader<ArrayList<ListBook>> loader, ArrayList<ListBook> listBooks) {
        View progressBar = findViewById(R.id.loading);
        progressBar.setVisibility(View.GONE);
        emptyListView.setText(R.string.no_book);
        mAdapter.clear();
        if(listBooks!=null&&!listBooks.isEmpty()){
            mAdapter.addAll(listBooks);
        }
    }

    @Override
    public void onLoaderReset(android.content.Loader<ArrayList<ListBook>> loader) {
        mAdapter.clear();
    }
}