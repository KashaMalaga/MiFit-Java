package com.activeandroid;

import android.content.Context;
import com.activeandroid.c.e;
import com.activeandroid.d.b;
import com.activeandroid.d.d;
import com.xiaomi.e.a;
import dalvik.system.DexFile;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class h {
    private Map<Class<? extends g>, j> a = new HashMap();
    private Map<Class<?>, e> b = new i(this);

    public h(c cVar) {
        if (!a(cVar)) {
            try {
                a(cVar.a());
            } catch (Throwable e) {
                b.e("Couldn't open source path.", e);
            }
        }
        b.c("ModelInfo loaded.");
    }

    private void a(Context context) {
        String packageName = context.getPackageName();
        String str = context.getApplicationInfo().sourceDir;
        List<String> arrayList = new ArrayList();
        if (str == null || new File(str).isDirectory()) {
            Enumeration resources = Thread.currentThread().getContextClassLoader().getResources(a.f);
            while (resources.hasMoreElements()) {
                str = ((URL) resources.nextElement()).getFile();
                if (str.contains("bin") || str.contains("classes")) {
                    arrayList.add(str);
                }
            }
        } else {
            Enumeration entries = new DexFile(str).entries();
            while (entries.hasMoreElements()) {
                arrayList.add(entries.nextElement());
            }
        }
        for (String str2 : arrayList) {
            a(new File(str2), packageName, context.getClassLoader());
        }
    }

    private void a(File file, String str, ClassLoader classLoader) {
        if (file.isDirectory()) {
            for (File a : file.listFiles()) {
                a(a, str, classLoader);
            }
            return;
        }
        String name = file.getName();
        if (!file.getPath().equals(name)) {
            name = file.getPath();
            if (name.endsWith(".class")) {
                name = name.substring(0, name.length() - 6).replace(System.getProperty("file.separator"), ".");
                int lastIndexOf = name.lastIndexOf(str);
                if (lastIndexOf >= 0) {
                    name = name.substring(lastIndexOf);
                } else {
                    return;
                }
            }
            return;
        }
        try {
            Class cls = Class.forName(name, false, classLoader);
            if (d.a(cls)) {
                this.a.put(cls, new j(cls));
            } else if (d.b(cls)) {
                e eVar = (e) cls.newInstance();
                this.b.put(eVar.a(), eVar);
            }
        } catch (Throwable e) {
            b.e("Couldn't create class.", e);
        } catch (Throwable e2) {
            b.e("Couldn't instantiate TypeSerializer.", e2);
        } catch (Throwable e22) {
            b.e("IllegalAccessException", e22);
        }
    }

    private boolean a(c cVar) {
        if (!cVar.h()) {
            return false;
        }
        List<Class> e = cVar.e();
        if (e != null) {
            for (Class cls : e) {
                this.a.put(cls, new j(cls));
            }
        }
        e = cVar.f();
        if (e != null) {
            for (Class cls2 : e) {
                try {
                    e eVar = (e) cls2.newInstance();
                    this.b.put(eVar.a(), eVar);
                } catch (Throwable e2) {
                    b.e("Couldn't instantiate TypeSerializer.", e2);
                } catch (Throwable e22) {
                    b.e("IllegalAccessException", e22);
                }
            }
        }
        return true;
    }

    public j a(Class<? extends g> cls) {
        return (j) this.a.get(cls);
    }

    public Collection<j> a() {
        return this.a.values();
    }

    public e b(Class<?> cls) {
        return (e) this.b.get(cls);
    }
}
