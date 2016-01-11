package com.xiaomi.mipush.sdk;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.a.b.c;
import java.util.concurrent.ConcurrentLinkedQueue;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public class MessageHandleService extends IntentService {
    private static ConcurrentLinkedQueue<e> a = new ConcurrentLinkedQueue();

    public MessageHandleService() {
        super("MessageHandleThread");
    }

    public static void a(e eVar) {
        if (eVar != null) {
            a.add(eVar);
        }
    }

    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            e eVar = (e) a.poll();
            if (eVar != null) {
                try {
                    PushMessageReceiver a = eVar.a();
                    Intent b = eVar.b();
                    switch (b.getIntExtra(l.a, 1)) {
                        case l.a /*1*/:
                            k a2 = s.a((Context) this).a(b);
                            if (a2 == null) {
                                return;
                            }
                            if (a2 instanceof j) {
                                a.onReceiveMessage(this, (j) a2);
                                return;
                            } else if (a2 instanceof i) {
                                a.onCommandResult(this, (i) a2);
                                return;
                            } else {
                                return;
                            }
                        case a.l /*3*/:
                            a.onCommandResult(this, (i) b.getSerializableExtra(l.g));
                            return;
                        case a.aQ /*4*/:
                            return;
                        default:
                            return;
                    }
                } catch (Throwable e) {
                    c.a(e);
                }
                c.a(e);
            }
        }
    }
}
