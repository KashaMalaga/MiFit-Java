package cn.com.smartdevices.bracelet.gps.ui;

import android.os.Bundle;
import cn.com.smartdevices.bracelet.C0596r;
import com.commonsware.cwac.camera.a;
import com.commonsware.cwac.camera.m;
import com.commonsware.cwac.camera.p;

public class bw extends a {
    private by a = null;
    private String b;

    void a() {
        m mVar = new m(b());
        mVar.a(this.b);
        a(mVar);
    }

    public void a(int i, Runnable runnable) {
        a(i).a(runnable).a();
    }

    public void a(boolean z) {
        if (getView() != null) {
            super.a(z);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(new p(new bx(this, getActivity())).d(true).a());
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        C0596r.e("WatermarkCameraFragment", "DemoCameraFragment onSaveInstanceState");
    }
}
