package b.a;

import com.tencent.connect.common.Constants;
import org.json.JSONObject;

public abstract class C0343cg {
    protected static String b = Constants.HTTP_POST;
    protected static String c = Constants.HTTP_GET;
    protected String d;

    public C0343cg(String str) {
        this.d = str;
    }

    public abstract JSONObject a();

    public void a(String str) {
        this.d = str;
    }

    public abstract String b();

    protected String c() {
        return b;
    }

    public String d() {
        return this.d;
    }
}
