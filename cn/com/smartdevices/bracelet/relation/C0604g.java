package cn.com.smartdevices.bracelet.relation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.ui.widget.DimPanelBottomBar;
import com.huami.android.view.c;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;

public class C0604g extends c {
    final /* synthetic */ DetailActivity a;

    public C0604g(DetailActivity detailActivity) {
        this.a = detailActivity;
    }

    protected int inflateLayout() {
        return R.layout.dialog_bind_qq_health_tip;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        ((TextView) onCreateView.findViewById(R.id.title)).setText(a.f);
        ((TextView) onCreateView.findViewById(R.id.msg)).setText(getActivity().getString(R.string.friend_new_user_guide));
        ((DimPanelBottomBar) onCreateView.findViewById(R.id.bt_bar)).b(getActivity().getString(R.string.friend_new_user_guide_ok));
        return onCreateView;
    }

    protected void onRightButtonClicked() {
        this.a.N = true;
        this.a.j.a(this.a, true);
        this.a.I.onClick(this.a.I);
        dismiss();
    }
}
