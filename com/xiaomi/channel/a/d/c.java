package com.xiaomi.channel.a.d;

import java.util.Map;

public class c {
    public int a;
    public Map<String, String> b;

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s", new Object[]{Integer.valueOf(this.a), this.b.toString()});
    }
}
