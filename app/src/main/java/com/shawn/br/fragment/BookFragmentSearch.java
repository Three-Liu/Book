package com.shawn.br.fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.shawn.br.R;
import com.shawn.br.book.Book;
import com.shawn.br.book.BookAdapter;
import com.shawn.br.data.DBOperate;

import java.util.ArrayList;

/**
 * Created by Three on 2016/7/22.
 */
public class BookFragmentSearch extends Fragment {
    private ArrayList<Book> list = new ArrayList<>();
    private Book book = new Book();

    public BookFragmentSearch() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_center_search, container, false);
//        final EditText editText = (EditText) view.findViewById(R.id.search_input);
        final android.support.v7.widget.SearchView searchView = (android.support.v7.widget.SearchView) view.findViewById(R.id.search_query_bar);
        searchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                DBOperate.getContext(getActivity());
                Cursor cursor = DBOperate.searchData(searchView.getQuery().toString());
                if (cursor != null && cursor.moveToFirst())
                    while (!cursor.isAfterLast()) {
                        book.setTitle(cursor.getString(0));
                        book.setImageId(cursor.getBlob(1));
                        list.add(book);
                        cursor.moveToNext();
                    }
                else {
                    Toast.makeText(getActivity(), "No record", Toast.LENGTH_LONG).show();
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        ListView listView = (ListView) view.findViewById(R.id.search_center_result);
        final BookAdapter bookAdapter = new BookAdapter(getActivity(), R.layout.search_element_layout, list);
        getActivity().runOnUiThread(new Runnable(){
            public void run() {
                bookAdapter.notifyDataSetChanged();
            }
        });
        listView.setAdapter(bookAdapter);
        return view;
    }
}
