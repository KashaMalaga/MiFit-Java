package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huami.android.view.c;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import kankan.wheel.widget.a;

public class C0766do extends c {
    protected int inflateLayout() {
        return n.fragment_progress_bar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        TextView textView = (TextView) onCreateView.findViewById(l.progress_txt);
        if (arguments != null) {
            CharSequence string = arguments.getString(a.bA, "...");
            boolean z = arguments.getBoolean(a.bB, true);
            textView.setText(string);
            setCancelable(z);
        }
        return onCreateView;
    }
}
