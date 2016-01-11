package com.huami.android.widget.share;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import cn.com.smartdevices.bracelet.C0596r;
import com.huami.android.view.SquareView;
import com.xiaomi.hm.health.a.f;
import com.xiaomi.hm.health.a.g;
import java.util.ArrayList;
import java.util.List;

final class t extends BaseAdapter {
    final /* synthetic */ q a;
    private List<u> b = null;

    public t(q qVar, List<u> list) {
        this.a = qVar;
        this.b = list;
        if (this.b == null) {
            this.b = new ArrayList();
        }
    }

    public u a(int i) {
        return (u) this.b.get(i);
    }

    public int getCount() {
        return this.b.size();
    }

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.a.getActivity()).inflate(g.view_share_panel_item, null);
        }
        SquareView squareView = (SquareView) view.findViewById(f.icon);
        u a = a(i);
        squareView.setBackgroundResource(a.a);
        squareView.setEnabled(a.c);
        C0596r.e("SharePanel", "position: " + i + "; shareTarget.enable  " + a.c);
        return view;
    }
}
