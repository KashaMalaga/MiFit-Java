package android.support.v4.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import java.util.List;
import java.util.Map;

public abstract class cn {
    private Matrix a;

    public Parcelable a(View view, Matrix matrix, RectF rectF) {
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        if (round <= 0 || round2 <= 0) {
            return null;
        }
        if (this.a == null) {
            this.a = new Matrix();
        }
        this.a.set(matrix);
        this.a.postTranslate(-rectF.left, -rectF.top);
        Parcelable createBitmap = Bitmap.createBitmap(round, round2, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.concat(this.a);
        view.draw(canvas);
        return createBitmap;
    }

    public View a(Context context, Parcelable parcelable) {
        if (!(parcelable instanceof Bitmap)) {
            return null;
        }
        Bitmap bitmap = (Bitmap) parcelable;
        View imageView = new ImageView(context);
        imageView.setImageBitmap(bitmap);
        return imageView;
    }

    public void a(List<View> list) {
    }

    public void a(List<String> list, List<View> list2, List<View> list3) {
    }

    public void a(List<String> list, Map<String, View> map) {
    }

    public void b(List<String> list, List<View> list2, List<View> list3) {
    }
}
