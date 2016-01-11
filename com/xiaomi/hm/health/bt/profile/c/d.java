package com.xiaomi.hm.health.bt.profile.c;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.b.c;
import com.xiaomi.hm.health.bt.profile.b.j;
import com.xiaomi.mipush.sdk.f;
import java.util.HashMap;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

@SuppressLint({"NewApi"})
public class d {
    private static final String a = "ProfileManager";
    private static final int b = 4;
    private static d d = null;
    private HashMap<String, a> c = new HashMap(b);

    private d() {
    }

    private BluetoothDevice a(Context context, String str) {
        for (BluetoothDevice bluetoothDevice : ((BluetoothManager) context.getSystemService("bluetooth")).getConnectedDevices(7)) {
            C0596r.e(a, "conneted device: " + bluetoothDevice.getName() + f.i + bluetoothDevice.getAddress());
            if (bluetoothDevice.getAddress().equalsIgnoreCase(str)) {
                return bluetoothDevice;
            }
        }
        return null;
    }

    public static d a() {
        if (d == null) {
            d = new d();
        }
        return d;
    }

    public synchronized a a(Context context, g gVar) {
        a aVar = null;
        synchronized (this) {
            String a = gVar.a();
            if (this.c.containsKey(a)) {
                aVar = (a) this.c.get(a);
            } else if (this.c.size() < b) {
                switch (e.a[gVar.b().a().ordinal()]) {
                    case l.a /*1*/:
                    case a.k /*2*/:
                        break;
                    case a.l /*3*/:
                        aVar = new j(context.getApplicationContext(), gVar);
                        break;
                    default:
                        break;
                }
                aVar.g(a(context, a));
                this.c.put(a, aVar);
            }
        }
        return aVar;
    }

    public synchronized a a(c cVar) {
        a aVar;
        for (a aVar2 : this.c.values()) {
            if (cVar.a() == aVar2.j().a()) {
                break;
            }
        }
        aVar2 = null;
        return aVar2;
    }

    public void a(a aVar) {
        a(aVar.k());
    }

    public synchronized void a(String str) {
        a aVar = (a) this.c.remove(str);
        if (aVar != null) {
            aVar.m();
        }
    }

    public synchronized a b(String str) {
        return (a) this.c.get(str);
    }
}
