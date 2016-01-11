package cn.com.smartdevices.bracelet.gps.sync;

import android.app.Service;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;

abstract class C0468b extends Service {
    private volatile Looper a;
    private volatile C0470c b;
    private final String c;
    private boolean d;

    public C0468b(String str) {
        this.c = str;
    }

    private void b(Intent intent, int i) {
        Message obtainMessage = this.b.obtainMessage();
        obtainMessage.arg1 = i;
        obtainMessage.obj = intent;
        this.b.sendMessage(obtainMessage);
    }

    protected abstract void a(Intent intent);

    protected void a(Intent intent, int i) {
        b(intent, i);
    }

    public void a(boolean z) {
        this.d = z;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        HandlerThread handlerThread = new HandlerThread("IntentService[" + this.c + "]");
        handlerThread.start();
        this.a = handlerThread.getLooper();
        this.b = new C0470c(this, this.a);
    }

    public void onDestroy() {
        this.a.quit();
    }

    public void onStart(Intent intent, int i) {
        b(intent, i);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        onStart(intent, i2);
        return this.d ? 3 : 2;
    }
}
