package com.huami.android.zxing;

import android.os.AsyncTask;
import android.util.Log;
import cn.com.smartdevices.bracelet.F;

final class p extends AsyncTask<Object, Object, Object> {
    final /* synthetic */ n a;

    private p(n nVar) {
        this.a = nVar;
    }

    protected Object doInBackground(Object... objArr) {
        try {
            Thread.sleep(F.a);
            Log.i(n.a, "Finishing activity due to inactivity");
            this.a.c.finish();
        } catch (InterruptedException e) {
        }
        return null;
    }
}
