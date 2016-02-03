package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.view.J;
import cn.com.smartdevices.bracelet.view.SelectDaysView;
import com.huami.android.view.c;
import com.xiaomi.hm.health.R;
import kankan.wheel.widget.a;

public class cJ extends c {
    private int a;

    protected int inflateLayout() {
        return R.layout.fragment_setting_alarm_repeat_simple;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        SelectDaysView selectDaysView = (SelectDaysView) onCreateView.findViewById(R.id.days_view);
        this.a = getArguments().getInt(a.bv);
        selectDaysView.a(new J(getActivity(), getResources().getStringArray(R.array.select_days_simple), this.a));
        selectDaysView.a(new cK(this));
        return onCreateView;
    }

    public void onPause() {
        super.onPause();
        C0401a.b(C0401a.I);
    }

    public void onResume() {
        super.onResume();
        C0401a.a(C0401a.I);
    }

    protected void onRightButtonClicked() {
        dismiss();
    }
}
