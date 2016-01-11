package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;

public class C0710bl extends C0709bk {
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(n.activity_instruction_page_1, viewGroup, false);
        a(inflate);
        this.c_.setCurrentText(getString(r.instruction_tip_1));
        return inflate;
    }
}
