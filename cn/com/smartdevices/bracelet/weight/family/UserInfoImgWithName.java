package cn.com.smartdevices.bracelet.weight.family;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.view.WeightUserAvatar;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;

@SuppressLint({"NewApi"})
public class UserInfoImgWithName extends RelativeLayout implements OnClickListener {
    private static final String a = UserInfoImgWithName.class.getSimpleName();
    private WeightUserAvatar b;
    private TextView c;
    private UserInfo d;
    private k e;

    public UserInfoImgWithName(Context context) {
        this(context, null, 0);
    }

    public UserInfoImgWithName(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UserInfoImgWithName(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(n.userimg_with_name, this, true);
        this.b = (WeightUserAvatar) inflate.findViewById(l.user_icon);
        this.b.setOnClickListener(this);
        this.c = (TextView) inflate.findViewById(l.user_name);
    }

    public void a(int i) {
        this.c.setTextColor(i);
    }

    public void a(Drawable drawable, String str) {
        this.b.setBackground(drawable);
        this.c.setText(str);
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            C0596r.e(a, "bindUser " + userInfo.toString());
            this.d = userInfo;
            b(this.d);
            a(this.d.name);
            return;
        }
        this.b.setBackgroundResource(k.default_userinfo);
        this.c.setText(a.f);
    }

    public void a(k kVar) {
        this.e = kVar;
    }

    public void a(String str) {
        this.c.setText(str);
    }

    public void a(boolean z) {
        this.c.setVisibility(8);
        if (z) {
            this.c = (TextView) findViewById(l.user_name_right);
        } else {
            this.c = (TextView) findViewById(l.user_name);
        }
        this.c.setVisibility(0);
    }

    public void b(int i) {
        this.c.setTextSize((float) i);
    }

    public void b(UserInfo userInfo) {
        this.b.a(Utils.c(userInfo.uid));
        this.b.a(userInfo.name);
        Utils.a(userInfo, this.b);
    }

    public void b(boolean z) {
        this.c.setEnabled(z);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case l.user_icon /*2131297540*/:
                if (this.e != null) {
                    this.e.a(this.d);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
