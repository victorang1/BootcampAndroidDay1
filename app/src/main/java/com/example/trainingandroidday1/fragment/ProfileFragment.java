package com.example.trainingandroidday1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.trainingandroidday1.R;

public class ProfileFragment extends Fragment {

    private TextView tvName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        tvName = view.findViewById(R.id.tv_name);
        String name = getActivity().getIntent().getStringExtra("name");
        tvName.setText(getResources().getString(R.string.profile_name, name));
        return view;
    }
}
