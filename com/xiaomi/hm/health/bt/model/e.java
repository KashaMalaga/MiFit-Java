package com.xiaomi.hm.health.bt.model;

import android.bluetooth.BluetoothDevice;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.bt.c.y;
import com.xiaomi.mipush.sdk.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class e {
    public BluetoothDevice a = null;
    public int b = 0;
    public byte c = (byte) 0;
    public ArrayList<String> d = new ArrayList();
    public ArrayList<String> e = new ArrayList();
    public ArrayList<String> f = new ArrayList();
    public ArrayList<String> g = new ArrayList();
    public String h = a.f;
    public String i = a.f;
    public String j = a.f;
    public String k = a.f;
    public String l = a.f;
    public String m = a.f;
    public com.xiaomi.hm.health.bt.profile.Weight.e n = new com.xiaomi.hm.health.bt.profile.Weight.e();
    public String o = a.f;

    public boolean a() {
        return (this.c & 1) == 1;
    }

    public boolean a(UUID uuid) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            if (y.a((String) it.next()).equals(uuid)) {
                return true;
            }
        }
        it = this.e.iterator();
        while (it.hasNext()) {
            if (y.a((String) it.next()).equals(uuid)) {
                return true;
            }
        }
        it = this.f.iterator();
        while (it.hasNext()) {
            if (y.b((String) it.next()).equals(uuid)) {
                return true;
            }
        }
        it = this.g.iterator();
        while (it.hasNext()) {
            if (y.b((String) it.next()).equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    public boolean b() {
        return ((this.c >> 1) & 1) == 1;
    }

    public boolean c() {
        return ((this.c >> 2) & 1) == 1;
    }

    public String toString() {
        return "[" + this.a.getName() + f.i + this.a.getAddress() + "] " + "flag:" + this.c + ",serv16:" + this.d + ",inServ16:" + this.e + ",serv128:" + this.f + ",inServ128:" + this.g + ",solicit16:" + this.h + ",solicit128:" + this.i + ",localName:" + this.j + ",shortLocalName:" + this.k + ",txLevel:" + this.l + ",manufact:" + this.m + ",weightData:" + this.n + ",other:" + this.o;
    }
}
