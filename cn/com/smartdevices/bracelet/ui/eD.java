package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.LinePieChartView;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.eventbus.EventBtOnOff;
import cn.com.smartdevices.bracelet.eventbus.EventWeightLowBattery;
import cn.com.smartdevices.bracelet.eventbus.weight.EventScaleStatus;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout.PanelSlideListener;
import cn.com.smartdevices.bracelet.weight.BabyWeightActivity;
import com.tencent.connect.common.Constants;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.bleservice.a;
import com.xiaomi.hm.health.bt.model.i;
import com.xiaomi.hm.health.bt.profile.Weight.WeightHwInfo;
import com.xiaomi.hm.health.bt.profile.Weight.f;
import de.greenrobot.event.EventBus;
import kankan.wheel.widget.a.b;

public class eD extends p implements OnClickListener {
    private static final String c = "SettingWeightFragment";
    private static final int d = 257;
    private static final int o = 8193;
    WeightHwInfo b;
    private TextView e;
    private TextView f = null;
    private View g;
    private SlidingUpPanelLayout h;
    private TextView i;
    private LinePieChartView j = null;
    private ImageView k;
    private TextView l;
    private PanelSlideListener m = new eE(this);
    private boolean n = false;
    private boolean p;

    private void a(float f) {
        if (f >= 0.0f && f <= 1.0f) {
        }
    }

    private void a(View view) {
        this.h = (SlidingUpPanelLayout) view.findViewById(R.id.fragment_setting_sliding_layout);
        this.h.setOverlayed(true);
        this.h.setEnableDragViewTouchEvents(true);
        this.h.setPanelSlideListener(this.m);
        this.h.setSlidingEnabled(true);
        d();
        this.e = (TextView) view.findViewById(R.id.device_firmware_version_text);
        this.f = (TextView) view.findViewById(R.id.mili_rebind_tips);
        this.i = (TextView) view.findViewById(R.id.weight_settings_merge_state);
        e();
        view.findViewById(R.id.device_unbind).setOnClickListener(this);
        view.findViewById(R.id.device_firmware_version).setOnClickListener(this);
        view.findViewById(R.id.device_unbind_in_mask).setOnClickListener(this);
        this.g = view.findViewById(R.id.mask_view);
        this.j = (LinePieChartView) view.findViewById(R.id.weight_battery_pie_chart);
        this.k = (ImageView) view.findViewById(R.id.weight_device_battery_low_power);
        this.l = (TextView) view.findViewById(R.id.weight_device_battery_tips);
        view.findViewById(R.id.weight_setting_babyweight).setOnClickListener(this);
        view.findViewById(R.id.weight_settings_about).setOnClickListener(this);
        view.findViewById(R.id.weight_settings_merge_ll).setOnClickListener(this);
        if (DeviceSource.hasBindWeight()) {
            this.f.setText(R.string.unbind);
        } else {
            this.f.setText(R.string.bind_weight_scale);
        }
    }

    public static eD c() {
        eD eDVar = new eD();
        eDVar.setArguments(new Bundle());
        return eDVar;
    }

    private void d() {
        fg a = new fe(getActivity()).a();
        if (a.d()) {
            int e = a.e();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.main_ui_panel_height);
            C0596r.e(c, "SlidingPanel SystemBarH : " + e + ", OriginalPanelH : " + dimensionPixelSize);
            this.h.setPanelHeight(dimensionPixelSize - e);
        }
    }

    private void e() {
        if (Keeper.readPersonInfo().getMiliConfig().getWeightMergeResult()) {
            this.i.setText(R.string.state_open);
        } else {
            this.i.setText(R.string.state_close);
        }
    }

    private void f() {
        this.k.setVisibility(0);
        this.l.setVisibility(0);
    }

    private void g() {
        Intent intent = new Intent(getActivity(), UnBindActivity.class);
        intent.putExtra(Constants.VIA_RESULT_SUCCESS, Utils.c);
        startActivityForResult(intent, d);
    }

    private void h() {
        C0596r.e(c, "enableUI");
        this.g.setVisibility(4);
        this.f.setVisibility(0);
    }

    private void i() {
        j();
    }

    private void j() {
        f i = a.i();
        if (i == null || !i.u()) {
            this.e.setText(this.b.fwVersion);
            return;
        }
        i z = i.z();
        if (z == null || z.c == null) {
            this.e.setText(this.b.fwVersion);
        } else {
            this.e.setText(z.c);
        }
    }

    private void k() {
        Intent intent = new Intent(getActivity(), BabyWeightActivity.class);
        intent.putExtra("CONNECTION_FAIL", this.n);
        startActivity(intent);
    }

    public boolean a(boolean z) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || defaultAdapter.isEnabled()) {
            return true;
        }
        if (!z) {
            return false;
        }
        if (a.l()) {
            return true;
        }
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), o);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C0596r.e(c, "onActivityResult: " + i + " result:" + i2);
        if (i == d && i2 == -1 && getActivity() != null) {
            Activity activity = getActivity();
            if (activity == null) {
                return;
            }
            if (activity instanceof SettingContainerActivity) {
                ((SettingContainerActivity) activity).b();
            } else if (activity instanceof SettingActivity) {
                ((SettingActivity) activity).b();
            }
        } else if (i == o) {
            switch (i2) {
                case b.a /*-1*/:
                    k();
                    return;
                case kankan.wheel.widget.a.i /*0*/:
                    com.huami.android.view.b.a(getActivity().getApplicationContext(), getString(R.string.failed_enable_bt), 1).show();
                    return;
                default:
                    return;
            }
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.weight_settings_merge_ll:
                startActivity(new Intent(getActivity(), SettingMergeDuplicateActivity.class));
                return;
            case R.id.weight_settings_about:
                startActivity(new Intent(getActivity(), InstructionWeightActivity.class));
                C0401a.a(getActivity().getApplicationContext(), C0401a.fS);
                return;
            case R.id.device_unbind:
                if (DeviceSource.hasBindWeight()) {
                    g();
                    return;
                }
                C0401a.a(getActivity().getApplicationContext(), C0401a.fN);
                startActivity(new Intent(getActivity(), SearchWeightScaleActivity.class));
                getActivity().finish();
                return;
            case R.id.device_firmware_version:
                com.huami.android.view.b.a(getActivity(), getActivity().getString(R.string.bracelet_info_mac_address, new Object[]{this.b.name, this.b.address}), 1).show();
                return;
            case R.id.device_unbind_in_mask:
                if (Utils.e()) {
                    g();
                    C0401a.a(getActivity().getApplicationContext(), C0401a.fT);
                    return;
                }
                return;
            case R.id.weight_setting_babyweight:
                C0596r.e(c, "click " + this.p);
                if (this.p) {
                    a(true);
                    return;
                } else {
                    k();
                    return;
                }
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = Keeper.readWeightHwInfo();
        EventBus.getDefault().register(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.setting_weight_fragment, viewGroup, false);
        a(inflate);
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onDestroyView() {
        super.onDestroyView();
        C0596r.e(c, "onDestroyView");
    }

    public void onEvent(EventBtOnOff eventBtOnOff) {
        C0596r.e(c, "onBtOnOff:" + eventBtOnOff.type);
        if (eventBtOnOff.type == 1) {
            this.p = true;
        } else if (eventBtOnOff.type == 0) {
            this.p = false;
        }
        C0596r.e(c, "mBluetooth is " + this.p);
    }

    public void onEvent(EventWeightLowBattery eventWeightLowBattery) {
        C0596r.e(c, " EventWeightLowBattery() update drag view ");
    }

    public void onEvent(EventScaleStatus eventScaleStatus) {
        C0596r.e(c, "event scale status " + eventScaleStatus.status);
        if (eventScaleStatus.status == d) {
            this.n = false;
        } else {
            this.n = true;
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        C0596r.e(c, "onResume");
        i();
        e();
        h();
    }
}
