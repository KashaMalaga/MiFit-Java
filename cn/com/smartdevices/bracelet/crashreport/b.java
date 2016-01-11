package cn.com.smartdevices.bracelet.crashreport;

import android.view.View;
import android.view.View.OnClickListener;
import java.io.File;

class b implements OnClickListener {
    final /* synthetic */ CrashReportDialogActivity a;

    b(CrashReportDialogActivity crashReportDialogActivity) {
        this.a = crashReportDialogActivity;
    }

    public void onClick(View view) {
        File file = new File(this.a.b);
        if (file.exists()) {
            file.delete();
        }
        this.a.c();
    }
}
