package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Switch;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;

public class C0798es extends p implements OnClickListener {
    private Switch b;
    private PersonInfo c;

    private void a(View view) {
        view.findViewById(l.weight_settings_merge_ll).setOnClickListener(this);
        this.c = Keeper.readPersonInfo();
        this.b = (Switch) view.findViewById(l.weight_settings_merge_switch);
        this.b.setChecked(this.c.getMiliConfig().getWeightMergeResult());
        this.b.setOnCheckedChangeListener(new C0799et(this));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case l.weight_settings_merge_ll /*2131297221*/:
                this.b.toggle();
                if (this.b.isChecked()) {
                    C0401a.a(getActivity().getApplicationContext(), C0401a.fF, C0401a.fG);
                    return;
                } else {
                    C0401a.a(getActivity().getApplicationContext(), C0401a.fF, C0401a.fH);
                    return;
                }
            default:
                return;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(n.fragment_setting_merge_duplicate, viewGroup, false);
        a(inflate);
        return inflate;
    }
}
