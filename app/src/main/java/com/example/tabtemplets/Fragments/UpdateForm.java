package com.example.tabtemplets.Fragments;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabtemplets.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class UpdateForm extends BottomSheetDialogFragment {


    public UpdateForm() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_form, container, false);


        return view;
    }

}