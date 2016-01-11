package cn.com.smartdevices.bracelet.ui;

import android.app.ProgressDialog;
import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.model.RunningReminderInfo;
import cn.com.smartdevices.bracelet.upgrade.OtaVersionInfo;
import com.activeandroid.b;
import com.d.a.a.C0781y;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import org.apache.http.Header;

public class C0782ec extends C0781y {
    private static final char[] i = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private final dW c;
    private final Context d;
    private final File e;
    private final OtaVersionInfo f;
    private boolean g;
    private ProgressDialog h;

    public C0782ec(dW dWVar, Context context, File file, OtaVersionInfo otaVersionInfo) {
        super(file);
        this.c = dWVar;
        this.d = context;
        this.e = file;
        this.f = otaVersionInfo;
        b(context);
    }

    public static String a(File file) {
        String str = null;
        if (file.isFile()) {
            byte[] bArr = new byte[b.a];
            try {
                InputStream fileInputStream = new FileInputStream(file);
                MessageDigest instance = MessageDigest.getInstance("MD5");
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                fileInputStream.close();
                str = C0782ec.a(instance.digest());
            } catch (Exception e) {
            }
        }
        return str;
    }

    public static String a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            stringBuilder.append(i[(b & RunningReminderInfo.b) >>> 4]);
            stringBuilder.append(i[b & 15]);
        }
        return stringBuilder.toString();
    }

    private void a(int i) {
        if (this.h != null) {
            this.h.setProgress(i);
        }
    }

    private void b(Context context) {
        if (this.h == null) {
            this.h = new ProgressDialog(context);
            this.h.setMax(100);
            this.h.setProgress(0);
            this.h.setTitle("\u56fa\u4ef6\u4e0b\u8f7d");
            this.h.setMessage("\u4e0b\u8f7d\u8fdb\u5ea6");
            this.h.setProgressStyle(1);
            this.h.setIndeterminate(false);
            this.h.setCancelable(true);
            this.h.setOnCancelListener(new C0783ed(this));
        }
    }

    private void c() {
        if (this.h != null) {
            this.h.dismiss();
        }
    }

    private void d() {
        if (this.h != null) {
            this.h.show();
        }
    }

    public void a(int i, Header[] headerArr, File file) {
        C0596r.e("Setting.Firmware", "Download On Success!!");
        if (headerArr != null) {
            for (Header header : headerArr) {
                C0596r.e("Setting.Firmware", header.getName() + " : " + header.getValue());
            }
        }
        if (!this.g) {
            String path = this.e.getPath();
            File file2 = new File(path.substring(0, path.length() - dW.c.length()));
            if (file2.exists()) {
                file2.delete();
            }
            this.e.renameTo(file2);
            C0596r.e("Setting.Firmware", "FirmwareFile : " + file2 + " , " + file2.exists() + " , " + file2.length());
            path = C0782ec.a(file2);
            C0596r.e("Setting.Firmware", "FirmwareMd5 : " + path);
            if (path.equalsIgnoreCase(this.f.f)) {
                this.c.a();
            } else {
                com.huami.android.view.b.a(this.d, "\u56fa\u4ef6\u6821\u9a8c\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5", 0).show();
            }
        }
    }

    public void a(int i, Header[] headerArr, Throwable th, File file) {
        C0596r.g("Setting.Firmware", "Download On Failure : " + this.e.getPath());
        C0596r.g("Setting.Firmware", th.toString());
        if (headerArr != null) {
            for (Header header : headerArr) {
                C0596r.e("Setting.Firmware", header.getName() + " : " + header.getValue());
            }
        }
        if (!this.g) {
            c();
            com.huami.android.view.b.a(this.d, "\u4e0b\u8f7d\u56fa\u4ef6\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5", 0).show();
        }
    }

    public void onFinish() {
        C0596r.e("Setting.Firmware", "Download On Finish!!");
        if (this.e.exists()) {
            this.e.delete();
        }
        c();
    }

    public void onProgress(int i, int i2) {
        C0596r.e("Setting.Firmware", "Download On Progress : " + i + " Total : " + i2);
        a((int) ((((float) i) / ((float) i2)) * CropOverlayView.a));
    }

    public void onStart() {
        super.onStart();
        C0596r.e("Setting.Firmware", "Download On Start!!");
        d();
    }
}
