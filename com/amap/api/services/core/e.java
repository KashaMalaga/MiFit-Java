package com.amap.api.services.core;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.support.v4.view.a.C0113o;
import com.amap.api.location.LocationManagerProxy;
import com.tencent.connect.common.Constants;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import com.xiaomi.market.sdk.o;
import com.xiaomi.mipush.sdk.f;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
    public static double a(double d) {
        return Double.parseDouble(new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US)).format(d));
    }

    public static double a(int i) {
        return ((double) i) / 111700.0d;
    }

    public static String a() {
        String valueOf = String.valueOf(System.currentTimeMillis());
        String str = Constants.VIA_TO_TYPE_QQ_GROUP;
        int length = valueOf.length();
        return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
    }

    public static String a(LatLonPoint latLonPoint) {
        if (latLonPoint == null) {
            return a.f;
        }
        double a = a(latLonPoint.getLongitude());
        return a + f.i + a(latLonPoint.getLatitude());
    }

    public static String a(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2);
        String a = a();
        stringBuffer.append("&ts=" + a);
        stringBuffer.append("&scode=" + b(a, str));
        return stringBuffer.toString();
    }

    public static String a(Date date) {
        return date != null ? new SimpleDateFormat("HH:mm").format(date) : a.f;
    }

    public static String a(List<LatLonPoint> list) {
        if (list == null) {
            return a.f;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            LatLonPoint latLonPoint = (LatLonPoint) list.get(i);
            double a = a(latLonPoint.getLongitude());
            stringBuffer.append(a).append(f.i).append(a(latLonPoint.getLatitude()));
            stringBuffer.append(";");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }

    public static Proxy a(Context context) {
        URI uri;
        try {
            uri = new URI("http://restapi.amap.com");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            uri = null;
        }
        Proxy a = VERSION.SDK_INT >= 11 ? a(context, uri) : c(context);
        return (a == null || a.type() == Type.DIRECT) ? a : null;
    }

    private static Proxy a(Context context, URI uri) {
        List select;
        try {
            select = ProxySelector.getDefault().select(uri);
        } catch (Exception e) {
            select = null;
        }
        return (select == null || select.size() <= 0) ? null : (Proxy) select.get(0);
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[C0113o.l];
        while (true) {
            int read = inputStream.read(bArr, 0, C0113o.l);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static String b(Context context) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String toUpperCase = Integer.toHexString(b & HeartRateInfo.HR_EMPTY_VALUE).toUpperCase(Locale.US);
                if (toUpperCase.length() == 1) {
                    stringBuffer.append(Constants.VIA_RESULT_SUCCESS);
                }
                stringBuffer.append(toUpperCase);
                stringBuffer.append(kankan.wheel.widget.a.ci);
            }
            return stringBuffer.toString();
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String b(String str, String str2) {
        return o.a(d.a(null).h() + kankan.wheel.widget.a.ci + str.substring(0, str.length() - 3) + kankan.wheel.widget.a.ci + str2);
    }

    public static void b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(LocationManagerProxy.KEY_STATUS_CHANGED) && jSONObject.has(o.n)) {
                String string = jSONObject.getString(LocationManagerProxy.KEY_STATUS_CHANGED);
                String string2 = jSONObject.getString(o.n);
                if (!string.equals(Constants.VIA_TO_TYPE_QQ_GROUP) && string.equals(Constants.VIA_RESULT_SUCCESS)) {
                    if (string2.equals("INVALID_USER_KEY") || string2.equals("INSUFFICIENT_PRIVILEGES") || string2.equals("INVALID_USER_SCODE") || string2.equals("INVALID_USER_SIGNATURE")) {
                        throw new AMapException(AMapException.ERROR_FAILURE_AUTH);
                    } else if (string2.equals("SERVICE_NOT_EXIST") || string2.equals("SERVICE_RESPONSE_ERROR") || string2.equals("OVER_QUOTA") || string2.equals("UNKNOWN_ERROR")) {
                        throw new AMapException(AMapException.ERROR_UNKNOWN);
                    } else if (string2.equals("INVALID_PARAMS")) {
                        throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
                    } else if (string2.equals("\u670d\u52a1\u6b63\u5728\u7ef4\u62a4\u4e2d")) {
                        throw new AMapException(AMapException.ERROR_UNKNOWN);
                    } else if (string2.equals("\u53c2\u6570\u7f3a\u5931\u6216\u683c\u5f0f\u975e\u6cd5")) {
                        throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
                    } else if (string2.equals("\u8d26\u53f7\u672a\u6fc0\u6d3b\u6216\u5df2\u88ab\u51bb\u7ed3")) {
                        throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
                    } else if (string2.startsWith("UNKOWN_ERROR")) {
                        throw new AMapException(AMapException.ERROR_UNKNOWN);
                    } else {
                        throw new AMapException(string2);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.net.Proxy c(android.content.Context r10) {
        /*
        r9 = -1;
        r7 = 80;
        r6 = 0;
        r0 = "connectivity";
        r0 = r10.getSystemService(r0);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        r0 = (android.net.ConnectivityManager) r0;	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        r8 = r0.getActiveNetworkInfo();	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r8 == 0) goto L_0x010c;
    L_0x0012:
        r0 = r8.getType();	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        r1 = 1;
        if (r0 != r1) goto L_0x0031;
    L_0x0019:
        r1 = android.net.Proxy.getHost(r10);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        r0 = android.net.Proxy.getPort(r10);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        r7 = r0;
    L_0x0022:
        if (r1 == 0) goto L_0x010c;
    L_0x0024:
        r0 = new java.net.Proxy;	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        r2 = java.net.Proxy.Type.HTTP;	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        r1 = java.net.InetSocketAddress.createUnresolved(r1, r7);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        r0.<init>(r2, r1);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
    L_0x002f:
        r6 = r0;
    L_0x0030:
        return r6;
    L_0x0031:
        r0 = "content://telephony/carriers/preferapn";
        r1 = android.net.Uri.parse(r0);	 Catch:{ Exception -> 0x0083, RuntimeException -> 0x0100 }
        r0 = r10.getContentResolver();	 Catch:{ Exception -> 0x0083, RuntimeException -> 0x0100 }
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r2 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0083, RuntimeException -> 0x0100 }
        if (r2 == 0) goto L_0x0115;
    L_0x0045:
        r0 = r2.moveToFirst();	 Catch:{ Exception -> 0x0083, RuntimeException -> 0x0100 }
        if (r0 == 0) goto L_0x0115;
    L_0x004b:
        r0 = "proxy";
        r0 = r2.getColumnIndex(r0);	 Catch:{ Exception -> 0x0083, RuntimeException -> 0x0100 }
        if (r0 == r9) goto L_0x0112;
    L_0x0053:
        r1 = r2.getString(r0);	 Catch:{ Exception -> 0x0083, RuntimeException -> 0x0100 }
        if (r1 == 0) goto L_0x0062;
    L_0x0059:
        r0 = "";
        r0 = r1.equals(r0);	 Catch:{ Exception -> 0x0083, RuntimeException -> 0x0100 }
        if (r0 == 0) goto L_0x0062;
    L_0x0061:
        r1 = r6;
    L_0x0062:
        r0 = "port";
        r0 = r2.getColumnIndex(r0);	 Catch:{ Exception -> 0x0083, RuntimeException -> 0x0100 }
        if (r0 == r9) goto L_0x010f;
    L_0x006a:
        r0 = r2.getString(r0);	 Catch:{ Exception -> 0x0083, RuntimeException -> 0x0100 }
        if (r0 == 0) goto L_0x010f;
    L_0x0070:
        r3 = "";
        r3 = r0.equals(r3);	 Catch:{ Exception -> 0x0083, RuntimeException -> 0x0100 }
        if (r3 != 0) goto L_0x010f;
    L_0x0078:
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Exception -> 0x0083, RuntimeException -> 0x0100 }
    L_0x007c:
        if (r2 == 0) goto L_0x0081;
    L_0x007e:
        r2.close();	 Catch:{ Exception -> 0x0109, RuntimeException -> 0x0100 }
    L_0x0081:
        r7 = r0;
        goto L_0x0022;
    L_0x0083:
        r0 = move-exception;
        r0 = r7;
    L_0x0085:
        r1 = r8.getExtraInfo();	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r1 == 0) goto L_0x00f5;
    L_0x008b:
        r2 = "";
        r2 = r1.equals(r2);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r2 != 0) goto L_0x00f5;
    L_0x0093:
        r2 = java.util.Locale.US;	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        r1 = r1.toLowerCase(r2);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        r2 = "cmwap";
        r2 = r1.startsWith(r2);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r2 != 0) goto L_0x00b1;
    L_0x00a1:
        r2 = "3gwap";
        r2 = r1.startsWith(r2);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r2 != 0) goto L_0x00b1;
    L_0x00a9:
        r2 = "uniwap";
        r2 = r1.startsWith(r2);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r2 == 0) goto L_0x00cd;
    L_0x00b1:
        r0 = android.net.Proxy.getDefaultHost();	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r0 == 0) goto L_0x00ca;
    L_0x00b7:
        r1 = "";
        r1 = r0.equals(r1);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r1 != 0) goto L_0x00ca;
    L_0x00bf:
        r1 = "null";
        r1 = r0.equals(r1);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r1 != 0) goto L_0x00ca;
    L_0x00c7:
        r1 = r0;
        goto L_0x0022;
    L_0x00ca:
        r0 = "10.0.0.172";
        goto L_0x00c7;
    L_0x00cd:
        r2 = "ctwap";
        r1 = r1.startsWith(r2);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r1 == 0) goto L_0x00f1;
    L_0x00d5:
        r0 = android.net.Proxy.getDefaultHost();	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r0 == 0) goto L_0x00ee;
    L_0x00db:
        r1 = "";
        r1 = r0.equals(r1);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r1 != 0) goto L_0x00ee;
    L_0x00e3:
        r1 = "null";
        r1 = r0.equals(r1);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r1 != 0) goto L_0x00ee;
    L_0x00eb:
        r1 = r0;
        goto L_0x0022;
    L_0x00ee:
        r0 = "10.0.0.200";
        goto L_0x00eb;
    L_0x00f1:
        r7 = r0;
        r1 = r6;
        goto L_0x0022;
    L_0x00f5:
        r1 = android.net.Proxy.getDefaultHost();	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        r0 = android.net.Proxy.getDefaultPort();	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        r7 = r0;
        goto L_0x0022;
    L_0x0100:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0030;
    L_0x0106:
        r0 = move-exception;
        goto L_0x0030;
    L_0x0109:
        r1 = move-exception;
        goto L_0x0085;
    L_0x010c:
        r0 = r6;
        goto L_0x002f;
    L_0x010f:
        r0 = r7;
        goto L_0x007c;
    L_0x0112:
        r1 = r6;
        goto L_0x0062;
    L_0x0115:
        r0 = r7;
        r1 = r6;
        goto L_0x007c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.core.e.c(android.content.Context):java.net.Proxy");
    }

    public static Date c(String str) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date d(String str) {
        Date date = null;
        if (!(str == null || str.trim().equals(a.f))) {
            try {
                date = new SimpleDateFormat("HHmm").parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    public static Date e(String str) {
        Date date = null;
        if (!(str == null || str.trim().equals(a.f))) {
            try {
                date = new SimpleDateFormat("HH:mm").parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    public static String f(String str) {
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : split) {
            stringBuffer.append(append);
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }
}
