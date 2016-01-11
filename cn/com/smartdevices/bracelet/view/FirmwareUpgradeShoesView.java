package cn.com.smartdevices.bracelet.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import cn.com.smartdevices.bracelet.model.ShareData;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import com.xiaomi.hm.health.k;

public class FirmwareUpgradeShoesView extends View {
    private float a;
    private BitmapDrawable b;
    private float c;
    private float d;
    private RectF e;
    private Path f;
    private int g;

    public FirmwareUpgradeShoesView(Context context) {
        this(context, null);
    }

    public FirmwareUpgradeShoesView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FirmwareUpgradeShoesView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = 1;
        this.b = (BitmapDrawable) context.getResources().getDrawable(k.ic_fw_upgrade_shoes);
        this.b.setAntiAlias(true);
        this.f = new Path();
    }

    private void a(Canvas canvas) {
        this.b.setAlpha(ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD);
        this.b.draw(canvas);
    }

    private void b(Canvas canvas) {
        this.b.setAlpha(HeartRateInfo.HR_EMPTY_VALUE);
        this.b.draw(canvas);
    }

    public int a() {
        return this.g;
    }

    @SuppressLint({"NewApi"})
    public void a(float f) {
        this.a = f;
        postInvalidateOnAnimation();
    }

    public void a(int i) {
        this.g = i;
    }

    protected void onDraw(Canvas canvas) {
        if (this.a == 0.0f) {
            a(canvas);
        } else if (this.a == 1.0f) {
            b(canvas);
        } else {
            a(canvas);
            this.f.moveTo(this.c, this.d);
            this.f.arcTo(this.e, -90.0f, 360.0f * (this.a / ((float) this.g)));
            this.f.close();
            canvas.clipPath(this.f);
            this.f.rewind();
            b(canvas);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.b.setBounds(0, 0, i, i2);
        this.c = ((float) i) / 2.0f;
        this.d = ((float) i2) / 2.0f;
        float sqrt = (float) Math.sqrt((double) ((this.c * this.c) + (this.d * this.d)));
        this.e = new RectF(this.c - sqrt, this.d - sqrt, this.c + sqrt, sqrt + this.d);
    }
}
