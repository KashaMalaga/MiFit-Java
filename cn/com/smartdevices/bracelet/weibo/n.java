package cn.com.smartdevices.bracelet.weibo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huami.android.view.c;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.r;

public class n extends c {
    protected int inflateLayout() {
        return com.xiaomi.hm.health.n.dialog_bind_qq_health_tip;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        ((TextView) onCreateView.findViewById(l.title)).setText(getActivity().getString(r.bind_weibo_health));
        ((TextView) onCreateView.findViewById(l.msg)).setText(getActivity().getString(r.bind_weibo_health_tip_init));
        return onCreateView;
    }

    protected void onEmptyAreaClicked() {
    }
}
