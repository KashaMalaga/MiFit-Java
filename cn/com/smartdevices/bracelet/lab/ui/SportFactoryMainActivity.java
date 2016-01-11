package cn.com.smartdevices.bracelet.lab.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.lab.a;
import cn.com.smartdevices.bracelet.lab.k;
import cn.com.smartdevices.bracelet.partner.Partner;
import cn.com.smartdevices.bracelet.partner.WebActivity;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import com.huami.android.view.b;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import de.greenrobot.event.EventBus;

public class SportFactoryMainActivity extends SystemBarTintActivity implements OnClickListener, OnLongClickListener, OnChildClickListener, OnGroupClickListener {
    private static final int d = 4;
    private N a = null;
    private ExpandableListView b;
    private int c = 0;

    private void a(int i) {
        b.a((Context) this, i, 0).show();
    }

    private void b() {
        if (cn.com.smartdevices.bracelet.config.b.h().j.c.booleanValue()) {
            boolean readBluethoothBrocastEnable = Keeper.readBluethoothBrocastEnable();
            Keeper.setBluethoothBrocastEnable(!readBluethoothBrocastEnable);
            this.a.a(k.a(this));
            a();
            b.a((Context) this, readBluethoothBrocastEnable ? getString(r.toast_disable_bluethooth_brocast) : getString(r.toast_enable_bluethooth_brocast), 0).show();
        }
    }

    public void a() {
        int groupCount = this.a.getGroupCount();
        for (int i = 0; i < groupCount; i++) {
            this.b.expandGroup(i);
        }
    }

    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        a a = this.a.a(i, i2);
        if (a == null || a.b == null) {
            return false;
        }
        if (k.m.equals(a.c)) {
            Partner partner = new Partner();
            partner.url = "http://paopaotuan.org/pk.do";
            partner.title = "\u5c0f\u7c73\u624b\u73af\u8dd1\u8dd1\u56e2";
            partner.shareContent = "\u521b\u5efa\u6216\u52a0\u5165\u8dd1\u8dd1\u56e2\uff0c\u4e92\u76f8\u6fc0\u52b1\u3001\u4e00\u8d77\u6210\u957f\uff01";
            partner.subTitle = "\u5c0f\u7c73\u624b\u73af\u8dd1\u8dd1\u56e2";
            partner.id = "runnerHelpe";
            startActivity(WebActivity.buildIntent(this, partner));
        } else {
            try {
                Intent intent = new Intent(this, a.b);
                intent.putExtra(k.h, a.c);
                startActivity(intent);
                return true;
            } catch (ActivityNotFoundException e) {
                a(r.lab_factory_sport_analyser_activity_not_found);
            }
        }
        return true;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case l.home_back /*2131296313*/:
                finish();
                return;
            case l.rl_head_title /*2131297538*/:
                this.c++;
                if (this.c == d) {
                    this.c = 0;
                    b();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.activity_lab_factory_main);
        View findViewById = findViewById(l.rl_head_title);
        findViewById.setOnLongClickListener(this);
        findViewById.setOnClickListener(this);
        TextView textView = (TextView) findViewById(l.home_back);
        textView.setText(getString(r.lab_factory_title));
        textView.setOnClickListener(this);
        this.a = new N(this, k.a(this));
        this.b = (ExpandableListView) findViewById(l.list);
        this.b.setAdapter(this.a);
        this.b.setOnChildClickListener(this);
        this.b.setOnGroupClickListener(this);
        a();
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        return true;
    }

    public boolean onLongClick(View view) {
        if (cn.com.smartdevices.bracelet.config.b.h().e.ENABLE_ACTION_TAG.booleanValue()) {
            boolean readBehaviorTagEnable = Keeper.readBehaviorTagEnable();
            Keeper.setBehaviorTagEnable(!readBehaviorTagEnable);
            this.a.a(k.a(this));
            a();
            b.a((Context) this, readBehaviorTagEnable ? getString(r.toast_disable_behavior_tag) : getString(r.toast_enable_behavior_tag), 0).show();
        }
        return false;
    }

    public void onPause() {
        super.onResume();
        C0401a.b(C0401a.Z);
        C0401a.b((Activity) this);
    }

    public void onResume() {
        super.onResume();
        C0401a.a(C0401a.Z);
        C0401a.a((Activity) this);
    }
}
