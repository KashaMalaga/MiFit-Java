package com.huami.android.view;

public abstract class h {
    public g a(String str) {
        for (g gVar : a()) {
            if (gVar.a().equals(str)) {
                return gVar;
            }
        }
        return null;
    }

    public abstract g[] a();
}
