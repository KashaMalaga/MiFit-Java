package com.activeandroid.c;

import java.io.File;

public final class c extends e {
    public Class<?> a() {
        return File.class;
    }

    public String a(Object obj) {
        return obj == null ? null : ((File) obj).toString();
    }

    public File b(Object obj) {
        return obj == null ? null : new File((String) obj);
    }

    public Class<?> b() {
        return String.class;
    }

    public /* synthetic */ Object c(Object obj) {
        return b(obj);
    }

    public /* synthetic */ Object d(Object obj) {
        return a(obj);
    }
}
