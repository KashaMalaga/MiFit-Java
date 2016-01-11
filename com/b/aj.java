package com.b;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class aj extends FilterOutputStream {
    private final S a;
    private boolean b;

    private aj(OutputStream outputStream, S s) {
        super(outputStream);
        this.b = false;
        this.a = s;
    }

    public void close() {
        IOException iOException = null;
        try {
            super.close();
        } catch (IOException e) {
            iOException = e;
        }
        if (this.b) {
            this.a.b();
        } else {
            this.a.a();
        }
        if (iOException != null) {
            throw iOException;
        }
    }

    public void flush() {
        try {
            super.flush();
        } catch (IOException e) {
            this.b = true;
            throw e;
        }
    }

    public void write(int i) {
        try {
            super.write(i);
        } catch (IOException e) {
            this.b = true;
            throw e;
        }
    }

    public void write(byte[] bArr) {
        try {
            super.write(bArr);
        } catch (IOException e) {
            this.b = true;
            throw e;
        }
    }

    public void write(byte[] bArr, int i, int i2) {
        try {
            super.write(bArr, i, i2);
        } catch (IOException e) {
            this.b = true;
            throw e;
        }
    }
}
