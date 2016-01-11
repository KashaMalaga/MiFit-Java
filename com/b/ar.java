package com.b;

import com.xiaomi.e.a;
import com.xiaomi.mipush.sdk.f;
import java.util.List;

public final class ar {
    private boolean a = false;
    private String b = a.f;
    private boolean c = false;
    private double d = 0.0d;
    private double e = 0.0d;

    protected ar(List list, String str, String str2, String str3) {
        this.b = str3;
        d();
    }

    private void d() {
        int i;
        boolean z;
        String substring;
        String[] split;
        int i2 = 0;
        String str = this.b;
        if (str != null && str.length() > 8) {
            int i3 = 0;
            for (i = 1; i < str.length() - 3; i++) {
                i3 ^= str.charAt(i);
            }
            if (Integer.toHexString(i3).equalsIgnoreCase(str.substring(str.length() - 2, str.length()))) {
                z = true;
                if (z) {
                    substring = this.b.substring(0, this.b.length() - 3);
                    i = 0;
                    while (i2 < substring.length()) {
                        if (substring.charAt(i2) == ',') {
                            i++;
                        }
                        i2++;
                    }
                    split = substring.split(f.i, i + 1);
                    if (split.length < 6) {
                        if (!(split[2].equals(a.f) || split[split.length - 3].equals(a.f) || split[split.length - 2].equals(a.f) || split[split.length - 1].equals(a.f))) {
                            Integer.valueOf(split[2]).intValue();
                            this.d = Double.valueOf(split[split.length - 3]).doubleValue();
                            this.e = Double.valueOf(split[split.length - 2]).doubleValue();
                            this.c = true;
                        }
                    } else {
                        return;
                    }
                }
                this.a = this.c;
            }
        }
        z = false;
        if (z) {
            substring = this.b.substring(0, this.b.length() - 3);
            i = 0;
            while (i2 < substring.length()) {
                if (substring.charAt(i2) == ',') {
                    i++;
                }
                i2++;
            }
            split = substring.split(f.i, i + 1);
            if (split.length < 6) {
                Integer.valueOf(split[2]).intValue();
                this.d = Double.valueOf(split[split.length - 3]).doubleValue();
                this.e = Double.valueOf(split[split.length - 2]).doubleValue();
                this.c = true;
            } else {
                return;
            }
        }
        this.a = this.c;
    }

    protected final boolean a() {
        return this.a;
    }

    protected final double b() {
        return this.d;
    }

    protected final double c() {
        return this.e;
    }
}
