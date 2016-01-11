package cn.com.smartdevices.bracelet.gps.ui;

import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;

class bm implements MediaScannerConnectionClient {
    final /* synthetic */ String a;
    final /* synthetic */ WatermarkActivity b;

    bm(WatermarkActivity watermarkActivity, String str) {
        this.b = watermarkActivity;
        this.a = str;
    }

    public void onMediaScannerConnected() {
        if (this.b.y != null) {
            this.b.y.scanFile(this.a, "image/jpeg");
        }
    }

    public void onScanCompleted(String str, Uri uri) {
        if (this.b.y != null && this.b.y.isConnected()) {
            this.b.y.disconnect();
        }
    }
}
