package cn.com.smartdevices.bracelet.chart.base;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;

public class i extends r {
    Bitmap a;
    Shader b;

    public i(Bitmap bitmap) {
        this.a = bitmap;
        this.c = new Paint();
        this.b = new BitmapShader(this.a, TileMode.REPEAT, TileMode.CLAMP);
        this.c.setShader(this.b);
    }

    public int a() {
        return this.a.getHeight();
    }

    public void a(float f, float f2) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2);
        this.b.setLocalMatrix(matrix);
    }

    public void a(Bitmap bitmap) {
        this.c.setShader(new BitmapShader(bitmap, TileMode.REPEAT, TileMode.CLAMP));
    }

    public int b() {
        return this.a.getWidth();
    }
}
