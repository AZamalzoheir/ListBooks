package com.example.amalzoheir.listbooks;
import android.support.v4.content.Loader;
import android.content.AsyncTaskLoader;
import android.content.Context;

import java.nio.charset.MalformedInputException;
import java.util.ArrayList;

/**
 * Created by Amalzoheir on 12/7/2017.
 */

public class ListbookLoader extends AsyncTaskLoader<ArrayList<ListBook>> {
    private static final String LOG_TAG =ListbookLoader.class.getName();
    private String burl;
    public ListbookLoader(Context context,String url){
        super(context);
        this.burl=url;
    }
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        onForceLoad();
    }

    @Override
    public ArrayList<ListBook> loadInBackground() {
        if(burl==null){
            return null;
        }
        ArrayList<ListBook> listBooks=null;
        try{
            listBooks=QueryUtils.fetchListbookData(burl);
        } catch (MalformedInputException e) {
            e.printStackTrace();
        }
        return listBooks;
    }
}
