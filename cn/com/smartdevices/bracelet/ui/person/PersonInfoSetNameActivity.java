package cn.com.smartdevices.bracelet.ui.person;

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
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.ui.widget.DimPanelBottomBar;
import com.huami.android.view.b;
import com.huami.android.widget.share.m;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;

public class PersonInfoSetNameActivity extends PersonInfoBaseActivity implements OnClickListener, OnGlobalLayoutListener {
    private static final String c = PersonInfoSetNameActivity.class.getSimpleName();
    private View d;
    private DimPanelBottomBar e;
    private EditText f;
    private TextView g;
    private InputMethodManager h;
    private Context i = this;
    private TextPaint j;
    private LayoutParams k;
    private String l = a.f;

    public void b() {
        super.b();
    }

    public void c() {
        C0596r.e(c, "set username " + this.l);
        this.a.nickname = this.l;
        super.c();
        if (this.a.nickname.isEmpty()) {
            b.a((Context) this, (int) R.string.please_input_name, 0).show();
        } else if (Utils.g(this.a.nickname)) {
            Intent intent = new Intent();
            intent.setClass(this, PersonInfoSetGenderActivity.class);
            startActivityForResult(intent, 6);
        } else {
            b.a((Context) this, (int) R.string.invalid_name, 0).show();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_person_info_set_name);
        this.h = (InputMethodManager) this.i.getSystemService("input_method");
        a();
        this.f = (EditText) findViewById(R.id.info_name_edittext);
        this.l = this.a.nickname;
        if (!(this.l == null || this.l.equals(this.a.uid + a.f))) {
            this.f.setText(this.l);
        }
        this.g = (TextView) findViewById(R.id.bracelet_login_title_info);
        if (getString(R.string.input_person_name) != null) {
            this.g.setText(getString(R.string.input_person_name));
        }
        this.j = this.f.getPaint();
        this.f.setFilters(new InputFilter[]{new LengthFilter(20)});
        this.f.addTextChangedListener(new e(this));
        this.e = (DimPanelBottomBar) findViewById(R.id.bottom_bar);
        this.k = new LayoutParams(-1, -2);
        this.k.addRule(12);
        this.d = findViewById(R.id.info_gender_bg);
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public void onGlobalLayout() {
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.bottom - rect.top;
        int height = getWindow().getDecorView().getHeight();
        C0596r.e(c, "rawHeight is " + height + " displayHeight is " + i);
        C0596r.e(c, "is softInputActivt " + this.h.isActive());
        if (height - i > m.n) {
            this.k.bottomMargin = 0;
            this.e.setLayoutParams(this.k);
            return;
        }
        this.k.bottomMargin = Utils.a(this.i, 36.0f);
        this.e.setLayoutParams(this.k);
    }

    protected void onPause() {
        super.onPause();
        if (VERSION.SDK_INT >= 16) {
            getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    protected void onResume() {
        super.onResume();
    }
}
