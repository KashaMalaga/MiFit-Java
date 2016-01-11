package cn.com.smartdevices.bracelet.tag;

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
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;

public class a extends c {
    public static final String a = "left_button";
    public static final String b = "right_button";
    public static final String c = "message";
    private e d = null;

    public static a a(Activity activity, Bundle bundle) {
        a aVar = (a) Fragment.instantiate(activity, a.class.getName(), bundle);
        aVar.show(activity.getFragmentManager().beginTransaction(), a.class.getName());
        return aVar;
    }

    public static a a(Activity activity, Bundle bundle, String str) {
        FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
        Fragment aVar = new a();
        aVar.setArguments(bundle);
        if (TextUtils.isEmpty(str)) {
            str = a.class.getName();
        }
        beginTransaction.add(aVar, str);
        beginTransaction.commitAllowingStateLoss();
        return aVar;
    }

    protected int inflateLayout() {
        return n.fragment_running_short_track_confirm;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == l.left_button) {
            if (this.d != null) {
                this.d.b(this);
            }
            dismiss();
        } else if (id == l.right_button) {
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
        ((TextView) onCreateView.findViewById(l.description)).setText(arguments.getString(c));
        TextView textView = (TextView) onCreateView.findViewById(l.left_button);
        textView.setOnClickListener(this);
        CharSequence string = arguments.getString(a);
        if (!TextUtils.isEmpty(string)) {
            textView.setText(string);
        }
        textView = (TextView) onCreateView.findViewById(l.right_button);
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
