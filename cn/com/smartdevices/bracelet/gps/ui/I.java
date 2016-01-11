package cn.com.smartdevices.bracelet.gps.ui;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.huami.android.widget.share.l;

class I extends AsyncTask<Bitmap, Void, l> {
    final /* synthetic */ GPSResultActivity a;

    private I(GPSResultActivity gPSResultActivity) {
        this.a = gPSResultActivity;
    }

    protected l a(Bitmap... bitmapArr) {
        return this.a.a(bitmapArr[0]);
    }

    protected void a(l lVar) {
        if (this.a.L != null) {
            this.a.L.a(lVar);
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Bitmap[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((l) obj);
    }
}
