package com.activeandroid.app;

import android.content.Context;
import com.activeandroid.a;

public class Application extends android.app.Application {
    public void onCreate() {
        super.onCreate();
        a.a((Context) this);
    }

    public void onTerminate() {
        super.onTerminate();
        a.b();
    }
}
