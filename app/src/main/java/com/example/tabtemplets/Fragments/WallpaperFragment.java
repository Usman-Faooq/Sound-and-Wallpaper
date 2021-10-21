package com.example.tabtemplets.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabtemplets.Adapters.WallpaperAdapter;
import com.example.tabtemplets.DataVeriables.FirebaseDataVeriables;
import com.example.tabtemplets.FavouriteWallpaper;
import com.example.tabtemplets.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class WallpaperFragment extends Fragment {

    RecyclerView recyclerView;
    WallpaperAdapter adapter;
    FloatingActionButton btn;

    public WallpaperFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wallpaper_frag, container, false);
        recyclerView = view.findViewById(R.id.recview);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        FirebaseRecyclerOptions<FirebaseDataVeriables> options =
                new FirebaseRecyclerOptions.Builder<FirebaseDataVeriables>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("wallpapers"), FirebaseDataVeriables.class).build();

        adapter = new WallpaperAdapter(options);
        recyclerView.setAdapter(adapter);

        btn = view.findViewById(R.id.wallpaper_fav_float_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), FavouriteWallpaper.class);
                startActivity(i);
            }
        });

        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}