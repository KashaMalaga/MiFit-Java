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

public class fq extends c {
    public static final String a = "TITLE";
    public static final String b = "CONTENT";
    public static final String c = "NEGATIVETEXT";
    public static final String d = "POSITIVETEXT";
    private TextView e;
    private TextView f;
    private DimPanelBottomBar g;
    private String h;
    private String i;
    private String j;
    private String k;

    protected int inflateLayout() {
        return n.fragment_logoutcommon;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.h = getArguments().getString(a) == null ? a : getArguments().getString(a);
        this.i = getArguments().getString(b) == null ? b : getArguments().getString(b);
        this.j = getArguments().getString(c) == null ? c : getArguments().getString(c);
        this.k = getArguments().getString(d) == null ? d : getArguments().getString(d);
        this.e = (TextView) onCreateView.findViewById(l.logout_title);
        this.e.setText(this.h);
        this.f = (TextView) onCreateView.findViewById(l.logout_content);
        this.f.setText(this.i);
        this.g = (DimPanelBottomBar) onCreateView.findViewById(l.dimbtmbar);
        this.g.a(this.k);
        this.g.b(this.j);
        return onCreateView;
    }
}
