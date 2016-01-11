package com.b;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

final class C0922g implements Serializable {
    protected byte a = (byte) 0;
    protected ArrayList b = new ArrayList();
    private byte c = (byte) 3;

    C0922g() {
    }

    protected final Boolean a(DataOutputStream dataOutputStream) {
        try {
            dataOutputStream.writeByte(this.c);
            dataOutputStream.writeByte(this.a);
            for (int i = 0; i < this.b.size(); i++) {
                C0923h c0923h = (C0923h) this.b.get(i);
                dataOutputStream.writeByte(c0923h.a);
                Object obj = new byte[c0923h.a];
                System.arraycopy(c0923h.b, 0, obj, 0, c0923h.a < c0923h.b.length ? c0923h.a : c0923h.b.length);
                dataOutputStream.write(obj);
                dataOutputStream.writeDouble(c0923h.c);
                dataOutputStream.writeInt(c0923h.d);
                dataOutputStream.writeInt(c0923h.e);
                dataOutputStream.writeDouble(c0923h.f);
                dataOutputStream.writeByte(c0923h.g);
                dataOutputStream.writeByte(c0923h.h);
                obj = new byte[c0923h.h];
                System.arraycopy(c0923h.i, 0, obj, 0, c0923h.h < c0923h.i.length ? c0923h.h : c0923h.i.length);
                dataOutputStream.write(obj);
                dataOutputStream.writeByte(c0923h.j);
            }
            return Boolean.valueOf(true);
        } catch (IOException e) {
            return Boolean.valueOf(false);
        }
    }
}
