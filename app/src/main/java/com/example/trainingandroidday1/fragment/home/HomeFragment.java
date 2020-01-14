package com.example.trainingandroidday1.fragment.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingandroidday1.InsertActivity;
import com.example.trainingandroidday1.R;
import com.example.trainingandroidday1.model.Person;
import com.example.trainingandroidday1.repository.TodoRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements HomeAdapter.onEachItemInterface {

    public HomeAdapter mAdapter;
    private RecyclerView recyclerView;
    private ArrayList<Person> todoList = new ArrayList<>();
    private FloatingActionButton fab;

    @Override
    public void onResume() {
        super.onResume();
        if(mAdapter != null) {
            todoList = TodoRepository.getAllTodo();
            mAdapter.notifyDataSetChanged();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        fab = view.findViewById(R.id.fab);

        TodoRepository.initList();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), InsertActivity.class);
                startActivity(intent);
            }
        });

        todoList = TodoRepository.getAllTodo();

        mAdapter = new HomeAdapter(todoList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onCourseItemClick(Person todo) {
        Toast.makeText(getActivity(), todo.getName(), Toast.LENGTH_SHORT).show();
    }
}
