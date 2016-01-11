package com.b;

class O {
    private M a = null;
    private String b = null;

    protected O() {
    }

    public M a() {
        return this.a;
    }

    public void a(M m) {
        this.a = m;
    }

    public void a(String str) {
        this.b = str.replace("##", "#");
    }

    public String b() {
        return this.b;
    }
}
