package cn.com.smartdevices.bracelet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.model.BasicDateData;
import cn.com.smartdevices.bracelet.tencent.QQLogin;
import cn.com.smartdevices.bracelet.tencent.health.QQHealth;
import com.xiaomi.hm.health.bt.a.d;
import com.xiaomi.hm.health.bt.bleservice.BLEService;
import com.xiaomi.hm.health.bt.bleservice.a;
import com.xiaomi.hm.health.bt.model.HwSyncDataStatus;
import com.xiaomi.hm.health.bt.model.b;
import com.xiaomi.hm.health.bt.model.h;
import com.xiaomi.hm.health.dataprocess.DaySportData;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import com.xiaomi.hm.health.dataprocess.SportData;
import com.xiaomi.hm.health.dataprocess.SportDay;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class F extends d {
    public static final long a = 300000;
    public static HwSyncDataStatus b = new HwSyncDataStatus();
    private static final int d = 0;
    private static final int e = 1;
    private static final String f = "SyncMiLiDataCB";
    private static final int g = 3;
    private static boolean h = false;
    private Context i = null;
    private List<String> j = new ArrayList();
    private boolean k = false;
    private Handler l = new G(this);
    private boolean m = false;

    public F(Context context) {
        this.i = context.getApplicationContext();
    }

    public F(Context context, boolean z) {
        this.i = context.getApplicationContext();
        this.k = z;
    }

    private List<SportDay> a(List<b> list) {
        h f = a.f();
        if (f != null) {
            this.m = f.a();
        }
        C0596r.d(f, "isMiLi1S:" + this.m);
        Calendar instance = Calendar.getInstance();
        HashMap hashMap = new HashMap();
        for (b bVar : list) {
            List<com.xiaomi.hm.health.bt.model.a> list2 = bVar.b;
            Calendar calendar = bVar.a;
            C0596r.d(f, "data size:" + list2.size() + ",data time:" + calendar.getTime().toString() + ",phone time:" + instance.getTime().toString());
            if (calendar.getTimeInMillis() > instance.getTimeInMillis()) {
                C0596r.d(f, "the synced data Calendar is wrong,drop!!!");
            }
            for (com.xiaomi.hm.health.bt.model.a aVar : list2) {
                DaySportData daySportData;
                int i = calendar.get(e);
                int i2 = calendar.get(2);
                int i3 = calendar.get(5);
                int i4 = calendar.get(12) + (calendar.get(11) * 60);
                DaySportData a = C0591m.a().a(i, i2, i3);
                if (a == null) {
                    a = new DaySportData(i, i2, i3);
                    C0591m.a().a(a);
                    daySportData = a;
                } else {
                    daySportData = a;
                }
                daySportData.setNeedSync(true);
                daySportData.setNeedPostProcess(true);
                SportData sportData = !this.m ? new SportData(i4, aVar.e & HeartRateInfo.HR_EMPTY_VALUE, aVar.c & HeartRateInfo.HR_EMPTY_VALUE, aVar.d & HeartRateInfo.HR_EMPTY_VALUE) : new SportData(i4, aVar.e & HeartRateInfo.HR_EMPTY_VALUE, aVar.c & HeartRateInfo.HR_EMPTY_VALUE, aVar.d & HeartRateInfo.HR_EMPTY_VALUE, aVar.f & HeartRateInfo.HR_EMPTY_VALUE);
                if (this.k) {
                    daySportData.add(sportData, true);
                } else {
                    daySportData.add(sportData);
                }
                if (!hashMap.containsKey(daySportData.getKey())) {
                    hashMap.put(daySportData.getKey(), daySportData.getSportDay());
                }
                calendar.add(12, e);
            }
        }
        C0596r.d(f, "analysis...............................before");
        C0591m.a().o();
        C0596r.d(f, "analysis...............................after");
        C0596r.d(f, "updateStepInfoWithRealtimeSteps...............................before");
        if (ChartData.a().x()) {
            ChartData.a().a(-1, (int) d);
        }
        C0596r.d(f, "updateStepInfoWithRealtimeSteps...............................before");
        C0596r.d(f, "saveToDb...............................before");
        C0591m.a().p();
        C0596r.d(f, "saveToDb...............................after");
        C0596r.d(f, "initDays...............................before");
        C0591m.a().c();
        C0596r.d(f, "initDays...............................after");
        return new ArrayList(hashMap.values());
    }

    private void a(int i, int i2, boolean z) {
        C0596r.e(f, "notifySyncDataStatusChanged:" + i);
        if (!this.k) {
            Parcelable hwSyncDataStatus = new HwSyncDataStatus(i, i2, z);
            b = hwSyncDataStatus;
            Intent intent = new Intent(BLEService.e);
            intent.putExtra(BLEService.j, hwSyncDataStatus);
            this.i.sendBroadcast(intent);
        }
    }

    private void a(Context context, List<SportDay> list) {
        if (cn.com.smartdevices.bracelet.config.b.h().c.d.booleanValue()) {
            C0596r.e(f, "Sync Data To QQ Health!!");
            QQLogin instance = QQLogin.getInstance();
            QQHealth instance2 = QQHealth.getInstance();
            if (instance != null && instance.isLoginValid() && instance2 != null) {
                instance2.addNeedSyncDays(list);
                instance2.syncDataAsync();
            }
        }
    }

    private void a(ArrayList<BasicDateData> arrayList) {
        int i = d;
        for (int i2 = d; i2 < arrayList.size(); i2 += e) {
            if (this.j.contains(((BasicDateData) arrayList.get(i2)).date)) {
                C0596r.d(f, " failed date = " + ((BasicDateData) arrayList.get(i2)).date + " , but retry alread.");
                return;
            }
            C0596r.d(f, " failed date = " + ((BasicDateData) arrayList.get(i2)).date);
            this.j.add(((BasicDateData) arrayList.get(i2)).date);
        }
        Message message = new Message();
        message.what = e;
        ArrayList arrayList2 = new ArrayList();
        while (i < arrayList.size()) {
            arrayList2.add(((BasicDateData) arrayList.get(i)).date);
            i += e;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("failed_datas", arrayList2);
        message.setData(bundle);
        this.l.sendMessage(message);
    }

    public void a() {
        super.a();
        a(2, d, true);
    }

    public void a(int i) {
        super.a(i);
        a(g, i, true);
    }

    public void a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        C0596r.e(f, "notifyDynamicStatusChanged");
        context.sendBroadcast(new Intent(BLEService.f));
    }

    public void a(Object obj) {
        super.a(obj);
        if (obj != null) {
            h = false;
            List a = a((List) obj);
            this.l.sendEmptyMessage(d);
            a(this.i.getApplicationContext(), a);
            a(false);
            Keeper.keepSyncTime(System.currentTimeMillis(), d);
            if (!this.k) {
                Keeper.keepSyncBraceletTime(System.currentTimeMillis());
            }
            C0591m.a().f();
            a(4, 100, true);
            return;
        }
        a(4, 100, false);
    }

    public void a(boolean z) {
        DynamicManager.getInstance().analysisDynamic(this.i, z);
        a(this.i);
    }

    public void b(Object obj) {
        super.b(obj);
        a(4, 100, false);
    }
}
