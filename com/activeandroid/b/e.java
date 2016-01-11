package com.activeandroid.b;

import android.text.TextUtils;
import com.activeandroid.g;

public final class e implements h {
    private String[] a;
    private boolean b = false;
    private boolean c = false;

    public e(f... fVarArr) {
        int i = 0;
        int length = fVarArr.length;
        this.a = new String[length];
        while (i < length) {
            this.a[i] = fVarArr[i].a + " AS " + fVarArr[i].b;
            i++;
        }
    }

    public e(String... strArr) {
        this.a = strArr;
    }

    public b a(Class<? extends g> cls) {
        return new b(cls, this);
    }

    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT ");
        if (this.b) {
            stringBuilder.append("DISTINCT ");
        } else if (this.c) {
            stringBuilder.append("ALL ");
        }
        if (this.a == null || this.a.length <= 0) {
            stringBuilder.append("* ");
        } else {
            stringBuilder.append(TextUtils.join(", ", this.a) + " ");
        }
        return stringBuilder.toString();
    }

    public e b() {
        this.b = true;
        this.c = false;
        return this;
    }

    public e c() {
        this.b = false;
        this.c = true;
        return this;
    }
}
