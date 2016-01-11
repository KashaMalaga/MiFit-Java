package com.c.a;

public class A extends RuntimeException {
    static final long serialVersionUID = -4086729973971783390L;

    public A(String str) {
        super(str);
    }

    public A(String str, Throwable th) {
        super(str, th);
    }

    public A(Throwable th) {
        super(th);
    }
}
