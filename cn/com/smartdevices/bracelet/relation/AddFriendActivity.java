package cn.com.smartdevices.bracelet.relation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.relation.b.g;
import com.huami.android.ui.ActionBarActivity;
import com.huami.android.view.b;
import com.xiaomi.hm.health.R;
import de.greenrobot.event.EventBus;

public class AddFriendActivity extends ActionBarActivity implements OnClickListener {
    private EditText a;
    private A b;

    public AddFriendActivity() {
        super(C0401a.gH, C0401a.gy);
    }

    public static Intent a(Context context) {
        return new Intent(context, AddFriendActivity.class);
    }

    public void onClick(View view) {
        long parseLong;
        try {
            parseLong = Long.parseLong(this.a.getText().toString());
        } catch (NumberFormatException e) {
            parseLong = -1;
        }
        this.b.a(parseLong);
        Utils.a((Activity) this, (int) R.string.data_loading);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_add_friend);
        this.a = (EditText) findViewById(R.id.username);
        ((Button) findViewById(R.id.search_button)).setOnClickListener(this);
        this.b = A.a();
        EventBus.getDefault().register(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(g gVar) {
        Utils.a((Activity) this);
        if (gVar.a != 1) {
            b.a((Context) this, (int) R.string.network_error, 0);
        } else if (gVar.b > 0) {
            startActivity(SearchResultActivity.a(this, gVar.b, gVar.c, gVar.d, gVar.e));
        } else {
            b.a((Context) this, (int) R.string.search_result_is_empty, 0);
        }
    }
}
