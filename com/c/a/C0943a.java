package com.c.a;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

final class C0943a implements E<Date>, v<Date> {
    private final DateFormat a;
    private final DateFormat b;
    private final DateFormat c;

    C0943a() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    C0943a(int i) {
        this(DateFormat.getDateInstance(i, Locale.US), DateFormat.getDateInstance(i));
    }

    public C0943a(int i, int i2) {
        this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    C0943a(String str) {
        this(new SimpleDateFormat(str, Locale.US), new SimpleDateFormat(str));
    }

    C0943a(DateFormat dateFormat, DateFormat dateFormat2) {
        this.a = dateFormat;
        this.b = dateFormat2;
        this.c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        this.c.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    private Date a(w wVar) {
        Date parse;
        synchronized (this.b) {
            try {
                parse = this.b.parse(wVar.d());
            } catch (ParseException e) {
                try {
                    parse = this.a.parse(wVar.d());
                } catch (ParseException e2) {
                    try {
                        parse = this.c.parse(wVar.d());
                    } catch (Throwable e3) {
                        throw new G(wVar.d(), e3);
                    }
                }
            }
        }
        return parse;
    }

    public w a(Date date, Type type, D d) {
        w c;
        synchronized (this.b) {
            c = new C(this.a.format(date));
        }
        return c;
    }

    public Date a(w wVar, Type type, u uVar) {
        if (wVar instanceof C) {
            Date a = a(wVar);
            if (type == Date.class) {
                return a;
            }
            if (type == Timestamp.class) {
                return new Timestamp(a.getTime());
            }
            if (type == java.sql.Date.class) {
                return new java.sql.Date(a.getTime());
            }
            throw new IllegalArgumentException(getClass() + " cannot deserialize to " + type);
        }
        throw new A("The date should be a string value");
    }

    public /* synthetic */ Object b(w wVar, Type type, u uVar) {
        return a(wVar, type, uVar);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C0943a.class.getSimpleName());
        stringBuilder.append('(').append(this.b.getClass().getSimpleName()).append(')');
        return stringBuilder.toString();
    }
}
