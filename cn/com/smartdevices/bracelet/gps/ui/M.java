package cn.com.smartdevices.bracelet.gps.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cn.com.smartdevices.bracelet.lab.a.a;
import com.xiaomi.account.openauth.h;

class M implements OnClickListener {
    final /* synthetic */ GaodeTestActivity a;

    M(GaodeTestActivity gaodeTestActivity) {
        this.a = gaodeTestActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.h.l();
        a.b();
        this.a.b.setText("Clean " + this.a.e());
        this.a.b.setEnabled(!this.a.e().contains(h.P));
    }
}
