package cn.com.smartdevices.bracelet.gps.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.xiaomi.hm.health.b.a.i;

class V implements OnItemLongClickListener {
    final /* synthetic */ HistoryActivity a;

    V(HistoryActivity historyActivity) {
        this.a = historyActivity;
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag = view.getTag(i.childId);
        if (tag == null) {
            return false;
        }
        int intValue = ((Integer) tag).intValue();
        if (intValue < 0) {
            return true;
        }
        this.a.a(((Integer) view.getTag(i.groupId)).intValue(), intValue);
        return true;
    }
}
