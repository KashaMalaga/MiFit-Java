package cn.com.smartdevices.bracelet.model;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Birthday {
    private static final String TAG = "Birthday";
    private int day = -1;
    private int month = -1;
    private int year = -1;

    public static Birthday fromStr(String str) {
        Birthday birthday = new Birthday();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("-");
            try {
                if (split.length > 0) {
                    birthday.setYear(Integer.valueOf(split[0]).intValue());
                }
                if (split.length > 1) {
                    birthday.setMonth(Integer.valueOf(split[1]).intValue());
                }
                if (split.length > 2) {
                    birthday.setDay(Integer.valueOf(split[2]).intValue());
                }
            } catch (Exception e) {
                C0596r.e(TAG, e.toString());
            }
        }
        return birthday;
    }

    public int getAge() {
        return this.year == -1 ? -1 : Calendar.getInstance().get(1) - this.year;
    }

    public int getAgeInMonths() {
        int year = getYear();
        int month = getMonth();
        int i = Calendar.getInstance().get(1);
        int i2 = Calendar.getInstance().get(2) + 1;
        C0596r.e(TAG, "year " + year + " month " + month + " current_year " + i + " current_month " + i2);
        year = i >= year ? (((i - year) * 12) + i2) - month : 0;
        C0596r.e(TAG, "months " + year);
        return year <= 0 ? 0 : year;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public boolean isValid() {
        return this.year > 0 && this.month > 0;
    }

    public void setDay(int i) {
        this.day = i;
    }

    public void setMonth(int i) {
        this.month = i;
    }

    public void setYear(int i) {
        this.year = i;
    }

    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(BraceletApp.a().getResources().getString(R.string.date_year_month));
        Calendar instance = Calendar.getInstance();
        instance.set(this.year, this.month - 1, 1);
        return simpleDateFormat.format(new Date(instance.getTimeInMillis()));
    }

    public String toStringData() {
        return this.year + "-" + this.month;
    }
}
