package com.shawn.br.data.book;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shawn.br.R;
import com.shawn.br.data.BitmapByte;

import java.util.List;

/**
 * This is adapter for Book
 * Adapter for searchResult
 */
public class BookAdapter extends ArrayAdapter<Book> {
    private int idResource;
    private List<Book> objects;
    public BookAdapter(Context context, int resource, List<Book> objects) {
        super(context, resource, objects);
        this.idResource = resource;
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return this.objects.size();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        Book book = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(getContext()).inflate(idResource, null);
            viewHolder.image = (ImageView) view.findViewById(R.id.bookImage);
            viewHolder.tw = (TextView) view.findViewById(R.id.bookTitle);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.image.setImageBitmap(BitmapByte.arrayTopic(book.getImageId()));
        viewHolder.tw.setText(book.getTitle());
        return view;
    }

    // ViewHolder to accelerate ListView
    class ViewHolder {
        ImageView image;
        TextView tw;
    }
}
