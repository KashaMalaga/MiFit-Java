package cn.com.smartdevices.bracelet.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.View;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.config.f;
import cn.com.smartdevices.bracelet.heartrate.HeartRateBuyGuideActivity;
import cn.com.smartdevices.bracelet.heartrate.HeartRateMainActivity;
import cn.com.smartdevices.bracelet.lab.h;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.partner.PartnerListActivity;
import cn.com.smartdevices.bracelet.relation.FriendActivity;
import cn.com.smartdevices.bracelet.relation.db.Friend;
import cn.com.smartdevices.bracelet.weight.family.WeightFamilyMemberActivity;
import com.xiaomi.hm.health.bt.b.c;
import com.xiaomi.hm.health.bt.bleservice.a;

class bM extends ContextThemeWrapper {
    private static final int d = 2000;
    long a = 0;
    final /* synthetic */ bH b;
    private Handler c = new Handler();

    public bM(bH bHVar) {
        this.b = bHVar;
    }

    public bM(bH bHVar, Context context, int i) {
        this.b = bHVar;
        super(context, i);
    }

    private void a(Context context, Intent intent, String str) {
        context.startActivity(intent);
        C0401a.a(this.b.getActivity(), C0401a.dg, str);
        this.c.postDelayed(new bP(this), 1000);
    }

    private void a(Context context, Class<?> cls, String str) {
        Intent intent = new Intent();
        intent.setClass(context, cls);
        context.startActivity(intent);
        C0401a.a(this.b.getActivity(), C0401a.dg, str);
        this.c.postDelayed(new bO(this), 1000);
    }

    public void onDismissClick(View view) {
        this.b.onCancel(this.b.getDialog());
    }

    public void onItemAboutClick(View view) {
        a(this.b.getActivity(), SettingAboutActivity.class, C0401a.dl);
    }

    public void onItemAlarmClick(View view) {
        a(this.b.getActivity(), AlarmActivity.class, C0401a.di);
    }

    public void onItemDevicesClick(View view) {
        Intent intent = new Intent(this.b.getActivity(), SettingActivity.class);
        if (ChartData.a().u() == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            intent.putExtra(Utils.a, Utils.c);
        }
        a(this.b.getActivity(), intent, C0401a.dh);
    }

    public void onItemFriendClick(View view) {
        h.b("RELATION");
        a(this.b.getActivity(), FriendActivity.class, C0401a.dq);
    }

    public void onItemHeartRateClick(View view) {
        if (Keeper.readPersonInfo().hasBinded1S()) {
            com.xiaomi.hm.health.bt.model.h f = a.f();
            if ((f != null && f.a()) || Keeper.readPersonInfo().hasBinded1S()) {
                a(this.b.getActivity(), HeartRateMainActivity.class, C0401a.dr);
                return;
            }
            return;
        }
        startActivity(new Intent(this, HeartRateBuyGuideActivity.class));
    }

    public void onItemPersonalClick(View view) {
        a(this.b.getActivity(), MyPageActivity.class, C0401a.dj);
    }

    public void onItemRunningClick(View view) {
        h.b("RUNNING");
        Intent intent = new Intent("com.xiaomi.hm.health.action.RUNNING");
        intent.setPackage(this.b.getActivity().getPackageName());
        a(this.b.getActivity(), intent, C0401a.dn);
    }

    public void onItemSensorhubClick(View view) {
        Intent intent = new Intent(this.b.getActivity(), DynamicDetailActivity.class);
        intent.putExtra(ChartData.KEY_SOURCE, c.SENSORHUB.b());
        intent.putExtra(ChartData.KEY_MODE, 1);
        a(this.b.getActivity(), intent, C0401a.dm);
    }

    public void onItemServiceClick(View view) {
        Keeper.keepFeatureVisited(f.f);
        b.h().o.getClass();
        String str = com.xiaomi.e.a.f;
        if (!f.f.equals(str)) {
            Keeper.keepFeatureVisited(str);
        }
        a(this.b.getActivity(), PartnerListActivity.class, C0401a.dp);
    }

    public void onItemShareClick(View view) {
        C0596r.e("TTT", "interval " + (System.currentTimeMillis() - this.a));
        if (System.currentTimeMillis() - this.a >= 2000) {
            this.a = System.currentTimeMillis();
            int i = 0;
            Bundle arguments = this.b.getArguments();
            if (arguments != null) {
                i = arguments.getInt(ChartData.KEY_MODE);
            }
            if (i == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
                this.b.d();
            } else {
                MainUIActivity mainUIActivity = (MainUIActivity) this.b.getActivity();
                if (mainUIActivity != null) {
                    mainUIActivity.j();
                } else {
                    return;
                }
            }
            C0401a.a(this.b.getActivity(), C0401a.dg, C0401a.dk);
            this.c.postDelayed(new bN(this), 1000);
        }
    }

    public void onItemWeightClick(View view) {
        a(this.b.getActivity(), WeightFamilyMemberActivity.class, Friend.d);
    }
}
