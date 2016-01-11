package com.f.a.b.f;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.f.a.b.g;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public class c implements OnScrollListener {
    private g a;
    private final boolean b;
    private final boolean c;
    private final OnScrollListener d;

    public c(g gVar, boolean z, boolean z2) {
        this(gVar, z, z2, null);
    }

    public c(g gVar, boolean z, boolean z2, OnScrollListener onScrollListener) {
        this.a = gVar;
        this.b = z;
        this.c = z2;
        this.d = onScrollListener;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.d != null) {
            this.d.onScroll(absListView, i, i2, i3);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case a.i /*0*/:
                this.a.j();
                break;
            case l.a /*1*/:
                if (this.b) {
                    this.a.i();
                    break;
                }
                break;
            case a.k /*2*/:
                if (this.c) {
                    this.a.i();
                    break;
                }
                break;
        }
        if (this.d != null) {
            this.d.onScrollStateChanged(absListView, i);
        }
    }
}
