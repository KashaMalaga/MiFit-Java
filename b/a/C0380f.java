package b.a;

import org.json.JSONArray;

public class C0380f extends aW {
    public C0380f(String str) {
        a(new JSONArray(str));
    }

    public C0380f(JSONArray jSONArray) {
        a(jSONArray);
    }

    private void a(JSONArray jSONArray) {
        a(jSONArray.getString(0));
        a((long) jSONArray.getInt(1));
    }
}
