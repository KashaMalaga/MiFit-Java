package cn.com.smartdevices.bracelet.eventbus;

import com.xiaomi.e.a;

public class EventServiceStateChanged {
    public static final int AUTHORIZATION = 0;
    public static final int DEAUTHORIZATION = 1;
    public int action = AUTHORIZATION;
    public boolean success = false;
    public String thirdAppId = a.f;
    public String url = a.f;

    public EventServiceStateChanged(int i, String str) {
        this.action = i;
        this.url = str;
    }
}
