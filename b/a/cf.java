package b.a;

import com.d.a.a.C1012a;
import com.f.a.b.d.a;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.xiaomi.account.openauth.h;
import com.xiaomi.channel.b.v;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONObject;

public class cf {
    private static final String a = cf.class.getName();
    private Map<String, String> b;

    private static String a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), C1012a.e);
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            try {
                stringBuilder.append(new StringBuilder(String.valueOf(readLine)).append("\n").toString());
            } catch (Exception e) {
                stringBuilder = a;
                bX.b(stringBuilder, "Caught IOException in convertStreamToString()", e);
                return null;
            } finally {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                    bX.b(a, "Caught IOException in convertStreamToString()", e2);
                    return null;
                }
            }
        }
        return stringBuilder.toString();
    }

    private JSONObject a(String str) {
        int nextInt = new Random().nextInt(h.E);
        try {
            String property = System.getProperty("line.separator");
            if (str.length() <= 1) {
                bX.b(a, new StringBuilder(String.valueOf(nextInt)).append(":\tInvalid baseUrl.").toString());
                return null;
            }
            bX.a(a, new StringBuilder(String.valueOf(nextInt)).append(":\tget: ").append(str).toString());
            HttpUriRequest httpGet = new HttpGet(str);
            if (this.b != null && this.b.size() > 0) {
                for (String str2 : this.b.keySet()) {
                    httpGet.addHeader(str2, (String) this.b.get(str2));
                }
            }
            HttpResponse execute = new DefaultHttpClient(b()).execute(httpGet);
            if (execute.getStatusLine().getStatusCode() == v.C) {
                HttpEntity entity = execute.getEntity();
                if (entity != null) {
                    InputStream inflaterInputStream;
                    InputStream content = entity.getContent();
                    Header firstHeader = execute.getFirstHeader("Content-Encoding");
                    if (firstHeader == null || !firstHeader.getValue().equalsIgnoreCase(C1012a.g)) {
                        if (firstHeader != null) {
                            if (firstHeader.getValue().equalsIgnoreCase("deflate")) {
                                bX.a(a, new StringBuilder(String.valueOf(nextInt)).append("  Use InflaterInputStream get data....").toString());
                                inflaterInputStream = new InflaterInputStream(content);
                            }
                        }
                        inflaterInputStream = content;
                    } else {
                        bX.a(a, new StringBuilder(String.valueOf(nextInt)).append("  Use GZIPInputStream get data....").toString());
                        inflaterInputStream = new GZIPInputStream(content);
                    }
                    String a = a(inflaterInputStream);
                    bX.a(a, new StringBuilder(String.valueOf(nextInt)).append(":\tresponse: ").append(property).append(a).toString());
                    return a == null ? null : new JSONObject(a);
                }
            } else {
                bX.c(a, new StringBuilder(String.valueOf(nextInt)).append(":\tFailed to send message. StatusCode = ").append(execute.getStatusLine().getStatusCode()).append(C0352cm.a).append(str).toString());
            }
            return null;
        } catch (Exception e) {
            bX.c(a, new StringBuilder(String.valueOf(nextInt)).append(":\tClientProtocolException,Failed to send message.").append(str).toString(), e);
            return null;
        } catch (Exception e2) {
            bX.c(a, new StringBuilder(String.valueOf(nextInt)).append(":\tIOException,Failed to send message.").append(str).toString(), e2);
            return null;
        }
    }

    private JSONObject a(String str, JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        int nextInt = new Random().nextInt(h.E);
        bX.c(a, new StringBuilder(String.valueOf(nextInt)).append(":\trequest: ").append(str).append(C0352cm.a).append(jSONObject2).toString());
        Object httpPost = new HttpPost(str);
        HttpClient defaultHttpClient = new DefaultHttpClient(b());
        try {
            if (a()) {
                byte[] a = C0351cl.a("content=" + jSONObject2, Charset.defaultCharset().toString());
                httpPost.addHeader("Content-Encoding", "deflate");
                httpPost.setEntity(new InputStreamEntity(new ByteArrayInputStream(a), (long) a.length));
            } else {
                List arrayList = new ArrayList(1);
                arrayList.add(new BasicNameValuePair(ParamKey.CONTENT, jSONObject2));
                httpPost.setEntity(new UrlEncodedFormEntity(arrayList, com.d.a.a.h.DEFAULT_CHARSET));
            }
            HttpResponse execute = defaultHttpClient.execute(httpPost);
            if (execute.getStatusLine().getStatusCode() == v.C) {
                HttpEntity entity = execute.getEntity();
                if (entity == null) {
                    return null;
                }
                InputStream content = entity.getContent();
                Header firstHeader = execute.getFirstHeader("Content-Encoding");
                InputStream inflaterInputStream = (firstHeader == null || !firstHeader.getValue().equalsIgnoreCase("deflate")) ? content : new InflaterInputStream(content);
                String a2 = a(inflaterInputStream);
                bX.a(a, new StringBuilder(String.valueOf(nextInt)).append(":\tresponse: ").append(C0352cm.a).append(a2).toString());
                return a2 == null ? null : new JSONObject(a2);
            } else {
                bX.c(a, new StringBuilder(String.valueOf(nextInt)).append(":\tFailed to send message. StatusCode = ").append(execute.getStatusLine().getStatusCode()).append(C0352cm.a).append(str).toString());
                return null;
            }
        } catch (Exception e) {
            bX.c(a, new StringBuilder(String.valueOf(nextInt)).append(":\tClientProtocolException,Failed to send message.").append(str).toString(), e);
            return null;
        } catch (Exception e2) {
            bX.c(a, new StringBuilder(String.valueOf(nextInt)).append(":\tIOException,Failed to send message.").append(str).toString(), e2);
            return null;
        } catch (Exception e22) {
            bX.c(a, new StringBuilder(String.valueOf(nextInt)).append(":\tIOException,Failed to send message.").append(str).toString(), e22);
            return null;
        }
    }

    private HttpParams b() {
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, C1012a.b);
        HttpConnectionParams.setSoTimeout(basicHttpParams, a.b);
        HttpProtocolParams.setUserAgent(basicHttpParams, System.getProperty("http.agent"));
        return basicHttpParams;
    }

    private void b(String str) {
        if (C0352cm.d(str) || (C0343cg.c.equals(str.trim()) ^ C0343cg.b.equals(str.trim())) == 0) {
            throw new RuntimeException("\u9a8c\u8bc1\u8bf7\u6c42\u65b9\u5f0f\u5931\u8d25[" + str + "]");
        }
    }

    public cf a(Map<String, String> map) {
        this.b = map;
        return this;
    }

    public <T extends C0345ch> T a(C0343cg c0343cg, Class<T> cls) {
        String trim = c0343cg.c().trim();
        b(trim);
        JSONObject a = C0343cg.c.equals(trim) ? a(c0343cg.b()) : C0343cg.b.equals(trim) ? a(c0343cg.d, c0343cg.a()) : null;
        if (a == null) {
            return null;
        }
        try {
            return (C0345ch) cls.getConstructor(new Class[]{JSONObject.class}).newInstance(new Object[]{a});
        } catch (Exception e) {
            bX.b(a, "SecurityException", e);
            return null;
        } catch (Exception e2) {
            bX.b(a, "NoSuchMethodException", e2);
            return null;
        } catch (Exception e22) {
            bX.b(a, "IllegalArgumentException", e22);
            return null;
        } catch (Exception e222) {
            bX.b(a, "InstantiationException", e222);
            return null;
        } catch (Exception e2222) {
            bX.b(a, "IllegalAccessException", e2222);
            return null;
        } catch (Exception e22222) {
            bX.b(a, "InvocationTargetException", e22222);
            return null;
        }
    }

    public boolean a() {
        return false;
    }
}
