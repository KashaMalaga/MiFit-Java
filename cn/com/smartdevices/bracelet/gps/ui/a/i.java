package cn.com.smartdevices.bracelet.gps.ui.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.gps.h.k;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.b.a.j;
import com.xiaomi.hm.health.b.a.o;

public class i extends g {
    public static final String b = "count";
    protected h a;
    private TextView c;
    private j d = null;

    public static i c(int i) {
        i iVar = new i();
        iVar.setArguments(g.a(i));
        return iVar;
    }

    public int a() {
        return j.fragment_running_count_down;
    }

    public void a(j jVar) {
        this.d = jVar;
    }

    public void b() {
        if (this.a != null) {
            this.a.a(2, null);
        }
        dismissAllowingStateLoss();
    }

    public void b(int i) {
        this.c.setText(i + a.f);
        if (this.a != null) {
            Bundle bundle = new Bundle();
            bundle.putInt(b, i);
            this.a.a(3, bundle);
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.a = (h) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnCountDownListener");
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        if (this.d != null) {
            this.d.a(this);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i = o.CountDownDimTint;
        if (k.b(getActivity())) {
            i = o.CountDownDimDialogTint;
        }
        setStyle(0, i);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.c = (TextView) onCreateView.findViewById(com.xiaomi.hm.health.b.a.i.counter);
        return onCreateView;
    }
}
