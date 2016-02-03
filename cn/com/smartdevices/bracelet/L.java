package cn.com.smartdevices.bracelet;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import cn.com.smartdevices.bracelet.eventbus.weight.EventWeightSyncedDevice;
import cn.com.smartdevices.bracelet.model.Birthday;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.weight.J;
import cn.com.smartdevices.bracelet.weight.P;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import cn.com.smartdevices.bracelet.weight.WeightInfo;
import cn.com.smartdevices.bracelet.weight.aA;
import cn.com.smartdevices.bracelet.weight.ah;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.a.d;
import com.xiaomi.hm.health.bt.bleservice.BLEService;
import com.xiaomi.hm.health.bt.profile.Weight.e;
import com.xiaomi.hm.health.bt.profile.Weight.m;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class L extends d {
    public static final int a = 30000;
    private static final String b = "SyncWeightDataCB";
    private SparseArray<ArrayList<WeightInfo>> d = new SparseArray();
    private int e = 0;
    private Context f = null;

    public L(Context context) {
        this.f = context;
    }

    private int a(ArrayList<e> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        List a;
        ah a2 = ah.a();
        J a3 = J.a();
        ArrayList arrayList2 = new ArrayList();
        boolean weightMergeResult = Keeper.readPersonInfo().getMiliConfig().getWeightMergeResult();
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            e eVar = (e) it.next();
            WeightInfo a4 = a2.a(eVar.e(), true);
            UserInfo userInfo = null;
            if (a4 != null) {
                if (ah.g(a4)) {
                    a2.d(a4);
                } else {
                    userInfo = a3.a(a4.uid);
                    if (userInfo == null) {
                        C0596r.d(b, "Should not go here!!!uid:" + a4.uid);
                    }
                }
            }
            if (userInfo == null) {
                List a5 = aA.a(eVar);
                if (a5 == null) {
                    C0596r.d(b, "Drop no mathed weight data!!!");
                } else if (a5.size() != 1) {
                    C0596r.d(b, "Drop the weight data that matched more than one user!!!");
                } else {
                    userInfo = (UserInfo) a5.get(0);
                }
            }
            WeightInfo weightInfo = new WeightInfo(eVar.k(), userInfo.uid, eVar.e());
            weightInfo.deviceid = eVar.a();
            if (weightMergeResult) {
                a(weightInfo);
                i2 = i;
            } else {
                i2 = i + 1;
                if (a4 != null) {
                    i2--;
                    if (a4.synced == 2) {
                        a2.d(a4);
                        arrayList2.add(weightInfo);
                    }
                } else {
                    arrayList2.add(weightInfo);
                }
            }
            i = i2;
        }
        if (weightMergeResult) {
            this.e = 0;
            a = a(this.d);
            i = this.e;
        } else {
            Object obj = arrayList2;
        }
        a2.a(a);
        if (a.size() <= 0) {
            return i;
        }
        EventBus.getDefault().post(new EventWeightSyncedDevice(true));
        return i;
    }

    private ArrayList<WeightInfo> a(SparseArray<ArrayList<WeightInfo>> sparseArray) {
        ArrayList<WeightInfo> arrayList = new ArrayList();
        int size = sparseArray.size();
        ah a = ah.a();
        for (int i = 0; i < size; i++) {
            WeightInfo weightInfo = null;
            Iterator it = ((ArrayList) sparseArray.valueAt(i)).iterator();
            while (it.hasNext()) {
                WeightInfo weightInfo2 = (WeightInfo) it.next();
                if (weightInfo2.uid == 0) {
                    C0596r.d(b, "<<merge>> USER_ID_UNKNOWN:" + weightInfo2);
                    arrayList.add(weightInfo2);
                    weightInfo2 = weightInfo;
                } else if (weightInfo == null) {
                    C0596r.d(b, "<<merge>> lastInfo is null");
                } else if (Math.abs(weightInfo2.timestamp - weightInfo.timestamp) <= 30000) {
                    C0596r.d(b, "<<merge>> ignore last info");
                    weightInfo = a.b(weightInfo.timestamp);
                    if (weightInfo != null) {
                        C0596r.d(b, "<<merge>> delete last info");
                        a.d(weightInfo);
                    }
                } else {
                    WeightInfo b = a.b(weightInfo.timestamp);
                    if (b == null) {
                        this.e++;
                        C0596r.d(b, "<<merge>> add last info:" + weightInfo);
                    } else {
                        a.d(b);
                        C0596r.d(b, "<<merge>> exsit last info:" + weightInfo);
                    }
                    arrayList.add(weightInfo);
                }
                weightInfo = weightInfo2;
            }
            if (weightInfo != null) {
                weightInfo2 = a.b(weightInfo.timestamp);
                if (weightInfo2 == null) {
                    this.e++;
                    C0596r.d(b, "<<merge>> add last info:" + weightInfo);
                } else {
                    a.d(weightInfo2);
                    C0596r.d(b, "<<merge>> exsit last info:" + weightInfo);
                }
                arrayList.add(weightInfo);
            }
        }
        return arrayList;
    }

    private void a(WeightInfo weightInfo) {
        ArrayList arrayList = (ArrayList) this.d.get(weightInfo.uid);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.d.put(weightInfo.uid, arrayList);
            C0596r.d(b, "<<merge>> add to SparseArray:" + weightInfo.uid);
        }
        C0596r.d(b, "<<merge>> add to WeightInfo list:" + weightInfo);
        arrayList.add(weightInfo);
    }

    private void b() {
        float f = GroundOverlayOptions.NO_DIMENSION;
        C0596r.e(b, "in updateWeightUI");
        J.a().d();
        ah.a();
        WeightInfo h = ah.a().h();
        UserInfo a = J.a().a(h.uid);
        P p = new P();
        p.a.a(h.timestamp);
        p.a.a(true);
        p.a.b(false);
        PersonInfo readPersonInfo = Keeper.readPersonInfo();
        p.a.a(readPersonInfo.miliConfig.weightUnit);
        p.a.b(aA.b(h.weight, readPersonInfo.miliConfig.weightUnit));
        p.a.a(a != null ? aA.a(a.height, Birthday.fromStr(a.birthday).getAge(), a.weight) : GroundOverlayOptions.NO_DIMENSION);
        p.b = a != null ? a.name : this.f.getString(R.string.visitor);
        p.c = a != null ? a.uid : 0;
        if (a != null) {
            f = a.targetWeight;
        }
        p.d = f;
        EventBus.getDefault().post(p);
    }

    public void a() {
    }

    public void a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        C0596r.e(b, "notifyDynamicStatusChanged");
        context.sendBroadcast(new Intent(BLEService.f));
    }

    public void a(m mVar) {
        int i = 0;
        if (mVar.d != null) {
            i = a(mVar.d);
        }
        if (i > 0) {
            b();
            C0891z.a(this.f).a(mVar, i);
            a(this.f);
            C0401a.a(this.f, C0401a.fK);
            if (mVar.c > 0) {
                C0596r.e(b, " reboot Count " + mVar.c);
                C0401a.a(this.f, C0401a.fP, mVar.c);
            }
        }
    }

    public void a(Object obj) {
        super.a(obj);
        if (obj != null) {
            a((m) obj);
        }
    }
}
