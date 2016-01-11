package com.d.a.a;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class E implements Runnable {
    final /* synthetic */ Object a;
    final /* synthetic */ D b;

    E(D d, Object obj) {
        this.b = d;
        this.a = obj;
    }

    public void run() {
        if (this.a instanceof JSONObject) {
            this.b.e.a(this.b.b, this.b.c, this.b.d, (JSONObject) this.a);
        } else if (this.a instanceof JSONArray) {
            this.b.e.a(this.b.b, this.b.c, this.b.d, (JSONArray) this.a);
        } else if (this.a instanceof String) {
            this.b.e.onFailure(this.b.b, this.b.c, (String) this.a, this.b.d);
        } else {
            this.b.e.a(this.b.b, this.b.c, new JSONException("Unexpected response type " + this.a.getClass().getName()), (JSONObject) null);
        }
    }
}
