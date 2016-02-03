package com.xiaomi.channel.relationservice.b;

class c implements Runnable {
    final /* synthetic */ a a;
    private final /* synthetic */ d b;

    c(a aVar, d dVar) {
        this.a = aVar;
        this.b = dVar;
    }

    public void run() {
        if (this.a.d.contains(this.b)) {
            this.a.d.remove(this.b);
        }
    }
}
