package cn.com.smartdevices.bracelet.heartrate;

import android.content.Context;
import android.util.Base64;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.d.C0425b;
import cn.com.smartdevices.bracelet.gps.c.a.g;
import cn.com.smartdevices.bracelet.gps.services.O;
import cn.com.smartdevices.bracelet.j.l;
import cn.com.smartdevices.bracelet.model.HeartRateItem;
import com.xiaomi.channel.relationservice.data.a;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import com.xiaomi.market.sdk.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    private static final String a = "HeartRateDataManager";
    private static b b;
    private final Context c;
    private C0425b d = null;

    private b(Context context) {
        this.c = context;
        this.d = C0425b.a(context);
    }

    private int a(int i) {
        return i < 60 ? 0 : (i < 60 || i >= 100) ? 3 : 1;
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (b == null) {
                b = new b(context);
            }
            bVar = b;
        }
        return bVar;
    }

    private List<HeartRateItem> a(String str) {
        List<HeartRateItem> arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(com.xiaomi.channel.gamesdk.b.a) != 1) {
                return null;
            }
            JSONArray jSONArray = jSONObject.getJSONArray(com.xiaomi.channel.gamesdk.b.b);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                HeartRateItem heartRateItem = new HeartRateItem();
                heartRateItem.time = jSONObject2.getLong(g.f);
                heartRateItem.type = jSONObject2.getInt(a.h);
                byte[] decode = Base64.decode(jSONObject2.getString(O.j), 2);
                if (decode != null && decode.length > 0) {
                    heartRateItem.hr = decode[0] & HeartRateInfo.HR_EMPTY_VALUE;
                    heartRateItem.status = a(heartRateItem.hr);
                    arrayList.add(heartRateItem);
                }
            }
            return arrayList;
        } catch (JSONException e) {
            return null;
        }
    }

    public ArrayList<HeartRateItem> a(int i, int i2) {
        return this.d.a(i, i2);
    }

    public void a() {
        boolean readHeartRateDataFromServer = Keeper.readHeartRateDataFromServer();
        C0596r.d(a, "if need sync from server : " + (!readHeartRateDataFromServer));
        if (!readHeartRateDataFromServer) {
            l.d(this.c, new c(this));
        }
    }

    public boolean a(long j) {
        return this.d.a(j);
    }

    public boolean a(HeartRateItem heartRateItem) {
        return heartRateItem == null ? false : this.d.a(heartRateItem);
    }

    public ArrayList<HeartRateItem> b(int i, int i2) {
        if (!Keeper.readHeartRateDataFromServer()) {
            a();
        }
        return a(i, i2);
    }

    public boolean b() {
        e eVar = new e();
        ArrayList a = this.d.a(2);
        if (a == null || a.size() <= 0) {
            return true;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator it = a.iterator();
        while (it.hasNext()) {
            JSONObject toJSONObject = ((HeartRateItem) it.next()).toJSONObject();
            try {
                toJSONObject.put(kankan.wheel.widget.a.ak, cn.com.smartdevices.bracelet.e.a.d(this.c));
                toJSONObject.put(o.L, 4);
            } catch (JSONException e) {
                C0596r.e(a, e.getMessage());
            }
            jSONArray.put(toJSONObject);
        }
        C0596r.d(a, "sync to server: " + jSONArray.toString());
        l.a(this.c, jSONArray.toString(), new d(this, a, eVar));
        return eVar.a;
    }
}
