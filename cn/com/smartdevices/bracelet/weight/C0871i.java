package cn.com.smartdevices.bracelet.weight;

import android.app.DialogFragment;
import android.content.Intent;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.weight.family.MemberInfoBaseActivity;
import cn.com.smartdevices.bracelet.weight.family.MemberInfoSetNameActivity;
import com.huami.android.view.e;

class C0871i implements e {
    final /* synthetic */ com.xiaomi.hm.health.bt.profile.Weight.e a;
    final /* synthetic */ BabyWeightActivity b;

    C0871i(BabyWeightActivity babyWeightActivity, com.xiaomi.hm.health.bt.profile.Weight.e eVar) {
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
        C0596r.e("BabyWeightActivity", "generate baby weight panel right click");
        Intent intent = new Intent(this.b.o, MemberInfoSetNameActivity.class);
        intent.putExtra("FROM_BABY_WEIGHT", true);
        intent.putExtra(MemberInfoBaseActivity.d, true);
        intent.putExtra(com.xiaomi.hm.health.bt.profile.Weight.e.d, this.a.n());
        this.b.startActivityForResult(intent, 1365);
        dialogFragment.dismiss();
    }
}
