package com.shawn.br.data.person;

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
 * Created by Three on 2016/7/21.
 */
public class PersonAdapter extends ArrayAdapter<Person> {
    private int mResource;
    public PersonAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        Person person = getItem(position);
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(getContext()).inflate(mResource,null);
            viewHolder.image_gender = (ImageView) view.findViewById(R.id.person_gender);
            viewHolder.image_person = (ImageView) view.findViewById(R.id.person_image);
            viewHolder.tw = (TextView) view.findViewById(R.id.person_name);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.image_gender.setImageResource(person.getGender().equals("male")?R.drawable.male:R.drawable.female);
        viewHolder.tw.setText(person.getName());
        viewHolder.image_person.setImageBitmap(BitmapByte.arrayTopic(person.getImageId()));
        return view;
    }
    class ViewHolder {
        ImageView image_person;
        TextView tw;
        ImageView image_gender;
    }
}
