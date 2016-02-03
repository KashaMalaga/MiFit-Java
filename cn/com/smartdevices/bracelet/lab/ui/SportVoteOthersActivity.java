package cn.com.smartdevices.bracelet.lab.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import com.xiaomi.hm.health.R;

public class SportVoteOthersActivity extends SystemBarTintActivity implements OnClickListener {
    private EditText a = null;
    private TextView b = null;
    private TextView c = null;
    private Animation d = null;

    private void a() {
        this.c = (TextView) findViewById(R.id.home_back);
        this.c.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_back:
                finish();
                return;
            case R.id.confirm:
                Editable text = this.a.getText();
                Object trim = text.toString().trim();
                if (TextUtils.isEmpty(trim)) {
                    this.a.startAnimation(this.d);
                    this.a.setSelection(0, text.length());
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("sport_name", trim);
                setResult(0, intent);
                finish();
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_lab_sport_vote_others);
        a();
        this.a = (EditText) findViewById(R.id.favorite_user_sport_name);
        this.a.addTextChangedListener(new ai(this, 10, this.a));
        this.b = (TextView) findViewById(R.id.confirm);
        this.b.setOnClickListener(this);
        this.d = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.edit_shake);
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.ae);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.a(C0401a.ae);
        C0401a.a((Activity) this);
    }
}
