package com.example.a15017498.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class holiday_act extends AppCompatActivity {

    ListView lvHoliday;
    TextView TxtHoliday;
    ArrayList<holiday> holidaysSecular = new ArrayList<>();
    ArrayList<holiday> holidaysReligion = new ArrayList<>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday_act);

        lvHoliday = (ListView) findViewById(R.id.listViewHoliday);
        TxtHoliday = (TextView) findViewById(R.id.textViewHoiday);

        Intent intentReceived4=getIntent();
        final String category_name = intentReceived4.getStringExtra("category_name");

        TxtHoliday.setText(category_name);

        holidaysSecular.add(new holiday("New Year","1 Jan 2017","new_year","secular"));
        holidaysSecular.add(new holiday("Chinese New Year","28-30 Jan 2017","cny","secular"));
        holidaysSecular.add(new holiday("National Day","9 August 2017","national_day","secular"));

        holidaysReligion.add(new holiday("Vesak Day","10 May 2017","vesak_day","religion"));
        holidaysReligion.add(new holiday("Good Friday","14 April 2017","good_friday","religion"));
        holidaysReligion.add(new holiday("Hari Raya ","25 June 2017","hari_raya_puasa","religion"));
        holidaysReligion.add(new holiday("Hari Raya Haji","1 Septemember 2017","hari_raya_haji","religion"));
        holidaysReligion.add(new holiday("Christmas Day","25 December 2017","christmas","religion"));

        if(category_name.equalsIgnoreCase("Ethnic & Religion")){
            arrayAdapter = new HolidayAdapter(this, R.layout.row, holidaysReligion);

            lvHoliday.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(holiday_act.this,holidaysReligion.get(position).getName() +" Date: "+holidaysReligion.get(position).getDate(), Toast.LENGTH_SHORT).show();

                }
            });

        }else{
            arrayAdapter = new HolidayAdapter(this, R.layout.row, holidaysSecular);

            lvHoliday.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(holiday_act.this,holidaysSecular.get(position).getName() +" Date: "+holidaysSecular.get(position).getDate(), Toast.LENGTH_SHORT).show();

                }
            });

        }

        lvHoliday.setAdapter(arrayAdapter);

    }
}
