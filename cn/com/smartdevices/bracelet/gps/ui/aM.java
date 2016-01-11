package cn.com.smartdevices.bracelet.gps.ui;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.gps.services.I;
import com.xiaomi.hm.health.b.a.h;
import com.xiaomi.hm.health.b.a.i;
import com.xiaomi.hm.health.b.a.j;
import com.xiaomi.hm.health.b.a.n;

public class aM extends DialogFragment implements OnClickListener {
    public static final String a = "function";
    public static final int b = 1;
    public static final int c = 17;
    private ImageView d;
    private Context e;
    private C0488aO f = null;
    private View g = null;

    public static void a(Activity activity, Bundle bundle) {
        FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
        aM aMVar = new aM();
        aMVar.setArguments(bundle);
        aMVar.a(new aN(aMVar));
        aMVar.show(beginTransaction, aMVar.getClass().getName());
    }

    public void a(C0488aO c0488aO) {
        this.f = c0488aO;
    }

    public void onClick(View view) {
        if (this.f != null && view.getId() == i.confirm) {
            this.f.a();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = getActivity();
        getDialog().getWindow().requestFeature(b);
        View inflate = layoutInflater.inflate(j.fragment_running_pace_unavailable, viewGroup, false);
        this.g = inflate.findViewById(i.confirm);
        this.d = (ImageView) inflate.findViewById(i.image);
        this.g.setOnClickListener(this);
        TextView textView = (TextView) inflate.findViewById(i.remind);
        TextView textView2 = (TextView) inflate.findViewById(i.label);
        Bundle arguments = getArguments();
        int i;
        if (arguments.getInt(a, b) == c) {
            i = arguments.getInt(C0543z.e, 2);
            if (i == 34) {
                textView.setText(n.running_tip_open_ble_label);
                textView2.setText(n.running_tip_hr_ble_content);
                C0401a.a(this.e, C0401a.hh);
            } else if (i == 2) {
                textView.setText(n.running_tip_hr_bracelet_label);
                textView2.setText(n.running_tip_hr_bracelet_content);
                this.d.setImageResource(h.run_popup_miband);
                C0401a.a(this.e, C0401a.hg);
            } else if (i == I.d) {
                textView.setText(n.running_hr_disabled_tips);
                this.d.setImageResource(h.run_popup_heart);
                textView2.setVisibility(8);
                C0401a.a(this.e, C0401a.hi);
            } else if (i == I.e) {
                textView.setText(n.hr_battery_low);
                this.d.setImageResource(h.run_popup_lowpower);
                textView2.setText(n.close_hr_check);
            }
        } else {
            i = arguments.getInt(C0543z.e, c);
            if (i == c) {
                textView.setText(n.running_tip_open_ble_label);
                textView2.setText(n.running_tip_open_ble_content);
            } else if (i == b) {
                textView.setText(n.running_tip_use_bracelet_label);
                textView2.setText(n.running_tip_use_bracelet_content);
            } else if (i == cn.com.smartdevices.bracelet.weight.family.h.d) {
                textView.setText(n.running_tip_open_ble_label);
                textView2.setText(n.running_tip_conn_shoes);
            }
        }
        return inflate;
    }

    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(-2, -2);
    }
}
