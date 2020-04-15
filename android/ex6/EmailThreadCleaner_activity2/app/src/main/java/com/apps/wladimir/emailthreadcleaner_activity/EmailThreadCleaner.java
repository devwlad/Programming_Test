package com.apps.wladimir.emailthreadcleaner_activity;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;

public class EmailThreadCleaner extends IntentService {

    public EmailThreadCleaner(){
        super("EmailThreadCleaner");
    }

    public static void RemoveDuplicate(LinkedList<String> iList){
        HashSet tempSet = new HashSet();
        ListIterator<String> listIterator = iList.listIterator();
        while (listIterator.hasNext()){
            Object obj = listIterator.next();
            if (tempSet.contains(obj)){
                listIterator.remove();
            } else {
                tempSet.add(obj);
            }
        }
    }

    private void sendResultBroadcast(LinkedList data){
        Intent intent = new Intent ();
        intent.putExtra("data", data);
        sendBroadcast(intent);
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        LinkedList<String> data = (LinkedList<String>) intent.getExtras().get("data");
        RemoveDuplicate(data);
        sendResultBroadcast(data);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}