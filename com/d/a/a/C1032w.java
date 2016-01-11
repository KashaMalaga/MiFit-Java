package com.d.a.a;

import android.util.Log;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;

public abstract class C1032w extends h {
    private static final String a = "BinaryHttpResponseHandler";
    private String[] b;

    public C1032w() {
        this.b = new String[]{"image/jpeg", "image/png"};
    }

    public C1032w(String[] strArr) {
        this.b = new String[]{"image/jpeg", "image/png"};
        if (strArr != null) {
            this.b = strArr;
        } else {
            Log.e(a, "Constructor passed allowedContentTypes was null !");
        }
    }

    public String[] a() {
        return this.b;
    }

    public abstract void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th);

    public abstract void onSuccess(int i, Header[] headerArr, byte[] bArr);

    public final void sendResponseMessage(HttpResponse httpResponse) {
        int i = 0;
        StatusLine statusLine = httpResponse.getStatusLine();
        Header[] headers = httpResponse.getHeaders("Content-Type");
        if (headers.length != 1) {
            sendFailureMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), null, new HttpResponseException(statusLine.getStatusCode(), "None, or more than one, Content-Type Header found!"));
            return;
        }
        Header header = headers[0];
        for (String str : a()) {
            try {
                if (Pattern.matches(str, header.getValue())) {
                    i = 1;
                }
            } catch (Throwable e) {
                Log.e(a, "Given pattern is not valid: " + str, e);
            }
        }
        if (i == 0) {
            sendFailureMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), null, new HttpResponseException(statusLine.getStatusCode(), "Content-Type not allowed!"));
        } else {
            super.sendResponseMessage(httpResponse);
        }
    }
}
