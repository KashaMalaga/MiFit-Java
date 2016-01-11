package com.f.a.c;

import com.f.a.a.a.b;
import java.io.File;

public final class a {
    private a() {
    }

    public static File a(String str, b bVar) {
        File a = bVar.a(str);
        return (a == null || !a.exists()) ? null : a;
    }

    public static boolean b(String str, b bVar) {
        File a = bVar.a(str);
        return a != null && a.exists() && a.delete();
    }
}
