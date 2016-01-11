package cn.com.smartdevices.bracelet.gps.ui;

import android.os.Message;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.h.e;
import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.gps.services.N;
import java.util.List;

final class H implements N {
    final /* synthetic */ GPSResultActivity a;

    private H(GPSResultActivity gPSResultActivity) {
        this.a = gPSResultActivity;
    }

    public void a(long j, int i) {
        e.a("GPS", "onTrackDataLoaded|trackId:" + j + ",message:" + i);
        this.a.t.sendEmptyMessage(2);
    }

    public void a(long j, String str) {
        e.a("GPS", "onContourTrackCreated|trackId:" + j + ",path:" + str);
        Message obtainMessage = this.a.t.obtainMessage(1);
        obtainMessage.obj = str;
        this.a.t.sendMessage(obtainMessage);
        if (TextUtils.isEmpty(str)) {
            C0596r.d("Map", "onContourTrackCreated watermark_failed_to_create_contour_track trackId = " + j);
        } else {
            C0596r.e("Map", "onContourTrackCreated uri = " + str);
        }
    }

    public void a(long j, List<c> list) {
        synchronized (this.a) {
            this.a.h = true;
            this.a.f = list;
            if (this.a.g) {
                this.a.H.a((List) list);
            }
        }
    }
}
