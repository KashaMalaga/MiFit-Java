package com.activeandroid.b;

import com.activeandroid.b;
import com.activeandroid.g;

public final class i implements h {
    private Class<? extends g> a;

    public i(Class<? extends g> cls) {
        this.a = cls;
    }

    public g a(String str) {
        return new g(this, str);
    }

    public g a(String str, Object... objArr) {
        return new g(this, str, objArr);
    }

    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE ");
        stringBuilder.append(b.c(this.a));
        stringBuilder.append(" ");
        return stringBuilder.toString();
    }

    Class<? extends g> b() {
        return this.a;
    }
}
