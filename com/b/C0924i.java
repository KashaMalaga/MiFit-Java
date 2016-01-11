package com.b;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

final class C0924i implements Serializable {
    protected byte a = (byte) 0;
    protected ArrayList b = new ArrayList();
    private byte c = (byte) 8;

    C0924i() {
    }

    protected final Boolean a(DataOutputStream dataOutputStream) {
        try {
            dataOutputStream.writeByte(this.c);
            dataOutputStream.writeByte(this.a);
            for (byte b = (byte) 0; b < this.a; b++) {
                C0925j c0925j = (C0925j) this.b.get(b);
                dataOutputStream.write(c0925j.a);
                dataOutputStream.writeShort(c0925j.b);
                dataOutputStream.write(C0927l.a(c0925j.c, c0925j.c.length));
            }
            return Boolean.valueOf(true);
        } catch (IOException e) {
            return Boolean.valueOf(false);
        }
    }
}
