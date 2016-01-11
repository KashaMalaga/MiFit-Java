package com.c.b.d.c;

import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

final class b implements g {
    b() {
    }

    private static char a(char c, int i) {
        int i2 = (((i * 149) % HeartRateInfo.HR_EMPTY_VALUE) + 1) + c;
        return i2 <= HeartRateInfo.HR_EMPTY_VALUE ? (char) i2 : (char) (i2 - 256);
    }

    public int a() {
        return 5;
    }

    public void a(h hVar) {
        int a;
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\u0000');
        while (hVar.h()) {
            stringBuilder.append(hVar.b());
            hVar.a++;
            a = j.a(hVar.a(), hVar.a, a());
            if (a != a()) {
                hVar.b(a);
                break;
            }
        }
        int length = stringBuilder.length() - 1;
        a = (hVar.e() + length) + 1;
        hVar.c(a);
        a = hVar.j().i() - a > 0 ? 1 : 0;
        if (hVar.h() || a != 0) {
            if (length <= 249) {
                stringBuilder.setCharAt(0, (char) length);
            } else if (length <= 249 || length > 1555) {
                throw new IllegalStateException("Message length not in valid ranges: " + length);
            } else {
                stringBuilder.setCharAt(0, (char) ((length / 250) + 249));
                stringBuilder.insert(1, (char) (length % 250));
            }
        }
        a = stringBuilder.length();
        while (i < a) {
            hVar.a(a(stringBuilder.charAt(i), hVar.e() + 1));
            i++;
        }
    }
}
