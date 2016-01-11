package com.activeandroid.d;

import java.util.Comparator;

public class c implements Comparator<Object> {
    static char a(String str, int i) {
        return i >= str.length() ? '\u0000' : str.charAt(i);
    }

    int a(String str, String str2) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            char a = a(str, i2);
            char a2 = a(str2, i);
            if (!Character.isDigit(a) && !Character.isDigit(a2)) {
                return i3;
            }
            if (!Character.isDigit(a)) {
                return -1;
            }
            if (!Character.isDigit(a2)) {
                return 1;
            }
            if (a < a2) {
                if (i3 == 0) {
                    i3 = -1;
                }
            } else if (a > a2) {
                if (i3 == 0) {
                    i3 = 1;
                }
            } else if (a == '\u0000' && a2 == '\u0000') {
                return i3;
            }
            i2++;
            i++;
        }
    }

    public int compare(Object obj, Object obj2) {
        String obj3 = obj.toString();
        String obj4 = obj2.toString();
        int i = 0;
        int i2 = 0;
        while (true) {
            char a = a(obj3, i2);
            char a2 = a(obj4, i);
            int i3 = i2;
            char c = a;
            int i4 = 0;
            while (true) {
                if (!Character.isSpaceChar(c) && c != '0') {
                    break;
                }
                i4 = c == '0' ? i4 + 1 : 0;
                i3++;
                c = a(obj3, i3);
            }
            int i5 = i;
            char c2 = a2;
            int i6 = 0;
            while (true) {
                if (!Character.isSpaceChar(c2) && c2 != '0') {
                    break;
                }
                i6 = c2 == '0' ? i6 + 1 : 0;
                i5++;
                c2 = a(obj4, i5);
            }
            if (Character.isDigit(c) && Character.isDigit(c2)) {
                int a3 = a(obj3.substring(i3), obj4.substring(i5));
                if (a3 != 0) {
                    return a3;
                }
            }
            if (c == '\u0000' && c2 == '\u0000') {
                return i4 - i6;
            }
            if (c < c2) {
                return -1;
            }
            if (c > c2) {
                return 1;
            }
            i2 = i3 + 1;
            i = i5 + 1;
        }
    }
}
