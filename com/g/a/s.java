package com.g.a;

import android.content.Context;
import android.text.TextUtils;
import b.a.C0362d;
import b.a.C0365dJ;
import b.a.C0366dK;
import b.a.C0367dL;
import b.a.bX;
import b.a.dC;
import b.a.dD;
import b.a.dP;
import b.a.dx;
import com.g.a.b.b;
import com.xiaomi.e.a;
import java.util.HashMap;
import java.util.Map;

public class s implements C0365dJ {
    private final b a = new b();
    private Context b = null;
    private r c;
    private dC d = new dC();
    private dP e = new dP();
    private C0367dL f = new C0367dL();
    private dD g;
    private dx h;
    private boolean i = false;

    s() {
        this.d.a((C0365dJ) this);
    }

    private void f(Context context) {
        if (!this.i) {
            this.b = context.getApplicationContext();
            this.g = new dD(this.b);
            this.h = dx.a(this.b);
            this.i = true;
        }
    }

    private void g(Context context) {
        this.f.c(context);
        if (this.c != null) {
            this.c.a();
        }
    }

    private void h(Context context) {
        this.f.d(context);
        this.e.a(context);
        if (this.c != null) {
            this.c.b();
        }
        this.h.b();
    }

    public void a(int i) {
        C1059a.c = i;
    }

    void a(Context context) {
        if (context == null) {
            bX.b(p.e, "unexpected null context in onResume");
            return;
        }
        this.a.a(context);
        try {
            dx.a(context).a(this.a);
        } catch (Exception e) {
        }
    }

    void a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (context == null) {
                bX.b(p.e, "unexpected null context in reportError");
                return;
            }
            try {
                if (!this.i) {
                    f(context);
                }
                this.h.a(new C0362d(str).a(false));
            } catch (Exception e) {
                bX.b(p.e, a.f, e);
            }
        }
    }

    void a(Context context, String str, String str2) {
        try {
            if (!this.i) {
                f(context);
            }
            z.a(new v(this, str, str2));
        } catch (Exception e) {
            bX.b(p.e, a.f, e);
        }
    }

    public void a(Context context, String str, String str2, long j, int i) {
        try {
            if (!this.i) {
                f(context);
            }
            this.g.a(str, str2, j, i);
        } catch (Exception e) {
            bX.b(p.e, a.f, e);
        }
    }

    public void a(Context context, String str, HashMap<String, Object> hashMap) {
        try {
            if (!this.i) {
                f(context);
            }
            this.g.a(str, (Map) hashMap);
        } catch (Exception e) {
            bX.b(p.e, a.f, e);
        }
    }

    void a(Context context, String str, HashMap<String, Object> hashMap, String str2) {
        try {
            if (!this.i) {
                f(context);
            }
            z.a(new x(this, str, hashMap, str2));
        } catch (Exception e) {
            bX.b(p.e, a.f, e);
        }
    }

    void a(Context context, String str, Map<String, Object> map, long j) {
        try {
            if (!this.i) {
                f(context);
            }
            this.g.a(str, (Map) map, j);
        } catch (Exception e) {
            bX.b(p.e, a.f, e);
        }
    }

    void a(Context context, Throwable th) {
        if (context != null && th != null) {
            try {
                if (!this.i) {
                    f(context);
                }
                this.h.a(new C0362d(th).a(false));
            } catch (Exception e) {
                bX.b(p.e, a.f, e);
            }
        }
    }

    void a(com.g.a.b.a aVar) {
        this.a.a(aVar);
    }

    public void a(r rVar) {
        this.c = rVar;
    }

    void a(String str) {
        if (!C1059a.j) {
            try {
                this.e.a(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(String str, String str2) {
        C1059a.a = str;
        C1059a.b = str2;
    }

    public void a(Throwable th) {
        try {
            this.e.a();
            if (this.b != null) {
                if (!(th == null || this.h == null)) {
                    this.h.b(new C0362d(th));
                }
                h(this.b);
                C0366dK.a(this.b).edit().commit();
            }
            z.a();
        } catch (Exception e) {
            bX.a(p.e, "Exception in onAppCrash", e);
        }
    }

    void b(Context context) {
        if (context == null) {
            bX.b(p.e, "unexpected null context in onResume");
            return;
        }
        if (C1059a.j) {
            this.e.a(context.getClass().getName());
        }
        try {
            if (!this.i) {
                f(context);
            }
            z.a(new t(this, context));
        } catch (Exception e) {
            bX.b(p.e, "Exception occurred in Mobclick.onResume(). ", e);
        }
    }

    void b(Context context, String str, String str2) {
        try {
            z.a(new w(this, str, str2));
        } catch (Exception e) {
            bX.b(p.e, a.f, e);
        }
    }

    void b(String str) {
        if (!C1059a.j) {
            try {
                this.e.b(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void c(Context context) {
        if (context == null) {
            bX.b(p.e, "unexpected null context in onPause");
            return;
        }
        if (C1059a.j) {
            this.e.b(context.getClass().getName());
        }
        try {
            if (!this.i) {
                f(context);
            }
            z.a(new u(this, context));
        } catch (Exception e) {
            bX.b(p.e, "Exception occurred in Mobclick.onRause(). ", e);
        }
    }

    void c(Context context, String str, String str2) {
        try {
            z.a(new y(this, str, str2));
        } catch (Exception e) {
            bX.b(p.e, a.f, e);
        }
    }

    void d(Context context) {
        try {
            if (!this.i) {
                f(context);
            }
            this.h.a();
        } catch (Exception e) {
            bX.b(p.e, a.f, e);
        }
    }

    void e(Context context) {
        try {
            this.e.a();
            h(context);
            C0366dK.a(context).edit().commit();
            z.a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
