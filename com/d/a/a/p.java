package com.d.a.a;

import org.apache.http.Header;

public abstract class p<JSON_TYPE> extends Y {
    private static final String LOG_TAG = "BaseJsonHttpResponseHandler";

    public p() {
        this(h.DEFAULT_CHARSET);
    }

    public p(String str) {
        super(str);
    }

    public final void onFailure(int i, Header[] headerArr, String str, Throwable th) {
        if (str != null) {
            Runnable c1029t = new C1029t(this, str, i, headerArr, th);
            if (getUseSynchronousMode()) {
                c1029t.run();
                return;
            } else {
                new Thread(c1029t).start();
                return;
            }
        }
        onFailure(i, headerArr, th, null, null);
    }

    public abstract void onFailure(int i, Header[] headerArr, Throwable th, String str, JSON_TYPE json_type);

    public final void onSuccess(int i, Header[] headerArr, String str) {
        if (i != 204) {
            Runnable c1026q = new C1026q(this, str, i, headerArr);
            if (getUseSynchronousMode()) {
                c1026q.run();
                return;
            } else {
                new Thread(c1026q).start();
                return;
            }
        }
        onSuccess(i, headerArr, null, null);
    }

    public abstract void onSuccess(int i, Header[] headerArr, String str, JSON_TYPE json_type);

    protected abstract JSON_TYPE parseResponse(String str, boolean z);
}
