package com.shawn.br.fragment;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.shawn.br.R;
import com.shawn.br.book.Book;
import com.shawn.br.book.BookAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * consummate QuaryFragment
 *
 * Created by Three on 2016/7/11.
 */
public class QuaryFragment extends Fragment{
    private SearchView searchView;
    public QuaryFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quary,container,false);
        ListView list = (ListView) view.findViewById(R.id.booklist);
        ArrayList<Book> books = new ArrayList<>();

        //search book
        searchView = (SearchView) view.findViewById(R.id.search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                // get query from here and execDB
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }

        });

        //list arrayadapter
        BookAdapter adapter = new BookAdapter(getActivity(), R.layout.singlebook_layout, getData(books));
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BookInfoFragment fragment = new BookInfoFragment();
                Bundle b = new Bundle();
                b.putParcelable("book",(Book)parent.getItemAtPosition(position));
                fragment.setArguments(b);
                getFragmentManager().beginTransaction()
                        .detach(getFragmentManager().findFragmentByTag(QuaryFragment.class.getName()))
                        .add(R.id.center_container,fragment,BookInfoFragment.class.getName())
                        .addToBackStack(BookInfoFragment.class.getName())
                        .commit();
            }
        });
        return view;
    }
    public List<Book> getData(ArrayList<Book> data) {
        // after attach DataBase All this get from DB
        Resources resources = getResources();
        String[] name = resources.getStringArray(R.array.bookTitle);
        TypedArray typedArray = resources.obtainTypedArray(R.array.bookImage);
        for (int i = 0; i < name.length; i++) {
            Book book = new Book();
            book.setImageId(typedArray.getResourceId(i,0));
            book.setName(name[i]);
            data.add(book);
        }
        typedArray.recycle();
        return data;
    }
}
