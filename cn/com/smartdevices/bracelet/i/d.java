package cn.com.smartdevices.bracelet.i;

import cn.com.smartdevices.bracelet.i.a.b;

public abstract class d<Params> extends b {
    private static final int ORDER_AFTER = 17;
    private static final int ORDER_AFTER_FAILURE = 16;
    private static final int ORDER_AFTER_SUCCESS = 1;
    protected Params mWorkParams;

    public d(Params params) {
        this.mWorkParams = params;
    }

    public abstract String tag();

    public abstract void work();
}
