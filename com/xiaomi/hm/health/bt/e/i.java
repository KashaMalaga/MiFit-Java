package com.xiaomi.hm.health.bt.e;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SuppressLint({"NewApi"})
public class i {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    private static ThreadPoolExecutor e = new ThreadPoolExecutor(b, b, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    private final String d = "UUIDScanner";

    public static void a(Context context, BluetoothDevice bluetoothDevice, j jVar) {
        e.execute(new k(context, bluetoothDevice, jVar));
    }
}
