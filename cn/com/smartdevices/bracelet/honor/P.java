package cn.com.smartdevices.bracelet.honor;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import com.d.a.a.h;
import com.xiaomi.channel.gamesdk.b;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.apache.http.util.EncodingUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class P {
    public static String a(Context context, String str) {
        String string;
        Exception e;
        try {
            FileInputStream openFileInput = context.openFileInput(str);
            byte[] bArr = new byte[openFileInput.available()];
            openFileInput.read(bArr);
            string = EncodingUtils.getString(bArr, h.DEFAULT_CHARSET);
            try {
                openFileInput.close();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return string;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            string = null;
            e = exception;
            e.printStackTrace();
            return string;
        }
        return string;
    }

    public static void a(Context context, String str, String str2) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes());
            openFileOutput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean a(long j, long j2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date(j2)).equals(simpleDateFormat.format(new Date(j)));
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        return (networkInfo == null || !networkInfo.isConnected()) ? networkInfo2 != null && networkInfo2.isConnected() : true;
    }

    public static int b(Context context) {
        return context == null ? 0 : WifiManager.calculateSignalLevel(((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getRssi(), 5);
    }

    public static String b(Context context, String str) {
        try {
            return new JSONObject(str).getJSONArray(b.b).toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean b(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(j2));
        instance.set(5, instance.get(5) + 1);
        Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(new Date(j));
        return instance.get(1) == gregorianCalendar.get(1) && instance.get(2) == gregorianCalendar.get(2) && instance.get(5) == gregorianCalendar.get(5);
    }
}
