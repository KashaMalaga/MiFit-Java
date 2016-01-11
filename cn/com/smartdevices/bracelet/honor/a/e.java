package cn.com.smartdevices.bracelet.honor.a;

import cn.com.smartdevices.bracelet.model.ShareData;
import com.c.a.a.b;

public class e extends d {
    private static final long serialVersionUID = -1272915166517629800L;
    @b(a = "total_milestone")
    public long h;
    @b(a = "single_distance")
    public int i;

    public e() {
        this.a = ShareData.SHARE_TYPE_LAB_SITUP_ACCUMULATE;
    }

    public String toString() {
        return "RunSummary [totalMilestone=" + this.h + ", singleDistance=" + this.i + ", moudle=" + this.a + ", timeStamp=" + this.f + ", syncMark=" + this.g + "]";
    }
}
