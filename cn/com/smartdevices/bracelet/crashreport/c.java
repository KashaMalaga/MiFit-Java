package cn.com.smartdevices.bracelet.crashreport;

import android.view.View;
import android.view.View.OnClickListener;

class c implements OnClickListener {
    final /* synthetic */ CrashReportingApplication a;
    final /* synthetic */ CrashReportDialogActivity b;

    c(CrashReportDialogActivity crashReportDialogActivity, CrashReportingApplication crashReportingApplication) {
        this.b = crashReportDialogActivity;
        this.a = crashReportingApplication;
    }

    public void onClick(View view) {
        this.a.g();
        this.b.c();
    }
}
