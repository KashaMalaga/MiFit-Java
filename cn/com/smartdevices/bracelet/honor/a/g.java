package cn.com.smartdevices.bracelet.honor.a;

import cn.com.smartdevices.bracelet.model.ShareData;
import com.c.a.a.b;

public class g extends d {
    private static final long serialVersionUID = -3410979155129659207L;
    @b(a = "sleep_start")
    public long h;
    @b(a = "etb_mark")
    public int i;
    @b(a = "etb_days")
    public int j;

    public g() {
        this.a = ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD;
    }

    public String toString() {
        return "SleepSummary [sleepStart=" + this.h + ", etbMark=" + this.i + ", etbDays=" + this.j + ", moudle=" + this.a + ", timeStamp=" + this.f + ", syncMark=" + this.g + "]";
    }
}
