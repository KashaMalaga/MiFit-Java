package cn.com.smartdevices.bracelet.shoes.sync.c;

import android.text.TextUtils;
import com.xiaomi.account.openauth.h;
import com.xiaomi.hm.health.dataprocess.SportDay;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class b {
    private b() {
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis((long) (Integer.valueOf(str).intValue() * h.E));
        return new SportDay(instance).getKey();
    }

    public static List<String> a(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException();
        }
        int size = list.size();
        if (size == 0) {
            return new ArrayList(0);
        }
        List<String> arrayList = new ArrayList(size);
        Calendar instance = Calendar.getInstance();
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                instance.setTimeInMillis(Long.valueOf(str).longValue() * 1000);
                arrayList.add(new SportDay(instance).getKey());
            }
        }
        return arrayList.size() <= 0 ? new ArrayList(0) : arrayList;
    }
}
