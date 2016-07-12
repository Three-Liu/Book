package com.shawn.br.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shawn.br.R;
import com.shawn.br.book.Book;

/**
 * This is a single book fragment
 * Created by Three on 2016/7/11.
 */
public class BookInfoFragment extends Fragment {
    public BookInfoFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_detail_layout,container,false);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolBar);

        //Send book object your select
        Bundle b = getArguments();
        Book book = b.getParcelable("book");
        toolbar.setTitle(book.getName());
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction()
                        .attach(getFragmentManager().findFragmentByTag(QuaryFragment.class.getName()))
                        .detach(getFragmentManager().findFragmentByTag(BookInfoFragment.class.getName()))
                        .commit();
            }
        });
        //Access DB to get people who own this book
        //Adapter for People listview

        //assign book image and title
        ImageView imageView = (ImageView) view.findViewById(R.id.book_image);
//        TextView textView = (TextView) view.findViewById(R.id.book_title);
        imageView.setImageResource(book.getImageId());
//        textView.setText(book.getName());
        return view;
    }

}
