package cn.com.smartdevices.bracelet.ui;

import android.content.Context;
import android.os.Message;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.j.n;
import com.d.a.a.h;
import java.io.File;
import org.apache.http.Header;

class dL extends h {
    final /* synthetic */ Context a;
    final /* synthetic */ File b;
    final /* synthetic */ dE c;

    dL(dE dEVar, Context context, File file) {
        this.c = dEVar;
        this.a = context;
        this.b = file;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e("WPJ", "onFailure");
        if (this.c.m != null) {
            Message message = new Message();
            message.what = 3;
            message.obj = Boolean.valueOf(false);
            this.c.m.sendMessage(message);
            if (this.b != null && this.b.exists()) {
                this.b.delete();
            }
        }
    }

    public void onProgress(int i, int i2) {
        if (this.c.m != null) {
            Message message = new Message();
            message.what = 2;
            message.arg1 = (i * 100) / i2;
            this.c.m.sendMessage(message);
        }
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        C0596r.e("WPJ", "onSuccess:" + new String(bArr));
        if (this.c.m != null) {
            Message message = new Message();
            message.what = 3;
            if (bArr == null || !n.a(this.a, new String(bArr)).c()) {
                message.obj = Boolean.valueOf(false);
            } else {
                message.obj = Boolean.valueOf(true);
            }
            this.c.m.sendMessage(message);
            if (this.b != null && this.b.exists()) {
                this.b.delete();
            }
        }
    }
}
