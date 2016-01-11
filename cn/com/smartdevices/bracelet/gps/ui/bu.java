package cn.com.smartdevices.bracelet.gps.ui;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import cn.com.smartdevices.bracelet.C0596r;

@SuppressLint({"NewApi"})
public class bu extends Fragment {
    private static final String a = "WatermarkCameraFragment";
    private static final int f = 999;
    private static final String g = "use_ffc";
    private static final String h = "use_ssm";
    private static final String i = "share_width";
    private static final String j = "share_height";
    private Context b;
    private bw c;
    private bw d;
    private bw e;

    public bu() {
        this.c = null;
        this.d = null;
        this.e = null;
        this.e = this.d;
    }

    public static bu a() {
        return new bu();
    }

    public void a(by byVar) {
        if (this.e != null) {
            this.e.a(false);
            this.e.a = byVar;
            try {
                this.e.a(false, true);
            } catch (Exception e) {
                C0596r.g(a, e.getMessage());
            }
        }
    }

    public void a(String str) {
        if (this.e != null) {
            this.e.a(str);
        }
    }

    public void a(boolean z) {
        if (z) {
            if (this.c == null) {
                this.c = b(false);
            }
            this.e = this.c;
        } else {
            if (this.d == null) {
                this.d = b(true);
            }
            this.e = this.d;
        }
        getFragmentManager().beginTransaction().replace(f, this.e).commit();
    }

    public bw b(boolean z) {
        bw bwVar = new bw();
        Bundle bundle = new Bundle();
        bundle.putBoolean(g, z);
        bwVar.setArguments(bundle);
        return bwVar;
    }

    public void b() {
        if (this.e != null) {
            this.e.h();
        }
    }

    public String c() {
        return this.e != null ? this.e.l() : null;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(true);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = getActivity();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.c == null) {
            this.c = b(false);
        }
        View frameLayout = new FrameLayout(this.b);
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        frameLayout.setId(f);
        frameLayout.setOnClickListener(new bv(this));
        return frameLayout;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onResume() {
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        C0596r.e(a, "onSaveInstanceState");
    }
}
