package com.amap.api.location.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.support.v4.view.a.C0113o;
import cn.com.smartdevices.bracelet.gps.c.a.g;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictSearchQuery;
import com.tencent.connect.common.Constants;
import com.xiaomi.e.a;
import com.xiaomi.market.sdk.o;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
    public static String a = a.f;
    public static String b = a.f;
    static int c = C0113o.l;
    static String d = null;
    private static SharedPreferences e = null;
    private static Editor f = null;
    private static Method g;

    public static String a() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = Constants.VIA_TO_TYPE_QQ_GROUP;
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String a(String str, String str2) {
        String str3 = null;
        try {
            if (d == null || d.length() == 0) {
                d = c.a(null).i();
            }
            str3 = g.a(d + kankan.wheel.widget.a.ci + str.substring(0, str.length() - 3) + kankan.wheel.widget.a.ci + str2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str3;
    }

    public static void a(Context context, AMapLocation aMapLocation) {
        try {
            if (e == null) {
                e = context.getSharedPreferences("last_know_location", 0);
            }
            if (f == null) {
                f = e.edit();
            }
            f.putString("last_know_lat", String.valueOf(aMapLocation.getLatitude()));
            f.putString("last_know_lng", String.valueOf(aMapLocation.getLongitude()));
            f.putString(DistrictSearchQuery.KEYWORDS_PROVINCE, aMapLocation.getProvince());
            f.putString(DistrictSearchQuery.KEYWORDS_CITY, aMapLocation.getCity());
            f.putString(DistrictSearchQuery.KEYWORDS_DISTRICT, aMapLocation.getDistrict());
            f.putString("cityCode", aMapLocation.getCityCode());
            f.putString("adCode", aMapLocation.getAdCode());
            f.putFloat("accuracy", aMapLocation.getAccuracy());
            f.putLong(g.f, aMapLocation.getTime());
            a(f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void a(Editor editor) {
        if (editor != null) {
            if (VERSION.SDK_INT >= 9) {
                try {
                    if (g == null) {
                        g = Editor.class.getDeclaredMethod("apply", new Class[0]);
                    }
                    g.invoke(editor, new Object[0]);
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    editor.commit();
                    return;
                }
            }
            editor.commit();
        }
    }

    public static void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(LocationManagerProxy.KEY_STATUS_CHANGED) && jSONObject.has(o.n)) {
                String string = jSONObject.getString(LocationManagerProxy.KEY_STATUS_CHANGED);
                String string2 = jSONObject.getString(o.n);
                if (!string.equals(Constants.VIA_TO_TYPE_QQ_GROUP) && string.equals(Constants.VIA_RESULT_SUCCESS)) {
                    if (string2.equals("INVALID_USER_KEY") || string2.equals("INSUFFICIENT_PRIVILEGES") || string2.equals("USERKEY_PLAT_NOMATCH") || string2.equals("INVALID_USER_SCODE")) {
                        throw new AMapLocException(AMapException.ERROR_FAILURE_AUTH);
                    } else if (string2.equals("SERVICE_NOT_EXIST") || string2.equals("SERVICE_RESPONSE_ERROR") || string2.equals("OVER_QUOTA") || string2.equals("UNKNOWN_ERROR")) {
                        throw new AMapLocException(AMapException.ERROR_UNKNOWN);
                    } else if (string2.equals("INVALID_PARAMS")) {
                        throw new AMapLocException(AMapException.ERROR_INVALID_PARAMETER);
                    }
                }
            }
        } catch (JSONException e) {
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            State state = activeNetworkInfo.getState();
            return (state == null || state == State.DISCONNECTED || state == State.DISCONNECTING) ? false : true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static AMapLocation b(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("last_know_location", 0);
            AMapLocation aMapLocation = new AMapLocation(a.f);
            aMapLocation.setProvider(LocationProviderProxy.AMapNetwork);
            double parseDouble = Double.parseDouble(sharedPreferences.getString("last_know_lat", "0.0"));
            double parseDouble2 = Double.parseDouble(sharedPreferences.getString("last_know_lng", "0.0"));
            aMapLocation.setLatitude(parseDouble);
            aMapLocation.setLongitude(parseDouble2);
            aMapLocation.setProvince(sharedPreferences.getString(DistrictSearchQuery.KEYWORDS_PROVINCE, a.f));
            aMapLocation.setCity(sharedPreferences.getString(DistrictSearchQuery.KEYWORDS_CITY, a.f));
            aMapLocation.setDistrict(sharedPreferences.getString(DistrictSearchQuery.KEYWORDS_DISTRICT, a.f));
            aMapLocation.setCityCode(sharedPreferences.getString("cityCode", a.f));
            aMapLocation.setAdCode(sharedPreferences.getString("adCode", a.f));
            aMapLocation.setAccuracy(sharedPreferences.getFloat("accuracy", 0.0f));
            aMapLocation.setTime(sharedPreferences.getLong(g.f, 0));
            return aMapLocation;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
