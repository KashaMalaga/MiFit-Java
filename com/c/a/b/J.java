package com.c.a.b;

class J implements CharSequence {
    char[] a;

    J() {
    }

    public char charAt(int i) {
        return this.a[i];
    }

    public int length() {
        return this.a.length;
    }

    public CharSequence subSequence(int i, int i2) {
        return new String(this.a, i, i2 - i);
    }
}
