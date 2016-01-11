package com.d.a.a;

import org.apache.http.Header;
import org.json.JSONException;

class D implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ int b;
    final /* synthetic */ Header[] c;
    final /* synthetic */ Throwable d;
    final /* synthetic */ z e;

    D(z zVar, byte[] bArr, int i, Header[] headerArr, Throwable th) {
        this.e = zVar;
        this.a = bArr;
        this.b = i;
        this.c = headerArr;
        this.d = th;
    }

    public void run() {
        try {
            this.e.postRunnable(new E(this, this.e.a(this.a)));
        } catch (JSONException e) {
            this.e.postRunnable(new F(this, e));
        }
    }
}
