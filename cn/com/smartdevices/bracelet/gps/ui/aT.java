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

public class aT extends DialogFragment implements OnClickListener {
    private aU a = null;
    private View b = null;

    public static void a(Activity activity) {
        FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
        aT aTVar = new aT();
        aTVar.show(beginTransaction, aTVar.getClass().getName());
    }

    public void a(aU aUVar) {
        this.a = aUVar;
    }

    public void onClick(View view) {
        if (this.a != null && view.getId() == i.button) {
            this.a.a();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        View inflate = layoutInflater.inflate(j.fragment_running_hr_tips, viewGroup, false);
        this.b = inflate.findViewById(i.button);
        this.b.setOnClickListener(this);
        return inflate;
    }

    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(-2, -2);
    }
}
