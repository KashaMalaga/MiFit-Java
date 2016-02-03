package cn.com.smartdevices.bracelet.shoes.ui;

import android.app.DialogFragment;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import com.huami.android.widget.c;
import com.tencent.connect.common.Constants;

class O implements c {
    final /* synthetic */ ShoesIntroActivity a;

    O(ShoesIntroActivity shoesIntroActivity) {
        this.a = shoesIntroActivity;
    }

    public void a(DialogFragment dialogFragment, int i) {
        if (i == -2) {
            C0401a.a(this.a.g, C0409b.bD, C0410c.t, Constants.VIA_RESULT_SUCCESS);
            this.a.d();
        } else if (i == -1) {
            C0401a.a(this.a.g, C0409b.bD, C0410c.t, Constants.VIA_TO_TYPE_QQ_GROUP);
        }
    }
}
