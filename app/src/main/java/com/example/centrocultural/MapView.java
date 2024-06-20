package com.example.centrocultural;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class GalleryCanvasView extends View {
    private Paint paint;

    public GalleryCanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawGallery(canvas);
    }

    private void drawGallery(Canvas canvas) {
        // Configurar la pintura para el contorno de las habitaciones
        Paint paintRoom = new Paint();
        paintRoom.setColor(Color.BLACK);
        paintRoom.setStyle(Paint.Style.STROKE);
        paintRoom.setStrokeWidth(3);
        
        Paint paintText = new Paint();
        paintText.setColor(Color.BLACK);
        paintText.setTextSize(40);
        paintText.setTextAlign(Paint.Align.CENTER);

        // Dibujar las salas y puertas
        // Sala 1
        canvas.drawRect(100, 700, 300, 900, paintRoom);
        canvas.drawText("Sala 1", 200, 800, paintText);
        // Puerta Sala 1
        canvas.drawRect(180, 690, 220, 700, paintRoom);

        // Sala 2
        canvas.drawRect(300, 700, 500, 900, paintRoom);
        canvas.drawText("Sala 2", 400, 800, paintText);
        // Puerta Sala 2
        canvas.drawRect(380, 690, 420, 700, paintRoom);

        // Sala 3
        canvas.drawRect(500, 700, 700, 900, paintRoom);
        canvas.drawText("Sala 3", 600, 800, paintText);
        // Puerta Sala 3
        canvas.drawRect(580, 690, 620, 700, paintRoom);

        // Sala 4
        canvas.drawRect(700, 500, 900, 900, paintRoom);
        canvas.drawText("Sala 4", 800, 750, paintText);
        // Puerta Sala 4
        canvas.drawRect(690, 680, 700, 720, paintRoom);

        // Sala 5
        canvas.drawRect(700, 100, 900, 400, paintRoom);
        canvas.drawText("Sala 5", 800, 300, paintText);
        // Puerta Sala 5
        canvas.drawRect(690, 280, 700, 320, paintRoom);

        // Sala 6
        canvas.drawRect(400, 100, 700, 300, paintRoom);
        canvas.drawText("Sala 6", 500, 200, paintText);
        // Puerta Sala 6
        canvas.drawRect(390, 180, 400, 220, paintRoom);

        // Sala 7
        canvas.drawRect(100, 100, 400, 300, paintRoom);
        canvas.drawText("Sala 7", 300, 200, paintText);
        // Puerta Sala 7
        canvas.drawRect(90, 180, 100, 220, paintRoom);

        // Sala 8
        canvas.drawRect(100, 300, 300, 700, paintRoom);
        canvas.drawText("Sala 8", 200, 500, paintText);
        // Puerta Sala 8
        canvas.drawRect(90, 480, 100, 520, paintRoom);
    }

}
