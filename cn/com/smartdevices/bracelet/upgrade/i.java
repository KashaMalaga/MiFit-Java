package cn.com.smartdevices.bracelet.upgrade;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.preference.PreferenceManager;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.partner.NativeInterface;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.xiaomi.e.a;
import com.xiaomi.market.sdk.o;
import com.xiaomi.market.sdk.q;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.http.message.BasicNameValuePair;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public final class i {
    public static final int a = 263;
    public static final int b = 264;
    public static final int c = 265;
    public static final String d = "ChangeLog";
    public static final String e = "NewVersion";
    public static final String f = "DownUrl";
    public static final String g = "NeedCheck";
    public static final String h = "NeedUploadContacts";
    private static final boolean i = false;

    private i() {
    }

    public static f a(Context context, String str) {
        int parseInt;
        int i = 0;
        f fVar = new f();
        j a = j.a(context);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair(WidgetRequestParam.REQ_PARAM_COMMENT_TOPIC, "checkupdate"));
        InputStream b = a.b(str, arrayList);
        if (b != null) {
            Element a2 = new k().a(b);
            try {
                b.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (a2 != null) {
                try {
                    String nodeValue = a2.getElementsByTagName(q.e).item(0).getFirstChild().getNodeValue();
                    parseInt = nodeValue != null ? Integer.parseInt(nodeValue) : -1;
                    String str2 = a.f;
                    NodeList childNodes = a2.getElementsByTagName("change_log").item(0).getChildNodes();
                    if (childNodes != null) {
                        while (i < childNodes.getLength()) {
                            String str3 = str2 + childNodes.item(i).getNodeValue();
                            i++;
                            str2 = str3;
                        }
                    }
                    fVar.d(str2);
                    fVar.b(a2.getElementsByTagName("file_url").item(0).getFirstChild().getNodeValue());
                    fVar.c(a2.getElementsByTagName(f.aD).item(0).getFirstChild().getNodeValue());
                } catch (Exception e2) {
                    e2.printStackTrace();
                    parseInt = -1;
                }
                fVar.a(parseInt);
                PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(e, parseInt).commit();
                return fVar;
            }
        }
        parseInt = -1;
        fVar.a(parseInt);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(e, parseInt).commit();
        return fVar;
    }

    public static String a() {
        return j.a;
    }

    public static boolean a(Context context) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date()).compareTo(PreferenceManager.getDefaultSharedPreferences(context).getString(g, Constants.VIA_RESULT_SUCCESS)) > 0;
    }

    public static boolean a(Context context, String str, int i) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str, Constants.VIA_RESULT_SUCCESS).compareTo(Constants.VIA_RESULT_SUCCESS) != 0;
    }

    public static OtaVersionInfo b(Context context, String str) {
        OtaVersionInfo otaVersionInfo = new OtaVersionInfo();
        j a = j.a(context);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("devtype", NativeInterface.BRACELET_SCHEME));
        arrayList.add(new BasicNameValuePair("devversion", a.f));
        arrayList.add(new BasicNameValuePair(f.ak, a.f + c(context, context.getPackageName())));
        arrayList.add(new BasicNameValuePair("softtype", a.f));
        arrayList.add(new BasicNameValuePair("timestamp", a.f + System.currentTimeMillis()));
        InputStream a2 = a.a(str, arrayList);
        if (a2 != null) {
            Element a3 = new k().a(a2);
            try {
                a2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (a3 != null) {
                try {
                    otaVersionInfo.a = a3.getElementsByTagName(SocialConstants.PARAM_URL).item(0).getFirstChild().getNodeValue();
                    String nodeValue = a3.getElementsByTagName(f.aQ).item(0).getFirstChild().getNodeValue();
                    if (nodeValue != null) {
                        otaVersionInfo.b = Float.valueOf(nodeValue).floatValue();
                    }
                    otaVersionInfo.c = a3.getElementsByTagName(o.x).item(0).getFirstChild().getNodeValue();
                    otaVersionInfo.d = a3.getElementsByTagName("verinfo").item(0).getFirstChild().getNodeValue();
                    nodeValue = a3.getElementsByTagName("size").item(0).getFirstChild().getNodeValue();
                    if (nodeValue != null) {
                        otaVersionInfo.e = Integer.valueOf(nodeValue).intValue();
                    }
                    otaVersionInfo.f = a3.getElementsByTagName(f.aD).item(0).getFirstChild().getNodeValue();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return otaVersionInfo;
    }

    public static String b() {
        return j.c;
    }

    public static void b(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        defaultSharedPreferences.edit().putString(g, new SimpleDateFormat("yyyyMMdd").format(new Date())).commit();
    }

    public static boolean b(Context context, String str, int i) {
        try {
            return Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(new Date())) - Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(context).getString(str, Constants.VIA_RESULT_SUCCESS)) > i;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int c(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 1);
            return packageInfo == null ? 0 : packageInfo.versionCode;
        } catch (NameNotFoundException e) {
            return 0;
        }
    }

    public static void d(Context context, String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        defaultSharedPreferences.edit().putString(str, new SimpleDateFormat("yyyyMMdd").format(new Date())).commit();
    }

    public static boolean e(Context context, String str) {
        if (str == null) {
            return false;
        }
        f(context, str);
        return true;
    }

    public static void f(Context context, String str) {
        if (str != null) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                context.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
