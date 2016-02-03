package cn.com.smartdevices.bracelet.gps.services.b;

import android.text.TextUtils;
import android.util.Log;
import cn.com.smartdevices.bracelet.C0596r;
import com.activeandroid.b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class h {
    private static final String a = "UTF-8";

    public static String a(byte[] bArr) {
        Throwable e;
        Throwable th;
        String str = null;
        if (!(bArr == null || bArr.length == 0)) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPInputStream gZIPInputStream;
            try {
                gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
                try {
                    byte[] bArr2 = new byte[b.a];
                    while (true) {
                        int read = gZIPInputStream.read(bArr2);
                        if (read < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    byteArrayOutputStream.flush();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    try {
                        Log.e("GZipUtils", e.getMessage(), e);
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (IOException e6) {
                            }
                        }
                        str = byteArrayOutputStream.toString(a);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e7) {
                            }
                        }
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (IOException e8) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e9) {
                e = e9;
                Object obj = str;
                Log.e("GZipUtils", e.getMessage(), e);
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (gZIPInputStream != null) {
                    gZIPInputStream.close();
                }
                str = byteArrayOutputStream.toString(a);
                return str;
            } catch (Throwable e10) {
                gZIPInputStream = str;
                th = e10;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (gZIPInputStream != null) {
                    gZIPInputStream.close();
                }
                throw th;
            }
            try {
                str = byteArrayOutputStream.toString(a);
            } catch (Throwable e102) {
                Log.e("GZipUtils2", e102.getMessage(), e102);
            }
        }
        return str;
    }

    public static String a(byte[] bArr, String str) {
        GZIPInputStream gZIPInputStream;
        IOException e;
        Throwable th;
        String str2 = null;
        if (!(bArr == null || bArr.length == 0)) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
                try {
                    byte[] bArr2 = new byte[b.a];
                    while (true) {
                        int read = gZIPInputStream.read(bArr2);
                        if (read < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    byteArrayOutputStream.flush();
                    if (TextUtils.isEmpty(str)) {
                        str2 = byteArrayOutputStream.toString(a);
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                    } else {
                        str2 = byteArrayOutputStream.toString(str);
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                    }
                } catch (IOException e6) {
                    e = e6;
                    try {
                        C0596r.a("GZipUtils", e.getMessage());
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e7) {
                            }
                        }
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (IOException e8) {
                            }
                        }
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e9) {
                            }
                        }
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (IOException e10) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e11) {
                e = e11;
                Object obj = str2;
                C0596r.a("GZipUtils", e.getMessage());
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (gZIPInputStream != null) {
                    gZIPInputStream.close();
                }
                return str2;
            } catch (Throwable th3) {
                gZIPInputStream = str2;
                th = th3;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (gZIPInputStream != null) {
                    gZIPInputStream.close();
                }
                throw th;
            }
        }
        return str2;
    }

    public static byte[] a(String str) {
        GZIPOutputStream gZIPOutputStream;
        IOException e;
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(str.getBytes(a));
                gZIPOutputStream.flush();
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    C0596r.a("GZipUtils", e.getMessage());
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th2) {
                    th = th2;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e6) {
            IOException iOException = e6;
            gZIPOutputStream = null;
            e = iOException;
            C0596r.a("GZipUtils", e.getMessage());
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th3) {
            Throwable th4 = th3;
            gZIPOutputStream = null;
            th = th4;
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            throw th;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] a(String str, String str2) {
        IOException e;
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream;
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                if (TextUtils.isEmpty(str2)) {
                    gZIPOutputStream.write(str.getBytes(a));
                } else {
                    gZIPOutputStream.write(str.getBytes(str2));
                }
                gZIPOutputStream.flush();
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    C0596r.a("GZipUtils", e.getMessage());
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th2) {
                    th = th2;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e6) {
            IOException iOException = e6;
            gZIPOutputStream = null;
            e = iOException;
            C0596r.a("GZipUtils", e.getMessage());
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th3) {
            Throwable th4 = th3;
            gZIPOutputStream = null;
            th = th4;
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            throw th;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
