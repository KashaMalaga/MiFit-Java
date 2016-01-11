package cn.com.smartdevices.bracelet.view;

import android.support.v7.widget.N;
import android.support.v7.widget.aj;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.n;
import java.util.List;

class ac extends N<ae> {
    final /* synthetic */ WeightUserQuickPicker a;
    private List<UserInfo> b;

    public ac(WeightUserQuickPicker weightUserQuickPicker, List<UserInfo> list) {
        this.a = weightUserQuickPicker;
        this.b = list;
    }

    public int a() {
        return this.b.size();
    }

    public /* synthetic */ aj a(ViewGroup viewGroup, int i) {
        return c(viewGroup, i);
    }

    public void a(ae aeVar, int i) {
        UserInfo userInfo = (UserInfo) this.b.get(i);
        aeVar.r.setImageResource(k.choose_user_src_selector);
        aeVar.r.a(userInfo.name);
        Utils.a(userInfo, aeVar.r);
        if (this.a.g == i) {
            aeVar.a.setAlpha(1.0f);
        } else {
            aeVar.a.setAlpha(0.3f);
        }
        aeVar.a.setOnClickListener(new ad(this, userInfo, i));
    }

    public ae c(ViewGroup viewGroup, int i) {
        return new ae(LayoutInflater.from(viewGroup.getContext()).inflate(n.view_weight_user_picker_item, viewGroup, false));
    }
}
