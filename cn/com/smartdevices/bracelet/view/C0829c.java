package cn.com.smartdevices.bracelet.view;

import android.view.View;
import android.view.View.OnClickListener;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.C0591m;
import com.tencent.connect.common.Constants;

class C0829c implements OnClickListener {
    final /* synthetic */ DynamicView a;

    C0829c(DynamicView dynamicView) {
        this.a = dynamicView;
    }

    public void onClick(View view) {
        if (C0591m.a().r() == 3) {
            C0401a.a(this.a.getContext(), C0409b.bE, C0410c.t, Constants.VIA_RESULT_SUCCESS);
        }
        this.a.a(this.a.getContext(), this.a.F);
    }
}
