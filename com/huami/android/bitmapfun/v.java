package com.huami.android.bitmapfun;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class v extends Fragment {
    private Object a;

    public Object a() {
        return this.a;
    }

    public void a(Object obj) {
        this.a = obj;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }
}
