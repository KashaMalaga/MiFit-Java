package android.support.v4.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.print.PrintAttributes.Builder;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.util.Log;
import java.io.InputStream;

class i {
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 1;
    public static final int h = 2;
    private static final String l = "PrintHelperKitkat";
    private static final int m = 3500;
    final Context a;
    Options b = null;
    int i = h;
    int j = h;
    int k = g;
    private final Object n = new Object();

    i(Context context) {
        this.a = context;
    }

    private Bitmap a(Uri uri, int i) {
        int i2 = g;
        Bitmap bitmap = null;
        if (i <= 0 || uri == null || this.a == null) {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        a(uri, options);
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i3 > 0 && i4 > 0) {
            int max = Math.max(i3, i4);
            while (max > i) {
                max >>>= g;
                i2 <<= g;
            }
            if (i2 > 0 && Math.min(i3, i4) / i2 > 0) {
                Options options2;
                synchronized (this.n) {
                    this.b = new Options();
                    this.b.inMutable = true;
                    this.b.inSampleSize = i2;
                    options2 = this.b;
                }
                try {
                    bitmap = a(uri, options2);
                    synchronized (this.n) {
                        this.b = null;
                    }
                } catch (Throwable th) {
                    synchronized (this.n) {
                        this.b = null;
                    }
                }
            }
        }
        return bitmap;
    }

    private Bitmap a(Uri uri, Options options) {
        InputStream inputStream = null;
        if (uri == null || this.a == null) {
            throw new IllegalArgumentException("bad argument to loadBitmap");
        }
        try {
            inputStream = this.a.getContentResolver().openInputStream(uri);
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e) {
                    Log.w(l, "close fail ", e);
                }
            }
            return decodeStream;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e2) {
                    Log.w(l, "close fail ", e2);
                }
            }
        }
    }

    private Matrix a(int i, int i2, RectF rectF, int i3) {
        Matrix matrix = new Matrix();
        float width = rectF.width() / ((float) i);
        width = i3 == h ? Math.max(width, rectF.height() / ((float) i2)) : Math.min(width, rectF.height() / ((float) i2));
        matrix.postScale(width, width);
        matrix.postTranslate((rectF.width() - (((float) i) * width)) / 2.0f, (rectF.height() - (width * ((float) i2))) / 2.0f);
        return matrix;
    }

    public int a() {
        return this.i;
    }

    public void a(int i) {
        this.i = i;
    }

    public void a(String str, Bitmap bitmap, n nVar) {
        if (bitmap != null) {
            int i = this.i;
            PrintManager printManager = (PrintManager) this.a.getSystemService("print");
            MediaSize mediaSize = MediaSize.UNKNOWN_PORTRAIT;
            if (bitmap.getWidth() > bitmap.getHeight()) {
                mediaSize = MediaSize.UNKNOWN_LANDSCAPE;
            }
            printManager.print(str, new j(this, str, bitmap, i, nVar), new Builder().setMediaSize(mediaSize).setColorMode(this.j).build());
        }
    }

    public void a(String str, Uri uri, n nVar) {
        PrintDocumentAdapter kVar = new k(this, str, uri, nVar, this.i);
        PrintManager printManager = (PrintManager) this.a.getSystemService("print");
        Builder builder = new Builder();
        builder.setColorMode(this.j);
        if (this.k == g) {
            builder.setMediaSize(MediaSize.UNKNOWN_LANDSCAPE);
        } else if (this.k == h) {
            builder.setMediaSize(MediaSize.UNKNOWN_PORTRAIT);
        }
        printManager.print(str, kVar, builder.build());
    }

    public int b() {
        return this.k;
    }

    public void b(int i) {
        this.j = i;
    }

    public int c() {
        return this.j;
    }

    public void c(int i) {
        this.k = i;
    }
}
