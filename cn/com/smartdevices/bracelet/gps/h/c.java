package cn.com.smartdevices.bracelet.gps.h;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class c {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 4;

    private c() {
    }

    public static int a(int i, int i2, int i3, int i4) {
        if (i <= i3 && i2 <= i4) {
            return a;
        }
        int round = Math.round(((float) i) / ((float) i3));
        int round2 = Math.round(((float) i2) / ((float) i4));
        return round2 >= round ? round2 : round;
    }

    public static int a(Options options, int i, int i2) {
        return a(options.outWidth, options.outHeight, i, i2);
    }

    private static Bitmap a(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = ((float) i) / ((float) width);
        float f2 = ((float) i2) / ((float) height);
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
    }

    public static Bitmap a(Bitmap bitmap, Bitmap bitmap2, int i) {
        boolean z = true;
        if ((i & b) != 0 && (i & a) != 0) {
            throw new IllegalArgumentException("combine indicator should not be both horizonal and vertical");
        } else if (bitmap == null && bitmap2 == null) {
            return null;
        } else {
            if (bitmap == null) {
                return bitmap2;
            }
            if (bitmap2 == null) {
                return bitmap;
            }
            Bitmap a;
            if ((i & b) != 0) {
                a = a(bitmap, bitmap2, (i & c) != 0);
            } else {
                a = null;
            }
            if ((i & a) != 0) {
                if ((i & c) == 0) {
                    z = false;
                }
                bitmap2 = b(bitmap, bitmap2, z);
            } else {
                bitmap2 = a;
            }
            return bitmap2 == null ? null : bitmap2;
        }
    }

    public static Bitmap a(Bitmap bitmap, Bitmap bitmap2, int i, int i2) {
        if (bitmap == null && bitmap2 == null) {
            return null;
        }
        if (bitmap == null) {
            return bitmap2;
        }
        if (bitmap2 == null) {
            return bitmap;
        }
        if (!bitmap.isMutable()) {
            Bitmap copy = bitmap.copy(Config.ARGB_8888, true);
            if (copy != null) {
                bitmap.recycle();
            }
            bitmap = copy;
        }
        Paint paint = new Paint();
        Canvas canvas = new Canvas(bitmap);
        canvas.drawBitmap(bitmap2, (float) i, (float) i2, paint);
        canvas.save(31);
        canvas.restore();
        return bitmap;
    }

    public static Bitmap a(Bitmap bitmap, Bitmap bitmap2, int i, int i2, int i3, int i4) {
        if (bitmap == null && bitmap2 == null) {
            return null;
        }
        if (bitmap == null) {
            return bitmap2;
        }
        if (bitmap2 == null) {
            return bitmap;
        }
        if (!bitmap.isMutable()) {
            Bitmap copy = bitmap.copy(Config.ARGB_8888, true);
            if (copy != null) {
                bitmap.recycle();
            }
            bitmap = copy;
        }
        new Canvas(bitmap).drawBitmap(bitmap2, (float) i, (float) i2, new Paint());
        bitmap2 = a(bitmap, i3, i4);
        if (bitmap == bitmap2) {
            return bitmap2;
        }
        bitmap.recycle();
        return bitmap2;
    }

    private static Bitmap a(Bitmap bitmap, Bitmap bitmap2, boolean z) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        int i;
        if (height == height2 || !z) {
            i = height2;
            height2 = width2;
            width2 = height;
            height = i;
        } else if (height > height2) {
            height2 = (int) ((((float) width2) * ((float) height)) / ((float) height2));
            width2 = height;
        } else {
            width = (int) ((((float) width) * ((float) height2)) / ((float) height));
            height = height2;
            i = height2;
            height2 = width2;
            width2 = i;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width + height2, Math.max(width2, height), Config.ARGB_8888);
        Paint paint = new Paint();
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, new Rect(0, 0, width, width2), new Rect(0, 0, width, width2), paint);
        canvas.drawBitmap(bitmap2, new Rect(0, 0, height2, height), new Rect(width, 0, height2 + width, height), paint);
        return createBitmap;
    }

    public static Bitmap a(byte[] bArr, int i, int i2) {
        int i3 = a;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        options.inPreferredConfig = Config.RGB_565;
        if (i4 > i2) {
            i3 = Math.round(((float) i4) / ((float) i2));
        }
        if (i5 / i3 > i) {
            i3 = Math.round(((float) i5) / ((float) i));
        }
        options.inSampleSize = i3;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public static boolean a(String str, Bitmap bitmap) {
        Throwable th;
        boolean z = false;
        if (!(TextUtils.isEmpty(str) || bitmap == null)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    z = bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Exception e2) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    return z;
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
            } catch (Exception e5) {
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return z;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        }
        return z;
    }

    public static boolean a(String str, Bitmap bitmap, int i) {
        FileOutputStream fileOutputStream;
        Throwable th;
        boolean z = false;
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                z = bitmap.compress(CompressFormat.JPEG, i, fileOutputStream);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                    }
                }
            } catch (Exception e2) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                return z;
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
        } catch (Exception e5) {
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
        return z;
    }

    private static Bitmap b(Bitmap bitmap, Bitmap bitmap2, boolean z) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        int i;
        if (width == width2 || !z) {
            i = width2;
            width2 = height;
            height = width;
            width = i;
        } else if (width > width2) {
            height2 = (int) ((((float) height2) * ((float) width)) / ((float) width2));
            width2 = height;
            height = width;
        } else {
            height = width2;
            i = (int) ((((float) height) * ((float) width2)) / ((float) width));
            width = width2;
            width2 = i;
        }
        Bitmap createBitmap = Bitmap.createBitmap(Math.max(height, width), width2 + height2, Config.ARGB_8888);
        Paint paint = new Paint();
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, new Rect(0, 0, height, width2), new Rect(0, 0, height, width2), paint);
        canvas.drawBitmap(bitmap2, new Rect(0, 0, width, height2), new Rect(0, width2, width, height2 + width2), paint);
        return createBitmap;
    }
}
