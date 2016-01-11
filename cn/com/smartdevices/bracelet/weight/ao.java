package cn.com.smartdevices.bracelet.weight;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import cn.com.smartdevices.bracelet.C0401a;

class ao implements OnClickListener {
    final /* synthetic */ WeightReportActivity a;

    ao(WeightReportActivity weightReportActivity) {
        this.a = weightReportActivity;
    }

    public void onClick(View view) {
        C0401a.a(this.a.b, C0401a.ht);
        Intent intent = new Intent(this.a.b, BabyWeightInfoActivity.class);
        intent.putExtra("GENDER", this.a.m.gender);
        intent.putExtra("UNIT", this.a.n.h());
        this.a.startActivity(intent);
    }
}
