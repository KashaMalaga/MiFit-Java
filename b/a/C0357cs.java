package b.a;

import android.support.v4.view.a.C0113o;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public final class C0357cs {
    private static final Comparator a = new C0358ct();

    private C0357cs() {
    }

    public static int a(byte b, byte b2) {
        return b < b2 ? -1 : b2 < b ? 1 : 0;
    }

    public static int a(double d, double d2) {
        return d < d2 ? -1 : d2 < d ? 1 : 0;
    }

    public static int a(int i, int i2) {
        return i < i2 ? -1 : i2 < i ? 1 : 0;
    }

    public static int a(long j, long j2) {
        return j < j2 ? -1 : j2 < j ? 1 : 0;
    }

    public static int a(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static int a(Object obj, Object obj2) {
        if (obj instanceof Comparable) {
            return C0357cs.a((Comparable) obj, (Comparable) obj2);
        }
        if (obj instanceof List) {
            return C0357cs.a((List) obj, (List) obj2);
        }
        if (obj instanceof Set) {
            return C0357cs.a((Set) obj, (Set) obj2);
        }
        if (obj instanceof Map) {
            return C0357cs.a((Map) obj, (Map) obj2);
        }
        if (obj instanceof byte[]) {
            return C0357cs.a((byte[]) obj, (byte[]) obj2);
        }
        throw new IllegalArgumentException("Cannot compare objects of type " + obj.getClass());
    }

    public static int a(String str, String str2) {
        return str.compareTo(str2);
    }

    public static int a(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int remaining = byteBuffer.remaining();
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), bArr, i, remaining);
        return remaining;
    }

    public static int a(List list, List list2) {
        int a = C0357cs.a(list.size(), list2.size());
        if (a != 0) {
            return a;
        }
        for (a = 0; a < list.size(); a++) {
            int compare = a.compare(list.get(a), list2.get(a));
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static int a(Map map, Map map2) {
        int a = C0357cs.a(map.size(), map2.size());
        if (a != 0) {
            return a;
        }
        SortedMap treeMap = new TreeMap(a);
        treeMap.putAll(map);
        Iterator it = treeMap.entrySet().iterator();
        treeMap = new TreeMap(a);
        treeMap.putAll(map2);
        Iterator it2 = treeMap.entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Entry entry = (Entry) it.next();
            Entry entry2 = (Entry) it2.next();
            int compare = a.compare(entry.getKey(), entry2.getKey());
            if (compare != 0) {
                return compare;
            }
            a = a.compare(entry.getValue(), entry2.getValue());
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public static int a(Set set, Set set2) {
        int a = C0357cs.a(set.size(), set2.size());
        if (a != 0) {
            return a;
        }
        SortedSet treeSet = new TreeSet(a);
        treeSet.addAll(set);
        SortedSet treeSet2 = new TreeSet(a);
        treeSet2.addAll(set2);
        Iterator it = treeSet.iterator();
        Iterator it2 = treeSet2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            a = a.compare(it.next(), it2.next());
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public static int a(short s, short s2) {
        return s < s2 ? -1 : s2 < s ? 1 : 0;
    }

    public static int a(boolean z, boolean z2) {
        return Boolean.valueOf(z).compareTo(Boolean.valueOf(z2));
    }

    public static int a(byte[] bArr, byte[] bArr2) {
        int a = C0357cs.a(bArr.length, bArr2.length);
        if (a != 0) {
            return a;
        }
        for (a = 0; a < bArr.length; a++) {
            int a2 = C0357cs.a(bArr[a], bArr2[a]);
            if (a2 != 0) {
                return a2;
            }
        }
        return 0;
    }

    public static String a(byte b) {
        return Integer.toHexString((b | PersonInfo.INCOMING_CALL_DISABLE_BIT) & 511).toUpperCase().substring(1);
    }

    public static void a(ByteBuffer byteBuffer, StringBuilder stringBuilder) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        int position = arrayOffset + byteBuffer.position();
        int limit = byteBuffer.limit() + arrayOffset;
        arrayOffset = limit - position > C0113o.h ? position + C0113o.h : limit;
        for (int i = position; i < arrayOffset; i++) {
            if (i > position) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(C0357cs.a(array[i]));
        }
        if (limit != arrayOffset) {
            stringBuilder.append("...");
        }
    }

    public static byte[] a(ByteBuffer byteBuffer) {
        if (C0357cs.b(byteBuffer)) {
            return byteBuffer.array();
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        C0357cs.a(byteBuffer, bArr, 0);
        return bArr;
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        Object obj = new byte[bArr.length];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        return obj;
    }

    public static boolean b(ByteBuffer byteBuffer) {
        return byteBuffer.hasArray() && byteBuffer.position() == 0 && byteBuffer.arrayOffset() == 0 && byteBuffer.remaining() == byteBuffer.capacity();
    }

    public static ByteBuffer c(ByteBuffer byteBuffer) {
        return byteBuffer == null ? null : !C0357cs.b(byteBuffer) ? ByteBuffer.wrap(C0357cs.a(byteBuffer)) : byteBuffer;
    }

    public static ByteBuffer d(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        ByteBuffer wrap = ByteBuffer.wrap(new byte[byteBuffer.remaining()]);
        if (byteBuffer.hasArray()) {
            System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), wrap.array(), 0, byteBuffer.remaining());
            return wrap;
        }
        byteBuffer.slice().get(wrap.array());
        return wrap;
    }
}
