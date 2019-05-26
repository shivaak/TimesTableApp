package com.shiva.timetable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int min = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seek = findViewById(R.id.seekNumber);
        seek.setMax(19);

        ListView lstTables = findViewById(R.id.lstTable);

        final ArrayList<Integer> tables = new ArrayList<Integer>();

        final ArrayAdapter<Integer> adap = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tables);

        lstTables.setAdapter(adap);

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(!fromUser) return;
                progress=progress+min;
                tables.clear();
                for(int i=1;i<=100;i++){
                    tables.add(i*progress);
                }
                adap.notifyDataSetChanged();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
