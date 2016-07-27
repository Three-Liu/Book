package com.shawn.br.fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.shawn.br.R;
import com.shawn.br.data.book.Book;
import com.shawn.br.data.BitmapByte;
import com.shawn.br.data.database.DataBase;
import com.shawn.br.data.database.table.BookTable;
import com.shawn.br.data.database.table.PersonTable;
import com.shawn.br.data.person.Person;
import com.shawn.br.data.person.PersonAdapter;

import java.util.ArrayList;

/**
 * Created by Three on 2016/7/20.
 */
public class BookFragment extends Fragment {
    private Book book;
    private ArrayList<Person> list;
    private ListView listView;
    private PersonAdapter personAdapter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            list = bundle.getParcelableArrayList("query");
            personAdapter = new PersonAdapter(getActivity(), R.layout.person_list_layout, list);
            personAdapter.notifyDataSetChanged();
            listView.setAdapter(personAdapter);
            super.handleMessage(msg);
        }
    };
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Message message = handler.obtainMessage();
            list = new ArrayList<>();
            SQLiteDatabase sqLiteDatabase = DataBase.getSqliteDatabase(getActivity());
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + PersonTable.TABLENAME + " WHERE "
                    + PersonTable.STORAGE+ " like ?", new String[]{"%/0"+book.getTitle()+"/%"});
            if (cursor != null && cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    Person person = new Person();
                    person.setName(cursor.getString(0));
                    person.setGender(cursor.getString(1));
                    person.setStorageOfBook(cursor.getString(2));
                    person.setImageId(cursor.getBlob(3));
                    cursor.moveToNext();
                    list.add(person);
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
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolBar);
        toolbar.inflateMenu(R.menu.toolbar_menu);
        toolbar.setNavigationIcon(R.drawable.back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction()
                        .show(getFragmentManager().findFragmentByTag(CenterFragment.class.getName()))
                        .commit();
                getFragmentManager().popBackStack();
            }
        });
        ImageView imageView = (ImageView) view.findViewById(R.id.book_image);
        TextView textView = (TextView) view.findViewById(R.id.book_title);
        imageView.setImageBitmap(BitmapByte.arrayTopic(book.getImageId()));
        textView.setText(book.getTitle());
        listView = (ListView) view.findViewById(R.id.person_list);
        handler.post(runnable);
        return view;
    }
}
