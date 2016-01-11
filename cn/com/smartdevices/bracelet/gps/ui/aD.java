package cn.com.smartdevices.bracelet.gps.ui;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.gps.a.b;
import cn.com.smartdevices.bracelet.gps.h.f;
import com.huami.android.view.c;
import com.huami.android.view.e;
import com.xiaomi.hm.health.b.a.j;

public class aD extends c {
    public static final int a = 1;

    public static DialogFragment a(Activity activity, Class<? extends c> cls) {
        return a(activity, cls, null);
    }

    public static DialogFragment a(Activity activity, Class<? extends c> cls, e eVar) {
        try {
            FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
            c cVar = (c) Fragment.instantiate(activity, cls.getName());
            if (eVar != null) {
                cVar.setOpClickListener(eVar);
            }
            cVar.show(beginTransaction, cls.getName());
            return cVar;
        } catch (Exception e) {
            return null;
        }
    }

    protected int inflateLayout() {
        return j.fragment_running_no_gps_prompt;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    protected void onEmptyAreaClicked() {
        dismiss();
        b.e(getActivity(), false);
    }

    protected void onLeftButtonClicked() {
        super.onLeftButtonClicked();
        dismiss();
        b.e(getActivity(), false);
    }

    protected void onRightButtonClicked() {
        getActivity().startActivityForResult(f.a(), a);
        dismiss();
        b.e(getActivity(), true);
    }
}
