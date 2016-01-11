package cn.com.smartdevices.bracelet.shoes.sync;

import android.os.HandlerThread;
import android.os.Message;

abstract class C0643t {
    private u a = null;
    private final int b = 0;
    private boolean c = false;
    private final byte[] d = new byte[0];

    public C0643t() {
        HandlerThread handlerThread = new HandlerThread("Thread [" + getClass() + "]");
        handlerThread.start();
        this.a = new u(this, handlerThread.getLooper());
    }

    public void a() {
        if (this.a == null) {
            synchronized (this.d) {
                this.c = true;
            }
            if (!this.a.hasMessages(0)) {
                this.a.a();
            }
        }
    }

    protected abstract void a(Message message);

    protected void a(Object obj) {
        Message obtainMessage = this.a.obtainMessage(0);
        obtainMessage.obj = obj;
        this.a.sendMessage(obtainMessage);
    }
}
