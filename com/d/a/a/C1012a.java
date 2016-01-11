package com.d.a.a;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.xiaomi.account.openauth.h;
import com.xiaomi.e.a;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

public class C1012a {
    public static final int a = 10;
    public static final int b = 10000;
    public static final int c = 5;
    public static final int d = 1500;
    public static final int e = 8192;
    public static final String f = "Accept-Encoding";
    public static final String g = "gzip";
    public static final String h = "AsyncHttpClient";
    private int i;
    private int j;
    private final DefaultHttpClient k;
    private final HttpContext l;
    private ExecutorService m;
    private final Map<Context, List<N>> n;
    private final Map<String, String> o;
    private boolean p;

    public C1012a() {
        this(false, 80, 443);
    }

    public C1012a(int i) {
        this(false, i, 443);
    }

    public C1012a(int i, int i2) {
        this(false, i, i2);
    }

    public C1012a(SchemeRegistry schemeRegistry) {
        this.i = a;
        this.j = b;
        this.p = true;
        HttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, (long) this.j);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(this.i));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, a);
        HttpConnectionParams.setSoTimeout(basicHttpParams, this.j);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, this.j);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, e);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        ClientConnectionManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        this.m = d();
        this.n = new WeakHashMap();
        this.o = new HashMap();
        this.l = new SyncBasicHttpContext(new BasicHttpContext());
        this.k = new DefaultHttpClient(threadSafeClientConnManager, basicHttpParams);
        this.k.addRequestInterceptor(new C1013b(this));
        this.k.addResponseInterceptor(new C1014c(this));
        this.k.addRequestInterceptor(new C1015d(this), 0);
        this.k.setHttpRequestRetryHandler(new T(c, d));
    }

    public C1012a(boolean z, int i, int i2) {
        this(C1012a.a(z, i, i2));
    }

    public static String a(boolean z, String str, O o) {
        String replace = z ? str.replace(" ", "%20") : str;
        if (o == null) {
            return replace;
        }
        String trim = o.b().trim();
        if (trim.equals(a.f) || trim.equals("?")) {
            return replace;
        }
        return (replace + (replace.contains("?") ? "&" : "?")) + trim;
    }

    private HttpEntity a(O o, S s) {
        HttpEntity httpEntity = null;
        if (o != null) {
            try {
                httpEntity = o.a(s);
            } catch (Throwable th) {
                if (s != null) {
                    s.sendFailureMessage(0, httpEntity, httpEntity, th);
                } else {
                    th.printStackTrace();
                }
            }
        }
        return httpEntity;
    }

    private HttpEntityEnclosingRequestBase a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, HttpEntity httpEntity) {
        if (httpEntity != null) {
            httpEntityEnclosingRequestBase.setEntity(httpEntity);
        }
        return httpEntityEnclosingRequestBase;
    }

    private static SchemeRegistry a(boolean z, int i, int i2) {
        if (z) {
            Log.d(h, "Beware! Using the fix is insecure, as it doesn't verify SSL certificates.");
        }
        if (i < 1) {
            i = 80;
            Log.d(h, "Invalid HTTP port number specified, defaulting to 80");
        }
        if (i2 < 1) {
            i2 = 443;
            Log.d(h, "Invalid HTTPS port number specified, defaulting to 443");
        }
        SocketFactory c = z ? I.c() : SSLSocketFactory.getSocketFactory();
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), i));
        schemeRegistry.register(new Scheme("https", c, i2));
        return schemeRegistry;
    }

    public static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Throwable e) {
                Log.w(h, "Cannot close input stream", e);
            }
        }
    }

    public static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Throwable e) {
                Log.w(h, "Cannot close output stream", e);
            }
        }
    }

    public static void a(Class<?> cls) {
        if (cls != null) {
            T.a(cls);
        }
    }

    public static void b(Class<?> cls) {
        if (cls != null) {
            T.b(cls);
        }
    }

    public N a(Context context, String str, O o, S s) {
        return a(this.k, this.l, new HttpHead(C1012a.a(this.p, str, o)), null, s, context);
    }

    public N a(Context context, String str, S s) {
        return a(context, str, null, s);
    }

    public N a(Context context, String str, HttpEntity httpEntity, String str2, S s) {
        return a(this.k, this.l, a(new HttpPost(URI.create(str).normalize()), httpEntity), str2, s, context);
    }

    public N a(Context context, String str, Header[] headerArr, O o, S s) {
        HttpUriRequest httpHead = new HttpHead(C1012a.a(this.p, str, o));
        if (headerArr != null) {
            httpHead.setHeaders(headerArr);
        }
        return a(this.k, this.l, httpHead, null, s, context);
    }

    public N a(Context context, String str, Header[] headerArr, O o, String str2, S s) {
        HttpUriRequest httpPost = new HttpPost(URI.create(str).normalize());
        if (o != null) {
            httpPost.setEntity(a(o, s));
        }
        if (headerArr != null) {
            httpPost.setHeaders(headerArr);
        }
        return a(this.k, this.l, httpPost, str2, s, context);
    }

    public N a(Context context, String str, Header[] headerArr, S s) {
        HttpUriRequest httpDelete = new HttpDelete(URI.create(str).normalize());
        if (headerArr != null) {
            httpDelete.setHeaders(headerArr);
        }
        return a(this.k, this.l, httpDelete, null, s, context);
    }

    public N a(Context context, String str, Header[] headerArr, HttpEntity httpEntity, String str2, S s) {
        HttpUriRequest a = a(new HttpPost(URI.create(str).normalize()), httpEntity);
        if (headerArr != null) {
            a.setHeaders(headerArr);
        }
        return a(this.k, this.l, a, str2, s, context);
    }

    public N a(String str, O o, S s) {
        return a(null, str, o, s);
    }

    public N a(String str, S s) {
        return a(null, str, null, s);
    }

    protected N a(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, S s, Context context) {
        if (httpUriRequest == null) {
            throw new IllegalArgumentException("HttpUriRequest must not be null");
        } else if (s == null) {
            throw new IllegalArgumentException("ResponseHandler must not be null");
        } else if (s.getUseSynchronousMode()) {
            throw new IllegalArgumentException("Synchronous ResponseHandler used in AsyncHttpClient. You should create your response handler in a looper thread or use SyncHttpClient instead.");
        } else {
            if (str != null) {
                httpUriRequest.setHeader("Content-Type", str);
            }
            s.setRequestHeaders(httpUriRequest.getAllHeaders());
            s.setRequestURI(httpUriRequest.getURI());
            Object c1018g = new C1018g(defaultHttpClient, httpContext, httpUriRequest, s);
            this.m.submit(c1018g);
            N n = new N(c1018g);
            if (context != null) {
                List list = (List) this.n.get(context);
                if (list == null) {
                    list = new LinkedList();
                    this.n.put(context, list);
                }
                if (s instanceof M) {
                    ((M) s).a(httpUriRequest);
                }
                list.add(n);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((N) it.next()).c()) {
                        it.remove();
                    }
                }
            }
            return n;
        }
    }

    public HttpClient a() {
        return this.k;
    }

    public void a(int i) {
        if (i < 1) {
            i = a;
        }
        this.i = i;
        ConnManagerParams.setMaxConnectionsPerRoute(this.k.getParams(), new ConnPerRouteBean(this.i));
    }

    public void a(int i, int i2) {
        this.k.setHttpRequestRetryHandler(new T(i, i2));
    }

    public void a(Context context, boolean z) {
        if (context == null) {
            Log.e(h, "Passed null Context to cancelRequests");
            return;
        }
        Runnable c1016e = new C1016e(this, context, z);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new Thread(c1016e).start();
        } else {
            c1016e.run();
        }
    }

    public void a(String str) {
        HttpProtocolParams.setUserAgent(this.k.getParams(), str);
    }

    public void a(String str, int i) {
        this.k.getParams().setParameter("http.route.default-proxy", new HttpHost(str, i));
    }

    public void a(String str, int i, String str2, String str3) {
        this.k.getCredentialsProvider().setCredentials(new AuthScope(str, i), new UsernamePasswordCredentials(str2, str3));
        this.k.getParams().setParameter("http.route.default-proxy", new HttpHost(str, i));
    }

    public void a(String str, String str2) {
        this.o.put(str, str2);
    }

    public void a(String str, String str2, AuthScope authScope) {
        a(str, str2, authScope, false);
    }

    public void a(String str, String str2, AuthScope authScope, boolean z) {
        Credentials usernamePasswordCredentials = new UsernamePasswordCredentials(str, str2);
        CredentialsProvider credentialsProvider = this.k.getCredentialsProvider();
        if (authScope == null) {
            authScope = AuthScope.ANY;
        }
        credentialsProvider.setCredentials(authScope, usernamePasswordCredentials);
        b(z);
    }

    public void a(String str, String str2, boolean z) {
        a(str, str2, null, z);
    }

    public void a(ExecutorService executorService) {
        this.m = executorService;
    }

    public void a(CookieStore cookieStore) {
        this.l.setAttribute("http.cookie-store", cookieStore);
    }

    public void a(RedirectHandler redirectHandler) {
        this.k.setRedirectHandler(redirectHandler);
    }

    public void a(SSLSocketFactory sSLSocketFactory) {
        this.k.getConnectionManager().getSchemeRegistry().register(new Scheme("https", sSLSocketFactory, 443));
    }

    public void a(boolean z) {
        a(z, z, z);
    }

    public void a(boolean z, boolean z2) {
        a(z, z2, true);
    }

    public void a(boolean z, boolean z2, boolean z3) {
        this.k.getParams().setBooleanParameter("http.protocol.reject-relative-redirect", !z2);
        this.k.getParams().setBooleanParameter("http.protocol.allow-circular-redirects", z3);
        this.k.setRedirectHandler(new C1010H(z));
    }

    public N b(Context context, String str, O o, S s) {
        return a(this.k, this.l, new HttpGet(C1012a.a(this.p, str, o)), null, s, context);
    }

    public N b(Context context, String str, S s) {
        return b(context, str, null, s);
    }

    public N b(Context context, String str, HttpEntity httpEntity, String str2, S s) {
        return a(this.k, this.l, a(new HttpPut(URI.create(str).normalize()), httpEntity), str2, s, context);
    }

    public N b(Context context, String str, Header[] headerArr, O o, S s) {
        HttpUriRequest httpGet = new HttpGet(C1012a.a(this.p, str, o));
        if (headerArr != null) {
            httpGet.setHeaders(headerArr);
        }
        return a(this.k, this.l, httpGet, null, s, context);
    }

    public N b(Context context, String str, Header[] headerArr, HttpEntity httpEntity, String str2, S s) {
        HttpUriRequest a = a(new HttpPut(URI.create(str).normalize()), httpEntity);
        if (headerArr != null) {
            a.setHeaders(headerArr);
        }
        return a(this.k, this.l, a, str2, s, context);
    }

    public N b(String str, O o, S s) {
        return b(null, str, o, s);
    }

    public N b(String str, S s) {
        return b(null, str, null, s);
    }

    public HttpContext b() {
        return this.l;
    }

    public void b(int i) {
        if (i < h.E) {
            i = b;
        }
        this.j = i;
        HttpParams params = this.k.getParams();
        ConnManagerParams.setTimeout(params, (long) this.j);
        HttpConnectionParams.setSoTimeout(params, this.j);
        HttpConnectionParams.setConnectionTimeout(params, this.j);
    }

    public void b(String str) {
        this.o.remove(str);
    }

    public void b(String str, String str2) {
        a(str, str2, false);
    }

    public void b(boolean z) {
        if (z) {
            this.k.addRequestInterceptor(new L(), 0);
        } else {
            this.k.removeRequestInterceptorByClass(L.class);
        }
    }

    public N c(Context context, String str, O o, S s) {
        return a(context, str, a(o, s), null, s);
    }

    public N c(Context context, String str, S s) {
        return a(this.k, this.l, new HttpDelete(URI.create(str).normalize()), null, s, context);
    }

    public N c(Context context, String str, Header[] headerArr, O o, S s) {
        HttpUriRequest httpDelete = new HttpDelete(C1012a.a(this.p, str, o));
        if (headerArr != null) {
            httpDelete.setHeaders(headerArr);
        }
        return a(this.k, this.l, httpDelete, null, s, context);
    }

    public N c(String str, O o, S s) {
        return c(null, str, o, s);
    }

    public N c(String str, S s) {
        return c(null, str, null, s);
    }

    public ExecutorService c() {
        return this.m;
    }

    public void c(boolean z) {
        for (List<N> list : this.n.values()) {
            if (list != null) {
                for (N a : list) {
                    a.a(z);
                }
            }
        }
        this.n.clear();
    }

    public N d(Context context, String str, O o, S s) {
        return b(context, str, a(o, s), null, s);
    }

    public N d(String str, O o, S s) {
        return d(null, str, o, s);
    }

    public N d(String str, S s) {
        return d(null, str, null, s);
    }

    protected ExecutorService d() {
        return Executors.newCachedThreadPool();
    }

    public void d(boolean z) {
        this.p = z;
    }

    public int e() {
        return this.i;
    }

    public N e(String str, S s) {
        return c(null, str, s);
    }

    public int f() {
        return this.j;
    }

    public void g() {
        this.k.getCredentialsProvider().clear();
    }

    public boolean h() {
        return this.p;
    }
}
