package com.amap.api.maps.offlinemap;

import android.content.Context;
import cn.com.smartdevices.bracelet.d.C0430g;
import com.amap.api.mapcore.n;
import com.amap.api.mapcore.util.ac;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.bt;
import com.amap.api.mapcore.util.bu;
import com.amap.api.mapcore.util.u;
import com.amap.api.mapcore.util.w;
import com.amap.api.mapcore.util.y;
import com.amap.api.maps.AMapException;
import com.d.a.a.C1012a;
import com.f.a.b.d.a;
import com.tencent.connect.common.Constants;
import com.xiaomi.account.openauth.h;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;

public abstract class ProtocalHandler<T, V> extends bu {
    protected final int CONN_TIMEOUT = a.a;
    protected final int READ_TIMEOUT = 50000;
    private int d = 1;
    protected Context mContext;
    protected int maxTry = 1;
    protected String recommandURL = com.xiaomi.e.a.f;
    protected T task;

    public ProtocalHandler(Context context) {
        a(context, null);
    }

    public ProtocalHandler(Context context, T t) {
        a(context, t);
    }

    private V a() {
        int i = 0;
        V v = null;
        while (i < this.maxTry) {
            try {
                bt a = bt.a(false);
                setProxy(ac.a(this.mContext));
                v = a(a.b(this));
                i = this.maxTry;
            } catch (Throwable e) {
                az.a(e, "ProtocalHandler", "getDataMayThrow AMapException");
                e.printStackTrace();
                i++;
                if (i >= this.maxTry) {
                    throw new AMapException(e.getErrorMessage());
                }
            } catch (Throwable e2) {
                az.a(e2, "ProtocalHandler", "getDataMayThrow AMapCoreException");
                e2.printStackTrace();
                i++;
                if (i < this.maxTry) {
                    try {
                        Thread.sleep((long) (this.d * h.E));
                    } catch (InterruptedException e3) {
                        az.a(e2, "ProtocalHandler", "getDataMayThrow InterruptedException");
                        e2.printStackTrace();
                        throw new AMapException(e2.getMessage());
                    }
                }
                onExceptionOccur();
                throw new AMapException(e2.a());
            }
        }
        return v;
    }

    private V a(byte[] bArr) {
        return loadData(bArr);
    }

    private void a(Context context, T t) {
        this.mContext = context;
        this.task = t;
    }

    public V getData() {
        return this.task != null ? a() : null;
    }

    public HttpEntity getEntity() {
        return null;
    }

    public Map<String, String> getRequestHead() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put(C1012a.f, C1012a.g);
        hashMap.put("User-Agent", n.c);
        hashMap.put("X-INFO", y.a(this.mContext, u.e(), null));
        hashMap.put("ia", Constants.VIA_TO_TYPE_QQ_GROUP);
        hashMap.put("ec", Constants.VIA_TO_TYPE_QQ_GROUP);
        hashMap.put(C0430g.b, w.f(this.mContext));
        return hashMap;
    }

    protected V loadData(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, kankan.wheel.widget.a.bO);
        } catch (Throwable e) {
            az.a(e, "ProtocalHandler", "loadData Exception");
            e.printStackTrace();
            str = null;
        }
        if (str == null || str.equals(com.xiaomi.e.a.f)) {
            return null;
        }
        u.a(str);
        return paseJSON(str);
    }

    protected V onExceptionOccur() {
        return null;
    }

    protected abstract V paseJSON(String str);

    protected String strEncoder(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLEncoder.encode(str, kankan.wheel.widget.a.bO);
        } catch (Throwable e) {
            az.a(e, "ProtocalHandler", "strEncoderUnsupportedEncodingException");
            e.printStackTrace();
            return new String();
        } catch (Throwable e2) {
            az.a(e2, "ProtocalHandler", "strEncoderException");
            e2.printStackTrace();
            return new String();
        }
    }

    protected String strReEncoder(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, kankan.wheel.widget.a.bO);
        } catch (Throwable e) {
            az.a(e, "ProtocalHandler", "strReEncoderUnsupportedEncodingException");
            e.printStackTrace();
            return new String();
        } catch (Throwable e2) {
            az.a(e2, "ProtocalHandler", "strReEncoderException");
            e2.printStackTrace();
            return new String();
        }
    }
}
