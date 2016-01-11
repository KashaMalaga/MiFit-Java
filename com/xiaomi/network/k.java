package com.xiaomi.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import cn.com.smartdevices.bracelet.gps.c.a;
import com.activeandroid.b;
import com.d.a.a.C1012a;
import com.d.a.a.h;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.http.NameValuePair;

public class k {
    public static final Pattern a = Pattern.compile("([^\\s;]+)(.*)");
    public static final Pattern b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
    public static final Pattern c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    public static InputStream a(Context context, URL url, String str, String str2) {
        return a(context, url, str, str2, null, null);
    }

    public static InputStream a(Context context, URL url, String str, String str2, Map<String, String> map, m mVar) {
        if (context == null) {
            throw new IllegalArgumentException("context");
        } else if (url == null) {
            throw new IllegalArgumentException(SocialConstants.PARAM_URL);
        } else {
            try {
                HttpURLConnection.setFollowRedirects(true);
                HttpURLConnection b = b(context, url);
                b.setConnectTimeout(C1012a.b);
                b.setReadTimeout(a.k);
                if (!TextUtils.isEmpty(str)) {
                    b.setRequestProperty("User-Agent", str);
                }
                if (str2 != null) {
                    b.setRequestProperty("Cookie", str2);
                }
                if (map != null) {
                    for (String str3 : map.keySet()) {
                        b.setRequestProperty(str3, (String) map.get(str3));
                    }
                }
                if (mVar != null) {
                    if (url.getProtocol().equals("http") || url.getProtocol().equals("https")) {
                        mVar.a = b.getResponseCode();
                        if (mVar.b == null) {
                            mVar.b = new HashMap();
                        }
                        int i = 0;
                        while (true) {
                            Object headerFieldKey = b.getHeaderFieldKey(i);
                            CharSequence headerField = b.getHeaderField(i);
                            if (headerFieldKey == null && headerField == null) {
                                break;
                            }
                            if (!(TextUtils.isEmpty(headerFieldKey) || TextUtils.isEmpty(headerField))) {
                                mVar.b.put(headerFieldKey.toLowerCase(), headerField);
                            }
                            i++;
                        }
                    }
                }
                return new l(b.getInputStream());
            } catch (IOException e) {
                throw e;
            } catch (Throwable th) {
                IOException iOException = new IOException(th.getMessage());
            }
        }
    }

    public static String a(Context context, String str, List<NameValuePair> list) {
        return a(context, str, (List) list, null, null, null);
    }

    public static String a(Context context, String str, List<NameValuePair> list, Map<String, String> map, String str2, String str3) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(SocialConstants.PARAM_URL);
        }
        try {
            HttpURLConnection b = b(context, new URL(str));
            b.setConnectTimeout(C1012a.b);
            b.setReadTimeout(a.k);
            b.setRequestMethod(Constants.HTTP_POST);
            if (!TextUtils.isEmpty(str2)) {
                b.setRequestProperty("User-Agent", str2);
            }
            if (str3 != null) {
                b.setRequestProperty("Cookie", str3);
            }
            String a = a((List) list);
            if (a == null) {
                throw new IllegalArgumentException("nameValuePairs");
            }
            b.setDoOutput(true);
            byte[] bytes = a.getBytes();
            b.getOutputStream().write(bytes, 0, bytes.length);
            b.getOutputStream().flush();
            b.getOutputStream().close();
            Log.d("com.xiaomi.common.Network", "Http POST Response Code: " + b.getResponseCode());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new l(b.getInputStream())));
            StringBuffer stringBuffer = new StringBuffer();
            String property = System.getProperty("line.separator");
            for (a = bufferedReader.readLine(); a != null; a = bufferedReader.readLine()) {
                stringBuffer.append(a);
                stringBuffer.append(property);
            }
            a = stringBuffer.toString();
            bufferedReader.close();
            if (map != null) {
                while (true) {
                    String headerFieldKey = b.getHeaderFieldKey(i);
                    String headerField = b.getHeaderField(i);
                    if (headerFieldKey == null && headerField == null) {
                        break;
                    }
                    map.put(headerFieldKey, headerField);
                    i = (i + 1) + 1;
                }
            }
            return a;
        } catch (IOException e) {
            throw e;
        } catch (Throwable th) {
            IOException iOException = new IOException(th.getMessage());
        }
    }

    public static String a(Context context, URL url) {
        return a(context, url, null, h.DEFAULT_CHARSET, null);
    }

    public static String a(Context context, URL url, String str, String str2, String str3) {
        InputStream inputStream = null;
        try {
            StringBuilder stringBuilder = new StringBuilder(b.a);
            inputStream = a(context, url, str, str3);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str2), b.a);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(readLine);
                stringBuilder.append("\r\n");
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Log.e("com.xiaomi.common.Network", "Failed to close responseStream" + e.toString());
                }
            }
            return stringBuilder.toString();
        } catch (IOException e2) {
            throw e2;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    Log.e("com.xiaomi.common.Network", "Failed to close responseStream" + e3.toString());
                }
            }
        }
    }

    public static String a(URL url) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(url.getProtocol()).append("://").append("10.0.0.172").append(url.getPath());
        if (!TextUtils.isEmpty(url.getQuery())) {
            stringBuilder.append("?").append(url.getQuery());
        }
        return stringBuilder.toString();
    }

    public static String a(List<NameValuePair> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (NameValuePair nameValuePair : list) {
            try {
                if (nameValuePair.getValue() != null) {
                    stringBuffer.append(URLEncoder.encode(nameValuePair.getName(), h.DEFAULT_CHARSET));
                    stringBuffer.append("=");
                    stringBuffer.append(URLEncoder.encode(nameValuePair.getValue(), h.DEFAULT_CHARSET));
                    stringBuffer.append("&");
                }
            } catch (UnsupportedEncodingException e) {
                Log.d("com.xiaomi.common.Network", "Failed to convert from param list to string: " + e.toString());
                Log.d("com.xiaomi.common.Network", "pair: " + nameValuePair.toString());
                return null;
            }
        }
        return (stringBuffer.length() > 0 ? stringBuffer.deleteCharAt(stringBuffer.length() - 1) : stringBuffer).toString();
    }

    public static boolean a(Context context) {
        if (!"CN".equalsIgnoreCase(((TelephonyManager) context.getSystemService("phone")).getSimCountryIso())) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return false;
                }
                String extraInfo = activeNetworkInfo.getExtraInfo();
                return (TextUtils.isEmpty(extraInfo) || extraInfo.length() < 3 || extraInfo.contains("ctwap")) ? false : extraInfo.regionMatches(true, extraInfo.length() - 3, "wap", 0, 3);
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    public static HttpURLConnection b(Context context, URL url) {
        if (b(context)) {
            return (HttpURLConnection) url.openConnection(new Proxy(Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
        }
        if (!a(context)) {
            return (HttpURLConnection) url.openConnection();
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(a(url)).openConnection();
        httpURLConnection.addRequestProperty("X-Online-Host", url.getHost());
        return httpURLConnection;
    }

    public static boolean b(Context context) {
        if (!"CN".equalsIgnoreCase(((TelephonyManager) context.getSystemService("phone")).getSimCountryIso())) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return false;
                }
                String extraInfo = activeNetworkInfo.getExtraInfo();
                return (TextUtils.isEmpty(extraInfo) || extraInfo.length() < 3) ? false : extraInfo.contains("ctwap");
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e2) {
            return false;
        }
    }
}
