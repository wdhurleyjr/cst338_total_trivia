package com.wdhurleyjr.cst338_total_trivia.TriviaViewModel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.wdhurleyjr.cst338_total_trivia.DB.Game.Question;
import com.wdhurleyjr.cst338_total_trivia.R;

public class TriviaGameViewHolder extends RecyclerView.ViewHolder {

    private final TextView questionTextView;
    private final RadioButton radioButton1;
    private final RadioButton radioButton2;
    private final RadioButton radioButton3;
    private final RadioButton radioButton4;
    private TriviaGameViewHolder(View triviaGameView){
        super(triviaGameView);
        questionTextView = triviaGameView.findViewById(R.id.question_text_view);
        radioButton1 = triviaGameView.findViewById(R.id.radioButton1);
        radioButton2 = triviaGameView.findViewById(R.id.radioButton2);
        radioButton3 = triviaGameView.findViewById(R.id.radioButton3);
        radioButton4 = triviaGameView.findViewById(R.id.radioButton4);
    }

    public void bind(Question question){
        questionTextView.setText(question.getGameQuestion());
        radioButton1.setText(question.getGameAnswer1());
        radioButton2.setText(question.getGameAnswer2());
        radioButton3.setText(question.getGameAnswer3());
        radioButton4.setText(question.getGameAnswer4());

    }

    static TriviaGameViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_row, parent, false);
        return  new TriviaGameViewHolder(view);
    }
}
