package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import com.xiaomi.hm.health.bt.bleservice.a;
import com.xiaomi.hm.health.i;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import kankan.wheel.widget.g;

public class SettingContainerActivity extends SystemBarTintActivity {
    public static final String a = "device_type";
    private static final String b = "SettingContainerActivity";

    public void a() {
    }

    public void b() {
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C0784ee c0784ee = (C0784ee) getFragmentManager().findFragmentByTag(C0784ee.class.getName());
        C0596r.e(b, "setting fragment =" + c0784ee);
        if (c0784ee != null) {
            c0784ee.onActivityResult(i, i2, intent);
        }
    }

    protected void onCreate(Bundle bundle) {
        Fragment fragment;
        String str;
        int color;
        CharSequence charSequence;
        super.onCreate(bundle);
        setContentView((int) n.activity_settings_container);
        Resources resources = getResources();
        int intExtra = getIntent().getIntExtra(a, -1);
        String string;
        Fragment c0784ee;
        Object obj;
        if (intExtra == C0671aa.BRACELET.ordinal()) {
            string = resources.getString(r.mi_band);
            if (DeviceSource.hasBindBracelet()) {
                c0784ee = new C0784ee();
                String name = C0784ee.class.getName();
                if (a.c()) {
                    fragment = c0784ee;
                    str = name;
                    color = resources.getColor(i.bg_mode_step);
                    charSequence = string;
                } else {
                    fragment = c0784ee;
                    str = name;
                    color = resources.getColor(g.bg_color_grey);
                    obj = string;
                }
            } else {
                c0784ee = new A();
                fragment = c0784ee;
                str = A.class.getName();
                color = resources.getColor(g.bg_color_grey);
                obj = string;
            }
        } else if (intExtra == C0671aa.WEIGHT.ordinal()) {
            string = resources.getString(r.weight_scale);
            if (DeviceSource.hasBindWeight()) {
                c0784ee = new eD();
                fragment = c0784ee;
                str = eD.class.getName();
                color = resources.getColor(i.bg_mode_weight);
                obj = string;
            } else {
                c0784ee = new B();
                fragment = c0784ee;
                str = B.class.getName();
                color = resources.getColor(g.bg_color_grey);
                obj = string;
            }
        } else {
            finish();
            return;
        }
        ((TextView) findViewById(l.title)).setText(charSequence);
        findViewById(l.root_layout).setBackgroundColor(color);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.add(l.fragment_container, fragment, str);
        beginTransaction.commit();
    }
}
