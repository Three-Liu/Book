package com.shawn.br.fragment.confirm;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.shawn.br.Person;
import com.shawn.br.R;

/**
 * Created by Three on 2016/7/11.
 */
public class MajorGradeFragment extends Fragment implements AdapterView.OnItemSelectedListener{
    private static String[] grade = {"1", "2", "3", "4"};
    private Person person;
    public MajorGradeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Resources res = getResources();
        String[] major = res.getStringArray(R.array.major);
        View view = inflater.inflate(R.layout.fragment_major_grade, container, false);
        Spinner majorSp = (Spinner) view.findViewById(R.id.major);
        Spinner gradeSp = (Spinner) view.findViewById(R.id.grade);
        ArrayAdapter<String> majorAdp = new ArrayAdapter<>(getActivity(),R.layout.support_simple_spinner_dropdown_item,major);
        ArrayAdapter<String> gradeAdp = new ArrayAdapter<>(getActivity(),R.layout.support_simple_spinner_dropdown_item,grade);
        majorSp.setAdapter(majorAdp);
        gradeSp.setAdapter(gradeAdp);
        majorSp.setTag("major");
        gradeSp.setTag("grade");
        majorSp.setOnItemSelectedListener(this);
        gradeSp.setOnItemSelectedListener(this);
        person = new Person();
        view.findViewById(R.id.confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String tag = (String)parent.getTag();
        switch (tag){
            case "major":
                person.setMajor((String)parent.getItemAtPosition(position));
                break;
            case "grade":
                person.setGrade((String)parent.getItemAtPosition(position));
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
