package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Switch;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.config.b;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;

public class dM extends p implements OnClickListener {
    private View b;
    private View c;
    private Switch d;
    private b e;
    private String f = "SettingAboutUserAgreementFragment";

    private void a(View view) {
        this.b = view.findViewById(l.setting_about_user_agreement_play_area);
        this.b.setOnClickListener(this);
        this.c = view.findViewById(l.setting_about_join_improvement_plan_area);
        this.c.setOnClickListener(this);
        this.d = (Switch) view.findViewById(l.setting_about_join_improvement_plan_switch);
        this.d.setChecked(Keeper.readUserAgreement());
        C0596r.e(this.f, "UmengAnalyticsTracker : get from file --- user improvement state is " + Keeper.readUserAgreement());
        this.d.setOnCheckedChangeListener(new dN(this));
    }

    protected boolean b() {
        return true;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case l.setting_about_user_agreement_play_area /*2131297199*/:
                Utils.r(getActivity());
                C0401a.a(getActivity(), C0401a.ef);
                return;
            case l.setting_about_join_improvement_plan_area /*2131297200*/:
                this.d.toggle();
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = b.h();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(n.fragment_setting_about_user_agreement, viewGroup, false);
        a(inflate);
        return inflate;
    }

    public void onPause() {
        super.onPause();
        C0401a.b(C0401a.M);
    }

    public void onResume() {
        super.onResume();
        C0401a.a(C0401a.M);
    }
}
