package cn.com.smartdevices.bracelet.weight.family;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import cn.com.smartdevices.bracelet.weight.J;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import com.huami.android.view.b;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import java.util.ArrayList;
import java.util.List;

public class WeightFamilyMemberActivity extends SystemBarTintActivity implements OnClickListener {
    private static final String b = "WeightFamilyMemberActivity";
    private Context a = this;
    private ListView c;
    private n d;
    private List<UserInfo> e = new ArrayList();
    private ImageView f;

    private void a() {
        this.c = (ListView) findViewById(l.family_members_dymantic_list);
        this.f = (ImageView) findViewById(l.add_member_plus);
        this.f.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case l.add_member_plus /*2131296391*/:
                if (!Utils.l(this.a)) {
                    b.a(this.a, getString(r.please_connect_internet), 0).show();
                    return;
                } else if (J.a().c() >= 16) {
                    b.a(this.a, getString(r.over_the_max_user_count), 0).show();
                    return;
                } else {
                    this.a.startActivity(new Intent(this.a, MemberInfoSetNameActivity.class));
                    C0401a.a(this.a, C0401a.fl, C0401a.fm);
                    return;
                }
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.activity_family_member);
        a();
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.aL);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        this.e = J.a().e();
        this.d = new n(this);
        this.c.setAdapter(this.d);
        this.c.setOnItemClickListener(new m(this));
        C0401a.a(C0401a.aL);
        C0401a.a((Activity) this);
    }
}
