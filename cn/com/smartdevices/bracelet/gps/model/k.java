package cn.com.smartdevices.bracelet.gps.model;

import com.xiaomi.account.openauth.h;
import com.xiaomi.mistatistic.sdk.d;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class k implements Serializable {
    private static final int e = 2;
    private static final int f = 4;
    private static final int g = 1;
    private static final int h = 1;
    private static int i = 0;
    private static int j = 0;
    private static final long serialVersionUID = 1;
    public int a;
    public int b;
    public int c;
    public Calendar d;

    static {
        i = e;
        j = f;
        if (Locale.getDefault().toString().startsWith(Locale.ENGLISH.toString())) {
            i = h;
            j = h;
        }
    }

    public k() {
        this(Calendar.getInstance());
    }

    public k(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        Calendar instance = Calendar.getInstance();
        instance.set(this.a, this.b, this.c);
        instance.setFirstDayOfWeek(i);
        instance.setMinimalDaysInFirstWeek(j);
        instance.setTimeZone(TimeZone.getTimeZone("GMT+" + (((instance.get(15) / h.E) / 60) / 60)));
        this.d = instance;
    }

    public k(k kVar) {
        this(kVar.a, kVar.b, kVar.c);
    }

    public k(Calendar calendar) {
        this.a = calendar.get(h);
        this.b = calendar.get(e);
        this.c = calendar.get(5);
        calendar.setFirstDayOfWeek(i);
        calendar.setMinimalDaysInFirstWeek(j);
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+" + (((calendar.get(15) / h.E) / 60) / 60)));
        this.d = calendar;
    }

    public int a(k kVar) {
        return this.a > kVar.a ? h : this.a < kVar.a ? -1 : this.b <= kVar.b ? this.b < kVar.b ? -1 : this.c <= kVar.c ? this.c < kVar.c ? -1 : 0 : h : h;
    }

    public Calendar a() {
        return this.d;
    }

    public boolean a(int i, int i2, int i3) {
        return this.c == i3 && this.b == i2 && this.a == i;
    }

    public boolean a(Calendar calendar) {
        return a(calendar.get(h), calendar.get(e), calendar.get(5));
    }

    public String b() {
        return toString();
    }

    public boolean b(k kVar) {
        return this.c == kVar.c && this.b == kVar.b && this.a == kVar.a;
    }

    public int c(k kVar) {
        Calendar calendar = this.d;
        Calendar calendar2 = kVar.d;
        if (this.a == kVar.a) {
            return calendar.get(6) - calendar2.get(6);
        }
        calendar = (Calendar) calendar.clone();
        calendar2 = (Calendar) calendar2.clone();
        calendar.clear(11);
        calendar.clear(12);
        calendar.clear(13);
        calendar.clear(14);
        calendar2.clear(11);
        calendar2.clear(12);
        calendar2.clear(13);
        calendar2.clear(14);
        return (int) ((calendar.getTimeInMillis() - calendar2.getTimeInMillis()) / d.h);
    }

    public long c() {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(this.a, this.b, this.c);
        return instance.getTimeInMillis();
    }

    public boolean d() {
        return c(new k()) == 0;
    }

    public boolean e() {
        return c(new k()) == -1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a).append("-");
        if (this.b + h < 10) {
            stringBuilder.append(0);
        }
        stringBuilder.append(this.b + h).append("-");
        if (this.c < 10) {
            stringBuilder.append(0);
        }
        stringBuilder.append(this.c);
        return stringBuilder.toString();
    }
}
