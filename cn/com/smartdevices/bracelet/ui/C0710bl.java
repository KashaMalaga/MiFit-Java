package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.hm.health.R;

public class C0710bl extends C0709bk {
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_instruction_page_1, viewGroup, false);
        a(inflate);
        this.c_.setCurrentText(getString(R.string.instruction_tip_1));
        return inflate;
    }
}
