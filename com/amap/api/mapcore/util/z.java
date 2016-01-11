package com.amap.api.mapcore.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.provider.Settings.System;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class z {
    private static String a = null;
    private static boolean b = false;
    private static String c = null;
    private static String d = null;
    private static String e = null;
    private static String f = null;

    class a extends DefaultHandler {
        a() {
        }

        public void characters(char[] cArr, int i, int i2) {
            if (z.b) {
                z.a = new String(cArr, i, i2);
            }
        }

        public void endElement(String str, String str2, String str3) {
            z.b = false;
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (str2.equals("string") && "UTDID".equals(attributes.getValue("name"))) {
                z.b = true;
            }
        }
    }

    public static String a(Context context) {
        try {
            if (a != null && !com.xiaomi.e.a.f.equals(a)) {
                return a;
            }
            if (context.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0) {
                a = System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
            }
            if (!(a == null || com.xiaomi.e.a.f.equals(a))) {
                return a;
            }
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");
                    if (file.exists()) {
                        SAXParserFactory.newInstance().newSAXParser().parse(file, new a());
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e2) {
                e2.printStackTrace();
            } catch (SAXException e3) {
                e3.printStackTrace();
            } catch (IOException e4) {
                e4.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return a;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private static List<ScanResult> a(List<ScanResult> list) {
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            for (int i2 = 1; i2 < size - i; i2++) {
                if (((ScanResult) list.get(i2 - 1)).level > ((ScanResult) list.get(i2)).level) {
                    ScanResult scanResult = (ScanResult) list.get(i2 - 1);
                    list.set(i2 - 1, list.get(i2));
                    list.set(i2, scanResult);
                }
            }
        }
        return list;
    }

    static String b(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        if (context != null) {
            try {
                if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager.isWifiEnabled()) {
                        List scanResults = wifiManager.getScanResults();
                        if (scanResults == null || scanResults.size() == 0) {
                            return stringBuilder.toString();
                        }
                        List a = a(scanResults);
                        Object obj = 1;
                        int i = 0;
                        while (i < a.size() && i < 10) {
                            ScanResult scanResult = (ScanResult) a.get(i);
                            if (obj != null) {
                                obj = null;
                            } else {
                                stringBuilder.append("||");
                            }
                            stringBuilder.append(scanResult.BSSID);
                            i++;
                        }
                    }
                    return stringBuilder.toString();
                }
            } catch (Throwable th) {
                az.a(th, "DeviceInfo", "getWifiMacs");
                th.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    static String c(Context context) {
        try {
            if (c != null && !com.xiaomi.e.a.f.equals(c)) {
                return c;
            }
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") != 0) {
                return c;
            }
            c = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            return c;
        } catch (Throwable th) {
            az.a(th, "DeviceInfo", "getDeviceMac");
            th.printStackTrace();
        }
    }

    static String d(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
                return stringBuilder.toString();
            }
            CellLocation cellLocation = ((TelephonyManager) context.getSystemService("phone")).getCellLocation();
            if (cellLocation instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                stringBuilder.append(gsmCellLocation.getLac()).append("||").append(gsmCellLocation.getCid()).append("&bt=gsm");
            } else if (cellLocation instanceof CdmaCellLocation) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                int systemId = cdmaCellLocation.getSystemId();
                int networkId = cdmaCellLocation.getNetworkId();
                int baseStationId = cdmaCellLocation.getBaseStationId();
                if (systemId < 0 || networkId < 0 || baseStationId < 0) {
                    stringBuilder.append(systemId).append("||").append(networkId).append("||").append(baseStationId).append("&bt=cdma");
                } else {
                    stringBuilder.append(systemId).append("||").append(networkId).append("||").append(baseStationId).append("&bt=cdma");
                }
            }
            return stringBuilder.toString();
        } catch (Throwable th) {
            az.a(th, "DeviceInfo", "cellInfo");
            th.printStackTrace();
        }
    }

    static String e(Context context) {
        String str = com.xiaomi.e.a.f;
        try {
            str = v(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str;
    }

    static int f(Context context) {
        int i = -1;
        try {
            i = w(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return i;
    }

    public static int g(Context context) {
        int i = -1;
        try {
            i = u(context);
        } catch (Throwable th) {
            az.a(th, "DeviceInfo", "getActiveNetWorkType");
            th.printStackTrace();
        }
        return i;
    }

    static int h(Context context) {
        int i = -1;
        try {
            i = u(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return i;
    }

    static String i(Context context) {
        String extraInfo;
        try {
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
                return null;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            extraInfo = activeNetworkInfo.getExtraInfo();
            return extraInfo;
        } catch (Throwable th) {
            az.a(th, "DeviceInfo", "getNetworkExtraInfo");
            th.printStackTrace();
            extraInfo = null;
        }
    }

    static String j(Context context) {
        try {
            if (d != null && !com.xiaomi.e.a.f.equals(d)) {
                return d;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            d = i2 > i ? i + "*" + i2 : i2 + "*" + i;
            return d;
        } catch (Throwable th) {
            az.a(th, "DeviceInfo", "getReslution");
            th.printStackTrace();
        }
    }

    static String k(Context context) {
        try {
            return t(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    static String l(Context context) {
        try {
            return t(context);
        } catch (Throwable th) {
            az.a(th, "DeviceInfo", "getActiveNetworkTypeName");
            th.printStackTrace();
            return null;
        }
    }

    static String m(Context context) {
        try {
            if (e != null && !com.xiaomi.e.a.f.equals(e)) {
                return e;
            }
            if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
                return e;
            }
            e = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            return e;
        } catch (Throwable th) {
            az.a(th, "DeviceInfo", "getDeviceID");
            th.printStackTrace();
        }
    }

    static String n(Context context) {
        String str = null;
        try {
            str = r(context);
        } catch (Throwable th) {
            az.a(th, "DeviceInfo", "getSubscriberId");
            th.printStackTrace();
        }
        return str;
    }

    static String o(Context context) {
        try {
            return s(context);
        } catch (Throwable th) {
            az.a(th, "DeviceInfo", "getNetworkOperatorName");
            th.printStackTrace();
            return null;
        }
    }

    static String p(Context context) {
        try {
            return s(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    static String q(Context context) {
        try {
            return r(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String r(Context context) {
        if (f != null && !com.xiaomi.e.a.f.equals(f)) {
            return f;
        }
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return f;
        }
        f = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        return f;
    }

    private static String s(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0 ? null : ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
    }

    private static String t(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return com.xiaomi.e.a.f;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return com.xiaomi.e.a.f;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null ? com.xiaomi.e.a.f : activeNetworkInfo.getTypeName();
    }

    private static int u(Context context) {
        if (context == null || context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return -1;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return -1;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null ? -1 : activeNetworkInfo.getType();
    }

    private static String v(Context context) {
        String str = com.xiaomi.e.a.f;
        String n = n(context);
        return (n == null || n.length() < 5) ? str : n.substring(3, 5);
    }

    private static int w(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0 ? -1 : ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
    }
}
