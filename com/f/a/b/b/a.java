package com.f.a.b.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.f.a.b.a.e;
import com.f.a.b.a.f;
import com.f.a.b.d.d;
import com.f.a.c.b;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class a implements d {
    protected static final String a = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";
    protected static final String b = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";
    protected static final String c = "Rotate image on %1$d\u00b0 [%2$s]";
    protected static final String d = "Flip image horizontally [%s]";
    protected static final String e = "Image can't be decoded [%s]";
    protected final boolean f;

    public a(boolean z) {
        this.f = z;
    }

    private boolean a(String str, String str2) {
        return VERSION.SDK_INT >= 5 && "image/jpeg".equalsIgnoreCase(str2) && d.a(str) == d.FILE;
    }

    protected Bitmap a(Bitmap bitmap, e eVar, int i, boolean z) {
        Matrix matrix = new Matrix();
        e e = eVar.e();
        if (e == e.EXACTLY || e == e.EXACTLY_STRETCHED) {
            float b = b.b(new f(bitmap.getWidth(), bitmap.getHeight(), i), eVar.d(), eVar.f(), e == e.EXACTLY_STRETCHED);
            if (Float.compare(b, 1.0f) != 0) {
                matrix.setScale(b, b);
                if (this.f) {
                    com.f.a.c.f.a(b, r2, r2.a(b), Float.valueOf(b), eVar.a());
                }
            }
        }
        if (z) {
            matrix.postScale(GroundOverlayOptions.NO_DIMENSION, 1.0f);
            if (this.f) {
                com.f.a.c.f.a(d, eVar.a());
            }
        }
        if (i != 0) {
            matrix.postRotate((float) i);
            if (this.f) {
                com.f.a.c.f.a(c, Integer.valueOf(i), eVar.a());
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public Bitmap a(e eVar) {
        Closeable b = b(eVar);
        try {
            c a = a((InputStream) b, eVar);
            b = b(b, eVar);
            Bitmap decodeStream = BitmapFactory.decodeStream(b, null, a(a.a, eVar));
            if (decodeStream != null) {
                return a(decodeStream, eVar, a.b.a, a.b.b);
            }
            com.f.a.c.f.d(e, eVar.a());
            return decodeStream;
        } finally {
            com.f.a.c.d.a(b);
        }
    }

    protected Options a(f fVar, e eVar) {
        int a;
        e e = eVar.e();
        if (e == e.NONE) {
            a = b.a(fVar);
        } else {
            a = b.a(fVar, eVar.d(), eVar.f(), e == e.IN_SAMPLE_POWER_OF_2);
        }
        if (a > 1 && this.f) {
            com.f.a.c.f.a(a, fVar, fVar.a(a), Integer.valueOf(a), eVar.a());
        }
        Options j = eVar.j();
        j.inSampleSize = a;
        return j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected com.f.a.b.b.b a(java.lang.String r6) {
        /*
        r5 = this;
        r1 = 0;
        r0 = 1;
        r2 = new android.media.ExifInterface;	 Catch:{ IOException -> 0x002a }
        r3 = com.f.a.b.d.d.FILE;	 Catch:{ IOException -> 0x002a }
        r3 = r3.c(r6);	 Catch:{ IOException -> 0x002a }
        r2.<init>(r3);	 Catch:{ IOException -> 0x002a }
        r3 = "Orientation";
        r4 = 1;
        r2 = r2.getAttributeInt(r3, r4);	 Catch:{ IOException -> 0x002a }
        switch(r2) {
            case 1: goto L_0x0017;
            case 2: goto L_0x0018;
            case 3: goto L_0x0022;
            case 4: goto L_0x0023;
            case 5: goto L_0x0027;
            case 6: goto L_0x001e;
            case 7: goto L_0x001f;
            case 8: goto L_0x0026;
            default: goto L_0x0017;
        };
    L_0x0017:
        r0 = r1;
    L_0x0018:
        r2 = new com.f.a.b.b.b;
        r2.<init>(r1, r0);
        return r2;
    L_0x001e:
        r0 = r1;
    L_0x001f:
        r1 = 90;
        goto L_0x0018;
    L_0x0022:
        r0 = r1;
    L_0x0023:
        r1 = 180; // 0xb4 float:2.52E-43 double:8.9E-322;
        goto L_0x0018;
    L_0x0026:
        r0 = r1;
    L_0x0027:
        r1 = 270; // 0x10e float:3.78E-43 double:1.334E-321;
        goto L_0x0018;
    L_0x002a:
        r2 = move-exception;
        r2 = "Can't read EXIF tags from file [%s]";
        r0 = new java.lang.Object[r0];
        r0[r1] = r6;
        com.f.a.c.f.c(r2, r0);
        goto L_0x0017;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.f.a.b.b.a.a(java.lang.String):com.f.a.b.b.b");
    }

    protected c a(InputStream inputStream, e eVar) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        String b = eVar.b();
        b a = (eVar.i() && a(b, options.outMimeType)) ? a(b) : new b();
        return new c(new f(options.outWidth, options.outHeight, a.a), a);
    }

    protected InputStream b(e eVar) {
        return eVar.g().a(eVar.b(), eVar.h());
    }

    protected InputStream b(InputStream inputStream, e eVar) {
        try {
            inputStream.reset();
            return inputStream;
        } catch (IOException e) {
            com.f.a.c.d.a((Closeable) inputStream);
            return b(eVar);
        }
    }
}
