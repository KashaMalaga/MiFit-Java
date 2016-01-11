package com.xiaomi.f.c;

public class j {
    private String a;

    public j(String str) {
        this.a = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("stream:error (").append(this.a).append(")");
        return stringBuilder.toString();
    }
}
