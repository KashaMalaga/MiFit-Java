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
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.LinePieChartView;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.f.d;
import cn.com.smartdevices.bracelet.ui.HelpActivity;
import cn.com.smartdevices.bracelet.ui.MainUIActivity;
import cn.com.smartdevices.bracelet.ui.SearchSingleBraceletActivity;
import cn.com.smartdevices.bracelet.ui.SearchWeightScaleActivity;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import com.tencent.connect.common.Constants;
import com.xiaomi.hm.health.R;
import java.util.Locale;
import kankan.wheel.widget.a;

public class MultiDevicesErrActivity extends SystemBarTintActivity implements OnClickListener {
    private static final String a = "MultiBraceletErrActivity";
    private String b;
    private TextView c;
    private TextView d;
    private Button e;
    private Button f;
    private Context g = this;

    private boolean a() {
        return Utils.c.equals(this.b) || Utils.d.equals(this.b);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 6 && i2 == -1) {
            C0596r.e(a, "onActivityResult, result OK, finish");
            finish();
        }
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.donot_bind_txt:
                Keeper.keepNeedBind(0);
                intent.setClass(this, MainUIActivity.class);
                startActivity(intent);
                finish();
                if (Utils.b.equals(this.b)) {
                    C0401a.a((Context) this, C0409b.V, C0410c.n, Constants.VIA_SSO_LOGIN);
                } else {
                    C0401a.a((Context) this, C0409b.an, C0410c.n, Constants.VIA_SSO_LOGIN);
                    C0401a.a(this.g, C0401a.ga, C0401a.gd);
                }
                C0401a.a((Context) this, C0401a.dI);
                return;
            case R.id.buy_bracelet_stuff:
                d.a((Activity) this, false);
                C0401a.a(this.g, C0409b.ad);
                C0401a.a(getApplicationContext(), C0401a.be, C0401a.cd);
                return;
            case R.id.multi_devices_err_help_btn:
                intent = new Intent(this, HelpActivity.class);
                intent.putExtra(Utils.a, this.b);
                startActivity(intent);
                C0401a.a(this.g, C0401a.gb, C0401a.gd);
                return;
            case R.id.multi_devices_err_device_list_btn:
                intent.putExtra(a.bz, true);
                if (Utils.b.equals(this.b)) {
                    intent.setClass(this, SearchSingleBraceletActivity.class);
                    C0401a.a(this.g, C0409b.ac);
                } else if (Utils.c.equals(this.b)) {
                    intent.setClass(this, SearchWeightScaleActivity.class);
                }
                startActivityForResult(intent, 6);
                C0401a.a((Context) this, C0401a.dJ);
                return;
            case R.id.multi_devices_err_search_again:
                intent.setClass(this, SearchSingleBraceletActivity.class);
                intent.putExtra(a.bz, false);
                if (Utils.b.equals(this.b)) {
                    intent.setClass(this, SearchSingleBraceletActivity.class);
                    C0401a.a(this.g, C0409b.ab);
                } else if (a()) {
                    intent.setClass(this, SearchWeightScaleActivity.class);
                    C0401a.a(this.g, C0401a.fZ, C0401a.gd);
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
        setContentView((int) R.layout.multi_devices_err);
        Intent intent = getIntent();
        if (intent != null) {
            this.b = intent.getStringExtra(Utils.a);
            int intExtra = intent.getIntExtra(SearchSingleBraceletActivity.a, -1);
            C0596r.e(a, "infoResId " + intExtra);
            if (intExtra > 0) {
                ((TextView) findViewById(R.id.multi_devices_info)).setText(intExtra);
            }
        }
        LinePieChartView linePieChartView = (LinePieChartView) findViewById(R.id.searching_pie_chart);
        findViewById(R.id.multi_devices_err_search_again).setOnClickListener(this);
        this.e = (Button) findViewById(R.id.multi_devices_err_device_list_btn);
        this.e.setOnClickListener(this);
        this.f = (Button) findViewById(R.id.multi_devices_err_help_btn);
        this.f.setOnClickListener(this);
        View findViewById = findViewById(R.id.buy_bracelet_stuff);
        findViewById.setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.donot_bind_txt);
        textView.setText(Html.fromHtml("<u>" + getString(R.string.donot_bind) + "</u>"));
        textView.setOnClickListener(this);
        if (b.h().h.a.booleanValue()) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        this.c = (TextView) findViewById(R.id.multi_devices_err_title);
        this.d = (TextView) findViewById(R.id.multi_devices_info);
        if (Utils.b.equals(this.b)) {
            this.c.setText(R.string.multi_devices_title);
            this.d.setText(R.string.multi_devices_info);
            this.e.setText(R.string.look_device_list);
            linePieChartView.a(0);
            if (Locale.getDefault().toString().equals(Locale.SIMPLIFIED_CHINESE.toString())) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            this.f.setVisibility(8);
        } else if (a()) {
            this.c.setText(R.string.multi_devices_weight_title);
            this.d.setText(R.string.multi_weight_devices_info);
            this.e.setText(R.string.look_weight_device_list);
            this.e.setVisibility(8);
            linePieChartView.a(3);
            findViewById.setVisibility(8);
            this.f.setVisibility(0);
        }
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.v);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.a(C0401a.v);
        C0401a.a((Activity) this);
    }
}
