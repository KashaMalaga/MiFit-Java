package cn.com.smartdevices.bracelet.shoes.ui;

import android.bluetooth.BluetoothAdapter;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.model.d;
import cn.com.smartdevices.bracelet.shoes.model.e;
import com.huami.android.ui.CustomActionBarActivity;
import com.huami.android.widget.f;
import com.huami.android.zxing.CaptureActivity;
import com.tencent.connect.common.Constants;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.c.h;
import com.xiaomi.hm.health.c.i;
import com.xiaomi.hm.health.c.m;
import kankan.wheel.widget.a.b;

public class ShoesIntroActivity extends CustomActionBarActivity implements OnClickListener {
    private static final String a = "ShoesUI";
    private static final int b = 0;
    private static final int c = 1;
    private e d = null;
    private Context f;

    public ShoesIntroActivity() {
        super(C0401a.bV, C0401a.aq);
    }

    private String a(String str, int i) {
        for (e eVar : t.d(this)) {
            if (eVar.e.equals(str) && eVar.f == i) {
                return eVar.d();
            }
        }
        return a.f;
    }

    private void d() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            if (defaultAdapter.isEnabled()) {
                f();
            } else {
                startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), b);
            }
        }
    }

    private void f() {
        startActivity(ShoesBindActivity.a((Context) this, this.d));
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 0) {
            if (i == c) {
                switch (i2) {
                    case b.a /*-1*/:
                        f();
                        break;
                    default:
                        break;
                }
            }
        }
        switch (i2) {
            case b.a /*-1*/:
                f();
                break;
            case b /*0*/:
                try {
                    startActivityForResult(new Intent("cn.com.smartdevices.bracelet.intent.action.ENABLE_BLUETOOTH"), c);
                    break;
                } catch (ActivityNotFoundException e) {
                    C0596r.e(a, "EnableBluetoothActivity not found, may be the module is running alone");
                    break;
                }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == h.shoes_bind_btn) {
            if (d.k.equals(this.d.e)) {
                if (this.d.f == c) {
                    C0401a.a(this.f, C0409b.bu, C0410c.t, Constants.VIA_RESULT_SUCCESS);
                } else if (this.d.f == 2) {
                    C0401a.a(this.f, C0409b.bu, C0410c.t, Constants.VIA_TO_TYPE_QQ_GROUP);
                }
            }
            cn.com.smartdevices.bracelet.shoes.model.a e = t.e(this);
            if (e != null) {
                C0596r.d(a, "bind info found");
                com.huami.android.widget.a aVar = new com.huami.android.widget.a();
                Bundle bundle = new Bundle();
                String a = a(e.c(), e.o());
                String d = this.d.d();
                bundle.putString(f.a, getResources().getString(m.shoes_bind_change_text, new Object[]{a, d}));
                bundle.putString(com.huami.android.widget.a.d, getResources().getString(m.shoes_cancel));
                bundle.putString(com.huami.android.widget.a.e, getResources().getString(m.shoes_bind_change_ok));
                aVar.setArguments(bundle);
                aVar.a(new O(this));
                aVar.show(getFragmentManager(), a);
                return;
            }
            C0596r.d(a, "no bind info found");
            d();
        } else if (id == h.shoes_buy_btn) {
            if (d.k.equals(this.d.e)) {
                if (this.d.f == c) {
                    C0401a.a(this.f, C0409b.bv, C0410c.t, Constants.VIA_RESULT_SUCCESS);
                } else if (this.d.f == 2) {
                    C0401a.a(this.f, C0409b.bv, C0410c.t, Constants.VIA_TO_TYPE_QQ_GROUP);
                }
            }
            if (!TextUtils.isEmpty(this.d.d)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.d.d));
                intent.addCategory("android.intent.category.BROWSABLE");
                startActivity(intent);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.activity_shoes_intro);
        this.f = getApplicationContext();
        c(getResources().getColor(com.xiaomi.hm.health.c.e.font_color_c7_v2));
        this.d = (e) getIntent().getSerializableExtra(CaptureActivity.l);
        if (this.d == null) {
            finish();
            return;
        }
        ((ImageView) findViewById(h.shoes_organization_logo)).setVisibility(b);
        TextView textView = (TextView) findViewById(h.shoes_brand_name);
        textView.setVisibility(8);
        TextView textView2 = (TextView) findViewById(h.shoes_description);
        CharSequence d = this.d.d();
        if (TextUtils.isEmpty(d)) {
            d = this.d.h();
        }
        textView.setText(d);
        textView2.setText(this.d.g);
        Resources resources = getResources();
        int i = m.shoes_smart_shoes;
        Object[] objArr = new Object[c];
        objArr[b] = d;
        a(resources.getString(i, objArr));
        findViewById(h.shoes_bind_btn).setOnClickListener(this);
        findViewById(h.shoes_buy_btn).setOnClickListener(this);
    }
}
