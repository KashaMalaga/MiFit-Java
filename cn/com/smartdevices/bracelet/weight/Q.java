package cn.com.smartdevices.bracelet.weight;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.a.r;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.util.q;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.profile.Weight.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q extends DialogFragment {
    private static final String e = "UserListActivity";
    private static final int o = 250;
    private ListView a;
    private TextView b;
    private e c;
    private List<UserInfo> d = new ArrayList();
    private C0861ac f;
    private Context g;
    private LinearLayout h;
    private LinearLayout i;
    private RelativeLayout j;
    private boolean k = false;
    private int l = 350;
    private Animator m;
    private Animator n;
    private C0859aa p;

    public void a() {
        a(250);
    }

    public void a(long j) {
        if (this.m == null || !this.m.isRunning()) {
            int height = this.i.getHeight();
            int height2 = this.j.getHeight();
            Animator ofInt = ValueAnimator.ofInt(new int[]{0, height});
            ofInt.addUpdateListener(new V(this, height2));
            Animator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.addUpdateListener(new W(this));
            q.a(ofInt);
            q.b(ofFloat);
            ofInt = q.a();
            ofInt.setInterpolator(new DecelerateInterpolator());
            ofInt.setDuration(j);
            ofInt.start();
            this.m = ofInt;
        }
    }

    public void a(long j, AnimatorListener animatorListener) {
        if (this.n == null || !this.n.isRunning()) {
            int height = this.i.getHeight();
            int height2 = this.j.getHeight();
            Animator ofInt = ValueAnimator.ofInt(new int[]{height, 0});
            ofInt.addUpdateListener(new T(this, height2));
            Animator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            ofFloat.addUpdateListener(new U(this));
            q.a(ofInt);
            q.b(ofFloat);
            ofInt = q.a();
            ofInt.setInterpolator(new AccelerateInterpolator());
            ofInt.setDuration(j);
            ofInt.addListener(animatorListener);
            ofInt.start();
            this.n = ofInt;
        }
    }

    public void a(ListView listView) {
        this.l = Utils.a(this.g, 350.0f);
        ListAdapter adapter = listView.getAdapter();
        if (adapter != null) {
            int i = 0;
            for (int i2 = 0; i2 < adapter.getCount(); i2++) {
                View view = adapter.getView(i2, null, listView);
                view.measure(0, 0);
                i += view.getMeasuredHeight();
            }
            LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = (listView.getDividerHeight() * (adapter.getCount() - 1)) + i;
            layoutParams.height = Math.min(layoutParams.height, this.l);
            listView.setLayoutParams(layoutParams);
        }
    }

    public void a(C0859aa c0859aa) {
        this.p = c0859aa;
    }

    public void b() {
        a(250, new Y(this));
    }

    public void dismissAllowingStateLoss() {
        if (getActivity() != null) {
            super.dismissAllowingStateLoss();
            b();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.i.post(new X(this));
    }

    public void onCancel(DialogInterface dialogInterface) {
        C0596r.e(e, "onCancel");
        b();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.g = getActivity().getApplicationContext();
    }

    @r
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_userslist, viewGroup, false);
        this.a = (ListView) inflate.findViewById(R.id.users_list);
        this.b = (TextView) inflate.findViewById(R.id.list_title);
        this.h = (LinearLayout) inflate.findViewById(R.id.dlg_empty_area_btn);
        this.i = (LinearLayout) inflate.findViewById(R.id.content);
        this.j = (RelativeLayout) inflate.findViewById(R.id.main_content);
        this.h.setOnClickListener(new R(this));
        this.d.clear();
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString(e.d);
            if (string != null) {
                this.c = e.b(string);
                C0596r.e(e, "receive weightadvdata " + this.c.toString());
            }
            this.k = arguments.getBoolean("FROM_BABY_WEIGHT");
        }
        C0596r.e(e, "mUserInfos size is " + this.d.size() + " " + toString());
        this.d = J.a().d();
        this.b.setText(getString(R.string.weight_match_no_suitable_user));
        if (this.c == null) {
            this.b.setText(getString(R.string.please_choose_user));
            this.d.clear();
            this.d = J.a().d();
        }
        if (this.c != null) {
            Collections.sort(this.d, new C0860ab(this, aA.a(this.c.j(), this.c.h())));
        }
        for (UserInfo userInfo : this.d) {
            C0596r.e(e, "after info : " + userInfo.toString());
        }
        this.f = new C0861ac(this);
        this.a.setAdapter(this.f);
        if (this.c != null) {
            this.a.addFooterView(new Z(this, this.g));
        }
        this.a.setOnItemClickListener(new S(this));
        a(this.a);
        return inflate;
    }

    public void onPause() {
        super.onPause();
        C0401a.b(C0401a.aR);
    }

    public void onResume() {
        super.onResume();
        C0401a.a(C0401a.aR);
    }
}
