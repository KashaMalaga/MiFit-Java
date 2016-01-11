package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;

public class bE extends by {
    protected void a(View view) {
        a(view, new bG(getActivity(), r.instruction_weight_title_6, r.instruction_weight_tips1_6, r.instruction_weight_tips2_6));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(n.activity_instruction_weight_page_1, viewGroup, false);
        a(inflate);
        return inflate;
    }
}
