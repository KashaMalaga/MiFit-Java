package com.amap.api.maps.offlinemap;

import cn.com.smartdevices.bracelet.ui.dW;
import com.amap.api.mapcore.util.az;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.e.a;
import com.xiaomi.market.sdk.o;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.json.JSONObject;

class l {
    public int a = 3;
    long b = 0;
    private String c = null;
    private String d = null;
    private String e = null;
    private String f = null;
    private String g = a.f;
    private long h = 0;
    private long i = 0;
    private String j;
    private String k;
    private int l;
    private boolean m = false;
    private int n;
    private String o = a.f;

    public l(OfflineMapCity offlineMapCity) {
        this.c = offlineMapCity.getCity();
        this.e = offlineMapCity.getAdcode();
        this.d = offlineMapCity.getUrl();
        this.i = offlineMapCity.getSize();
        a();
        this.g = offlineMapCity.getVersion();
        this.o = offlineMapCity.getCode();
        this.m = false;
    }

    public l(OfflineMapProvince offlineMapProvince) {
        this.c = offlineMapProvince.getProvinceName();
        this.e = offlineMapProvince.getProvinceCode();
        this.d = offlineMapProvince.getUrl();
        this.i = offlineMapProvince.getSize();
        a();
        this.g = offlineMapProvince.getVersion();
        this.m = true;
    }

    protected void a() {
        String a = d.a();
        this.f = a + this.e + ".zip" + dW.c;
        try {
            if (!new File(a + this.e).exists() && !new File(a + this.e + ".zip" + dW.c).exists()) {
                new File(this.f).createNewFile();
            }
        } catch (Throwable e) {
            az.a(e, "UpdateItem", "init");
            e.printStackTrace();
        }
    }

    public void a(int i) {
        this.l = i;
    }

    public void a(long j) {
        this.i = j;
    }

    public void a(String str) {
        this.c = str;
    }

    public String b() {
        return this.c;
    }

    public void b(int i) {
        this.n = i;
    }

    public void b(long j) {
        this.h = j;
    }

    public void b(String str) {
        this.g = str;
    }

    public String c() {
        return this.g;
    }

    public void c(long j) {
        this.h = j;
    }

    public void c(String str) {
        this.e = str;
    }

    public String d() {
        return this.f;
    }

    public void d(String str) {
        this.d = str;
    }

    public String e() {
        return this.e;
    }

    public void e(String str) {
        this.j = str;
    }

    public String f() {
        return this.d;
    }

    public void f(String str) {
        this.k = str;
    }

    public long g() {
        return this.i;
    }

    public void g(String str) {
        if (str != null) {
            try {
                if (!str.equals(a.f)) {
                    JSONObject jSONObject = new JSONObject(str).getJSONObject("file");
                    if (jSONObject != null) {
                        this.c = jSONObject.optString(SocialConstants.PARAM_TITLE);
                        this.e = jSONObject.optString(b.a);
                        this.d = jSONObject.optString(SocialConstants.PARAM_URL);
                        this.f = jSONObject.optString("fileName");
                        this.h = jSONObject.optLong("lLocalLength");
                        this.i = jSONObject.optLong("lRemoteLength");
                        this.a = jSONObject.optInt("mState");
                        this.b = jSONObject.optLong("Schedule");
                        this.g = jSONObject.optString(o.x);
                        this.k = jSONObject.optString("localPath");
                        this.j = jSONObject.optString("vMapFileNames");
                        this.m = jSONObject.optBoolean("isSheng");
                        this.n = jSONObject.optInt("mCompleteCode");
                        this.o = jSONObject.optString("mCityCode");
                    }
                }
            } catch (Throwable e) {
                az.a(e, "UpdateItem", "readFileToJSONObject");
                e.printStackTrace();
            }
        }
    }

    public long h() {
        return this.i;
    }

    public boolean i() {
        return this.m;
    }

    public int j() {
        return this.n;
    }

    public String k() {
        return this.o;
    }

    public void l() {
        OutputStreamWriter outputStreamWriter;
        Throwable e;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(SocialConstants.PARAM_TITLE, this.c);
            jSONObject2.put(b.a, this.e);
            jSONObject2.put(SocialConstants.PARAM_URL, this.d);
            jSONObject2.put("fileName", this.f);
            jSONObject2.put("lLocalLength", this.h);
            jSONObject2.put("lRemoteLength", this.i);
            jSONObject2.put("mState", this.a);
            jSONObject2.put("Schedule", this.b);
            jSONObject2.put(o.x, this.g);
            jSONObject2.put("localPath", this.k);
            if (this.j != null) {
                jSONObject2.put("vMapFileNames", this.j);
            }
            jSONObject2.put("isSheng", this.m);
            jSONObject2.put("mCompleteCode", this.n);
            jSONObject2.put("mCityCode", this.o);
            jSONObject.put("file", jSONObject2);
            File file = new File(this.f + ".dt");
            file.delete();
            try {
                outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file, true), kankan.wheel.widget.a.bO);
                try {
                    outputStreamWriter.write(jSONObject.toString());
                    if (outputStreamWriter != null) {
                        try {
                            outputStreamWriter.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        az.a(e, "UpdateItem", "saveJSONObjectToFile");
                        e.printStackTrace();
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                    } catch (Throwable th) {
                        e = th;
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw e;
                    }
                }
            } catch (IOException e5) {
                e = e5;
                outputStreamWriter = null;
                az.a(e, "UpdateItem", "saveJSONObjectToFile");
                e.printStackTrace();
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
            } catch (Throwable th2) {
                e = th2;
                outputStreamWriter = null;
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                throw e;
            }
        } catch (Throwable e6) {
            az.a(e6, "UpdateItem", "saveJSONObjectToFile parseJson");
            e6.printStackTrace();
        }
    }
}
