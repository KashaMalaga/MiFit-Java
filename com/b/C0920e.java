package com.b;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

final class C0920e implements Serializable {
    protected byte[] a = new byte[16];
    protected byte[] b = new byte[16];
    protected byte[] c = new byte[16];
    protected short d = (short) 0;
    protected short e = (short) 0;
    protected byte f = (byte) 0;
    protected byte[] g = new byte[16];
    protected byte[] h = new byte[32];
    protected short i = (short) 0;
    protected ArrayList j = new ArrayList();
    private byte k = (byte) 41;
    private short l = (short) 0;

    C0920e() {
    }

    private Boolean a(DataOutputStream dataOutputStream) {
        Boolean.valueOf(true);
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream2.flush();
            dataOutputStream2.write(this.a);
            dataOutputStream2.write(this.b);
            dataOutputStream2.write(this.c);
            dataOutputStream2.writeShort(this.d);
            dataOutputStream2.writeShort(this.e);
            dataOutputStream2.writeByte(this.f);
            this.g[15] = (byte) 0;
            dataOutputStream2.write(C0927l.a(this.g, this.g.length));
            this.h[31] = (byte) 0;
            dataOutputStream2.write(C0927l.a(this.h, this.h.length));
            dataOutputStream2.writeShort(this.i);
            for (short s = (short) 0; s < this.i; s = (short) (s + 1)) {
                OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream3 = new DataOutputStream(byteArrayOutputStream2);
                dataOutputStream3.flush();
                as asVar = (as) this.j.get(s);
                if (!(asVar.c == null || asVar.c.a(dataOutputStream3).booleanValue())) {
                    Boolean.valueOf(false);
                }
                if (!(asVar.d == null || asVar.d.a(dataOutputStream3).booleanValue())) {
                    Boolean.valueOf(false);
                }
                if (!(asVar.e == null || asVar.e.a(dataOutputStream3).booleanValue())) {
                    Boolean.valueOf(false);
                }
                if (!(asVar.f == null || asVar.f.a(dataOutputStream3).booleanValue())) {
                    Boolean.valueOf(false);
                }
                if (!(asVar.g == null || asVar.g.a(dataOutputStream3).booleanValue())) {
                    Boolean.valueOf(false);
                }
                asVar.a = Integer.valueOf(byteArrayOutputStream2.size() + 4).shortValue();
                dataOutputStream2.writeShort(asVar.a);
                dataOutputStream2.writeInt(asVar.b);
                dataOutputStream2.write(byteArrayOutputStream2.toByteArray());
            }
            this.l = Integer.valueOf(byteArrayOutputStream.size()).shortValue();
            dataOutputStream.writeByte(this.k);
            dataOutputStream.writeShort(this.l);
            dataOutputStream.write(byteArrayOutputStream.toByteArray());
            return Boolean.valueOf(true);
        } catch (IOException e) {
            return Boolean.valueOf(false);
        }
    }

    protected final byte[] a() {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(new DataOutputStream(byteArrayOutputStream));
        return byteArrayOutputStream.toByteArray();
    }
}
