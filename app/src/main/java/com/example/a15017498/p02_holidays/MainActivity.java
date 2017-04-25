package com.example.a15017498.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvCategory;
    ArrayList<String> category = new ArrayList<>();
    ArrayAdapter<String> aaToDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCategory = (ListView) findViewById(R.id.listViewCategory);

        category.add("Secular");
        category.add("Ethnic & Religion");

        aaToDo=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,category);
        lvCategory.setAdapter(aaToDo);

        lvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,holiday_act.class);
                intent.putExtra("category_name",category.get(position));
                startActivity(intent);

            }
        });

    }
}
