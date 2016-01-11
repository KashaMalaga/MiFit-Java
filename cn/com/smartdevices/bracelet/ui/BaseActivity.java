package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.aC;
import android.support.v4.app.cp;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.HomeKeyReceiver;
import cn.com.smartdevices.bracelet.chart.util.t;
import cn.com.smartdevices.bracelet.config.b;
import com.xiaomi.hm.health.l;

public abstract class BaseActivity extends Activity {
    public static final int MI_NOTE_APP_DPI = 480;
    public static final int MI_NOTE_ORIGINAL_DPI = 440;
    protected TextView mHomeBack;
    private HomeKeyReceiver mHomeKeyReceiver;

    private void initHomeBack() {
        this.mHomeBack = (TextView) findViewById(l.home_back);
        if (this.mHomeBack != null) {
            this.mHomeBack.setOnClickListener(new C0815o(this));
            if (t.a() && !isExceptForMiNote()) {
                this.mHomeBack.setTextSize(14.0f);
            }
        }
    }

    public void finish() {
        Intent b = aC.b(this);
        if (b == null || !aC.a((Activity) this, b)) {
            super.finish();
        } else {
            cp.a((Context) this).b(b).b();
        }
    }

    protected boolean isExceptForMiNote() {
        return false;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (t.d(this)) {
            if (isExceptForMiNote()) {
                t.a((Context) this, (int) MI_NOTE_ORIGINAL_DPI);
            } else {
                t.a((Context) this, (int) MI_NOTE_APP_DPI);
            }
        }
        IntentFilter intentFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        this.mHomeKeyReceiver = new HomeKeyReceiver();
        registerReceiver(this.mHomeKeyReceiver, intentFilter);
    }

    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.mHomeKeyReceiver);
    }

    protected void onHomeBackPressed() {
        finish();
    }

    protected void onNewIntent(Intent intent) {
        if (b.h().c.d.booleanValue()) {
            BindQQHealthActivity.a((Activity) this, intent);
        }
    }

    protected void onResume() {
        super.onResume();
        if (b.h().c.d.booleanValue()) {
            BindQQHealthActivity.a((Activity) this, getIntent());
            BindQQHealthActivity.a((Activity) this);
        }
    }

    public void setContentView(int i) {
        super.setContentView(i);
        initHomeBack();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        initHomeBack();
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        initHomeBack();
    }

    protected void updateTitle(int i) {
        this.mHomeBack.setText(i);
    }

    protected void updateTitle(String str) {
        this.mHomeBack.setText(str);
    }
}
