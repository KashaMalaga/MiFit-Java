package cn.com.smartdevices.bracelet.shoes.sync;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.model.e;
import com.d.a.a.h;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.http.Header;

final class Q extends h {
    final /* synthetic */ File a;
    final /* synthetic */ R b;
    final /* synthetic */ e c;

    Q(File file, R r, e eVar) {
        this.a = file;
        this.b = r;
        this.c = eVar;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e(B.a, "onFailure statusCode = " + i);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        Exception e;
        Throwable th;
        FileOutputStream fileOutputStream = null;
        try {
            if (this.a.exists()) {
                this.a.delete();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(this.a);
            try {
                fileOutputStream2.write(bArr);
                this.b.a = this.a.getAbsolutePath();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e2) {
                    }
                }
                if (TextUtils.isEmpty(this.b.a)) {
                    C0596r.e(B.a, "Failed to sync shoes icon shoes = " + this.c.toString());
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = fileOutputStream2;
                try {
                    C0596r.e(B.a, "write exception: " + e.getMessage());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    if (TextUtils.isEmpty(this.b.a)) {
                        C0596r.e(B.a, "Failed to sync shoes icon shoes = " + this.c.toString());
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (TextUtils.isEmpty(this.b.a)) {
                        C0596r.e(B.a, "Failed to sync shoes icon shoes = " + this.c.toString());
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (TextUtils.isEmpty(this.b.a)) {
                    C0596r.e(B.a, "Failed to sync shoes icon shoes = " + this.c.toString());
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            C0596r.e(B.a, "write exception: " + e.getMessage());
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (TextUtils.isEmpty(this.b.a)) {
                C0596r.e(B.a, "Failed to sync shoes icon shoes = " + this.c.toString());
            }
        }
    }
}
