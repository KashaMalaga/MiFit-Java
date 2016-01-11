package com.huami.android.zxing;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.c.b.a;
import com.c.b.e;
import com.c.b.s;
import com.huami.android.zxing.a.g;
import java.util.Collection;
import java.util.Map;

public final class d extends Handler {
    private static final String a = d.class.getSimpleName();
    private final CaptureActivity b;
    private final k c;
    private e d = e.SUCCESS;
    private final g e;

    d(CaptureActivity captureActivity, Collection<a> collection, Map<e, ?> map, String str, g gVar) {
        this.b = captureActivity;
        this.c = new k(captureActivity, collection, map, str, new A(captureActivity.b()));
        this.c.start();
        this.e = gVar;
        gVar.c();
        b();
    }

    private void b() {
        if (this.d == e.SUCCESS) {
            this.d = e.PREVIEW;
            this.e.a(this.c.a(), (int) l.f);
            this.b.h();
        }
    }

    public void a() {
        this.d = e.DONE;
        Message.obtain(this.c.a(), l.g).sendToTarget();
        try {
            this.c.join(500);
        } catch (InterruptedException e) {
        }
        removeMessages(l.b);
        removeMessages(l.c);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case l.a /*65537*/:
                b();
                return;
            case l.b /*65538*/:
                this.d = e.SUCCESS;
                this.b.a((s) message.obj);
                return;
            case l.c /*65539*/:
                this.d = e.PREVIEW;
                if (message.arg1 == l.h) {
                    this.b.i();
                    Toast.makeText(this.b, "\u89e3\u7801\u9519\u8bef", 0).show();
                }
                this.e.a(this.c.a(), (int) l.f);
                this.b.g();
                return;
            case l.d /*65540*/:
                this.b.setResult(-1, (Intent) message.obj);
                this.b.finish();
                return;
            case l.h /*65544*/:
                Message obtain = Message.obtain(this.c.a(), l.h);
                obtain.obj = message.obj;
                obtain.sendToTarget();
                return;
            default:
                return;
        }
    }
}
