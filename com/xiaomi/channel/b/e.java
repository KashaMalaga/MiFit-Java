package com.xiaomi.channel.b;

import android.os.Bundle;

class e implements Runnable {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public void run() {
        Bundle bundle = new Bundle();
        bundle.putString(a.a, null);
        bundle.putString(a.b, this.a.a.name);
        this.a.set(bundle);
    }
}
