package cn.com.smartdevices.bracelet.lab.ui;

import android.content.Context;
import android.content.res.Resources;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.b.b;
import cn.com.smartdevices.bracelet.g.c;
import cn.com.smartdevices.bracelet.g.f;
import cn.com.smartdevices.bracelet.g.g;
import cn.com.smartdevices.bracelet.lab.b.d;
import cn.com.smartdevices.bracelet.model.ShareData;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.i;
import com.xiaomi.hm.health.r;
import java.util.List;

public class C0590z {
    private static final String d = "->";
    private Context a = null;
    private int b = -1;
    private c c = null;

    public C0590z(Context context, int i) {
        this.a = context;
        this.b = i;
        if (this.b == 1) {
            this.c = new f();
        } else if (this.b == 2) {
            this.c = new g();
        }
    }

    private int a(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        int i = 0;
        for (Integer num : list) {
            if (num.intValue() > i) {
                i = num.intValue();
            }
        }
        return i;
    }

    private String a(Context context, int i) {
        return 1 == i ? context.getString(r.lab_factory_sport_type_ropeskipping) : 2 == i ? context.getString(r.lab_factory_sport_type_situp) : a.f;
    }

    public ShareData a(int i, List<Integer> list, String str) {
        Object obj = null;
        ShareData shareData = new ShareData();
        int a = list == null ? 0 : a(list);
        if (i < a) {
            obj = 1;
        }
        Resources resources = this.a.getResources();
        if (obj != null) {
            if (this.b == 1) {
                shareData.setType(100);
                shareData.title = this.a.getString(r.sport_new_record_ropeskipping);
            } else if (this.b == 2) {
                shareData.setType(ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD);
                shareData.title = this.a.getString(r.lab_factory_sport_share_info_new_record);
            }
            shareData.color = resources.getColor(i.lab_record_broken_bg);
        } else if (this.b == 1) {
            shareData.setType(ShareData.SHARE_TYPE_LAB_ROPE_SKIPPING_ACCUMULATE);
            shareData.title = this.a.getString(r.lab_factory_sport_continuous_ropeskipping);
            shareData.color = resources.getColor(i.lab_ropeskipping_bg);
        } else if (this.b == 2) {
            shareData.setType(ShareData.SHARE_TYPE_LAB_SITUP_ACCUMULATE);
            shareData.title = this.a.getString(r.lab_factory_sport_continuous_situp);
            shareData.color = resources.getColor(i.lab_situp_bg);
        } else {
            shareData.color = resources.getColor(i.lab_record_broken_bg);
        }
        shareData.contentUnit = this.a.getString(r.lab_factory_sport_unit);
        shareData.description = str;
        shareData.time = a(this.a, this.b);
        shareData.content = String.valueOf(a);
        shareData.ranking = this.c.a(this.a, a);
        return shareData;
    }

    public String a(int i, long j) {
        float a;
        String a2 = cn.com.smartdevices.bracelet.lab.b.f.a(this.a, j);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            a = b.a(this.b).a(i, j);
        } catch (IllegalArgumentException e) {
            C0596r.e("Lab", e.getMessage());
            a = 0.0f;
        }
        if (i > 0) {
            stringBuilder.append(this.a.getString(r.lab_factory_sport_accumulate, new Object[]{Integer.valueOf(i)})).append("\n").append(this.a.getString(r.lab_factory_sport_share_info_accumulated_time_once)).append(a2).append(this.a.getString(r.lab_factory_sport_result_dot)).append(this.a.getString(r.lab_factory_sport_result_cost_cal, new Object[]{Integer.valueOf((int) a)}));
        } else {
            int a3 = d.a(i, j);
            stringBuilder.append(this.a.getString(r.lab_factory_sport_share_info_accumulated_time_once)).append(a2).append(this.a.getString(r.lab_factory_sport_result_dot)).append(this.a.getString(r.lab_factory_sport_result_cost_cal, new Object[]{Integer.valueOf((int) a)})).append("\n").append(this.a.getString(r.lab_factory_sport_steps_converted, new Object[]{Integer.valueOf(a3)}));
        }
        return stringBuilder.toString();
    }
}
