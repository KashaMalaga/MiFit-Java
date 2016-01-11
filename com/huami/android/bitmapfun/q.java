package com.huami.android.bitmapfun;

import cn.com.smartdevices.bracelet.ui.dW;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

final class q {
    final /* synthetic */ m a;
    private final String b;
    private final long[] c;
    private boolean d;
    private o e;
    private long f;

    private q(m mVar, String str) {
        this.a = mVar;
        this.b = str;
        this.c = new long[mVar.q];
    }

    private void a(String[] strArr) {
        if (strArr.length != this.a.q) {
            throw b(strArr);
        }
        int i = 0;
        while (i < strArr.length) {
            try {
                this.c[i] = Long.parseLong(strArr[i]);
                i++;
            } catch (NumberFormatException e) {
                throw b(strArr);
            }
        }
    }

    private IOException b(String[] strArr) {
        throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
    }

    public File a(int i) {
        return new File(this.a.l, this.b + "." + i);
    }

    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        for (long append : this.c) {
            stringBuilder.append(' ').append(append);
        }
        return stringBuilder.toString();
    }

    public File b(int i) {
        return new File(this.a.l, this.b + "." + i + dW.c);
    }
}
