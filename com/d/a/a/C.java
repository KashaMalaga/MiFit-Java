package com.d.a.a;

import org.json.JSONException;
import org.json.JSONObject;

class C implements Runnable {
    final /* synthetic */ JSONException a;
    final /* synthetic */ A b;

    C(A a, JSONException jSONException) {
        this.b = a;
        this.a = jSONException;
    }

    public void run() {
        this.b.d.a(this.b.b, this.b.c, this.a, (JSONObject) null);
    }
}
