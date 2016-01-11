package com.e.a;

import android.util.Log;
import com.e.b.d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class L implements Cloneable {
    private static final Q i = new C1049o();
    private static final Q j = new C1046m();
    private static Class[] k = new Class[]{Float.TYPE, Float.class, Double.TYPE, Integer.TYPE, Double.class, Integer.class};
    private static Class[] l = new Class[]{Integer.TYPE, Integer.class, Float.TYPE, Double.TYPE, Float.class, Double.class};
    private static Class[] m = new Class[]{Double.TYPE, Double.class, Float.TYPE, Integer.TYPE, Float.class, Integer.class};
    private static final HashMap<Class, HashMap<String, Method>> n = new HashMap();
    private static final HashMap<Class, HashMap<String, Method>> o = new HashMap();
    String a;
    protected d b;
    Method c;
    Class d;
    C1047u e;
    final ReentrantReadWriteLock f;
    final Object[] g;
    private Method h;
    private Q p;
    private Object q;

    private L(d dVar) {
        this.c = null;
        this.h = null;
        this.e = null;
        this.f = new ReentrantReadWriteLock();
        this.g = new Object[1];
        this.b = dVar;
        if (dVar != null) {
            this.a = dVar.b();
        }
    }

    private L(String str) {
        this.c = null;
        this.h = null;
        this.e = null;
        this.f = new ReentrantReadWriteLock();
        this.g = new Object[1];
        this.a = str;
    }

    public static <V> L a(d dVar, Q<V> q, V... vArr) {
        L l = new L(dVar);
        l.a((Object[]) vArr);
        l.a((Q) q);
        return l;
    }

    public static L a(d<?, Float> dVar, float... fArr) {
        return new M((d) dVar, fArr);
    }

    public static L a(d<?, Integer> dVar, int... iArr) {
        return new N((d) dVar, iArr);
    }

    public static L a(d dVar, C1051q... c1051qArr) {
        C1047u a = C1047u.a(c1051qArr);
        if (a instanceof C1050p) {
            return new N(dVar, (C1050p) a);
        }
        if (a instanceof C1048n) {
            return new M(dVar, (C1048n) a);
        }
        L l = new L(dVar);
        l.e = a;
        l.d = c1051qArr[0].e();
        return l;
    }

    public static L a(String str, Q q, Object... objArr) {
        L l = new L(str);
        l.a(objArr);
        l.a(q);
        return l;
    }

    public static L a(String str, float... fArr) {
        return new M(str, fArr);
    }

    public static L a(String str, int... iArr) {
        return new N(str, iArr);
    }

    public static L a(String str, C1051q... c1051qArr) {
        C1047u a = C1047u.a(c1051qArr);
        if (a instanceof C1050p) {
            return new N(str, (C1050p) a);
        }
        if (a instanceof C1048n) {
            return new M(str, (C1048n) a);
        }
        L l = new L(str);
        l.e = a;
        l.d = c1051qArr[0].e();
        return l;
    }

    static String a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        char toUpperCase = Character.toUpperCase(str2.charAt(0));
        return new StringBuilder(String.valueOf(str)).append(toUpperCase).append(str2.substring(1)).toString();
    }

    private Method a(Class cls, String str, Class cls2) {
        Method declaredMethod;
        Method method = null;
        String a = a(str, this.a);
        Class[] clsArr = null;
        if (cls2 == null) {
            try {
                return cls.getMethod(a, clsArr);
            } catch (NoSuchMethodException e) {
                try {
                    declaredMethod = cls.getDeclaredMethod(a, clsArr);
                    try {
                        declaredMethod.setAccessible(true);
                        return declaredMethod;
                    } catch (NoSuchMethodException e2) {
                        Log.e("PropertyValuesHolder", "Couldn't find no-arg method for property " + this.a + ": " + e);
                        return declaredMethod;
                    }
                } catch (NoSuchMethodException e3) {
                    declaredMethod = null;
                    Log.e("PropertyValuesHolder", "Couldn't find no-arg method for property " + this.a + ": " + e);
                    return declaredMethod;
                }
            }
        }
        Class[] clsArr2 = new Class[1];
        clsArr = this.d.equals(Float.class) ? k : this.d.equals(Integer.class) ? l : this.d.equals(Double.class) ? m : new Class[]{this.d};
        int length = clsArr.length;
        int i = 0;
        while (i < length) {
            Class cls3 = clsArr[i];
            clsArr2[0] = cls3;
            try {
                method = cls.getMethod(a, clsArr2);
                this.d = cls3;
                return method;
            } catch (NoSuchMethodException e4) {
                try {
                    method = cls.getDeclaredMethod(a, clsArr2);
                    method.setAccessible(true);
                    this.d = cls3;
                    return method;
                } catch (NoSuchMethodException e5) {
                    i++;
                }
            }
        }
        Log.e("PropertyValuesHolder", "Couldn't find setter/getter for property " + this.a + " with value type " + this.d);
        return method;
    }

    private Method a(Class cls, HashMap<Class, HashMap<String, Method>> hashMap, String str, Class cls2) {
        Method method = null;
        try {
            Method method2;
            this.f.writeLock().lock();
            HashMap hashMap2 = (HashMap) hashMap.get(cls);
            if (hashMap2 != null) {
                method = (Method) hashMap2.get(this.a);
            }
            if (method == null) {
                method = a(cls, str, cls2);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap();
                    hashMap.put(cls, hashMap2);
                }
                hashMap2.put(this.a, method);
                method2 = method;
            } else {
                method2 = method;
            }
            this.f.writeLock().unlock();
            return method2;
        } catch (Throwable th) {
            this.f.writeLock().unlock();
        }
    }

    private void a(Object obj, C1051q c1051q) {
        if (this.b != null) {
            c1051q.a(this.b.a(obj));
        }
        try {
            if (this.h == null) {
                b(obj.getClass());
            }
            c1051q.a(this.h.invoke(obj, new Object[0]));
        } catch (InvocationTargetException e) {
            Log.e("PropertyValuesHolder", e.toString());
        } catch (IllegalAccessException e2) {
            Log.e("PropertyValuesHolder", e2.toString());
        }
    }

    private void b(Class cls) {
        this.h = a(cls, o, "get", null);
    }

    public L a() {
        try {
            L l = (L) super.clone();
            l.a = this.a;
            l.b = this.b;
            l.e = this.e.b();
            l.p = this.p;
            return l;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    void a(float f) {
        this.q = this.e.a(f);
    }

    public void a(Q q) {
        this.p = q;
        this.e.a(q);
    }

    public void a(d dVar) {
        this.b = dVar;
    }

    void a(Class cls) {
        this.c = a(cls, n, "set", this.d);
    }

    void a(Object obj) {
        C1051q c1051q;
        if (this.b != null) {
            try {
                this.b.a(obj);
                Iterator it = this.e.e.iterator();
                while (it.hasNext()) {
                    c1051q = (C1051q) it.next();
                    if (!c1051q.a()) {
                        c1051q.a(this.b.a(obj));
                    }
                }
                return;
            } catch (ClassCastException e) {
                Log.e("PropertyValuesHolder", "No such property (" + this.b.b() + ") on target object " + obj + ". Trying reflection instead");
                this.b = null;
            }
        }
        Class cls = obj.getClass();
        if (this.c == null) {
            a(cls);
        }
        Iterator it2 = this.e.e.iterator();
        while (it2.hasNext()) {
            c1051q = (C1051q) it2.next();
            if (!c1051q.a()) {
                if (this.h == null) {
                    b(cls);
                }
                try {
                    c1051q.a(this.h.invoke(obj, new Object[0]));
                } catch (InvocationTargetException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                } catch (IllegalAccessException e3) {
                    Log.e("PropertyValuesHolder", e3.toString());
                }
            }
        }
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(float... fArr) {
        this.d = Float.TYPE;
        this.e = C1047u.a(fArr);
    }

    public void a(int... iArr) {
        this.d = Integer.TYPE;
        this.e = C1047u.a(iArr);
    }

    public void a(C1051q... c1051qArr) {
        int i = 0;
        int length = c1051qArr.length;
        C1051q[] c1051qArr2 = new C1051q[Math.max(length, 2)];
        this.d = c1051qArr[0].e();
        while (i < length) {
            c1051qArr2[i] = c1051qArr[i];
            i++;
        }
        this.e = new C1047u(c1051qArr2);
    }

    public void a(Object... objArr) {
        this.d = objArr[0].getClass();
        this.e = C1047u.a(objArr);
    }

    void b() {
        if (this.p == null) {
            Q q = this.d == Integer.class ? i : this.d == Float.class ? j : null;
            this.p = q;
        }
        if (this.p != null) {
            this.e.a(this.p);
        }
    }

    void b(Object obj) {
        a(obj, (C1051q) this.e.e.get(0));
    }

    public String c() {
        return this.a;
    }

    void c(Object obj) {
        a(obj, (C1051q) this.e.e.get(this.e.e.size() - 1));
    }

    public /* synthetic */ Object clone() {
        return a();
    }

    Object d() {
        return this.q;
    }

    void d(Object obj) {
        if (this.b != null) {
            this.b.a(obj, d());
        }
        if (this.c != null) {
            try {
                this.g[0] = d();
                this.c.invoke(obj, this.g);
            } catch (InvocationTargetException e) {
                Log.e("PropertyValuesHolder", e.toString());
            } catch (IllegalAccessException e2) {
                Log.e("PropertyValuesHolder", e2.toString());
            }
        }
    }

    public String toString() {
        return this.a + ": " + this.e.toString();
    }
}
