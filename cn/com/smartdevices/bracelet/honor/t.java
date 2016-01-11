package cn.com.smartdevices.bracelet.honor;

import android.content.Context;
import android.os.Message;
import cn.com.smartdevices.bracelet.C0596r;
import com.d.a.a.h;
import org.apache.http.Header;

class t extends h {
    final /* synthetic */ Message a;
    final /* synthetic */ Context b;
    final /* synthetic */ MedalManager c;

    t(MedalManager medalManager, Message message, Context context) {
        this.c = medalManager;
        this.a = message;
        this.b = context;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        this.a.obj = null;
        C0596r.e("MedalManager", "Medal config list error\n" + th);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        String str = new String(bArr);
        C0596r.b("MedalManager", "Medal config status:" + i + " \nbody:" + str);
        this.a.obj = P.b(this.b, str);
    }
}
