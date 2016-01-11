package com.activeandroid.d;

import java.io.InputStream;

public class j {
    private final InputStream a;
    private boolean b;
    private int c;

    public j(InputStream inputStream) {
        this.a = inputStream;
    }

    public boolean a() {
        if (!this.b) {
            this.b = true;
            this.c = this.a.read();
        }
        return this.c != -1;
    }

    public boolean a(String str) {
        if (str == null || str.length() == 0 || str.charAt(0) != this.c) {
            return false;
        }
        int length = str.length();
        this.a.mark(length - 1);
        for (int i = 1; i < length; i++) {
            if (this.a.read() != str.charAt(i)) {
                this.a.reset();
                return false;
            }
        }
        return true;
    }

    public int b() {
        if (!this.b) {
            this.c = this.a.read();
        }
        this.b = false;
        return this.c;
    }
}
