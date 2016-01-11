package cn.com.smartdevices.bracelet.gps.h;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.a.a;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class e {
    public static boolean a = false;
    private static final int b = 20971520;

    private e() {
    }

    private static String a() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }

    public static void a(String str, String str2) {
        FileWriter fileWriter;
        IOException e;
        Throwable th;
        C0596r.e(str, str2);
        if (a) {
            File file = new File(a.d(".MISportLab"), ".gpsLog.txt");
            if (file.exists() && file.length() > 20971520) {
                file.delete();
            }
            try {
                fileWriter = new FileWriter(file, true);
                try {
                    fileWriter.write(a() + "  " + str + "  " + str2 + "\n");
                    fileWriter.flush();
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        C0596r.e(str, e.getMessage());
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e4) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e5) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                fileWriter = null;
                C0596r.e(str, e.getMessage());
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (Throwable th3) {
                th = th3;
                fileWriter = null;
                if (fileWriter != null) {
                    fileWriter.close();
                }
                throw th;
            }
        }
    }
}
