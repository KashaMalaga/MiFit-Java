package com.b;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.lab.sportmode.GroupItemBaseInfo;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.push.MiPushMessageReceiver;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.core.AMapLocException;
import com.amap.api.location.core.c;
import com.amap.api.location.core.d;
import com.amap.api.services.core.AMapException;
import com.tencent.connect.common.Constants;
import com.xiaomi.e.a;
import com.xiaomi.market.sdk.o;
import com.xiaomi.mipush.sdk.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import kankan.wheel.widget.l;
import org.json.JSONObject;

public class C0916a implements Z {
    private aa A = aa.a();
    private int B = 0;
    private String C = "00:00:00:00:00:00";
    private at D = null;
    private StringBuilder E = new StringBuilder();
    private long F = 0;
    private long G = 0;
    private CellLocation H = null;
    private boolean I = false;
    TimerTask a;
    Timer b;
    C0926k c;
    int d = 0;
    private Context e = null;
    private int f = 9;
    private ConnectivityManager g = null;
    private WifiManager h = null;
    private TelephonyManager i = null;
    private List<P> j = new ArrayList();
    private List<ScanResult> k = new ArrayList();
    private Map<PendingIntent, List<Y>> l = new HashMap();
    private Map<PendingIntent, List<Y>> m = new HashMap();
    private E n = new E();
    private PhoneStateListener o = null;
    private int p = -113;
    private C0919d q = new C0919d();
    private WifiInfo r = null;
    private JSONObject s = null;
    private String t = null;
    private M u = null;
    private long v = 0;
    private boolean w = false;
    private long x = 0;
    private long y = 0;
    private long z = 0;

    private M a(byte[] bArr, boolean z) {
        if (this.e == null) {
            return null;
        }
        ab abVar = new ab();
        ao.a();
        String a = this.A.a(bArr, this.e, this.s);
        ao.a();
        try {
            d.a(a);
        } catch (AMapLocException e) {
            throw e;
        } catch (Exception e2) {
        }
        String str = a.f;
        String[] a2 = aa.a(this.s);
        if (a != null && a.indexOf("<saps>") != -1) {
            a = this.n.a(abVar.a(a), "GBK");
        } else if (a2[0].equals("true")) {
            ao.a("api return pure");
        } else {
            ao.a("aps return pure");
        }
        M b = abVar.b(a);
        if (ao.a(b)) {
            if (b.t() != null) {
            }
            if (this.E == null || this.E.length() <= 0) {
                return b;
            }
            this.t = this.E.toString();
            return b;
        }
        throw new AMapLocException(AMapException.ERROR_UNKNOWN);
    }

    private P a(NeighboringCellInfo neighboringCellInfo) {
        if (ao.b() < 5) {
            return null;
        }
        try {
            P p = new P();
            String[] a = ao.a(this.i);
            p.a = a[0];
            p.b = a[1];
            p.c = neighboringCellInfo.getLac();
            p.d = neighboringCellInfo.getCid();
            p.j = ao.a(neighboringCellInfo.getRssi());
            return p;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private String a(int i, int i2, int i3) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(GroupItemBaseInfo.KEY_END_TIME, i);
        jSONObject.put("d", i2);
        jSONObject.put("u", i3);
        return jSONObject.toString();
    }

    private void a(CellLocation cellLocation) {
        CellLocation cellLocation2 = null;
        if (!(this.w || this.i == null || this.i == null)) {
            cellLocation2 = this.i.getCellLocation();
        }
        if (cellLocation2 != null) {
            cellLocation = cellLocation2;
        }
        if (cellLocation != null) {
            switch (ao.a(cellLocation, this.e)) {
                case l.a /*1*/:
                    if (this.i != null) {
                        c(cellLocation);
                        return;
                    }
                    return;
                case kankan.wheel.widget.a.k /*2*/:
                    d(cellLocation);
                    return;
                default:
                    return;
            }
        }
    }

    private void a(StringBuilder stringBuilder) {
        int i = 0;
        if (stringBuilder != null) {
            String[] strArr = new String[]{" phnum=\"\"", " nettype=\"\"", " nettype=\"UNKNOWN\"", " inftype=\"\"", "<macs><![CDATA[]]></macs>", "<nb></nb>", "<mmac><![CDATA[]]></mmac>", " gtype=\"0\"", " glong=\"0.0\"", " glat=\"0.0\"", " precision=\"0.0\"", " glong=\"0\"", " glat=\"0\"", " precision=\"0\"", "<smac>null</smac>", "<smac>00:00:00:00:00:00</smac>", "<imei>000000000000000</imei>", "<imsi>000000000000000</imsi>", "<mcc>000</mcc>", "<mcc>0</mcc>", "<lac>0</lac>", "<cellid>0</cellid>", "<key></key>"};
            int length = strArr.length;
            while (i < length) {
                String str = strArr[i];
                while (stringBuilder.indexOf(str) != -1) {
                    int indexOf = stringBuilder.indexOf(str);
                    stringBuilder.delete(indexOf, str.length() + indexOf);
                }
                i++;
            }
            while (stringBuilder.indexOf("*<") != -1) {
                stringBuilder.deleteCharAt(stringBuilder.indexOf("*<"));
            }
        }
    }

    private synchronized void a(List<ScanResult> list) {
        if (list != null) {
            if (list.size() >= 1) {
                Object hashMap = new HashMap();
                for (int i = 0; i < list.size(); i++) {
                    ScanResult scanResult = (ScanResult) list.get(i);
                    if (list.size() <= 20 || a(scanResult.level)) {
                        if (scanResult.SSID != null) {
                            scanResult.SSID = scanResult.SSID.replace("*", ".");
                        } else {
                            scanResult.SSID = "null";
                        }
                        hashMap.put(Integer.valueOf((scanResult.level * 30) + i), scanResult);
                    }
                }
                TreeMap treeMap = new TreeMap(Collections.reverseOrder());
                treeMap.putAll(hashMap);
                list.clear();
                for (Entry value : treeMap.entrySet()) {
                    list.add(value.getValue());
                    if (list.size() > 29) {
                        break;
                    }
                }
                hashMap.clear();
                treeMap.clear();
            }
        }
    }

    private boolean a(int i) {
        int i2 = 20;
        try {
            i2 = WifiManager.calculateSignalLevel(i, 20);
        } catch (Throwable e) {
            ao.a(e);
        }
        return i2 >= 1;
    }

    private boolean a(long j) {
        long a = ao.a();
        if (a - j >= 300) {
            return false;
        }
        long j2 = 0;
        if (this.u != null) {
            j2 = a - this.u.h();
        }
        return j2 <= 10000;
    }

    private boolean a(ScanResult scanResult) {
        boolean z = false;
        if (scanResult != null) {
            try {
                if (!(TextUtils.isEmpty(scanResult.BSSID) || scanResult.BSSID.equals("00:00:00:00:00:00"))) {
                    z = true;
                }
            } catch (Exception e) {
                return true;
            }
        }
        return z;
    }

    private boolean a(WifiInfo wifiInfo) {
        return (wifiInfo == null || wifiInfo.getBSSID() == null || wifiInfo.getSSID() == null || wifiInfo.getBSSID().equals("00:00:00:00:00:00") || TextUtils.isEmpty(wifiInfo.getSSID())) ? false : true;
    }

    private synchronized byte[] a(Object obj) {
        ag agVar;
        agVar = new ag();
        this.E.delete(0, this.E.length());
        String str = Constants.VIA_RESULT_SUCCESS;
        String str2 = Constants.VIA_RESULT_SUCCESS;
        String str3 = Constants.VIA_RESULT_SUCCESS;
        String str4 = Constants.VIA_RESULT_SUCCESS;
        String str5 = Constants.VIA_RESULT_SUCCESS;
        String str6 = a.f;
        Q.c = a.f;
        String str7 = a.f;
        str6 = a.f;
        String str8 = a.f;
        String str9 = "V1.3.1";
        String a = at.a(o.x);
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder stringBuilder3 = new StringBuilder();
        String str10 = this.f == 2 ? Constants.VIA_TO_TYPE_QQ_GROUP : str;
        if (this.i != null) {
            if (Q.a == null || "888888888888888".equals(Q.a)) {
                try {
                    Q.a = this.i.getDeviceId();
                    if (Q.a == null) {
                        Q.a = "888888888888888";
                    }
                } catch (SecurityException e) {
                }
            }
            if (Q.b == null || "888888888888888".equals(Q.b)) {
                try {
                    Q.b = this.i.getSubscriberId();
                    if (Q.b == null) {
                        Q.b = "888888888888888";
                    }
                } catch (SecurityException e2) {
                }
            }
        }
        NetworkInfo networkInfo = null;
        try {
            networkInfo = this.g.getActiveNetworkInfo();
        } catch (SecurityException e3) {
        }
        if (aa.a(networkInfo) != -1) {
            str7 = aa.a(this.i);
            if (t()) {
                if (a(this.r)) {
                    str = str7;
                    str7 = Constants.VIA_SSO_LOGIN;
                }
            }
            str6 = Constants.VIA_TO_TYPE_QQ_GROUP;
            if (!t()) {
                o();
                str = str7;
                str7 = str6;
            }
            str = str7;
            str7 = str6;
        } else {
            this.r = null;
            str = str7;
            str7 = str6;
        }
        String str11 = aa.a(this.s)[1];
        agVar.i = str10;
        agVar.j = str2;
        agVar.k = str3;
        agVar.l = str4;
        agVar.m = str5;
        agVar.c = Q.d;
        agVar.d = Q.e;
        agVar.n = str11;
        agVar.o = Q.a;
        agVar.r = Q.c;
        agVar.p = Q.b;
        agVar.q = this.C;
        agVar.s = str;
        agVar.t = str7;
        agVar.f = c.e();
        agVar.g = MiPushMessageReceiver.ANDROID + c.d();
        agVar.h = c.g() + f.i + c.h();
        agVar.B = str9;
        agVar.C = a;
        try {
            if (this.k != null && this.k.size() > 0) {
                agVar.E = (ao.a() - this.z) + a.f;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.E.append("<?xml version=\"1.0\" encoding=\"");
        this.E.append("GBK").append("\"?>");
        this.E.append("<Cell_Req ver=\"3.0\"><HDR version=\"3.0\" cdma=\"");
        this.E.append(str10);
        this.E.append("\" gtype=\"").append(str2);
        this.E.append("\" glong=\"").append(str3);
        this.E.append("\" glat=\"").append(str4);
        this.E.append("\" precision=\"").append(str5);
        this.E.append("\"><src>").append(Q.d);
        this.E.append("</src><license>").append(Q.e);
        this.E.append("</license><key>").append(str11);
        this.E.append("</key><clientid>").append(Q.f);
        this.E.append("</clientid><imei>").append(Q.a);
        this.E.append("</imei><imsi>").append(Q.b);
        this.E.append("</imsi><smac>").append(this.C);
        this.E.append("</smac></HDR><DRR phnum=\"").append(Q.c);
        this.E.append("\" nettype=\"").append(str);
        this.E.append("\" inftype=\"").append(str7).append("\">");
        if (this.j.size() > 0) {
            StringBuilder stringBuilder4 = new StringBuilder();
            P p;
            switch (this.f) {
                case l.a /*1*/:
                    p = (P) this.j.get(0);
                    stringBuilder4.delete(0, stringBuilder4.length());
                    stringBuilder4.append("<mcc>").append(p.a).append("</mcc>");
                    stringBuilder4.append("<mnc>").append(p.b).append("</mnc>");
                    stringBuilder4.append("<lac>").append(p.c).append("</lac>");
                    stringBuilder4.append("<cellid>").append(p.d);
                    stringBuilder4.append("</cellid>");
                    stringBuilder4.append("<signal>").append(p.j);
                    stringBuilder4.append("</signal>");
                    str8 = stringBuilder4.toString();
                    for (int i = 0; i < this.j.size(); i++) {
                        if (i != 0) {
                            p = (P) this.j.get(i);
                            stringBuilder.append(p.c).append(f.i);
                            stringBuilder.append(p.d).append(f.i);
                            stringBuilder.append(p.j);
                            if (i != this.j.size() - 1) {
                                stringBuilder.append("*");
                            }
                        }
                    }
                    str6 = str8;
                    break;
                case kankan.wheel.widget.a.k /*2*/:
                    p = (P) this.j.get(0);
                    stringBuilder4.delete(0, stringBuilder4.length());
                    stringBuilder4.append("<mcc>").append(p.a).append("</mcc>");
                    stringBuilder4.append("<sid>").append(p.g).append("</sid>");
                    stringBuilder4.append("<nid>").append(p.h).append("</nid>");
                    stringBuilder4.append("<bid>").append(p.i).append("</bid>");
                    if (p.f > 0 && p.e > 0) {
                        stringBuilder4.append("<lon>").append(p.f).append("</lon>");
                        stringBuilder4.append("<lat>").append(p.e).append("</lat>");
                    }
                    stringBuilder4.append("<signal>").append(p.j).append("</signal>");
                    str6 = stringBuilder4.toString();
                    break;
                default:
                    str6 = str8;
                    break;
            }
            stringBuilder4.delete(0, stringBuilder4.length());
            str7 = str6;
        } else {
            str7 = str8;
        }
        if (t()) {
            if (a(this.r)) {
                stringBuilder3.append(this.r.getBSSID()).append(f.i);
                stringBuilder3.append(this.r.getRssi()).append(f.i);
                stringBuilder3.append(this.r.getSSID().replace("*", "."));
            }
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                ScanResult scanResult = (ScanResult) this.k.get(i2);
                if (a(scanResult)) {
                    stringBuilder2.append(scanResult.BSSID).append(f.i);
                    stringBuilder2.append(scanResult.level).append(f.i);
                    stringBuilder2.append(i2).append("*");
                }
            }
        } else {
            o();
        }
        this.E.append(str7);
        this.E.append(String.format("<nb>%s</nb>", new Object[]{stringBuilder}));
        if (stringBuilder2.length() == 0) {
            this.E.append(String.format("<macs><![CDATA[%s]]></macs>", new Object[]{stringBuilder3}));
        } else {
            stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
            this.E.append(String.format("<macs><![CDATA[%s]]></macs>", new Object[]{stringBuilder2}));
        }
        this.E.append(String.format("<mmac><![CDATA[%s]]></mmac>", new Object[]{stringBuilder3}));
        this.E.append("</DRR></Cell_Req>");
        a(this.E);
        StringBuilder stringBuilder5 = stringBuilder2.length() == 0 ? stringBuilder3 : stringBuilder2;
        agVar.v = str7;
        agVar.w = stringBuilder.toString();
        agVar.x = stringBuilder3.toString();
        agVar.y = stringBuilder5.toString();
        agVar.u = String.valueOf(this.f);
        stringBuilder.delete(0, stringBuilder.length());
        stringBuilder5.delete(0, stringBuilder5.length());
        stringBuilder3.delete(0, stringBuilder3.length());
        return agVar.a();
    }

    private P b(CellLocation cellLocation) {
        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
        P p = new P();
        String[] a = ao.a(this.i);
        p.a = a[0];
        p.b = a[1];
        p.c = gsmCellLocation.getLac();
        p.d = gsmCellLocation.getCid();
        p.j = this.p;
        return p;
    }

    private void b(int i) {
        if (i == -113) {
            this.p = -113;
            return;
        }
        this.p = i;
        switch (this.f) {
            case l.a /*1*/:
            case kankan.wheel.widget.a.k /*2*/:
                if (this.j.size() > 0) {
                    ((P) this.j.get(0)).j = this.p;
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void c(int i) {
        try {
            if (ao.a() - this.F < 45000 || !e()) {
                return;
            }
            if (!e() || this.D.f() >= 20) {
                y();
                if (this.a == null) {
                    this.a = new C0918c(this, i);
                }
                if (this.b == null) {
                    this.b = new Timer(false);
                    this.b.schedule(this.a, kankan.wheel.widget.a.bX, kankan.wheel.widget.a.bX);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void c(CellLocation cellLocation) {
        if (this.j != null && cellLocation != null && this.i != null) {
            this.j.clear();
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            int i = gsmCellLocation.getLac() == -1 ? 0 : (gsmCellLocation.getCid() == -1 || gsmCellLocation.getCid() == android.support.v4.e.a.a.a || gsmCellLocation.getCid() >= 268435455) ? 0 : gsmCellLocation.getLac() == 0 ? 0 : gsmCellLocation.getLac() > android.support.v4.e.a.a.a ? 0 : gsmCellLocation.getCid() == 0 ? 0 : 1;
            if (i == 0) {
                this.f = 9;
                ao.a("case 2,gsm illegal");
                return;
            }
            this.f = 1;
            List list = null;
            this.j.add(b(cellLocation));
            if (this.i != null) {
                list = this.i.getNeighboringCellInfo();
            }
            if (r0 != null) {
                for (NeighboringCellInfo neighboringCellInfo : r0) {
                    if (neighboringCellInfo.getCid() != -1) {
                        int i2 = neighboringCellInfo.getLac() == -1 ? 0 : neighboringCellInfo.getLac() == 0 ? 0 : neighboringCellInfo.getLac() > android.support.v4.e.a.a.a ? 0 : neighboringCellInfo.getCid() == -1 ? 0 : neighboringCellInfo.getCid() == 0 ? 0 : neighboringCellInfo.getCid() == android.support.v4.e.a.a.a ? 0 : neighboringCellInfo.getCid() >= 268435455 ? 0 : 1;
                        if (i2 != 0) {
                            P a = a(neighboringCellInfo);
                            if (a != null) {
                                this.j.add(a);
                            }
                        }
                    }
                }
            }
        }
    }

    private void d(int i) {
        int i2 = 70254591;
        if (e()) {
            try {
                x();
                switch (i) {
                    case l.a /*1*/:
                        i2 = 674234367;
                        break;
                    case kankan.wheel.widget.a.k /*2*/:
                        if (!n()) {
                            i2 = 674234367;
                            break;
                        } else {
                            i2 = 2083520511;
                            break;
                        }
                }
                this.D.a(null, a(1, i2, 1));
                this.c = this.D.d();
                if (this.c != null) {
                    Object a = this.A.a(this.c.a(), this.e);
                    if (e()) {
                        if (TextUtils.isEmpty(a) || !a.equals("true")) {
                            this.d++;
                            this.D.a(this.c, a(1, i2, 0));
                        } else {
                            this.D.a(this.c, a(1, i2, 1));
                        }
                    }
                }
                y();
                if (e() && this.D.f() == 0) {
                    w();
                } else if (this.d >= 3) {
                    w();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                ao.a(th);
            }
        }
    }

    private void d(CellLocation cellLocation) {
        this.j.clear();
        if (ao.b() >= 5) {
            try {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                if (cdmaCellLocation.getSystemId() <= 0) {
                    this.f = 9;
                    ao.a("cdma illegal");
                } else if (cdmaCellLocation.getNetworkId() < 0) {
                    this.f = 9;
                    ao.a("cdma illegal");
                } else if (cdmaCellLocation.getBaseStationId() < 0) {
                    this.f = 9;
                    ao.a("cdma illegal");
                } else {
                    this.f = 2;
                    String[] a = ao.a(this.i);
                    P p = new P();
                    p.a = a[0];
                    p.b = a[1];
                    p.g = cdmaCellLocation.getSystemId();
                    p.h = cdmaCellLocation.getNetworkId();
                    p.i = cdmaCellLocation.getBaseStationId();
                    p.j = this.p;
                    p.e = cdmaCellLocation.getBaseStationLatitude();
                    p.f = cdmaCellLocation.getBaseStationLongitude();
                    this.j.add(p);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void f() {
        this.h = (WifiManager) ao.b(this.e, "wifi");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.e.registerReceiver(this.q, intentFilter);
        p();
    }

    private void g() {
        try {
            CellLocation.requestLocationUpdate();
        } catch (Throwable th) {
        }
    }

    private void h() {
        this.g = (ConnectivityManager) ao.b(this.e, "connectivity");
        g();
        this.y = ao.a();
        this.i = (TelephonyManager) ao.b(this.e, "phone");
        switch (this.i != null ? this.i.getPhoneType() : 9) {
            case l.a /*1*/:
                this.f = 1;
                break;
            case kankan.wheel.widget.a.k /*2*/:
                this.f = 2;
                break;
            default:
                this.f = 9;
                break;
        }
        this.o = new C0917b(this);
        int i = ao.b() < 7 ? 2 : PersonInfo.INCOMING_CALL_DISABLE_BIT;
        if (i != 0) {
            try {
                if (this.i != null) {
                    this.i.listen(this.o, i | 16);
                }
            } catch (Throwable e) {
                ao.a(e);
            }
        } else if (this.i != null) {
            this.i.listen(this.o, 16);
        }
    }

    private String i() {
        v();
        String str = a.f;
        String str2 = a.f;
        str2 = LocationManagerProxy.NETWORK_PROVIDER;
        if (t()) {
            this.r = this.h.getConnectionInfo();
        } else {
            o();
        }
        String str3 = a.f;
        P p;
        StringBuilder stringBuilder;
        switch (this.f) {
            case l.a /*1*/:
                if (this.j.size() > 0) {
                    p = (P) this.j.get(0);
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(p.a).append("#");
                    stringBuilder.append(p.b).append("#");
                    stringBuilder.append(p.c).append("#");
                    stringBuilder.append(p.d).append("#");
                    stringBuilder.append(str2).append("#");
                    stringBuilder.append(this.k.size() > 0 ? "cellwifi" : "cell");
                    return stringBuilder.toString();
                }
                break;
            case kankan.wheel.widget.a.k /*2*/:
                if (this.j.size() > 0) {
                    p = (P) this.j.get(0);
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(p.a).append("#");
                    stringBuilder.append(p.b).append("#");
                    stringBuilder.append(p.g).append("#");
                    stringBuilder.append(p.h).append("#");
                    stringBuilder.append(p.i).append("#");
                    stringBuilder.append(str2).append("#");
                    stringBuilder.append(this.k.size() > 0 ? "cellwifi" : "cell");
                    return stringBuilder.toString();
                }
                break;
            case kankan.wheel.widget.a.bo /*9*/:
                str2 = String.format("#%s#", new Object[]{str2});
                if ((this.k.size() == 1 && !a(this.r)) || this.k.size() == 0) {
                    return null;
                }
                if (this.k.size() != 1 || !a(this.r)) {
                    return str2 + "wifi";
                }
                ScanResult scanResult = (ScanResult) this.k.get(0);
                str = (scanResult == null || !this.r.getBSSID().equals(scanResult.BSSID)) ? str2 : null;
                return str;
        }
        return str;
    }

    private StringBuilder j() {
        v();
        StringBuilder stringBuilder = new StringBuilder(700);
        switch (this.f) {
            case l.a /*1*/:
                for (int i = 0; i < this.j.size(); i++) {
                    if (i != 0) {
                        P p = (P) this.j.get(i);
                        stringBuilder.append("#").append(p.b);
                        stringBuilder.append("|").append(p.c);
                        stringBuilder.append("|").append(p.d);
                    }
                }
                break;
        }
        if (this.C == null || this.C.equals("00:00:00:00:00:00")) {
            if (this.r != null) {
                this.C = this.r.getMacAddress();
                if (this.C == null) {
                    this.C = "00:00:00:00:00:00";
                }
            } else if (this.h != null) {
                this.r = this.h.getConnectionInfo();
                if (this.r != null) {
                    this.C = this.r.getMacAddress();
                    if (this.C == null) {
                        this.C = "00:00:00:00:00:00";
                    }
                    this.r = null;
                }
            }
        }
        if (t()) {
            String bssid = a(this.r) ? this.r.getBSSID() : a.f;
            int i2 = 0;
            for (int i3 = 0; i3 < this.k.size(); i3++) {
                ScanResult scanResult = (ScanResult) this.k.get(i3);
                if (a(scanResult)) {
                    String str = scanResult.BSSID;
                    String str2 = "nb";
                    if (bssid.equals(str)) {
                        str2 = "access";
                        i2 = 1;
                    }
                    stringBuilder.append(String.format("#%s,%s", new Object[]{str, str2}));
                }
            }
            if (i2 == 0 && bssid.length() > 0) {
                stringBuilder.append("#").append(bssid);
                stringBuilder.append(",access");
            }
        } else {
            o();
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(0);
        }
        return stringBuilder;
    }

    private synchronized byte[] k() {
        if (l()) {
            g();
            this.y = ao.a();
        }
        if (m()) {
            p();
        }
        return a(null);
    }

    private boolean l() {
        return (this.w || this.y == 0 || ao.a() - this.y < Q.j) ? false : true;
    }

    private boolean m() {
        return t() && this.z != 0 && ao.a() - this.z >= Q.i;
    }

    private boolean n() {
        if (this.h == null || !t()) {
            return false;
        }
        NetworkInfo networkInfo = null;
        try {
            if (this.g != null) {
                networkInfo = this.g.getActiveNetworkInfo();
            }
            return aa.a(networkInfo) != -1 && a(this.h.getConnectionInfo());
        } catch (SecurityException e) {
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private void o() {
        this.k.clear();
        this.r = null;
    }

    private void p() {
        if (t()) {
            try {
                this.h.startScan();
                this.z = ao.a();
            } catch (SecurityException e) {
            }
        }
    }

    private boolean q() {
        return this.x != 0 && ao.a() - this.x < 2000;
    }

    private void r() {
        if (this.u != null && this.l.size() >= 1) {
            Iterator it = this.l.entrySet().iterator();
            while (it != null && it.hasNext()) {
                Entry entry = (Entry) it.next();
                PendingIntent pendingIntent = (PendingIntent) entry.getKey();
                List<Y> list = (List) entry.getValue();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                for (Y y : list) {
                    long a = y.a();
                    if (a == -1 || a >= ao.a()) {
                        float a2 = ao.a(new double[]{y.b, y.a, this.u.f(), this.u.e()});
                        if (a2 < y.c) {
                            bundle.putFloat(cn.com.smartdevices.bracelet.relation.db.a.g, a2);
                            bundle.putString("fence", y.b());
                            intent.putExtras(bundle);
                            try {
                                pendingIntent.send(this.e, 0, intent);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    private void s() {
        switch (this.f) {
            case l.a /*1*/:
                if (this.j.size() == 0) {
                    this.f = 9;
                    return;
                }
                return;
            case kankan.wheel.widget.a.k /*2*/:
                if (this.j.size() == 0) {
                    this.f = 9;
                    return;
                }
                return;
            default:
                return;
        }
    }

    private boolean t() {
        boolean z = false;
        if (this.h != null) {
            try {
                z = this.h.isWifiEnabled();
            } catch (Exception e) {
            }
            if (!z && ao.b() > 17) {
                try {
                    z = String.valueOf(af.a(this.h, "isScanAlwaysAvailable", new Object[0])).equals("true");
                } catch (Exception e2) {
                }
            }
        }
        return z;
    }

    private M u() {
        byte[] k = k();
        if (this.E == null || !this.E.toString().equals(this.t) || this.u == null) {
            return a(k, false);
        }
        this.v = ao.a();
        return this.u;
    }

    private void v() {
        if (this.w) {
            this.f = 9;
            this.j.clear();
            return;
        }
        s();
    }

    private void w() {
        if (this.b != null) {
            this.b.cancel();
            this.b = null;
        }
        if (this.a != null) {
            this.a.cancel();
            this.a = null;
        }
    }

    private void x() {
        if (e()) {
            try {
                this.D.a(768);
            } catch (Throwable th) {
                th.printStackTrace();
                ao.a(th);
            }
        }
    }

    private void y() {
        if (e() && this.D.f() <= 0) {
            try {
                if (!this.D.e()) {
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public int a(boolean z, int i) {
        if (z) {
            c(i);
        } else {
            w();
        }
        return e() ? this.D.f() : -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.b.M a() {
        /*
        r10 = this;
        r2 = 0;
        r1 = 1;
        r0 = r10.e;
        if (r0 != 0) goto L_0x000e;
    L_0x0006:
        r0 = new com.amap.api.location.core.AMapLocException;
        r1 = "\u672a\u77e5\u7684\u9519\u8bef";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r0 = com.b.Q.d;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.amap.api.location.core.AMapLocException;
        r1 = "key\u9274\u6743\u5931\u8d25";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r0 = com.b.Q.e;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x002e;
    L_0x0026:
        r0 = new com.amap.api.location.core.AMapLocException;
        r1 = "key\u9274\u6743\u5931\u8d25";
        r0.<init>(r1);
        throw r0;
    L_0x002e:
        r0 = r10.s;
        r0 = com.b.aa.a(r0);
        r3 = "false";
        r0 = r0[r2];
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x004d;
    L_0x003e:
        r0 = "AuthLocation";
        r1 = "key\u9274\u6743\u5931\u8d25";
        android.util.Log.e(r0, r1);
        r0 = new com.amap.api.location.core.AMapLocException;
        r1 = "key\u9274\u6743\u5931\u8d25";
        r0.<init>(r1);
        throw r0;
    L_0x004d:
        r0 = r10.l();
        if (r0 == 0) goto L_0x005c;
    L_0x0053:
        r10.g();
        r4 = com.b.ao.a();
        r10.y = r4;
    L_0x005c:
        r0 = r10.m();
        if (r0 == 0) goto L_0x0065;
    L_0x0062:
        r10.p();
    L_0x0065:
        r0 = r10.B;
        r0 = r0 + 1;
        r10.B = r0;
        r0 = r10.B;
        if (r0 <= r1) goto L_0x0072;
    L_0x006f:
        r10.c();
    L_0x0072:
        r0 = r10.B;
        if (r0 != r1) goto L_0x0090;
    L_0x0076:
        r4 = java.lang.System.currentTimeMillis();
        r10.G = r4;
        r0 = r10.e;
        r0 = com.b.ao.a(r0);
        r10.w = r0;
        r0 = r10.h;
        if (r0 == 0) goto L_0x0090;
    L_0x0088:
        r0 = r10.h;
        r0 = r0.getScanResults();
        r10.k = r0;
    L_0x0090:
        r0 = r10.k;
        if (r0 != 0) goto L_0x009b;
    L_0x0094:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r10.k = r0;
    L_0x009b:
        r0 = r10.B;
        if (r0 != r1) goto L_0x00c3;
    L_0x009f:
        r0 = r10.t();
        if (r0 == 0) goto L_0x00c3;
    L_0x00a5:
        r4 = r10.G;
        r6 = r10.F;
        r4 = r4 - r6;
        r6 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 >= 0) goto L_0x00c3;
    L_0x00b0:
        r0 = 4;
    L_0x00b1:
        if (r0 <= 0) goto L_0x00c3;
    L_0x00b3:
        r3 = r10.k;
        r3 = r3.size();
        if (r3 != 0) goto L_0x00c3;
    L_0x00bb:
        r4 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        android.os.SystemClock.sleep(r4);
        r0 = r0 + -1;
        goto L_0x00b1;
    L_0x00c3:
        r4 = r10.v;
        r0 = r10.a(r4);
        if (r0 == 0) goto L_0x00d8;
    L_0x00cb:
        r0 = r10.u;
        if (r0 == 0) goto L_0x00d8;
    L_0x00cf:
        r0 = com.b.ao.a();
        r10.v = r0;
        r0 = r10.u;
    L_0x00d7:
        return r0;
    L_0x00d8:
        r0 = r10.H;	 Catch:{ Throwable -> 0x00f4 }
        r10.a(r0);	 Catch:{ Throwable -> 0x00f4 }
    L_0x00dd:
        r0 = r10.k;
        r10.a(r0);
        r3 = r10.i();
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 == 0) goto L_0x00f9;
    L_0x00ec:
        r0 = new com.amap.api.location.core.AMapLocException;
        r1 = "\u83b7\u53d6\u57fa\u7ad9/WiFi\u4fe1\u606f\u4e3a\u7a7a\u6216\u5931\u8d25";
        r0.<init>(r1);
        throw r0;
    L_0x00f4:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x00dd;
    L_0x00f9:
        r4 = r10.j();
        r0 = 0;
        r5 = r10.e;	 Catch:{ Throwable -> 0x014f }
        r5 = com.b.N.a(r5);	 Catch:{ Throwable -> 0x014f }
        r6 = "mem";
        r0 = r5.a(r3, r4, r6);	 Catch:{ Throwable -> 0x014f }
    L_0x010a:
        if (r0 == 0) goto L_0x0151;
    L_0x010c:
        r6 = r0.h();
        r8 = com.b.ao.a();
        r6 = r8 - r6;
        r8 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r5 <= 0) goto L_0x0151;
    L_0x011d:
        if (r0 == 0) goto L_0x0121;
    L_0x011f:
        if (r1 == 0) goto L_0x014c;
    L_0x0121:
        r0 = r10.u();	 Catch:{ AMapLocException -> 0x0148 }
    L_0x0125:
        r10.u = r0;
    L_0x0127:
        r0 = r10.e;
        r0 = com.b.N.a(r0);
        r1 = r10.u;
        r0.a(r3, r1, r4);
        r0 = r4.length();
        r4.delete(r2, r0);
        r0 = com.b.ao.a();
        r10.v = r0;
        r10.r();
        r10.d();
        r0 = r10.u;
        goto L_0x00d7;
    L_0x0148:
        r1 = move-exception;
        if (r0 != 0) goto L_0x0125;
    L_0x014b:
        throw r1;
    L_0x014c:
        r10.u = r0;
        goto L_0x0127;
    L_0x014f:
        r5 = move-exception;
        goto L_0x010a;
    L_0x0151:
        r1 = r2;
        goto L_0x011d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.a():com.b.M");
    }

    public void a(PendingIntent pendingIntent) {
        if (pendingIntent != null) {
            this.l.remove(pendingIntent);
        }
    }

    public void a(Context context) {
        if (context != null && this.e == null) {
            this.e = context.getApplicationContext();
            ao.a(this.e, "in debug mode, only for test");
            f();
            h();
            this.F = System.currentTimeMillis();
        }
    }

    public void a(AMapLocation aMapLocation) {
        if (aMapLocation != null && this.m.size() >= 1) {
            Iterator it = this.m.entrySet().iterator();
            while (it != null && it.hasNext()) {
                Entry entry = (Entry) it.next();
                PendingIntent pendingIntent = (PendingIntent) entry.getKey();
                List<Y> list = (List) entry.getValue();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                for (Y y : list) {
                    long a = y.a();
                    if (a == -1 || a >= ao.a()) {
                        float a2 = ao.a(new double[]{y.b, y.a, aMapLocation.getLatitude(), aMapLocation.getLongitude()});
                        if (a2 >= y.c) {
                            if (y.d != 0) {
                                y.d = 0;
                            }
                        }
                        if (a2 < y.c) {
                            if (y.d != 1) {
                                y.d = 1;
                            }
                        }
                        bundle.putFloat(cn.com.smartdevices.bracelet.relation.db.a.g, a2);
                        bundle.putString("fence", y.b());
                        bundle.putInt(LocationManagerProxy.KEY_STATUS_CHANGED, y.d);
                        intent.putExtras(bundle);
                        try {
                            pendingIntent.send(this.e, 0, intent);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void a(Y y, PendingIntent pendingIntent) {
        if (pendingIntent != null && y != null) {
            long a = y.a();
            if (a != -1 && a < ao.a()) {
                return;
            }
            List list;
            if (this.l.get(pendingIntent) != null) {
                list = (List) this.l.get(pendingIntent);
                list.add(y);
                this.l.put(pendingIntent, list);
                return;
            }
            list = new ArrayList();
            list.add(y);
            this.l.put(pendingIntent, list);
        }
    }

    public void a(String str) {
        if (str != null && str.indexOf("##") != -1) {
            String[] split = str.split("##");
            if (split.length == 3) {
                Q.a(split[0]);
                if (!Q.e.equals(split[1])) {
                    N.a(this.e).a();
                }
                Q.b(split[1]);
                Q.c(split[2]);
            }
        }
    }

    public void a(JSONObject jSONObject) {
        this.s = jSONObject;
    }

    public void b() {
        try {
            if (this.D != null) {
                this.D.c();
                this.I = false;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            if (this.e != null) {
                this.e.unregisterReceiver(this.q);
            }
        } catch (Throwable th2) {
            this.q = null;
        }
        this.q = null;
        w();
        try {
            if (!(this.i == null || this.o == null)) {
                this.i.listen(this.o, 0);
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
            ao.a(th3);
        }
        if (this.e != null) {
            N.a(this.e).a();
            N.a(this.e).b();
        }
        Q.a(false);
        this.v = 0;
        this.j.clear();
        this.l.clear();
        this.m.clear();
        this.p = -113;
        o();
        this.t = null;
        this.u = null;
        this.e = null;
        this.i = null;
    }

    public void b(PendingIntent pendingIntent) {
        if (pendingIntent != null) {
            this.m.remove(pendingIntent);
        }
    }

    public void b(Y y, PendingIntent pendingIntent) {
        if (pendingIntent != null && y != null) {
            long a = y.a();
            if (a != -1 && a < ao.a()) {
                return;
            }
            List list;
            if (this.m.get(pendingIntent) != null) {
                list = (List) this.m.get(pendingIntent);
                list.add(y);
                this.m.put(pendingIntent, list);
                return;
            }
            list = new ArrayList();
            list.add(y);
            this.m.put(pendingIntent, list);
        }
    }

    public void c() {
        try {
            if (this.D == null) {
                this.D = at.a(this.e);
                this.D.a((int) PersonInfo.INCOMING_CALL_DISABLE_BIT);
            }
            if (!this.I) {
                this.I = true;
                this.D.a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void d() {
        if (this.u != null && this.m.size() >= 1) {
            Iterator it = this.m.entrySet().iterator();
            while (it != null && it.hasNext()) {
                Entry entry = (Entry) it.next();
                PendingIntent pendingIntent = (PendingIntent) entry.getKey();
                List<Y> list = (List) entry.getValue();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                for (Y y : list) {
                    long a = y.a();
                    if (a == -1 || a >= ao.a()) {
                        float a2 = ao.a(new double[]{y.b, y.a, this.u.f(), this.u.e()});
                        if (a2 >= y.c) {
                            if (y.d != 0) {
                                y.d = 0;
                            }
                        }
                        if (a2 < y.c) {
                            if (y.d != 1) {
                                y.d = 1;
                            }
                        }
                        bundle.putFloat(cn.com.smartdevices.bracelet.relation.db.a.g, a2);
                        bundle.putString("fence", y.b());
                        bundle.putInt(LocationManagerProxy.KEY_STATUS_CHANGED, y.d);
                        intent.putExtras(bundle);
                        try {
                            pendingIntent.send(this.e, 0, intent);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    boolean e() {
        return this.D != null;
    }
}
