package com.tencent.wxop.stat.a;

import com.sina.weibo.sdk.utils.AidTask;
import com.xiaomi.account.openauth.h;

public enum e {
    PAGE_VIEW(1),
    SESSION_ENV(2),
    ERROR(3),
    CUSTOM(h.E),
    ADDITION(AidTask.WHAT_LOAD_AID_SUC),
    MONITOR_STAT(AidTask.WHAT_LOAD_AID_API_ERR),
    MTA_GAME_USER(AidTask.WHAT_LOAD_AID_IO_ERR),
    NETWORK_MONITOR(1004),
    NETWORK_DETECTOR(1005);
    
    private int bG;

    private e(int i) {
        this.bG = i;
    }

    public final int r() {
        return this.bG;
    }
}
