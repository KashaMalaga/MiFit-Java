package cn.com.smartdevices.bracelet.weight;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.DateFormat;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.gps.services.ay;
import cn.com.smartdevices.bracelet.j.l;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.SyncResult;
import com.activeandroid.a.d;
import com.activeandroid.b.e;
import com.huami.android.widget.a;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.hm.health.dataprocess.SportDay;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ah {
    private static final String a = "WeightInfoManager";
    private static ah b;

    private ah() {
    }

    public static ah a() {
        if (b == null) {
            b = new ah();
        }
        return b;
    }

    private List<WeightInfo> a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject(b.b);
            List<WeightInfo> arrayList = new ArrayList(jSONObject.getInt("total"));
            JSONArray jSONArray = jSONObject.getJSONArray(a.c);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                WeightInfo weightInfo = new WeightInfo();
                weightInfo.uid = jSONObject2.getInt(WidgetRequestParam.REQ_PARAM_ATTENTION_FUID);
                weightInfo.weight = Float.valueOf(jSONObject2.getString("wt")).floatValue();
                weightInfo.timestamp = jSONObject2.getLong(ay.H) * 1000;
                arrayList.add(weightInfo);
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private long[] b(Calendar calendar) {
        long[] jArr = new long[2];
        Calendar calendar2 = (Calendar) calendar.clone();
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        jArr[0] = calendar2.getTimeInMillis();
        C0596r.e(a, "from time :" + new SimpleDateFormat("HH:mm:ss").format(Long.valueOf(calendar2.getTimeInMillis())));
        calendar2.set(11, 23);
        calendar2.set(12, 59);
        calendar2.set(13, 59);
        jArr[1] = calendar2.getTimeInMillis();
        C0596r.e(a, "to time :" + new SimpleDateFormat("HH:mm:ss").format(Long.valueOf(calendar2.getTimeInMillis())));
        return jArr;
    }

    private void e(List<WeightInfo> list) {
        C0596r.d(a, "Delete Infos Mark : " + list.size());
        com.activeandroid.a.d();
        try {
            for (WeightInfo i : list) {
                i(i);
            }
            com.activeandroid.a.f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            com.activeandroid.a.e();
        }
    }

    private String f(List<WeightInfo> list) {
        String jSONArray;
        String str = com.xiaomi.e.a.f;
        try {
            JSONArray jSONArray2 = new JSONArray();
            for (WeightInfo weightInfo : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(WidgetRequestParam.REQ_PARAM_ATTENTION_FUID, weightInfo.uid);
                jSONObject.put("wt", Float.valueOf(weightInfo.weight));
                jSONObject.put(ay.H, weightInfo.timestamp / 1000);
                if (!TextUtils.isEmpty(weightInfo.deviceid)) {
                    jSONObject.put("did", weightInfo.deviceid);
                }
                jSONArray2.put(jSONObject);
            }
            jSONArray = jSONArray2.toString();
        } catch (Exception e) {
            e.printStackTrace();
            jSONArray = str;
        }
        C0596r.e(a, "Sync WeightInfos : " + jSONArray);
        return jSONArray;
    }

    public static boolean f(WeightInfo weightInfo) {
        return weightInfo.synced == 2;
    }

    private String g(List<WeightInfo> list) {
        String jSONArray;
        String str = com.xiaomi.e.a.f;
        try {
            JSONArray jSONArray2 = new JSONArray();
            for (WeightInfo weightInfo : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ay.H, weightInfo.timestamp / 1000);
                jSONObject.put(WidgetRequestParam.REQ_PARAM_ATTENTION_FUID, weightInfo.uid);
                jSONArray2.put(jSONObject);
            }
            jSONArray = jSONArray2.toString();
        } catch (Exception e) {
            e.printStackTrace();
            jSONArray = str;
        }
        C0596r.e(a, "Sync Deleted WeightInfos : " + jSONArray);
        return jSONArray;
    }

    private void g(int i) {
        C0596r.e(a, "Delete Infos Mark UID : " + i);
        e(a(i));
    }

    public static boolean g(WeightInfo weightInfo) {
        return weightInfo.synced == -2;
    }

    public static boolean h(WeightInfo weightInfo) {
        return weightInfo.synced == 2 || weightInfo.synced == -2;
    }

    private void i(WeightInfo weightInfo) {
        C0596r.d(a, "Delete Info Mark : " + weightInfo);
        if (weightInfo.synced == 2) {
            weightInfo.synced = -2;
        } else {
            weightInfo.synced = -1;
        }
        j(weightInfo);
    }

    private void j(WeightInfo weightInfo) {
        b(weightInfo, false);
    }

    private com.activeandroid.b.b k() {
        return new e().a(WeightInfo.class).a("Synced=?", Integer.valueOf(-1));
    }

    private com.activeandroid.b.b l() {
        return new e().a(WeightInfo.class).a("Synced=?", Integer.valueOf(0)).b("UserId<>?", Integer.valueOf(0));
    }

    public WeightInfo a(int i, int i2) {
        Object[] objArr = new Object[]{Integer.valueOf(i)};
        WeightInfo weightInfo = (WeightInfo) new e().a(WeightInfo.class).a("Synced>?", Integer.valueOf(-1)).b("UserId=?", objArr).b(i2).g("Timestamp DESC").e();
        C0596r.e(a, "Get Info : " + i + ", " + i2 + ", " + weightInfo);
        return weightInfo;
    }

    public WeightInfo a(int i, long j) {
        return (WeightInfo) new e().a(WeightInfo.class).a("Synced>?", Integer.valueOf(-1)).b("UserId=?", Integer.valueOf(i)).b("Timestamp<?", Long.valueOf(j)).g("Timestamp DESC").e();
    }

    public WeightInfo a(long j, boolean z) {
        if (!z) {
            return b(j);
        }
        WeightInfo weightInfo = (WeightInfo) new e().a(WeightInfo.class).a("TimeStamp=?", Long.valueOf(j)).e();
        C0596r.e(a, "Get Info : " + DateFormat.format("yyyy-MM-dd HH:mm:ss", j) + ", " + weightInfo);
        return weightInfo;
    }

    public List<WeightInfo> a(int i) {
        Object[] objArr = new Object[]{Integer.valueOf(i)};
        List<WeightInfo> d = new e().a(WeightInfo.class).a("Synced>?", Integer.valueOf(-1)).b("UserId=?", objArr).g("Timestamp DESC").d();
        C0596r.e(a, "Get Infos : " + i + ", " + d.size());
        return d;
    }

    public List<WeightInfo> a(int i, Calendar calendar) {
        long[] b = b(calendar);
        Object[] objArr = new Object[]{Integer.valueOf(i)};
        objArr = new Object[]{Long.valueOf(b[0]), Long.valueOf(b[1])};
        List<WeightInfo> d = new e().a(WeightInfo.class).a("Synced>?", Integer.valueOf(-1)).b("UserId=?", objArr).b("Timestamp>=? AND Timestamp<=?", objArr).g("Timestamp DESC").d();
        C0596r.e(a, "Get Infos : " + i + " " + DateFormat.format("yyyy-MM-dd hh:mm:ss", calendar) + ", " + d.size());
        for (WeightInfo weightInfo : d) {
            C0596r.e(a, "Get Info : " + weightInfo);
        }
        return d;
    }

    public List<WeightInfo> a(Calendar calendar) {
        long[] b = b(calendar);
        Object[] objArr = new Object[]{Long.valueOf(b[0]), Long.valueOf(b[1])};
        List<WeightInfo> d = new e().a(WeightInfo.class).a("Synced>?", Integer.valueOf(-1)).b("Timestamp>=? AND Timestamp<=?", objArr).g("Timestamp DESC").d();
        C0596r.e(a, "Get Infos : " + DateFormat.format("yyyy-MM-dd hh:mm:ss", calendar) + ", " + d.size());
        for (WeightInfo weightInfo : d) {
            C0596r.e(a, "Get Info : " + weightInfo);
        }
        return d;
    }

    public void a(WeightInfo weightInfo) {
        C0596r.d(a, "Add Info : " + weightInfo);
        weightInfo.save();
    }

    public void a(WeightInfo weightInfo, int i) {
        C0596r.d(a, "Update Info : " + weightInfo + " New UID : " + i);
        WeightInfo weightInfo2 = new WeightInfo(weightInfo);
        weightInfo2.uid = i;
        if (weightInfo2.synced == 1) {
            weightInfo2.synced = 0;
        }
        a(weightInfo2);
        if (weightInfo.synced == 1) {
            i(weightInfo);
        } else {
            d(weightInfo);
        }
    }

    public void a(WeightInfo weightInfo, boolean z) {
        C0596r.d(a, "Add Info : " + weightInfo + ", Uncertain : " + z);
        if (z) {
            weightInfo.synced = 2;
        }
        weightInfo.save();
    }

    public boolean a(long j) {
        return ((WeightInfo) new e().a(WeightInfo.class).a("Synced>?", Integer.valueOf(-1)).b("Timestamp=?", Long.valueOf(j)).e()) != null;
    }

    public boolean a(Context context) {
        boolean z = !Keeper.readScaleSyncedWeightInfosFromServer();
        C0596r.e(a, "Sync with Server 1, from server : " + z);
        return z ? a(context, new al(this, context)) : b(context);
    }

    public boolean a(Context context, aE aEVar) {
        C0596r.e(a, "Sync WeightInfos To Local!!");
        SyncResult syncResult = new SyncResult();
        l.a(cn.com.smartdevices.bracelet.e.a.f(context), -1, -1, -1, true, new ai(this, syncResult, context, aEVar));
        return syncResult.result;
    }

    public boolean a(Context context, List<WeightInfo> list) {
        C0596r.e(a, "Sync WeightInfos To Server!!");
        if (list == null || list.isEmpty()) {
            return true;
        }
        String f = f((List) list);
        SyncResult syncResult = new SyncResult();
        l.g(cn.com.smartdevices.bracelet.e.a.f(context), f, new aj(this, context, syncResult, list));
        return syncResult.result;
    }

    public boolean a(List<WeightInfo> list) {
        return a((List) list, false);
    }

    public boolean a(List<WeightInfo> list, boolean z) {
        boolean z2;
        C0596r.d(a, "Add Infos : " + list.size() + ", Uncertain : " + z);
        com.activeandroid.a.d();
        try {
            for (WeightInfo a : list) {
                a(a, z);
            }
            com.activeandroid.a.f();
            z2 = true;
        } catch (Exception e) {
            e.printStackTrace();
            z2 = false;
        } finally {
            com.activeandroid.a.e();
        }
        return z2;
    }

    public int b(int i) {
        return new e(d.a).a(WeightInfo.class).a("Synced>?", Integer.valueOf(-1)).b("UserId=?", Integer.valueOf(i)).g();
    }

    public WeightInfo b(int i, Calendar calendar) {
        long[] b = b(calendar);
        Object[] objArr = new Object[]{Integer.valueOf(i)};
        objArr = new Object[]{Long.valueOf(b[0]), Long.valueOf(b[1])};
        WeightInfo weightInfo = (WeightInfo) new e().a(WeightInfo.class).a("Synced>?", Integer.valueOf(-1)).b("UserId=?", objArr).b("Timestamp>=? AND Timestamp<=?", objArr).g("Timestamp DESC").e();
        C0596r.e(a, "Get Latest Info : " + i + ", " + DateFormat.format("yyyy-MM-dd hh:mm:ss", calendar) + ", " + weightInfo);
        return weightInfo;
    }

    public WeightInfo b(long j) {
        Object[] objArr = new Object[]{Long.valueOf(j)};
        WeightInfo weightInfo = (WeightInfo) new e().a(WeightInfo.class).a("Synced>?", Integer.valueOf(-1)).b("TimeStamp=?", objArr).e();
        C0596r.e(a, "Get Info : " + DateFormat.format("yyyy-MM-dd HH:mm:ss", j) + ", " + weightInfo);
        return weightInfo;
    }

    public List<WeightInfo> b(int i, int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException();
        }
        return new e().a(WeightInfo.class).a("Synced>?", Integer.valueOf(-1)).b("UserId=?", Integer.valueOf(i)).g("Timestamp DESC").a(i2).d();
    }

    public void b() {
        C0596r.d(a, "Delete All Infos!!");
        new com.activeandroid.b.a().a(WeightInfo.class).d();
    }

    public void b(WeightInfo weightInfo) {
        a(weightInfo, true);
    }

    public void b(WeightInfo weightInfo, boolean z) {
        C0596r.d(a, "Update Info : " + weightInfo + ", markUpdated : " + z);
        if (z && weightInfo.synced == 1) {
            weightInfo.synced = 0;
        }
        weightInfo.save();
    }

    public void b(List<WeightInfo> list) {
        a((List) list, true);
    }

    public boolean b(Context context) {
        int i = 3;
        LoginData f = cn.com.smartdevices.bracelet.e.a.f(context);
        int i2 = 1;
        int i3 = 3;
        do {
            int g = g();
            C0596r.d(a, "Sync with Server 2, to server : " + g);
            if (g > 0) {
                cn.com.smartdevices.bracelet.i.d lVar = new cn.com.smartdevices.bracelet.weight.a.l(context, f, Integer.valueOf(100));
                lVar.work();
                i2 &= lVar.isSuccessed();
            }
            C0596r.d(a, "Sync with Server 2, to server : " + i2);
            i3--;
            if (g <= 0) {
                break;
            }
        } while (i3 > 0);
        do {
            i3 = e();
            C0596r.d(a, "Sync with Server 3, delete from server : " + i3);
            if (i3 > 0) {
                cn.com.smartdevices.bracelet.i.d aVar = new cn.com.smartdevices.bracelet.weight.a.a(context, f, Integer.valueOf(kankan.wheel.widget.a.aB));
                aVar.work();
                i2 &= aVar.isSuccessed();
            }
            C0596r.d(a, "Sync with Server 3, delete from server : " + i2);
            i--;
            if (i3 <= 0) {
                break;
            }
        } while (i > 0);
        return i2;
    }

    public boolean b(Context context, List<WeightInfo> list) {
        C0596r.e(a, "Sync Deleted WeightInfos To Server!!");
        if (list == null || list.isEmpty()) {
            return true;
        }
        String g = g((List) list);
        SyncResult syncResult = new SyncResult();
        l.f(cn.com.smartdevices.bracelet.e.a.f(context), g, new ak(this, context, syncResult, list));
        return syncResult.result;
    }

    public List<WeightInfo> c() {
        List<WeightInfo> d = new e().a(WeightInfo.class).g("Timestamp DESC").d();
        C0596r.e(a, "Get All Infos : " + d.size());
        for (WeightInfo weightInfo : d) {
            C0596r.e(a, "Get Info : " + weightInfo);
        }
        return d;
    }

    public List<WeightInfo> c(int i) {
        com.activeandroid.b.b k = k();
        if (i > 0) {
            k = k.a(i);
        }
        List<WeightInfo> d = k.d();
        C0596r.e(a, "Get Infos Deleted : " + d.size());
        return d;
    }

    public void c(WeightInfo weightInfo) {
        if (weightInfo.synced == 0) {
            d(weightInfo);
        } else {
            i(weightInfo);
        }
    }

    public boolean c(List<WeightInfo> list) {
        boolean z;
        C0596r.d(a, "Delete Infos Local : " + list.size());
        com.activeandroid.a.d();
        try {
            for (WeightInfo d : list) {
                d(d);
            }
            com.activeandroid.a.f();
            z = true;
            return z;
        } catch (Exception e) {
            z = e;
            z.printStackTrace();
            return false;
        } finally {
            com.activeandroid.a.e();
        }
    }

    public List<WeightInfo> d() {
        return c(0);
    }

    public List<WeightInfo> d(int i) {
        com.activeandroid.b.b l = l();
        if (i > 0) {
            l = l.a(i);
        }
        List<WeightInfo> d = l.d();
        C0596r.e(a, "Get Infos NeedSync : " + d.size());
        return d;
    }

    public void d(WeightInfo weightInfo) {
        C0596r.d(a, "Delete Info Local : " + weightInfo);
        weightInfo.delete();
    }

    public boolean d(List<WeightInfo> list) {
        boolean z;
        C0596r.d(a, "Update Infos : " + list.size());
        com.activeandroid.a.d();
        try {
            for (WeightInfo j : list) {
                j(j);
            }
            com.activeandroid.a.f();
            z = true;
            return z;
        } catch (Exception e) {
            z = e;
            z.printStackTrace();
            return false;
        } finally {
            com.activeandroid.a.e();
        }
    }

    public int e() {
        int g = k().g();
        C0596r.e(a, "Get Infos Deleted Count : " + g);
        return g;
    }

    public WeightInfo e(int i) {
        Object[] objArr = new Object[]{Integer.valueOf(i)};
        WeightInfo weightInfo = (WeightInfo) new e().a(WeightInfo.class).a("Synced>?", Integer.valueOf(-1)).b("UserId=?", objArr).g("Timestamp DESC").e();
        C0596r.e(a, "Get Latest Info : " + i + ", " + weightInfo);
        return weightInfo;
    }

    public void e(WeightInfo weightInfo) {
        b(weightInfo, true);
    }

    public WeightInfo f(int i) {
        Object[] objArr = new Object[]{Integer.valueOf(i)};
        WeightInfo weightInfo = (WeightInfo) new e().a(WeightInfo.class).a("Synced>?", Integer.valueOf(-1)).b("UserId=?", objArr).g("Timestamp ASC").e();
        C0596r.e(a, "Get Earliest Info : " + i + ", " + weightInfo);
        return weightInfo;
    }

    public List<WeightInfo> f() {
        return d(0);
    }

    public int g() {
        int g = l().g();
        C0596r.e(a, "Get Infos NeedSync Count : " + g);
        return g;
    }

    public WeightInfo h() {
        return (WeightInfo) new e().a(WeightInfo.class).a("Synced>?", Integer.valueOf(-1)).g("Timestamp DESC").e();
    }

    public SportDay i() {
        SportDay sportDay = new SportDay();
        WeightInfo weightInfo = (WeightInfo) new e().a(WeightInfo.class).a("Synced>?", Integer.valueOf(-1)).g("Timestamp ASC").e();
        C0596r.e(a, "Get Oldest Info : " + weightInfo);
        if (weightInfo == null) {
            return sportDay;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(weightInfo.timestamp);
        return new SportDay(instance);
    }

    public SportDay j() {
        SportDay sportDay = new SportDay();
        WeightInfo weightInfo = (WeightInfo) new e().a(WeightInfo.class).a("Synced>?", Integer.valueOf(-1)).g("Timestamp DESC").e();
        C0596r.e(a, "Get Latest Info : " + weightInfo);
        if (weightInfo == null) {
            return sportDay;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(weightInfo.timestamp);
        return new SportDay(instance);
    }
}
