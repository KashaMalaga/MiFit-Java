package cn.com.smartdevices.bracelet.relation;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.C0151az;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0544h;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.j.n;
import cn.com.smartdevices.bracelet.view.O;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.f.a.b.a.f;
import com.huami.android.widget.share.h;
import com.huami.android.widget.share.l;
import com.huami.android.widget.share.q;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.r;
import java.io.File;
import java.io.Serializable;

class ab extends AsyncTask<Bitmap, Integer, File> {
    private static final int b = 680;
    private static final int c = 958;
    private static final int d = 160;
    private static final int e = 100;
    final /* synthetic */ UserQRCardActivity a;
    private File f;

    private ab(UserQRCardActivity userQRCardActivity) {
        this.a = userQRCardActivity;
    }

    private void a(String str, float f, float f2, Paint paint, Canvas canvas) {
        paint.setTextAlign(Align.CENTER);
        String[] split = str.split("\n");
        float descent = (-paint.ascent()) + paint.descent();
        if (paint.getStyle() == Style.FILL_AND_STROKE || paint.getStyle() == Style.STROKE) {
            descent += paint.getStrokeWidth();
        }
        float f3 = descent * 0.3f;
        for (int i = 0; i < split.length; i++) {
            canvas.drawText(split[i], f, ((descent + f3) * ((float) i)) + f2, paint);
        }
    }

    protected File a(Bitmap... bitmapArr) {
        this.f = new File(this.a.i, this.a.h.a + "_share.png");
        if (this.f.exists()) {
            return this.f;
        }
        Bitmap bitmap = bitmapArr[0];
        Bitmap createBitmap = Bitmap.createBitmap(b, c, Config.ARGB_8888);
        Resources resources = this.a.getResources();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Canvas canvas = new Canvas(createBitmap);
        canvas.save();
        paint.setColor(-1);
        canvas.drawRect(new Rect(0, 0, b, d), paint);
        RectF rectF = new RectF(36.0f, BitmapDescriptorFactory.HUE_ORANGE, 136.0f, 130.0f);
        paint.setColor(Color.rgb(190, 190, 190));
        canvas.drawOval(rectF, paint);
        Bitmap bitmap2 = null;
        if (!(this.a.h == null || TextUtils.isEmpty(this.a.h.c))) {
            Bitmap a = C0544h.a().a(this.a.h.c, new f(90, 90));
            if (a != null) {
                bitmap2 = O.a(a);
                a.recycle();
            }
        }
        if (bitmap2 == null) {
            bitmap2 = BitmapFactory.decodeResource(resources, k.default_friend_avatar);
        }
        canvas.drawBitmap(bitmap2, new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight()), new RectF(41.0f, 35.0f, 131.0f, 125.0f), paint);
        paint.setColor(Color.rgb(86, 86, 86));
        paint.setTextSize(BitmapDescriptorFactory.HUE_ORANGE);
        canvas.drawText(this.a.h.b, 156.0f, 75.0f, paint);
        paint.setColor(Color.rgb(186, 186, 186));
        paint.setTextSize(26.0f);
        canvas.drawText(this.a.h.a + a.f, 156.0f, 111.0f, paint);
        paint.setColor(Color.rgb(246, 246, 246));
        canvas.drawRect(new Rect(0, d, b, 858), paint);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        Rect rect2 = new Rect(142, 210, 538, 606);
        paint.setColor(C0151az.s);
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        String string = this.a.getString(r.label_share_info1);
        paint.setColor(Color.rgb(86, 86, 86));
        paint.setTextSize(BitmapDescriptorFactory.HUE_ORANGE);
        canvas.drawText(string, (float) ((680 - (string.length() * 30)) / 2), (float) n.e, paint);
        paint.setColor(Color.rgb(186, 186, 186));
        paint.setTextSize(26.0f);
        a(this.a.getString(r.label_share_info2), 340.0f, (float) 722, paint, canvas);
        rect2 = new Rect(0, 858, b, c);
        paint.setColor(Color.rgb(246, 246, 246));
        canvas.drawRect(rect2, paint);
        bitmap2 = BitmapFactory.decodeResource(resources, k.ic_share_logo);
        int height = (((100 - bitmap2.getHeight()) / 2) + c) - 100;
        int width = (680 - bitmap2.getWidth()) / 2;
        paint.setColor(C0151az.s);
        canvas.drawBitmap(bitmap2, (float) width, (float) height, paint);
        canvas.restore();
        Utils.a(this.f.getAbsolutePath(), createBitmap);
        return this.f;
    }

    protected void a(File file) {
        String string = this.a.getString(r.label_my_qrcode);
        String string2 = this.a.getString(r.share_to_topic);
        Serializable lVar = new l();
        lVar.a = string;
        lVar.d = a.f;
        lVar.c = string;
        lVar.e = file.getAbsolutePath();
        lVar.b = string2;
        Bundle bundle = new Bundle();
        bundle.putSerializable(h.a, lVar);
        bundle.putBoolean(q.b, true);
        h hVar = new h();
        hVar.setArguments(bundle);
        hVar.a(new ac(this));
        hVar.show(this.a.getFragmentManager(), C0401a.aY);
        if (this.a.k != null) {
            this.a.k.dismiss();
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Bitmap[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((File) obj);
    }
}
