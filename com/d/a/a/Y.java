package com.d.a.a;

import android.util.Log;
import org.apache.http.Header;

public abstract class Y extends h {
    private static final String LOG_TAG = "TextHttpResponseHandler";

    public Y() {
        this(h.DEFAULT_CHARSET);
    }

    public Y(String str) {
        setCharset(str);
    }

    public static String getResponseString(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (Throwable e) {
            Log.e(LOG_TAG, "Encoding response into string failed", e);
            return null;
        }
    }

    public abstract void onFailure(int i, Header[] headerArr, String str, Throwable th);

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        onFailure(i, headerArr, getResponseString(bArr, getCharset()), th);
    }

    public abstract void onSuccess(int i, Header[] headerArr, String str);

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        onSuccess(i, headerArr, getResponseString(bArr, getCharset()));
    }
}
