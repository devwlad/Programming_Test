package com.apps.wladimir.emailthreadcleaner_activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.LinkedList;

public class EmailAdapter extends ArrayAdapter<Email> {

    private Context mContext;
    private LinkedList<Email> emailList;
    private LinkedList<Email> emailList_copy;

    public EmailAdapter(@NonNull Context context, LinkedList list){
        super(context, 0, list);
        mContext = context;
        emailList = list;
        emailList_copy = list;

    }

    public void resetList(){
        emailList = emailList_copy;
        notifyDataSetChanged();
    }

    public void updateAdapter(LinkedList list){
            emailList = list;
            notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View emailListView = convertView;
        if(emailListView == null){
            emailListView = LayoutInflater.from(mContext).inflate(R.layout.email_list, parent, false);
        }

        Email currentEmail = emailList.get(position);

        TextView email = (TextView) emailListView.findViewById(R.id.textView_email);
        email.setText(currentEmail.getEmail());

        return emailListView;
    }

    @Override
    public int getCount() {
        return emailList.size();
    }


}
