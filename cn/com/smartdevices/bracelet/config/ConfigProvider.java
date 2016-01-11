package cn.com.smartdevices.bracelet.config;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.v4.view.a.C0113o;
import android.util.Log;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.e.a;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ConfigProvider extends ContentProvider {
    public static final String a = "ConfigProvider";
    public static final String b = "channel";
    public static final Uri c = Uri.parse("content://cn.com.smartdevices.bracelet.config/");
    private static final String e = "host";
    File d;

    private boolean a(String str) {
        boolean createNewFile;
        Throwable e;
        Throwable th;
        Throwable th2;
        OutputStream outputStream = null;
        try {
            OutputStream fileOutputStream;
            createNewFile = !this.d.exists() ? this.d.createNewFile() : true;
            if (createNewFile) {
                try {
                    fileOutputStream = new FileOutputStream(this.d);
                    try {
                        fileOutputStream.write(str.getBytes());
                        fileOutputStream.close();
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        outputStream = fileOutputStream;
                        try {
                            Log.e("DebugUtils", "file not found", e);
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e3) {
                                }
                            }
                            return createNewFile;
                        } catch (Throwable th3) {
                            th = th3;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e4) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        outputStream = fileOutputStream;
                        Log.e("DebugUtils", "config save failed", e);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e6) {
                            }
                        }
                        return createNewFile;
                    } catch (Throwable th4) {
                        th = th4;
                        outputStream = fileOutputStream;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e7) {
                    e = e7;
                    Log.e("DebugUtils", "file not found", e);
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    return createNewFile;
                } catch (IOException e8) {
                    e = e8;
                    Log.e("DebugUtils", "config save failed", e);
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    return createNewFile;
                }
            }
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e9) {
                }
            }
        } catch (Throwable th5) {
            th2 = th5;
            createNewFile = true;
            e = th2;
            Log.e("DebugUtils", "file not found", e);
            if (outputStream != null) {
                outputStream.close();
            }
            return createNewFile;
        } catch (Throwable th52) {
            th2 = th52;
            createNewFile = true;
            e = th2;
            Log.e("DebugUtils", "config save failed", e);
            if (outputStream != null) {
                outputStream.close();
            }
            return createNewFile;
        }
        return createNewFile;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        this.d = new File(getContext().getCacheDir(), b.a);
        return true;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) {
        int i = 0;
        if (str.contains("w")) {
            i = 536870912;
            if (!this.d.exists()) {
                try {
                    this.d.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (str.contains("r")) {
            i |= 268435456;
        }
        if (str.contains("+")) {
            i |= 33554432;
        }
        return ParcelFileDescriptor.open(this.d, i);
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        C0596r.a(a, uri.toString());
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(this.d));
            char[] cArr = new char[C0113o.j];
            StringBuilder stringBuilder = new StringBuilder();
            int read;
            do {
                read = inputStreamReader.read(cArr, 0, cArr.length);
                if (read > 0) {
                    stringBuilder.append(cArr, 0, read);
                    continue;
                }
            } while (read > 0);
            return new e(stringBuilder.length() > 0 ? stringBuilder.toString() : "{}", a.a(getContext()), a.b(getContext()));
        } catch (Throwable e) {
            Log.e("DebugUtils", "\u52a0\u8f7d\u914d\u7f6e\u6587\u4ef6\u51fa\u9519", e);
            return null;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        boolean a;
        String path = uri.getPath();
        Log.e(a, uri.toString() + "|" + path);
        if ("/".equals(path)) {
            a = a(contentValues.getAsString(ParamKey.CONTENT));
        } else if (path.contains(b)) {
            path = contentValues.getAsString(b);
            a.b(getContext(), path);
            Log.e(a, path);
            a = true;
        } else if (path.contains(e)) {
            a.c(getContext(), contentValues.getAsString(e));
            a = true;
        } else {
            a = false;
        }
        if (a) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return a ? 1 : 0;
    }
}
