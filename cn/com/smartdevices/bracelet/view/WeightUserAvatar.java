package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import cn.com.smartdevices.bracelet.chart.util.t;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeightUserAvatar extends ImageView {
    private String a;
    private String b;
    private boolean c;
    private Bitmap d;
    private float e;
    private int f;
    private int g;

    public WeightUserAvatar(Context context) {
        this(context, null, 0);
    }

    public WeightUserAvatar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WeightUserAvatar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = 436207616;
        addOnLayoutChangeListener(new Z(this));
    }

    private void a() {
        this.e = t.a(getContext(), 23.0f);
        this.f = -419430401;
        this.d = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(this.d);
        Paint paint = new Paint(1);
        paint.setTextAlign(Align.CENTER);
        paint.setLinearText(true);
        paint.setTextSize(this.e);
        paint.getTextBounds(this.b, 0, 1, new Rect());
        float width = (float) (canvas.getWidth() / 2);
        float height = (float) (canvas.getHeight() / 2);
        paint.setColor(this.g);
        canvas.drawCircle(width, height, width, paint);
        paint.setColor(this.f);
        canvas.drawText(this.b, width, height - ((paint.descent() + paint.ascent()) / 2.0f), paint);
    }

    private void b() {
        if (this.d == null && !TextUtils.isEmpty(this.b)) {
            a();
        }
        super.setBackground(new BitmapDrawable(getResources(), this.d));
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(String str) {
        String str2 = null;
        if (str != null && !str.equals(this.a)) {
            this.a = str;
            this.d = null;
            this.b = a.f;
            try {
                this.b = this.a.substring(0, 1);
                this.b = this.b.toUpperCase();
                Matcher matcher = Pattern.compile("[\u4e00-\u9fa5]+").matcher(this.a);
                while (matcher.find()) {
                    str2 = matcher.group();
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.b = str2.substring(str2.length() - 1, str2.length());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setBackground(Drawable drawable) {
        this.c = false;
        super.setBackground(drawable);
    }

    public void setBackgroundResource(int i) {
        if (i == R.drawable.default_userinfo) {
            this.c = true;
            if (getWidth() > 0) {
                b();
                return;
            }
            return;
        }
        this.c = false;
        super.setBackgroundResource(i);
    }
}
