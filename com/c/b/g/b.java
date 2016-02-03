package com.c.b.g;

public final class b extends r {
    private static final char[] a = new char[]{'A', 'B', 'C', 'D'};
    private static final char[] b = new char[]{'T', 'N', '*', 'E'};
    private static final char[] c = new char[]{'/', ':', '+', '.'};
    private static final char d = a[0];

    public boolean[] a(String str) {
        if (str.length() < 2) {
            str = d + str + d;
        } else {
            char toUpperCase = Character.toUpperCase(str.charAt(0));
            char toUpperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            boolean a = a.a(a, toUpperCase);
            boolean a2 = a.a(a, toUpperCase2);
            boolean a3 = a.a(b, toUpperCase);
            boolean a4 = a.a(b, toUpperCase2);
            if (a) {
                if (!a2) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
            } else if (a3) {
                if (!a4) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
            } else if (a2 || a4) {
                throw new IllegalArgumentException("Invalid start/end guards: " + str);
            } else {
                str = d + str + d;
            }
        }
        int i = 20;
        int i2 = 1;
        while (i2 < str.length() - 1) {
            if (Character.isDigit(str.charAt(i2)) || str.charAt(i2) == '-' || str.charAt(i2) == '$') {
                i += 9;
            } else if (a.a(c, str.charAt(i2))) {
                i += 10;
            } else {
                throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i2) + '\'');
            }
            i2++;
        }
        boolean[] zArr = new boolean[((str.length() - 1) + i)];
        i2 = 0;
        i = 0;
        while (i2 < str.length()) {
            int i3;
            int i4;
            boolean z;
            int i5;
            char toUpperCase3 = Character.toUpperCase(str.charAt(i2));
            if (i2 == 0 || i2 == str.length() - 1) {
                switch (toUpperCase3) {
                    case '*':
                        toUpperCase3 = 'C';
                        break;
                    case 'E':
                        toUpperCase3 = 'D';
                        break;
                    case 'N':
                        toUpperCase3 = 'B';
                        break;
                    case 'T':
                        toUpperCase3 = 'A';
                        break;
                }
            }
            int i6 = 0;
            while (i6 < a.a.length) {
                if (toUpperCase3 == a.a[i6]) {
                    i3 = a.b[i6];
                    i6 = 0;
                    i4 = 0;
                    z = true;
                    while (i6 < 7) {
                        zArr[i] = z;
                        i5 = i + 1;
                        if (((i3 >> (6 - i6)) & 1) != 0 || i4 == 1) {
                            i6++;
                            i4 = 0;
                            z = z;
                            i = i5;
                        } else {
                            i4++;
                            i = i5;
                        }
                    }
                    if (i2 < str.length() - 1) {
                        zArr[i] = false;
                        i++;
                    }
                    i2++;
                } else {
                    i6++;
                }
            }
            i3 = 0;
            i6 = 0;
            i4 = 0;
            z = true;
            while (i6 < 7) {
                zArr[i] = z;
                i5 = i + 1;
                if (((i3 >> (6 - i6)) & 1) != 0) {
                }
                if (z) {
                }
                i6++;
                i4 = 0;
                z = z;
                i = i5;
            }
            if (i2 < str.length() - 1) {
                zArr[i] = false;
                i++;
            }
            i2++;
        }
        return zArr;
    }
}
