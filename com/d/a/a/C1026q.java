package com.d.a.a;

import android.util.Log;
import org.apache.http.Header;

class C1026q implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ Header[] c;
    final /* synthetic */ p d;

    C1026q(p pVar, String str, int i, Header[] headerArr) {
        this.d = pVar;
        this.a = str;
        this.b = i;
        this.c = headerArr;
    }

    public void run() {
        try {
            this.d.postRunnable(new C1027r(this, this.d.parseResponse(this.a, false)));
        } catch (Throwable th) {
            Log.d("BaseJsonHttpResponseHandler", "parseResponse thrown an problem", th);
            this.d.postRunnable(new C1028s(this, th));
        }
    }
}
