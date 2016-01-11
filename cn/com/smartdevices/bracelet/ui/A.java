package cn.com.smartdevices.bracelet.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.f.d;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout;
import com.xiaomi.hm.health.j;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;

public class A extends p implements OnClickListener {
    private static final String b = "BindDevicesBandFragment";
    private static final int c = 257;
    private TextView d;
    private SlidingUpPanelLayout e;

    private void d() {
        fg a = new fe(getActivity()).a();
        if (a.d()) {
            int e = a.e();
            int dimensionPixelSize = getResources().getDimensionPixelSize(j.main_ui_panel_height);
            C0596r.e(b, "SlidingPanel SystemBarH : " + e + ", OriginalPanelH : " + dimensionPixelSize);
            this.e.setPanelHeight(dimensionPixelSize - e);
        }
    }

    public void c() {
        C0596r.e(b, "On start bind clicked!!");
        startActivityForResult(new Intent(getActivity(), SearchSingleBraceletActivity.class), c);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        C0596r.e(b, "onActivityResult requestCode = " + i + ", resultCode " + i2);
        if (i == c && i2 == -1 && getActivity() != null) {
            getActivity().finish();
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case l.about_mi_band /*2131296337*/:
                d.a(getActivity(), true);
                return;
            case l.start_bind /*2131296338*/:
                c();
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(n.activity_bind_devices_band, viewGroup, false);
        this.d = (TextView) inflate.findViewById(l.about_mi_band);
        this.d.setText(Html.fromHtml(getString(r.bind_mi_band_about)));
        this.d.setOnClickListener(this);
        inflate.findViewById(l.start_bind).setOnClickListener(this);
        this.e = (SlidingUpPanelLayout) inflate.findViewById(l.fragment_setting_sliding_layout);
        this.e.setSlidingEnabled(false);
        d();
        if (b.h().w.booleanValue()) {
            this.d.setVisibility(4);
        }
        return inflate;
    }
}
