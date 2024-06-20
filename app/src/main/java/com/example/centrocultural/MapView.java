package com.example.centrocultural;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MapView extends View {

    private Paint paint;

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int viewWidth = getWidth();
        int viewHeight = getHeight();

        // Configuración del mapa
        int columns = 9;
        int rows = 11;
        float unitWidth = viewWidth / (float) (columns + 2); // Aumentamos el espacio para el margen
        float unitHeight = viewHeight / (float) (rows + 2); // Aumentamos el espacio para el margen

        float offsetX = unitWidth; // Margen horizontal
        float offsetY = unitHeight; // Margen vertical

        // Dibujar el contorno del mapa
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawRect(offsetX, offsetY, offsetX + columns * unitWidth, offsetY + rows * unitHeight, paint);

        // Dibujar las habitaciones
        // Sala 1
        canvas.drawRect(offsetX, offsetY, offsetX + 2 * unitWidth, offsetY + 2 * unitHeight, paint);
        // Sala 2
        canvas.drawRect(offsetX + 2 * unitWidth, offsetY, offsetX + 6 * unitWidth, offsetY + 2 * unitHeight, paint);
        // Pasillo
        canvas.drawRect(offsetX + 6 * unitWidth, offsetY, offsetX + 7 * unitWidth, offsetY + 2 * unitHeight, paint);
        // Sala 3 (vertical)
        canvas.drawRect(offsetX + 7 * unitWidth, offsetY, offsetX + 9 * unitWidth, offsetY + 11 * unitHeight, paint);
        // Sala 4 (vertical)
        canvas.drawRect(offsetX, offsetY + 2 * unitHeight, offsetX + 2 * unitWidth, offsetY + 9 * unitHeight, paint);
        // Sala 5
        canvas.drawRect(offsetX, offsetY + 9 * unitHeight, offsetX + 2 * unitWidth, offsetY + 11 * unitHeight, paint);
        // Sala 6
        canvas.drawRect(offsetX + 2 * unitWidth, offsetY + 9 * unitHeight, offsetX + 6 * unitWidth, offsetY + 11 * unitHeight, paint);
        // Pasillo
        canvas.drawRect(offsetX + 6 * unitWidth, offsetY + 9 * unitHeight, offsetX + 7 * unitWidth, offsetY + 11 * unitHeight, paint);

        // Dibujar el texto dentro de las habitaciones
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(30);

        // Sala 1
        canvas.drawText("Sala 1", offsetX + unitWidth, offsetY + unitHeight, paint);
        // Sala 2
        canvas.drawText("Sala 2", offsetX + 4 * unitWidth, offsetY + unitHeight, paint);
        // Sala 3
        canvas.drawText("Sala 3", offsetX + 8 * unitWidth, offsetY + 5.5f * unitHeight, paint);
        // Sala 4
        canvas.drawText("Sala 4", offsetX + unitWidth, offsetY + 5.5f * unitHeight, paint);
        // Sala 5
        canvas.drawText("Sala 5", offsetX + unitWidth, offsetY + 10 * unitHeight, paint);
        // Sala 6
        canvas.drawText("Sala 6", offsetX + 4 * unitWidth, offsetY + 10 * unitHeight, paint);

        // Dibujar el patio (espacio vacío en el centro)
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(offsetX + 2 * unitWidth, offsetY + 2 * unitHeight, offsetX + 6 * unitWidth, offsetY + 9 * unitHeight, paint);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText("Patio", offsetX + 4 * unitWidth, offsetY + 5.5f * unitHeight, paint);
    }
}
