package com.xiaomi.channel.relationservice.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Vector;

public class a implements Runnable {
    public static final int a = 1010;
    private final Object b = new Object();
    private Handler c = null;
    private final Vector<d> d = new Vector();

    public a(String str) {
        Thread thread = new Thread(null, this, str);
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        synchronized (this.b) {
            while (this.c == null) {
                try {
                    this.b.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Message a() {
        return this.c.obtainMessage();
    }

    public void a(int i) {
        this.c.removeMessages(i);
    }

    public void a(Message message) {
        this.c.sendMessage(message);
    }

    public void a(Message message, long j) {
        this.c.sendMessageDelayed(message, j);
    }

    public void a(d dVar) {
        this.c.post(new b(this, dVar));
    }

    public void b() {
        this.c.removeCallbacksAndMessages(null);
        this.c.getLooper().quit();
    }

    public void b(d dVar) {
        this.c.post(new c(this, dVar));
    }

    public Handler c() {
        return this.c;
    }

    public void run() {
        synchronized (this.b) {
            Looper.prepare();
            this.c = new e(this, Looper.myLooper());
            this.b.notifyAll();
        }
        Looper.loop();
    }
}
