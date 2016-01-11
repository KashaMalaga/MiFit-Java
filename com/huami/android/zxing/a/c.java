package com.huami.android.zxing.a;

import android.os.AsyncTask;

final class c extends AsyncTask<Object, Object, Object> {
    final /* synthetic */ a a;

    private c(a aVar) {
        this.a = aVar;
    }

    protected Object doInBackground(Object... objArr) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        this.a.start();
        return null;
    }
}
