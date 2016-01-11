package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import android.view.View.OnClickListener;

class aJ implements OnClickListener {
    final /* synthetic */ aK a;
    final /* synthetic */ aI b;

    aJ(aI aIVar, aK aKVar) {
        this.b = aIVar;
        this.a = aKVar;
    }

    public void onClick(View view) {
        if (this.a.d != null) {
            this.b.a(this.a);
        }
    }
}
