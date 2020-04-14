package com.apps.wladimir.searchword;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WordAdapter extends ArrayAdapter<Word> implements Filterable {

    private Context mContext;
    private ArrayList<Word> wordList;
    private ArrayList<Word> wordList_copy;

    public WordAdapter(@NonNull Context context, ArrayList<Word> list){
        super(context, 0, list);
        mContext = context;
        wordList = list;
        wordList_copy = list;

    }

    public void resetList(){
        wordList = wordList_copy;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View wordList = convertView;
        if(wordList == null){
            wordList = LayoutInflater.from(mContext).inflate(R.layout.word_list, parent, false);
        }

        Word currentWord = this.wordList.get(position);

        TextView word = (TextView) wordList.findViewById(R.id.textView_word);
        word.setText(currentWord.getWord());

        return wordList;
    }

    @Override
    public int getCount() {
        return wordList.size();
    }

    public Filter getFilter() {
        Filter filter = new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults results = new FilterResults();
                ArrayList<Word> FilteredArrayWords = new ArrayList<>();


                String fWord = charSequence.toString();
                for (Word word : wordList){
                    String lWord = word.getWord();
                    if (Typo.CheckTypo(fWord, lWord)){
                        FilteredArrayWords.add(word);
                    } else {
                        if (Jumbled.checkPartialJumble(fWord, lWord)){
                            FilteredArrayWords.add(word);
                        }
                    }
                }
                results.count = FilteredArrayWords.size();
                results.values = FilteredArrayWords;

                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                if (filterResults.count > 0) {
                    wordList = (ArrayList<Word>) filterResults.values;
                    notifyDataSetChanged();
                } else {
                    wordList.clear();
                    notifyDataSetChanged();
                }
            }
        };

        wordList = wordList_copy;
        return filter;
    }


}
