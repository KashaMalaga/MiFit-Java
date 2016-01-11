package cn.com.smartdevices.bracelet.weight.goal;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.weight.J;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import com.activeandroid.b.e;
import java.util.List;

public class a {
    private static final String a = "WeightGoalManager";
    private static a b;

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    private void a(Context context, WeightGoal weightGoal) {
        Utils.a(context, weightGoal, new b(this));
    }

    private void b(Context context, WeightGoal weightGoal) {
        C0596r.e(a, " local doesnt found data and can not del");
        Utils.a(context, weightGoal.fuid + com.xiaomi.e.a.f, weightGoal.datetime, new c(this, weightGoal));
    }

    public WeightGoal a(int i, long j) {
        Object[] objArr = new Object[]{Long.valueOf(j)};
        objArr = new Object[]{Integer.valueOf(WeightGoal.WEIGHTGOAL_NEED_DELETE)};
        List d = new e().a(WeightGoal.class).a("FUID=?", Integer.valueOf(i)).b("DateTime <= ?", objArr).b("Synced!=?", objArr).g("DateTime DESC").d();
        if (d == null || d.size() <= 0) {
            C0596r.e(a, "size null");
            return null;
        }
        C0596r.e(a, "size " + d.size());
        return (WeightGoal) d.get(0);
    }

    public List<WeightGoal> a(int i, int i2) {
        C0596r.e(a, "get goal list by uid " + i + " tag " + i2);
        return new e().a(WeightGoal.class).a("FUID=?", Integer.valueOf(i)).b("Synced=?", Integer.valueOf(i2)).d();
    }

    public void a(Context context) {
        C0596r.e(a, "syncLocalToServer...");
        for (UserInfo userInfo : J.a().d()) {
            int i = userInfo.uid;
            List<WeightGoal> a = a(i, WeightGoal.WEIGHTGOAL_NEED_DELETE);
            C0596r.e(a, a == null ? "needdelelist is empty " : " need delete " + a.size() + " weight goal");
            for (WeightGoal weightGoal : a) {
                C0596r.e(a, "dele goal");
                b(context, weightGoal);
            }
            List<WeightGoal> a2 = a(i, WeightGoal.WEIGHTGOAL_NEED_SYNC);
            C0596r.e(a, a2 == null ? "needUpdateList is empty " : " need update " + a2.size() + " weight goal");
            for (WeightGoal weightGoal2 : a2) {
                C0596r.e(a, "udpate goal");
                a(context, weightGoal2);
            }
        }
    }

    public void a(Context context, List<UserInfo> list) {
        C0596r.e(a, "syncFromServer...");
        for (UserInfo userInfo : list) {
            Utils.a(context, userInfo.uid + com.xiaomi.e.a.f, com.xiaomi.e.a.f, com.xiaomi.e.a.f, new d(this));
        }
    }

    public void a(WeightGoal weightGoal) {
        weightGoal.synced = WeightGoal.WEIGHTGOAL_NEED_SYNC;
        weightGoal.save();
    }

    public boolean a(int i) {
        Object[] objArr = new Object[]{Integer.valueOf(WeightGoal.WEIGHTGOAL_NEED_DELETE)};
        List d = new e().a(WeightGoal.class).a("FUID=?", Integer.valueOf(i)).b("Synced!=?", objArr).d();
        if (d == null || d.size() == 0) {
            C0596r.e(a, "the user fuid is first time to set weight goal");
            return true;
        }
        C0596r.e(a, " the user fuid is not first time to set weight goal and the size is " + d.size());
        return false;
    }

    public void b() {
        C0596r.g(a, "Delete All Infos!!");
        new com.activeandroid.b.a().a(WeightGoal.class).d();
    }

    public void b(int i) {
        C0596r.e(a, "deleteuserWeightGoalInLocal " + i);
        List<WeightGoal> d = new e().a(WeightGoal.class).a("FUID=?", Integer.valueOf(i)).g("DateTime DESC").d();
        if (d == null || d.size() == 0) {
            C0596r.e(a, "nothing goal found in fuid " + i);
            return;
        }
        com.activeandroid.a.d();
        try {
            for (WeightGoal weightGoal : d) {
                weightGoal.synced = WeightGoal.WEIGHTGOAL_NEED_DELETE;
                weightGoal.save();
            }
            com.activeandroid.a.f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            com.activeandroid.a.e();
        }
    }

    public void b(Context context) {
        C0596r.e(a, "clear all");
        for (WeightGoal weightGoal : new e().a(WeightGoal.class).d()) {
            C0596r.e(a, "delete goal " + weightGoal.fuid + " " + weightGoal.datetime);
            weightGoal.synced = WeightGoal.WEIGHTGOAL_NEED_DELETE;
            weightGoal.save();
            b(context, weightGoal);
        }
    }

    public long c(int i) {
        List d = new e().a(WeightGoal.class).a("FUID=?", Integer.valueOf(i)).g("DateTime DESC").d();
        if (d == null || d.size() == 0) {
            C0596r.e(a, "nothing goal found in fuid " + i);
            return -1;
        }
        WeightGoal weightGoal = (WeightGoal) d.get(0);
        C0596r.e(a, "latest goal " + weightGoal.toString());
        return weightGoal.datetime;
    }
}
