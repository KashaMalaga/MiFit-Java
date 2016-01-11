package com.amap.api.mapcore;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import com.amap.api.mapcore.util.az;

class b extends Handler {
    final /* synthetic */ AMapDelegateImpGLSurfaceView a;

    b(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
        this.a = aMapDelegateImpGLSurfaceView;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        try {
            if (this.a.K != null) {
                this.a.K.onTouch((MotionEvent) message.obj);
            }
        } catch (Throwable th) {
            az.a(th, "AMapDelegateImpGLSurfaceView", "onTouchHandler");
            th.printStackTrace();
        }
    }
}
