package cn.com.smartdevices.bracelet.relation;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.e.a;
import cn.com.smartdevices.bracelet.j.l;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.push.j;
import cn.com.smartdevices.bracelet.relation.db.Friend;
import cn.com.smartdevices.bracelet.relation.db.b;
import cn.com.smartdevices.bracelet.relation.db.d;
import cn.com.smartdevices.bracelet.relation.db.e;
import cn.com.smartdevices.bracelet.relation.db.f;
import cn.com.smartdevices.bracelet.relation.db.g;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import de.greenrobot.event.EventBus;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class A {
    public static final String a = "friendManager";
    private static A b = null;
    private static final String i = "relation";
    private static final String j = "user_guide";
    private Context c;
    private g d;
    private d e;
    private b f;
    private LoginData g;
    private EventBus h = EventBus.getDefault();

    private A(Context context) {
        this.c = context;
        e eVar = new e(context);
        this.d = eVar.b();
        this.e = eVar.c();
        this.f = eVar.d();
        this.g = a.f(context);
    }

    public static A a() {
        if (b == null) {
            synchronized (A.class) {
                if (b == null) {
                    b = new A(BraceletApp.a());
                }
            }
        }
        return b;
    }

    private void e(long j) {
        this.e.b(j);
        this.d.c(j);
        this.f.b("user_id=" + j, null);
    }

    public f a(long j, int i) {
        return i == 1 ? this.d.b(j) : this.d.a(j);
    }

    public List<Friend> a(int i, int i2) {
        return this.e.a(i, i2);
    }

    public void a(int i, int i2, boolean z, boolean z2, boolean z3) {
        a(i, i2, z, z2, z3, false);
    }

    public void a(int i, int i2, boolean z, boolean z2, boolean z3, boolean z4) {
        int i3;
        ArrayList arrayList = new ArrayList();
        if (z4) {
            i3 = i;
        } else {
            if (!z) {
                Collection a = this.e.a(i, i2);
                if (!(a == null || a.isEmpty())) {
                    arrayList.addAll(a);
                }
            }
            if (z2) {
                int size = arrayList.size();
                if (size > 0) {
                    this.h.post(new cn.com.smartdevices.bracelet.relation.b.e(0, z, size >= i2, z3, arrayList));
                    return;
                }
            }
            i3 = arrayList.size() + i;
        }
        l.a(this.g, (long) i3, i2, new B(this, z, arrayList, i2, z4, z3, i, z2));
    }

    public void a(long j) {
        l.e(this.g, j, new C(this));
    }

    public void a(long j, boolean z) {
        if (z) {
            l.a(this.g, j, 0, new G(this, j));
            return;
        }
        List a = this.f.a(j, 30);
        if (a != null) {
            cn.com.smartdevices.bracelet.relation.b.d dVar = new cn.com.smartdevices.bracelet.relation.b.d();
            dVar.a = true;
            dVar.c = j;
            dVar.b = a;
            this.h.post(dVar);
        }
    }

    public void a(Context context, long j) {
        f b = this.d.b(j);
        if (b == null || b.v != 0) {
            l.d(this.g, j, new I(this, j));
        } else {
            a(context, j, true);
        }
    }

    public void a(Context context, long j, String str) {
        l.a(this.g, j, str, new D(this, j, str, context));
    }

    public void a(Context context, long j, boolean z) {
        l.a(this.g, j, z, new E(this, z, context, j));
    }

    public void a(Context context, boolean z) {
        if (context == null) {
            throw new NullPointerException("context is null");
        }
        Editor edit = context.getSharedPreferences(i, WXMediaMessage.THUMB_LENGTH_LIMIT).edit();
        edit.putBoolean(j, z);
        edit.commit();
    }

    public void a(cn.com.smartdevices.bracelet.push.b bVar) {
        f a = this.d.a(bVar.n);
        C0596r.e(a, bVar.toString());
        if (a == null) {
            cn.com.smartdevices.bracelet.d.a.d fVar = new f();
            fVar.v = 0;
            fVar.q = bVar.n;
            fVar.r = bVar.o;
            fVar.u = 1;
            fVar.t = 0;
            fVar.s = System.currentTimeMillis();
            fVar.w = bVar.p;
            this.d.a(fVar);
            return;
        }
        a.r = bVar.o;
        a.s = System.currentTimeMillis();
        a.u++;
        a.v = 0;
        this.d.a(a);
    }

    public void a(cn.com.smartdevices.bracelet.push.e eVar) {
        f fVar = new f();
        fVar.t = 1;
        fVar.w = eVar.u;
        fVar.q = eVar.r;
        fVar.r = eVar.s;
        fVar.v = 0;
        fVar.u = 0;
        fVar.s = System.currentTimeMillis();
        if (!this.d.b(fVar)) {
            this.d.a((cn.com.smartdevices.bracelet.d.a.d) fVar);
        }
    }

    public void a(j jVar) {
        e(jVar.l);
    }

    public boolean a(Context context) {
        return context.getSharedPreferences(i, WXMediaMessage.THUMB_LENGTH_LIMIT).getBoolean(j, false);
    }

    public List<f> b(int i, int i2) {
        try {
            return this.d.a((long) i, (long) i2);
        } catch (SQLDataException e) {
            C0596r.a(a, e.getMessage());
            return null;
        }
    }

    public void b() {
        this.d.c();
        this.e.c();
        this.f.c();
        if (b != null) {
            b = null;
        }
    }

    public void b(long j) {
        this.d.c(j);
    }

    public void b(Context context, long j, boolean z) {
        C0401a.a(this.c, C0401a.gT);
        l.b(this.g, j, new F(this, context, j, z));
    }

    public void b(cn.com.smartdevices.bracelet.push.e eVar) {
        Friend friend;
        JSONException e;
        f fVar;
        if (!TextUtils.isEmpty(eVar.t)) {
            Friend a = this.e.a(eVar.r);
            if (a == null) {
                try {
                    JSONObject jSONObject = new JSONArray(eVar.t).getJSONObject(0);
                    friend = new Friend();
                    try {
                        friend.n = jSONObject.optLong(kankan.wheel.widget.a.n);
                        friend.o = jSONObject.optString(Friend.c);
                        friend.r = jSONObject.optInt(cn.com.smartdevices.bracelet.relation.db.a.c);
                        friend.s = jSONObject.optInt(Friend.f);
                        friend.p = jSONObject.optString(cn.com.smartdevices.bracelet.push.e.p);
                        friend.q = jSONObject.optInt("w");
                        friend.t = jSONObject.optInt("rlove");
                        friend.u = jSONObject.optInt("slove");
                        friend.v = jSONObject.optLong("update_ts") * 1000;
                        friend.x = jSONObject.optString(ParamKey.NICK);
                        friend.y = System.currentTimeMillis();
                    } catch (JSONException e2) {
                        e = e2;
                        C0596r.a(a, e.getMessage());
                        if (friend == null) {
                            this.e.b(friend);
                            fVar = new f();
                            fVar.w = friend.p;
                            fVar.t = 3;
                            fVar.q = friend.n;
                            fVar.r = friend.o;
                            fVar.v = 3;
                            fVar.u = 0;
                            fVar.s = System.currentTimeMillis();
                            this.d.c(fVar);
                        }
                    }
                } catch (JSONException e3) {
                    e = e3;
                    friend = a;
                    C0596r.a(a, e.getMessage());
                    if (friend == null) {
                        this.e.b(friend);
                        fVar = new f();
                        fVar.w = friend.p;
                        fVar.t = 3;
                        fVar.q = friend.n;
                        fVar.r = friend.o;
                        fVar.v = 3;
                        fVar.u = 0;
                        fVar.s = System.currentTimeMillis();
                        this.d.c(fVar);
                    }
                }
                if (friend == null) {
                    this.e.b(friend);
                    fVar = new f();
                    fVar.w = friend.p;
                    fVar.t = 3;
                    fVar.q = friend.n;
                    fVar.r = friend.o;
                    fVar.v = 3;
                    fVar.u = 0;
                    fVar.s = System.currentTimeMillis();
                    this.d.c(fVar);
                }
            }
        }
    }

    public List<Friend> c() {
        try {
            return this.e.b();
        } catch (SQLDataException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void c(long j) {
        l.c(this.g, j, new H(this, j));
    }

    public void c(cn.com.smartdevices.bracelet.push.e eVar) {
        f fVar = new f();
        fVar.w = eVar.u;
        fVar.t = 2;
        fVar.q = eVar.r;
        fVar.r = eVar.s;
        fVar.v = 2;
        fVar.u = 0;
        fVar.s = System.currentTimeMillis();
        this.d.c(fVar);
    }

    public Friend d(long j) {
        return this.e.a(j);
    }

    public List<f> d() {
        try {
            return this.d.b();
        } catch (SQLDataException e) {
            e.printStackTrace();
            return null;
        }
    }
}
