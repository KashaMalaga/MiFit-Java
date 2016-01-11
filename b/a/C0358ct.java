package b.a;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class C0358ct implements Comparator {
    private C0358ct() {
    }

    public int compare(Object obj, Object obj2) {
        return (obj == null && obj2 == null) ? 0 : obj == null ? -1 : obj2 == null ? 1 : obj instanceof List ? C0357cs.a((List) obj, (List) obj2) : obj instanceof Set ? C0357cs.a((Set) obj, (Set) obj2) : obj instanceof Map ? C0357cs.a((Map) obj, (Map) obj2) : obj instanceof byte[] ? C0357cs.a((byte[]) obj, (byte[]) obj2) : C0357cs.a((Comparable) obj, (Comparable) obj2);
    }
}
