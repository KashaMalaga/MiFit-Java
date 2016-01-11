package cn.com.smartdevices.bracelet.shoes.ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.reflection.FwUpgradeManager;
import com.huami.android.ui.CustomActionBarActivity;
import com.xiaomi.hm.health.c.e;
import com.xiaomi.hm.health.c.h;
import com.xiaomi.hm.health.c.i;
import com.xiaomi.hm.health.c.m;

public class ShoesListActivity extends CustomActionBarActivity {
    private T a = null;
    private Context b = null;

    public ShoesListActivity() {
        super(C0401a.bZ, C0401a.au);
    }

    private void d() {
        FwUpgradeManager.forceUpdateShoes(Boolean.valueOf(true));
        FwUpgradeManager.checkFwUpgrade(this.b, 2, new R(this));
    }

    private void f() {
        if (this.e != null) {
            this.e.setOnLongClickListener(new S(this));
        }
    }

    protected String b() {
        return getResources().getString(m.shoes_select_shoes);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.activity_shoes_list);
        this.b = getApplicationContext();
        c(getResources().getColor(e.font_color_c7_v2));
        ListView listView = (ListView) findViewById(h.shoes_list);
        this.a = new T(this);
        listView.setAdapter(this.a);
        listView.setOnItemClickListener(new P(this));
        findViewById(h.firmware_update).setOnClickListener(new Q(this));
        f();
    }

    public void onResume() {
        super.onResume();
        this.a.a();
        this.a.a(t.d(getApplication()));
        this.a.notifyDataSetChanged();
    }
}
