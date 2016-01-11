package cn.com.smartdevices.bracelet.weight.a;

import cn.com.smartdevices.bracelet.i.a.a;
import cn.com.smartdevices.bracelet.weight.WeightInfo;
import cn.com.smartdevices.bracelet.weight.ah;
import java.util.List;

class c extends a<Integer, List<WeightInfo>> {
    private c() {
    }

    public List<WeightInfo> a(Integer num) {
        return ah.a().c(num.intValue());
    }

    public boolean a(List<WeightInfo> list) {
        return list == null || list.size() == 0;
    }

    public /* synthetic */ Object access(Object obj) {
        return a((Integer) obj);
    }

    public /* synthetic */ boolean isEmpty(Object obj) {
        return a((List) obj);
    }
}
