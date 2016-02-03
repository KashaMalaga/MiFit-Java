package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0667t;
import cn.com.smartdevices.bracelet.Constant;
import com.huami.android.view.c;
import com.xiaomi.hm.health.R;

public class cA extends c {
    private int a = 0;

    protected int inflateLayout() {
        this.a = getArguments().getInt(Constant.aR);
        return this.a == 0 ? R.layout.fragment_mili_exit_login : this.a == 1 ? R.layout.fragment_mili_exit_login_continue : R.layout.fragment_unbind_mili_exit_login;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.a == 0) {
            TextView textView = (TextView) onCreateView.findViewById(R.id.mili_exit_login_info_tv);
            String string = getString(R.string.mili_exit_login_info_unbind);
            String string2 = getString(R.string.mili_exit_login_info_unlock);
            String string3 = getString(R.string.mili_exit_login_info_continue_tip);
            textView.setText(C0667t.c(getActivity()) ? string + string2 + string3 : string + string3);
        }
        return onCreateView;
    }
}
