package com.amap.api.mapcore;

import javax.microedition.khronos.opengles.GL10;

public abstract class q {
    private t a;

    public void destroy() {
        if (this.a != null) {
            this.a.a(this);
        }
    }

    public abstract int getZIndex();

    public abstract void onDrawFrame(GL10 gl10);
}
