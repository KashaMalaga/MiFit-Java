package cn.com.smartdevices.bracelet;

import com.d.a.a.h;
import com.xiaomi.channel.gamesdk.b;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

final class S extends h {
    S() {
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.d("Utils", "uploadIMEI fail");
        Keeper.setUploadImeiStatus(0);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        if (bArr != null) {
            String str = new String(bArr);
            C0596r.d("Utils", "Response uploadIMEI: " + str);
            try {
                if (((Integer) new JSONObject(str).get(b.a)).intValue() == 1) {
                    Keeper.setUploadImeiStatus(1);
                    return;
                } else {
                    Keeper.setUploadImeiStatus(0);
                    return;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                Keeper.setUploadImeiStatus(0);
                return;
            }
        }
        C0596r.d("Utils", "Response uploadIMEI return null");
        Keeper.setUploadImeiStatus(0);
    }
}
