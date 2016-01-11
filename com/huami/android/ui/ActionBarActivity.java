package com.huami.android.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.aC;
import android.support.v4.app.cp;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import cn.com.smartdevices.bracelet.C0401a;
import com.xiaomi.hm.health.a.c;

public class ActionBarActivity extends Activity implements OnGlobalLayoutListener, OnPreDrawListener {
    private FrameLayout a;
    private ViewGroup b;
    private View c;
    private final String d;
    private final String e;
    private boolean f = false;

    public ActionBarActivity(String str, String str2) {
        this.d = str;
        this.e = str2;
    }

    private boolean b() {
        ViewGroup viewGroup = (ViewGroup) this.b.getRootView();
        viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.f || this.c == null) {
            return true;
        }
        String simpleName = getClass().getSimpleName();
        Rect rect = new Rect();
        viewGroup.getWindowVisibleDisplayFrame(rect);
        if (rect.top > 0 && this.c.getParent() == null) {
            Log.d(simpleName, rect.toString());
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, rect.top);
            layoutParams.gravity |= 48;
            this.c.setVisibility(0);
            this.a.addView(this.c, layoutParams);
        }
        return false;
    }

    public void a() {
        finish();
    }

    public void c(int i) {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            Drawable colorDrawable = new ColorDrawable(i);
            getWindow().setBackgroundDrawable(colorDrawable);
            actionBar.setBackgroundDrawable(colorDrawable);
        }
        this.c.setBackgroundColor(i);
    }

    public void e() {
        this.f = true;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = (ViewGroup) getWindow().getDecorView();
        this.a = (FrameLayout) this.b.findViewById(16908290);
        if (!this.f) {
            ActionBar actionBar = getActionBar();
            this.c = new View(this);
            if (actionBar != null) {
                Drawable drawable = getResources().getDrawable(c.bg_color_blue);
                actionBar.setDisplayShowHomeEnabled(false);
                actionBar.setDisplayHomeAsUpEnabled(true);
                this.c.setBackgroundResource(c.bg_color_blue);
                actionBar.setBackgroundDrawable(drawable);
            }
        }
        ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
        viewTreeObserver.addOnPreDrawListener(this);
        viewTreeObserver.addOnGlobalLayoutListener(this);
        C0401a.a((Context) this, this.d);
    }

    public void onGlobalLayout() {
        b();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                Intent b = aC.b(this);
                if (b == null || !aC.a((Activity) this, b)) {
                    a();
                } else {
                    cp.a((Context) this).b(b).b();
                }
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    protected void onPause() {
        super.onPause();
        C0401a.a((Activity) this);
        C0401a.a(this.e);
    }

    public boolean onPreDraw() {
        return b();
    }

    protected void onResume() {
        super.onResume();
        C0401a.a((Activity) this);
        C0401a.a(this.e);
    }
}
