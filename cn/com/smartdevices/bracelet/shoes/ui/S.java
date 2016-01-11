package cn.com.smartdevices.bracelet.shoes.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.xiaomi.hm.health.c.h;

class S implements OnLongClickListener {
    final /* synthetic */ ShoesListActivity a;

    S(ShoesListActivity shoesListActivity) {
        this.a = shoesListActivity;
    }

    public boolean onLongClick(View view) {
        View findViewById = this.a.findViewById(h.firmware_update);
        if (findViewById.getVisibility() != 0) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        return true;
    }
}
