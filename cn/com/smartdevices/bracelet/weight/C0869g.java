package cn.com.smartdevices.bracelet.weight;

import android.app.DialogFragment;
import cn.com.smartdevices.bracelet.C0596r;
import com.huami.android.view.e;

class C0869g implements e {
    final /* synthetic */ com.xiaomi.hm.health.bt.profile.Weight.e a;
    final /* synthetic */ BabyWeightActivity b;

    C0869g(BabyWeightActivity babyWeightActivity, com.xiaomi.hm.health.bt.profile.Weight.e eVar) {
        this.b = babyWeightActivity;
        this.a = eVar;
    }

    public void a(DialogFragment dialogFragment) {
        C0596r.e("BabyWeightActivity", "weightsmall panel empty area click");
        dialogFragment.dismiss();
        dialogFragment.getActivity().finish();
    }

    public void b(DialogFragment dialogFragment) {
        C0596r.e("BabyWeightActivity", "weightsmall panel left click");
        dialogFragment.dismiss();
        dialogFragment.getActivity().finish();
    }

    public void c(DialogFragment dialogFragment) {
        C0596r.e("BabyWeightActivity", "weightsmall panel right click");
        this.b.e(this.a);
    }
}
