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
        ImageView imageView1=(ImageView) findViewById(R.id.imageView1);
        ImageView imageView2=(ImageView) findViewById(R.id.imageView2);
        ImageView imageView3=(ImageView) findViewById(R.id.imageView3);
        ImageView imageView4=(ImageView) findViewById(R.id.imageView4);
        ImageView imageView5=(ImageView) findViewById(R.id.imageView5);
        ImageView imageView6=(ImageView) findViewById(R.id.imageView6);
        ImageView imageView7=(ImageView) findViewById(R.id.imageView7);
        ImageView imageView8=(ImageView) findViewById(R.id.imageView8);
        ImageView imageView9=(ImageView) findViewById(R.id.imageView9);
        ImageView imageView10=(ImageView) findViewById(R.id.imageView10);
        ImageView imageView11=(ImageView) findViewById(R.id.imageView11);

        ImageView imageView12=(ImageView) findViewById(R.id.imageView12);
        ImageView imageView13=(ImageView) findViewById(R.id.imageView13);
        ImageView imageView14=(ImageView) findViewById(R.id.imageView14);
        generateAvatar("A",imageView1,mColors.get(1));
        generateAvatar("B",imageView2,mColors.get(2));
        generateAvatar("C",imageView3,mColors.get(3));
        generateAvatar("D",imageView4,mColors.get(4));
        generateAvatar("E",imageView5,mColors.get(5));
        generateAvatar("F",imageView6,mColors.get(6));
        generateAvatar("G",imageView7,mColors.get(7));
        generateAvatar("H",imageView8,mColors.get(8));
        generateAvatar("I",imageView9,mColors.get(9));
        generateAvatar("J",imageView10,mColors.get(10));
        generateAvatar("K",imageView11,mColors.get(11));
        generateAvatar("L",imageView12,mColors.get(4));
        generateAvatar("M",imageView13,mColors.get(7));
        generateAvatar("N",imageView14,mColors.get(6));


    }
    @Nullable
    private RoundedBitmapDrawable generateAvatar(String name,ImageView imageView,String color){
       String text=name.substring(0,1);
        Bitmap bitmap=Bitmap.createBitmap(100,100, Bitmap.Config.RGB_565);
        Canvas canvas=new Canvas(bitmap);
        Paint paint=new Paint();
        paint.setColor(Color.parseColor(color));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPaint(paint);
        paint.setColor(Color.WHITE);
        paint.setTextSize(75);
        //center text
        Rect rect=canvas.getClipBounds();
        int cHeight=rect.height();
        int cWidth=rect.width();
        paint.getTextBounds(text, 0, text.length(), rect);
        float x = cWidth / 2f - rect.width() / 2f - rect.left;
        float y = cHeight / 2f + rect.height() / 2f - rect.bottom;

        Log.d("canvas","width: "+canvas.getWidth());
        Log.d("canvas","height: "+canvas.getHeight());
        Log.d("canvas","x: "+x);
        Log.d("canvas","y: "+y);
        canvas.drawText(name.substring(0,1),x,y,paint);

        RoundedBitmapDrawable bitmapDrawable= RoundedBitmapDrawableFactory.create(getResources(),bitmap);
        bitmapDrawable.setCircular(true);
        imageView.setImageDrawable(bitmapDrawable);
        return null;

    }
}
