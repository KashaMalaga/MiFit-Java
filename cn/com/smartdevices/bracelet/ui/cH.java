package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.view.SelectDaysView;
import cn.com.smartdevices.bracelet.view.Y;
import com.huami.android.view.c;
import com.xiaomi.hm.health.f;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import kankan.wheel.widget.a;

public class cH extends c {
    private SelectDaysView a;
    private int b;

    protected int inflateLayout() {
        return n.fragment_setting_alarm_repeat;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.a = (SelectDaysView) onCreateView.findViewById(l.days_view);
        this.b = getArguments().getInt(a.bv);
        C0596r.e("DDDD", "Days : " + this.b);
        this.a.a(new Y(getActivity(), getResources().getStringArray(f.weeks), this.b));
        this.a.a(new cI(this));
        return onCreateView;
    }

    protected void onRightButtonClicked() {
        dismiss();
        ((NewAlarmActivity) getActivity()).c(this.b);
    }
}
