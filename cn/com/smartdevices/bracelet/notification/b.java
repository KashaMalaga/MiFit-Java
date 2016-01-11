package cn.com.smartdevices.bracelet.notification;

import java.text.Collator;
import java.util.Comparator;

final class b implements Comparator<c> {
    private final Collator a = Collator.getInstance();

    b() {
    }

    public int a(c cVar, c cVar2) {
        return this.a.compare(cVar.b(), cVar2.b());
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((c) obj, (c) obj2);
    }
}
