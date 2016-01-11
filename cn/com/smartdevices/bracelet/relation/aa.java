package cn.com.smartdevices.bracelet.relation;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.relation.a.a;
import com.c.b.x;
import com.huami.android.zxing.z;

class aa extends AsyncTask<a, Integer, Bitmap> {
    final /* synthetic */ UserQRCardActivity a;
    private int b = 0;

    public aa(UserQRCardActivity userQRCardActivity, int i) {
        this.a = userQRCardActivity;
        this.b = i;
    }

    protected Bitmap a(a... aVarArr) {
        if (aVarArr == null || aVarArr.length == 0) {
            return null;
        }
        a aVar = aVarArr[0];
        a aVar2 = new a();
        aVar2.a = aVar.a;
        aVar2.b = aVar.b;
        try {
            Bitmap a = z.a(aVar2, this.b);
            if (a == null) {
                return a;
            }
            Utils.b(this.a.c.getAbsolutePath(), a);
            return a;
        } catch (x e) {
            return null;
        }
    }

    protected void a(Bitmap bitmap) {
        this.a.f.setEnabled(true);
        this.a.d.setImageBitmap(bitmap);
        this.a.e = bitmap;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((a[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Bitmap) obj);
    }
}
