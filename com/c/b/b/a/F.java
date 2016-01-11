package com.c.b.b.a;

import cn.com.smartdevices.bracelet.ui.C0812l;
import com.a.a.a.C0910s;
import com.c.b.s;
import com.d.a.a.h;
import com.huami.android.zxing.y;
import com.xiaomi.hm.health.t;
import com.xiaomi.mipush.sdk.f;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kankan.wheel.widget.a;

public final class F extends u {
    private static final Pattern a = Pattern.compile("BEGIN:VCARD", 2);
    private static final Pattern b = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");
    private static final Pattern c = Pattern.compile("\r\n[ \t]");
    private static final Pattern d = Pattern.compile("\\\\[nN]");
    private static final Pattern e = Pattern.compile("\\\\([,;\\\\])");
    private static final Pattern f = Pattern.compile("=");
    private static final Pattern g = Pattern.compile(";");
    private static final Pattern h = Pattern.compile("(?<!\\\\);+");
    private static final Pattern i = Pattern.compile(f.i);
    private static final Pattern j = Pattern.compile("[;,]");

    private static String a(CharSequence charSequence, String str) {
        int length = charSequence.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            switch (charAt) {
                case a.bd /*10*/:
                case t.WeightView_wv_bmi_size /*13*/:
                    break;
                case '=':
                    if (i >= length - 2) {
                        break;
                    }
                    charAt = charSequence.charAt(i + 1);
                    if (!(charAt == '\r' || charAt == '\n')) {
                        char charAt2 = charSequence.charAt(i + 2);
                        int a = u.a(charAt);
                        int a2 = u.a(charAt2);
                        if (a >= 0 && a2 >= 0) {
                            byteArrayOutputStream.write((a << 4) + a2);
                        }
                        i += 2;
                        break;
                    }
                default:
                    a(byteArrayOutputStream, str, stringBuilder);
                    stringBuilder.append(charAt);
                    break;
            }
            i++;
        }
        a(byteArrayOutputStream, str, stringBuilder);
        return stringBuilder.toString();
    }

    private static String a(List<String> list) {
        return (list == null || list.isEmpty()) ? null : (String) list.get(0);
    }

    static List<List<String>> a(CharSequence charSequence, String str, boolean z, boolean z2) {
        List<List<String>> list = null;
        int i = 0;
        int length = str.length();
        while (i < length) {
            Matcher matcher = Pattern.compile("(?:^|\n)" + charSequence + "(?:;([^:]*))?:", 2).matcher(str);
            if (i > 0) {
                i--;
            }
            if (!matcher.find(i)) {
                break;
            }
            String str2;
            List list2;
            int end = matcher.end(0);
            CharSequence group = matcher.group(1);
            List list3 = null;
            Object obj = null;
            String str3 = null;
            if (group != null) {
                String[] split = g.split(group);
                int length2 = split.length;
                int i2 = 0;
                while (i2 < length2) {
                    Object obj2;
                    group = split[i2];
                    if (list3 == null) {
                        list3 = new ArrayList(1);
                    }
                    list3.add(group);
                    String[] split2 = f.split(group, 2);
                    if (split2.length > 1) {
                        String str4 = split2[0];
                        str2 = split2[1];
                        if ("ENCODING".equalsIgnoreCase(str4) && "QUOTED-PRINTABLE".equalsIgnoreCase(str2)) {
                            obj2 = 1;
                            i2++;
                            obj = obj2;
                        } else if ("CHARSET".equalsIgnoreCase(str4)) {
                            str3 = str2;
                            obj2 = obj;
                            i2++;
                            obj = obj2;
                        }
                    }
                    obj2 = obj;
                    i2++;
                    obj = obj2;
                }
                str2 = str3;
                list2 = list3;
            } else {
                str2 = null;
                list2 = null;
            }
            i = end;
            while (true) {
                i = str.indexOf(10, i);
                if (i < 0) {
                    break;
                } else if (i >= str.length() - 1 || (str.charAt(i + 1) != ' ' && str.charAt(i + 1) != '\t')) {
                    if (obj == null || ((i < 1 || str.charAt(i - 1) != '=') && (i < 2 || str.charAt(i - 2) != '='))) {
                        break;
                    }
                    i++;
                } else {
                    i += 2;
                }
            }
            if (i < 0) {
                i = length;
            } else if (i > end) {
                Object a;
                List<List<String>> arrayList = list == null ? new ArrayList(1) : list;
                if (i >= 1 && str.charAt(i - 1) == '\r') {
                    i--;
                }
                CharSequence substring = str.substring(end, i);
                if (z) {
                    substring = substring.trim();
                }
                if (obj != null) {
                    a = a(substring, str2);
                    if (z2) {
                        a = h.matcher(a).replaceAll("\n").trim();
                    }
                } else {
                    if (z2) {
                        substring = h.matcher(substring).replaceAll("\n").trim();
                    }
                    a = e.matcher(d.matcher(c.matcher(substring).replaceAll(com.xiaomi.e.a.f)).replaceAll("\n")).replaceAll("$1");
                }
                if (list2 == null) {
                    List arrayList2 = new ArrayList(1);
                    arrayList2.add(a);
                    arrayList.add(arrayList2);
                } else {
                    list2.add(0, a);
                    arrayList.add(list2);
                }
                i++;
                list = arrayList;
            } else {
                i++;
            }
        }
        return list;
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder stringBuilder) {
        if (byteArrayOutputStream.size() > 0) {
            String str2;
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new String(toByteArray, Charset.forName(h.DEFAULT_CHARSET));
            } else {
                try {
                    str2 = new String(toByteArray, str);
                } catch (UnsupportedEncodingException e) {
                    str2 = new String(toByteArray, Charset.forName(h.DEFAULT_CHARSET));
                }
            }
            byteArrayOutputStream.reset();
            stringBuilder.append(str2);
        }
    }

    private static void a(Iterable<List<String>> iterable) {
        if (iterable != null) {
            for (List list : iterable) {
                String str = (String) list.get(0);
                String[] strArr = new String[5];
                int i = 0;
                int i2 = 0;
                while (i < strArr.length - 1) {
                    int indexOf = str.indexOf(59, i2);
                    if (indexOf < 0) {
                        break;
                    }
                    strArr[i] = str.substring(i2, indexOf);
                    i++;
                    i2 = indexOf + 1;
                }
                strArr[i] = str.substring(i2);
                StringBuilder stringBuilder = new StringBuilder(100);
                a(strArr, 3, stringBuilder);
                a(strArr, 1, stringBuilder);
                a(strArr, 2, stringBuilder);
                a(strArr, 0, stringBuilder);
                a(strArr, 4, stringBuilder);
                list.set(0, stringBuilder.toString().trim());
            }
        }
    }

    private static void a(String[] strArr, int i, StringBuilder stringBuilder) {
        if (strArr[i] != null && !strArr[i].isEmpty()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(strArr[i]);
        }
    }

    private static boolean a(CharSequence charSequence) {
        return charSequence == null || b.matcher(charSequence).matches();
    }

    private static String[] a(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        List arrayList = new ArrayList(collection.size());
        for (List list : collection) {
            String str = (String) list.get(0);
            if (!(str == null || str.isEmpty())) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[collection.size()]);
    }

    static List<String> b(CharSequence charSequence, String str, boolean z, boolean z2) {
        List a = a(charSequence, str, z, z2);
        return (a == null || a.isEmpty()) ? null : (List) a.get(0);
    }

    private static String[] b(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        List arrayList = new ArrayList(collection.size());
        for (List list : collection) {
            Object obj;
            int i = 1;
            while (i < list.size()) {
                obj = (String) list.get(i);
                int indexOf = obj.indexOf(61);
                if (indexOf < 0) {
                    break;
                } else if (y.c.equalsIgnoreCase(obj.substring(0, indexOf))) {
                    obj = obj.substring(indexOf + 1);
                    break;
                } else {
                    i++;
                }
            }
            obj = null;
            arrayList.add(obj);
        }
        return (String[]) arrayList.toArray(new String[collection.size()]);
    }

    public C1002d a(s sVar) {
        String c = u.c(sVar);
        Matcher matcher = a.matcher(c);
        if (!matcher.find() || matcher.start() != 0) {
            return null;
        }
        List a = a("FN", c, true, false);
        if (a == null) {
            a = a(C0910s.c, c, true, false);
            a((Iterable) a);
        }
        Collection collection = a;
        a = b("NICKNAME", c, true, false);
        String[] split = a == null ? null : i.split((CharSequence) a.get(0));
        Collection a2 = a("TEL", c, true, false);
        Collection a3 = a("EMAIL", c, true, false);
        List b = b("NOTE", c, false, false);
        Collection a4 = a("ADR", c, true, true);
        List b2 = b("ORG", c, true, true);
        List b3 = b("BDAY", c, true, false);
        List list = (b3 == null || a((CharSequence) b3.get(0))) ? b3 : null;
        List b4 = b(C0812l.a, c, true, false);
        Collection a5 = a("URL", c, true, false);
        List b5 = b("IMPP", c, true, false);
        a = b("GEO", c, true, false);
        String[] split2 = a == null ? null : j.split((CharSequence) a.get(0));
        if (!(split2 == null || split2.length == 2)) {
            split2 = null;
        }
        return new C1002d(a(collection), split, null, a(a2), b(a2), a(a3), b(a3), a(b5), a(b), a(a4), b(a4), a(b2), a(list), a(b4), a(a5), split2);
    }

    public /* synthetic */ q b(s sVar) {
        return a(sVar);
    }
}
