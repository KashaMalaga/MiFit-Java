package com.amap.api.services.help;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.d;
import com.amap.api.services.core.e;
import com.amap.api.services.core.k;
import com.amap.api.services.core.l;
import com.xiaomi.e.a;
import java.util.List;

public final class Inputtips {
    Handler a = new a(this);
    private Context b;
    private InputtipsListener c;

    public interface InputtipsListener {
        void onGetInputtips(List<Tip> list, int i);
    }

    public Inputtips(Context context, InputtipsListener inputtipsListener) {
        d.a(context);
        this.b = context.getApplicationContext();
        this.c = inputtipsListener;
    }

    public void requestInputtips(final String str, final String str2) {
        if (str == null || str.equals(a.f)) {
            throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
        }
        new Thread(this) {
            final /* synthetic */ Inputtips c;

            public void run() {
                k kVar = new k(new l(str, str2), e.a(this.c.b));
                Message message = new Message();
                try {
                    message.obj = (List) kVar.getData();
                    message.what = 0;
                } catch (AMapException e) {
                    message.what = e.getErrorCode();
                } finally {
                    this.c.a.sendMessage(message);
                }
            }
        }.start();
    }
}
