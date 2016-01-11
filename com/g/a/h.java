package com.g.a;

import android.graphics.Bitmap;
import android.os.Message;
import android.support.v4.app.C0056bn;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.xiaomi.e.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

final class h extends WebChromeClient {
    WebChromeClient a = null;
    final /* synthetic */ g b;
    private final String c = "ekv";
    private final String d = C0056bn.d;

    public h(g gVar, WebChromeClient webChromeClient) {
        this.b = gVar;
        if (webChromeClient == null) {
            this.a = new WebChromeClient();
        } else {
            this.a = webChromeClient;
        }
    }

    public void onCloseWindow(WebView webView) {
        this.a.onCloseWindow(webView);
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        return this.a.onCreateWindow(webView, z, z2, message);
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return this.a.onJsAlert(webView, str, str2, jsResult);
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return this.a.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return this.a.onJsConfirm(webView, str, str2, jsResult);
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ("ekv".equals(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str3);
                Map hashMap = new HashMap();
                String str4 = (String) jSONObject.remove(SyncShoesDataService.d);
                int intValue = jSONObject.isNull("duration") ? 0 : ((Integer) jSONObject.remove("duration")).intValue();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str5 = (String) keys.next();
                    hashMap.put(str5, jSONObject.getString(str5));
                }
                f.a().a(this.b.a, str4, hashMap, (long) intValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (!C0056bn.d.equals(str2)) {
            return this.a.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        } else {
            try {
                JSONObject jSONObject2 = new JSONObject(str3);
                String optString = jSONObject2.optString("label");
                if (a.f.equals(optString)) {
                    optString = null;
                }
                f.a().a(this.b.a, jSONObject2.getString(f.aC), optString, (long) jSONObject2.optInt("duration"), 1);
            } catch (Exception e2) {
            }
        }
        jsPromptResult.confirm();
        return true;
    }

    public void onProgressChanged(WebView webView, int i) {
        this.a.onProgressChanged(webView, i);
    }

    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        this.a.onReceivedIcon(webView, bitmap);
    }

    public void onReceivedTitle(WebView webView, String str) {
        this.a.onReceivedTitle(webView, str);
    }

    public void onRequestFocus(WebView webView) {
        this.a.onRequestFocus(webView);
    }
}
