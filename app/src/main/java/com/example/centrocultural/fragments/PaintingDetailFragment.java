package com.example.centrocultural.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.centrocultural.R;

public class PaintingDetailFragment extends Fragment {

    private static final String ARG_NAME = "name";
    private static final String ARG_IMAGE_RES_ID = "imageResId";
    private static final String ARG_DESCRIPTION = "description";
    private static final String ARG_ARTIST = "artist";
    private static final String ARG_YEAR = "year";

    public static PaintingDetailFragment newInstance(String name, int imageResId, String description, String artist, String year) {
        PaintingDetailFragment fragment = new PaintingDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putInt(ARG_IMAGE_RES_ID, imageResId);
        args.putString(ARG_DESCRIPTION, description);
        args.putString(ARG_ARTIST, artist);
        args.putString(ARG_YEAR, year);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_painting_detail, container, false);

        ImageView imageView = view.findViewById(R.id.paintingDetailImageView);
        TextView nameTextView = view.findViewById(R.id.paintingDetailTitleTextView);
        TextView descriptionTextView = view.findViewById(R.id.paintingDetailDescriptionTextView);
        TextView artistTextView = view.findViewById(R.id.paintingDetailAuthorTextView);
        TextView yearTextView = view.findViewById(R.id.paintingDetailYearTextView);
        if (getArguments() != null) {
            nameTextView.setText(getArguments().getString(ARG_NAME));
            imageView.setImageResource(getArguments().getInt(ARG_IMAGE_RES_ID));
            descriptionTextView.setText(getArguments().getString(ARG_DESCRIPTION));
            artistTextView.setText(getArguments().getString(ARG_ARTIST));
            yearTextView.setText(getArguments().getString(ARG_YEAR));
        }

        return view;
    }
}
