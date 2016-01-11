package com.huami.android.ui;

import android.app.ActionBar;
import android.app.ActionBar.LayoutParams;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.hm.health.a.f;
import com.xiaomi.hm.health.a.g;

public class CustomActionBarActivity extends ActionBarActivity {
    private ActionBar a = null;
    private final View b = null;
    protected TextView e = null;

    public CustomActionBarActivity(String str, String str2) {
        super(str, str2);
    }

    private void d() {
        this.a = getActionBar();
        if (this.a != null) {
            this.a.setDisplayShowCustomEnabled(true);
            this.a.setDisplayShowHomeEnabled(false);
            this.a.setDisplayHomeAsUpEnabled(true);
            this.a.setDisplayShowTitleEnabled(false);
            this.a.setDisplayUseLogoEnabled(false);
            f();
        }
    }

    private void f() {
        RelativeLayout relativeLayout = (RelativeLayout) getLayoutInflater().inflate(g.title_bar, null);
        this.e = (TextView) relativeLayout.findViewById(f.title);
        CharSequence b = b();
        if (b != null) {
            this.e.setText(b);
        }
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.a.setCustomView(relativeLayout, layoutParams);
    }

    protected void a(OnClickListener onClickListener) {
        if (this.b != null) {
            this.b.setOnClickListener(onClickListener);
        }
    }

    public void a(String str) {
        if (this.e != null) {
            this.e.setVisibility(0);
            this.e.setText(str);
        }
    }

    protected String b() {
        return null;
    }

    public void b(int i) {
        if (this.e != null) {
            this.e.setText(getResources().getString(i));
        }
    }

    protected String g_() {
        return null;
    }

    protected void h_() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, f.custom_action_bar_menu, 0, g_()).setShowAsAction(2);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        if (menuItem.getGroupId() == 0 && menuItem.getItemId() == f.custom_action_bar_menu) {
            h_();
        }
        return true;
    }
}
