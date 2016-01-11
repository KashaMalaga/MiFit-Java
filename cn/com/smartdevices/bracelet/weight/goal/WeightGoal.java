package cn.com.smartdevices.bracelet.weight.goal;

import android.content.Context;
import cn.com.smartdevices.bracelet.j.f;
import com.activeandroid.a.a;
import com.activeandroid.a.d;
import com.activeandroid.g;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import org.json.JSONObject;

@d(a = "WeightGoals")
public class WeightGoal extends g {
    public static int GOAL_TYPE = 1;
    private static final String TAG = WeightGoal.class.getSimpleName();
    public static int WEIGHTGOAL_NEED_DELETE = -1;
    public static int WEIGHTGOAL_NEED_SYNC = 0;
    public static int WEIGHTGOAL_SYNCED = 1;
    @a(a = "CurrentVal")
    public float currentVal;
    @a(a = "DateTime")
    public long datetime;
    @a(a = "FUID")
    public int fuid;
    @a(a = "Goal")
    public float goal;
    @a(a = "GoalType")
    public int goal_type;
    @a(a = "Height")
    public int height;
    @a(a = "Synced")
    public int synced;
    @a(a = "UID")
    public long uid;

    public WeightGoal(Context context, int i, float f, float f2, int i2) {
        this.uid = cn.com.smartdevices.bracelet.e.a.f(context).uid;
        this.fuid = i;
        this.goal_type = GOAL_TYPE;
        this.currentVal = f;
        this.goal = f2;
        this.datetime = System.currentTimeMillis() / 1000;
        this.height = i2;
        this.synced = WEIGHTGOAL_NEED_SYNC;
    }

    public WeightGoal(JSONObject jSONObject) {
        this.uid = jSONObject.optLong(kankan.wheel.widget.a.n);
        this.goal_type = jSONObject.optInt("goal_type");
        this.currentVal = (float) jSONObject.optDouble("currentval");
        this.datetime = jSONObject.optLong("date_time");
        this.goal = (float) jSONObject.optDouble(cn.com.smartdevices.bracelet.gps.c.d.c);
        this.fuid = jSONObject.optInt(WidgetRequestParam.REQ_PARAM_ATTENTION_FUID);
        this.height = jSONObject.optInt(f.C);
        this.synced = WEIGHTGOAL_SYNCED;
    }
}
