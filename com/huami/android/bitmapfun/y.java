package com.huami.android.bitmapfun;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import java.io.FileDescriptor;

public class y extends z {
    private static final String a = "ImageResizer";
    protected int d;
    protected int e;

    public y(Context context, int i) {
        super(context);
        a(i);
    }

    public y(Context context, int i, int i2) {
        super(context);
        a(i, i2);
    }

    public static int a(int i, int i2, Options options) {
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        return (i4 > i2 || i3 > i) ? i2 == 0 ? (int) Math.floor((double) (((float) i3) / ((float) i))) : i == 0 ? (int) Math.floor((double) (((float) i4) / ((float) i2))) : Math.max((int) Math.floor((double) (((float) i4) / ((float) i2))), (int) Math.floor((double) (((float) i3) / ((float) i)))) : 1;
    }

    public static int a(Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 > i2 && i7 / i5 > i) {
                i5 *= 2;
            }
            long j = (long) ((i3 * i4) / i5);
            while (j > ((long) ((i * i2) * 2))) {
                j /= 2;
                i5 *= 2;
            }
        }
        return i5;
    }

    public static Bitmap a(Resources resources, int i, int i2, int i3, s sVar) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = a(options, i2, i3);
        if (E.c()) {
            a(options, sVar);
        }
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i, options);
    }

    public static Bitmap a(FileDescriptor fileDescriptor, int i, int i2, s sVar) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        options.inSampleSize = a(i, i2, options);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }

    public static Bitmap a(String str, int i, int i2) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = a(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap a(String str, int i, int i2, s sVar) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = a(options, i, i2);
        if (E.c()) {
            a(options, sVar);
        }
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    @TargetApi(11)
    private static void a(Options options, s sVar) {
        options.inMutable = true;
        if (sVar != null) {
            Bitmap a = sVar.a(options);
            if (a != null) {
                options.inBitmap = a;
            }
        }
    }

    private Bitmap c(int i) {
        return a(this.g, i, this.d, this.e, f());
    }

    protected Bitmap a(Object obj) {
        return c(Integer.parseInt(String.valueOf(obj)));
    }

    protected Bitmap a(Object obj, int i) {
        return c(Integer.parseInt(String.valueOf(obj)));
    }

    public void a(int i) {
        a(i, i);
    }

    public void a(int i, int i2) {
        this.d = i;
        this.e = i2;
    }
}
