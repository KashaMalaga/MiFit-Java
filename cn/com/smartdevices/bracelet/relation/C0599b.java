package cn.com.smartdevices.bracelet.relation;

import cn.com.smartdevices.bracelet.relation.db.a;
import java.util.Comparator;

class C0599b implements Comparator<a> {
    final /* synthetic */ DetailActivity a;

    C0599b(DetailActivity detailActivity) {
        this.a = detailActivity;
    }

    public int a(a aVar, a aVar2) {
        return (int) (aVar.o - aVar2.o);
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((a) obj, (a) obj2);
    }
}
