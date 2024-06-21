package com.example.centrocultural;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.centrocultural.fragments.HomeFragment;
import com.example.centrocultural.fragments.Sala1Fragment;

public class MapView extends View {
    private Paint paint;
    private GestureDetector gestureDetector;
    private static final String TAG = "MapView";

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);

        gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                handleTouch(e.getX(), e.getY());
                return true;
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawGallery(canvas);
    }

    private void drawGallery(Canvas canvas) {
        // Obtener las dimensiones de la vista
        int viewWidth = getWidth();
        int viewHeight = getHeight();

        // Calcular las unidades de tamaño para las salas
        float unitWidth = viewWidth / 10f;
        float unitHeight = viewHeight / 10f;

        // Configurar la pintura para el contorno de las habitaciones
        Paint paintRoom = new Paint();
        paintRoom.setColor(Color.BLACK);
        paintRoom.setStyle(Paint.Style.STROKE);
        paintRoom.setStrokeWidth(3);

        Paint paintText = new Paint();
        paintText.setColor(Color.BLACK);
        paintText.setTextSize(unitHeight / 3);
        paintText.setTextAlign(Paint.Align.CENTER);

        // Dibujar las salas y puertas
        // Sala 1
        canvas.drawRect(unitWidth, 7 * unitHeight, 3 * unitWidth, 9 * unitHeight, paintRoom);
        //canvas.drawText("Sala 1", 2 * unitWidth, 8 * unitHeight, paintText);
        // Puerta Sala 1
        canvas.drawRect(1.8f * unitWidth, 6.9f * unitHeight, 2.2f * unitWidth, 7 * unitHeight, paintRoom);

        // Sala 2
        canvas.drawRect(3 * unitWidth, 7 * unitHeight, 5 * unitWidth, 9 * unitHeight, paintRoom);
        //canvas.drawText("Sala 2", 4 * unitWidth, 8 * unitHeight, paintText);
        // Puerta Sala 2
        canvas.drawRect(3.8f * unitWidth, 6.9f * unitHeight, 4.2f * unitWidth, 7 * unitHeight, paintRoom);

        // Sala 3
        canvas.drawRect(5 * unitWidth, 7 * unitHeight, 7 * unitWidth, 9 * unitHeight, paintRoom);
       // canvas.drawText("Sala 3", 6 * unitWidth, 8 * unitHeight, paintText);
        // Puerta Sala 3
        canvas.drawRect(5.8f * unitWidth, 6.9f * unitHeight, 6.2f * unitWidth, 7 * unitHeight, paintRoom);

        // Sala 4
        canvas.drawRect(7 * unitWidth, 5 * unitHeight, 9 * unitWidth, 9 * unitHeight, paintRoom);
        //canvas.drawText("Sala 4", 8 * unitWidth, 7 * unitHeight, paintText);
        // Puerta Sala 4
        canvas.drawRect(6.9f * unitWidth, 6.8f * unitHeight, 7 * unitWidth, 7.2f * unitHeight, paintRoom);

        // Sala 5
        canvas.drawRect(7 * unitWidth, 1 * unitHeight, 9 * unitWidth, 4 * unitHeight, paintRoom);
        //canvas.drawText("Sala 5", 8 * unitWidth, 2.5f * unitHeight, paintText);
        // Puerta Sala 5
        canvas.drawRect(6.9f * unitWidth, 2.8f * unitHeight, 7 * unitWidth, 3.2f * unitHeight, paintRoom);

        // Sala 6
        canvas.drawRect(4 * unitWidth, 1 * unitHeight, 7 * unitWidth, 3 * unitHeight, paintRoom);
        //canvas.drawText("Sala 6", 5.5f * unitWidth, 2 * unitHeight, paintText);
        // Puerta Sala 6
        canvas.drawRect(3.9f * unitWidth, 1.8f * unitHeight, 4 * unitWidth, 2.2f * unitHeight, paintRoom);

        // Sala 7
        canvas.drawRect(unitWidth, unitHeight, 4 * unitWidth, 3 * unitHeight, paintRoom);
        //canvas.drawText("Sala 7", 2.5f * unitWidth, 2 * unitHeight, paintText);
        // Puerta Sala 7
        canvas.drawRect(0.9f * unitWidth, 1.8f * unitHeight, unitWidth, 2.2f * unitHeight, paintRoom);

        // Sala 8
        canvas.drawRect(unitWidth, 3 * unitHeight, 3 * unitWidth, 7 * unitHeight, paintRoom);
        //canvas.drawText("Sala 8", 2 * unitWidth, 5 * unitHeight, paintText);
        // Puerta Sala 8
        canvas.drawRect(0.9f * unitWidth, 4.8f * unitHeight, unitWidth, 5.2f * unitHeight, paintRoom);
    }

    private void redirectToFragment(Class<? extends Fragment> fragmentClass) {
        try {
            Fragment fragment = fragmentClass.newInstance();

            FragmentActivity activity = (FragmentActivity) getContext();
            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainerView, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    // Modificar el método handleTouch para navegar a Sala1Fragment cuando se haga clic
    private void handleTouch(float x, float y) {
        Log.d(TAG, "handleTouch: Touch at (" + x + ", " + y + ")");
        redirectToFragment(Sala1Fragment.class);
    }
}
