package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.weight.J;
import com.huami.android.view.c;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;

public class cZ extends c {
    private static final String a = cZ.class.getSimpleName();
    private static int d;
    private TextView b;
    private int c;

    public static Fragment a(int i) {
        C0596r.e(a, "receive the uid" + i);
        d = i;
        return new cZ();
    }

    protected int inflateLayout() {
        return n.fragment_weightgoal_with_noweight;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.b = (TextView) onCreateView.findViewById(l.name_title);
        this.c = d;
        if (this.c == -1) {
            this.b.setText(getString(r.no_weight_record, new Object[]{Keeper.readPersonInfo().nickname}));
        } else {
            if (J.a().a(this.c) != null) {
                this.b.setText(getString(r.no_weight_record, new Object[]{r0.name}));
            }
        }
        return onCreateView;
    }

    protected void onRightButtonClicked() {
        dismiss();
    }
}
