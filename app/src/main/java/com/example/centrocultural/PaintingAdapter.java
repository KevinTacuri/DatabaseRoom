package com.example.centrocultural;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PaintingAdapter extends RecyclerView.Adapter<PaintingAdapter.PaintingViewHolder> {

    private List<Painting> paintings;

    public PaintingAdapter(List<Painting> paintings) {
        this.paintings = paintings;
    }

    @NonNull
    @Override
    public PaintingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_painting, parent, false);
        return new PaintingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaintingViewHolder holder, int position) {
        Painting painting = paintings.get(position);
        holder.paintingName.setText(painting.getName());
    }

    @Override
    public int getItemCount() {
        return paintings.size();
    }

    public static class PaintingViewHolder extends RecyclerView.ViewHolder {
        TextView paintingName;

        public PaintingViewHolder(@NonNull View itemView) {
            super(itemView);
            paintingName = itemView.findViewById(R.id.paintingName);
        }
    }
}
