package com.example.centrocultural.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.centrocultural.Painting;
import com.example.centrocultural.R;
import com.example.centrocultural.Room;
import com.example.centrocultural.RoomAdapter;

import java.util.ArrayList;
import java.util.List;

public class CuadrosFragment extends Fragment {

    public static CuadrosFragment newInstance(String param1, String param2) {
        return new CuadrosFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cuadros, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.roomsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Room> rooms = createRooms();
        RoomAdapter adapter = new RoomAdapter(rooms, getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Room> createRooms() {
        List<Room> rooms = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            List<Painting> paintings = new ArrayList<>();
            for (int j = 1; j <= 10; j++) {
                paintings.add(new Painting("Painting " + j + " in Room " + i));
            }
            rooms.add(new Room("Room " + i, paintings));
        }
        return rooms;
    }
}
