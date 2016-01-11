package cn.com.smartdevices.bracelet.notification;

import android.view.View;
import android.view.View.OnClickListener;

class m implements OnClickListener {
    final /* synthetic */ a a;
    final /* synthetic */ k b;
    final /* synthetic */ l c;

    m(l lVar, a aVar, k kVar) {
        this.c = lVar;
        this.a = aVar;
        this.b = kVar;
    }

    public void onClick(View view) {
        this.a.b = this.b.t.isChecked();
        this.c.a.b.b(this.a);
    }
}
