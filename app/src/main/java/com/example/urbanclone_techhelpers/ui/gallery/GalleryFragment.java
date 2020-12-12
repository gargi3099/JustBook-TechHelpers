package com.example.application2.ui.gallery;


import android.content.Intent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.application2.R;

public class GalleryFragment extends Fragment {

    private com.example.application2.ui.gallery.GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        Intent intent = new Intent(getActivity(),com.example.application2.Myprofile.class);
        startActivity(intent);
        getActivity().finish();
      /*galleryViewModel =
                ViewModelProviders.of(this).get(com.example.application2.ui.gallery.GalleryViewModel.class);


        galleryViewModel =
                ViewModelProviders.of(this).get(com.example.application2.ui.gallery.GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }

        });*/


        return root;
    }
}