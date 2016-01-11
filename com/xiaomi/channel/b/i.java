package com.xiaomi.channel.b;

import android.os.Bundle;

class i implements Runnable {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public void run() {
        Bundle bundle = new Bundle();
        bundle.putString(a.a, null);
        bundle.putString(a.b, this.a.a.name);
        this.a.set(bundle);
    }
}
