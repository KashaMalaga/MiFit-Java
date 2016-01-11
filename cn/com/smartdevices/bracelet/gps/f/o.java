package cn.com.smartdevices.bracelet.gps.f;

import com.amap.api.maps.AMap.CancelableCallback;

class o implements CancelableCallback {
    final /* synthetic */ u a;
    final /* synthetic */ n b;

    o(n nVar, u uVar) {
        this.b = nVar;
        this.a = uVar;
    }

    public void onCancel() {
        this.a.a();
    }

    public void onFinish() {
        this.a.b();
    }
}
