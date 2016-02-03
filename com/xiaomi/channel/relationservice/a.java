package com.xiaomi.channel.relationservice;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.channel.b.x;
import com.xiaomi.channel.relationservice.a.a.d;
import com.xiaomi.channel.relationservice.data.BuddyData;
import java.util.ArrayList;
import java.util.List;

public class a {
    static final int a = 1200;
    public static final String b = "action_on_buddy_data_setected";
    private static final String c = "RelationServiceClient";
    private static a d;
    private d e;
    private final Object f = new Object();
    private Context g;
    private BroadcastReceiver h = new b(this);
    private com.xiaomi.channel.relationservice.data.d i;
    private ServiceConnection j = new c(this);

    private a(Context context) {
        if (context != null) {
            try {
                this.g = context.getApplicationContext();
                f();
                context.registerReceiver(this.h, new IntentFilter(b));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Bundle a(ContentValues contentValues) {
        Bundle bundle = new Bundle();
        for (String str : contentValues.keySet()) {
            Object obj = contentValues.get(str);
            if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Long) {
                bundle.putLong(str, Long.valueOf(String.valueOf(obj)).longValue());
            } else if (obj instanceof Integer) {
                bundle.putInt(str, Integer.valueOf(String.valueOf(obj)).intValue());
            }
        }
        return bundle;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (d == null) {
                d = new a(context);
            }
            aVar = d;
        }
        return aVar;
    }

    private void f() {
        synchronized (this.f) {
            try {
                if (this.e == null) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName("com.xiaomi.channel", "com.xiaomi.channel.relationservice.RelationService"));
                    this.g.bindService(intent, this.j, 1);
                    Log.d(c, "RelationService::bindService");
                    try {
                        this.f.wait(20000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private d g() {
        return a() ? this.e : null;
    }

    private int h() {
        return !x.d(this.g) ? com.xiaomi.channel.gamesdk.a.a : !x.a(this.g, a) ? com.xiaomi.channel.gamesdk.a.b : !a() ? com.xiaomi.channel.gamesdk.a.e : 0;
    }

    public int a(ContentValues contentValues, String str, String[] strArr) {
        int i = 0;
        if (contentValues == null || !a()) {
            return 0;
        }
        List arrayList = new ArrayList();
        arrayList.add(a(contentValues));
        int i2 = com.xiaomi.channel.relationservice.data.a.a;
        if (arrayList.size() <= i2) {
            return g().a(str, strArr, arrayList);
        }
        int i3 = 0;
        do {
            i3 += g().a(str, strArr, arrayList.subList(i, i + i2 > arrayList.size() ? arrayList.size() : i + i2));
            i += i2;
        } while (i < arrayList.size());
        return i3;
    }

    public int a(com.xiaomi.channel.relationservice.data.d dVar) {
        int h = h();
        if (h != 0 || dVar == null) {
            return h;
        }
        try {
            CharSequence d = this.e.d();
            dVar.c = d;
            if (TextUtils.isEmpty(d)) {
                return h;
            }
            this.i = dVar;
            return 0;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int a(String str, String[] strArr, List<Bundle> list) {
        if (a()) {
            try {
                return this.e.a(str, strArr, list);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public String a(String str) {
        if (!TextUtils.isEmpty(str) && a()) {
            try {
                return this.e.a(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return com.xiaomi.e.a.f;
    }

    public List<BuddyData> a(String str, String[] strArr, String str2, String str3, String str4, String str5) {
        if (a()) {
            try {
                return this.e.a(str, strArr, str2, str3, str4, str5);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void a(com.xiaomi.channel.relationservice.a.a.a aVar) {
        if (a()) {
            try {
                this.e.a(aVar);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean a() {
        if (this.e != null) {
            return true;
        }
        f();
        return this.e != null;
    }

    public boolean a(Bundle bundle) {
        if (bundle != null && a()) {
            try {
                return this.e.a(bundle);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean a(BuddyData buddyData) {
        if (a()) {
            try {
                return this.e.a(buddyData);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && a()) {
            try {
                return this.e.a(str, str2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean a(List<BuddyData> list) {
        if (a() && list != null) {
            try {
                int i = com.xiaomi.channel.relationservice.data.a.a;
                if (list.size() <= i) {
                    return this.e.a((List) list);
                }
                int i2 = 0;
                int i3 = 1;
                while (true) {
                    boolean a = this.e.a(list.subList(i2, i2 + i > list.size() ? list.size() : i2 + i)) & i3;
                    i2 += i;
                    if (i2 >= list.size()) {
                        return a;
                    }
                    boolean z = a;
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public int b(List<String> list) {
        if (a()) {
            try {
                return this.e.b((List) list);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public BuddyData b(String str) {
        if (h() == 0) {
            try {
                return this.e.b(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void b(com.xiaomi.channel.relationservice.a.a.a aVar) {
        if (a()) {
            try {
                this.e.b(aVar);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean b() {
        if (a()) {
            try {
                return this.e.a();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public int c() {
        if (a()) {
            try {
                return this.e.b();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public boolean c(List<String> list) {
        if (list != null && a()) {
            try {
                return this.e.c(list);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean d() {
        if (a()) {
            try {
                return this.e.c();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void e() {
        this.g.unbindService(this.j);
        this.g.unregisterReceiver(this.h);
        d = null;
    }
}
