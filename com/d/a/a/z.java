package com.d.a.a;

import android.util.Log;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class z extends Y {
    private static final String a = "JsonHttpResponseHandler";

    public z() {
        super(h.DEFAULT_CHARSET);
    }

    public z(String str) {
        super(str);
    }

    protected Object a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        String str;
        Object nextValue;
        String responseString = Y.getResponseString(bArr, getCharset());
        if (responseString != null) {
            responseString = responseString.trim();
            if (responseString.startsWith("{") || responseString.startsWith("[")) {
                str = responseString;
                nextValue = new JSONTokener(responseString).nextValue();
                Object obj = str;
                return nextValue == null ? nextValue : obj;
            }
        }
        str = responseString;
        nextValue = null;
        String str2 = str;
        if (nextValue == null) {
        }
    }

    public void a(int i, Header[] headerArr, Throwable th, JSONArray jSONArray) {
    }

    public void a(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
    }

    public void a(int i, Header[] headerArr, JSONArray jSONArray) {
    }

    public void a(int i, Header[] headerArr, JSONObject jSONObject) {
    }

    public void onFailure(int i, Header[] headerArr, String str, Throwable th) {
    }

    public final void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        if (bArr != null) {
            Runnable d = new D(this, bArr, i, headerArr, th);
            if (getUseSynchronousMode()) {
                d.run();
                return;
            } else {
                new Thread(d).start();
                return;
            }
        }
        Log.v(a, "response body is null, calling onFailure(Throwable, JSONObject)");
        a(i, headerArr, th, (JSONObject) null);
    }

    public void onSuccess(int i, Header[] headerArr, String str) {
    }

    public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        if (i != 204) {
            Runnable a = new A(this, bArr, i, headerArr);
            if (getUseSynchronousMode()) {
                a.run();
                return;
            } else {
                new Thread(a).start();
                return;
            }
        }
        a(i, headerArr, new JSONObject());
    }
}
