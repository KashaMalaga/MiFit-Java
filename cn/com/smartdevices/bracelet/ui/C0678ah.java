package cn.com.smartdevices.bracelet.ui;

import android.app.DialogFragment;
import com.huami.android.view.c;
import com.huami.android.view.e;

class C0678ah implements e {
    final /* synthetic */ c a;
    final /* synthetic */ C0675ae b;

    C0678ah(C0675ae c0675ae, c cVar) {
        this.b = c0675ae;
        this.a = cVar;
    }

    public void a(DialogFragment dialogFragment) {
    }

    public void b(DialogFragment dialogFragment) {
        this.a.dismiss();
        this.b.k.b();
    }

    public void c(DialogFragment dialogFragment) {
        this.a.dismiss();
        this.b.k.a();
    }
}
