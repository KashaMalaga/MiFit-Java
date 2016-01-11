package cn.com.smartdevices.bracelet.lab.b;

import android.content.Context;
import android.content.SharedPreferences;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import com.xiaomi.hm.health.q;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class a {
    private static final String a = "DBCopyHelper";
    private static final String b = "databases";
    private static final String c = "exercises_db";
    private static final String d = "exercises_db_version";
    private static final int e = 1;

    private a() {
    }

    public static final void a(Context context, int i) {
        FileNotFoundException e;
        Throwable th;
        IOException e2;
        if (context != null) {
            SharedPreferences sharedPref = Keeper.getSharedPref();
            if (sharedPref.getInt(d, 0) < e) {
                InputStream openRawResource = context.getResources().openRawResource(q.exercise_db);
                if (openRawResource != null) {
                    FileOutputStream fileOutputStream = null;
                    try {
                        File file = new File(context.getApplicationInfo().dataDir, b);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file, c), false);
                        try {
                            byte[] bArr = new byte[openRawResource.available()];
                            openRawResource.read(bArr);
                            fileOutputStream2.write(bArr);
                            sharedPref.edit().putInt(d, e).commit();
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e3) {
                                }
                            }
                            if (openRawResource != null) {
                                try {
                                    openRawResource.close();
                                } catch (IOException e4) {
                                }
                            }
                        } catch (FileNotFoundException e5) {
                            e = e5;
                            fileOutputStream = fileOutputStream2;
                            try {
                                C0596r.a(a, e.getMessage());
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e6) {
                                    }
                                }
                                if (openRawResource != null) {
                                    try {
                                        openRawResource.close();
                                    } catch (IOException e7) {
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e8) {
                                    }
                                }
                                if (openRawResource != null) {
                                    try {
                                        openRawResource.close();
                                    } catch (IOException e9) {
                                    }
                                }
                                throw th;
                            }
                        } catch (IOException e10) {
                            e2 = e10;
                            fileOutputStream = fileOutputStream2;
                            C0596r.a(a, e2.getMessage());
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e11) {
                                }
                            }
                            if (openRawResource != null) {
                                try {
                                    openRawResource.close();
                                } catch (IOException e12) {
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (openRawResource != null) {
                                openRawResource.close();
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e13) {
                        e = e13;
                        C0596r.a(a, e.getMessage());
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (openRawResource != null) {
                            openRawResource.close();
                        }
                    } catch (IOException e14) {
                        e2 = e14;
                        C0596r.a(a, e2.getMessage());
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (openRawResource != null) {
                            openRawResource.close();
                        }
                    }
                }
            }
        }
    }
}
