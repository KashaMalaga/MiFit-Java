package cn.com.smartdevices.bracelet.upgrade;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import cn.com.smartdevices.bracelet.gps.services.C0454m;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.lab.sportmode.SportBaseInfo;
import com.d.a.a.h;
import com.g.a.b.b;
import com.xiaomi.channel.b.v;
import com.xiaomi.e.a;
import com.xiaomi.market.sdk.o;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kankan.wheel.widget.i;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;

public class j {
    public static final String a = "http://ota.app-xae.xiaomi.com/soft_testhm.php";
    public static final String b = "http://10.12.5.10/tmp/";
    public static final String c = "http://ota.app-xae.xiaomi.com/ota_testhm.php";
    private static final int d = 60000;
    private static final int e = 60000;
    private static final String f = "1.0";
    private static final String g = "ch";
    private static final String h = "en";
    private static j i;
    private HttpClient j = new DefaultHttpClient();
    private Context k;

    private j(Context context) {
        HttpParams params = this.j.getParams();
        params.setIntParameter("http.socket.timeout", e);
        params.setIntParameter("http.connection.timeout", e);
        this.k = context;
    }

    public static j a(Context context) {
        if (i == null) {
            i = new j(context);
        }
        return i;
    }

    private ArrayList<NameValuePair> a() {
        String uuid;
        ArrayList<NameValuePair> arrayList = new ArrayList();
        if (null == null) {
            TelephonyManager telephonyManager = (TelephonyManager) this.k.getSystemService("phone");
            if (telephonyManager != null) {
                uuid = new UUID((((long) (a.f + ((WifiManager) this.k.getSystemService("wifi")).getConnectionInfo().getMacAddress()).hashCode()) << 32) | ((long) (a.f + Secure.getString(this.k.getContentResolver(), "android_id")).hashCode()), (((long) (a.f + telephonyManager.getDeviceId()).hashCode()) << 32) | ((long) (a.f + telephonyManager.getSimSerialNumber()).hashCode())).toString();
            } else {
                uuid = "null";
            }
        } else {
            uuid = null;
        }
        String str = VERSION.RELEASE;
        String str2 = a.f + VERSION.SDK_INT;
        String str3 = Build.MODEL;
        String packageName = this.k.getPackageName();
        String string = this.k.getString(i.app_name);
        String str4 = a.f + i.c(this.k, this.k.getPackageName());
        String str5 = "HHCN";
        String str6 = h.DEFAULT_CHARSET;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = ((Activity) this.k).getWindowManager().getDefaultDisplay();
        defaultDisplay.getMetrics(displayMetrics);
        String str7 = a.f + defaultDisplay.getWidth();
        String str8 = a.f + defaultDisplay.getHeight();
        String str9 = f;
        String str10 = ((Activity) this.k).getResources().getConfiguration().locale.getLanguage().equals(Locale.CHINESE.toString()) ? g : h;
        arrayList.add(new BasicNameValuePair("devicecode", uuid));
        arrayList.add(new BasicNameValuePair(o.j, str));
        arrayList.add(new BasicNameValuePair("osversion", str2));
        arrayList.add(new BasicNameValuePair(f.aa, str3));
        arrayList.add(new BasicNameValuePair(b.b, packageName));
        arrayList.add(new BasicNameValuePair("software", string));
        arrayList.add(new BasicNameValuePair("softv", str4));
        arrayList.add(new BasicNameValuePair(b.c, str5));
        arrayList.add(new BasicNameValuePair("ie", str6));
        arrayList.add(new BasicNameValuePair("w", str7));
        arrayList.add(new BasicNameValuePair(C0454m.a, str8));
        arrayList.add(new BasicNameValuePair(SportBaseInfo.VERSION, str9));
        arrayList.add(new BasicNameValuePair("l", str10));
        return arrayList;
    }

    private String c(String str, ArrayList<NameValuePair> arrayList) {
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            NameValuePair nameValuePair = (NameValuePair) it.next();
            str = str + (i == 0 ? "?" : "&") + nameValuePair.getName() + "=" + nameValuePair.getValue();
            i++;
        }
        return str;
    }

    public InputStream a(String str, ArrayList<NameValuePair> arrayList) {
        InputStream inputStream = null;
        try {
            HttpResponse execute = this.j.execute(new HttpGet(c(str, arrayList)));
            if (execute.getStatusLine().getStatusCode() == v.C) {
                inputStream = execute.getEntity().getContent();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return inputStream;
    }

    public InputStream b(String str, ArrayList<NameValuePair> arrayList) {
        InputStream inputStream = null;
        HttpUriRequest httpPost = new HttpPost(str);
        try {
            List a = a();
            if (arrayList != null) {
                a.addAll(arrayList);
            }
            httpPost.setEntity(new UrlEncodedFormEntity(a, h.DEFAULT_CHARSET));
            HttpResponse execute = this.j.execute(httpPost);
            if (execute.getStatusLine().getStatusCode() == v.C) {
                inputStream = execute.getEntity().getContent();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return inputStream;
    }
}
