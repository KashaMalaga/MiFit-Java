package com.amap.api.maps.offlinemap;

import android.os.Environment;
import android.os.StatFs;
import cn.com.smartdevices.bracelet.gps.sync.C0483q;
import cn.com.smartdevices.bracelet.lab.ui.C0568d;
import com.amap.api.mapcore.util.az;
import com.tencent.open.SocialConstants;
import com.xiaomi.market.sdk.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kankan.wheel.widget.a;
import org.json.JSONArray;
import org.json.JSONObject;

class m {
    public static long a() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return ((long) statFs.getFreeBlocks()) * ((long) statFs.getBlockSize());
    }

    public static OfflineMapProvince a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        OfflineMapProvince offlineMapProvince = new OfflineMapProvince();
        offlineMapProvince.setUrl(jSONObject.optString(SocialConstants.PARAM_URL));
        offlineMapProvince.setProvinceName(jSONObject.optString("name"));
        offlineMapProvince.setJianpin(jSONObject.optString("jianpin"));
        offlineMapProvince.setPinyin(jSONObject.optString("pinyin"));
        offlineMapProvince.setProvinceCode(jSONObject.optString("adcode"));
        offlineMapProvince.setVersion(jSONObject.optString(o.x));
        offlineMapProvince.setSize(Long.parseLong(jSONObject.optString("size")));
        offlineMapProvince.setCityList(b(jSONObject));
        return offlineMapProvince;
    }

    public static String a(Throwable th) {
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        return stringWriter.toString();
    }

    public static void a(int i) {
        try {
            Thread.sleep((long) i);
        } catch (InterruptedException e) {
            Thread.interrupted();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(File file, File file2) {
        if (file.isDirectory()) {
            if (!file2.exists()) {
                file2.mkdir();
            }
            String[] list = file.list();
            for (int i = 0; i < list.length; i++) {
                a(new File(file, list[i]), new File(file2, list[i]));
            }
            return;
        }
        try {
            b(file, file2);
        } catch (Throwable e) {
            az.a(e, "Utility", "copyDirectory");
            e.printStackTrace();
        }
    }

    public static void a(String str) {
    }

    public static boolean a(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    if (!listFiles[i].delete()) {
                        return false;
                    }
                } else if (!a(listFiles[i])) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static ArrayList<OfflineMapCity> b(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("cities");
        ArrayList<OfflineMapCity> arrayList = new ArrayList();
        if (optJSONArray == null) {
            return arrayList;
        }
        if (optJSONArray.length() == 0) {
            arrayList.add(c(jSONObject));
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(c(optJSONObject));
            }
        }
        return arrayList;
    }

    public static void b(int i) {
    }

    public static void b(File file, File file2) {
        FileChannel channel;
        Throwable th;
        FileChannel fileChannel = null;
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            channel = fileInputStream.getChannel();
            try {
                Object channel2 = fileOutputStream.getChannel();
                if (channel != null) {
                    channel.transferTo(0, channel.size(), channel2);
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (channel != null) {
                    channel.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (channel2 != null) {
                    channel2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    az.a(th, "Utility", "copyFile");
                    th.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            channel = fileChannel;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (channel != null) {
                channel.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (fileChannel != null) {
                fileChannel.close();
            }
            throw th;
        }
    }

    public static void b(String str) {
        Throwable e;
        String str2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + "  " + str;
        OutputStreamWriter outputStreamWriter;
        try {
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(new File(d.a() + "error.txt"), true), a.bO);
            try {
                outputStreamWriter.write(str2);
                if (outputStreamWriter != null) {
                    try {
                        outputStreamWriter.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    az.a(e, "Utility", "wirteErr");
                    e.printStackTrace();
                    if (outputStreamWriter != null) {
                        try {
                            outputStreamWriter.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    e = th;
                    if (outputStreamWriter != null) {
                        try {
                            outputStreamWriter.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw e;
                }
            }
        } catch (IOException e5) {
            e = e5;
            outputStreamWriter = null;
            az.a(e, "Utility", "wirteErr");
            e.printStackTrace();
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
        } catch (Throwable th2) {
            e = th2;
            outputStreamWriter = null;
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
            throw e;
        }
    }

    public static boolean b() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static OfflineMapCity c(JSONObject jSONObject) {
        OfflineMapCity offlineMapCity = new OfflineMapCity();
        offlineMapCity.setAdcode(jSONObject.optString("adcode"));
        offlineMapCity.setUrl(jSONObject.optString(SocialConstants.PARAM_URL));
        offlineMapCity.setCity(jSONObject.optString("name"));
        offlineMapCity.setCode(jSONObject.optString("citycode"));
        offlineMapCity.setPinyin(jSONObject.optString("pinyin"));
        offlineMapCity.setJianpin(jSONObject.optString("jianpin"));
        offlineMapCity.setVersion(jSONObject.optString(o.x));
        offlineMapCity.setSize(Long.parseLong(jSONObject.optString("size")));
        return offlineMapCity;
    }

    public static List<OfflineMapProvince> c(String str) {
        List<OfflineMapProvince> arrayList = new ArrayList();
        if (str == null || com.xiaomi.e.a.f.equals(str)) {
            return arrayList;
        }
        JSONObject optJSONObject = new JSONObject(str).optJSONObject(C0483q.g);
        if (optJSONObject == null) {
            return arrayList;
        }
        optJSONObject = optJSONObject.optJSONObject("offlinemap_with_province");
        if (optJSONObject == null) {
            return arrayList;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("offlinemapinfo_with_province");
        if (optJSONObject2 == null) {
            return arrayList;
        }
        if (optJSONObject2.has(o.x)) {
            OfflineMapManager.a = optJSONObject2.optString(o.x);
        }
        JSONArray optJSONArray = optJSONObject2.optJSONArray("provinces");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
            if (optJSONObject3 != null) {
                arrayList.add(a(optJSONObject3));
            }
        }
        optJSONObject = optJSONObject2.optJSONObject(C0568d.e);
        if (optJSONObject == null) {
            return arrayList;
        }
        optJSONObject = optJSONObject.optJSONObject("other");
        if (optJSONObject == null) {
            return arrayList;
        }
        arrayList.add(a(optJSONObject));
        return arrayList;
    }
}
