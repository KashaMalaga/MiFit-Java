package com.xiaomi.h.a;

import com.xiaomi.channel.a.b.c;
import org.apache.thrift.b;
import org.apache.thrift.e;
import org.apache.thrift.f;
import org.apache.thrift.g;
import org.apache.thrift.protocol.l.a;

public class S {
    public static <T extends b<T, ?>> void a(T t, byte[] bArr) {
        if (bArr == null) {
            throw new f("the message byte is empty.");
        }
        new e(new a(true, true, bArr.length)).a(t, bArr);
    }

    public static <T extends b<T, ?>> byte[] a(T t) {
        byte[] bArr = null;
        if (t != null) {
            try {
                bArr = new g(new org.apache.thrift.protocol.a.a()).a(t);
            } catch (Throwable e) {
                c.a("convertThriftObjectToBytes catch TException.", e);
            }
        }
        return bArr;
    }
}
