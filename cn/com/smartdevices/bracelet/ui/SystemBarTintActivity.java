package cn.com.smartdevices.bracelet.ui;

import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import cn.com.smartdevices.bracelet.C0667t;
import com.huami.android.ui.a;
import com.xiaomi.hm.health.s;

public class SystemBarTintActivity extends BaseActivity {
    private View mContentView;
    private boolean mDisableStatusBarTintAuto;
    private fe mSystemBarTintManager;

    public void applyStatusBarTint(int i) {
        if (!a.b(this)) {
            return;
        }
        if (VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(i);
            if (C0667t.b(this)) {
                i = Color.rgb((int) (((double) Color.red(i)) * 0.75d), (int) (((double) Color.green(i)) * 0.75d), (int) (((double) Color.blue(i)) * 0.75d));
            }
            getWindow().setStatusBarColor(i);
            return;
        }
        this.mSystemBarTintManager.a(i);
    }

    public void applyStatusBarTintAuto() {
        if (a.b(this) && this.mContentView != null) {
            this.mContentView.post(new fd(this));
        }
    }

    public void applyStatusBarTintRes(int i) {
        applyStatusBarTint(getResources().getColor(i));
    }

    public void applyStatusBarTintResDrawable(int i) {
        if (!a.b(this)) {
            return;
        }
        if (VERSION.SDK_INT >= 21) {
            this.mDisableStatusBarTintAuto = false;
            applyStatusBarTintAuto();
            return;
        }
        this.mSystemBarTintManager.b(i);
    }

    public void configStatusBarTint() {
        if (a.b(this)) {
            this.mContentView = findViewById(16908290);
            this.mSystemBarTintManager = new fe(this);
            if (VERSION.SDK_INT < 21) {
                this.mSystemBarTintManager.a(true);
            }
        }
    }

    public void disableAutoApplyStatusBarTint() {
        this.mDisableStatusBarTintAuto = true;
    }

    public int getStatusBarHeight() {
        if (this.mSystemBarTintManager == null) {
            return 0;
        }
        fg a = this.mSystemBarTintManager.a();
        return a != null ? a.b() : 0;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (a.b(this) && VERSION.SDK_INT <= 19) {
            setTheme(s.AppThemeTint);
        }
        configStatusBarTint();
        applyStatusBarTintAuto();
    }
}
