package cn.com.smartdevices.bracelet.ui;

import com.xiaomi.hm.health.bt.a.d;

class C0770ds extends d {
    final /* synthetic */ SearchSingleBraceletActivity a;

    C0770ds(SearchSingleBraceletActivity searchSingleBraceletActivity) {
        this.a = searchSingleBraceletActivity;
    }

    public void a(Object obj) {
        super.a(obj);
        SearchSingleBraceletActivity.v.removeMessages(4101);
        if (obj != null) {
            SearchSingleBraceletActivity.v.sendEmptyMessage(4102);
        } else {
            SearchSingleBraceletActivity.v.sendEmptyMessage(4101);
        }
    }

    public void b(Object obj) {
        super.b(obj);
        SearchSingleBraceletActivity.v.removeMessages(4101);
        SearchSingleBraceletActivity.v.sendEmptyMessage(4101);
    }
}
