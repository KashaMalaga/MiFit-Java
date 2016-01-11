package cn.com.smartdevices.bracelet.i.a;

import cn.com.smartdevices.bracelet.i.a;
import cn.com.smartdevices.bracelet.i.c;

public abstract class b {
    private c mState = new c();

    public void exception() {
        this.mState.d();
    }

    public void exception(a aVar) {
        this.mState.a(aVar);
    }

    public void failure() {
        this.mState.b();
    }

    public a getException() {
        return this.mState.l();
    }

    public boolean isException() {
        return this.mState.j();
    }

    public boolean isFailed() {
        return this.mState.i();
    }

    public boolean isIdle() {
        return this.mState.e();
    }

    public boolean isPassedon() {
        return this.mState.k();
    }

    public boolean isSuccessed() {
        return this.mState.h();
    }

    public void logState(String str) {
        this.mState.b(str + "_" + getClass().getSimpleName());
    }

    public void passon() {
        this.mState.c();
    }

    public c state() {
        return this.mState;
    }

    public void success() {
        this.mState.a();
    }

    public void success(boolean z) {
        this.mState.a(z);
    }
}
