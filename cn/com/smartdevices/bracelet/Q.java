package cn.com.smartdevices.bracelet;

import android.content.Context;
import cn.com.smartdevices.bracelet.j.n;
import cn.com.smartdevices.bracelet.weight.goal.WeightGoal;
import com.d.a.a.h;
import java.util.List;
import org.apache.http.Header;

final class Q extends h {
    final /* synthetic */ Context a;
    final /* synthetic */ ad b;

    Q(Context context, ad adVar) {
        this.a = context;
        this.b = adVar;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e("Utils", "get from server fail");
        this.b.a(null);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        if (bArr != null) {
            String str = new String(bArr);
            C0596r.e("Utils", "Response getTargetWeightGoalFromServer : " + str);
            if (n.a(this.a, str).c()) {
                List j = Utils.k(str);
                if (j == null || j.size() <= 0) {
                    C0596r.e("Utils", " info size is null or 0");
                    this.b.a(null);
                    return;
                }
                C0596r.e("Utils", "item size is " + j.size());
                this.b.a((WeightGoal) j.get(0));
                return;
            }
            this.b.a(null);
        }
    }
}
