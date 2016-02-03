package com.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.GpsStatus.NmeaListener;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.support.v4.view.a.C0113o;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.weight.family.h;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.d.a.a.C1012a;
import com.tencent.connect.common.Constants;
import com.xiaomi.e.a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TreeMap;
import kankan.wheel.widget.l;

public final class C0930o {
    private static int D = C1012a.b;
    private static C0930o u = null;
    private Timer A = null;
    private Thread B = null;
    private Looper C = null;
    private Context a = null;
    private TelephonyManager b = null;
    private LocationManager c = null;
    private WifiManager d = null;
    private SensorManager e = null;
    private String f = a.f;
    private String g = a.f;
    private String h = a.f;
    private boolean i = false;
    private int j = 0;
    private boolean k = false;
    private long l = -1;
    private String m = a.f;
    private String n = a.f;
    private int o = 0;
    private int p = 0;
    private int q = 0;
    private String r = a.f;
    private long s = 0;
    private long t = 0;
    private C0932q v = null;
    private C0933r w = null;
    private CellLocation x = null;
    private C0934s y = null;
    private List z = new ArrayList();

    private C0930o(Context context) {
        if (context != null) {
            this.a = context;
            this.f = Build.MODEL;
            this.b = (TelephonyManager) context.getSystemService("phone");
            this.c = (LocationManager) context.getSystemService(com.xiaomi.channel.relationservice.data.a.l);
            this.d = (WifiManager) context.getSystemService("wifi");
            this.e = (SensorManager) context.getSystemService("sensor");
            if (this.b != null && this.d != null) {
                try {
                    this.g = this.b.getDeviceId();
                } catch (Exception e) {
                }
                this.h = this.b.getSubscriberId();
                if (this.d.getConnectionInfo() != null) {
                    this.n = this.d.getConnectionInfo().getMacAddress();
                    if (this.n != null && this.n.length() > 0) {
                        this.n = this.n.replace(kankan.wheel.widget.a.ci, a.f);
                    }
                }
                String[] b = C0930o.b(this.b);
                this.o = Integer.parseInt(b[0]);
                this.p = Integer.parseInt(b[1]);
                this.q = this.b.getNetworkType();
                this.r = context.getPackageName();
                this.i = this.b.getPhoneType() == 2;
            }
        }
    }

    private void A() {
        if (this.d != null) {
            try {
                if (I.a) {
                    this.d.startScan();
                }
            } catch (Exception e) {
            }
        }
    }

    private CellLocation B() {
        if (this.b == null) {
            return null;
        }
        CellLocation b;
        try {
            b = C0930o.b((List) C0927l.a(this.b, "getAllCellInfo", new Object[0]));
        } catch (NoSuchMethodException e) {
            b = null;
        } catch (Exception e2) {
            b = null;
        }
        return b;
    }

    private static int a(CellLocation cellLocation, Context context) {
        if (System.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 1 || cellLocation == null) {
            return 9;
        }
        if (cellLocation instanceof GsmCellLocation) {
            return 1;
        }
        try {
            Class.forName("android.telephony.cdma.CdmaCellLocation");
            return 2;
        } catch (Exception e) {
            return 9;
        }
    }

    protected static C0930o a(Context context) {
        if (u == null && C0930o.c(context)) {
            Object obj;
            LocationManager locationManager = (LocationManager) context.getSystemService(com.xiaomi.channel.relationservice.data.a.l);
            if (locationManager != null) {
                for (String str : locationManager.getAllProviders()) {
                    if (!str.equals("passive")) {
                        if (str.equals(GeocodeSearch.GPS)) {
                        }
                    }
                    obj = 1;
                }
            }
            obj = null;
            if (obj != null) {
                u = new C0930o(context);
            }
        }
        return u;
    }

    private void a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null && this.a != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            this.a.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    static /* synthetic */ void a(C0930o c0930o, NmeaListener nmeaListener) {
        if (c0930o.c != null && nmeaListener != null) {
            c0930o.c.addNmeaListener(nmeaListener);
        }
    }

    static /* synthetic */ void a(C0930o c0930o, PhoneStateListener phoneStateListener) {
        if (c0930o.b != null) {
            c0930o.b.listen(phoneStateListener, h.d);
        }
    }

    private static void a(List list) {
        if (list != null && list.size() > 0) {
            Object hashMap = new HashMap();
            for (int i = 0; i < list.size(); i++) {
                ScanResult scanResult = (ScanResult) list.get(i);
                if (scanResult.SSID == null) {
                    scanResult.SSID = "null";
                }
                hashMap.put(Integer.valueOf(scanResult.level), scanResult);
            }
            TreeMap treeMap = new TreeMap(Collections.reverseOrder());
            treeMap.putAll(hashMap);
            list.clear();
            for (Integer num : treeMap.keySet()) {
                list.add(treeMap.get(num));
            }
            hashMap.clear();
            treeMap.clear();
        }
    }

    private boolean a(CellLocation cellLocation) {
        if (cellLocation == null) {
            return false;
        }
        switch (C0930o.a(cellLocation, this.a)) {
            case l.a /*1*/:
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                if (gsmCellLocation.getLac() == -1 || gsmCellLocation.getLac() == 0 || gsmCellLocation.getLac() > android.support.v4.e.a.a.a || gsmCellLocation.getCid() == -1 || gsmCellLocation.getCid() == 0 || gsmCellLocation.getCid() == android.support.v4.e.a.a.a) {
                    return false;
                }
                if (gsmCellLocation.getCid() >= 268435455) {
                    return false;
                }
                break;
            case kankan.wheel.widget.a.k /*2*/:
                try {
                    if (C0927l.b(cellLocation, "getSystemId", new Object[0]) <= 0 || C0927l.b(cellLocation, "getNetworkId", new Object[0]) < 0) {
                        return false;
                    }
                    if (C0927l.b(cellLocation, "getBaseStationId", new Object[0]) < 0) {
                        return false;
                    }
                } catch (Exception e) {
                    break;
                }
                break;
        }
        return true;
    }

    private static boolean a(Object obj) {
        try {
            Method declaredMethod = WifiManager.class.getDeclaredMethod("isScanAlwaysAvailable", null);
            if (declaredMethod != null) {
                return ((Boolean) declaredMethod.invoke(obj, null)).booleanValue();
            }
        } catch (Exception e) {
        }
        return false;
    }

    private static int b(Object obj) {
        try {
            Method declaredMethod = Sensor.class.getDeclaredMethod("getMinDelay", null);
            if (declaredMethod != null) {
                return ((Integer) declaredMethod.invoke(obj, null)).intValue();
            }
        } catch (Exception e) {
        }
        return 0;
    }

    private static CellLocation b(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int i;
        CellLocation cellLocation;
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        CellLocation cellLocation2 = null;
        int i2 = 0;
        int i3 = 0;
        CellLocation cellLocation3 = null;
        while (i2 < list.size()) {
            CellLocation cellLocation4;
            Object obj = list.get(i2);
            if (obj != null) {
                try {
                    Class loadClass = systemClassLoader.loadClass("android.telephony.CellInfoGsm");
                    Class loadClass2 = systemClassLoader.loadClass("android.telephony.CellInfoWcdma");
                    Class loadClass3 = systemClassLoader.loadClass("android.telephony.CellInfoLte");
                    Class loadClass4 = systemClassLoader.loadClass("android.telephony.CellInfoCdma");
                    i = loadClass.isInstance(obj) ? 1 : loadClass2.isInstance(obj) ? 2 : loadClass3.isInstance(obj) ? 3 : loadClass4.isInstance(obj) ? 4 : 0;
                    if (i > 0) {
                        Object obj2 = null;
                        if (i == 1) {
                            try {
                                obj2 = loadClass.cast(obj);
                            } catch (Exception e) {
                                i3 = i;
                                cellLocation4 = cellLocation2;
                            }
                        } else if (i == 2) {
                            obj2 = loadClass2.cast(obj);
                        } else if (i == 3) {
                            obj2 = loadClass3.cast(obj);
                        } else if (i == 4) {
                            obj2 = loadClass4.cast(obj);
                        }
                        obj = C0927l.a(obj2, "getCellIdentity", new Object[0]);
                        if (obj != null) {
                            if (i != 4) {
                                int b;
                                if (i != 3) {
                                    i3 = C0927l.b(obj, "getLac", new Object[0]);
                                    b = C0927l.b(obj, "getCid", new Object[0]);
                                    cellLocation4 = new GsmCellLocation();
                                    cellLocation4.setLacAndCid(i3, b);
                                    cellLocation = cellLocation3;
                                    cellLocation3 = cellLocation4;
                                    break;
                                }
                                i3 = C0927l.b(obj, "getTac", new Object[0]);
                                b = C0927l.b(obj, "getCi", new Object[0]);
                                cellLocation4 = new GsmCellLocation();
                                try {
                                    cellLocation4.setLacAndCid(i3, b);
                                    cellLocation = cellLocation3;
                                    cellLocation3 = cellLocation4;
                                    break;
                                } catch (Exception e2) {
                                    i3 = i;
                                }
                            } else {
                                cellLocation = new CdmaCellLocation();
                                try {
                                    cellLocation.setCellLocationData(C0927l.b(obj, "getBasestationId", new Object[0]), C0927l.b(obj, "getLatitude", new Object[0]), C0927l.b(obj, "getLongitude", new Object[0]), C0927l.b(obj, "getSystemId", new Object[0]), C0927l.b(obj, "getNetworkId", new Object[0]));
                                    cellLocation3 = cellLocation2;
                                    break;
                                } catch (Exception e3) {
                                    cellLocation3 = cellLocation;
                                    cellLocation4 = cellLocation2;
                                    i3 = i;
                                }
                            }
                        } else {
                            i3 = i;
                            cellLocation4 = cellLocation2;
                        }
                    } else {
                        i3 = i;
                        cellLocation4 = cellLocation2;
                    }
                } catch (Exception e4) {
                    cellLocation4 = cellLocation2;
                }
            } else {
                cellLocation4 = cellLocation2;
            }
            i2++;
            cellLocation2 = cellLocation4;
        }
        i = i3;
        cellLocation = cellLocation3;
        cellLocation3 = cellLocation2;
        return i != 4 ? cellLocation3 : cellLocation;
    }

    private void b(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null && this.a != null) {
            try {
                this.a.unregisterReceiver(broadcastReceiver);
            } catch (Exception e) {
            }
        }
    }

    protected static boolean b(Context context) {
        if (context == null) {
            return true;
        }
        boolean z;
        if (!Secure.getString(context.getContentResolver(), "mock_location").equals(Constants.VIA_RESULT_SUCCESS)) {
            PackageManager packageManager = context.getPackageManager();
            List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(C0113o.h);
            String str = "android.permission.ACCESS_MOCK_LOCATION";
            String packageName = context.getPackageName();
            z = false;
            for (ApplicationInfo applicationInfo : installedApplications) {
                if (z) {
                    break;
                }
                boolean z2;
                try {
                    String[] strArr = packageManager.getPackageInfo(applicationInfo.packageName, ChartData.d).requestedPermissions;
                    if (strArr != null) {
                        int length = strArr.length;
                        int i = 0;
                        while (i < length) {
                            if (!strArr[i].equals(str)) {
                                i++;
                            } else if (!applicationInfo.packageName.equals(packageName)) {
                                z2 = true;
                                z = z2;
                            }
                        }
                    }
                } catch (Exception e) {
                    z2 = z;
                }
            }
        } else {
            z = false;
        }
        return z;
    }

    private static String[] b(TelephonyManager telephonyManager) {
        int i = 0;
        String str = null;
        if (telephonyManager != null) {
            str = telephonyManager.getNetworkOperator();
        }
        String[] strArr = new String[]{Constants.VIA_RESULT_SUCCESS, Constants.VIA_RESULT_SUCCESS};
        if (TextUtils.isDigitsOnly(str) && str.length() > 4) {
            strArr[0] = str.substring(0, 3);
            char[] toCharArray = str.substring(3).toCharArray();
            while (i < toCharArray.length && Character.isDigit(toCharArray[i])) {
                i++;
            }
            strArr[1] = str.substring(3, i + 3);
        }
        return strArr;
    }

    private static boolean c(Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), ChartData.d).requestedPermissions;
            for (String a : I.b) {
                if (!I.a(strArr, a)) {
                    return false;
                }
            }
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    protected final String a(int i) {
        ArrayList arrayList = new ArrayList();
        if (this.e == null) {
            return "null";
        }
        List sensorList = this.e.getSensorList(-1);
        return (sensorList == null || sensorList.get(i) == null || ((Sensor) sensorList.get(i)).getName() == null || ((Sensor) sensorList.get(i)).getName().length() <= 0) ? "null" : ((Sensor) sensorList.get(i)).getName();
    }

    protected final List a(float f) {
        List arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(f) <= 1.0f) {
            f = 1.0f;
        }
        if (c()) {
            CellLocation cellLocation = (CellLocation) j().get(1);
            if (cellLocation != null && (cellLocation instanceof GsmCellLocation)) {
                arrayList.add(Integer.valueOf(((GsmCellLocation) cellLocation).getLac()));
                arrayList.add(Integer.valueOf(((GsmCellLocation) cellLocation).getCid()));
                if (((double) (currentTimeMillis - ((Long) j().get(0)).longValue())) <= 50000.0d / ((double) f)) {
                    arrayList.add(Integer.valueOf(1));
                } else {
                    arrayList.add(Integer.valueOf(0));
                }
            }
        }
        return arrayList;
    }

    protected final void a() {
        String str = a.f;
        b();
        if (this.C != null) {
            this.C.quit();
            this.C = null;
        }
        if (this.B != null) {
            this.B.interrupt();
            this.B = null;
        }
        this.B = new C0931p(this, str);
        this.B.start();
    }

    protected final double b(int i) {
        ArrayList arrayList = new ArrayList();
        if (this.e == null) {
            return 0.0d;
        }
        List sensorList = this.e.getSensorList(-1);
        return (sensorList == null || sensorList.get(i) == null) ? 0.0d : (double) ((Sensor) sensorList.get(i)).getMaximumRange();
    }

    protected final List b(float f) {
        List arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(f) <= 1.0f) {
            f = 1.0f;
        }
        if (c()) {
            CellLocation cellLocation = (CellLocation) j().get(1);
            if (cellLocation != null && (cellLocation instanceof CdmaCellLocation)) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                arrayList.add(Integer.valueOf(cdmaCellLocation.getSystemId()));
                arrayList.add(Integer.valueOf(cdmaCellLocation.getNetworkId()));
                arrayList.add(Integer.valueOf(cdmaCellLocation.getBaseStationId()));
                arrayList.add(Integer.valueOf(cdmaCellLocation.getBaseStationLongitude()));
                arrayList.add(Integer.valueOf(cdmaCellLocation.getBaseStationLatitude()));
                if (((double) (currentTimeMillis - ((Long) j().get(0)).longValue())) <= 50000.0d / ((double) f)) {
                    arrayList.add(Integer.valueOf(1));
                } else {
                    arrayList.add(Integer.valueOf(0));
                }
            }
        }
        return arrayList;
    }

    protected final void b() {
        if (this.v != null) {
            PhoneStateListener phoneStateListener = this.v;
            if (this.b != null) {
                this.b.listen(phoneStateListener, 0);
            }
            this.v = null;
        }
        if (this.w != null) {
            NmeaListener nmeaListener = this.w;
            if (!(this.c == null || nmeaListener == null)) {
                this.c.removeNmeaListener(nmeaListener);
            }
            this.w = null;
        }
        if (this.A != null) {
            this.A.cancel();
            this.A = null;
        }
        if (this.C != null) {
            this.C.quit();
            this.C = null;
        }
        if (this.B != null) {
            this.B.interrupt();
            this.B = null;
        }
    }

    protected final int c(int i) {
        ArrayList arrayList = new ArrayList();
        if (this.e == null) {
            return 0;
        }
        List sensorList = this.e.getSensorList(-1);
        return (sensorList == null || sensorList.get(i) == null) ? 0 : C0930o.b(sensorList.get(i));
    }

    protected final boolean c() {
        CellLocation cellLocation = null;
        if (this.b != null && this.b.getSimState() == 5 && this.k) {
            return true;
        }
        if (this.b != null) {
            try {
                cellLocation = this.b.getCellLocation();
            } catch (Exception e) {
            }
            if (cellLocation != null) {
                this.t = System.currentTimeMillis();
                this.x = cellLocation;
                return true;
            }
        }
        return false;
    }

    protected final int d(int i) {
        ArrayList arrayList = new ArrayList();
        if (this.e == null) {
            return 0;
        }
        List sensorList = this.e.getSensorList(-1);
        return (sensorList == null || sensorList.get(i) == null) ? 0 : (int) (((double) ((Sensor) sensorList.get(i)).getPower()) * 100.0d);
    }

    protected final boolean d() {
        return this.d != null && (this.d.isWifiEnabled() || C0930o.a(this.d));
    }

    protected final double e(int i) {
        ArrayList arrayList = new ArrayList();
        if (this.e == null) {
            return 0.0d;
        }
        List sensorList = this.e.getSensorList(-1);
        return (sensorList == null || sensorList.get(i) == null) ? 0.0d : (double) ((Sensor) sensorList.get(i)).getResolution();
    }

    protected final boolean e() {
        try {
            if (this.c != null && this.c.isProviderEnabled(GeocodeSearch.GPS)) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    protected final byte f(int i) {
        ArrayList arrayList = new ArrayList();
        if (this.e == null) {
            return kankan.wheel.widget.a.ab;
        }
        List sensorList = this.e.getSensorList(-1);
        return (sensorList == null || sensorList.get(i) == null || ((Sensor) sensorList.get(i)).getType() > android.support.v4.media.h.j) ? kankan.wheel.widget.a.ab : (byte) ((Sensor) sensorList.get(i)).getType();
    }

    protected final String f() {
        if (this.f == null) {
            this.f = Build.MODEL;
        }
        return this.f != null ? this.f : a.f;
    }

    protected final String g() {
        if (this.g == null && this.a != null) {
            this.b = (TelephonyManager) this.a.getSystemService("phone");
            if (this.b != null) {
                try {
                    this.g = this.b.getDeviceId();
                } catch (Exception e) {
                }
            }
        }
        return this.g != null ? this.g : a.f;
    }

    protected final String g(int i) {
        ArrayList arrayList = new ArrayList();
        if (this.e == null) {
            return "null";
        }
        List sensorList = this.e.getSensorList(-1);
        return (sensorList == null || sensorList.get(i) == null || ((Sensor) sensorList.get(i)).getVendor() == null || ((Sensor) sensorList.get(i)).getVendor().length() <= 0) ? "null" : ((Sensor) sensorList.get(i)).getVendor();
    }

    protected final byte h(int i) {
        ArrayList arrayList = new ArrayList();
        if (this.e == null) {
            return kankan.wheel.widget.a.ab;
        }
        List sensorList = this.e.getSensorList(-1);
        return (sensorList == null || sensorList.get(i) == null || ((Sensor) sensorList.get(i)).getType() > android.support.v4.media.h.j) ? kankan.wheel.widget.a.ab : (byte) ((Sensor) sensorList.get(i)).getVersion();
    }

    protected final String h() {
        if (this.h == null && this.a != null) {
            this.b = (TelephonyManager) this.a.getSystemService("phone");
            if (this.b != null) {
                this.h = this.b.getSubscriberId();
            }
        }
        return this.h != null ? this.h : a.f;
    }

    protected final boolean i() {
        return this.i;
    }

    protected final List j() {
        if (System.getInt(this.a.getContentResolver(), "airplane_mode_on", 0) == 1) {
            return new ArrayList();
        }
        if (!c()) {
            return new ArrayList();
        }
        Object B;
        List arrayList = new ArrayList();
        if (!a(this.x)) {
            B = B();
            if (a((CellLocation) B)) {
                this.t = System.currentTimeMillis();
                arrayList.add(Long.valueOf(this.t));
                arrayList.add(B);
                return arrayList;
            }
        }
        B = this.x;
        arrayList.add(Long.valueOf(this.t));
        arrayList.add(B);
        return arrayList;
    }

    protected final List k() {
        int i = 0;
        List arrayList = new ArrayList();
        if (!d()) {
            return new ArrayList();
        }
        List arrayList2 = new ArrayList();
        synchronized (this) {
            if ((System.currentTimeMillis() - this.s < 3500 ? 1 : 0) != 0) {
                arrayList2.add(Long.valueOf(this.s));
                while (i < this.z.size()) {
                    arrayList.add(this.z.get(i));
                    i++;
                }
                arrayList2.add(arrayList);
            }
        }
        return arrayList2;
    }

    protected final byte l() {
        return c() ? (byte) this.j : Byte.MIN_VALUE;
    }

    protected final List m() {
        List arrayList = new ArrayList();
        if (this.b == null) {
            return arrayList;
        }
        if (!c()) {
            return arrayList;
        }
        if (this.b.getSimState() == 1) {
            return arrayList;
        }
        int i = 0;
        for (NeighboringCellInfo neighboringCellInfo : this.b.getNeighboringCellInfo()) {
            if (i > 15) {
                break;
            } else if (!(neighboringCellInfo.getLac() == 0 || neighboringCellInfo.getLac() == android.support.v4.e.a.a.a || neighboringCellInfo.getCid() == android.support.v4.e.a.a.a || neighboringCellInfo.getCid() == 268435455)) {
                arrayList.add(neighboringCellInfo);
                i++;
            }
        }
        return arrayList;
    }

    protected final List n() {
        long j;
        Object obj;
        List arrayList = new ArrayList();
        String str = a.f;
        if (e()) {
            long j2 = this.l;
            j = j2;
            obj = this.m;
        } else {
            String str2 = str;
            j = -1;
            String str3 = str2;
        }
        if (j <= 0) {
            j = System.currentTimeMillis() / 1000;
        }
        if (j > 2147483647L) {
            j /= 1000;
        }
        arrayList.add(Long.valueOf(j));
        arrayList.add(obj);
        return arrayList;
    }

    protected final long o() {
        long j = 0;
        long j2 = this.l;
        if (j2 > 0) {
            j = j2;
            int length = String.valueOf(j2).length();
            while (length != 13) {
                j = length > 13 ? j / 10 : j * 10;
                length = String.valueOf(j).length();
            }
        }
        return j;
    }

    protected final String p() {
        if (this.n == null && this.a != null) {
            this.d = (WifiManager) this.a.getSystemService("wifi");
            if (!(this.d == null || this.d.getConnectionInfo() == null)) {
                this.n = this.d.getConnectionInfo().getMacAddress();
                if (this.n != null && this.n.length() > 0) {
                    this.n = this.n.replace(kankan.wheel.widget.a.ci, a.f);
                }
            }
        }
        return this.n != null ? this.n : a.f;
    }

    protected final int q() {
        return this.o;
    }

    protected final int r() {
        return this.p;
    }

    protected final int s() {
        return this.q;
    }

    protected final String t() {
        if (this.r == null && this.a != null) {
            this.r = this.a.getPackageName();
        }
        return this.r != null ? this.r : a.f;
    }

    protected final List u() {
        int i = 0;
        List arrayList = new ArrayList();
        if (d()) {
            List k = k();
            List list = (List) k.get(1);
            long longValue = ((Long) k.get(0)).longValue();
            C0930o.a(list);
            arrayList.add(Long.valueOf(longValue));
            if (list != null && list.size() > 0) {
                while (i < list.size()) {
                    ScanResult scanResult = (ScanResult) list.get(i);
                    if (arrayList.size() - 1 >= 40) {
                        break;
                    }
                    if (scanResult != null) {
                        List arrayList2 = new ArrayList();
                        arrayList2.add(scanResult.BSSID.replace(kankan.wheel.widget.a.ci, a.f));
                        arrayList2.add(Integer.valueOf(scanResult.level));
                        arrayList2.add(scanResult.SSID);
                        arrayList.add(arrayList2);
                    }
                    i++;
                }
            }
        }
        return arrayList;
    }

    protected final void v() {
        synchronized (this) {
            this.z.clear();
        }
        if (this.y != null) {
            b(this.y);
            this.y = null;
        }
        if (this.A != null) {
            this.A.cancel();
            this.A = null;
        }
        this.A = new Timer();
        this.y = new C0934s();
        a(this.y);
        A();
    }

    protected final void w() {
        synchronized (this) {
            this.z.clear();
        }
        if (this.y != null) {
            b(this.y);
            this.y = null;
        }
        if (this.A != null) {
            this.A.cancel();
            this.A = null;
        }
    }

    protected final byte x() {
        ArrayList arrayList = new ArrayList();
        if (this.e == null) {
            return (byte) 0;
        }
        List sensorList = this.e.getSensorList(-1);
        return sensorList != null ? (byte) sensorList.size() : (byte) 0;
    }

    protected final Context y() {
        return this.a;
    }
}
