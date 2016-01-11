package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huami.android.view.c;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;

class C0692av extends c {
    final /* synthetic */ C0681ak a;

    private C0692av(C0681ak c0681ak) {
        this.a = c0681ak;
    }

    protected int inflateLayout() {
        return n.dialog_sensor_hub_tip;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        if (!(arguments == null || arguments.getString("Msg") == null)) {
            ((TextView) onCreateView.findViewById(l.msg)).setText(arguments.getString("Msg"));
        }
        return onCreateView;
    }
}
