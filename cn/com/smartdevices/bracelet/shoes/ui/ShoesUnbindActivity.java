package cn.com.smartdevices.bracelet.shoes.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.model.e;
import com.huami.android.ui.CustomActionBarActivity;
import com.huami.android.view.b;
import com.huami.android.zxing.CaptureActivity;
import com.xiaomi.hm.health.c.g;
import com.xiaomi.hm.health.c.h;
import com.xiaomi.hm.health.c.i;
import com.xiaomi.hm.health.c.m;

public class ShoesUnbindActivity extends CustomActionBarActivity implements OnClickListener {
    private e a = null;

    public ShoesUnbindActivity() {
        super(C0401a.bY, C0401a.at);
    }

    public void onClick(View view) {
        if (view.getId() == h.shoes_unbind_btn) {
            t.m(getApplicationContext(), this.a.e());
            b.a((Context) this, getResources().getString(m.shoes_unbind_success), 1).show();
            setResult(-1);
        }
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.activity_shoes_unbind);
        c(getResources().getColor(com.xiaomi.hm.health.c.e.shoes_gray_bg));
        this.a = (e) getIntent().getSerializableExtra(CaptureActivity.l);
        if (this.a == null) {
            finish();
            return;
        }
        ((ImageView) findViewById(h.shoes_unbind_icon)).setImageDrawable(getResources().getDrawable(g.shoes_lining_guangsu_unbind));
        a(getResources().getString(m.shoes_smart_shoes, new Object[]{this.a.h()}));
        findViewById(h.shoes_unbind_btn).setOnClickListener(this);
        findViewById(h.shoes_cancel_btn).setOnClickListener(this);
    }
}
