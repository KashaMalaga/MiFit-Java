package cn.com.smartdevices.bracelet.relation;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.relation.a.a;
import com.huami.android.ui.ActionBarActivity;
import com.huami.android.widget.f;
import com.huami.android.widget.share.s;
import com.tencent.connect.common.Constants;
import com.xiaomi.hm.health.R;
import java.io.File;
import java.io.Serializable;

public class UserQRCardActivity extends ActionBarActivity implements OnClickListener, s {
    private static final String a = "card";
    private static final String b = "qr_code";
    private File c;
    private ImageView d;
    private Bitmap e;
    private View f;
    private int g;
    private a h;
    private File i;
    private boolean j;
    private f k;

    public UserQRCardActivity() {
        super(C0401a.gO, C0401a.gE);
    }

    public static Intent a(Context context, long j, String str, String str2) {
        Serializable aVar = new a();
        aVar.a = j;
        aVar.c = str;
        aVar.b = str2;
        Intent intent = new Intent(context, UserQRCardActivity.class);
        intent.putExtra(a, aVar);
        return intent;
    }

    public void a() {
        C0401a.a((Context) this, C0409b.aL, C0410c.u, this.j ? Constants.VIA_TO_TYPE_QQ_GROUP : Constants.VIA_RESULT_SUCCESS);
        super.a();
    }

    public void b() {
        this.k = f.a(getFragmentManager(), getString(R.string.label_preparing_share_image), false);
        new ab().execute(new Bitmap[]{this.e});
    }

    public void onBackPressed() {
        a();
    }

    public void onClick(View view) {
        this.k = f.a(getFragmentManager(), getString(R.string.label_preparing_share_image), false);
        new ab().execute(new Bitmap[]{this.e});
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_user_card);
        this.d = (ImageView) findViewById(R.id.qr_code);
        this.f = findViewById(R.id.share_button);
        this.f.setOnClickListener(this);
        this.f.setEnabled(false);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (i >= i2) {
            i = i2;
        }
        this.g = (i * 7) / 8;
        this.h = (a) getIntent().getSerializableExtra(a);
        this.i = new File(getExternalCacheDir(), b);
        if (!this.i.exists()) {
            this.i.mkdirs();
        }
        this.c = new File(this.i, this.h.a + ".png");
        if (this.c.exists()) {
            this.e = BitmapFactory.decodeFile(this.c.getAbsolutePath());
        }
        if (this.e == null) {
            new aa(this, this.g).execute(new a[]{this.h});
            return;
        }
        this.f.setEnabled(true);
        this.d.setImageBitmap(this.e);
    }
}
