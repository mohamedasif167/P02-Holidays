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

        if(category_name.equalsIgnoreCase("Secular")){
            holidaysSecular.add(new holiday("New Year","1 Jan 2017","new_year","Happy New Year!, This celebration is to celebrated the new Year!"));
            holidaysSecular.add(new holiday("Chinese New Year","28-30 Jan 2017","cny","Chinese Lunar New Year 2017 starts on a Saturday. As most businesses and organizations end work early on the eve, employees enjoy a three-and-a-half days long weekend break during this festive season. "));
            holidaysSecular.add(new holiday("National Day","9 August 2017","national_day","Singapore celebrates its 52nd year of independence in 2017."));

        }else{
            holidaysSecular.add(new holiday("Vesak Day","10 May 2017","vesak_day","Vesak Day is observed by Buddhists in Singapore, Thailand, Sri Lanka, Cambodia and many other southeast Asian countries in memory of Gautama Buddha's birth, attainment of Nirvana and passing."));
            holidaysSecular.add(new holiday("Good Friday","14 April 2017","good_friday","Good Friday is the day Christians commemorate the crucifixion of Jesus Christ. It is the Friday before Easter Day (Sunday) which is itself not gazetted as a holiday in Singapore."));
            holidaysSecular.add(new holiday("Hari Raya Puasa","25 June 2017","hari_raya_puasa","Hari Raya Puasa is the local Malay name for the Muslim religious holiday/celebration of Eid al-Fitr (or Aidil-fitri) which marks the end of the Islamic holy month of fasting,"));
            holidaysSecular.add(new holiday("Hari Raya Haji","1 Septemember 2017","hari_raya_haji","Hari Raya Haji is the local Malay name for the Muslim religious holiday/celebration of Eid al-Adha. It is held to honour the willingness of the prophet Ibrahim(Abraham) to sacrifice his young son Ismail(Ishmael) in submission to Allah(God)."));
            holidaysSecular.add(new holiday("Deepavali","18 October 2017","deepavali","Deepavali, also known as Diwali and, popularly, the Festival of Lights, is an Indian holiday/festival celebrated by Indians, especially by adherents of Hinduism, Sikhism and Jainism."));
            holidaysSecular.add(new holiday("Christmas Day","25 December 2017","christmas","Singapore, with a substantial percentage of the population being of the Christian and Catholic faiths, celebrates this important day as a gazetted national holiday. "));
        }

        arrayAdapter = new HolidayAdapter(this, R.layout.row, holidaysSecular);

        lvHoliday.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(holiday_act.this,holidaysSecular.get(position).getDesc(), Toast.LENGTH_SHORT).show();

            }
        });

        lvHoliday.setAdapter(arrayAdapter);

    }
}
