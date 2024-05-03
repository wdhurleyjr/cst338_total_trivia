package com.wdhurleyjr.cst338_total_trivia.Activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wdhurleyjr.cst338_total_trivia.DB.Game.Question;
import com.wdhurleyjr.cst338_total_trivia.R;

import java.util.ArrayList;
import java.util.List;

public class TriviaGame_RecyclerViewAdapter extends RecyclerView.Adapter<TriviaGame_RecyclerViewAdapter.MyViewHolder> {

    Context context;
    List<Question> questions;

    public TriviaGame_RecyclerViewAdapter(Context context, List <Question> questions){
        this.questions = questions;
        this.context = context;
    }

    @NonNull
    @Override
    public TriviaGame_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflates the layout which gives a look to our rows
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new TriviaGame_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TriviaGame_RecyclerViewAdapter.MyViewHolder holder, int position) {
        //assigning to values to the recycler_view_rom.xml when it comes back onto screen when scrolling
        Question question = questions.get(position);
        holder.tvQuestion.setText(question.getGameQuestion());
        holder.tvAnswer1.setText(question.getGameAnswer1());
        holder.tvAnswer2.setText(question.getGameAnswer2());
        holder.tvAnswer3.setText(question.getGameAnswer3());
        holder.tvAnswer4.setText(question.getGameAnswer4());
    }

    @Override
    public int getItemCount() {
        //how many questions
        return 20;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvQuestion, tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvQuestion = itemView.findViewById(R.id.question_text_view);
            tvAnswer1 = itemView.findViewById(R.id.radioButton1);
            tvAnswer2 = itemView.findViewById(R.id.radioButton2);
            tvAnswer3 = itemView.findViewById(R.id.radioButton3);
            tvAnswer4 = itemView.findViewById(R.id.radioButton4);
        }
    }
}
