package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.opengl.GLUtils;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.v4.view.a.C0113o;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.mapcore.ai;
import com.amap.api.mapcore.n;
import com.amap.api.mapcore.t;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.WeightedLatLng;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.huami.android.widget.share.m;
import com.xiaomi.account.openauth.h;
import com.xiaomi.e.a;
import com.xiaomi.mipush.sdk.f;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPInputStream;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONObject;

public class u {
    static final int[] a = new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    static final double[] b = new double[]{7453.642d, 3742.9905d, 1873.333d, 936.89026d, 468.472d, 234.239d, 117.12d, 58.56d, 29.28d, 14.64d, 7.32d, 3.66d, 1.829d, 0.915d, 0.4575d, 0.228d, 0.1144d};

    public static double a(double d, double d2) {
        return d2 > 0.0d ? Math.log((1048576.0d * d) / d2) / Math.log(2.0d) : 0.0d;
    }

    public static double a(double d, double d2, double d3, double d4, double d5, double d6) {
        return ((d3 - d) * (d6 - d2)) - ((d5 - d) * (d4 - d2));
    }

    public static float a(double d, double d2, double d3, double d4) {
        if (d <= 0.0d) {
            return d2 > 0.0d ? (float) a(d2, d4) : 0.0f;
        } else {
            float a = (float) a(d, d3);
            return d2 > 0.0d ? (float) Math.min((double) a, a(d2, d4)) : a;
        }
    }

    public static float a(float f) {
        return f < 0.0f ? 0.0f : f > 45.0f ? 45.0f : f;
    }

    public static int a(int i) {
        int log = (int) (Math.log((double) i) / Math.log(2.0d));
        return (1 << log) >= i ? 1 << log : 1 << (log + 1);
    }

    public static int a(GL10 gl10, int i, Bitmap bitmap) {
        return a(gl10, i, bitmap, false);
    }

    public static int a(GL10 gl10, int i, Bitmap bitmap, boolean z) {
        int b = b(gl10, i, bitmap, z);
        bitmap.recycle();
        return b;
    }

    public static int a(GL10 gl10, Bitmap bitmap) {
        return a(gl10, bitmap, false);
    }

    public static int a(GL10 gl10, Bitmap bitmap, boolean z) {
        return a(gl10, 0, bitmap, z);
    }

    public static int a(Object[] objArr) {
        return Arrays.hashCode(objArr);
    }

    public static Bitmap a(Context context, String str) {
        try {
            InputStream open = s.a(context).open(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            open.close();
            return decodeStream;
        } catch (Throwable e) {
            az.a(e, "Util", "fromAsset");
            return null;
        }
    }

    public static Bitmap a(Bitmap bitmap, float f) {
        return bitmap == null ? null : Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) * f), (int) (((float) bitmap.getHeight()) * f), true);
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, bitmap.hasAlpha() ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public static Bitmap a(View view) {
        try {
            b(view);
            view.destroyDrawingCache();
            view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            return view.getDrawingCache().copy(Config.ARGB_8888, false);
        } catch (Throwable th) {
            az.a(th, "Utils", "getBitmapFromView");
            th.printStackTrace();
            return null;
        }
    }

    public static DPoint a(LatLng latLng) {
        double d = (latLng.longitude / 360.0d) + 0.5d;
        double sin = Math.sin(Math.toRadians(latLng.latitude));
        return new DPoint(d * WeightedLatLng.DEFAULT_INTENSITY, (((Math.log((WeightedLatLng.DEFAULT_INTENSITY + sin) / (WeightedLatLng.DEFAULT_INTENSITY - sin)) * 0.5d) / -6.283185307179586d) + 0.5d) * WeightedLatLng.DEFAULT_INTENSITY);
    }

    private static FPoint a(FPoint fPoint, FPoint fPoint2, FPoint fPoint3, FPoint fPoint4) {
        FPoint fPoint5 = new FPoint(0.0f, 0.0f);
        double d = (double) (((fPoint2.y - fPoint.y) * (fPoint.x - fPoint3.x)) - ((fPoint2.x - fPoint.x) * (fPoint.y - fPoint3.y)));
        double d2 = (double) (((fPoint2.y - fPoint.y) * (fPoint4.x - fPoint3.x)) - ((fPoint2.x - fPoint.x) * (fPoint4.y - fPoint3.y)));
        fPoint5.x = (float) (((double) fPoint3.x) + ((((double) (fPoint4.x - fPoint3.x)) * d) / d2));
        fPoint5.y = (float) (((d * ((double) (fPoint4.y - fPoint3.y))) / d2) + ((double) fPoint3.y));
        return fPoint5;
    }

    public static String a(Context context) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return context.getCacheDir().toString() + "/";
        }
        File file;
        File file2;
        if (MapsInitializer.sdcardDir == null || MapsInitializer.sdcardDir.equals(a.f)) {
            file = new File(Environment.getExternalStorageDirectory(), "amap");
            if (!file.exists()) {
                file.mkdir();
            }
            file2 = new File(file, "mini_mapv3");
            if (!file2.exists()) {
                file2.mkdir();
            }
            return file2.toString() + "/";
        }
        file2 = new File(MapsInitializer.sdcardDir);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        file = new File(file2, "mini_mapv3");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.toString() + "/";
    }

    public static String a(File file) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        Throwable e;
        FileInputStream fileInputStream2;
        BufferedReader bufferedReader2 = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, kankan.wheel.widget.a.bO));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        fileInputStream2 = fileInputStream;
                    } catch (IOException e3) {
                        e = e3;
                        bufferedReader2 = bufferedReader;
                    } catch (Throwable th) {
                        e = th;
                        bufferedReader2 = bufferedReader;
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e42) {
                                e42.printStackTrace();
                            }
                        }
                    } catch (Throwable th2) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e422) {
                        e422.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e6) {
                e = e6;
                bufferedReader = null;
                fileInputStream2 = fileInputStream;
                try {
                    az.a(e, "Util", "readFile fileNotFound");
                    e.printStackTrace();
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e4222) {
                            e4222.printStackTrace();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e42222) {
                                    e42222.printStackTrace();
                                }
                            }
                        } catch (Throwable th3) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e52) {
                                    e52.printStackTrace();
                                }
                            }
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e422222) {
                            e422222.printStackTrace();
                        }
                    }
                    return stringBuffer.toString();
                } catch (Throwable th4) {
                    e = th4;
                    fileInputStream = fileInputStream2;
                    bufferedReader2 = bufferedReader;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e522) {
                            e522.printStackTrace();
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e5222) {
                                    e5222.printStackTrace();
                                }
                            }
                        } catch (Throwable th5) {
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e52222) {
                                    e52222.printStackTrace();
                                }
                            }
                        }
                    }
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e522222) {
                            e522222.printStackTrace();
                        }
                    }
                    throw e;
                }
            } catch (IOException e7) {
                e = e7;
                try {
                    az.a(e, "Util", "readFile io");
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4222222) {
                            e4222222.printStackTrace();
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e42222222) {
                                    e42222222.printStackTrace();
                                }
                            }
                        } catch (Throwable th6) {
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e5222222) {
                                    e5222222.printStackTrace();
                                }
                            }
                        }
                    }
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e422222222) {
                            e422222222.printStackTrace();
                        }
                    }
                    return stringBuffer.toString();
                } catch (Throwable th7) {
                    e = th7;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    throw e;
                }
            }
        } catch (FileNotFoundException e8) {
            e = e8;
            bufferedReader = null;
            az.a(e, "Util", "readFile fileNotFound");
            e.printStackTrace();
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return stringBuffer.toString();
        } catch (IOException e9) {
            e = e9;
            fileInputStream = null;
            az.a(e, "Util", "readFile io");
            e.printStackTrace();
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            return stringBuffer.toString();
        } catch (Throwable th8) {
            e = th8;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw e;
        }
        return stringBuffer.toString();
    }

    public static String a(InputStream inputStream) {
        try {
            return new String(b(inputStream), kankan.wheel.widget.a.bO);
        } catch (Throwable th) {
            az.a(th, "Util", "decodeAssetResData");
            th.printStackTrace();
            return null;
        }
    }

    public static String a(String str, Object obj) {
        return str + "=" + String.valueOf(obj);
    }

    public static String a(String... strArr) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int length = strArr.length;
        int i2 = 0;
        while (i < length) {
            stringBuilder.append(strArr[i]);
            if (i2 != strArr.length - 1) {
                stringBuilder.append(f.i);
            }
            i2++;
            i++;
        }
        return stringBuilder.toString();
    }

    public static FloatBuffer a(float[] fArr) {
        try {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            asFloatBuffer.put(fArr);
            asFloatBuffer.position(0);
            return asFloatBuffer;
        } catch (Throwable th) {
            az.a(th, "Util", "makeFloatBuffer1");
            th.printStackTrace();
            return null;
        }
    }

    public static FloatBuffer a(float[] fArr, FloatBuffer floatBuffer) {
        try {
            floatBuffer.clear();
            floatBuffer.put(fArr);
            floatBuffer.position(0);
            return floatBuffer;
        } catch (Throwable th) {
            az.a(th, "Util", "makeFloatBuffer2");
            th.printStackTrace();
            return null;
        }
    }

    public static void a(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public static void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(LocationManagerProxy.KEY_STATUS_CHANGED)) {
                String string = jSONObject.getString(LocationManagerProxy.KEY_STATUS_CHANGED);
                if (string.equals("E6008")) {
                    throw new AMapException("key\u4e3a\u7a7a");
                } else if (string.equals("E6012")) {
                    throw new AMapException("key\u4e0d\u5b58\u5728");
                } else if (string.equals("E6018")) {
                    throw new AMapException("key\u88ab\u9501\u5b9a");
                }
            }
        } catch (Throwable e) {
            az.a(e, "Util", "paseAuthFailurJson");
            e.printStackTrace();
        }
    }

    public static void a(GL10 gl10, int i) {
        gl10.glDeleteTextures(1, new int[]{i}, 0);
    }

    public static boolean a() {
        return VERSION.SDK_INT >= 8;
    }

    public static boolean a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = ((d3 - d) * (d8 - d6)) - ((d4 - d2) * (d7 - d5));
        if (d9 == 0.0d) {
            return false;
        }
        double d10 = (((d2 - d6) * (d7 - d5)) - ((d - d5) * (d8 - d6))) / d9;
        d9 = (((d2 - d6) * (d3 - d)) - ((d - d5) * (d4 - d2))) / d9;
        return d10 >= 0.0d && d10 <= WeightedLatLng.DEFAULT_INTENSITY && d9 >= 0.0d && d9 <= WeightedLatLng.DEFAULT_INTENSITY;
    }

    public static boolean a(LatLng latLng, List<LatLng> list) {
        double d = latLng.longitude;
        double d2 = latLng.latitude;
        double d3 = latLng.latitude;
        if (list.size() < 3) {
            return false;
        }
        if (!((LatLng) list.get(0)).equals(list.get(list.size() - 1))) {
            list.add(list.get(0));
        }
        int i = 0;
        int i2 = 0;
        while (i < list.size() - 1) {
            double d4 = ((LatLng) list.get(i)).longitude;
            double d5 = ((LatLng) list.get(i)).latitude;
            double d6 = ((LatLng) list.get(i + 1)).longitude;
            double d7 = ((LatLng) list.get(i + 1)).latitude;
            if (b(d, d2, d4, d5, d6, d7)) {
                return true;
            }
            int i3;
            if (Math.abs(d7 - d5) < 1.0E-9d) {
                i3 = i2;
            } else {
                if (b(d4, d5, d, d2, 180.0d, d3)) {
                    if (d5 > d7) {
                        i3 = i2 + 1;
                    }
                } else if (b(d6, d7, d, d2, 180.0d, d3)) {
                    if (d7 > d5) {
                        i3 = i2 + 1;
                    }
                } else if (a(d4, d5, d6, d7, d, d2, 180.0d, d3)) {
                    i3 = i2 + 1;
                }
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        return i2 % 2 != 0;
    }

    private static boolean a(FPoint fPoint, FPoint fPoint2, FPoint fPoint3) {
        return ((double) (((fPoint3.x - fPoint2.x) * (fPoint.y - fPoint2.y)) - ((fPoint.x - fPoint2.x) * (fPoint3.y - fPoint2.y)))) >= 0.0d;
    }

    public static byte[] a(byte[] bArr) {
        Throwable th;
        GZIPInputStream gZIPInputStream;
        try {
            gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr, 0, bArr.length));
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr2 = new byte[C0113o.h];
                while (true) {
                    int read = gZIPInputStream.read(bArr2);
                    if (read <= -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                bArr = byteArrayOutputStream.toByteArray();
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (IOException e) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    az.a(th, "Util", "DataunZip");
                    th.printStackTrace();
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    return bArr;
                } catch (Throwable th3) {
                    th = th3;
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            gZIPInputStream = null;
            if (gZIPInputStream != null) {
                gZIPInputStream.close();
            }
            throw th;
        }
        return bArr;
    }

    public static float[] a(t tVar, List<IPoint> list) {
        int i = 0;
        List arrayList = new ArrayList();
        List<FPoint> b = b(tVar, (List) list);
        FPoint[] a = a(tVar);
        int i2 = 0;
        while (i2 < 4) {
            arrayList.clear();
            for (int i3 = 0; i3 < b.size() - 1; i3++) {
                FPoint fPoint = (FPoint) b.get(i3);
                FPoint fPoint2 = (FPoint) b.get(i3 + 1);
                if (i3 == 0 && a(fPoint, a[i2], a[(i2 + 1) % 4])) {
                    arrayList.add(fPoint);
                }
                if (a(fPoint, a[i2], a[(i2 + 1) % 4])) {
                    if (a(fPoint2, a[i2], a[(i2 + 1) % 4])) {
                        arrayList.add(fPoint2);
                    } else {
                        arrayList.add(a(a[i2], a[(i2 + 1) % 4], fPoint, fPoint2));
                    }
                } else if (a(fPoint2, a[i2], a[(i2 + 1) % 4])) {
                    arrayList.add(a(a[i2], a[(i2 + 1) % 4], fPoint, fPoint2));
                    arrayList.add(fPoint2);
                }
            }
            b.clear();
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                b.add(arrayList.get(i4));
            }
            byte b2 = (byte) (i2 + 1);
        }
        float[] fArr = new float[(b.size() * 3)];
        for (FPoint fPoint3 : b) {
            fArr[i * 3] = fPoint3.x;
            fArr[(i * 3) + 1] = fPoint3.y;
            fArr[(i * 3) + 2] = 0.0f;
            i++;
        }
        return fArr;
    }

    private static FPoint[] a(t tVar) {
        FPoint[] fPointArr = new FPoint[4];
        FPoint fPoint = new FPoint();
        tVar.a(-300, -300, fPoint);
        fPointArr[0] = fPoint;
        fPoint = new FPoint();
        tVar.a(tVar.h() + m.n, -300, fPoint);
        fPointArr[1] = fPoint;
        fPoint = new FPoint();
        tVar.a(tVar.h() + m.n, tVar.i() + m.n, fPoint);
        fPointArr[2] = fPoint;
        fPoint = new FPoint();
        tVar.a(-100, tVar.i() + m.n, fPoint);
        fPointArr[3] = fPoint;
        return fPointArr;
    }

    public static float b(float f) {
        return f > 20.0f ? 20.0f : f < 3.0f ? 3.0f : f;
    }

    public static int b(GL10 gl10, int i, Bitmap bitmap, boolean z) {
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        if (i == 0) {
            int[] iArr = new int[]{0};
            gl10.glGenTextures(1, iArr, 0);
            i = iArr[0];
        }
        gl10.glEnable(3553);
        gl10.glBindTexture(3553, i);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
        if (z) {
            gl10.glTexParameterf(3553, 10242, 10497.0f);
            gl10.glTexParameterf(3553, 10243, 10497.0f);
        } else {
            gl10.glTexParameterf(3553, 10242, 33071.0f);
            gl10.glTexParameterf(3553, 10243, 33071.0f);
        }
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        gl10.glDisable(3553);
        return i;
    }

    public static String b(int i) {
        return i < h.E ? i + "m" : (i / h.E) + "km";
    }

    public static String b(Context context) {
        String str = a.f;
        File file;
        if (MapsInitializer.sdcardDir == null || MapsInitializer.sdcardDir.equals(a.f)) {
            file = new File(Environment.getExternalStorageDirectory(), "amap");
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(file, "VMAP2");
            if (!file2.exists()) {
                file2.mkdir();
            }
            return file2.toString() + "/";
        }
        str = MapsInitializer.sdcardDir + "VMAP2/";
        file = new File(str);
        if (file.exists()) {
            return str;
        }
        file.mkdirs();
        return str;
    }

    private static List<FPoint> b(t tVar, List<IPoint> list) {
        List<FPoint> arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            FPoint fPoint = new FPoint();
            tVar.b(((IPoint) list.get(i)).y, ((IPoint) list.get(i)).x, fPoint);
            arrayList.add(fPoint);
        }
        return arrayList;
    }

    private static void b(View view) {
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                b(((ViewGroup) view).getChildAt(i));
            }
        } else if (view instanceof TextView) {
            ((TextView) view).setHorizontallyScrolling(false);
        }
    }

    public static boolean b() {
        return VERSION.SDK_INT >= 9;
    }

    public static boolean b(double d, double d2, double d3, double d4, double d5, double d6) {
        return Math.abs(a(d, d2, d3, d4, d5, d6)) < 1.0E-9d && (d - d3) * (d - d5) <= 0.0d && (d2 - d4) * (d2 - d6) <= 0.0d;
    }

    public static byte[] b(Context context, String str) {
        try {
            InputStream open = s.a(context).open(str);
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            return bArr;
        } catch (FileNotFoundException e) {
            Toast.makeText(ai.a, "Assets\u4e0b" + str + "\u4e0d\u5b58\u5728!", 0).show();
            e.printStackTrace();
            return new byte[0];
        } catch (Throwable th) {
            az.a(th, "Util", "decodeAssetResData");
            th.printStackTrace();
            return new byte[0];
        }
    }

    public static byte[] b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[C0113o.l];
        while (true) {
            int read = inputStream.read(bArr, 0, C0113o.l);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static boolean c() {
        return VERSION.SDK_INT >= 11;
    }

    public static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        State state = activeNetworkInfo.getState();
        return (state == null || state == State.DISCONNECTED || state == State.DISCONNECTING) ? false : true;
    }

    public static boolean d() {
        return VERSION.SDK_INT >= 12;
    }

    public static ad e() {
        try {
            if (n.e != null) {
                return n.e;
            }
            return new ad.a(n.b, "V2.4.1", n.c).a(new String[]{"com.amap.api.maps"}).a();
        } catch (Throwable th) {
            return null;
        }
    }
}
