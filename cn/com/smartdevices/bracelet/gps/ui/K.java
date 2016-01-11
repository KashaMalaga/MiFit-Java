package cn.com.smartdevices.bracelet.gps.ui;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.xiaomi.hm.health.b.a.i;
import com.xiaomi.hm.health.b.a.j;

public class K extends DialogFragment implements OnClickListener {
    private L a = null;
    private View b = null;
    private View c = null;

    public static void a(Activity activity) {
        FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
        K k = new K();
        k.show(beginTransaction, k.getClass().getName());
    }

    public void a(L l) {
        this.a = l;
    }

    public void onClick(View view) {
        if (this.a != null) {
            if (view.getId() == i.left_button) {
                this.a.a();
            }
            if (view.getId() == i.right_button) {
                this.a.b();
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        View inflate = layoutInflater.inflate(j.fragment_running_gps_unavailable, viewGroup, false);
        this.b = inflate.findViewById(i.left_button);
        this.c = inflate.findViewById(i.right_button);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        return inflate;
    }

    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(-2, -2);
    }
}
