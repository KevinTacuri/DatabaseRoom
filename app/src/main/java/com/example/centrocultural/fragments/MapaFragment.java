package com.example.centrocultural.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.centrocultural.MapView;
import com.example.centrocultural.R;

public class MapaFragment extends Fragment {

    private FrameLayout mapContainer;
    private MapView mapView;
    private Button sala1Button, sala2Button, sala3Button, sala4Button, sala5Button, sala6Button, sala7Button, sala8Button;

    public static MapaFragment newInstance(String s, String s1) {
        MapaFragment fragment = new MapaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mapa, container, false);
        mapContainer = view.findViewById(R.id.mapContainer);
        mapView = new MapView(getContext(), null);

        // Agregar el MapView al contenedor
        mapContainer.addView(mapView);

        // Usar ViewTreeObserver para esperar a que la vista se mida antes de agregar los botones
        mapContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                // Quitar el listener para evitar llamadas repetidas
                mapContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                // Agregar los botones después de que la vista se haya medido
                addButtons();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Agregar los botones cuando el fragmento está visible
        addButtons();
    }

    @Override
    public void onPause() {
        super.onPause();
        // Eliminar los botones cuando el fragmento no está visible
        removeButtons();
    }

    private void addButtons() {
        float unitWidth = mapView.getWidth() / 10f;
        float unitHeight = mapView.getHeight() / 10f;

        sala1Button = createButton("Sala 1", unitWidth, 7 * unitHeight, 2 * unitWidth, 2 * unitHeight, Sala1Fragment.class);
        sala2Button = createButton("Sala 2", 3 * unitWidth, 7 * unitHeight, 2 * unitWidth, 2 * unitHeight, Sala2Fragment.class);
        sala3Button = createButton("Sala 3", 5 * unitWidth, 7 * unitHeight, 2 * unitWidth, 2 * unitHeight, Sala3Fragment.class);
        sala4Button = createButton("Sala 4", 7 * unitWidth, 5 * unitHeight, 2 * unitWidth, 4 * unitHeight, Sala4Fragment.class);
        sala5Button = createButton("Sala 5", 7 * unitWidth, 1 * unitHeight, 2 * unitWidth, 3 * unitHeight, Sala5Fragment.class);
        sala6Button = createButton("Sala 6", 4 * unitWidth, 1 * unitHeight, 3 * unitWidth, 2 * unitHeight, Sala6Fragment.class);
        sala7Button = createButton("Sala 7", unitWidth, unitHeight, 3 * unitWidth, 2 * unitHeight, Sala7Fragment.class);
        sala8Button = createButton("Sala 8", unitWidth, 3 * unitHeight, 2 * unitWidth, 4 * unitHeight, Sala8Fragment.class);

        mapContainer.addView(sala1Button);
        mapContainer.addView(sala2Button);
        mapContainer.addView(sala3Button);
        mapContainer.addView(sala4Button);
        mapContainer.addView(sala5Button);
        mapContainer.addView(sala6Button);
        mapContainer.addView(sala7Button);
        mapContainer.addView(sala8Button);
    }

    private void removeButtons() {
        mapContainer.removeView(sala1Button);
        mapContainer.removeView(sala2Button);
        mapContainer.removeView(sala3Button);
        mapContainer.removeView(sala4Button);
        mapContainer.removeView(sala5Button);
        mapContainer.removeView(sala6Button);
        mapContainer.removeView(sala7Button);
        mapContainer.removeView(sala8Button);
    }

    private Button createButton(String text, float left, float top, float width, float height, final Class<? extends Fragment> fragmentClass) {
        Button button = new Button(getContext());
        button.setText(text);
        button.setBackgroundColor(Color.TRANSPARENT);
        button.setTextColor(Color.BLACK);

        // Crear parámetros de diseño para el botón
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) width, (int) height);
        layoutParams.leftMargin = (int) left;
        layoutParams.topMargin = (int) top;

        // Asignar parámetros de diseño al botón
        button.setLayoutParams(layoutParams);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FragmentActivity) getContext()).getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainerView, fragmentClass, null)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return button;
    }
}
