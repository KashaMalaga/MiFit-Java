package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.channel.a.b.c;
import java.net.InetAddress;
import java.net.UnknownHostException;

final class W implements Runnable {
    W() {
    }

    public void run() {
        String b = V.c();
        if (TextUtils.isEmpty(b)) {
            c.a("Network Checkup: cannot get gateway");
        } else {
            c.a("Network Checkup: get gateway:" + b);
            V.b(b);
        }
        try {
            InetAddress byName = InetAddress.getByName("www.baidu.com");
            c.a("Network Checkup: get address for www.baidu.com:" + byName.getAddress());
            V.b(byName.getHostAddress());
        } catch (UnknownHostException e) {
            c.a("Network Checkup: cannot resolve the host www.baidu.com");
        } catch (Throwable th) {
            c.a("the checkup failure." + th);
        }
    }
}
