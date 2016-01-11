package com.d.a.a;

import org.json.JSONException;
import org.json.JSONObject;

class F implements Runnable {
    final /* synthetic */ JSONException a;
    final /* synthetic */ D b;

    F(D d, JSONException jSONException) {
        this.b = d;
        this.a = jSONException;
    }

    public void run() {
        this.b.e.a(this.b.b, this.b.c, this.a, (JSONObject) null);
    }
}
