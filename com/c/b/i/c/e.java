package com.c.b.i.c;

import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

final class e {
    private static final int a = 3;
    private static final int b = 3;
    private static final int c = 40;
    private static final int d = 10;

    private e() {
    }

    static int a(b bVar) {
        return a(bVar, true) + a(bVar, false);
    }

    private static int a(b bVar, boolean z) {
        int a = z ? bVar.a() : bVar.b();
        int b = z ? bVar.b() : bVar.a();
        byte[][] c = bVar.c();
        int i = 0;
        int i2 = 0;
        while (i < a) {
            byte b2 = (byte) -1;
            int i3 = 0;
            int i4 = 0;
            while (i3 < b) {
                int i5;
                int i6;
                byte b3;
                byte b4 = z ? c[i][i3] : c[i3][i];
                byte b5;
                if (b4 == b2) {
                    b5 = b2;
                    i5 = i4 + 1;
                    i6 = i2;
                    b3 = b5;
                } else {
                    if (i4 >= 5) {
                        i2 += (i4 - 5) + b;
                    }
                    i5 = 1;
                    b5 = b4;
                    i6 = i2;
                    b3 = b5;
                }
                i3++;
                i4 = i5;
                b2 = b3;
                i2 = i6;
            }
            if (i4 >= 5) {
                i2 += (i4 - 5) + b;
            }
            i++;
        }
        return i2;
    }

    static boolean a(int i, int i2, int i3) {
        int i4;
        switch (i) {
            case a.i /*0*/:
                i4 = (i3 + i2) & 1;
                break;
            case l.a /*1*/:
                i4 = i3 & 1;
                break;
            case a.k /*2*/:
                i4 = i2 % b;
                break;
            case b /*3*/:
                i4 = (i3 + i2) % b;
                break;
            case a.aQ /*4*/:
                i4 = ((i3 / 2) + (i2 / b)) & 1;
                break;
            case a.X /*5*/:
                i4 = i3 * i2;
                i4 = (i4 % b) + (i4 & 1);
                break;
            case a.bt /*6*/:
                i4 = i3 * i2;
                i4 = ((i4 % b) + (i4 & 1)) & 1;
                break;
            case a.bc /*7*/:
                i4 = (((i3 * i2) % b) + ((i3 + i2) & 1)) & 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid mask pattern: " + i);
        }
        return i4 == 0;
    }

    private static boolean a(byte[] bArr, int i, int i2) {
        while (i < i2) {
            if (i >= 0 && i < bArr.length && bArr[i] == (byte) 1) {
                return false;
            }
            i++;
        }
        return true;
    }

    private static boolean a(byte[][] bArr, int i, int i2, int i3) {
        while (i2 < i3) {
            if (i2 >= 0 && i2 < bArr.length && bArr[i2][i] == (byte) 1) {
                return false;
            }
            i2++;
        }
        return true;
    }

    static int b(b bVar) {
        byte[][] c = bVar.c();
        int b = bVar.b();
        int a = bVar.a();
        int i = 0;
        int i2 = 0;
        while (i < a - 1) {
            int i3 = 0;
            while (i3 < b - 1) {
                byte b2 = c[i][i3];
                if (b2 == c[i][i3 + 1] && b2 == c[i + 1][i3] && b2 == c[i + 1][i3 + 1]) {
                    i2++;
                }
                i3++;
            }
            i++;
        }
        return i2 * b;
    }

    static int c(b bVar) {
        byte[][] c = bVar.c();
        int b = bVar.b();
        int a = bVar.a();
        int i = 0;
        int i2 = 0;
        while (i < a) {
            int i3 = 0;
            while (i3 < b) {
                byte[] bArr = c[i];
                if (i3 + 6 < b && bArr[i3] == (byte) 1 && bArr[i3 + 1] == (byte) 0 && bArr[i3 + 2] == (byte) 1 && bArr[i3 + b] == (byte) 1 && bArr[i3 + 4] == (byte) 1 && bArr[i3 + 5] == (byte) 0 && bArr[i3 + 6] == (byte) 1 && (a(bArr, i3 - 4, i3) || a(bArr, i3 + 7, i3 + 11))) {
                    i2++;
                }
                if (i + 6 < a && c[i][i3] == (byte) 1 && c[i + 1][i3] == (byte) 0 && c[i + 2][i3] == (byte) 1 && c[i + b][i3] == (byte) 1 && c[i + 4][i3] == (byte) 1 && c[i + 5][i3] == (byte) 0 && c[i + 6][i3] == (byte) 1 && (a(c, i3, i - 4, i) || a(c, i3, i + 7, i + 11))) {
                    i2++;
                }
                i3++;
            }
            i++;
        }
        return i2 * c;
    }

    static int d(b bVar) {
        int i;
        byte[][] c = bVar.c();
        int b = bVar.b();
        int a = bVar.a();
        int i2 = 0;
        for (int i3 = 0; i3 < a; i3++) {
            byte[] bArr = c[i3];
            for (i = 0; i < b; i++) {
                if (bArr[i] == (byte) 1) {
                    i2++;
                }
            }
        }
        i = bVar.a() * bVar.b();
        return ((Math.abs((i2 * 2) - i) * d) / i) * d;
    }
}
