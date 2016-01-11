package cn.com.smartdevices.bracelet.shoes.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.model.d;
import com.huami.android.zxing.CaptureActivity;
import java.io.Serializable;

class P implements OnItemClickListener {
    final /* synthetic */ ShoesListActivity a;

    P(ShoesListActivity shoesListActivity) {
        this.a = shoesListActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Serializable a = this.a.a.a(i);
        if (a == null) {
            C0596r.d("SUI", "item is empty position:" + i);
            return;
        }
        if (!d.k.equals(a.e)) {
            C0401a.a(this.a.b, C0409b.bt);
        } else if (a.f == 1) {
            C0401a.a(this.a.b, C0409b.br);
        } else if (a.f == 2) {
            C0401a.a(this.a.b, C0409b.bs);
        }
        Intent intent = a.k() ? new Intent(this.a, ShoesDetailActivity.class) : new Intent(this.a, ShoesIntroActivity.class);
        intent.putExtra(CaptureActivity.l, a);
        this.a.startActivity(intent);
    }
}
