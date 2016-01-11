package cn.com.smartdevices.bracelet.heartrate;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.Keeper;
import com.huami.android.ui.CustomActionBarActivity;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.e;
import com.xiaomi.hm.health.i;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;

public class HeartRateGuideActivity extends CustomActionBarActivity implements OnClickListener {
    private static final String a = "HeartRateMainActivity";
    private TextView b;
    private CountDownTimer c;

    public HeartRateGuideActivity() {
        super(a.f, a.f);
    }

    protected String b() {
        return getResources().getString(r.heartrate);
    }

    public void d() {
        setResult(-1);
        finish();
        overridePendingTransition(0, e.hr_guide_out);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case l.bt_measure /*2131296415*/:
                C0401a.a((Context) this, C0401a.gY);
                this.c.cancel();
                Keeper.setHRIfDirection(true);
                d();
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.activity_heart_guide);
        c(getResources().getColor(i.bg_mode_heartrate));
        C0401a.a((Context) this, C0401a.gX);
        getActionBar().setDisplayHomeAsUpEnabled(false);
        this.b = (TextView) findViewById(l.time);
        findViewById(l.bt_measure).setOnClickListener(this);
        this.c = new g(this, 6000, 1000);
        this.c.start();
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
