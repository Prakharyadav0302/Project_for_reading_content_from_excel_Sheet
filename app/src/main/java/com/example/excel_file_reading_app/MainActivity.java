package com.example.excel_file_reading_app;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.os.WorkSource;
import android.util.Log;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        List<WeatherSamples> weatherSamples = new ArrayList<>();
        getResources().openRawResource(R.raw.songslist);
        InputStream is = getResources().openRawResource(R.raw.songslist);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line = "";
            try {
                reader.readLine();
                while ((line = reader.readLine()) != null){
                    String[] tokens = line.split(",");
                    WeatherSamples sample = new WeatherSamples();
                        sample.setMonth(tokens[0]);
                        sample.setRainfall(Integer.parseInt(tokens[1]));
                        sample.setSun(Integer.parseInt(tokens[2]));
                        weatherSamples.add(sample);

                }
                recyclerView = findViewById(R.id.list_of_data);
                adapter = new Adapter(this,weatherSamples);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(adapter);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }



        }
    }