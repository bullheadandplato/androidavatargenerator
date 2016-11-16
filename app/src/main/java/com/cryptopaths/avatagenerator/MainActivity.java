package com.cryptopaths.avatagenerator;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> mColors=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //add colors in colors lost
        mColors.add("#F44336");
        mColors.add("#E91E63");
        mColors.add("#9C27B0");
        mColors.add("#673AB7");
        mColors.add("#3F51B5");
        mColors.add("#2196F3");
        mColors.add("#00BCD4");
        mColors.add("#009688");
        mColors.add("#4CAF50");
        mColors.add("#CDDC39");
        mColors.add("#FFC107");
        mColors.add("#FF9800");
        generateAvatar("Osama");
    }
    @Nullable
    private RoundedBitmapDrawable generateAvatar(String name){
        Bitmap bitmap=Bitmap.createBitmap(100,100, Bitmap.Config.RGB_565);
        Canvas canvas=new Canvas(bitmap);
        Paint paint=new Paint();
        paint.setColor(Color.parseColor(mColors.get(1)));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(50,50,50,paint);
        paint.setColor(Color.WHITE);
        paint.setTextSize(75);
        Log.d("canvas","width: "+canvas.getWidth());
        Log.d("canvas","height: "+canvas.getHeight());
        int x = (canvas.getWidth() / 2);
        int y = (int) ((canvas.getHeight() / 2)- (paint.descent()+paint.ascent())/2);
        Log.d("canvas","x: "+x);
        Log.d("canvas","y: "+y);
        canvas.drawText(name.substring(0,1),25,y,paint);

        ImageView imageView=(ImageView) findViewById(R.id.imageView);
        RoundedBitmapDrawable bitmapDrawable= RoundedBitmapDrawableFactory.create(getResources(),bitmap);
        bitmapDrawable.setCircular(true);
        imageView.setImageDrawable(bitmapDrawable);
        return null;

    }
}
