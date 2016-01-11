package cn.com.smartdevices.bracelet.model;

import android.text.TextUtils;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.dataprocess.SportDay;

public class SwitchOperator {
    public static final int SWITCH_BIND_NEW = 0;
    public static final int SWITCH_EXIT_LOGIN = 1;
    public static final int SWITCH_NONE = -1;
    public String date = a.f;
    public boolean enableClearData = false;
    public boolean enableSteps = false;
    public String lastMacAddress = a.f;
    public long lastUid = -1;
    public int steps = SWITCH_BIND_NEW;
    public int type = SWITCH_NONE;

    public boolean isValidBaseSteps() {
        return this.type > SWITCH_NONE && this.steps > 0 && !TextUtils.isEmpty(this.date) && this.date.equals(new SportDay().getKey());
    }
}
