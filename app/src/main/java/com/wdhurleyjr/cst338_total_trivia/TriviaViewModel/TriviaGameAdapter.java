package com.wdhurleyjr.cst338_total_trivia.TriviaViewModel;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.wdhurleyjr.cst338_total_trivia.DB.Game.Question;

public class TriviaGameAdapter extends ListAdapter<Question, TriviaGameViewHolder> {

    public TriviaGameAdapter(@NonNull DiffUtil.ItemCallback<Question> diffCallback){
        super(diffCallback);
    }

    @NonNull
    @Override
    public TriviaGameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return TriviaGameViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull TriviaGameViewHolder holder, int position) {
        Question currentQuestion = getItem(position);
        holder.bind(currentQuestion);
    }

    public static class TriviaGameDiff extends DiffUtil.ItemCallback<Question>{

        @Override
        public boolean areItemsTheSame(@NonNull Question oldItem, @NonNull Question newItem){
            return oldItem.getQuestionId() == newItem.getQuestionId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Question oldItem, @NonNull Question newItem){
            return oldItem.getGameQuestion().equals(newItem.getGameQuestion());
        }
    }
}
