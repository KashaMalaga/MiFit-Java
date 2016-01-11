package com.b;

import android.support.v4.media.h;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.xiaomi.mipush.sdk.f;
import java.util.zip.CRC32;
import kankan.wheel.widget.a;

public class ag {
    public byte[] A = null;
    public String B = null;
    public String C = null;
    public String D = null;
    public String E = null;
    public String a = Constants.VIA_TO_TYPE_QQ_GROUP;
    public short b = (short) 0;
    public String c = null;
    public String d = null;
    public String e = null;
    public String f = null;
    public String g = null;
    public String h = null;
    public String i = null;
    public String j = null;
    public String k = null;
    public String l = null;
    public String m = null;
    public String n = null;
    public String o = null;
    public String p = null;
    public String q = null;
    public String r = null;
    public String s = null;
    public String t = null;
    public String u = null;
    public String v = null;
    public String w = null;
    public String x = null;
    public String y = null;
    public String z = null;

    private String a(String str, int i) {
        String[] split = this.w.split("\\*")[i].split(f.i);
        return str.equals("lac") ? split[0] : str.equals("cellid") ? split[1] : str.equals("signal") ? split[2] : null;
    }

    private byte[] a(String str) {
        String[] split = str.split(a.ci);
        if (split == null || split.length != 6) {
            String[] strArr = new String[6];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = Constants.VIA_RESULT_SUCCESS;
            }
            split = strArr;
        }
        byte[] bArr = new byte[6];
        for (int i2 = 0; i2 < split.length; i2++) {
            if (split[i2].length() > 2) {
                split[i2] = split[i2].substring(0, 2);
            }
            bArr[i2] = (byte) Integer.parseInt(split[i2], 16);
        }
        return bArr;
    }

    private String b(String str) {
        if (!this.v.contains(str + ">")) {
            return Constants.VIA_RESULT_SUCCESS;
        }
        int indexOf = this.v.indexOf(str + ">");
        return this.v.substring((indexOf + str.length()) + 1, this.v.indexOf("</" + str));
    }

    private void b() {
        if (TextUtils.isEmpty(this.a)) {
            this.a = com.xiaomi.e.a.f;
        }
        if (TextUtils.isEmpty(this.c)) {
            this.c = com.xiaomi.e.a.f;
        }
        if (TextUtils.isEmpty(this.d)) {
            this.d = com.xiaomi.e.a.f;
        }
        if (TextUtils.isEmpty(this.e)) {
            this.e = com.xiaomi.e.a.f;
        }
        if (TextUtils.isEmpty(this.f)) {
            this.f = com.xiaomi.e.a.f;
        }
        if (TextUtils.isEmpty(this.g)) {
            this.g = com.xiaomi.e.a.f;
        }
        if (TextUtils.isEmpty(this.h)) {
            this.h = com.xiaomi.e.a.f;
        }
        if (TextUtils.isEmpty(this.i)) {
            this.i = com.xiaomi.e.a.f;
        }
        if (TextUtils.isEmpty(this.j)) {
            this.j = Constants.VIA_RESULT_SUCCESS;
        } else if (!(this.j.equals(Constants.VIA_TO_TYPE_QQ_GROUP) || this.j.equals(Constants.VIA_SSO_LOGIN))) {
            this.j = Constants.VIA_RESULT_SUCCESS;
        }
        if (TextUtils.isEmpty(this.D)) {
            this.D = Constants.VIA_RESULT_SUCCESS;
        } else if (!(this.D.equals(Constants.VIA_RESULT_SUCCESS) || this.D.equals(Constants.VIA_TO_TYPE_QQ_GROUP))) {
            this.D = Constants.VIA_RESULT_SUCCESS;
        }
        if (TextUtils.isEmpty(this.k)) {
            this.k = com.xiaomi.e.a.f;
        } else {
            this.k = String.valueOf(Double.valueOf(Double.parseDouble(this.k) * 1200000.0d).intValue());
        }
        if (TextUtils.isEmpty(this.l)) {
            this.l = com.xiaomi.e.a.f;
        } else {
            this.l = String.valueOf(Double.valueOf(Double.parseDouble(this.l) * 1000000.0d).intValue());
        }
        if (TextUtils.isEmpty(this.m)) {
            this.m = com.xiaomi.e.a.f;
        }
        if (TextUtils.isEmpty(this.n)) {
            this.n = com.xiaomi.e.a.f;
        }
        if (TextUtils.isEmpty(this.o)) {
            this.o = com.xiaomi.e.a.f;
        }
        if (TextUtils.isEmpty(this.p)) {
            this.p = com.xiaomi.e.a.f;
        }
        if (TextUtils.isEmpty(this.q)) {
            this.q = com.xiaomi.e.a.f;
        }
        if (TextUtils.isEmpty(this.r)) {
            this.r = com.xiaomi.e.a.f;
        }
        if (TextUtils.isEmpty(this.B)) {
            this.B = com.xiaomi.e.a.f;
        }
        if (TextUtils.isEmpty(this.C)) {
            this.C = com.xiaomi.e.a.f;
        }
        if (TextUtils.isEmpty(this.s)) {
            this.s = com.xiaomi.e.a.f;
        }
        if (TextUtils.isEmpty(this.t)) {
            this.t = Constants.VIA_RESULT_SUCCESS;
        } else if (!(this.t.equals(Constants.VIA_TO_TYPE_QQ_GROUP) || this.t.equals(Constants.VIA_SSO_LOGIN))) {
            this.t = Constants.VIA_RESULT_SUCCESS;
        }
        if (TextUtils.isEmpty(this.u)) {
            this.u = Constants.VIA_RESULT_SUCCESS;
        } else if (!(this.u.equals(Constants.VIA_TO_TYPE_QQ_GROUP) || this.u.equals(Constants.VIA_SSO_LOGIN))) {
            this.u = Constants.VIA_RESULT_SUCCESS;
        }
        if (TextUtils.isEmpty(this.v)) {
            this.v = com.xiaomi.e.a.f;
        }
        if (TextUtils.isEmpty(this.w)) {
            this.w = com.xiaomi.e.a.f;
        }
        if (TextUtils.isEmpty(this.x)) {
            this.x = com.xiaomi.e.a.f;
        }
        if (TextUtils.isEmpty(this.y)) {
            this.y = com.xiaomi.e.a.f;
        }
        if (TextUtils.isEmpty(this.E)) {
            this.E = com.xiaomi.e.a.f;
        }
        if (TextUtils.isEmpty(this.z)) {
            this.z = com.xiaomi.e.a.f;
        }
        if (this.A == null) {
            this.A = new byte[0];
        }
    }

    public byte[] a() {
        Object bytes;
        int length;
        Object b;
        String[] split;
        b();
        int i = 3072;
        if (this.A != null) {
            i = 3072 + (this.A.length + 1);
        }
        Object obj = new byte[i];
        obj[0] = Byte.parseByte(this.a);
        Object b2 = ak.b(this.b);
        System.arraycopy(b2, 0, obj, 1, b2.length);
        i = b2.length + 1;
        try {
            bytes = this.c.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e) {
            obj[i] = null;
            i++;
        }
        try {
            bytes = this.d.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e2) {
            obj[i] = null;
            i++;
        }
        try {
            bytes = this.n.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e3) {
            obj[i] = null;
            i++;
        }
        try {
            bytes = this.e.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e4) {
            obj[i] = null;
            i++;
        }
        try {
            bytes = this.f.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e5) {
            obj[i] = null;
            i++;
        }
        try {
            bytes = this.g.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e6) {
            obj[i] = null;
            i++;
        }
        try {
            bytes = this.r.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e7) {
            obj[i] = null;
            i++;
        }
        try {
            bytes = this.h.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e8) {
            obj[i] = null;
            i++;
        }
        try {
            bytes = this.o.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e9) {
            obj[i] = null;
            i++;
        }
        try {
            bytes = this.p.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e10) {
            obj[i] = null;
            i++;
        }
        if (TextUtils.isEmpty(this.q)) {
            obj[i] = null;
            i++;
        } else {
            bytes = a(this.q);
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        }
        try {
            bytes = this.B.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e11) {
            obj[i] = null;
            i++;
        }
        try {
            bytes = this.C.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e12) {
            obj[i] = null;
            i++;
        }
        try {
            bytes = this.s.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e13) {
            obj[i] = null;
            i++;
        }
        obj[i] = Byte.parseByte(this.t);
        i++;
        obj[i] = Byte.parseByte(this.j);
        i++;
        if (this.j.equals(Constants.VIA_TO_TYPE_QQ_GROUP)) {
            try {
                obj[i] = Byte.parseByte(this.D);
                i++;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (this.j.equals(Constants.VIA_TO_TYPE_QQ_GROUP) || this.j.equals(Constants.VIA_SSO_LOGIN)) {
            bytes = ak.a(Integer.parseInt(this.k));
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        }
        if (this.j.equals(Constants.VIA_TO_TYPE_QQ_GROUP) || this.j.equals(Constants.VIA_SSO_LOGIN)) {
            bytes = ak.a(Integer.parseInt(this.l));
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        }
        if (this.j.equals(Constants.VIA_TO_TYPE_QQ_GROUP) || this.j.equals(Constants.VIA_SSO_LOGIN)) {
            bytes = ak.b(this.m);
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        }
        obj[i] = Byte.parseByte(this.u);
        i++;
        if (this.u.equals(Constants.VIA_TO_TYPE_QQ_GROUP)) {
            bytes = ak.b(b("mcc"));
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
            bytes = ak.b(b("mnc"));
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
            bytes = ak.b(b("lac"));
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
            bytes = ak.a(b("cellid"));
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            length = bytes.length + i;
            i = Integer.parseInt(b("signal"));
            if (i > h.j) {
                i = 0;
            } else if (i < -128) {
                i = 0;
            }
            obj[length] = (byte) i;
            i = length + 1;
            if (this.w.length() == 0) {
                obj[i] = null;
                i++;
            } else {
                int length2 = this.w.split("\\*").length;
                obj[i] = (byte) length2;
                i++;
                length = 0;
                while (length < length2) {
                    b = ak.b(a("lac", length));
                    System.arraycopy(b, 0, obj, i, b.length);
                    i += b.length;
                    b = ak.a(a("cellid", length));
                    System.arraycopy(b, 0, obj, i, b.length);
                    int length3 = b.length + i;
                    i = Integer.parseInt(a("signal", length));
                    if (i > h.j) {
                        i = 0;
                    } else if (i < -128) {
                        i = 0;
                    }
                    obj[length3] = (byte) i;
                    length++;
                    i = length3 + 1;
                }
            }
        } else if (this.u.equals(Constants.VIA_SSO_LOGIN)) {
            bytes = ak.b(b("mcc"));
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
            bytes = ak.b(b("sid"));
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
            bytes = ak.b(b("nid"));
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
            bytes = ak.b(b("bid"));
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
            bytes = ak.a(b("lon"));
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
            bytes = ak.a(b("lat"));
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            length = bytes.length + i;
            i = Integer.parseInt(b("signal"));
            if (i > h.j) {
                i = 0;
            } else if (i < -128) {
                i = 0;
            }
            obj[length] = (byte) i;
            i = length + 1;
            obj[i] = null;
            i++;
        }
        if (this.x.length() == 0) {
            obj[i] = null;
            i++;
        } else {
            obj[i] = 1;
            i++;
            try {
                split = this.x.split(f.i);
                b = a(split[0]);
                System.arraycopy(b, 0, obj, i, b.length);
                i += b.length;
                b = split[2].getBytes("GBK");
                obj[i] = (byte) b.length;
                i++;
                System.arraycopy(b, 0, obj, i, b.length);
                i += b.length;
            } catch (Exception e14) {
                obj[i] = (byte) 0;
                i++;
            } catch (Throwable th2) {
                bytes = a("00:00:00:00:00:00");
                System.arraycopy(bytes, 0, obj, i, bytes.length);
                i += bytes.length;
                obj[i] = null;
                i++;
                obj[i] = Byte.parseByte(Constants.VIA_RESULT_SUCCESS);
                i++;
            }
            length = Integer.parseInt(split[1]);
            if (length > h.j) {
                length = 0;
            } else if (length < -128) {
                length = 0;
            }
            obj[i] = Byte.parseByte(String.valueOf(length));
            i++;
        }
        String[] split2 = this.y.split("\\*");
        if (TextUtils.isEmpty(this.y) || split2.length == 0) {
            obj[i] = null;
            i++;
        } else {
            obj[i] = (byte) split2.length;
            i++;
            length3 = 0;
            while (length3 < split2.length) {
                split = split2[length3].split(f.i);
                Object a = a(split[0]);
                System.arraycopy(a, 0, obj, i, a.length);
                i += a.length;
                try {
                    a = split[2].getBytes("GBK");
                    obj[i] = (byte) a.length;
                    i++;
                    System.arraycopy(a, 0, obj, i, a.length);
                    i += a.length;
                } catch (Exception e15) {
                    obj[i] = null;
                    i++;
                }
                length = Integer.parseInt(split[1]);
                if (length > h.j) {
                    length = 0;
                } else if (length < -128) {
                    length = 0;
                }
                obj[i] = Byte.parseByte(String.valueOf(length));
                length3++;
                i++;
            }
            if (this.E != null && this.E.length() > 0) {
                try {
                    bytes = ak.b(Integer.parseInt(this.E));
                    System.arraycopy(bytes, 0, obj, i, bytes.length);
                    i += bytes.length;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        }
        try {
            bytes = this.z.getBytes("GBK");
            if (bytes.length > h.j) {
                bytes = null;
            }
            if (bytes == null) {
                obj[i] = (byte) 0;
                i++;
            } else {
                obj[i] = (byte) bytes.length;
                i++;
                System.arraycopy(bytes, 0, obj, i, bytes.length);
                i += bytes.length;
            }
        } catch (Exception e16) {
            obj[i] = null;
            i++;
        }
        length = this.A != null ? this.A.length : 0;
        b = ak.b(length);
        System.arraycopy(b, 0, obj, i, b.length);
        i += b.length;
        if (length > 0) {
            System.arraycopy(this.A, 0, obj, i, this.A.length);
            i += this.A.length;
        }
        bytes = new byte[i];
        System.arraycopy(obj, 0, bytes, 0, i);
        CRC32 crc32 = new CRC32();
        crc32.update(bytes);
        b = ak.a(crc32.getValue());
        obj = new byte[(b.length + i)];
        System.arraycopy(bytes, 0, obj, 0, i);
        System.arraycopy(b, 0, obj, i, b.length);
        i += b.length;
        return obj;
    }
}
