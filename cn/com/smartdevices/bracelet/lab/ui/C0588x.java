package cn.com.smartdevices.bracelet.lab.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class C0588x implements OnClickListener {
    final /* synthetic */ LabFactoryTestActivity a;

    C0588x(LabFactoryTestActivity labFactoryTestActivity) {
        this.a = labFactoryTestActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.c.setText("End");
        this.a.k.setEnabled(false);
        this.a.l.setEnabled(false);
        this.a.m.setEnabled(false);
        this.a.d.setEnabled(false);
        this.a.e.setEnabled(false);
        this.a.f.setEnabled(false);
        this.a.g.setEnabled(false);
        this.a.a = true;
        this.a.g();
        this.a.runOnUiThread(new C0589y(this));
    }
}
