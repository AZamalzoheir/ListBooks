package com.example.amalzoheir.listbooks;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Amalzoheir on 12/5/2017.
 */

public class ListBookAdapter extends ArrayAdapter<ListBook> {
    public ListBookAdapter(Activity context,ArrayList<ListBook> listbooks) {
        super(context, 0, listbooks);
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View listItemView=convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.booklist_list_item, parent, false);
        }
        ListBook currentListBook=getItem(position);
        TextView bookNameView =(TextView)listItemView.findViewById(R.id.book_name);
        bookNameView.setText(currentListBook.getBookName());
        TextView bookAuthorView =(TextView)listItemView.findViewById(R.id.book_author);
        bookAuthorView.setText(currentListBook.getBookAuthor());
        return listItemView;
    }
}
