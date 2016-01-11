package cn.com.smartdevices.bracelet.tag;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.tag.a.c;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;

public class TagHistoryActivity extends SystemBarTintActivity implements OnClickListener {
    private l a;
    private c b;

    public static Intent a(Context context) {
        return new Intent(context, TagHistoryActivity.class);
    }

    public void onClick(View view) {
        if (view.getId() == l.home_back) {
            finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.activity_tag_history);
        findViewById(l.home_back).setOnClickListener(this);
        ListView listView = (ListView) findViewById(l.history_list);
        this.a = new l(this);
        listView.setAdapter(this.a);
        this.b = new c(this, a.f);
        this.a.a(this.b.d());
        this.a.notifyDataSetChanged();
        C0401a.a((Context) this, C0401a.bT);
    }

    public void onPause() {
        super.onPause();
        C0401a.b((Activity) this);
        C0401a.b(C0401a.aj);
    }

    public void onResume() {
        super.onResume();
        C0401a.a((Activity) this);
        C0401a.a(C0401a.aj);
    }
}
