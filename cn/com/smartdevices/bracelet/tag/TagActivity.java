package cn.com.smartdevices.bracelet.tag;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.tag.a.c;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import com.huami.android.view.b;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;

public class TagActivity extends SystemBarTintActivity implements OnClickListener, OnLongClickListener, c {
    private static final int f = 4097;
    c c;
    private TextView d;
    private View e;
    private final Handler g = new d(this);

    private void a() {
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        Fragment nVar = new n();
        this.d.setText(r.action_mark);
        this.e.setVisibility(0);
        beginTransaction.replace(l.container, nVar);
        beginTransaction.commit();
    }

    public void a(int i) {
        switch (i) {
            case kankan.wheel.widget.l.a /*1*/:
                Keeper.keepUploadEnable(true);
                a();
                return;
            default:
                return;
        }
    }

    public void onBackPressed() {
        if (Keeper.readUploadEnable()) {
            super.onBackPressed();
        } else {
            finish();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case l.home_back /*2131296313*/:
                finish();
                return;
            case l.history_button /*2131296577*/:
                startActivity(TagHistoryActivity.a(this));
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.activity_mark);
        this.d = (TextView) findViewById(l.home_back);
        this.d.setOnClickListener(this);
        findViewById(l.title_back_bar).setOnLongClickListener(this);
        this.e = findViewById(l.history_button);
        this.e.setOnClickListener(this);
        if (bundle == null) {
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            if (Keeper.readUploadEnable()) {
                a();
            } else {
                this.d.setText(r.title_action_tag_agreement);
                beginTransaction.add(l.container, new k());
            }
            beginTransaction.commit();
        }
        this.c = new c(this, a.f);
        C0401a.a((Context) this, C0401a.by);
    }

    public boolean onLongClick(View view) {
        if (cn.com.smartdevices.bracelet.lab.b.c.f(this)) {
            this.c.a(new e(this));
        } else {
            b.a((Context) this, "\u5f53\u524d\u7f51\u7edc\u73af\u5883\u4e0d\u662fwifi\uff0c\u8bf7\u5230wifi\u4e0b\u518d\u6b21\u91cd\u8bd5", 0).show();
        }
        return false;
    }

    protected void onPause() {
        C0401a.b(C0401a.af);
        C0401a.b((Activity) this);
        super.onPause();
    }

    protected void onResume() {
        C0401a.a((Activity) this);
        C0401a.a(C0401a.af);
        super.onResume();
    }
}
