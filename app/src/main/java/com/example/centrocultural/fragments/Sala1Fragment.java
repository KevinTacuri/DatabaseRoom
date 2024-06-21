package com.example.centrocultural.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.centrocultural.R;

public class Sala1Fragment extends Fragment {

    private static final int ROOM_INDEX_SALA1 = 0;
    private static final int ROOM_INDEX_SALA2 = 1;
    private static final int ROOM_INDEX_SALA3 = 2;
    private static final int ROOM_INDEX_SALA4 = 3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sala1, container, false);

        RelativeLayout relativeLayout = rootView.findViewById(R.id.customViewContainer);

        // Dibujar el rectángulo
        View sala1View = new View(getContext()) {
            @Override
            protected void onDraw(android.graphics.Canvas canvas) {
                super.onDraw(canvas);

                int width = getWidth();
                int height = getHeight();
                int padding = 50; // Aquí se define el padding para los bordes del rectángulo

                android.graphics.Paint paint = new android.graphics.Paint();
                paint.setColor(android.graphics.Color.BLACK);
                paint.setStyle(android.graphics.Paint.Style.STROKE); // Solo bordes
                paint.setStrokeWidth(5); // Grosor del borde

                // Dibujar el rectángulo
                canvas.drawRect(padding, padding, width - padding, height - padding, paint);
            }
        };

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );
        sala1View.setLayoutParams(layoutParams);
        relativeLayout.addView(sala1View);

        // Obtener dimensiones del rectángulo
        int rectangleWidth = getResources().getDisplayMetrics().widthPixels - 2 * 50;
        int rectangleHeight = getResources().getDisplayMetrics().heightPixels - 2 * 50;

        // Añadir ImageView en cada lado del rectángulo, centrados dentro del rectángulo
        int iconSize = 100; // Tamaño de los íconos
        int padding = 50; // Padding para los bordes del rectángulo

        // Icono en la centro superior
        ImageView topIcon = new ImageView(getContext());
        topIcon.setImageResource(R.drawable.sharp_aspect_ratio_24); // Reemplaza con tu drawable
        RelativeLayout.LayoutParams topParams = new RelativeLayout.LayoutParams(
                iconSize,
                iconSize
        );
        topParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        topParams.topMargin = padding; // Distancia desde el borde superior del rectángulo
        topIcon.setLayoutParams(topParams);
        relativeLayout.addView(topIcon);

        // Icono en la centro inferior
        ImageView bottomIcon = new ImageView(getContext());
        bottomIcon.setImageResource(R.drawable.sharp_aspect_ratio_24); // Reemplaza con tu drawable
        RelativeLayout.LayoutParams bottomParams = new RelativeLayout.LayoutParams(
                iconSize,
                iconSize
        );
        bottomParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        bottomParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        bottomParams.bottomMargin = padding; // Distancia desde el borde inferior del rectángulo
        bottomIcon.setLayoutParams(bottomParams);
        relativeLayout.addView(bottomIcon);

        // Icono en la centro izquierdo
        ImageView leftIcon = new ImageView(getContext());
        leftIcon.setImageResource(R.drawable.sharp_aspect_ratio_24); // Reemplaza con tu drawable
        RelativeLayout.LayoutParams leftParams = new RelativeLayout.LayoutParams(
                iconSize,
                iconSize
        );
        leftParams.addRule(RelativeLayout.CENTER_VERTICAL);
        leftParams.leftMargin = padding; // Distancia desde el borde izquierdo del rectángulo
        leftIcon.setLayoutParams(leftParams);
        relativeLayout.addView(leftIcon);

        // Icono en el centro derecho
        ImageView rightIcon = new ImageView(getContext());
        rightIcon.setImageResource(R.drawable.sharp_aspect_ratio_24); // Reemplaza con tu drawable
        RelativeLayout.LayoutParams rightParams = new RelativeLayout.LayoutParams(
                iconSize,
                iconSize
        );
        rightParams.addRule(RelativeLayout.CENTER_VERTICAL);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_END);
        rightParams.rightMargin = padding; // Distancia desde el borde derecho del rectángulo
        rightIcon.setLayoutParams(rightParams);
        relativeLayout.addView(rightIcon);

        // Clic listener para el ícono superior
        topIcon.setOnClickListener(v -> navigateToCuadrosFragment(ROOM_INDEX_SALA1)); // Navegar a la Sala 1 en CuadrosFragment

        // Clic listener para el ícono inferior
        bottomIcon.setOnClickListener(v -> navigateToCuadrosFragment(ROOM_INDEX_SALA2)); // Navegar a la Sala 2 en CuadrosFragment

        // Clic listener para el ícono izquierdo
        leftIcon.setOnClickListener(v -> navigateToCuadrosFragment(ROOM_INDEX_SALA3)); // Navegar a la Sala 3 en CuadrosFragment

        // Clic listener para el ícono derecho
        rightIcon.setOnClickListener(v -> navigateToCuadrosFragment(ROOM_INDEX_SALA4)); // Navegar a la Sala 4 en CuadrosFragment

        return rootView;
    }

    private void navigateToCuadrosFragment(int roomIndex) {
        // Navegar al CuadrosFragment y abrir la lista correspondiente
        CuadrosFragment cuadrosFragment = CuadrosFragment.newInstance(roomIndex);
        getParentFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, cuadrosFragment)
                .addToBackStack(null)
                .commit();
    }
}
