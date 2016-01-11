package com.huami.android.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.hm.health.a.f;
import com.xiaomi.hm.health.a.g;

public class a extends c {
    public static final String c = "title";
    public static final String d = "msg";

    protected int inflateLayout() {
        return g.dialog_bottom_alert_tips;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        int i2;
        if (getArguments() != null) {
            i = getArguments().getInt(c);
            i2 = i;
            i = getArguments().getInt(d);
        } else {
            i = 0;
            i2 = 0;
        }
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        TextView textView = (TextView) onCreateView.findViewById(f.title);
        if (textView != null) {
            textView.setText(i2);
        }
        textView = (TextView) onCreateView.findViewById(f.msg);
        if (textView != null) {
            textView.setText(i);
        }
        return onCreateView;
    }

    protected void onEmptyAreaClicked() {
    }
}
