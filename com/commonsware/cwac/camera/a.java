package com.commonsware.cwac.camera;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@TargetApi(11)
public class a extends Fragment {
    private CameraView a = null;
    private b b = null;

    public u a(int i) {
        return this.a.a(i);
    }

    protected void a(CameraView cameraView) {
        this.a = cameraView;
    }

    public void a(b bVar) {
        this.b = bVar;
    }

    public void a(m mVar) {
        this.a.a(mVar);
    }

    public void a(String str) {
        this.a.a(str);
    }

    public void a(boolean z) {
        this.a.a(z);
    }

    public void a(boolean z, boolean z2) {
        this.a.a(z, z2);
    }

    public b b() {
        if (this.b == null) {
            this.b = new o(getActivity());
        }
        return this.b;
    }

    public void c() {
        a(false, true);
    }

    public boolean d() {
        return this.a == null ? false : this.a.f();
    }

    public void e() {
        this.a.g();
    }

    public void f() {
        this.a.h();
    }

    public int g() {
        return this.a.d();
    }

    public void h() {
        this.a.i();
    }

    public void i() {
        this.a.j();
    }

    public boolean j() {
        return this.a.k();
    }

    public void k() {
        this.a.e();
    }

    public String l() {
        return this.a.l();
    }

    public void m() {
        this.a.m();
    }

    public void n() {
        this.a.n();
    }

    public boolean o() {
        return this.a.o();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = new CameraView(getActivity());
        this.a.a(b());
        return this.a;
    }

    public void onPause() {
        if (d()) {
            try {
                f();
            } catch (Throwable e) {
                Log.e(getClass().getSimpleName(), "Exception stopping recording in onPause()", e);
            }
        }
        this.a.c();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.a.b();
    }
}
