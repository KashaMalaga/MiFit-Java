package cn.com.smartdevices.bracelet.tag.a;

import cn.com.smartdevices.bracelet.C0596r;
import com.d.a.a.h;
import com.xiaomi.channel.gamesdk.b;
import java.io.File;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

class d extends h {
    final /* synthetic */ g a;
    final /* synthetic */ File b;
    final /* synthetic */ File c;
    final /* synthetic */ c d;

    d(c cVar, g gVar, File file, File file2) {
        this.d = cVar;
        this.a = gVar;
        this.b = file;
        this.c = file2;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.a(c.a, th.getMessage());
        if (this.a != null) {
            this.a.a(false, th.getMessage());
        }
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        if (this.a != null) {
            this.a.a(true, null);
        }
        try {
            if (new JSONObject(new String(bArr)).optInt(b.a) == 1) {
                this.b.delete();
                this.c.delete();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
