package com.activeandroid.d;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class i {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;

    public static List<String> a(InputStream inputStream) {
        Closeable bufferedInputStream = new BufferedInputStream(inputStream);
        List<String> arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        try {
            j jVar = new j(bufferedInputStream);
            Object obj = a;
            while (jVar.a()) {
                char b = (char) jVar.b();
                if (obj == d) {
                    if (jVar.a("*/")) {
                        obj = a;
                    }
                } else if (obj == c) {
                    if (a(b)) {
                        obj = a;
                    }
                } else if (obj == null && jVar.a("/*")) {
                    obj = d;
                } else if (obj == null && jVar.a("--")) {
                    obj = c;
                } else if (obj == null && b == ';') {
                    arrayList.add(stringBuffer.toString().trim());
                    stringBuffer.setLength(a);
                } else {
                    if (obj == null && b == '\'') {
                        obj = b;
                    } else if (obj == b && b == '\'') {
                        obj = a;
                    }
                    if (obj == null || obj == b) {
                        if (obj == null) {
                            if (b(b)) {
                                if (stringBuffer.length() > 0 && stringBuffer.charAt(stringBuffer.length() - 1) != ' ') {
                                    stringBuffer.append(' ');
                                }
                            }
                        }
                        stringBuffer.append(b);
                    }
                }
            }
            if (stringBuffer.length() > 0) {
                arrayList.add(stringBuffer.toString().trim());
            }
            return arrayList;
        } finally {
            a.a(bufferedInputStream);
        }
    }

    private static boolean a(char c) {
        return c == '\r' || c == '\n';
    }

    private static boolean b(char c) {
        return c == '\r' || c == '\n' || c == '\t' || c == ' ';
    }
}
