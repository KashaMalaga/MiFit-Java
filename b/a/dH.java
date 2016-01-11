package b.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.d.a.a.C1012a;
import com.d.a.a.h;
import com.g.a.C1059a;
import com.g.a.p;
import com.xiaomi.channel.b.v;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import kankan.wheel.widget.a;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class dH {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    private final int d = a;
    private String e;
    private String f = "10.0.0.172";
    private int g = 80;
    private Context h;
    private dM i;
    private ds j;

    public dH(Context context) {
        this.h = context;
        this.j = du.b(context);
        this.e = a(context);
    }

    private String a(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(p.b);
        stringBuffer.append("/");
        stringBuffer.append(p.c);
        stringBuffer.append(" ");
        try {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(bW.v(context));
            stringBuffer2.append("/");
            stringBuffer2.append(bW.d(context));
            stringBuffer2.append(" ");
            stringBuffer2.append(Build.MODEL);
            stringBuffer2.append("/");
            stringBuffer2.append(VERSION.RELEASE);
            stringBuffer2.append(" ");
            stringBuffer2.append(C0352cm.a(C1059a.a(context)));
            stringBuffer.append(URLEncoder.encode(stringBuffer2.toString(), h.DEFAULT_CHARSET));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    private boolean a() {
        if (this.h.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.h.getPackageName()) != 0) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.h.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(activeNetworkInfo == null || activeNetworkInfo.getType() == a)) {
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (extraInfo != null && (extraInfo.equals("cmwap") || extraInfo.equals("3gwap") || extraInfo.equals("uniwap"))) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private byte[] a(byte[] bArr, String str) {
        HttpUriRequest httpPost = new HttpPost(str);
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, C1012a.b);
        HttpConnectionParams.setSoTimeout(basicHttpParams, a.as);
        HttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
        httpPost.addHeader("X-Umeng-Sdk", this.e);
        httpPost.addHeader("Msg-Type", "envelope");
        InputStream content;
        try {
            if (a()) {
                defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(this.f, this.g));
            }
            httpPost.setEntity(new InputStreamEntity(new ByteArrayInputStream(bArr), (long) bArr.length));
            if (this.i != null) {
                this.i.e();
            }
            HttpResponse execute = defaultHttpClient.execute(httpPost);
            if (this.i != null) {
                this.i.f();
            }
            bX.a(p.e, "status code : " + execute.getStatusLine().getStatusCode());
            if (execute.getStatusLine().getStatusCode() != v.C) {
                return null;
            }
            bX.a(p.e, "Sent message to " + str);
            HttpEntity entity = execute.getEntity();
            if (entity == null) {
                return null;
            }
            content = entity.getContent();
            byte[] b = C0352cm.b(content);
            C0352cm.c(content);
            return b;
        } catch (Exception e) {
            bX.b(p.e, "ClientProtocolException,Failed to send message.", e);
            return null;
        } catch (Exception e2) {
            bX.b(p.e, "IOException,Failed to send message.", e2);
            return null;
        } catch (Throwable th) {
            C0352cm.c(content);
        }
    }

    private int b(byte[] bArr) {
        cq c0320bl = new C0320bl();
        try {
            new C0360cv(new cP()).a(c0320bl, bArr);
            if (c0320bl.a == a) {
                this.j.b(c0320bl.j());
                this.j.c();
            }
            bX.a(p.e, "send log:" + c0320bl.f());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c0320bl.a == a ? b : c;
    }

    public int a(byte[] bArr) {
        byte[] bArr2 = null;
        int i = 0;
        while (i < p.f.length) {
            bArr2 = a(bArr, p.f[i]);
            if (bArr2 != null) {
                if (this.i != null) {
                    this.i.c();
                }
                return bArr2 != null ? a : b(bArr2);
            } else {
                if (this.i != null) {
                    this.i.d();
                }
                i += a;
            }
        }
        if (bArr2 != null) {
        }
    }

    public void a(dM dMVar) {
        this.i = dMVar;
    }
}
