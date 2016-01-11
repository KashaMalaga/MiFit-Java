package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.a.b.c;
import com.xiaomi.channel.a.e.a;
import com.xiaomi.h.a.C;
import com.xiaomi.h.a.C1094a;
import com.xiaomi.h.a.C1104k;
import com.xiaomi.h.a.C1106m;
import com.xiaomi.h.a.C1110q;
import com.xiaomi.h.a.C1112s;
import com.xiaomi.h.a.E;
import com.xiaomi.h.a.I;
import com.xiaomi.h.a.M;
import com.xiaomi.h.a.Q;
import com.xiaomi.h.a.S;
import com.xiaomi.h.a.u;
import com.xiaomi.h.a.y;
import java.nio.ByteBuffer;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kankan.wheel.widget.l;
import org.apache.thrift.b;
import org.apache.thrift.f;

public class q {
    private static final byte[] a = new byte[]{(byte) 100, (byte) 23, (byte) 84, (byte) 114, (byte) 72, (byte) 0, (byte) 4, (byte) 97, (byte) 73, (byte) 97, (byte) 2, (byte) 52, (byte) 84, (byte) 102, (byte) 18, (byte) 32};

    protected static <T extends b<T, ?>> C1112s a(Context context, T t, C1094a c1094a) {
        return a(context, t, c1094a, !c1094a.equals(C1094a.Registration));
    }

    protected static <T extends b<T, ?>> C1112s a(Context context, T t, C1094a c1094a, boolean z) {
        byte[] a = S.a(t);
        if (a == null) {
            c.a("invoke convertThriftObjectToBytes method, return null.");
            return null;
        }
        C1112s c1112s = new C1112s();
        if (z) {
            String f = m.a(context).f();
            if (TextUtils.isEmpty(f)) {
                c.a("regSecret is empty, return null");
                return null;
            }
            byte[] a2 = a.a(f);
            c.b(Arrays.toString(a2));
            try {
                a = b(a2, a);
            } catch (Exception e) {
                c.c("encryption error. ");
            }
        }
        C1104k c1104k = new C1104k();
        c1104k.a = 5;
        c1104k.b = "fakeid";
        c1112s.a(c1104k);
        c1112s.a(ByteBuffer.wrap(a));
        c1112s.a(c1094a);
        c1112s.c(true);
        c1112s.b(context.getPackageName());
        c1112s.a(z);
        c1112s.a(m.a(context).c());
        return c1112s;
    }

    private static Cipher a(byte[] bArr, int i) {
        Key secretKeySpec = new SecretKeySpec(bArr, "AES");
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(a);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(i, secretKeySpec, ivParameterSpec);
        return instance;
    }

    protected static b a(Context context, C1112s c1112s) {
        if (c1112s.c()) {
            try {
                byte[] a = a(a.a(m.a(context).f()), c1112s.f());
            } catch (Throwable e) {
                throw new f("the aes decrypt failed.", e);
            }
        }
        a = c1112s.f();
        b a2 = a(c1112s.a());
        if (a2 != null) {
            S.a(a2, a);
        }
        return a2;
    }

    private static b a(C1094a c1094a) {
        switch (r.a[c1094a.ordinal()]) {
            case l.a /*1*/:
                return new y();
            case kankan.wheel.widget.a.k /*2*/:
                return new M();
            case kankan.wheel.widget.a.l /*3*/:
                return new I();
            case kankan.wheel.widget.a.aQ /*4*/:
                return new Q();
            case kankan.wheel.widget.a.X /*5*/:
                return new E();
            case kankan.wheel.widget.a.bt /*6*/:
                return new C1106m();
            case kankan.wheel.widget.a.bc /*7*/:
                return new C1110q();
            case kankan.wheel.widget.a.ba /*8*/:
                return new C();
            case kankan.wheel.widget.a.bo /*9*/:
                return new u();
            case kankan.wheel.widget.a.bd /*10*/:
                return new C1110q();
            default:
                return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, 2).doFinal(bArr2);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return a(bArr, 1).doFinal(bArr2);
    }
}
