package cn.com.smartdevices.bracelet.activity;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.model.ResponseResult;
import com.c.a.C0993k;
import com.d.a.a.h;
import java.util.List;
import org.apache.http.Header;

class v extends h {
    final /* synthetic */ StartUpActivity a;

    v(StartUpActivity startUpActivity) {
        this.a = startUpActivity;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.d("StartUpActivity", "getStartingUpUrl onFailure");
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        if (bArr != null) {
            String str = new String(bArr);
            C0596r.d("StartUpActivity", "responseString = " + str);
            try {
                ResponseResult responseResult = (ResponseResult) new C0993k().a(str, new w(this).getType());
                if (responseResult.getCode() == 1 && responseResult.getData() != null) {
                    this.a.a((List) responseResult.getData());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
