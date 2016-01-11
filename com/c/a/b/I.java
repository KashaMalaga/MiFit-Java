package com.c.a.b;

import java.io.Writer;

final class I extends Writer {
    private final Appendable a;
    private final J b;

    private I(Appendable appendable) {
        this.b = new J();
        this.a = appendable;
    }

    public void close() {
    }

    public void flush() {
    }

    public void write(int i) {
        this.a.append((char) i);
    }

    public void write(char[] cArr, int i, int i2) {
        this.b.a = cArr;
        this.a.append(this.b, i, i + i2);
    }
}
