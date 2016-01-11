package cn.com.smartdevices.bracelet.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.view.View;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.ReportData;
import cn.com.smartdevices.bracelet.model.ShareListDelegateActivity;
import kankan.wheel.widget.a;
import kankan.wheel.widget.g;

class C0750cz implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ int b;
    final /* synthetic */ MainUIActivity c;

    C0750cz(MainUIActivity mainUIActivity, View view, int i) {
        this.c = mainUIActivity;
        this.a = view;
        this.b = i;
    }

    public void run() {
        this.c.i.setVisibility(4);
        this.c.W.setBackgroundResource(g.window_bg);
        this.c.W.buildDrawingCache();
        Bitmap drawingCache = this.c.W.getDrawingCache();
        this.c.g.setVisibility(0);
        this.c.h.setVisibility(0);
        this.c.Y.setVisibility(0);
        this.c.i.setVisibility(0);
        this.a.setVisibility(this.b);
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + a.cb;
        if (Utils.a(str, drawingCache)) {
            this.c.W.setBackgroundResource(0);
            this.c.W.destroyDrawingCache();
            Intent intent = new Intent();
            intent.setClass(this.c, ShareListDelegateActivity.class);
            Object reportData = new ReportData();
            reportData.setType(ShareListDelegateActivity.SHARE_TYPE_MAIN_UI_SHARE);
            reportData.picture_url = str;
            intent.putExtra(ShareListDelegateActivity.REF_REPORT_DATA, Utils.c().b(reportData));
            this.c.startActivity(intent);
        }
    }
}
