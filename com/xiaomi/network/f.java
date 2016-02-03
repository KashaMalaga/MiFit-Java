package com.xiaomi.network;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.net.wifi.WifiManager;
import android.os.Process;
import android.support.v4.g.c;
import android.support.v4.view.a.C0113o;
import android.text.TextUtils;
import android.util.Log;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.a.a.a.C0907p;
import com.amap.api.services.district.DistrictSearchQuery;
import com.tencent.connect.common.Constants;
import com.xiaomi.b.a.a.a.i;
import com.xiaomi.channel.relationservice.data.a;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f {
    private static Map<String, ArrayList<String>> b = new HashMap();
    private static f k;
    private static g l;
    private static String m;
    private static String n;
    private static boolean o = false;
    protected Map<String, d> a = new HashMap();
    private Context c;
    private e d;
    private h e;
    private String f = Constants.VIA_RESULT_SUCCESS;
    private long g = 0;
    private final long h = 15;
    private long i = 0;
    private String j = "isp_prov_city_country_ip";

    protected f(Context context, e eVar, h hVar, String str, String str2, String str3) {
        this.c = context.getApplicationContext();
        if (this.c == null) {
            this.c = context;
        }
        this.e = hVar;
        if (eVar == null) {
            this.d = new s(this);
        } else {
            this.d = eVar;
        }
        this.f = str;
        if (str2 == null) {
            str2 = context.getPackageName();
        }
        m = str2;
        if (str3 == null) {
            str3 = k();
        }
        n = str3;
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (k == null) {
                throw new IllegalStateException("the host manager is not initialized yet.");
            }
            fVar = k;
        }
        return fVar;
    }

    private String a(ArrayList<String> arrayList, String str) {
        ArrayList arrayList2 = new ArrayList();
        List<NameValuePair> arrayList3 = new ArrayList();
        arrayList3.add(new BasicNameValuePair(a.h, str));
        arrayList3.add(new BasicNameValuePair(g.n, this.f));
        arrayList3.add(new BasicNameValuePair(com.huami.android.widget.a.c, a((Collection) arrayList, com.xiaomi.mipush.sdk.f.i)));
        c c = c("resolver.gslb.mi-idc.com");
        String format = String.format("http://%1$s/gslb/gslb/getbucket.asp?ver=3.0", new Object[]{"resolver.gslb.mi-idc.com"});
        if (c == null) {
            arrayList2.add(format);
        } else {
            arrayList2 = c.a(format);
        }
        Iterator it = arrayList2.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Builder buildUpon = Uri.parse((String) it.next()).buildUpon();
        for (NameValuePair nameValuePair : arrayList3) {
            buildUpon.appendQueryParameter(nameValuePair.getName(), nameValuePair.getValue());
        }
        return this.e == null ? k.a(this.c, new URL(buildUpon.toString())) : this.e.a(buildUpon.toString());
    }

    public static <T> String a(Collection<T> collection, String str) {
        if (collection == null || collection.isEmpty()) {
            return com.xiaomi.e.a.f;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            stringBuilder.append(it.next());
            if (it.hasNext()) {
                stringBuilder.append(str);
            }
        }
        return stringBuilder.toString();
    }

    public static String a(String[] strArr, String str) {
        if (strArr == null || strArr.length == 0) {
            return com.xiaomi.e.a.f;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            stringBuilder.append(str);
            stringBuilder.append(strArr[i]);
        }
        return stringBuilder.toString();
    }

    private ArrayList<c> a(ArrayList<String> arrayList) {
        String str;
        int i;
        i();
        synchronized (this.a) {
            e();
            for (String str2 : this.a.keySet()) {
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        synchronized (b) {
            for (String str22 : b.keySet()) {
                if (!arrayList.contains(str22)) {
                    arrayList.add(str22);
                }
            }
        }
        if (!arrayList.contains("resolver.gslb.mi-idc.com")) {
            arrayList.add("resolver.gslb.mi-idc.com");
        }
        ArrayList<c> arrayList2 = new ArrayList(arrayList.size());
        for (i = 0; i < arrayList.size(); i++) {
            arrayList2.add(null);
        }
        try {
            str22 = c() ? "wifi" : "wap";
            Object a = a((ArrayList) arrayList, str22);
            if (!TextUtils.isEmpty(a)) {
                JSONObject jSONObject = new JSONObject(a);
                if ("OK".equalsIgnoreCase(jSONObject.getString(C0907p.b))) {
                    jSONObject = jSONObject.getJSONObject("R");
                    String string = jSONObject.getString(DistrictSearchQuery.KEYWORDS_PROVINCE);
                    String string2 = jSONObject.getString(DistrictSearchQuery.KEYWORDS_CITY);
                    String string3 = jSONObject.getString("isp");
                    String string4 = jSONObject.getString("ip");
                    String string5 = jSONObject.getString(DistrictSearchQuery.KEYWORDS_COUNTRY);
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str22);
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        str22 = (String) arrayList.get(i2);
                        JSONArray jSONArray = jSONObject2.getJSONArray(str22);
                        c cVar = new c(str22);
                        for (i = 0; i < jSONArray.length(); i++) {
                            Object string6 = jSONArray.getString(i);
                            if (!TextUtils.isEmpty(string6)) {
                                cVar.a(new q(string6, jSONArray.length() - i));
                            }
                        }
                        arrayList2.set(i2, cVar);
                        cVar.g = string5;
                        cVar.c = string;
                        cVar.e = string3;
                        cVar.f = string4;
                        cVar.d = string2;
                        if (jSONObject.has("stat-percent")) {
                            cVar.a(jSONObject.getDouble("stat-percent"));
                        }
                        if (jSONObject.has("stat-domain")) {
                            cVar.c(jSONObject.getString("stat-domain"));
                        }
                        if (jSONObject.has("ttl")) {
                            cVar.a(((long) jSONObject.getInt("ttl")) * 1000);
                        }
                        b(cVar.d());
                    }
                }
            }
        } catch (JSONException e) {
        } catch (IOException e2) {
        } catch (Exception e3) {
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            c cVar2 = (c) arrayList2.get(i3);
            if (cVar2 != null) {
                a((String) arrayList.get(i3), cVar2);
            }
        }
        f();
        return arrayList2;
    }

    public static synchronized void a(Context context, e eVar, h hVar, String str, String str2, String str3) {
        synchronized (f.class) {
            if (k == null) {
                if (l == null) {
                    k = new f(context, eVar, hVar, str, str2, str3);
                } else {
                    k = l.a(context, eVar, hVar, str);
                }
                if (k != null) {
                    if (o.a() == null) {
                        o.a(context);
                    }
                    o.a().a(new r());
                }
            }
        }
    }

    public static void a(String str, String str2) {
        ArrayList arrayList = (ArrayList) b.get(str);
        synchronized (b) {
            if (arrayList == null) {
                arrayList = new ArrayList();
                arrayList.add(str2);
                b.put(str, arrayList);
            } else if (!arrayList.contains(str2)) {
                arrayList.add(str2);
            }
        }
    }

    private c c(String str) {
        synchronized (this.a) {
            e();
            d dVar = (d) this.a.get(str);
        }
        if (dVar != null) {
            c a = dVar.a();
            if (a != null) {
                return a;
            }
        }
        return null;
    }

    private c d(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return (c) a(arrayList).get(0);
    }

    private String e(String str) {
        return TextUtils.isEmpty(str) ? c.a : str.startsWith("WIFI") ? "WIFI" : str;
    }

    private void f(String str) {
        synchronized (this.a) {
            this.a.clear();
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                d a = new d().a(jSONArray.getJSONObject(i));
                this.a.put(a.d(), a);
            }
        }
    }

    private String k() {
        try {
            PackageInfo packageInfo = this.c.getPackageManager().getPackageInfo(this.c.getPackageName(), C0113o.o);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        } catch (Exception e) {
        }
        return Constants.VIA_RESULT_SUCCESS;
    }

    private JSONArray l() {
        JSONArray jSONArray;
        synchronized (this.a) {
            jSONArray = new JSONArray();
            for (d e : this.a.values()) {
                jSONArray.put(e.e());
            }
        }
        return jSONArray;
    }

    public c a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        } else if (!this.d.a(str)) {
            return null;
        } else {
            c c = c(str);
            if (c != null) {
                return c;
            }
            if (System.currentTimeMillis() - this.i > (this.g * 60) * 1000) {
                this.i = System.currentTimeMillis();
                c = d(str);
                if (c != null) {
                    this.g = 0;
                    return c;
                } else if (this.g < 15) {
                    this.g++;
                }
            }
            ArrayList arrayList = (ArrayList) b.get(str);
            synchronized (b) {
                if (arrayList != null) {
                    c cVar = new c(str);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        cVar.b((String) it.next());
                    }
                    return cVar;
                }
                return null;
            }
        }
    }

    public void a(String str, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            throw new IllegalArgumentException("the argument is invalid " + str + ", " + cVar);
        } else if (this.d.a(str)) {
            synchronized (this.a) {
                e();
                if (this.a.containsKey(str)) {
                    ((d) this.a.get(str)).a(cVar);
                } else {
                    d dVar = new d(str);
                    dVar.a(cVar);
                    this.a.put(str, dVar);
                }
            }
        }
    }

    public String b() {
        if (this.c == null) {
            return c.a;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.c.getSystemService("connectivity");
            if (connectivityManager == null) {
                return c.a;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return c.a;
            }
            if (activeNetworkInfo.getType() != 1) {
                return activeNetworkInfo.getTypeName() + "-" + activeNetworkInfo.getSubtypeName();
            }
            WifiManager wifiManager = (WifiManager) this.c.getSystemService("wifi");
            if (!(wifiManager == null || wifiManager.getConnectionInfo() == null)) {
                return "WIFI-" + wifiManager.getConnectionInfo().getSSID();
            }
            return c.a;
        } catch (Exception e) {
        }
    }

    public void b(String str) {
        this.j = str;
    }

    public boolean c() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.c.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            return 1 == activeNetworkInfo.getType();
        } catch (Exception e) {
            return false;
        }
    }

    public void d() {
        ArrayList arrayList;
        synchronized (this.a) {
            e();
            arrayList = new ArrayList(this.a.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                d dVar = (d) this.a.get(arrayList.get(size));
                if (!(dVar == null || dVar.a() == null)) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList a = a(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (a.get(i) != null) {
                a((String) arrayList.get(i), (c) a.get(i));
            }
        }
    }

    protected boolean e() {
        BufferedReader bufferedReader;
        IOException e;
        Throwable th;
        synchronized (this.a) {
            if (o) {
                return true;
            }
            o = true;
            this.a.clear();
            BufferedReader bufferedReader2 = null;
            try {
                File file = new File(this.c.getFilesDir(), g());
                if (file.isFile()) {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                    try {
                        StringBuilder stringBuilder = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuilder.append(readLine);
                        }
                        Object stringBuilder2 = stringBuilder.toString();
                        if (!TextUtils.isEmpty(stringBuilder2)) {
                            f(stringBuilder2);
                            Log.v("HostManager", "loading the new hosts succeed");
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e2) {
                                }
                            }
                            return true;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        try {
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e4) {
                                }
                            }
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e5) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader2 = bufferedReader;
                        try {
                            th.printStackTrace();
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e6) {
                                }
                            }
                            return false;
                        } catch (Throwable th4) {
                            th = th4;
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            throw th;
                        }
                    }
                }
                bufferedReader = null;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e7) {
                    }
                }
            } catch (IOException e8) {
                e = e8;
                bufferedReader = null;
                e.printStackTrace();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return false;
            } catch (Throwable th5) {
                th = th5;
                th.printStackTrace();
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                return false;
            }
            return false;
        }
    }

    public void f() {
        i();
        synchronized (this.a) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.c.openFileOutput(g(), 0)));
                Object jSONArray = l().toString();
                if (!TextUtils.isEmpty(jSONArray)) {
                    bufferedWriter.write(jSONArray);
                }
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    protected String g() {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.c.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == Process.myPid()) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return "com.xiaomi";
    }

    public ArrayList<com.xiaomi.b.a.a.a.c> h() {
        ArrayList<com.xiaomi.b.a.a.a.c> arrayList;
        synchronized (this.a) {
            Map hashMap = new HashMap();
            for (String str : this.a.keySet()) {
                d dVar = (d) this.a.get(str);
                if (dVar != null) {
                    Iterator it = dVar.b().iterator();
                    while (it.hasNext()) {
                        com.xiaomi.b.a.a.a.c cVar;
                        c cVar2 = (c) it.next();
                        com.xiaomi.b.a.a.a.c cVar3 = (com.xiaomi.b.a.a.a.c) hashMap.get(cVar2.d());
                        if (cVar3 == null) {
                            cVar3 = new com.xiaomi.b.a.a.a.c();
                            cVar3.a("httpapi");
                            cVar3.e(cVar2.f);
                            cVar3.d(e(cVar2.a));
                            cVar3.b(this.f);
                            cVar3.c(n);
                            cVar3.f(m);
                            cVar3.g(this.c.getPackageName());
                            cVar3.h(k());
                            i iVar = new i();
                            iVar.c(cVar2.d);
                            iVar.a(cVar2.g);
                            iVar.b(cVar2.c);
                            iVar.d(cVar2.e);
                            cVar3.a(iVar);
                            hashMap.put(cVar2.d(), cVar3);
                            cVar = cVar3;
                        } else {
                            cVar = cVar3;
                        }
                        com.xiaomi.b.a.a.a.a aVar = new com.xiaomi.b.a.a.a.a();
                        aVar.a(cVar2.b);
                        List arrayList2 = new ArrayList();
                        Iterator it2 = cVar2.e().iterator();
                        while (it2.hasNext()) {
                            q qVar = (q) it2.next();
                            ArrayList a = qVar.a();
                            if (!a.isEmpty()) {
                                com.xiaomi.b.a.a.a.g gVar = new com.xiaomi.b.a.a.a.g();
                                gVar.a(qVar.a);
                                int i = 0;
                                int i2 = 0;
                                long j = 0;
                                int i3 = 0;
                                Map hashMap2 = new HashMap();
                                Iterator it3 = a.iterator();
                                while (it3.hasNext()) {
                                    int d;
                                    a aVar2 = (a) it3.next();
                                    if (aVar2.a() >= 0) {
                                        j += aVar2.b();
                                        d = (int) (aVar2.d() + ((long) i3));
                                        i3 = i2;
                                        i2 = i + 1;
                                    } else {
                                        CharSequence e = aVar2.e();
                                        if (!TextUtils.isEmpty(e)) {
                                            hashMap2.put(e, Integer.valueOf(hashMap2.containsKey(e) ? ((Integer) hashMap2.get(e)).intValue() + 1 : 1));
                                        }
                                        d = i2 + 1;
                                        i2 = i;
                                        int i4 = d;
                                        d = i3;
                                        i3 = i4;
                                    }
                                    i = i2;
                                    i2 = i3;
                                    i3 = d;
                                }
                                gVar.a(hashMap2);
                                gVar.b(i);
                                gVar.a(i2);
                                gVar.a(j);
                                gVar.c(i3);
                                arrayList2.add(gVar);
                            }
                        }
                        if (!arrayList2.isEmpty()) {
                            aVar.a(arrayList2);
                            cVar.a(aVar);
                        }
                    }
                    continue;
                }
            }
            arrayList = new ArrayList();
            for (com.xiaomi.b.a.a.a.c cVar4 : hashMap.values()) {
                if (cVar4.g() > 0) {
                    arrayList.add(cVar4);
                }
            }
        }
        return arrayList;
    }

    public void i() {
        synchronized (this.a) {
            for (d c : this.a.values()) {
                c.c();
            }
            Object obj = null;
            while (obj == null) {
                for (String str : this.a.keySet()) {
                    if (((d) this.a.get(str)).b().isEmpty()) {
                        this.a.remove(str);
                        obj = null;
                        break;
                    }
                }
                obj = 1;
            }
        }
    }
}
