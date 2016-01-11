package com.huami.android.widget.share;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.huami.android.widget.a;
import com.huami.android.widget.d;
import com.huami.android.widget.e;
import com.tencent.open.SocialConstants;
import com.xiaomi.hm.health.a.f;
import com.xiaomi.hm.health.a.g;
import java.util.List;

@SuppressLint({"NewApi"})
public class h extends e implements OnClickListener, OnItemClickListener, d {
    public static final String a = "shareItem";
    public static final String b = "share_type";
    public static final String c = "share_filter";
    public static final String d = "is_asyn";
    private j e;
    private m i;
    private l j;
    private boolean k = false;
    private List<u> l;
    private boolean m = false;
    private p n;
    private OnClickListener o;
    private final d p = new i(this);
    private u q = null;
    private k r = k.Init;

    public h() {
        super(g.view_share_dialog);
    }

    @SuppressLint({"NewApi"})
    public static h a(Context context, Bundle bundle) {
        Fragment instantiate = instantiate(context, h.class.getName());
        instantiate.setArguments(bundle);
        return (h) instantiate;
    }

    @SuppressLint({"NewApi"})
    private void a() {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putStringArray(a.c, new String[]{getString(com.xiaomi.hm.health.a.h.share_to_miliao_target_feeds), getString(com.xiaomi.hm.health.a.h.share_to_miliao_target_friends), getString(com.xiaomi.hm.health.a.h.share_to_miliao_target_union)});
        bundle.putString(SocialConstants.PARAM_TITLE, getString(com.xiaomi.hm.health.a.h.share_miliao_path_selector));
        aVar.a(this.p);
        aVar.setArguments(bundle);
        aVar.show(getFragmentManager(), "Miliao");
    }

    private void a(u uVar) {
        if (uVar.a != com.xiaomi.hm.health.a.e.share_miliao_selector) {
            this.i.a(uVar, this.j, this.k, 0);
            if (uVar.c) {
                this.i.a(com.xiaomi.hm.health.a.h.share_prepare_tips);
                dismiss();
                return;
            }
            this.i.a(com.xiaomi.hm.health.a.h.share_uninstall_client);
        } else if (this.i.c()) {
            a();
        }
    }

    private boolean b(l lVar) {
        return lVar != null;
    }

    public void a(OnClickListener onClickListener) {
        this.o = onClickListener;
    }

    protected void a(View view) {
        GridView gridView = (GridView) view.findViewById(f.share_list);
        gridView.setAdapter(this.e);
        gridView.setOnItemClickListener(this);
        view.findViewById(f.dismiss_button).setOnClickListener(this);
    }

    public synchronized void a(l lVar) {
        if (this.m) {
            if (b(lVar)) {
                this.j = lVar;
                if (this.r == k.ClickedNotShare) {
                    if (this.q == null) {
                        throw new IllegalStateException();
                    }
                    this.i.a(this.q, this.j, this.k, 0);
                    this.r = k.Init;
                } else if (this.r != k.Init) {
                    throw new IllegalStateException();
                }
            }
        }
    }

    public void a(p pVar) {
        this.n = pVar;
    }

    @SuppressLint({"NewApi"})
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        boolean z = arguments.getBoolean(c, false);
        this.m = arguments.getBoolean(d, false);
        this.j = (l) arguments.getSerializable(a);
        this.k = arguments.getBoolean(b, false);
        this.i = new m(activity, z);
        this.i.a(this.n);
        this.l = this.i.b();
        this.e = new j(this, this.l);
        if (!this.m && !b(this.j)) {
            throw new IllegalArgumentException("shareitem is unavailable while ARG_IS_ASYN is not set");
        }
    }

    @SuppressLint({"NewApi"})
    public void onClick(View view) {
        if (view.getId() == f.dismiss_button) {
            dismiss();
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.o != null) {
            this.o.onClick(view);
        }
        u a = this.e.a(i);
        if (b(this.j)) {
            a(a);
            this.r = k.Init;
        } else if (this.m) {
            this.q = a;
            this.r = k.ClickedNotShare;
        } else {
            throw new IllegalStateException("share item is not available");
        }
    }
}
