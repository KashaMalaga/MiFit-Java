package cn.com.smartdevices.bracelet.lab.ui;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huami.android.view.c;
import com.huami.android.view.e;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;

public class ae extends c {
    public static final String a = "operation";
    public static final String b = "mainNotice";
    public static final String c = "extraNotice";
    private TextView d;
    private TextView e;

    public static ae a(Activity activity, Class<? extends DialogFragment> cls, Bundle bundle, e eVar) {
        FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
        ae aeVar = (ae) Fragment.instantiate(activity, cls.getName(), bundle);
        aeVar.setOpClickListener(eVar);
        aeVar.show(beginTransaction, cls.getName());
        return aeVar;
    }

    protected int inflateLayout() {
        return n.fragment_lab_sport_timeout;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.d = (TextView) onCreateView.findViewById(l.sport_timeout_notice_content);
        this.e = (TextView) onCreateView.findViewById(l.sport_timeout_extra_notice_content);
        Bundle arguments = getArguments();
        if (arguments != null) {
            CharSequence string = arguments.getString(c);
            if (TextUtils.isEmpty(string)) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
                this.e.setText(string);
            }
            string = arguments.getString(b);
            if (TextUtils.isEmpty(string)) {
                this.d.setVisibility(8);
            } else {
                this.d.setVisibility(0);
                this.d.setText(string);
            }
            CharSequence string2 = arguments.getString(a);
            if (TextUtils.isEmpty(string2)) {
                string2 = getString(17039370);
            }
            this.mLeftButton.setText(string2);
            this.mLeftButton.setVisibility(0);
        } else {
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            this.mLeftButton.setText(17039370);
        }
        setCancelable(false);
        return onCreateView;
    }
}
