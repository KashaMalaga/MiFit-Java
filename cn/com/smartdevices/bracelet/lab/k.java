package cn.com.smartdevices.bracelet.lab;

import android.content.Context;
import android.util.SparseArray;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.lab.sportmode.RopeSkippingInfo;
import cn.com.smartdevices.bracelet.lab.sportmode.SitUpInfo;
import cn.com.smartdevices.bracelet.lab.sportmode.SportBaseInfo;
import cn.com.smartdevices.bracelet.lab.ui.LabFactoryConnectedAdvActivity;
import cn.com.smartdevices.bracelet.lab.ui.LabFactoryReminderActivity;
import cn.com.smartdevices.bracelet.lab.ui.SportAnalyserActivity;
import cn.com.smartdevices.bracelet.lab.ui.SportFavoriteVoteGridActivity;
import cn.com.smartdevices.bracelet.partner.WebActivity;
import cn.com.smartdevices.bracelet.tag.TagActivity;
import com.xiaomi.hm.health.bt.bleservice.a;
import com.xiaomi.hm.health.bt.model.h;
import com.xiaomi.hm.health.r;
import java.util.ArrayList;

public final class k {
    public static final String a = "Situps";
    public static final String b = "RopeSkipping";
    public static final String c = "RunningHelper";
    public static final String d = "RunningHelperTester";
    public static final String e = "Other";
    public static final String f = "MoreSportFavorite";
    public static final String g = "LabStepsCountTest";
    public static final String h = (k.class.getPackage().getName() + ".extra.SPORT_TYPE");
    public static final String i = "disconnected_reminder";
    public static final String j = "bind_weixin";
    public static final String k = "connected_adv";
    public static final String l = "action_mark";
    public static final String m = "runner_group";
    public static final String n = "bind_qq";
    public static final int o = 0;
    public static final int p = 1;
    private String q = null;

    public k(String str) {
        this.q = str;
    }

    public static SparseArray<ArrayList<a>> a(Context context) {
        if (context == null) {
            return new SparseArray();
        }
        ArrayList arrayList;
        a aVar;
        h f = a.f();
        SparseArray<ArrayList<a>> sparseArray = new SparseArray();
        b h = b.h();
        if (!(DeviceSource.hasBindSensorHub() || f == null || f.a())) {
            arrayList = new ArrayList(3);
            aVar = new a(b);
            aVar.a = r.lab_factory_sport_type_ropeskipping;
            aVar.b = SportAnalyserActivity.class;
            arrayList.add(aVar);
            aVar = new a(a);
            aVar.a = r.lab_factory_sport_type_situp;
            aVar.b = SportAnalyserActivity.class;
            arrayList.add(aVar);
            if (h.e.ENABLE_SPORT_VOTE.booleanValue()) {
                aVar = new a(f);
                aVar.a = r.lab_factory_sport_more_sport_favorite_vote;
                aVar.b = SportFavoriteVoteGridActivity.class;
                arrayList.add(aVar);
            }
            if (!arrayList.isEmpty()) {
                sparseArray.put(o, arrayList);
            }
        }
        arrayList = new ArrayList();
        if (h.j.a.booleanValue()) {
            aVar = new a(i);
            aVar.a = r.lab_factory_disconnected_reminder;
            aVar.b = LabFactoryReminderActivity.class;
            arrayList.add(aVar);
        }
        if (h.j.c.booleanValue() && Keeper.readBluethoothBrocastEnable()) {
            aVar = new a(k);
            aVar.a = r.connected_broadcast;
            aVar.b = LabFactoryConnectedAdvActivity.class;
            arrayList.add(aVar);
        }
        if (h.e.ENABLE_ACTION_TAG.booleanValue() && Keeper.readBehaviorTagEnable()) {
            aVar = new a(l);
            aVar.a = r.action_mark;
            aVar.b = TagActivity.class;
            arrayList.add(aVar);
        }
        if (h.g.ENABLE_RUNNER_GROUP.booleanValue()) {
            a aVar2 = new a(m);
            aVar2.a = r.label_runner_group;
            aVar2.b = WebActivity.class;
            arrayList.add(aVar2);
        }
        if (cn.com.smartdevices.bracelet.gaocept.b.a) {
            try {
                aVar2 = new a(e);
                aVar2.a = r.lab_factory_internal_test;
                aVar2.b = Class.forName("cn.com.smartdevices.bracelet.lab.ui.LabFactoryTestActivity");
                arrayList.add(aVar2);
            } catch (Exception e) {
            }
            try {
                aVar2 = new a(d);
                aVar2.a = r.sport_running_helper_test;
                aVar2.b = Class.forName("cn.com.smartdevices.bracelet.gps.ui.GaodeTestActivity");
                arrayList.add(aVar2);
            } catch (Exception e2) {
            }
        }
        try {
            aVar2 = new a(g);
            aVar2.a = r.lab_step_test;
            aVar2.b = Class.forName("cn.com.smartdevices.bracelet.lab.ui.StepsCountActivity");
            arrayList.add(aVar2);
        } catch (Exception e3) {
        }
        if (arrayList.isEmpty()) {
            return sparseArray;
        }
        sparseArray.put(p, arrayList);
        return sparseArray;
    }

    public SportBaseInfo a() {
        if (b.equals(this.q)) {
            return new RopeSkippingInfo();
        }
        if (a.equals(this.q)) {
            return new SitUpInfo();
        }
        throw new IllegalArgumentException("Dont support mSportName =" + this.q);
    }
}
