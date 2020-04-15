package com.apps.wladimir.emailthreadcleaner_activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.Arrays;
import java.util.LinkedList;


public class MainActivity extends AppCompatActivity {

    private Button sendButton;
    private ListView listView;
    private EmailAdapter eAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = findViewById(R.id.send_button);
        listView = findViewById(R.id.list_view);

        String[] list = {"one", "one", "one", "two", "one", "three", "one", "three", "two"};

        LinkedList<Email> iList = new LinkedList(Arrays.asList(list));

        eAdapter = new EmailAdapter(this, iList);
        listView.setAdapter(eAdapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), EmailThreadCleaner.class);
                startService(intent);

            }
        });
    }

    private BroadcastReceiver bReceiver = new BroadcastReceiver(){

        @Override
        public void onReceive(Context context, Intent intent) {
            LinkedList<String> llEmail = (LinkedList<String>) intent.getExtras().get("data");
            MainActivity.this.eAdapter.updateAdapter(llEmail);
        }
    };
}
