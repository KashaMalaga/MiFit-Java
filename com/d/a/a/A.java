package com.d.a.a;

import org.apache.http.Header;
import org.json.JSONException;

class A implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ int b;
    final /* synthetic */ Header[] c;
    final /* synthetic */ z d;

    A(z zVar, byte[] bArr, int i, Header[] headerArr) {
        this.d = zVar;
        this.a = bArr;
        this.b = i;
        this.c = headerArr;
    }

    public void run() {
        try {
            this.d.postRunnable(new B(this, this.d.a(this.a)));
        } catch (JSONException e) {
            this.d.postRunnable(new C(this, e));
        }
    }
}
