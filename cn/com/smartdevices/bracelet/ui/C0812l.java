package cn.com.smartdevices.bracelet.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.ui.widget.DimPanelBottomBar;
import com.huami.android.view.c;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;

public class C0812l extends c {
    public static final String a = "TITLE";
    public static final String b = "CONTENT";
    public static final String c = "NEGATIVETEXT";
    public static final String d = "POSITIVETEXT";
    private static final String i = "BabyWeightFirstInFragment";
    private TextView e;
    private TextView f;
    private CheckBox g;
    private DimPanelBottomBar h;
    private String j;
    private String k;
    private String l;
    private String m;
    private C0814n n;
    private boolean o = false;

    public void a(C0814n c0814n) {
        this.n = c0814n;
    }

    protected int inflateLayout() {
        return n.fragment_babyweight;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.j = getArguments().getString(a) == null ? a : getArguments().getString(a);
        this.k = getArguments().getString(b) == null ? b : getArguments().getString(b);
        this.l = getArguments().getString(c) == null ? c : getArguments().getString(c);
        this.m = getArguments().getString(d) == null ? d : getArguments().getString(d);
        this.e = (TextView) onCreateView.findViewById(l.title);
        this.e.setText(this.j);
        this.f = (TextView) onCreateView.findViewById(l.content);
        this.f.setText(this.k);
        this.h = (DimPanelBottomBar) onCreateView.findViewById(l.dimbtmbar);
        this.h.a(this.m);
        this.h.b(this.l);
        this.g = (CheckBox) onCreateView.findViewById(l.check_text);
        this.g.setOnCheckedChangeListener(new C0813m(this));
        return onCreateView;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.n != null) {
            this.n.a();
        }
    }

    protected void onLeftButtonClicked() {
        super.onLeftButtonClicked();
        Keeper.setShowBabyWeight(this.o);
        dismiss();
    }

    protected void onRightButtonClicked() {
        super.onRightButtonClicked();
        Keeper.setShowBabyWeight(this.o);
        dismiss();
    }
}
