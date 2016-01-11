package com.activeandroid.b;

import com.activeandroid.d.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class g implements h {
    private i a;
    private String b;
    private String c;
    private List<Object> d = new ArrayList();
    private List<Object> e = new ArrayList();

    public g(i iVar, String str) {
        this.a = iVar;
        this.b = str;
    }

    public g(i iVar, String str, Object... objArr) {
        this.a = iVar;
        this.b = str;
        this.d.addAll(Arrays.asList(objArr));
    }

    public g a(String str) {
        this.c = str;
        this.e.clear();
        return this;
    }

    public g a(String str, Object... objArr) {
        this.c = str;
        this.e.clear();
        this.e.addAll(Arrays.asList(objArr));
        return this;
    }

    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.a());
        stringBuilder.append("SET ");
        stringBuilder.append(this.b);
        stringBuilder.append(" ");
        if (this.c != null) {
            stringBuilder.append("WHERE ");
            stringBuilder.append(this.c);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public void b() {
        f.a(a(), c());
    }

    public String[] c() {
        int i = 0;
        int size = this.d.size();
        int size2 = this.e.size();
        String[] strArr = new String[(size + size2)];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = this.d.get(i2).toString();
        }
        while (i < size2) {
            strArr[i + size] = this.e.get(i).toString();
            i++;
        }
        return strArr;
    }
}
