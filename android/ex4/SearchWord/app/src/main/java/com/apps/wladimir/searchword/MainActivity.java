package com.apps.wladimir.searchword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button searchButton;
    private Button clearButton;
    private ListView listView;
    private WordAdapter wAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText filter = (EditText) findViewById(R.id.search_filter);
        searchButton = findViewById(R.id.search_button);
        clearButton = findViewById(R.id.clear_button);

        listView = findViewById(R.id.list_view);
        Log.d(TAG, "onCreate: Started Successfully");

        final ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("Zero"));
        words.add(new Word("One"));
        words.add(new Word("Two"));
        words.add(new Word("Three"));
        words.add(new Word("Four"));
        words.add(new Word("Five"));
        words.add(new Word("Six"));
        words.add(new Word("Seven"));
        words.add(new Word("Eight"));
        words.add(new Word("Nine"));
        words.add(new Word("Ten"));
        words.add(new Word("Eleven"));
        words.add(new Word("Twelve"));
        words.add(new Word("Thirteen"));
        words.add(new Word("Fourteen"));
        words.add(new Word("Fifteen"));
        words.add(new Word("Sixteen"));
        words.add(new Word("Seventeen"));
        words.add(new Word("Eighteen"));
        words.add(new Word("Nineteen"));
        words.add(new Word("Twenty"));

        wAdapter = new WordAdapter(this, words);
        listView.setAdapter(wAdapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                String wFilter = filter.getText().toString();
                if (wFilter.length() > 0) {
                    MainActivity.this.wAdapter.getFilter().filter(wFilter);
                }
            }
        });
        clearButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                filter.setText("");
                MainActivity.this.wAdapter.resetList();
            }
        });
    }
}
