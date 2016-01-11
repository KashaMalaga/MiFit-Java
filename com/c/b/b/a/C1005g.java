package com.c.b.b.a;

import cn.com.smartdevices.bracelet.d.C0429f;
import com.g.a.p;
import com.xiaomi.mistatistic.sdk.d;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class C1005g extends q {
    private static final Pattern a = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");
    private static final long[] b = new long[]{C0429f.c, d.h, p.n, d.g, 1000};
    private static final Pattern c = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");
    private final String d;
    private final Date e;
    private final boolean f;
    private final Date g;
    private final boolean h;
    private final String i;
    private final String j;
    private final String[] k;
    private final String l;
    private final double m;
    private final double n;

    public C1005g(String str, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, double d, double d2) {
        super(r.CALENDAR);
        this.d = str;
        try {
            this.e = C1005g.a(str2);
            if (str3 == null) {
                long a = C1005g.a((CharSequence) str4);
                this.g = a < 0 ? null : new Date(a + this.e.getTime());
            } else {
                try {
                    this.g = C1005g.a(str3);
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e.toString());
                }
            }
            this.f = str2.length() == 8;
            boolean z = str3 != null && str3.length() == 8;
            this.h = z;
            this.i = str5;
            this.j = str6;
            this.k = strArr;
            this.l = str7;
            this.m = d;
            this.n = d2;
        } catch (ParseException e2) {
            throw new IllegalArgumentException(e2.toString());
        }
    }

    private static long a(CharSequence charSequence) {
        long j = -1;
        if (charSequence != null) {
            Matcher matcher = a.matcher(charSequence);
            if (matcher.matches()) {
                j = 0;
                for (int i = 0; i < b.length; i++) {
                    String group = matcher.group(i + 1);
                    if (group != null) {
                        j += ((long) Integer.parseInt(group)) * b[i];
                    }
                }
            }
        }
        return j;
    }

    private static String a(boolean z, Date date) {
        if (date == null) {
            return null;
        }
        return (z ? DateFormat.getDateInstance(2) : DateFormat.getDateTimeInstance(2, 2)).format(date);
    }

    private static Date a(String str) {
        if (!c.matcher(str).matches()) {
            throw new ParseException(str, 0);
        } else if (str.length() == 8) {
            return C1005g.l().parse(str);
        } else {
            if (str.length() != 16 || str.charAt(15) != 'Z') {
                return C1005g.m().parse(str);
            }
            Date parse = C1005g.m().parse(str.substring(0, 15));
            Calendar gregorianCalendar = new GregorianCalendar();
            long time = parse.getTime() + ((long) gregorianCalendar.get(15));
            gregorianCalendar.setTime(new Date(time));
            return new Date(time + ((long) gregorianCalendar.get(16)));
        }
    }

    private static DateFormat l() {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    private static DateFormat m() {
        return new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH);
    }

    public String a() {
        return this.d;
    }

    public Date b() {
        return this.e;
    }

    public boolean c() {
        return this.f;
    }

    public Date d() {
        return this.g;
    }

    public boolean e() {
        return this.h;
    }

    public String f() {
        return this.i;
    }

    public String g() {
        return this.j;
    }

    public String[] h() {
        return this.k;
    }

    public String i() {
        return this.l;
    }

    public double j() {
        return this.m;
    }

    public double k() {
        return this.n;
    }

    public String q() {
        StringBuilder stringBuilder = new StringBuilder(100);
        q.a(this.d, stringBuilder);
        q.a(C1005g.a(this.f, this.e), stringBuilder);
        q.a(C1005g.a(this.h, this.g), stringBuilder);
        q.a(this.i, stringBuilder);
        q.a(this.j, stringBuilder);
        q.a(this.k, stringBuilder);
        q.a(this.l, stringBuilder);
        return stringBuilder.toString();
    }
}
