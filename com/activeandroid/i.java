package com.activeandroid;

import com.activeandroid.c.b;
import com.activeandroid.c.c;
import com.activeandroid.c.d;
import com.activeandroid.c.e;
import com.activeandroid.c.g;
import java.io.File;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;

class i extends HashMap<Class<?>, e> {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
        put(Calendar.class, new b());
        put(Date.class, new d());
        put(java.util.Date.class, new g());
        put(File.class, new c());
    }
}
