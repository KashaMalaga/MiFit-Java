package com.d.a.a;

import android.util.Log;
import org.apache.http.Header;

class C1029t implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ Header[] c;
    final /* synthetic */ Throwable d;
    final /* synthetic */ p e;

    C1029t(p pVar, String str, int i, Header[] headerArr, Throwable th) {
        this.e = pVar;
        this.a = str;
        this.b = i;
        this.c = headerArr;
        this.d = th;
    }

    public void run() {
        try {
            this.e.postRunnable(new C1030u(this, this.e.parseResponse(this.a, true)));
        } catch (Throwable th) {
            Log.d("BaseJsonHttpResponseHandler", "parseResponse thrown an problem", th);
            this.e.postRunnable(new C1031v(this));
        }
    }
}
