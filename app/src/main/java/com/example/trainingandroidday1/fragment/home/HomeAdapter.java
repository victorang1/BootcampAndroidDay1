package com.example.trainingandroidday1.fragment.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingandroidday1.R;
import com.example.trainingandroidday1.model.Person;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private ArrayList<Person> todoList;
    private onEachItemInterface listener;

    public HomeAdapter(ArrayList<Person> todoList, onEachItemInterface listener) {
        this.todoList = todoList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Person person = todoList.get(position);
        holder.tvName.setText(person.getName());
        holder.tvAge.setText(person.getAge());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCourseItemClick(person);
            }
        });
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName, tvAge;
        private CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAge = itemView.findViewById(R.id.tv_age);
            cardView = itemView.findViewById(R.id.cv_layout);
        }
    }

    public interface onEachItemInterface {
        void onCourseItemClick(Person person);
    }
}
