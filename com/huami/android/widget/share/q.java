package com.huami.android.widget.share;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.a.r;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import cn.com.smartdevices.bracelet.C0596r;
import com.huami.android.widget.a;
import com.huami.android.widget.d;
import com.tencent.open.SocialConstants;
import com.xiaomi.hm.health.a.e;
import com.xiaomi.hm.health.a.f;
import com.xiaomi.hm.health.a.g;
import com.xiaomi.hm.health.a.h;
import java.util.List;

@SuppressLint({"NewApi"})
public class q extends Fragment implements OnCancelListener, OnDismissListener, OnItemClickListener, d {
    public static final String a = "share_type";
    public static final String b = "share_filter";
    private static final String d = "SharePanel";
    public int c;
    private boolean e = false;
    private t f;
    private m g;
    private u h;
    private boolean i = false;
    private s j;
    private List<u> k;
    private p l;
    private OnClickListener m;
    private d n = new r(this);

    private void a() {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putStringArray(a.c, new String[]{getString(h.share_to_miliao_target_feeds), getString(h.share_to_miliao_target_friends), getString(h.share_to_miliao_target_union)});
        bundle.putString(SocialConstants.PARAM_TITLE, getString(h.share_miliao_path_selector));
        aVar.a(this.n);
        aVar.a((OnCancelListener) this);
        aVar.a((OnDismissListener) this);
        aVar.setArguments(bundle);
        aVar.show(getFragmentManager(), "Miliao");
    }

    public void a(OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    public void a(l lVar) {
        if (lVar != null && this.h != null) {
            C0596r.e(d, lVar.toString());
            if (this.h.a != e.share_miliao_selector) {
                this.g.a(this.h, lVar, this.i, 0);
            } else {
                this.g.a(this.c, lVar.a, lVar.c, !this.i ? lVar.d : null, lVar.e);
            }
            this.e = false;
            this.h = null;
        }
    }

    public void a(p pVar) {
        this.l = pVar;
    }

    public void a(s sVar) {
        this.j = sVar;
    }

    public void onAttach(Activity activity) {
        boolean z;
        super.onAttach(activity);
        Bundle arguments = getArguments();
        if (arguments != null) {
            z = arguments.getBoolean(b, false);
            this.i = arguments.getBoolean(a, false);
        } else {
            z = false;
        }
        this.g = new m(activity, z);
        this.g.a(this.l);
        this.k = this.g.a();
        this.f = new t(this, this.k);
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.e = false;
        this.h = null;
    }

    @r
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(g.view_share_panel, null);
        GridView gridView = (GridView) inflate.findViewById(f.share_list);
        gridView.setNumColumns(this.f.getCount());
        gridView.setAdapter(this.f);
        gridView.setOnItemClickListener(this);
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        onCancel(dialogInterface);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.m != null) {
            this.m.onClick(view);
        }
        if (!this.e) {
            this.e = true;
            this.h = this.f.a(i);
            C0596r.e(d, "onItemClick");
            if (this.h.a != e.share_miliao_selector) {
                if (this.j != null) {
                    this.j.b();
                }
                if (((u) this.k.get(i)).c) {
                    this.g.a(h.share_prepare_tips);
                } else {
                    this.g.a(h.share_uninstall_client);
                }
            } else if (this.g.c()) {
                a();
            } else {
                this.e = false;
            }
            C0596r.e(d, "position: " + i + "; items.enable  " + ((u) this.k.get(i)).c);
        }
    }
}
