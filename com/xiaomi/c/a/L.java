package com.xiaomi.c.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.xiaomi.account.openauth.h;
import com.xiaomi.channel.a.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kankan.wheel.widget.a;

public final class L {
    static final /* synthetic */ boolean a = (!L.class.desiredAssertionStatus());
    private static final int b = Integer.getInteger(L.class.getName() + ".emptyRequestDelay", 100).intValue();
    private static final int c = Integer.getInteger(L.class.getName() + ".pauseMargin", a.aB).intValue();
    private static final boolean d;
    private Context A;
    private final Set<S> e = new CopyOnWriteArraySet();
    private final Set<T> f = new CopyOnWriteArraySet();
    private final Set<U> g = new CopyOnWriteArraySet();
    private final ReentrantLock h = new ReentrantLock();
    private final Condition i = this.h.newCondition();
    private final Condition j = this.h.newCondition();
    private final Condition k = this.h.newCondition();
    private long l = 0;
    private final O m;
    private final Runnable n = new M(this);
    private final C1085p o = new x();
    private final C1087r p = new C1087r();
    private final ScheduledExecutorService q = Executors.newSingleThreadScheduledExecutor();
    private ThreadPoolExecutor r;
    private ScheduledFuture<?> s;
    private C1077i t;
    private Queue<C1083n> u = new LinkedList();
    private SortedSet<Long> v = new TreeSet();
    private Long w = Long.valueOf(-1);
    private List<C1079j> x = new ArrayList();
    private volatile long y = 0;
    private volatile long z = 0;

    static {
        boolean z = true;
        String str = L.class.getSimpleName() + ".assertionsEnabled";
        if (System.getProperty(str) != null) {
            z = Boolean.getBoolean(str);
        } else if (a) {
            z = false;
        }
        d = z;
    }

    private L(O o, Context context) {
        this.m = o;
        this.A = context.getApplicationContext();
        c();
    }

    public static L a(O o, Context context) {
        if (o != null) {
            return new L(o, context);
        }
        throw new IllegalArgumentException("Client configuration may not be null");
    }

    private C1079j a(long j, C1079j c1079j) {
        k();
        C1081l b = c1079j.b();
        b.a(K.w, this.m.b());
        b.a(K.A, this.m.d());
        b.a(K.y, I.b().toString());
        b.a(K.z, "300");
        b.a(K.h, Constants.VIA_TO_TYPE_QQ_GROUP);
        b.a(K.q, Long.toString(j));
        a(b);
        b(b);
        b.a(K.c, Constants.VIA_TO_TYPE_QQ_GROUP);
        b.a(K.t, null);
        return b.a();
    }

    private C1089t a(int i, C1078u c1078u) {
        k();
        return a(c1078u) ? C1089t.a(c1078u.a(K.e)) : (this.t == null || this.t.c() != null) ? null : C1089t.a(i);
    }

    private void a(long j) {
        k();
        if (j < 0) {
            throw new IllegalArgumentException("Empty request delay must be >= 0 (was: " + j + ")");
        }
        h();
        if (d()) {
            c.b("SMACK-BOSH: Scheduling empty request in " + j + "ms");
            try {
                this.s = this.q.schedule(this.n, j, TimeUnit.MILLISECONDS);
            } catch (Throwable e) {
                c.a("SMACK-BOSH: Could not schedule empty request", e);
            }
        }
    }

    private void a(C1081l c1081l) {
        k();
        String e = this.m.e();
        if (e != null) {
            c1081l.a(K.r, e);
        }
    }

    private void a(C1083n c1083n) {
        this.u.add(c1083n);
        this.r.execute(new N(this));
    }

    private void a(C1078u c1078u, int i) {
        C1089t a = a(i, c1078u);
        if (a != null) {
            throw new C1070b("Terminal binding condition encountered: " + a.a() + "  (" + a.b() + ")");
        }
    }

    private void a(C1078u c1078u, C1078u c1078u2) {
        k();
        if (this.t.f() && c1078u2.a(K.o) == null) {
            String a = c1078u2.a(K.c);
            Long valueOf = a == null ? Long.valueOf(Long.parseLong(c1078u.a(K.q))) : Long.valueOf(Long.parseLong(a));
            Iterator it = this.x.iterator();
            while (it.hasNext()) {
                if (Long.valueOf(Long.parseLong(((C1078u) it.next()).a(K.q))).compareTo(valueOf) <= 0) {
                    it.remove();
                }
            }
        }
    }

    private void a(Throwable th) {
        l();
        this.h.lock();
        try {
            if (this.r != null) {
                this.r.shutdownNow();
                this.r = null;
                this.h.unlock();
                if (th == null) {
                    n();
                } else {
                    b(th);
                }
                this.h.lock();
                try {
                    h();
                    this.u = null;
                    this.t = null;
                    this.v = null;
                    this.x = null;
                    this.i.signalAll();
                    this.j.signalAll();
                    this.k.signalAll();
                    this.o.a();
                } finally {
                    this.h.unlock();
                }
            }
        } finally {
            this.h.unlock();
        }
    }

    private static boolean a(C1078u c1078u) {
        return "terminate".equals(c1078u.a(K.x));
    }

    private C1079j b(long j, C1079j c1079j) {
        k();
        C1081l b = c1079j.b();
        b.a(K.t, this.t.a().toString());
        b.a(K.q, Long.toString(j));
        return b.a();
    }

    private void b(C1081l c1081l) {
        k();
        String c = this.m.c();
        if (c != null) {
            c1081l.a(K.g, c);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(com.xiaomi.c.a.C1083n r11) {
        /*
        r10 = this;
        r0 = 0;
        r8 = 0;
        r10.l();
        r1 = r11.b();	 Catch:{ b -> 0x0083, InterruptedException -> 0x008d }
        r2 = r1.b();	 Catch:{ b -> 0x0083, InterruptedException -> 0x008d }
        r3 = r1.a();	 Catch:{ b -> 0x0083, InterruptedException -> 0x008d }
        r4 = r10.h;
        r4.lock();
        r4 = r1.c();	 Catch:{ InterruptedException -> 0x010d }
        r6 = r10.y;	 Catch:{ InterruptedException -> 0x010d }
        r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r1 != 0) goto L_0x0025;
    L_0x0021:
        r6 = 0;
        r10.y = r6;	 Catch:{ InterruptedException -> 0x010d }
    L_0x0025:
        r6 = r10.l;	 Catch:{ InterruptedException -> 0x010d }
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 > 0) goto L_0x0097;
    L_0x002b:
        r1 = r10.k;	 Catch:{ InterruptedException -> 0x010d }
        r1.signalAll();	 Catch:{ InterruptedException -> 0x010d }
    L_0x0030:
        r4 = r10.l;	 Catch:{ InterruptedException -> 0x010d }
        r6 = 1;
        r4 = r4 + r6;
        r10.l = r4;	 Catch:{ InterruptedException -> 0x010d }
        r1 = r10.h;
        r1.unlock();
        r10.g(r2);
        r4 = r11.a();
        r1 = r10.h;
        r1.lock();
        r1 = r10.d();	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        if (r1 != 0) goto L_0x012d;
    L_0x004e:
        r0 = r10.h;	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r0.unlock();	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r0 = r10.h;
        r0 = r0.isHeldByCurrentThread();
        if (r0 == 0) goto L_0x0126;
    L_0x005b:
        r0 = r10.u;	 Catch:{ all -> 0x011f }
        if (r0 == 0) goto L_0x0078;
    L_0x005f:
        r0 = r10.u;	 Catch:{ all -> 0x011f }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x011f }
        if (r0 == 0) goto L_0x0078;
    L_0x0067:
        r0 = r10.g();	 Catch:{ all -> 0x011f }
        if (r0 != 0) goto L_0x0078;
    L_0x006d:
        r0 = r10.c(r4);	 Catch:{ all -> 0x011f }
        r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r2 <= 0) goto L_0x0078;
    L_0x0075:
        r10.a(r0);	 Catch:{ all -> 0x011f }
    L_0x0078:
        r0 = r10.j;	 Catch:{ all -> 0x011f }
        r0.signalAll();	 Catch:{ all -> 0x011f }
        r0 = r10.h;
        r0.unlock();
    L_0x0082:
        return;
    L_0x0083:
        r0 = move-exception;
        r1 = "SMACK-BOSH: Could not obtain response";
        com.xiaomi.channel.a.b.c.a(r1, r0);
        r10.a(r0);
        goto L_0x0082;
    L_0x008d:
        r0 = move-exception;
        r1 = "Interrupted";
        com.xiaomi.channel.a.b.c.a(r1, r0);
        r10.a(r0);
        goto L_0x0082;
    L_0x0097:
        r1 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x010d }
        r1.<init>();	 Catch:{ InterruptedException -> 0x010d }
        r6 = "SMACK-BOSH: responded rid(";
        r1 = r1.append(r6);	 Catch:{ InterruptedException -> 0x010d }
        r1 = r1.append(r4);	 Catch:{ InterruptedException -> 0x010d }
        r4 = ") is not expected (";
        r1 = r1.append(r4);	 Catch:{ InterruptedException -> 0x010d }
        r4 = r10.l;	 Catch:{ InterruptedException -> 0x010d }
        r1 = r1.append(r4);	 Catch:{ InterruptedException -> 0x010d }
        r4 = "), wait";
        r1 = r1.append(r4);	 Catch:{ InterruptedException -> 0x010d }
        r1 = r1.toString();	 Catch:{ InterruptedException -> 0x010d }
        com.xiaomi.channel.a.b.c.b(r1);	 Catch:{ InterruptedException -> 0x010d }
        r1 = r10.k;	 Catch:{ InterruptedException -> 0x010d }
        r4 = 30;
        r6 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x010d }
        r1 = r1.await(r4, r6);	 Catch:{ InterruptedException -> 0x010d }
        if (r1 != 0) goto L_0x0030;
    L_0x00cb:
        r0 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x010d }
        r0.<init>();	 Catch:{ InterruptedException -> 0x010d }
        r1 = "SMACK-BOSH: wait for ";
        r0 = r0.append(r1);	 Catch:{ InterruptedException -> 0x010d }
        r2 = r10.l;	 Catch:{ InterruptedException -> 0x010d }
        r0 = r0.append(r2);	 Catch:{ InterruptedException -> 0x010d }
        r1 = " timeout, terminate!";
        r0 = r0.append(r1);	 Catch:{ InterruptedException -> 0x010d }
        r0 = r0.toString();	 Catch:{ InterruptedException -> 0x010d }
        com.xiaomi.channel.a.b.c.c(r0);	 Catch:{ InterruptedException -> 0x010d }
        r0 = new com.xiaomi.c.a.b;	 Catch:{ InterruptedException -> 0x010d }
        r1 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x010d }
        r1.<init>();	 Catch:{ InterruptedException -> 0x010d }
        r2 = "wait timeout for rid";
        r1 = r1.append(r2);	 Catch:{ InterruptedException -> 0x010d }
        r2 = r10.l;	 Catch:{ InterruptedException -> 0x010d }
        r1 = r1.append(r2);	 Catch:{ InterruptedException -> 0x010d }
        r1 = r1.toString();	 Catch:{ InterruptedException -> 0x010d }
        r0.<init>(r1);	 Catch:{ InterruptedException -> 0x010d }
        r10.a(r0);	 Catch:{ InterruptedException -> 0x010d }
        r0 = r10.h;
        r0.unlock();
        goto L_0x0082;
    L_0x010d:
        r0 = move-exception;
        r10.a(r0);	 Catch:{ all -> 0x0118 }
        r0 = r10.h;
        r0.unlock();
        goto L_0x0082;
    L_0x0118:
        r0 = move-exception;
        r1 = r10.h;
        r1.unlock();
        throw r0;
    L_0x011f:
        r0 = move-exception;
        r1 = r10.h;
        r1.unlock();
        throw r0;
    L_0x0126:
        r0 = "SMACK-BOSH: lock is not held by this thread, don't schedule empty request";
        com.xiaomi.channel.a.b.c.b(r0);
        goto L_0x0082;
    L_0x012d:
        r1 = r10.t;	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        if (r1 != 0) goto L_0x013a;
    L_0x0131:
        r1 = com.xiaomi.c.a.C1077i.a(r4, r2);	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r10.t = r1;	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r10.m();	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
    L_0x013a:
        r5 = r10.t;	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r10.a(r2, r3);	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r1 = a(r2);	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        if (r1 == 0) goto L_0x018d;
    L_0x0145:
        r0 = r10.h;	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r0.unlock();	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r0 = 0;
        r10.a(r0);	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r0 = r10.h;
        r0 = r0.isHeldByCurrentThread();
        if (r0 == 0) goto L_0x0186;
    L_0x0156:
        r0 = r10.u;	 Catch:{ all -> 0x017f }
        if (r0 == 0) goto L_0x0173;
    L_0x015a:
        r0 = r10.u;	 Catch:{ all -> 0x017f }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x017f }
        if (r0 == 0) goto L_0x0173;
    L_0x0162:
        r0 = r10.g();	 Catch:{ all -> 0x017f }
        if (r0 != 0) goto L_0x0173;
    L_0x0168:
        r0 = r10.c(r4);	 Catch:{ all -> 0x017f }
        r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r2 <= 0) goto L_0x0173;
    L_0x0170:
        r10.a(r0);	 Catch:{ all -> 0x017f }
    L_0x0173:
        r0 = r10.j;	 Catch:{ all -> 0x017f }
        r0.signalAll();	 Catch:{ all -> 0x017f }
        r0 = r10.h;
        r0.unlock();
        goto L_0x0082;
    L_0x017f:
        r0 = move-exception;
        r1 = r10.h;
        r1.unlock();
        throw r0;
    L_0x0186:
        r0 = "SMACK-BOSH: lock is not held by this thread, don't schedule empty request";
        com.xiaomi.channel.a.b.c.b(r0);
        goto L_0x0082;
    L_0x018d:
        r1 = b(r2);	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        if (r1 == 0) goto L_0x02aa;
    L_0x0193:
        if (r0 != 0) goto L_0x032d;
    L_0x0195:
        r1 = new java.util.ArrayList;	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r0 = r10.u;	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r0 = r0.size();	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r1.<init>(r0);	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
    L_0x01a0:
        r0 = r10.u;	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r2 = r0.iterator();	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
    L_0x01a6:
        r0 = r2.hasNext();	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        if (r0 == 0) goto L_0x01fe;
    L_0x01ac:
        r0 = r2.next();	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r0 = (com.xiaomi.c.a.C1083n) r0;	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r3 = new com.xiaomi.c.a.n;	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r0 = r0.a();	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r3.<init>(r0);	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r1.add(r3);	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        goto L_0x01a6;
    L_0x01bf:
        r0 = move-exception;
        r1 = "SMACK-BOSH: Could not process response";
        com.xiaomi.channel.a.b.c.a(r1, r0);	 Catch:{ all -> 0x02c5 }
        r1 = r10.h;	 Catch:{ all -> 0x02c5 }
        r1.unlock();	 Catch:{ all -> 0x02c5 }
        r10.a(r0);	 Catch:{ all -> 0x02c5 }
        r0 = r10.h;
        r0 = r0.isHeldByCurrentThread();
        if (r0 == 0) goto L_0x030b;
    L_0x01d5:
        r0 = r10.u;	 Catch:{ all -> 0x0304 }
        if (r0 == 0) goto L_0x01f2;
    L_0x01d9:
        r0 = r10.u;	 Catch:{ all -> 0x0304 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0304 }
        if (r0 == 0) goto L_0x01f2;
    L_0x01e1:
        r0 = r10.g();	 Catch:{ all -> 0x0304 }
        if (r0 != 0) goto L_0x01f2;
    L_0x01e7:
        r0 = r10.c(r4);	 Catch:{ all -> 0x0304 }
        r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r2 <= 0) goto L_0x01f2;
    L_0x01ef:
        r10.a(r0);	 Catch:{ all -> 0x0304 }
    L_0x01f2:
        r0 = r10.j;	 Catch:{ all -> 0x0304 }
        r0.signalAll();	 Catch:{ all -> 0x0304 }
        r0 = r10.h;
        r0.unlock();
        goto L_0x0082;
    L_0x01fe:
        r2 = r1.iterator();	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
    L_0x0202:
        r0 = r2.hasNext();	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        if (r0 == 0) goto L_0x0251;
    L_0x0208:
        r0 = r2.next();	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r0 = (com.xiaomi.c.a.C1083n) r0;	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r10.a(r0);	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        goto L_0x0202;
    L_0x0212:
        r0 = move-exception;
        r1 = "SMACK-BOSH: Could not process response";
        com.xiaomi.channel.a.b.c.a(r1, r0);	 Catch:{ all -> 0x02c5 }
        r1 = r10.h;	 Catch:{ all -> 0x02c5 }
        r1.unlock();	 Catch:{ all -> 0x02c5 }
        r10.a(r0);	 Catch:{ all -> 0x02c5 }
        r0 = r10.h;
        r0 = r0.isHeldByCurrentThread();
        if (r0 == 0) goto L_0x0319;
    L_0x0228:
        r0 = r10.u;	 Catch:{ all -> 0x0312 }
        if (r0 == 0) goto L_0x0245;
    L_0x022c:
        r0 = r10.u;	 Catch:{ all -> 0x0312 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0312 }
        if (r0 == 0) goto L_0x0245;
    L_0x0234:
        r0 = r10.g();	 Catch:{ all -> 0x0312 }
        if (r0 != 0) goto L_0x0245;
    L_0x023a:
        r0 = r10.c(r4);	 Catch:{ all -> 0x0312 }
        r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r2 <= 0) goto L_0x0245;
    L_0x0242:
        r10.a(r0);	 Catch:{ all -> 0x0312 }
    L_0x0245:
        r0 = r10.j;	 Catch:{ all -> 0x0312 }
        r0.signalAll();	 Catch:{ all -> 0x0312 }
        r0 = r10.h;
        r0.unlock();
        goto L_0x0082;
    L_0x0251:
        r0 = r1;
    L_0x0252:
        r1 = r10.h;
        r1 = r1.isHeldByCurrentThread();
        if (r1 == 0) goto L_0x02fd;
    L_0x025a:
        r1 = r10.u;	 Catch:{ all -> 0x02f6 }
        if (r1 == 0) goto L_0x0277;
    L_0x025e:
        r1 = r10.u;	 Catch:{ all -> 0x02f6 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x02f6 }
        if (r1 == 0) goto L_0x0277;
    L_0x0266:
        r1 = r10.g();	 Catch:{ all -> 0x02f6 }
        if (r1 != 0) goto L_0x0277;
    L_0x026c:
        r2 = r10.c(r4);	 Catch:{ all -> 0x02f6 }
        r1 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r1 <= 0) goto L_0x0277;
    L_0x0274:
        r10.a(r2);	 Catch:{ all -> 0x02f6 }
    L_0x0277:
        r1 = r10.j;	 Catch:{ all -> 0x02f6 }
        r1.signalAll();	 Catch:{ all -> 0x02f6 }
        r1 = r10.h;
        r1.unlock();
    L_0x0281:
        if (r0 == 0) goto L_0x0082;
    L_0x0283:
        r1 = r0.iterator();
    L_0x0287:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0082;
    L_0x028d:
        r0 = r1.next();
        r0 = (com.xiaomi.c.a.C1083n) r0;
        r2 = r10.o;
        r3 = r0.a();
        r4 = r10.A;
        r2 = r2.a(r5, r3, r4);
        r0.a(r2);
        r0 = r0.a();
        r10.f(r0);
        goto L_0x0287;
    L_0x02aa:
        r10.a(r4, r2);	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r10.d(r4);	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r1 = r10.e(r2);	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        if (r1 == 0) goto L_0x0252;
    L_0x02b6:
        if (r0 != 0) goto L_0x0252;
    L_0x02b8:
        r0 = new java.util.ArrayList;	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r2 = 1;
        r0.<init>(r2);	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r0.add(r1);	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        r10.a(r1);	 Catch:{ b -> 0x01bf, InterruptedException -> 0x0212 }
        goto L_0x0252;
    L_0x02c5:
        r0 = move-exception;
        r1 = r10.h;
        r1 = r1.isHeldByCurrentThread();
        if (r1 == 0) goto L_0x0327;
    L_0x02ce:
        r1 = r10.u;	 Catch:{ all -> 0x0320 }
        if (r1 == 0) goto L_0x02eb;
    L_0x02d2:
        r1 = r10.u;	 Catch:{ all -> 0x0320 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0320 }
        if (r1 == 0) goto L_0x02eb;
    L_0x02da:
        r1 = r10.g();	 Catch:{ all -> 0x0320 }
        if (r1 != 0) goto L_0x02eb;
    L_0x02e0:
        r2 = r10.c(r4);	 Catch:{ all -> 0x0320 }
        r1 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r1 <= 0) goto L_0x02eb;
    L_0x02e8:
        r10.a(r2);	 Catch:{ all -> 0x0320 }
    L_0x02eb:
        r1 = r10.j;	 Catch:{ all -> 0x0320 }
        r1.signalAll();	 Catch:{ all -> 0x0320 }
        r1 = r10.h;
        r1.unlock();
    L_0x02f5:
        throw r0;
    L_0x02f6:
        r0 = move-exception;
        r1 = r10.h;
        r1.unlock();
        throw r0;
    L_0x02fd:
        r1 = "SMACK-BOSH: lock is not held by this thread, don't schedule empty request";
        com.xiaomi.channel.a.b.c.b(r1);
        goto L_0x0281;
    L_0x0304:
        r0 = move-exception;
        r1 = r10.h;
        r1.unlock();
        throw r0;
    L_0x030b:
        r0 = "SMACK-BOSH: lock is not held by this thread, don't schedule empty request";
        com.xiaomi.channel.a.b.c.b(r0);
        goto L_0x0082;
    L_0x0312:
        r0 = move-exception;
        r1 = r10.h;
        r1.unlock();
        throw r0;
    L_0x0319:
        r0 = "SMACK-BOSH: lock is not held by this thread, don't schedule empty request";
        com.xiaomi.channel.a.b.c.b(r0);
        goto L_0x0082;
    L_0x0320:
        r0 = move-exception;
        r1 = r10.h;
        r1.unlock();
        throw r0;
    L_0x0327:
        r1 = "SMACK-BOSH: lock is not held by this thread, don't schedule empty request";
        com.xiaomi.channel.a.b.c.b(r1);
        goto L_0x02f5;
    L_0x032d:
        r1 = r0;
        goto L_0x01a0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.c.a.L.b(com.xiaomi.c.a.n):void");
    }

    private void b(Throwable th) {
        l();
        R r = null;
        for (S s : this.e) {
            if (r == null) {
                r = R.a(this, this.x, th);
            }
            try {
                s.a(r);
            } catch (Throwable e) {
                c.a("SMACK-BOSH:Unhandled Exception", e);
            }
        }
    }

    private static boolean b(C1078u c1078u) {
        return h.P.equals(c1078u.a(K.x));
    }

    private long c(C1078u c1078u) {
        k();
        if (!(this.t == null || this.t.e() == null)) {
            try {
                E a = E.a(c1078u.a(K.m));
                if (a != null) {
                    long c = (long) (a.c() - c);
                    return c < 0 ? (long) b : c;
                }
            } catch (Throwable e) {
                c.a("SMACK-BOSH: Could not extract", e);
            }
        }
        return i();
    }

    private void c() {
        l();
        this.h.lock();
        try {
            this.o.a(this.m);
            this.r = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        } finally {
            this.h.unlock();
        }
    }

    private void d(C1078u c1078u) {
        k();
        Long valueOf = Long.valueOf(Long.parseLong(c1078u.a(K.q)));
        if (this.w.equals(Long.valueOf(-1))) {
            this.w = valueOf;
            return;
        }
        this.v.add(valueOf);
        valueOf = Long.valueOf(this.w.longValue() + 1);
        while (!this.v.isEmpty() && valueOf.equals(this.v.first())) {
            this.w = valueOf;
            this.v.remove(valueOf);
            valueOf = Long.valueOf(valueOf.longValue() + 1);
        }
    }

    private boolean d() {
        k();
        return this.r != null;
    }

    private C1083n e(C1078u c1078u) {
        C1078u c1078u2 = null;
        k();
        String a = c1078u.a(K.o);
        if (a == null) {
            return null;
        }
        Long valueOf = Long.valueOf(Long.parseLong(a));
        Long.valueOf(Long.parseLong(c1078u.a(K.v)));
        Iterator it = this.x.iterator();
        while (it.hasNext() && c1078u2 == null) {
            C1078u c1078u3 = (C1078u) it.next();
            if (!valueOf.equals(Long.valueOf(Long.parseLong(c1078u3.a(K.q))))) {
                c1078u3 = c1078u2;
            }
            c1078u2 = c1078u3;
        }
        if (c1078u2 == null) {
            throw new C1070b("Report of missing message with RID '" + a + "' but local copy of that request was not found");
        }
        C1083n c1083n = new C1083n(c1078u2);
        a(c1083n);
        this.i.signalAll();
        return c1083n;
    }

    private void e() {
        C1083n f = f();
        if (f != null) {
            this.h.lock();
            try {
                long longValue = Long.valueOf(f.a().a(K.q)).longValue();
                if (this.l == 0) {
                    this.l = longValue;
                }
                this.h.unlock();
                b(f);
            } catch (Throwable th) {
                this.h.unlock();
            }
        }
    }

    private C1083n f() {
        C1083n c1083n;
        l();
        this.h.lock();
        do {
            if (this.u == null) {
                this.h.unlock();
                return null;
            }
            try {
                c1083n = (C1083n) this.u.poll();
                if (c1083n == null) {
                    this.i.await();
                    continue;
                }
            } catch (Throwable e) {
                c.a("Interrupted", e);
                continue;
            } catch (Throwable th) {
                this.h.unlock();
            }
        } while (c1083n == null);
        this.h.unlock();
        return c1083n;
    }

    private void f(C1078u c1078u) {
        l();
        C1071c c1071c = null;
        for (T t : this.f) {
            if (c1071c == null) {
                c1071c = C1071c.a(this, c1078u);
            }
            try {
                t.a(c1071c);
            } catch (Throwable e) {
                c.a("SMACK-BOSH:Unhandled Exception", e);
            }
        }
    }

    private void g(C1078u c1078u) {
        l();
        C1071c c1071c = null;
        for (U u : this.g) {
            if (c1071c == null) {
                c1071c = C1071c.b(this, c1078u);
            }
            try {
                u.a(c1071c);
            } catch (Throwable e) {
                c.a("SMACK-BOSH:Unhandled Exception", e);
            }
        }
    }

    private boolean g() {
        return !(this.s == null || this.s.isDone()) || this.y > 0;
    }

    private void h() {
        k();
        if (this.s != null) {
            this.s.cancel(false);
            this.s = null;
        }
    }

    private long i() {
        k();
        F d = this.t.d();
        long j = (long) b;
        if (d != null) {
            long c = (long) d.c();
            if (c > j) {
                return c;
            }
        }
        return j;
    }

    private void j() {
        l();
        try {
            a(C1079j.a().a());
        } catch (Throwable e) {
            a(e);
        }
    }

    private void k() {
        if (d && !this.h.isHeldByCurrentThread()) {
            throw new AssertionError("Lock is not held by current thread");
        }
    }

    private void l() {
        if (d && this.h.isHeldByCurrentThread()) {
            throw new AssertionError("Lock is held by current thread");
        }
    }

    private void m() {
        boolean isHeldByCurrentThread = this.h.isHeldByCurrentThread();
        if (isHeldByCurrentThread) {
            this.h.unlock();
        }
        try {
            R r = null;
            for (S s : this.e) {
                if (r == null) {
                    r = R.a(this);
                }
                s.a(r);
            }
            if (isHeldByCurrentThread) {
                this.h.lock();
            }
        } catch (Throwable e) {
            c.a("SMACK-BOSH:Unhandled Exception", e);
        } catch (Throwable th) {
            if (isHeldByCurrentThread) {
                this.h.lock();
            }
        }
    }

    private void n() {
        l();
        R r = null;
        for (S s : this.e) {
            if (r == null) {
                r = R.b(this);
            }
            try {
                s.a(r);
            } catch (Throwable e) {
                c.a("SMACK-BOSH:Unhandled Exception", e);
            }
        }
    }

    public void a() {
        a(new C1070b("Session explicitly closed by caller"));
    }

    public void a(S s) {
        if (s == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.e.add(s);
    }

    public void a(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.f.add(t);
    }

    public void a(U u) {
        if (u == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.g.add(u);
    }

    public void a(C1079j c1079j) {
        l();
        if (c1079j == null) {
            throw new IllegalArgumentException("Message body may not be null");
        }
        this.h.lock();
        if (d() || a((C1078u) c1079j)) {
            C1083n c1083n;
            try {
                C1078u a;
                long a2 = this.p.a();
                if (TextUtils.isEmpty(c1079j.e())) {
                    this.y = a2;
                }
                C1077i c1077i = this.t;
                if (c1077i == null && this.u.isEmpty()) {
                    a = a(a2, c1079j);
                } else {
                    a = b(a2, c1079j);
                    if (this.t.f()) {
                        this.x.add(a);
                    }
                }
                c1083n = new C1083n(a);
                a(c1083n);
                this.i.signalAll();
                h();
                a = c1083n.a();
                c1083n.a(this.o.a(c1077i, a, this.A));
                f(a);
            } finally {
                c1083n = this.h;
                c1083n.unlock();
            }
        } else {
            throw new C1070b("Cannot send message when session is closed");
        }
    }

    public void b() {
        if (this.r != null) {
            if (System.currentTimeMillis() - this.z > 30000 && this.r.getActiveCount() > 1) {
                a(new C1070b("SMACK-BOSH: request timeout happened, reset connection"));
            } else if (this.r.getActiveCount() <= 0 || g()) {
                this.h.lock();
                try {
                    a(0);
                } finally {
                    this.h.unlock();
                }
            }
        }
    }

    public void b(C1079j c1079j) {
        if (c1079j == null) {
            throw new IllegalArgumentException("Message body may not be null");
        }
        C1081l b = c1079j.b();
        b.a(K.x, "terminate");
        a(b.a());
    }
}
