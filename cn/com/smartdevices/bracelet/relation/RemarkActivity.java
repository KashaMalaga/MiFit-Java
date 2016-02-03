package cn.com.smartdevices.bracelet.relation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.relation.db.Friend;
import cn.com.smartdevices.bracelet.view.ClearEditText;
import com.huami.android.ui.ActionBarActivity;
import com.huami.android.view.b;
import com.xiaomi.hm.health.R;

public class RemarkActivity extends ActionBarActivity {
    public static final String a = "friend";
    public static final String b = "username";
    public static final String c = "userid";
    private Friend d;
    private A e;
    private ClearEditText f;

    public RemarkActivity() {
        super(C0401a.gM, C0401a.gC);
    }

    public static Intent a(Context context, Friend friend) {
        Intent intent = new Intent(context, RemarkActivity.class);
        intent.putExtra(a, friend);
        return intent;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_remark);
        this.d = (Friend) getIntent().getParcelableExtra(a);
        if (this.d == null || this.d.n < 0) {
            b.a((Context) this, (int) R.string.toast_user_info_error, 0);
            finish();
            return;
        }
        this.e = A.a();
        this.f = (ClearEditText) findViewById(R.id.remark_name);
        if (!TextUtils.isEmpty(this.d.x)) {
            this.f.setText(this.d.x);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_remark, menu);
        menu.findItem(R.id.action_save).getActionView();
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.action_save) {
            return super.onOptionsItemSelected(menuItem);
        }
        String obj = this.f.getText().toString();
        this.e.a((Context) this, this.d.n, obj);
        Intent intent = new Intent();
        intent.putExtra(b, obj);
        intent.putExtra(c, this.d.n);
        setResult(-1, intent);
        finish();
        return true;
    }
}
