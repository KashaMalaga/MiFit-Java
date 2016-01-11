package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.ui.widget.DimPanelBottomBar;
import com.huami.android.view.c;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;

public class C0811k extends c {
    public static final String a = "CONTENT";
    public static final String b = "NEGATIVETEXT";
    public static final String c = "POSITIVETEXT";
    private TextView d;
    private TextView e;
    private DimPanelBottomBar f;
    private String g;
    private String h;
    private String i;
    private String j;

    protected int inflateLayout() {
        return n.fragment_babyweight_2small;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.h = getArguments().getString(a) == null ? a : getArguments().getString(a);
        this.i = getArguments().getString(b) == null ? b : getArguments().getString(b);
        this.j = getArguments().getString(c) == null ? c : getArguments().getString(c);
        this.e = (TextView) onCreateView.findViewById(l.content);
        this.e.setText(this.h);
        this.f = (DimPanelBottomBar) onCreateView.findViewById(l.dimbtmbar);
        this.f.a(this.j);
        this.f.b(this.i);
        return onCreateView;
    }
}
