package cn.com.smartdevices.bracelet.weight;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import cn.com.smartdevices.bracelet.C0401a;

class C0872j implements OnClickListener {
    final /* synthetic */ BabyWeightInfoActivity a;

    C0872j(BabyWeightInfoActivity babyWeightInfoActivity) {
        this.a = babyWeightInfoActivity;
    }

    public void onClick(View view) {
        C0401a.a(this.a.d, C0401a.hs);
        this.a.startActivity(new Intent(this.a.d, BabyTipsDetailActivity.class));
    }
}
