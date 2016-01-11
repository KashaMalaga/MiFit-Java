package cn.com.smartdevices.bracelet.g;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.Html;
import cn.com.smartdevices.bracelet.C0401a;
import com.tencent.open.SocialConstants;
import com.xiaomi.hm.health.r;
import java.util.HashMap;
import java.util.Map;

public abstract class a implements c {
    protected static Map<Integer, Double> a = null;
    protected int b = 1;

    public a(int i) {
        if (a == null) {
            a = new HashMap(i);
        }
        a();
        this.b = b();
    }

    private int b(int i) {
        if (this.b != 0) {
            return (i / this.b) * this.b;
        }
        throw new IllegalStateException();
    }

    public static void b(Context context, String str) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
        if (networkInfo != null) {
            HashMap hashMap = new HashMap(3);
            hashMap.put(SocialConstants.PARAM_TYPE, str);
            hashMap.put("avl", String.valueOf(networkInfo.isAvailable()));
            hashMap.put("con", String.valueOf(networkInfo.isConnected()));
            C0401a.a(context, C0401a.bd, hashMap);
        }
    }

    public double a(int i) {
        int b = b(i);
        Double d = (Double) a.get(Integer.valueOf(b));
        while (d == null) {
            b -= this.b;
            if (b < 0) {
                break;
            }
            d = (Double) a.get(Integer.valueOf(b));
        }
        return d.doubleValue();
    }

    public String a(Context context, int i) {
        Resources resources = context.getResources();
        double a = a(i);
        if (a == 0.0d) {
            return Html.fromHtml(resources.getString(r.sport_ranking_desc_poor, new Object[]{com.xiaomi.e.a.f})).toString();
        } else if (a >= 99.89d) {
            return Html.fromHtml(resources.getString(r.sport_ranking_desc_great)).toString();
        } else {
            String str = com.xiaomi.e.a.f;
            return a(context, (a <= 99.0d ? String.valueOf((int) a) : String.valueOf(a)) + resources.getString(r.percent_mark));
        }
    }

    protected abstract String a(Context context, String str);

    public abstract void a();

    public abstract int b();
}
