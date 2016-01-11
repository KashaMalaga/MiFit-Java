package cn.com.smartdevices.bracelet.gps.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import cn.com.smartdevices.bracelet.gps.e.b;
import com.huami.android.ui.CustomActionBarActivity;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.b.a.i;
import com.xiaomi.hm.health.b.a.j;
import com.xiaomi.hm.health.b.a.n;

public class IllustrateActivity extends CustomActionBarActivity implements OnClickListener {
    public static final String a = "tabs";
    public static final int b = 1;
    public static final int c = 17;
    public static final int d = 273;
    private FragmentManager f;
    private aL g;
    private aS h;
    private Q i;
    private Fragment j;
    private View k;
    private View l;
    private View m;

    public IllustrateActivity() {
        super(a.f, a.f);
    }

    public static void a(Context context, int i) {
        Intent intent = new Intent(context, IllustrateActivity.class);
        intent.putExtra(a, i);
        context.startActivity(intent);
    }

    public void a(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction beginTransaction = this.f.beginTransaction();
            if (fragment.isAdded()) {
                beginTransaction.hide(this.j).show(fragment).commit();
            } else {
                beginTransaction.hide(this.j).add(i.container, fragment).commit();
            }
            this.j = fragment;
        }
    }

    protected String b() {
        return getString(n.running_help);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == i.pace) {
            this.k.setVisibility(0);
            this.l.setVisibility(4);
            if (this.m != null) {
                this.m.setVisibility(4);
            }
            a(this.g);
        } else if (id == i.foot) {
            this.k.setVisibility(4);
            this.l.setVisibility(0);
            if (this.m != null) {
                this.m.setVisibility(4);
            }
            a(this.h);
        } else if (id == i.hr) {
            this.k.setVisibility(4);
            this.l.setVisibility(4);
            if (this.m != null) {
                this.m.setVisibility(0);
            }
            a(this.i);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(j.activity_illustrate);
        if (b.d()) {
            ((ViewStub) findViewById(i.stub_illustrate_hr)).inflate();
            findViewById(i.hr).setOnClickListener(this);
            this.m = findViewById(i.view_hr);
            this.i = new Q();
        } else {
            ((ViewStub) findViewById(i.stub_illustrate)).inflate();
        }
        findViewById(i.pace).setOnClickListener(this);
        findViewById(i.foot).setOnClickListener(this);
        this.k = findViewById(i.view_pace);
        this.l = findViewById(i.view_foot);
        int intExtra = getIntent().getIntExtra(a, b);
        this.f = getFragmentManager();
        this.g = new aL();
        this.h = new aS();
        if (intExtra == c) {
            this.j = this.h;
            this.l.setVisibility(0);
        } else if (intExtra == d) {
            this.j = this.i;
            this.m.setVisibility(0);
        } else {
            this.j = this.g;
            this.k.setVisibility(0);
        }
        this.f.beginTransaction().add(i.container, this.j).commit();
    }
}
