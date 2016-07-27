package com.shawn.br.fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.shawn.br.R;
import com.shawn.br.data.book.Book;
import com.shawn.br.data.book.BookAdapter;
import com.shawn.br.data.database.DataBase;
import com.shawn.br.data.database.table.BookTable;

import java.util.ArrayList;

/**
 * Created by Three on 2016/7/22.
 */
public class BookFragmentSearch extends Fragment {
    private ArrayList<Book> list;
    private Book book = new Book();
    private String temp;
    private ListView listView;
    private BookAdapter bookAdapter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            list = bundle.getParcelableArrayList("query");
            bookAdapter = new BookAdapter(getActivity(), R.layout.search_element_layout, list);
            bookAdapter.notifyDataSetChanged();
            listView.setAdapter(bookAdapter);
            super.handleMessage(msg);
        }
    };
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Message message = handler.obtainMessage();
            list = new ArrayList<>();
            SQLiteDatabase sqLiteDatabase = DataBase.getSqliteDatabase(getActivity());
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + BookTable.TABLENAME + " WHERE " + BookTable.TITLE
                    + " = ?", new String[]{temp});
            if (cursor != null && cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    Book book = new Book();
                    book.setTitle(cursor.getString(0));
                    book.setImageId(cursor.getBlob(1));
                    cursor.moveToNext();
                    list.add(book);
                }
            } else {
                Toast.makeText(getActivity(), "No Record", Toast.LENGTH_SHORT).show();
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("query", list);
            message.setData(bundle);
            handler.sendMessage(message);
        }
    };

    public BookFragmentSearch() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_center_search, container, false);
        final android.support.v7.widget.SearchView searchView = (android.support.v7.widget.SearchView) view.findViewById(R.id.search_query_bar);
        listView = (ListView) view.findViewById(R.id.search_center_result);
        searchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                temp = searchView.getQuery().toString();
                handler.post(runnable);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Book book = bookAdapter.getItem(i);
                Bundle bundle = new Bundle();
                bundle.putParcelable("book", book);
                BookFragment bookFragment = new BookFragment();
                bookFragment.setArguments(bundle);
                getParentFragment().getActivity().getSupportFragmentManager().beginTransaction()
                        .hide(getParentFragment())
                        .add(R.id.container, bookFragment, BookFragment.class.getName())
                        .addToBackStack(BookFragment.class.getName())
                        .commit();

            }
        });
        return view;
    }
}
