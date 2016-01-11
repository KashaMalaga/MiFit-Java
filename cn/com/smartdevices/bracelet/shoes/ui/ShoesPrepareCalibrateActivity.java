package cn.com.smartdevices.bracelet.shoes.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.shoes.model.e;
import cn.com.smartdevices.bracelet.shoes.reflection.FwUpgradeManager;
import com.huami.android.ui.CustomActionBarActivity;
import com.huami.android.zxing.CaptureActivity;
import com.xiaomi.hm.health.c.g;
import com.xiaomi.hm.health.c.h;
import com.xiaomi.hm.health.c.i;
import com.xiaomi.hm.health.c.m;

public class ShoesPrepareCalibrateActivity extends CustomActionBarActivity implements OnClickListener {
    private ImageView a;
    private TextView b;
    private TextView c;
    private Button d;
    private View f;
    private boolean g = true;

    public ShoesPrepareCalibrateActivity() {
        super(C0401a.bX, C0401a.as);
    }

    public static Intent a(Context context, e eVar, boolean z) {
        Intent intent = new Intent(context, ShoesPrepareCalibrateActivity.class);
        intent.putExtra(CaptureActivity.l, eVar);
        intent.putExtra(ShoesCalibrateActivity.a, z);
        return intent;
    }

    private void d() {
        this.g = getIntent().getBooleanExtra(ShoesCalibrateActivity.a, true);
        if (this.g) {
            getActionBar().setDisplayHomeAsUpEnabled(false);
        }
        c(getResources().getColor(com.xiaomi.hm.health.c.e.font_color_c7_v2));
        this.c = (TextView) findViewById(h.shoes_calibrate_instruction);
        this.a = (ImageView) findViewById(h.shoes_calibrate_illustration);
        this.b = (TextView) findViewById(h.shoes_calibrate_suggestion);
        this.d = (Button) findViewById(h.shoes_start_calibrate_btn);
        this.f = findViewById(h.shoes_calibrate_connecting);
        this.c.setText(m.shoes_calibrate_prepare_instruction);
        this.a.setImageResource(g.shoes_prepare_calibrate_illustration);
        this.b.setVisibility(8);
        this.d.setVisibility(0);
        this.d.setText(getResources().getString(m.shoes_put_done));
        this.f.setVisibility(8);
        findViewById(h.shoes_start_calibrate_btn).setOnClickListener(this);
    }

    protected String b() {
        return getResources().getString(m.shoes_static_calibrate);
    }

    protected String g_() {
        return getResources().getString(m.shoes_skip);
    }

    protected void h_() {
        FwUpgradeManager.setUpgradeState(this, true);
        finish();
    }

    public void onClick(View view) {
        Intent intent = getIntent();
        intent.setClass(this, ShoesCalibrateActivity.class);
        startActivity(intent);
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.activity_shoes_calibrate);
        d();
        FwUpgradeManager.setUpgradeState(this, false);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        if (!this.g) {
            menu.removeItem(h.custom_action_bar_menu);
        }
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.g) {
            return super.onKeyDown(i, keyEvent);
        }
        FwUpgradeManager.setUpgradeState(this, true);
        return true;
    }

    protected void onPause() {
        super.onPause();
    }
}
