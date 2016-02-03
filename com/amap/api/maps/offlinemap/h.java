package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import cn.com.smartdevices.bracelet.d.C0430g;
import cn.com.smartdevices.bracelet.gps.services.ay;
import cn.com.smartdevices.bracelet.push.MiPushMessageReceiver;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.mapcore.n;
import com.amap.api.mapcore.util.ae;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.u;
import com.amap.api.mapcore.util.w;
import com.amap.api.mapcore.util.y;
import com.f.a.b.d.a;
import com.tencent.connect.common.Constants;
import com.xiaomi.market.sdk.o;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

class h extends ProtocalHandler<String, List<OfflineMapProvince>> {
    private Context d;

    public h(Context context, String str) {
        super(context, str);
        getClass();
        setConnectionTimeout(a.a);
        getClass();
        setSoTimeout(50000);
    }

    private void b(String str) {
        OutputStream fileOutputStream;
        Throwable e;
        if (!u.b(this.d).equals(com.xiaomi.e.a.f)) {
            File file = new File(u.b(this.d) + "offlinemap3.png");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Throwable e2) {
                    az.a(e2, "OfflineUpdateCityHandler", "writeSD dirCreate");
                    e2.printStackTrace();
                }
            }
            if (a() > 1048576) {
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(str.getBytes(kankan.wheel.widget.a.bO));
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                    } catch (FileNotFoundException e4) {
                        e = e4;
                        try {
                            az.a(e, "OfflineUpdateCityHandler", "writeSD filenotfound");
                            e.printStackTrace();
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e32) {
                                    e32.printStackTrace();
                                }
                            }
                        } catch (Throwable th) {
                            e = th;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            throw e;
                        }
                    } catch (IOException e6) {
                        e = e6;
                        az.a(e, "OfflineUpdateCityHandler", "writeSD io");
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e322) {
                                e322.printStackTrace();
                            }
                        }
                    }
                } catch (FileNotFoundException e7) {
                    e = e7;
                    fileOutputStream = null;
                    az.a(e, "OfflineUpdateCityHandler", "writeSD filenotfound");
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (IOException e8) {
                    e = e8;
                    fileOutputStream = null;
                    az.a(e, "OfflineUpdateCityHandler", "writeSD io");
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th2) {
                    e = th2;
                    fileOutputStream = null;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e;
                }
            }
        }
    }

    public long a() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return 0;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    protected List<OfflineMapProvince> a(String str) {
        List<OfflineMapProvince> list = null;
        try {
            if (this.d != null) {
                b(str);
            }
        } catch (Throwable th) {
            az.a(th, "OfflineUpdateCityHandler", "loadData jsonInit");
            th.printStackTrace();
        }
        try {
            list = m.c(str);
        } catch (Throwable th2) {
            az.a(th2, "OfflineUpdateCityHandler", "loadData parseJson");
            th2.printStackTrace();
        }
        return list;
    }

    protected List<OfflineMapProvince> a(byte[] bArr) {
        String str;
        Throwable e;
        List<OfflineMapProvince> arrayList = new ArrayList();
        try {
            str = new String(bArr, kankan.wheel.widget.a.bO);
            try {
                u.a(str);
                if (!(str == null || com.xiaomi.e.a.f.equals(str))) {
                    String optString = new JSONObject(str).optString(LocationManagerProxy.KEY_STATUS_CHANGED);
                    if (!(optString == null || optString.equals(com.xiaomi.e.a.f) || optString.equals(Constants.VIA_RESULT_SUCCESS))) {
                        if (this.d != null) {
                            b(str);
                        }
                        try {
                            arrayList = m.c(str);
                        } catch (Throwable e2) {
                            az.a(e2, "OfflineUpdateCityHandler", "loadData parseJson");
                            e2.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                e2 = th;
                az.a(e2, "OfflineUpdateCityHandler", "loadData jsonInit");
                e2.printStackTrace();
                arrayList = m.c(str);
                return arrayList;
            }
        } catch (Throwable th2) {
            e2 = th2;
            str = null;
            az.a(e2, "OfflineUpdateCityHandler", "loadData jsonInit");
            e2.printStackTrace();
            arrayList = m.c(str);
            return arrayList;
        }
        return arrayList;
    }

    public void a(Context context) {
        this.d = context;
    }

    public Map<String, String> getParams() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put(C0430g.b, w.f(this.d));
        hashMap.put("opertype", "offlinemap_with_province");
        hashMap.put("plattype", MiPushMessageReceiver.ANDROID);
        hashMap.put("product", n.b);
        hashMap.put(o.x, "V2.4.1");
        hashMap.put("ext", "standard");
        hashMap.put("output", "json");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=").append(w.f(this.d));
        stringBuffer.append("&opertype=offlinemap_with_province");
        stringBuffer.append("&plattype=android");
        stringBuffer.append("&product=").append(n.b);
        stringBuffer.append("&version=").append("V2.4.1");
        stringBuffer.append("&ext=standard");
        stringBuffer.append("&output=json");
        String a = ae.a(stringBuffer.toString());
        String a2 = y.a();
        hashMap.put(ay.H, a2);
        hashMap.put("scode", y.a(this.d, a2, a));
        return hashMap;
    }

    public String getURL() {
        return "http://restapi.amap.com/v3/config/resource";
    }

    protected /* synthetic */ Object loadData(byte[] bArr) {
        return a(bArr);
    }

    protected /* synthetic */ Object paseJSON(String str) {
        return a(str);
    }
}
