package com.xiaomi.h.a;

import com.xiaomi.hm.health.t;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum C1094a {
    Registration(1),
    UnRegistration(2),
    Subscription(3),
    UnSubscription(4),
    SendMessage(5),
    AckMessage(6),
    SetConfig(7),
    ReportFeedback(8),
    Notification(9),
    Command(10),
    MultiConnectionBroadcast(11),
    MultiConnectionResult(12),
    ConnectionKick(13);
    
    private final int n;

    private C1094a(int i) {
        this.n = i;
    }

    public static C1094a a(int i) {
        switch (i) {
            case l.a /*1*/:
                return Registration;
            case a.k /*2*/:
                return UnRegistration;
            case a.l /*3*/:
                return Subscription;
            case a.aQ /*4*/:
                return UnSubscription;
            case a.X /*5*/:
                return SendMessage;
            case a.bt /*6*/:
                return AckMessage;
            case a.bc /*7*/:
                return SetConfig;
            case a.ba /*8*/:
                return ReportFeedback;
            case a.bo /*9*/:
                return Notification;
            case a.bd /*10*/:
                return Command;
            case a.aW /*11*/:
                return MultiConnectionBroadcast;
            case a.be /*12*/:
                return MultiConnectionResult;
            case t.WeightView_wv_bmi_size /*13*/:
                return ConnectionKick;
            default:
                return null;
        }
    }

    public int a() {
        return this.n;
    }
}
