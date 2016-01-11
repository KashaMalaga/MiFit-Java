package com.c.b.c;

import com.d.a.a.h;
import java.util.HashMap;
import java.util.Map;
import kankan.wheel.widget.a;

public enum d {
    Cp437((String) new int[]{0, 2}, (int) new String[0]),
    ISO8859_1((String) new int[]{1, 3}, (int) new String[]{"ISO-8859-1"}),
    ISO8859_2((String) 4, (int) new String[]{"ISO-8859-2"}),
    ISO8859_3((String) 5, (int) new String[]{"ISO-8859-3"}),
    ISO8859_4((String) 6, (int) new String[]{"ISO-8859-4"}),
    ISO8859_5((String) 7, (int) new String[]{"ISO-8859-5"}),
    ISO8859_6((String) 8, (int) new String[]{"ISO-8859-6"}),
    ISO8859_7((String) 9, (int) new String[]{"ISO-8859-7"}),
    ISO8859_8((String) 10, (int) new String[]{"ISO-8859-8"}),
    ISO8859_9((String) 11, (int) new String[]{"ISO-8859-9"}),
    ISO8859_10((String) 12, (int) new String[]{"ISO-8859-10"}),
    ISO8859_11((String) 13, (int) new String[]{"ISO-8859-11"}),
    ISO8859_13((String) 15, (int) new String[]{"ISO-8859-13"}),
    ISO8859_14((String) 16, (int) new String[]{"ISO-8859-14"}),
    ISO8859_15((String) 17, (int) new String[]{"ISO-8859-15"}),
    ISO8859_16((String) 18, (int) new String[]{"ISO-8859-16"}),
    SJIS((String) 20, (int) new String[]{"Shift_JIS"}),
    Cp1250((String) 21, (int) new String[]{"windows-1250"}),
    Cp1251((String) 22, (int) new String[]{"windows-1251"}),
    Cp1252((String) 23, (int) new String[]{"windows-1252"}),
    Cp1256((String) 24, (int) new String[]{"windows-1256"}),
    UnicodeBigUnmarked((String) 25, (int) new String[]{"UTF-16BE", "UnicodeBig"}),
    UTF8((String) 26, (int) new String[]{h.DEFAULT_CHARSET}),
    ASCII((String) new int[]{27, a.aC}, (int) new String[]{"US-ASCII"}),
    Big5(28),
    GB18030((String) 29, (int) new String[]{l.b, "EUC_CN", "GBK"}),
    EUC_KR((String) 30, (int) new String[]{"EUC-KR"});
    
    private static final Map<Integer, d> B = null;
    private static final Map<String, d> C = null;
    private final int[] D;
    private final String[] E;

    static {
        B = new HashMap();
        C = new HashMap();
        for (d dVar : values()) {
            for (int valueOf : dVar.D) {
                B.put(Integer.valueOf(valueOf), dVar);
            }
            C.put(dVar.name(), dVar);
            for (Object put : dVar.E) {
                C.put(put, dVar);
            }
        }
    }

    private d(int i) {
        this(r3, r4, new int[]{i}, new String[0]);
    }

    private d(int i, String... strArr) {
        this.D = new int[]{i};
        this.E = strArr;
    }

    private d(int[] iArr, String... strArr) {
        this.D = iArr;
        this.E = strArr;
    }

    public static d a(int i) {
        if (i >= 0 && i < 900) {
            return (d) B.get(Integer.valueOf(i));
        }
        throw com.c.b.h.a();
    }

    public static d a(String str) {
        return (d) C.get(str);
    }

    public int a() {
        return this.D[0];
    }
}
