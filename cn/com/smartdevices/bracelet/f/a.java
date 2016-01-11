package cn.com.smartdevices.bracelet.f;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.activeandroid.b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class a {
    private a() {
    }

    public static Bitmap a(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
        int i = 100;
        while (byteArrayOutputStream.toByteArray().length / b.a > 100) {
            byteArrayOutputStream.reset();
            bitmap.compress(CompressFormat.JPEG, i, byteArrayOutputStream);
            i -= 20;
        }
        return BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, null);
    }

    public static Bitmap a(String str) {
        int i = 1;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        i2 = (i2 <= i3 || ((float) i2) <= 480.0f) ? (i2 >= i3 || ((float) i3) <= 800.0f) ? 1 : (int) (((float) options.outHeight) / 800.0f) : (int) (((float) options.outWidth) / 480.0f);
        if (i2 > 0) {
            i = i2;
        }
        options.inSampleSize = i;
        return a(BitmapFactory.decodeFile(str, options));
    }

    public static Bitmap b(Bitmap bitmap) {
        int i = 1;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
        if (byteArrayOutputStream.toByteArray().length / b.a > b.a) {
            byteArrayOutputStream.reset();
            bitmap.compress(CompressFormat.JPEG, 50, byteArrayOutputStream);
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(byteArrayInputStream, null, options);
        options.inJustDecodeBounds = false;
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        i2 = (i2 <= i3 || ((float) i2) <= 480.0f) ? (i2 >= i3 || ((float) i3) <= 800.0f) ? 1 : (int) (((float) options.outHeight) / 800.0f) : (int) (((float) options.outWidth) / 480.0f);
        if (i2 > 0) {
            i = i2;
        }
        options.inSampleSize = i;
        return a(BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, options));
    }
}
