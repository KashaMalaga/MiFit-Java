package cn.com.smartdevices.bracelet.weibo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huami.android.view.c;
import com.xiaomi.hm.health.R;

public class n extends c {
    protected int inflateLayout() {
        return R.layout.dialog_bind_qq_health_tip;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        ((TextView) onCreateView.findViewById(R.id.title)).setText(getActivity().getString(R.string.bind_weibo_health));
        ((TextView) onCreateView.findViewById(R.id.msg)).setText(getActivity().getString(R.string.bind_weibo_health_tip_init));
        return onCreateView;
    }

    protected void onEmptyAreaClicked() {
    }
}
