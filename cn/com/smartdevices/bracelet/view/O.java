package cn.com.smartdevices.bracelet.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.view.C0151az;
import cn.com.smartdevices.bracelet.C0596r;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class O {
    private static final String a = "Util";
    private static ProgressDialog b = null;

    public static Bitmap a(Context context, String str) {
        InputStream openInputStream;
        Throwable th;
        Drawable drawable = null;
        Uri fromFile = Uri.fromFile(new File(str));
        try {
            openInputStream = context.getContentResolver().openInputStream(fromFile);
            try {
                drawable = Drawable.createFromStream(openInputStream, null);
                if (openInputStream != null) {
                    try {
                        openInputStream.close();
                    } catch (IOException e) {
                        C0596r.g("ImageView", "Unable to close content: " + fromFile);
                    }
                }
            } catch (Exception e2) {
                try {
                    C0596r.g("ImageView", "Unable to open content: " + fromFile);
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException e3) {
                            C0596r.g("ImageView", "Unable to close content: " + fromFile);
                        }
                    }
                    return ((BitmapDrawable) drawable).getBitmap();
                } catch (Throwable th2) {
                    th = th2;
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException e4) {
                            C0596r.g("ImageView", "Unable to close content: " + fromFile);
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            openInputStream = drawable;
            C0596r.g("ImageView", "Unable to open content: " + fromFile);
            if (openInputStream != null) {
                openInputStream.close();
            }
            return ((BitmapDrawable) drawable).getBitmap();
        } catch (Throwable th3) {
            Throwable th4 = th3;
            openInputStream = drawable;
            th = th4;
            if (openInputStream != null) {
                openInputStream.close();
            }
            throw th;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    public static Bitmap a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        C0596r.e(a, "round bitmap w=" + bitmap.getWidth() + ", h=" + bitmap.getHeight());
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect();
        RectF rectF = new RectF();
        if (bitmap.getWidth() > bitmap.getHeight()) {
            rect.left = (bitmap.getWidth() - min) / 2;
            rect.top = 0;
            rect.right = bitmap.getWidth() - rect.left;
            rect.bottom = bitmap.getHeight();
        } else if (bitmap.getWidth() < bitmap.getHeight()) {
            rect.left = 0;
            rect.top = (bitmap.getHeight() - min) / 2;
            rect.right = bitmap.getWidth();
            rect.bottom = bitmap.getHeight() - rect.top;
        } else {
            rect.left = 0;
            rect.top = 0;
            rect.right = bitmap.getWidth();
            rect.bottom = bitmap.getHeight();
        }
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = (float) min;
        rectF.bottom = (float) min;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(C0151az.s);
        min /= 2;
        canvas.drawRoundRect(rectF, (float) min, (float) min, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rectF, paint);
        return createBitmap;
    }

    public static void a() {
        try {
            C0596r.e(a, "mPd = " + b + ", is showing=" + b.isShowing());
            if (b != null) {
                b.dismiss();
                b.hide();
            }
        } catch (Exception e) {
            C0596r.e(a, "Exception: mPd = " + b);
        }
    }

    public static void a(Context context, String str, String str2) {
        a(context, str, str2, false);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        if (b == null || !b.isShowing()) {
            try {
                b = ProgressDialog.show(context, str, str2);
                b.setCancelable(z);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        a(str2);
    }

    public static void a(String str) {
        try {
            if (b != null && b.isShowing()) {
                b.setMessage(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
