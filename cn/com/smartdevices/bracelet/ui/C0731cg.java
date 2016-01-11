package cn.com.smartdevices.bracelet.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Constant;
import cn.com.smartdevices.bracelet.DynamicManager;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.partner.Partner;
import cn.com.smartdevices.bracelet.partner.WebActivity;
import cn.com.smartdevices.bracelet.push.MiPushMessageReceiver;
import cn.com.smartdevices.bracelet.relation.MessageActivity;
import cn.com.smartdevices.bracelet.shoes.data.db.j;
import com.xiaomi.e.a;

class C0731cg extends BroadcastReceiver {
    final /* synthetic */ MainUIActivity a;

    C0731cg(MainUIActivity mainUIActivity) {
        this.a = mainUIActivity;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        C0596r.e("MainUIActivity", "action : " + action);
        if ("android.intent.action.DOWNLOAD_COMPLETE".equals(action)) {
            C0596r.e(MiPushMessageReceiver.PUSH_TYPE_INTENT, a.f + intent.getLongExtra("extra_download_id", 0));
            Utils.b(this.a);
        } else if (kankan.wheel.widget.a.bM.equals(action) || kankan.wheel.widget.a.bN.equals(action) || Constant.bZ.equals(action)) {
            this.a.s();
            r1 = new Intent(context, SettingActivity.class);
            r1.setFlags(67108864);
            if (kankan.wheel.widget.a.bN.equals(action)) {
                r1.setClass(context, AlarmActivity.class);
            } else if (Constant.bZ.equals(action)) {
                r1.putExtra(Utils.a, Utils.c);
            }
            context.startActivity(r1);
        } else if (Constant.aY.equals(action)) {
            DynamicManager.getInstance().c(this.a.E);
        } else if (Constant.bV.equals(action)) {
            C0401a.a(this.a, C0409b.aX);
            this.a.s();
            r0 = new Intent(context, MessageActivity.class);
            r0.setFlags(67108864);
            context.startActivity(r0);
        } else if (Constant.bW.equals(action)) {
            this.a.s();
            r1 = new Intent("android.intent.action.VIEW", Uri.parse(intent.getStringExtra(j.e)));
            r1.setFlags(67108864);
            context.startActivity(r1);
        } else if (Constant.bX.equals(action)) {
            this.a.s();
            r0 = WebActivity.buildIntent(context, (Partner) intent.getExtras().getSerializable("partner"));
            r0.setFlags(67108864);
            context.startActivity(r0);
        }
    }
}
