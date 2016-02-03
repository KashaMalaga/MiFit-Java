package cn.com.smartdevices.bracelet.lab.ui;

import android.content.Context;
import android.support.v4.view.a.C0113o;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class C0566a {
    private C0566a() {
    }

    public static boolean a(Context context, String str, String str2) {
        FileOutputStream fileOutputStream;
        Exception e;
        Throwable th;
        InputStream inputStream = null;
        boolean z = false;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException();
        }
        try {
            fileOutputStream = new FileOutputStream(str2);
            try {
                inputStream = context.getResources().getAssets().open(str);
                byte[] bArr = new byte[C0113o.l];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                z = true;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    C0596r.a("Lab", e.getMessage());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e7) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e8) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e9) {
            e = e9;
            fileOutputStream = null;
            C0596r.a("Lab", e.getMessage());
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
        return z;
    }
}
