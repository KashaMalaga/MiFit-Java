package cn.com.smartdevices.bracelet.honor.a;

import cn.com.smartdevices.bracelet.model.ShareData;
import com.c.a.a.b;

public class h extends d {
    private static final long serialVersionUID = 7545581074321022810L;
    @b(a = "total_step")
    public long h;
    @b(a = "current_step")
    public int i;
    @b(a = "step_goal")
    public int j;
    @b(a = "step_goal_mark")
    public int k;
    @b(a = "step_goal_days")
    public int l;

    public h() {
        this.a = ShareData.SHARE_TYPE_LAB_ROPE_SKIPPING_ACCUMULATE;
    }

    public String toString() {
        return "StepSummary [totalStep=" + this.h + ", currentStep=" + this.i + ", stepGoal=" + this.j + ", stepGoalMark=" + this.k + ", stepGoalDays=" + this.l + ", moudle=" + this.a + ", timeStamp=" + this.f + ", syncMark=" + this.g + "]";
    }
}
