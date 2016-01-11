package cn.com.smartdevices.bracelet.relation;

import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.Utils;
import com.huami.android.view.c;
import com.tencent.connect.common.Constants;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;

public class C0603f extends c {
    final /* synthetic */ DetailActivity a;

    public C0603f(DetailActivity detailActivity) {
        this.a = detailActivity;
    }

    protected int inflateLayout() {
        return n.fragment_friend_unfollow_confirm;
    }

    protected void onLeftButtonClicked() {
        C0401a.a(this.a, C0409b.aU, C0410c.w, Constants.VIA_TO_TYPE_QQ_GROUP);
        Utils.a(this.a, (int) r.data_loading, true);
        this.a.j.c(this.a.i.n);
    }

    protected void onRightButtonClicked() {
        C0401a.a(this.a, C0409b.aU, C0410c.w, Constants.VIA_RESULT_SUCCESS);
        dismiss();
    }
}
