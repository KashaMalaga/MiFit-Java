package com.tencent.connect.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.a.C0113o;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.model.ShareData;
import com.d.a.a.C1012a;
import com.tencent.open.a.f;
import com.tencent.open.utils.AsynLoadImgBack;
import com.tencent.open.utils.Util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class a {

    final class AnonymousClass1 extends Handler {
        final /* synthetic */ AsynLoadImgBack a;

        AnonymousClass1(Looper looper, AsynLoadImgBack asynLoadImgBack) {
            this.a = asynLoadImgBack;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case ShareData.SHARE_TYPE_LAB_ROPE_SKIPPING_ACCUMULATE /*101*/:
                    this.a.saved(0, (String) message.obj);
                    return;
                case ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD /*102*/:
                    this.a.saved(message.arg1, null);
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ Handler b;

        AnonymousClass2(String str, Handler handler) {
            this.a = str;
            this.b = handler;
        }

        public void run() {
            Bitmap a = a.a(this.a, 140);
            if (a != null) {
                String a2;
                String str = Environment.getExternalStorageDirectory() + "/tmp/";
                String str2 = "share2qq_temp" + Util.encrypt(this.a) + ".jpg";
                if (a.b(this.a, 140, 140)) {
                    f.b("AsynScaleCompressImage", "out of bound,compress!");
                    a2 = a.a(a, str, str2);
                } else {
                    f.b("AsynScaleCompressImage", "not out of bound,not compress!");
                    a2 = this.a;
                }
                f.b("AsynScaleCompressImage", "-->destFilePath: " + a2);
                if (a2 != null) {
                    Message obtainMessage = this.b.obtainMessage(ShareData.SHARE_TYPE_LAB_ROPE_SKIPPING_ACCUMULATE);
                    obtainMessage.obj = a2;
                    this.b.sendMessage(obtainMessage);
                    return;
                }
            }
            Message obtainMessage2 = this.b.obtainMessage(ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD);
            obtainMessage2.arg1 = 3;
            this.b.sendMessage(obtainMessage2);
        }
    }

    final class AnonymousClass3 extends Handler {
        final /* synthetic */ AsynLoadImgBack a;

        AnonymousClass3(Looper looper, AsynLoadImgBack asynLoadImgBack) {
            this.a = asynLoadImgBack;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case ShareData.SHARE_TYPE_LAB_ROPE_SKIPPING_ACCUMULATE /*101*/:
                    this.a.batchSaved(0, message.getData().getStringArrayList("images"));
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ ArrayList a;
        final /* synthetic */ Handler b;

        AnonymousClass4(ArrayList arrayList, Handler handler) {
            this.a = arrayList;
            this.b = handler;
        }

        public void run() {
            for (int i = 0; i < this.a.size(); i++) {
                Object obj = (String) this.a.get(i);
                if (!Util.isValidUrl(obj) && Util.fileExists(obj)) {
                    Bitmap a = a.a((String) obj, (int) C1012a.b);
                    if (a != null) {
                        String str = Environment.getExternalStorageDirectory() + "/tmp/";
                        String str2 = "share2qzone_temp" + Util.encrypt(obj) + ".jpg";
                        if (a.b((String) obj, 640, (int) C1012a.b)) {
                            f.b("AsynScaleCompressImage", "out of bound, compress!");
                            obj = a.a(a, str, str2);
                        } else {
                            f.b("AsynScaleCompressImage", "not out of bound,not compress!");
                        }
                        if (obj != null) {
                            this.a.set(i, obj);
                        }
                    }
                }
            }
            Message obtainMessage = this.b.obtainMessage(ShareData.SHARE_TYPE_LAB_ROPE_SKIPPING_ACCUMULATE);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("images", this.a);
            obtainMessage.setData(bundle);
            this.b.sendMessage(obtainMessage);
        }
    }

    public static final int a(Options options, int i, int i2) {
        int b = b(options, i, i2);
        if (b > 8) {
            return ((b + 7) / 8) * 8;
        }
        int i3 = 1;
        while (i3 < b) {
            i3 <<= 1;
        }
        return i3;
    }

    private static Bitmap a(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            width = height;
        }
        float f = ((float) i) / ((float) width);
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static final Bitmap a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        if (options.mCancel || options.outWidth == -1 || options.outHeight == -1) {
            return null;
        }
        Bitmap decodeFile;
        if (i2 <= i3) {
            i2 = i3;
        }
        options.inPreferredConfig = Config.RGB_565;
        if (i2 > i) {
            options.inSampleSize = a(options, -1, i * i);
        }
        options.inJustDecodeBounds = false;
        try {
            decodeFile = BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            decodeFile = null;
        }
        if (decodeFile == null) {
            return null;
        }
        i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i3 <= i4) {
            i3 = i4;
        }
        return i3 > i ? a(decodeFile, i) : decodeFile;
    }

    protected static final String a(Bitmap bitmap, String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        String stringBuffer = new StringBuffer(str).append(str2).toString();
        File file2 = new File(stringBuffer);
        if (file2.exists()) {
            file2.delete();
        }
        if (bitmap != null) {
            try {
                OutputStream fileOutputStream = new FileOutputStream(file2);
                bitmap.compress(CompressFormat.JPEG, 80, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                bitmap.recycle();
                return stringBuffer;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static final void a(Context context, String str, AsynLoadImgBack asynLoadImgBack) {
        f.b("AsynScaleCompressImage", "scaleCompressImage");
        if (TextUtils.isEmpty(str)) {
            asynLoadImgBack.saved(1, null);
        } else if (Util.hasSDCard()) {
            new Thread(new AnonymousClass2(str, new AnonymousClass1(context.getMainLooper(), asynLoadImgBack))).start();
        } else {
            asynLoadImgBack.saved(2, null);
        }
    }

    public static final void a(Context context, ArrayList<String> arrayList, AsynLoadImgBack asynLoadImgBack) {
        f.b("AsynScaleCompressImage", "batchScaleCompressImage");
        if (arrayList == null) {
            asynLoadImgBack.saved(1, null);
        } else {
            new Thread(new AnonymousClass4(arrayList, new AnonymousClass3(context.getMainLooper(), asynLoadImgBack))).start();
        }
    }

    private static int b(Options options, int i, int i2) {
        double d = (double) options.outWidth;
        double d2 = (double) options.outHeight;
        int ceil = i2 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d * d2) / ((double) i2)));
        int min = i == -1 ? C0113o.h : (int) Math.min(Math.floor(d / ((double) i)), Math.floor(d2 / ((double) i)));
        return min < ceil ? ceil : (i2 == -1 && i == -1) ? 1 : i != -1 ? min : ceil;
    }

    private static final boolean b(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (options.mCancel || options.outWidth == -1 || options.outHeight == -1) {
            return false;
        }
        int i5 = i3 > i4 ? i3 : i4;
        if (i3 >= i4) {
            i3 = i4;
        }
        f.b("AsynScaleCompressImage", "longSide=" + i5 + "shortSide=" + i3);
        options.inPreferredConfig = Config.RGB_565;
        return i5 > i2 || i3 > i;
    }
}
