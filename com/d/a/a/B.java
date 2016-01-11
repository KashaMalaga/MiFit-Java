package com.d.a.a;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class B implements Runnable {
    final /* synthetic */ Object a;
    final /* synthetic */ A b;

    B(A a, Object obj) {
        this.b = a;
        this.a = obj;
    }

    public void run() {
        if (this.a instanceof JSONObject) {
            this.b.d.a(this.b.b, this.b.c, (JSONObject) this.a);
        } else if (this.a instanceof JSONArray) {
            this.b.d.a(this.b.b, this.b.c, (JSONArray) this.a);
        } else if (this.a instanceof String) {
            this.b.d.onFailure(this.b.b, this.b.c, (String) this.a, new JSONException("Response cannot be parsed as JSON data"));
        } else {
            this.b.d.a(this.b.b, this.b.c, new JSONException("Unexpected response type " + this.a.getClass().getName()), (JSONObject) null);
        }
    }
}
