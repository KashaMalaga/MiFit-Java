package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import kankan.wheel.widget.l;
import org.apache.http.HttpEntity;

public class bt {
    private static bt a;
    private aw b;
    private Handler c;

    class AnonymousClass1 extends ay {
        final /* synthetic */ bu b;
        final /* synthetic */ bv c;
        final /* synthetic */ bt d;

        public void a() {
            try {
                this.d.a(this.d.b(this.b), this.c);
            } catch (v e) {
                this.d.a(e, this.c);
            }
        }
    }

    class a extends Handler {
        private a(Looper looper) {
            super(looper);
            Looper.prepare();
        }

        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case kankan.wheel.widget.a.i /*0*/:
                        ((bx) message.obj).b.a();
                        return;
                    case l.a /*1*/:
                        bx bxVar = (bx) message.obj;
                        bxVar.b.a(bxVar.a);
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            th.printStackTrace();
        }
    }

    private bt(boolean z, int i) {
        if (z) {
            try {
                this.b = aw.a(i);
            } catch (Throwable th) {
                az.a(th, "NetManger", "NetManger1");
                th.printStackTrace();
                return;
            }
        }
        if (Looper.myLooper() == null) {
            this.c = new a(Looper.getMainLooper());
        } else {
            this.c = new a();
        }
    }

    public static bt a() {
        return a(true, 5);
    }

    public static bt a(boolean z) {
        return a(z, 5);
    }

    private static synchronized bt a(boolean z, int i) {
        bt btVar;
        synchronized (bt.class) {
            try {
                if (a == null) {
                    a = new bt(z, i);
                } else if (z) {
                    if (a.b == null) {
                        a.b = aw.a(i);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            btVar = a;
        }
        return btVar;
    }

    private void a(v vVar, bv bvVar) {
        bx bxVar = new bx();
        bxVar.a = vVar;
        bxVar.b = bvVar;
        Message message = new Message();
        message.obj = bxVar;
        message.what = 1;
        this.c.sendMessage(message);
    }

    private void a(byte[] bArr, bv bvVar) {
        bvVar.a(bArr);
        bx bxVar = new bx();
        bxVar.b = bvVar;
        Message message = new Message();
        message.obj = bxVar;
        message.what = 0;
        this.c.sendMessage(message);
    }

    private byte[] a(bu buVar, br brVar) {
        v e;
        HttpEntity entity = buVar.getEntity();
        byte[] entityBytes = buVar.getEntityBytes();
        if (entity != null || entityBytes != null) {
            return entityBytes != null ? brVar.a(buVar.getURL(), buVar.getRequestHead(), entityBytes) : brVar.a(buVar.getURL(), buVar.getRequestHead(), entity);
        } else {
            try {
                return brVar.b(buVar.getURL(), buVar.getRequestHead(), buVar.getParams());
            } catch (v e2) {
                throw e2;
            } catch (Throwable th) {
                th.printStackTrace();
                e2 = new v(AMapException.ERROR_UNKNOWN);
            }
        }
    }

    private byte[] b(bu buVar, br brVar) {
        v e;
        try {
            return brVar.a(buVar.getURL(), buVar.getRequestHead(), buVar.getParams());
        } catch (v e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            e2 = new v(AMapException.ERROR_UNKNOWN);
        }
    }

    private void c(bu buVar) {
        if (buVar == null) {
            throw new v("requeust is null");
        } else if (buVar.getURL() == null || com.xiaomi.e.a.f.equals(buVar.getURL())) {
            throw new v("request url is empty");
        }
    }

    public byte[] a(bu buVar) {
        v e;
        try {
            c(buVar);
            return a(buVar, new br(buVar.a, buVar.b, buVar.c == null ? null : new Proxy(Type.HTTP, InetSocketAddress.createUnresolved(buVar.c.getHostName(), buVar.c.getPort()))));
        } catch (v e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            e2 = new v(AMapException.ERROR_UNKNOWN);
        }
    }

    public byte[] b(bu buVar) {
        v e;
        try {
            c(buVar);
            return b(buVar, new br(buVar.a, buVar.b, buVar.c == null ? null : new Proxy(Type.HTTP, InetSocketAddress.createUnresolved(buVar.c.getHostName(), buVar.c.getPort()))));
        } catch (v e2) {
            throw e2;
        } catch (Throwable th) {
            e2 = new v(AMapException.ERROR_UNKNOWN);
        }
    }
}
