package com.xiaomi.mipush.sdk;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.channel.a.b.c;
import java.util.ArrayList;
import java.util.List;

public class PushMessageHandler extends IntentService {
    private static List<g> a = new ArrayList();

    public PushMessageHandler() {
        super("mipush message handler");
    }

    protected static void a() {
        synchronized (a) {
            a.clear();
        }
    }

    public static void a(long j, String str, String str2) {
        synchronized (a) {
            for (g a : a) {
                a.a(j, str, str2);
            }
        }
    }

    public static void a(Context context, j jVar) {
        synchronized (a) {
            for (g gVar : a) {
                if (a(jVar.l(), gVar.a())) {
                    gVar.a(jVar.c(), jVar.d(), jVar.f(), jVar.i());
                    gVar.a(jVar);
                }
            }
        }
    }

    public static void a(Context context, k kVar) {
        String str = null;
        if (kVar instanceof j) {
            a(context, (j) kVar);
        } else if (kVar instanceof i) {
            i iVar = (i) kVar;
            String a = iVar.a();
            List b;
            if (f.a.equals(a)) {
                b = iVar.b();
                if (!(b == null || b.isEmpty())) {
                    str = (String) b.get(0);
                }
                a(iVar.c(), iVar.d(), str);
            } else if (f.b.equals(a) || f.c.equals(a) || f.h.equals(a)) {
                a(context, iVar.e(), a, iVar.c(), iVar.d(), iVar.b());
            } else if (f.f.equals(a)) {
                b = iVar.b();
                r5 = (b == null || b.isEmpty()) ? null : (String) b.get(0);
                a(context, iVar.e(), iVar.c(), iVar.d(), r5);
            } else if (f.g.equals(a)) {
                b = iVar.b();
                r5 = (b == null || b.isEmpty()) ? null : (String) b.get(0);
                b(context, iVar.e(), iVar.c(), iVar.d(), r5);
            }
        }
    }

    protected static void a(Context context, String str, long j, String str2, String str3) {
        synchronized (a) {
            for (g gVar : a) {
                if (a(str, gVar.a())) {
                    gVar.b(j, str2, str3);
                }
            }
        }
    }

    protected static void a(Context context, String str, String str2, long j, String str3, List<String> list) {
        synchronized (a) {
            for (g gVar : a) {
                if (a(str, gVar.a())) {
                    gVar.a(str2, j, str3, (List) list);
                }
            }
        }
    }

    protected static void a(g gVar) {
        synchronized (a) {
            if (!a.contains(gVar)) {
                a.add(gVar);
            }
        }
    }

    protected static boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.equals(str, str2);
    }

    protected static void b(Context context, String str, long j, String str2, String str3) {
        synchronized (a) {
            for (g gVar : a) {
                if (a(str, gVar.a())) {
                    gVar.c(j, str2, str3);
                }
            }
        }
    }

    public static boolean b() {
        return a.isEmpty();
    }

    protected void onHandleIntent(Intent intent) {
        if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
            if (m.a((Context) this).i()) {
                u.a((Context) this).a();
            }
        } else if (1 != l.a((Context) this)) {
            Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            try {
                List<ResolveInfo> queryBroadcastReceivers = getPackageManager().queryBroadcastReceivers(intent2, 32);
                intent2.setPackage(getPackageName());
                intent2.putExtras(intent);
                if (queryBroadcastReceivers != null) {
                    for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                        if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.packageName.equals(getPackageName())) {
                            break;
                        }
                    }
                }
                ResolveInfo resolveInfo2 = null;
                if (resolveInfo2 != null) {
                    ((PushMessageReceiver) Class.forName(resolveInfo2.activityInfo.name).newInstance()).onReceive(getApplicationContext(), intent2);
                } else {
                    c.c("cannot find the receiver to handler this message, check your manifest");
                }
            } catch (Exception e) {
            }
        } else if (b()) {
            c.c("receive a message before application calling initialize");
        } else {
            k a = s.a((Context) this).a(intent);
            if (a != null) {
                a((Context) this, a);
            }
        }
    }
}
