package com.xiaomi.d.a;

import com.xiaomi.channel.a.b.c;
import com.xiaomi.f.p;
import java.util.Date;

class e implements p {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    public void a() {
        c.b("SMACK " + this.a.b.format(new Date()) + " Connection reconnected (" + this.a.c.hashCode() + ")");
    }

    public void a(int i, Exception exception) {
        c.b("SMACK " + this.a.b.format(new Date()) + " Connection closed (" + this.a.c.hashCode() + ")");
    }

    public void a(Exception exception) {
        c.b("SMACK " + this.a.b.format(new Date()) + " Reconnection failed due to an exception (" + this.a.c.hashCode() + ")");
        exception.printStackTrace();
    }

    public void b() {
        c.b("SMACK " + this.a.b.format(new Date()) + " Connection started (" + this.a.c.hashCode() + ")");
    }
}
