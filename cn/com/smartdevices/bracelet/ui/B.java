package cn.com.smartdevices.bracelet.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout;
import com.xiaomi.hm.health.R;

public class B extends p implements OnClickListener {
    private static final String b = "BindDevicesWeightFragment";
    private static final int c = 256;
    private SlidingUpPanelLayout d;

    private void d() {
        fg a = new fe(getActivity()).a();
        if (a.d()) {
            int e = a.e();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.main_ui_panel_height);
            C0596r.e(b, "SlidingPanel SystemBarH : " + e + ", OriginalPanelH : " + dimensionPixelSize);
            this.d.setPanelHeight(dimensionPixelSize - e);
        }
    }

    public void c() {
        C0596r.e(b, "On start bind clicked!!");
        startActivityForResult(new Intent(getActivity(), SearchWeightScaleActivity.class), c);
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
            case R.id.about_mi_band:
                C0401a.a(getActivity().getApplicationContext(), C0401a.gp);
                Utils.a("http://s1.mi.com/m/product/scale/", (int) R.string.bracelet_store_desc, getActivity());
                return;
            case R.id.start_bind:
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
        View inflate = layoutInflater.inflate(R.layout.activity_bind_devices_weight, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.about_mi_band)).setText(Html.fromHtml(getString(R.string.bind_mi_weight_about)));
        inflate.findViewById(R.id.about_mi_band).setOnClickListener(this);
        inflate.findViewById(R.id.start_bind).setOnClickListener(this);
        this.d = (SlidingUpPanelLayout) inflate.findViewById(R.id.fragment_setting_sliding_layout);
        this.d.setSlidingEnabled(false);
        d();
        return inflate;
    }
}
