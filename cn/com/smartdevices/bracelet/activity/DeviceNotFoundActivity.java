package cn.com.smartdevices.bracelet.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.LinePieChartView;
import cn.com.smartdevices.bracelet.ui.HelpActivity;
import cn.com.smartdevices.bracelet.ui.MainUIActivity;
import cn.com.smartdevices.bracelet.ui.SearchSingleBraceletActivity;
import cn.com.smartdevices.bracelet.ui.SearchWeightScaleActivity;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import com.huami.android.view.b;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;

public class DeviceNotFoundActivity extends SystemBarTintActivity implements OnClickListener {
    private String a;
    private Context b = this;

    private boolean a() {
        return Utils.c.equals(this.a) || Utils.d.equals(this.a);
    }

    public void onBackPressed() {
        b.a((Context) this, (int) r.search_again, 0).show();
        setResult(0);
        finish();
    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case l.donot_bind_txt /*2131296910*/:
                Keeper.keepNeedBind(0);
                startActivity(new Intent(this, MainUIActivity.class));
                finish();
                C0401a.a(this.b, C0401a.ga, C0401a.gc);
                return;
            case l.bracelet_not_found_get_help /*2131296911*/:
                intent = new Intent(this, HelpActivity.class);
                intent.putExtra(Utils.a, this.a);
                startActivity(intent);
                C0401a.a(this.b, C0401a.gb, C0401a.gc);
                return;
            case l.bracelet_not_found_search_again /*2131296912*/:
                intent = new Intent(this, SearchSingleBraceletActivity.class);
                if (Utils.b.equals(this.a)) {
                    intent.setClass(this, SearchSingleBraceletActivity.class);
                } else if (a()) {
                    intent.setClass(this, SearchWeightScaleActivity.class);
                    C0401a.a(this.b, C0401a.fZ, C0401a.gc);
                }
                startActivity(intent);
                finish();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.bracelet_not_found);
        ((Button) findViewById(l.bracelet_not_found_search_again)).setOnClickListener(this);
        findViewById(l.bracelet_not_found_get_help).setOnClickListener(this);
        TextView textView = (TextView) findViewById(l.donot_bind_txt);
        textView.setText(Html.fromHtml("<u>" + getString(r.donot_bind) + "</u>"));
        textView.setOnClickListener(this);
        textView = (TextView) findViewById(l.multi_devices_err_title);
        TextView textView2 = (TextView) findViewById(l.bracelet_not_found_info);
        LinePieChartView linePieChartView = (LinePieChartView) findViewById(l.searching_pie_chart);
        Intent intent = getIntent();
        if (intent != null) {
            this.a = intent.getStringExtra(Utils.a);
            if (a()) {
                textView.setText(r.weight_not_found_title);
                textView2.setText(r.weight_not_found_info);
                linePieChartView.a(3);
            } else if (Utils.b.equals(this.a)) {
                textView.setText(r.bracelet_not_found_title);
                textView2.setText(r.bracelet_not_found_info);
                linePieChartView.a(0);
            }
        }
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.s);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.a(C0401a.s);
        C0401a.a((Activity) this);
    }
}
