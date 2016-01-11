package cn.com.smartdevices.bracelet.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.Utils;
import com.huami.android.view.c;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.hm.health.n;

public class fm extends c implements OnClickListener {
    private static final String a = "UseLazyDaysFragment";

    protected int inflateLayout() {
        return n.fragment_confirm_lazyday;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    protected void onLeftButtonClicked() {
        super.onLeftButtonClicked();
        dismiss();
    }

    protected void onRightButtonClicked() {
        super.onRightButtonClicked();
        dismiss();
        C0401a.a(getActivity(), C0401a.fg);
        Utils.a(new SportDay());
        Context activity = getActivity();
        if (activity != null) {
            Utils.t(activity);
            MainUIActivity mainUIActivity = (MainUIActivity) activity;
            if (mainUIActivity != null) {
                mainUIActivity.l();
            }
        }
    }
}
