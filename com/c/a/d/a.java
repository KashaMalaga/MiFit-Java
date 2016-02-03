package com.c.a.d;

import cn.com.smartdevices.bracelet.model.ShareData;
import com.activeandroid.b;
import com.c.a.b.u;
import com.tencent.connect.share.QQShare;
import com.xiaomi.channel.relationservice.data.BuddyData;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class a implements Closeable {
    private static final int A = 6;
    private static final int B = 7;
    private static final char[] a = ")]}'\n".toCharArray();
    private static final long b = -922337203685477580L;
    private static final int c = 0;
    private static final int d = 1;
    private static final int e = 2;
    private static final int f = 3;
    private static final int g = 4;
    private static final int h = 5;
    private static final int i = 6;
    private static final int j = 7;
    private static final int k = 8;
    private static final int l = 9;
    private static final int m = 10;
    private static final int n = 11;
    private static final int o = 12;
    private static final int p = 13;
    private static final int q = 14;
    private static final int r = 15;
    private static final int s = 16;
    private static final int t = 17;
    private static final int u = 0;
    private static final int v = 1;
    private static final int w = 2;
    private static final int x = 3;
    private static final int y = 4;
    private static final int z = 5;
    private final Reader C;
    private boolean D = false;
    private final char[] E = new char[b.a];
    private int F = u;
    private int G = u;
    private int H = u;
    private int I = u;
    private int J = u;
    private long K;
    private int L;
    private String M;
    private int[] N = new int[32];
    private int O = u;

    static {
        u.a = new b();
    }

    public a(Reader reader) {
        int[] iArr = this.N;
        int i = this.O;
        this.O = i + v;
        iArr[i] = i;
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.C = reader;
    }

    private void a(int i) {
        if (this.O == this.N.length) {
            Object obj = new int[(this.O * w)];
            System.arraycopy(this.N, u, obj, u, this.O);
            this.N = obj;
        }
        int[] iArr = this.N;
        int i2 = this.O;
        this.O = i2 + v;
        iArr[i2] = i;
    }

    private boolean a(char c) {
        switch (c) {
            case l /*9*/:
            case m /*10*/:
            case o /*12*/:
            case p /*13*/:
            case kankan.wheel.widget.a.bl /*32*/:
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
                break;
            case com.xiaomi.channel.relationservice.data.b.J /*35*/:
            case '/':
            case ';':
            case '=':
            case '\\':
                w();
                break;
            default:
                return true;
        }
        return false;
    }

    private boolean a(String str) {
        while (true) {
            if (this.F + str.length() > this.G && !b(str.length())) {
                return false;
            }
            if (this.E[this.F] == '\n') {
                this.H += v;
                this.I = this.F + v;
            } else {
                int i = u;
                while (i < str.length()) {
                    if (this.E[this.F + i] == str.charAt(i)) {
                        i += v;
                    }
                }
                return true;
            }
            this.F += v;
        }
    }

    private int b(boolean z) {
        char[] cArr = this.E;
        int i = this.F;
        int i2 = this.G;
        while (true) {
            if (i == i2) {
                this.F = i;
                if (b((int) v)) {
                    i = this.F;
                    i2 = this.G;
                } else if (!z) {
                    return -1;
                } else {
                    throw new EOFException("End of input at line " + u() + " column " + v());
                }
            }
            int i3 = i + v;
            char c = cArr[i];
            if (c == '\n') {
                this.H += v;
                this.I = i3;
                i = i3;
            } else if (c == ' ' || c == '\r') {
                i = i3;
            } else if (c == '\t') {
                i = i3;
            } else if (c == '/') {
                this.F = i3;
                if (i3 == i2) {
                    this.F--;
                    boolean b = b((int) w);
                    this.F += v;
                    if (!b) {
                        return c;
                    }
                }
                w();
                switch (cArr[this.F]) {
                    case '*':
                        this.F += v;
                        if (a("*/")) {
                            i = this.F + w;
                            i2 = this.G;
                            break;
                        }
                        throw b("Unterminated comment");
                    case '/':
                        this.F += v;
                        x();
                        i = this.F;
                        i2 = this.G;
                        break;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.F = i3;
                w();
                x();
                i = this.F;
                i2 = this.G;
            } else {
                this.F = i3;
                return c;
            }
        }
    }

    private IOException b(String str) {
        throw new f(str + " at line " + u() + " column " + v());
    }

    private String b(char c) {
        char[] cArr = this.E;
        StringBuilder stringBuilder = new StringBuilder();
        do {
            int i = this.F;
            int i2 = this.G;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + v;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.F = i4;
                    stringBuilder.append(cArr, i, (i4 - i) - 1);
                    return stringBuilder.toString();
                }
                if (c2 == '\\') {
                    this.F = i4;
                    stringBuilder.append(cArr, i, (i4 - i) - 1);
                    stringBuilder.append(y());
                    i = this.F;
                    i2 = this.G;
                    i4 = i;
                } else if (c2 == '\n') {
                    this.H += v;
                    this.I = i4;
                }
                i3 = i4;
            }
            stringBuilder.append(cArr, i, i3 - i);
            this.F = i3;
        } while (b((int) v));
        throw b("Unterminated string");
    }

    private boolean b(int i) {
        Object obj = this.E;
        this.I -= this.F;
        if (this.G != this.F) {
            this.G -= this.F;
            System.arraycopy(obj, this.F, obj, u, this.G);
        } else {
            this.G = u;
        }
        this.F = u;
        do {
            int read = this.C.read(obj, this.G, obj.length - this.G);
            if (read == -1) {
                return false;
            }
            this.G = read + this.G;
            if (this.H == 0 && this.I == 0 && this.G > 0 && obj[u] == '\ufeff') {
                this.F += v;
                this.I += v;
                i += v;
            }
        } while (this.G < i);
        return true;
    }

    private void c(char c) {
        char[] cArr = this.E;
        do {
            int i = this.F;
            int i2 = this.G;
            int i3 = i;
            while (i3 < i2) {
                i = i3 + v;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.F = i;
                    return;
                }
                if (c2 == '\\') {
                    this.F = i;
                    y();
                    i = this.F;
                    i2 = this.G;
                } else if (c2 == '\n') {
                    this.H += v;
                    this.I = i;
                }
                i3 = i;
            }
            this.F = i3;
        } while (b((int) v));
        throw b("Unterminated string");
    }

    private int o() {
        int b;
        int i = this.N[this.O - 1];
        if (i == v) {
            this.N[this.O - 1] = w;
        } else if (i == w) {
            switch (b(true)) {
                case 44:
                    break;
                case 59:
                    w();
                    break;
                case 93:
                    this.J = y;
                    return y;
                default:
                    throw b("Unterminated array");
            }
        } else if (i == x || i == z) {
            this.N[this.O - 1] = y;
            if (i == z) {
                switch (b(true)) {
                    case 44:
                        break;
                    case 59:
                        w();
                        break;
                    case 125:
                        this.J = w;
                        return w;
                    default:
                        throw b("Unterminated object");
                }
            }
            b = b(true);
            switch (b) {
                case com.xiaomi.channel.relationservice.data.b.I /*34*/:
                    this.J = p;
                    return p;
                case kankan.wheel.widget.a.ay /*39*/:
                    w();
                    this.J = o;
                    return o;
                case 125:
                    if (i != z) {
                        this.J = w;
                        return w;
                    }
                    throw b("Expected name");
                default:
                    w();
                    this.F--;
                    if (a((char) b)) {
                        this.J = q;
                        return q;
                    }
                    throw b("Expected name");
            }
        } else if (i == y) {
            this.N[this.O - 1] = z;
            switch (b(true)) {
                case 58:
                    break;
                case 61:
                    w();
                    if ((this.F < this.G || b((int) v)) && this.E[this.F] == '>') {
                        this.F += v;
                        break;
                    }
                default:
                    throw b("Expected ':'");
            }
        } else if (i == i) {
            if (this.D) {
                z();
            }
            this.N[this.O - 1] = j;
        } else if (i == j) {
            if (b(false) == -1) {
                this.J = t;
                return t;
            }
            w();
            this.F--;
        } else if (i == k) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (b(true)) {
            case com.xiaomi.channel.relationservice.data.b.I /*34*/:
                if (this.O == v) {
                    w();
                }
                this.J = l;
                return l;
            case kankan.wheel.widget.a.ay /*39*/:
                w();
                this.J = k;
                return k;
            case 44:
            case 59:
                break;
            case 91:
                this.J = x;
                return x;
            case 93:
                if (i == v) {
                    this.J = y;
                    return y;
                }
                break;
            case 123:
                this.J = v;
                return v;
            default:
                this.F--;
                if (this.O == v) {
                    w();
                }
                b = q();
                if (b != 0) {
                    return b;
                }
                b = r();
                if (b != 0) {
                    return b;
                }
                if (a(this.E[this.F])) {
                    w();
                    this.J = m;
                    return m;
                }
                throw b("Expected value");
        }
        if (i == v || i == w) {
            w();
            this.F--;
            this.J = j;
            return j;
        }
        throw b("Unexpected value");
    }

    private int q() {
        String str;
        int i;
        char c = this.E[this.F];
        String str2;
        if (c == 't' || c == 'T') {
            str = "true";
            str2 = "TRUE";
            i = z;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = i;
        } else if (c != 'n' && c != 'N') {
            return u;
        } else {
            str = "null";
            str2 = "NULL";
            i = j;
        }
        int length = str.length();
        int i2 = v;
        while (i2 < length) {
            if (this.F + i2 >= this.G && !b(i2 + v)) {
                return u;
            }
            char c2 = this.E[this.F + i2];
            if (c2 != str.charAt(i2) && c2 != r1.charAt(i2)) {
                return u;
            }
            i2 += v;
        }
        if ((this.F + length < this.G || b(length + v)) && a(this.E[this.F + length])) {
            return u;
        }
        this.F += length;
        this.J = i;
        return i;
    }

    private int r() {
        char[] cArr = this.E;
        int i = this.F;
        int i2 = this.G;
        long j = 0;
        Object obj = null;
        int i3 = v;
        int i4 = u;
        int i5 = u;
        int i6 = i2;
        i2 = i;
        while (true) {
            Object obj2;
            if (i2 + i5 == i6) {
                if (i5 == cArr.length) {
                    return u;
                }
                if (b(i5 + v)) {
                    i2 = this.F;
                    i6 = this.G;
                } else if (i4 != w && i3 != 0 && (j != Long.MIN_VALUE || obj != null)) {
                    if (obj == null) {
                        j = -j;
                    }
                    this.K = j;
                    this.F += i5;
                    this.J = r;
                    return r;
                } else if (i4 == w && i4 != y && i4 != j) {
                    return u;
                } else {
                    this.L = i5;
                    this.J = s;
                    return s;
                }
            }
            char c = cArr[i2 + i5];
            int i7;
            switch (c) {
                case '+':
                    if (i4 != z) {
                        return u;
                    }
                    i = i;
                    i4 = i3;
                    obj2 = obj;
                    continue;
                case QQShare.QQ_SHARE_TITLE_MAX_LENGTH /*45*/:
                    if (i4 == 0) {
                        i = v;
                        i7 = i3;
                        obj2 = v;
                        i4 = i7;
                        continue;
                    } else if (i4 == z) {
                        i = i;
                        i4 = i3;
                        obj2 = obj;
                        break;
                    } else {
                        return u;
                    }
                case kankan.wheel.widget.a.aZ /*46*/:
                    if (i4 != w) {
                        return u;
                    }
                    i = x;
                    i4 = i3;
                    obj2 = obj;
                    continue;
                case 'E':
                case ShareData.SHARE_TYPE_LAB_ROPE_SKIPPING_ACCUMULATE /*101*/:
                    if (i4 != w && i4 != y) {
                        return u;
                    }
                    i = z;
                    i4 = i3;
                    obj2 = obj;
                    continue;
                default:
                    if (c >= '0' && c <= '9') {
                        if (i4 != v && i4 != 0) {
                            if (i4 != w) {
                                if (i4 != x) {
                                    if (i4 != z && i4 != i) {
                                        i = i4;
                                        i4 = i3;
                                        obj2 = obj;
                                        break;
                                    }
                                    i = j;
                                    i4 = i3;
                                    obj2 = obj;
                                    break;
                                }
                                i = y;
                                i4 = i3;
                                obj2 = obj;
                                break;
                            } else if (j != 0) {
                                long j2 = (10 * j) - ((long) (c - 48));
                                i = (j > b || (j == b && j2 < j)) ? v : u;
                                i &= i3;
                                obj2 = obj;
                                j = j2;
                                i7 = i4;
                                i4 = i;
                                i = i7;
                                break;
                            } else {
                                return u;
                            }
                        }
                        j = (long) (-(c - 48));
                        i = w;
                        i4 = i3;
                        obj2 = obj;
                        continue;
                    } else if (a(c)) {
                        return u;
                    }
                    break;
            }
            if (i4 != w) {
            }
            if (i4 == w) {
            }
            this.L = i5;
            this.J = s;
            return s;
            i5 += v;
            obj = obj2;
            i3 = i4;
            i4 = i;
        }
    }

    private String s() {
        StringBuilder stringBuilder = null;
        int i = u;
        while (true) {
            String str;
            if (this.F + i < this.G) {
                switch (this.E[this.F + i]) {
                    case l /*9*/:
                    case m /*10*/:
                    case o /*12*/:
                    case p /*13*/:
                    case kankan.wheel.widget.a.bl /*32*/:
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case com.xiaomi.channel.relationservice.data.b.J /*35*/:
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        w();
                        break;
                    default:
                        i += v;
                        continue;
                }
            } else if (i >= this.E.length) {
                if (stringBuilder == null) {
                    stringBuilder = new StringBuilder();
                }
                stringBuilder.append(this.E, this.F, i);
                this.F = i + this.F;
                i = !b((int) v) ? u : u;
            } else if (b(i + v)) {
            }
            if (stringBuilder == null) {
                str = new String(this.E, this.F, i);
            } else {
                stringBuilder.append(this.E, this.F, i);
                str = stringBuilder.toString();
            }
            this.F = i + this.F;
            return str;
        }
    }

    private void t() {
        do {
            int i = u;
            while (this.F + i < this.G) {
                switch (this.E[this.F + i]) {
                    case l /*9*/:
                    case m /*10*/:
                    case o /*12*/:
                    case p /*13*/:
                    case kankan.wheel.widget.a.bl /*32*/:
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case com.xiaomi.channel.relationservice.data.b.J /*35*/:
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        w();
                        break;
                    default:
                        i += v;
                }
                this.F = i + this.F;
                return;
            }
            this.F = i + this.F;
        } while (b((int) v));
    }

    private int u() {
        return this.H + v;
    }

    private int v() {
        return (this.F - this.I) + v;
    }

    private void w() {
        if (!this.D) {
            throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void x() {
        char c;
        do {
            if (this.F < this.G || b((int) v)) {
                char[] cArr = this.E;
                int i = this.F;
                this.F = i + v;
                c = cArr[i];
                if (c == '\n') {
                    this.H += v;
                    this.I = this.F;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    private char y() {
        if (this.F != this.G || b((int) v)) {
            char[] cArr = this.E;
            int i = this.F;
            this.F = i + v;
            char c = cArr[i];
            switch (c) {
                case m /*10*/:
                    this.H += v;
                    this.I = this.F;
                    return c;
                case 'b':
                    return '\b';
                case ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD /*102*/:
                    return '\f';
                case 'n':
                    return '\n';
                case BuddyData.s /*114*/:
                    return '\r';
                case 't':
                    return '\t';
                case 'u':
                    if (this.F + y <= this.G || b((int) y)) {
                        int i2 = this.F;
                        int i3 = i2 + y;
                        int i4 = i2;
                        c = '\u0000';
                        for (i = i4; i < i3; i += v) {
                            char c2 = this.E[i];
                            c = (char) (c << y);
                            if (c2 >= '0' && c2 <= '9') {
                                c = (char) (c + (c2 - 48));
                            } else if (c2 >= 'a' && c2 <= 'f') {
                                c = (char) (c + ((c2 - 97) + m));
                            } else if (c2 < 'A' || c2 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.E, this.F, y));
                            } else {
                                c = (char) (c + ((c2 - 65) + m));
                            }
                        }
                        this.F += y;
                        return c;
                    }
                    throw b("Unterminated escape sequence");
                default:
                    return c;
            }
        }
        throw b("Unterminated escape sequence");
    }

    private void z() {
        b(true);
        this.F--;
        if (this.F + a.length <= this.G || b(a.length)) {
            int i = u;
            while (i < a.length) {
                if (this.E[this.F + i] == a[i]) {
                    i += v;
                } else {
                    return;
                }
            }
            this.F += a.length;
        }
    }

    public void a() {
        int i = this.J;
        if (i == 0) {
            i = o();
        }
        if (i == x) {
            a((int) v);
            this.J = u;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + f() + " at line " + u() + " column " + v());
    }

    public final void a(boolean z) {
        this.D = z;
    }

    public void b() {
        int i = this.J;
        if (i == 0) {
            i = o();
        }
        if (i == y) {
            this.O--;
            this.J = u;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + f() + " at line " + u() + " column " + v());
    }

    public void c() {
        int i = this.J;
        if (i == 0) {
            i = o();
        }
        if (i == v) {
            a((int) x);
            this.J = u;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + f() + " at line " + u() + " column " + v());
    }

    public void close() {
        this.J = u;
        this.N[u] = k;
        this.O = v;
        this.C.close();
    }

    public void d() {
        int i = this.J;
        if (i == 0) {
            i = o();
        }
        if (i == w) {
            this.O--;
            this.J = u;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + f() + " at line " + u() + " column " + v());
    }

    public boolean e() {
        int i = this.J;
        if (i == 0) {
            i = o();
        }
        return (i == w || i == y) ? false : true;
    }

    public d f() {
        int i = this.J;
        if (i == 0) {
            i = o();
        }
        switch (i) {
            case v /*1*/:
                return d.BEGIN_OBJECT;
            case w /*2*/:
                return d.END_OBJECT;
            case x /*3*/:
                return d.BEGIN_ARRAY;
            case y /*4*/:
                return d.END_ARRAY;
            case z /*5*/:
            case i /*6*/:
                return d.BOOLEAN;
            case j /*7*/:
                return d.NULL;
            case k /*8*/:
            case l /*9*/:
            case m /*10*/:
            case n /*11*/:
                return d.STRING;
            case o /*12*/:
            case p /*13*/:
            case q /*14*/:
                return d.NAME;
            case r /*15*/:
            case s /*16*/:
                return d.NUMBER;
            case t /*17*/:
                return d.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public String g() {
        String s;
        int i = this.J;
        if (i == 0) {
            i = o();
        }
        if (i == q) {
            s = s();
        } else if (i == o) {
            s = b('\'');
        } else if (i == p) {
            s = b('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + f() + " at line " + u() + " column " + v());
        }
        this.J = u;
        return s;
    }

    public String h() {
        String s;
        int i = this.J;
        if (i == 0) {
            i = o();
        }
        if (i == m) {
            s = s();
        } else if (i == k) {
            s = b('\'');
        } else if (i == l) {
            s = b('\"');
        } else if (i == n) {
            s = this.M;
            this.M = null;
        } else if (i == r) {
            s = Long.toString(this.K);
        } else if (i == s) {
            s = new String(this.E, this.F, this.L);
            this.F += this.L;
        } else {
            throw new IllegalStateException("Expected a string but was " + f() + " at line " + u() + " column " + v());
        }
        this.J = u;
        return s;
    }

    public boolean i() {
        int i = this.J;
        if (i == 0) {
            i = o();
        }
        if (i == z) {
            this.J = u;
            return true;
        } else if (i == i) {
            this.J = u;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + f() + " at line " + u() + " column " + v());
        }
    }

    public void j() {
        int i = this.J;
        if (i == 0) {
            i = o();
        }
        if (i == j) {
            this.J = u;
            return;
        }
        throw new IllegalStateException("Expected null but was " + f() + " at line " + u() + " column " + v());
    }

    public double k() {
        int i = this.J;
        if (i == 0) {
            i = o();
        }
        if (i == r) {
            this.J = u;
            return (double) this.K;
        }
        if (i == s) {
            this.M = new String(this.E, this.F, this.L);
            this.F += this.L;
        } else if (i == k || i == l) {
            this.M = b(i == k ? '\'' : '\"');
        } else if (i == m) {
            this.M = s();
        } else if (i != n) {
            throw new IllegalStateException("Expected a double but was " + f() + " at line " + u() + " column " + v());
        }
        this.J = n;
        double parseDouble = Double.parseDouble(this.M);
        if (this.D || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            this.M = null;
            this.J = u;
            return parseDouble;
        }
        throw new f("JSON forbids NaN and infinities: " + parseDouble + " at line " + u() + " column " + v());
    }

    public long l() {
        int i = this.J;
        if (i == 0) {
            i = o();
        }
        if (i == r) {
            this.J = u;
            return this.K;
        }
        long parseLong;
        if (i == s) {
            this.M = new String(this.E, this.F, this.L);
            this.F += this.L;
        } else if (i == k || i == l) {
            this.M = b(i == k ? '\'' : '\"');
            try {
                parseLong = Long.parseLong(this.M);
                this.J = u;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + f() + " at line " + u() + " column " + v());
        }
        this.J = n;
        double parseDouble = Double.parseDouble(this.M);
        parseLong = (long) parseDouble;
        if (((double) parseLong) != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.M + " at line " + u() + " column " + v());
        }
        this.M = null;
        this.J = u;
        return parseLong;
    }

    public int m() {
        int i = this.J;
        if (i == 0) {
            i = o();
        }
        if (i == r) {
            i = (int) this.K;
            if (this.K != ((long) i)) {
                throw new NumberFormatException("Expected an int but was " + this.K + " at line " + u() + " column " + v());
            }
            this.J = u;
        } else {
            if (i == s) {
                this.M = new String(this.E, this.F, this.L);
                this.F += this.L;
            } else if (i == k || i == l) {
                this.M = b(i == k ? '\'' : '\"');
                try {
                    i = Integer.parseInt(this.M);
                    this.J = u;
                } catch (NumberFormatException e) {
                }
            } else {
                throw new IllegalStateException("Expected an int but was " + f() + " at line " + u() + " column " + v());
            }
            this.J = n;
            double parseDouble = Double.parseDouble(this.M);
            i = (int) parseDouble;
            if (((double) i) != parseDouble) {
                throw new NumberFormatException("Expected an int but was " + this.M + " at line " + u() + " column " + v());
            }
            this.M = null;
            this.J = u;
        }
        return i;
    }

    public void n() {
        int i = u;
        do {
            int i2 = this.J;
            if (i2 == 0) {
                i2 = o();
            }
            if (i2 == x) {
                a((int) v);
                i += v;
            } else if (i2 == v) {
                a((int) x);
                i += v;
            } else if (i2 == y) {
                this.O--;
                i--;
            } else if (i2 == w) {
                this.O--;
                i--;
            } else if (i2 == q || i2 == m) {
                t();
            } else if (i2 == k || i2 == o) {
                c('\'');
            } else if (i2 == l || i2 == p) {
                c('\"');
            } else if (i2 == s) {
                this.F += this.L;
            }
            this.J = u;
        } while (i != 0);
    }

    public final boolean p() {
        return this.D;
    }

    public String toString() {
        return getClass().getSimpleName() + " at line " + u() + " column " + v();
    }
}
