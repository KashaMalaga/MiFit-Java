package cn.com.smartdevices.bracelet;

import cn.com.smartdevices.bracelet.weight.goal.WeightGoal;
import com.d.a.a.h;
import org.apache.http.Header;

final class O extends h {
    final /* synthetic */ ae a;
    final /* synthetic */ WeightGoal b;

    O(ae aeVar, WeightGoal weightGoal) {
        this.a = aeVar;
        this.b = weightGoal;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e("Utils", "upload person target fail");
        this.a.a();
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        if (bArr != null) {
            C0596r.e("Utils", "Response syncTargetWeightToServer: " + new String(bArr));
            this.a.a(this.b);
            return;
        }
        this.a.a();
    }
}
