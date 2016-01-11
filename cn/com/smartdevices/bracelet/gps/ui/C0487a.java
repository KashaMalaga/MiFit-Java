package cn.com.smartdevices.bracelet.gps.ui;

import android.app.Activity;
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
import com.xiaomi.hm.health.b.a.i;
import com.xiaomi.hm.health.b.a.j;

public class C0487a extends c {
    public static final String a = "left_button";
    public static final String b = "right_button";
    public static final String c = "message";
    private e d = null;

    public static C0487a a(Activity activity, Bundle bundle) {
        C0487a c0487a = (C0487a) Fragment.instantiate(activity, C0487a.class.getName(), bundle);
        c0487a.show(activity.getFragmentManager().beginTransaction(), C0487a.class.getName());
        return c0487a;
    }

    public static C0487a a(Activity activity, Bundle bundle, String str) {
        FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
        Fragment c0487a = new C0487a();
        c0487a.setArguments(bundle);
        if (TextUtils.isEmpty(str)) {
            str = C0487a.class.getName();
        }
        beginTransaction.add(c0487a, str);
        beginTransaction.commitAllowingStateLoss();
        return c0487a;
    }

    protected int inflateLayout() {
        return j.fragment_running_short_track_confirm;
    }

    public void onClick(View view) {
        view.setEnabled(false);
        int id = view.getId();
        if (id == i.left_button) {
            if (this.d != null) {
                this.d.b(this);
            }
            dismiss();
        } else if (id == i.right_button) {
            if (this.d != null) {
                this.d.c(this);
            }
            dismiss();
        } else {
            super.onClick(view);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        ((TextView) onCreateView.findViewById(i.description)).setText(arguments.getString(c));
        TextView textView = (TextView) onCreateView.findViewById(i.left_button);
        textView.setOnClickListener(this);
        CharSequence string = arguments.getString(a);
        if (!TextUtils.isEmpty(string)) {
            textView.setText(string);
        }
        textView = (TextView) onCreateView.findViewById(i.right_button);
        textView.setOnClickListener(this);
        CharSequence string2 = arguments.getString(b);
        if (!TextUtils.isEmpty(string2)) {
            textView.setText(string2);
        }
        return onCreateView;
    }

    public void setOpClickListener(e eVar) {
        this.d = eVar;
    }
}
