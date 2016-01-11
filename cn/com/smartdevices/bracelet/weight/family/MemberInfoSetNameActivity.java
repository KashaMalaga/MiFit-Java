package cn.com.smartdevices.bracelet.weight.family;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.ui.widget.DimPanelBottomBar;
import com.huami.android.view.b;
import com.huami.android.widget.share.m;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.bt.profile.Weight.e;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;

public class MemberInfoSetNameActivity extends MemberInfoBaseActivity implements OnClickListener, OnGlobalLayoutListener {
    private View h;
    private DimPanelBottomBar i;
    private EditText j;
    private InputMethodManager k;
    private Context l = this;
    private TextPaint m;
    private LayoutParams n;
    private String o = a.f;
    private boolean p = false;

    public void c() {
        super.c();
    }

    public void d() {
        C0596r.e("MemberInfoBaseActivity", "set username " + this.o);
        if (!this.e) {
            super.d();
        }
        if (!this.e) {
            if (this.o == null || this.o.trim().isEmpty()) {
                b.a((Context) this, getResources().getString(r.please_input_name), 0).show();
                return;
            } else if (!Utils.g(this.o)) {
                b.a((Context) this, getResources().getString(r.invalid_name), 0).show();
                return;
            }
        }
        Keeper.saveCurrentUser(Keeper.CURRENT_USER_NAME, this.o.trim());
        Intent intent = new Intent();
        intent.setClass(this, MemberInfoSetGenderActivity.class);
        intent.putExtra(MemberInfoBaseActivity.c, this.e);
        intent.putExtra(MemberInfoBaseActivity.d, this.f);
        intent.putExtra("FROM_BABY_WEIGHT", this.p);
        intent.putExtra(e.d, this.g == null ? a.f : this.g.n());
        startActivityForResult(intent, 6);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        C0596r.e("MemberInfoBaseActivity", "isWeightChooseUser " + this.f + " isVisitorMode " + this.e);
        if (!(this.f || this.e || i2 != -1)) {
            b.a(this.l, getString(r.generate_user_succ), 0).show();
        }
        if (!this.f || !this.e) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == 0) {
            setResult(0);
            finish();
        } else {
            setResult(-1);
            finish();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        Keeper.saveCurrentUser(Keeper.CURRENT_USER_NAME, a.f);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = getIntent().getBooleanExtra(MemberInfoBaseActivity.c, false);
        this.f = getIntent().getBooleanExtra(MemberInfoBaseActivity.d, false);
        this.p = getIntent().getBooleanExtra("FROM_BABY_WEIGHT", false);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            this.g = e.b(getIntent().getStringExtra(e.d));
        }
        if (this.f && this.e) {
            Keeper.saveCurrentUser(Keeper.CURRENT_USER_NAME, a.f);
            d();
            return;
        }
        setContentView((int) n.activity_person_info_set_name);
        this.k = (InputMethodManager) this.l.getSystemService("input_method");
        b();
        this.j = (EditText) findViewById(l.info_name_edittext);
        this.o = Keeper.getCurrentUserInfoByTag(Keeper.CURRENT_USER_NAME);
        if (this.o != null) {
            this.j.setText(this.o);
        }
        this.m = this.j.getPaint();
        this.j.setFilters(new InputFilter[]{new LengthFilter(20)});
        this.j.addTextChangedListener(new d(this));
        this.i = (DimPanelBottomBar) findViewById(l.bottom_bar);
        this.n = new LayoutParams(-1, -2);
        this.n.addRule(12);
        this.h = findViewById(l.info_gender_bg);
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void onGlobalLayout() {
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.bottom - rect.top;
        int height = getWindow().getDecorView().getHeight();
        C0596r.e("MemberInfoBaseActivity", "rawHeight is " + height + " displayHeight is " + i);
        C0596r.e("MemberInfoBaseActivity", "is softInputActivt " + this.k.isActive());
        if (height - i > m.n) {
            this.n.bottomMargin = 0;
            this.i.setLayoutParams(this.n);
            return;
        }
        this.n.bottomMargin = Utils.a(this.l, 36.0f);
        this.i.setLayoutParams(this.n);
    }

    protected void onPause() {
        super.onPause();
        if (VERSION.SDK_INT >= 16) {
            getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        C0401a.b(C0401a.aM);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.a(C0401a.aM);
        C0401a.a((Activity) this);
    }
}
