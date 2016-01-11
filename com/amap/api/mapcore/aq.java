package com.amap.api.mapcore;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.support.v4.view.C0151az;
import com.amap.api.mapcore.util.s;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

class aq {
    private aq() {
    }

    private static int a(byte[] bArr, int i) {
        return (((bArr[i + 0] & HeartRateInfo.HR_EMPTY_VALUE) | (bArr[i + 1] << 8)) | (bArr[i + 2] << 16)) | (bArr[i + 3] << 24);
    }

    private static Bitmap a(InputStream inputStream) {
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
        Object a = a(decodeStream);
        if (!NinePatch.isNinePatchChunk(a)) {
            return decodeStream;
        }
        Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 1, 1, decodeStream.getWidth() - 2, decodeStream.getHeight() - 2);
        decodeStream.recycle();
        Field declaredField = createBitmap.getClass().getDeclaredField("mNinePatchChunk");
        declaredField.setAccessible(true);
        declaredField.set(createBitmap, a);
        return createBitmap;
    }

    public static Drawable a(Context context, String str) {
        Bitmap b = b(context, str);
        if (b.getNinePatchChunk() == null) {
            return new BitmapDrawable(b);
        }
        Rect rect = new Rect();
        a(b.getNinePatchChunk(), rect);
        return new NinePatchDrawable(context.getResources(), b, b.getNinePatchChunk(), rect, null);
    }

    private static void a(Bitmap bitmap, byte[] bArr) {
        int i;
        int i2 = 0;
        int[] iArr = new int[(bitmap.getWidth() - 2)];
        bitmap.getPixels(iArr, 0, iArr.length, 1, bitmap.getHeight() - 1, iArr.length, 1);
        for (i = 0; i < iArr.length; i++) {
            if (-16777216 == iArr[i]) {
                a(bArr, 12, i);
                break;
            }
        }
        for (i = iArr.length - 1; i >= 0; i--) {
            if (-16777216 == iArr[i]) {
                a(bArr, 16, (iArr.length - i) - 2);
                break;
            }
        }
        int[] iArr2 = new int[(bitmap.getHeight() - 2)];
        bitmap.getPixels(iArr2, 0, 1, bitmap.getWidth() - 1, 0, 1, iArr2.length);
        while (i2 < iArr2.length) {
            if (-16777216 == iArr2[i2]) {
                a(bArr, 20, i2);
                break;
            }
            i2++;
        }
        for (i = iArr2.length - 1; i >= 0; i--) {
            if (-16777216 == iArr2[i]) {
                a(bArr, 24, (iArr2.length - i) - 2);
                return;
            }
        }
    }

    private static void a(OutputStream outputStream, int i) {
        outputStream.write((i >> 0) & HeartRateInfo.HR_EMPTY_VALUE);
        outputStream.write((i >> 8) & HeartRateInfo.HR_EMPTY_VALUE);
        outputStream.write((i >> 16) & HeartRateInfo.HR_EMPTY_VALUE);
        outputStream.write((i >> 24) & HeartRateInfo.HR_EMPTY_VALUE);
    }

    private static void a(byte[] bArr, int i, int i2) {
        bArr[i + 0] = (byte) (i2 >> 0);
        bArr[i + 1] = (byte) (i2 >> 8);
        bArr[i + 2] = (byte) (i2 >> 16);
        bArr[i + 3] = (byte) (i2 >> 24);
    }

    private static void a(byte[] bArr, Rect rect) {
        rect.left = a(bArr, 12);
        rect.right = a(bArr, 16);
        rect.top = a(bArr, 20);
        rect.bottom = a(bArr, 24);
    }

    private static byte[] a(Bitmap bitmap) {
        int i;
        int i2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (i = 0; i < 32; i++) {
            byteArrayOutputStream.write(0);
        }
        int[] iArr = new int[(width - 2)];
        bitmap.getPixels(iArr, 0, width, 1, 0, width - 2, 1);
        Object obj = iArr[0] == C0151az.s ? 1 : null;
        Object obj2 = iArr[iArr.length + -1] == -16777216 ? 1 : null;
        int length = iArr.length;
        width = 0;
        int i3 = 0;
        for (i2 = 0; i2 < length; i2++) {
            if (width != iArr[i2]) {
                i3++;
                a(byteArrayOutputStream, i2);
                width = iArr[i2];
            }
        }
        if (obj2 != null) {
            i3++;
            a(byteArrayOutputStream, iArr.length);
        }
        int i4 = i3;
        int i5 = i4 + 1;
        i = obj != null ? i5 - 1 : i5;
        int i6 = obj2 != null ? i - 1 : i;
        iArr = new int[(height - 2)];
        bitmap.getPixels(iArr, 0, 1, 0, 1, 1, height - 2);
        obj = iArr[0] == C0151az.s ? 1 : null;
        obj2 = iArr[iArr.length + -1] == -16777216 ? 1 : null;
        length = iArr.length;
        width = 0;
        i3 = 0;
        for (i2 = 0; i2 < length; i2++) {
            if (width != iArr[i2]) {
                i3++;
                a(byteArrayOutputStream, i2);
                width = iArr[i2];
            }
        }
        if (obj2 != null) {
            i3++;
            a(byteArrayOutputStream, iArr.length);
        }
        i5 = i3 + 1;
        i = obj != null ? i5 - 1 : i5;
        if (obj2 != null) {
            i--;
        }
        for (i5 = 0; i5 < i6 * i; i5++) {
            a(byteArrayOutputStream, 1);
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        toByteArray[0] = (byte) 1;
        toByteArray[1] = (byte) i4;
        toByteArray[2] = (byte) i3;
        toByteArray[3] = (byte) (i * i6);
        a(bitmap, toByteArray);
        return toByteArray;
    }

    private static Bitmap b(Context context, String str) {
        InputStream open = s.a(context).open(str);
        Bitmap a = a(open);
        open.close();
        return a;
    }
}
