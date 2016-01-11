package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.Utils;
import com.xiaomi.hm.health.j;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import java.util.ArrayList;
import java.util.Iterator;
import kankan.wheel.widget.g;

public class HelpActivity extends SystemBarTintActivity implements OnClickListener {
    private String a;
    private TextView b;
    private int[] c = new int[]{r.help_title_0, r.help_info_0, r.help_title_1, r.help_info_1, r.help_title_2, r.help_info_2, r.help_title_3, r.help_info_3, r.help_title_4, r.help_info_4};
    private int[] d = new int[]{r.weight_help_title_0, r.weight_help_info_0, r.weight_help_title_1, r.weight_help_info_1, r.weight_help_title_2, r.weight_help_info_2, r.weight_help_title_3, r.weight_help_info_3, r.help_title_4, r.help_info_4, r.weight_help_title_4, r.weight_help_info_4};
    private int[] e = new int[]{r.weight_help_title_0, r.weight_help_info_0, r.weight_help_title_1, r.weight_help_info_1, r.weight_help_title_2, r.weight_help_info_2, r.weight_help_title_3, r.weight_help_info_3, r.help_title_4, r.help_info_4};
    private int[] f = new int[]{r.unlock_screen_help_title0, r.unlock_screen_help_info0, r.unlock_screen_help_title1, r.unlock_screen_help_info1, r.unlock_screen_help_title2, r.unlock_screen_help_info2, r.unlock_screen_help_title3, r.unlock_screen_help_info3};
    private ArrayList<C0700bb> g = new ArrayList();

    private void a() {
        LinearLayout linearLayout = (LinearLayout) findViewById(l.help_content_area);
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            C0700bb c0700bb = (C0700bb) it.next();
            if (c0700bb.a > 0) {
                View textView = new TextView(this);
                textView.setText(c0700bb.a);
                textView.setTextSize(0, (float) getResources().getDimensionPixelSize(j.click_button_text_size));
                textView.setTextColor(getResources().getColor(g.title_color));
                linearLayout.addView(textView);
            }
            if (c0700bb.b > 0) {
                textView = new TextView(this);
                textView.setText(c0700bb.b);
                textView.setTextSize(0, (float) getResources().getDimensionPixelSize(j.info_content_size));
                textView.setTextColor(getResources().getColor(g.content_color));
                textView.setPadding(0, 0, 0, getResources().getDimensionPixelOffset(j.help_title_margin));
                linearLayout.addView(textView);
            }
        }
    }

    private void a(int[] iArr) {
        int i = 0;
        while (i < iArr.length) {
            int i2 = iArr[i];
            i++;
            this.g.add(new C0700bb(this, i2, iArr[i]));
            i++;
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case l.help_back_txt /*2131297299*/:
                finish();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.help_activity);
        findViewById(l.help_back_txt).setOnClickListener(this);
        this.b = (TextView) findViewById(l.help_back_txt);
        int[] iArr = this.c;
        Intent intent = getIntent();
        if (intent != null) {
            this.a = intent.getStringExtra(Utils.a);
            if (Utils.c.equals(this.a)) {
                iArr = this.d;
            } else if (Utils.b.equals(this.a)) {
                iArr = this.c;
            } else if (Utils.e.equals(this.a)) {
                iArr = this.f;
                this.b.setText(r.unlock_screen_invalid_helper);
            } else if (Utils.d.equals(this.a)) {
                iArr = this.e;
            }
        }
        a(iArr);
        a();
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.fk);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.a(C0401a.fk);
        C0401a.a((Activity) this);
        if (Utils.c.equals(this.a)) {
            C0401a.a((Context) this, C0401a.u);
        } else if (Utils.b.equals(this.a)) {
            C0401a.a((Context) this, C0401a.u);
        } else if (Utils.e.equals(this.a)) {
            C0401a.a((Context) this, C0401a.T);
        }
    }
}
