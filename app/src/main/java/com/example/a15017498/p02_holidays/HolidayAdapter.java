package com.example.a15017498.p02_holidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15017498 on 25/4/2017.
 */

public class HolidayAdapter extends ArrayAdapter<holiday> {

    private ArrayList<holiday> food;
    private Context context;
    private TextView tvFoodName;
    private TextView tvFoodDesc;
    private ImageView ivStar;

    public HolidayAdapter(Context context, int resource, ArrayList<holiday> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        food = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvFoodName = (TextView) rowView.findViewById(R.id.TxtTitle);
        tvFoodDesc = (TextView) rowView.findViewById(R.id.TxtDesc);
        // Get the ImageView object
        ivStar = (ImageView) rowView.findViewById(R.id.ivLogo);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        holiday currentFood = food.get(position);
        // Set the TextView to show the food

        tvFoodName.setText(currentFood.getName());
        tvFoodDesc.setText(currentFood.getDate());


        String picture = currentFood.getImg();
        int id = rowView.getResources().getIdentifier(picture,"drawable",inflater.getContext().getPackageName());
        ivStar.setImageResource(id);


        return rowView;
    }

}
