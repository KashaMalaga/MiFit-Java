package com.xiaomi.channel.a.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.d.a.a.C1012a;
import com.d.a.a.h;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.http.NameValuePair;

public class a {
    public static final Pattern a = Pattern.compile("([^\\s;]+)(.*)");
    public static final Pattern b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
    public static final Pattern c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    public static int a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                return activeNetworkInfo == null ? -1 : activeNetworkInfo.getType();
            } catch (Exception e) {
                return -1;
            }
        } catch (Exception e2) {
            return -1;
        }
    }

    public static String a(Context context, String str, List<NameValuePair> list) {
        return a(context, str, list, null, null, null);
    }

    public static String a(Context context, String str, List<NameValuePair> list, c cVar, String str2, String str3) {
        BufferedReader bufferedReader;
        IOException e;
        Throwable th;
        BufferedReader bufferedReader2;
        int i = 0;
        BufferedReader bufferedReader3 = null;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(SocialConstants.PARAM_URL);
        }
        OutputStream outputStream;
        try {
            HttpURLConnection a = a(context, a(str));
            a.setConnectTimeout(C1012a.b);
            a.setReadTimeout(cn.com.smartdevices.bracelet.gps.c.a.k);
            a.setRequestMethod(Constants.HTTP_POST);
            if (!TextUtils.isEmpty(str2)) {
                a.setRequestProperty("User-Agent", str2);
            }
            if (str3 != null) {
                a.setRequestProperty("Cookie", str3);
            }
            String a2 = a((List) list);
            if (a2 == null) {
                throw new IllegalArgumentException("nameValuePairs");
            }
            OutputStream outputStream2;
            String headerField;
            a.setDoOutput(true);
            byte[] bytes = a2.getBytes();
            outputStream = a.getOutputStream();
            try {
                outputStream.write(bytes, 0, bytes.length);
                outputStream.flush();
                outputStream.close();
                outputStream2 = null;
                int responseCode = a.getResponseCode();
                Log.d("com.xiaomi.common.Network", "Http POST Response Code: " + responseCode);
                if (cVar != null) {
                    cVar.a = responseCode;
                    if (cVar.b == null) {
                        cVar.b = new HashMap();
                    }
                    while (true) {
                        a2 = a.getHeaderFieldKey(i);
                        headerField = a.getHeaderField(i);
                        if (a2 == null && headerField == null) {
                            break;
                        }
                        cVar.b.put(a2, headerField);
                        i = (i + 1) + 1;
                    }
                }
                bufferedReader = new BufferedReader(new InputStreamReader(new b(a.getInputStream())));
            } catch (IOException e2) {
                e = e2;
                try {
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                throw new IOException(th.getMessage());
            }
            try {
                StringBuffer stringBuffer = new StringBuffer();
                headerField = System.getProperty("line.separator");
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    stringBuffer.append(readLine);
                    stringBuffer.append(headerField);
                }
                String stringBuffer2 = stringBuffer.toString();
                bufferedReader.close();
                BufferedReader bufferedReader4 = null;
                if (null != null) {
                    try {
                        outputStream2.close();
                    } catch (Throwable th4) {
                        Log.e("com.xiaomi.common.Network", "error while closing strean", th4);
                    }
                }
                if (null != null) {
                    bufferedReader4.close();
                }
                return stringBuffer2;
            } catch (IOException e3) {
                e = e3;
                bufferedReader2 = bufferedReader;
                outputStream = null;
                bufferedReader3 = bufferedReader2;
                throw e;
            } catch (Throwable th5) {
                th4 = th5;
                bufferedReader2 = bufferedReader;
                outputStream = null;
                bufferedReader3 = bufferedReader2;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable e4) {
                        Log.e("com.xiaomi.common.Network", "error while closing strean", e4);
                        throw th4;
                    }
                }
                if (bufferedReader3 != null) {
                    bufferedReader3.close();
                }
                throw th4;
            }
        } catch (IOException e5) {
            e = e5;
            outputStream = null;
        } catch (Throwable th6) {
            th4 = th6;
            outputStream = null;
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

    public static HttpURLConnection a(Context context, URL url) {
        if (!"http".equals(url.getProtocol())) {
            return (HttpURLConnection) url.openConnection();
        }
        if (c(context)) {
            return (HttpURLConnection) url.openConnection(new Proxy(Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
        }
        if (!b(context)) {
            return (HttpURLConnection) url.openConnection();
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(a(url)).openConnection();
        httpURLConnection.addRequestProperty("X-Online-Host", url.getHost());
        return httpURLConnection;
    }

    private static URL a(String str) {
        return new URL(str);
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
                return (TextUtils.isEmpty(extraInfo) || extraInfo.length() < 3 || extraInfo.contains("ctwap")) ? false : extraInfo.regionMatches(true, extraInfo.length() - 3, "wap", 0, 3);
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean c(Context context) {
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

    public static boolean d(Context context) {
        return a(context) >= 0;
    }

    public static boolean e(Context context) {
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
                return 1 == activeNetworkInfo.getType();
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    public static String f(Context context) {
        if (e(context)) {
            return "wifi";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return com.xiaomi.e.a.f;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                return activeNetworkInfo == null ? com.xiaomi.e.a.f : (activeNetworkInfo.getTypeName() + "-" + activeNetworkInfo.getSubtypeName() + "-" + activeNetworkInfo.getExtraInfo()).toLowerCase();
            } catch (Exception e) {
                return com.xiaomi.e.a.f;
            }
        } catch (Exception e2) {
            return com.xiaomi.e.a.f;
        }
    }
}
