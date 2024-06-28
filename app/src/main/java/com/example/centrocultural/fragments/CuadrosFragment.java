package com.example.centrocultural.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.centrocultural.Painting;
import com.example.centrocultural.R;
import com.example.centrocultural.Room;
import com.example.centrocultural.RoomAdapter;

import java.util.ArrayList;
import java.util.List;

public class CuadrosFragment extends Fragment {

    private static final String ARG_ROOM_INDEX = "arg_room_index";

    public static CuadrosFragment newInstance(int roomIndex) {
        CuadrosFragment fragment = new CuadrosFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ROOM_INDEX, roomIndex);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cuadros, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.roomsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Obtener el índice de la sala desde los argumentos
        int roomIndex = getArguments() != null ? getArguments().getInt(ARG_ROOM_INDEX) : -1;

        List<Room> rooms = createRooms();
        if (roomIndex >= 0 && roomIndex < rooms.size()) {
            // Si el índice de la sala es válido, abrir la lista correspondiente
            Room room = rooms.get(roomIndex);
            RoomAdapter adapter = new RoomAdapter(rooms, getContext()); // Pasar la lista completa de rooms
            recyclerView.setAdapter(adapter);
        } else {
            // Manejar caso de índice inválido
            // Puedes mostrar un mensaje de error o manejarlo como prefieras
        }

        return view;
    }

    private List<Room> createRooms() {
        List<Room> rooms = new ArrayList<>();

        List<Painting> paintingsSala1 = new ArrayList<>();
        paintingsSala1.add(new Painting(
                "ARCÁNGEL DE LA PUSKA DE PITUMARCA",
                R.drawable.image1,
                "Plateado en alto relieve policromado 120 x 90 cm.",
                "Noé Mamani Ccajiavilca",
                "2022"
        ));
        paintingsSala1.add(new Painting(
                "ARCÁNGEL DE LA PUSKA DE PITUMARCA",
                R.drawable.image2,
                "Plateado en alto relieve policromado 120 x 90 cm.",
                "Noé Mamani Ccajiavilca",
                "2022"
        ));
        paintingsSala1.add(new Painting(
                "ARCÁNGEL MIGUEL",
                R.drawable.image3,
                "Plateado en alto relieve 120 x 80 cm.",
                "Noé Mamani Ccajiavilca",
                "2022"
        ));
        paintingsSala1.add(new Painting(
                "ARCÁNGEL MIGUEL",
                R.drawable.image4,
                "Plateado en alto relieve 120 x 80 cm.",
                "Noé Mamani Ccajiavilca",
                "2022"
        ));
        rooms.add(new Room("Sala 1 Galería para Maestros", paintingsSala1));

        List<Painting> paintingsSala2 = new ArrayList<>();
        paintingsSala2.add(new Painting(
                "RESIDUO B: La memoria es un refugio en ruinas #1",
                R.drawable.image5,
                "Mixta (Collage) 50 x 33 cm.",
                "Giancarlo Melgar",
                "2024"
        ));
        paintingsSala2.add(new Painting(
                "RESIDUO B: Miles de diagnósticos una misma imposibilidad",
                R.drawable.image6,
                "Mixta (Collage) 100 x 70 cm.",
                "Giancarlo Melgar",
                "2024"
        ));
        paintingsSala2.add(new Painting(
                "RESIDUO B: Miles de diagnósticos una misma imposibilidad",
                R.drawable.image7,
                "Mixta (Collage) 100 x 70 cm.",
                "Giancarlo Melgar",
                "2024"
        ));
        rooms.add(new Room("Sala 2 Galería para Artistas", paintingsSala2));

        List<Painting> paintingsSala3 = new ArrayList<>();
        paintingsSala3.add(new Painting(
                "RESIDUO #11",
                R.drawable.image8,
                "Collage 31 x 24 cm.",
                "Paul Lazarte Velásquez",
                "2024"
        ));
        paintingsSala3.add(new Painting(
                "RESIDUO #8",
                R.drawable.image8,
                "Collage 42 x 29.5 cm.",
                "Paul Lazarte Velásquez",
                "2024"
        ));
        rooms.add(new Room("Sala 3 Galería para obras tridimensionales", paintingsSala3));

        List<Painting> paintingsSala4 = new ArrayList<>();
        paintingsSala4.add(new Painting(
                "CAMINO A LA LUNA Y A VENUS",
                R.drawable.image10,
                "Fotografia 45 x 30 cm.",
                "Moisés Calizaya Alvarado",
                "2017"
        ));
        paintingsSala4.add(new Painting(
                "RODEANDO LA TORRE",
                R.drawable.image11,
                "Fotografia 39 x 39 cm.",
                "Moisés Calizaya Alvarado",
                "2017"
        ));
        paintingsSala4.add(new Painting(
                "ATALAYA",
                R.drawable.image11,
                "Fotografía 30 x 52 cm.",
                "Moisés Calizaya Alvarado",
                "2017"
        ));
        paintingsSala4.add(new Painting(
                "CASTILLO BLANCO, CASTILLO NEGRO",
                R.drawable.image11,
                "Fotografía 30 x 65 cm.",
                "Moisés Calizaya Alvarado",
                "2017"
        ));
        paintingsSala4.add(new Painting(
                "TORRE ALBA",
                R.drawable.image11,
                "Fotografía 39 x 39 cm.",
                "Moisés Calizaya Alvarado",
                "2017"
        ));
        paintingsSala4.add(new Painting(
                "GIGANTES GUARDIANES",
                R.drawable.image11,
                "Fotografía 30 x 45 cm.",
                "Moisés Calizaya Alvarado",
                "2017"
        ));
        rooms.add(new Room("Sala 4 Galería para artistas jóvenes", paintingsSala4));

        List<Painting> paintingsSala5 = new ArrayList<>();
        paintingsSala5.add(new Painting(
                "Zapping: conexión compartida",
                R.drawable.image16,
                "Óleo sobre lienzo 45 x 60 cm.",
                "Cristal Luque Castro",
                "2024"
        ));
        paintingsSala5.add(new Painting(
                "A solas: Distención alquímica",
                R.drawable.image17,
                "Óleo sobre lienzo 100 x 120 cm.",
                "Cristal Luque Castro",
                "2024"
        ));
        rooms.add(new Room("Sala 5 Galería para pequeños formatos", paintingsSala5));

        List<Painting> paintingsSala6 = new ArrayList<>();
        paintingsSala6.add(new Painting(
                "Diálogo perenne en la sala de estar",
                R.drawable.image18,
                "Óleo sobre lienzo 120 x 200 cm.",
                "Cristal Luque Castro",
                "2024"
        ));
        paintingsSala6.add(new Painting(
                "Picnic: Reminiscencias bajo la mesa",
                R.drawable.image18,
                "Óleo sobre lienzo 100 x 160 cm.",
                "Cristal Luque Castro",
                "2024"
        ));
        rooms.add(new Room("Sala 6 Galería de promoción", paintingsSala6));

        List<Painting> paintingsSala7 = new ArrayList<>();
        paintingsSala7.add(new Painting(
                "S/T",
                R.drawable.image20,
                "Óleo sobre lienzo 80 x 100 cm.",
                "Cristal Luque Castro",
                "2019"
        ));
        paintingsSala7.add(new Painting(
                "Picnic: Reminiscencias sobre la mesa",
                R.drawable.image21,
                "Oleo sobre lienzo 100 x 120 cm.",
                "Cristal Luque Castro",
                "2024"
        ));
        rooms.add(new Room("Sala 7 Galería para invitados", paintingsSala7));

        List<Painting> paintingsSala8 = new ArrayList<>();
        paintingsSala8.add(new Painting(
                "Sol de Mayo: Cada prenda en este cordel es un disparador de estímulos",
                R.drawable.image22,
                "Óleo sobre lienzo 100 x 130 cm.",
                "Cristal Luque Castro",
                "1498"
        ));
        paintingsSala8.add(new Painting(
                "Hogar: Me niego a ser oculto",
                R.drawable.image23,
                "Óleo sobre lienzo 40 x 60 cm.",
                "Cristal Luque Castro",
                "2023"
        ));
        rooms.add(new Room("Sala 8 Galería de enlace", paintingsSala8));

        return rooms;
    }
}
