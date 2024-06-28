package com.example.centrocultural;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MapView extends View {
    private Paint paint;
    private Paint paintRoom;
    private Paint paintText;

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);

        paintRoom = new Paint();
        paintRoom.setColor(Color.BLACK);
        paintRoom.setStyle(Paint.Style.STROKE);
        paintRoom.setStrokeWidth(3);

        paintText = new Paint();
        paintText.setColor(Color.BLACK);
        paintText.setTextSize(40);
        paintText.setTextAlign(Paint.Align.CENTER);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawGallery(canvas);
    }

    private void drawGallery(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();

        // Escala de las dimensiones del mapa
        float scaleX = width / 1000f; // Suponiendo que el diseño original es de 1000 de ancho
        float scaleY = height / 1000f; // Suponiendo que el diseño original es de 1000 de alto

        // Sala 1
        canvas.drawRect(100 * scaleX, 700 * scaleY, 300 * scaleX, 900 * scaleY, paintRoom);
        //canvas.drawText("Sala 1", 200 * scaleX, 800 * scaleY, paintText);
        // Puerta Sala 1
        canvas.drawRect(180 * scaleX, 690 * scaleY, 220 * scaleX, 700 * scaleY, paintRoom);

        // Sala 2
        canvas.drawRect(300 * scaleX, 700 * scaleY, 500 * scaleX, 900 * scaleY, paintRoom);
        //canvas.drawText("Sala 2", 400 * scaleX, 800 * scaleY, paintText);
        // Puerta Sala 2
        canvas.drawRect(380 * scaleX, 690 * scaleY, 420 * scaleX, 700 * scaleY, paintRoom);

        // Sala 3
        canvas.drawRect(500 * scaleX, 700 * scaleY, 700 * scaleX, 900 * scaleY, paintRoom);
        //canvas.drawText("Sala 3", 600 * scaleX, 800 * scaleY, paintText);
        // Puerta Sala 3
        canvas.drawRect(580 * scaleX, 690 * scaleY, 620 * scaleX, 700 * scaleY, paintRoom);

        // Sala 4
        canvas.drawRect(700 * scaleX, 500 * scaleY, 900 * scaleX, 900 * scaleY, paintRoom);
       // canvas.drawText("Sala 4", 800 * scaleX, 750 * scaleY, paintText);
        // Puerta Sala 4
        canvas.drawRect(690 * scaleX, 680 * scaleY, 700 * scaleX, 720 * scaleY, paintRoom);

        // Sala 5
        canvas.drawRect(700 * scaleX, 100 * scaleY, 900 * scaleX, 400 * scaleY, paintRoom);
        //canvas.drawText("Sala 5", 800 * scaleX, 300 * scaleY, paintText);
        // Puerta Sala 5
        canvas.drawRect(690 * scaleX, 280 * scaleY, 700 * scaleX, 320 * scaleY, paintRoom);

        // Sala 6
        canvas.drawRect(400 * scaleX, 100 * scaleY, 700 * scaleX, 300 * scaleY, paintRoom);
        //canvas.drawText("Sala 6", 500 * scaleX, 200 * scaleY, paintText);
        // Puerta Sala 6
        canvas.drawRect(390 * scaleX, 180 * scaleY, 400 * scaleX, 220 * scaleY, paintRoom);

        // Sala 7
        canvas.drawRect(100 * scaleX, 100 * scaleY, 400 * scaleX, 300 * scaleY, paintRoom);
        //canvas.drawText("Sala 7", 300 * scaleX, 200 * scaleY, paintText);
        // Puerta Sala 7
        canvas.drawRect(90 * scaleX, 180 * scaleY, 100 * scaleX, 220 * scaleY, paintRoom);

        // Sala 8
        canvas.drawRect(100 * scaleX, 300 * scaleY, 300 * scaleX, 700 * scaleY, paintRoom);
        //canvas.drawText("Sala 8", 200 * scaleX, 500 * scaleY, paintText);
        // Puerta Sala 8
        canvas.drawRect(90 * scaleX, 480 * scaleY, 100 * scaleX, 520 * scaleY, paintRoom);
    }
}
