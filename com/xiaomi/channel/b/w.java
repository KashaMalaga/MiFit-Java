package com.xiaomi.channel.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class w {
    public static Bitmap a(Bitmap bitmap, int i, int i2, Config config) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width < i && height < i) {
            return bitmap;
        }
        double d = ((double) width) / ((double) i) > ((double) height) / ((double) i2) ? ((double) width) / ((double) i) : ((double) height) / ((double) i2);
        return b(bitmap, (int) (((double) width) / d), (int) (((double) height) / d), config);
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static File a() {
        try {
            File file = new File(new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "miliaoshare"), "images");
            return (file.isDirectory() || file.mkdirs()) ? new File(file, v.c) : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void a(String str) {
        File file = new File(str.substring(0, str.lastIndexOf("/")));
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static boolean a(Bitmap bitmap, String str) {
        return a(bitmap, str, CompressFormat.PNG, 100);
    }

    public static boolean a(Bitmap bitmap, String str, CompressFormat compressFormat, int i) {
        FileOutputStream fileOutputStream;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        try {
            a(str);
            File file = new File(str);
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            try {
                boolean compress = bitmap.compress(compressFormat, i, fileOutputStream);
                if (fileOutputStream == null) {
                    return compress;
                }
                try {
                    fileOutputStream.close();
                    return compress;
                } catch (IOException e) {
                    return compress;
                }
            } catch (IOException e2) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e3) {
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            return false;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileOutputStream = null;
            th = th4;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    public static Bitmap b(Bitmap bitmap, int i, int i2, Config config) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width < i && height < i) {
            return bitmap;
        }
        Rect rect = new Rect(0, 0, width, height);
        Rect rect2 = new Rect(0, 0, i, i2);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        new Canvas(createBitmap).drawBitmap(bitmap, rect, rect2, new Paint());
        return createBitmap;
    }
}
