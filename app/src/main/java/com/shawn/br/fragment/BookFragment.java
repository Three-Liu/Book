package com.shawn.br.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.shawn.br.R;
import com.shawn.br.book.Book;
import com.shawn.br.data.PictureToArray;

/**
 * Created by Three on 2016/7/20.
 */
public class BookFragment extends Fragment {
    private Book book;
    public BookFragment() {
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        book = bundle.getParcelable("book");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book,container,false);
//        ListView listView = (ListView) view.findViewById(R.id.booklist);
        ImageView imageView = (ImageView) view.findViewById(R.id.book_image);
        TextView textView = (TextView) view.findViewById(R.id.book_title);
        imageView.setImageBitmap(PictureToArray.arrayTopic(book.getImageId()));
        textView.setText(book.getTitle());
        return view;
    }
}
