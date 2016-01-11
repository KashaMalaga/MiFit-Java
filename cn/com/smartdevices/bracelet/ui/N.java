package cn.com.smartdevices.bracelet.ui;

import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;

class N implements MediaScannerConnectionClient {
    final /* synthetic */ BindWeixinActivity a;

    N(BindWeixinActivity bindWeixinActivity) {
        this.a = bindWeixinActivity;
    }

    public void onMediaScannerConnected() {
        this.a.o.scanFile(this.a.p, null);
    }

    public void onScanCompleted(String str, Uri uri) {
        this.a.m.sendEmptyMessage(4);
    }
}
