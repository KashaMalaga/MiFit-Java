package com.xiaomi.push.a;

public class a implements com.xiaomi.channel.a.b.a {
    private com.xiaomi.channel.a.b.a a = null;
    private com.xiaomi.channel.a.b.a b = null;

    public a(com.xiaomi.channel.a.b.a aVar, com.xiaomi.channel.a.b.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    public void a(String str) {
    }

    public void a(String str, Throwable th) {
        if (this.a != null) {
            this.a.a(str, th);
        }
        if (this.b != null) {
            this.b.a(str, th);
        }
    }

    public void b(String str) {
        if (this.a != null) {
            this.a.b(str);
        }
        if (this.b != null) {
            this.b.b(str);
        }
    }
}
