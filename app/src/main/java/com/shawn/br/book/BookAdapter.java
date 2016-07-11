package com.shawn.br.book;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shawn.br.R;

import java.util.List;

/**
 * This is adapter for Book
 * Adapter for searchResult
 */
public class BookAdapter extends ArrayAdapter<Book> {
    private int idResource;

    public BookAdapter(Context context, int resource, List<Book> objects) {
        super(context, resource, objects);
        this.idResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        Book book = getItem(position);
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(idResource, null);
        } else {
            view = convertView;
        }
        ImageView image = (ImageView) view.findViewById(R.id.bookImage);
        image.setImageResource(book.getImageId());
        TextView tw = (TextView) view.findViewById(R.id.bookTitle);
        tw.setText(book.getName());
        return view;
    }
    //will add HolderClass
}
