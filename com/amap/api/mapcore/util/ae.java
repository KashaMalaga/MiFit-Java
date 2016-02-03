package com.amap.api.mapcore.util;

import android.content.Context;
import b.a.C0374dh;
import com.xiaomi.hm.health.bt.profile.a.j;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kankan.wheel.widget.a;

public class ae {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            String[] split = str.split("&");
            Arrays.sort(split);
            StringBuffer stringBuffer = new StringBuffer();
            for (String append : split) {
                stringBuffer.append(append);
                stringBuffer.append("&");
            }
            String stringBuffer2 = stringBuffer.toString();
            if (stringBuffer2.length() > 1) {
                return (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            az.a(th, "Utils", "sortParams");
        }
        return str;
    }

    static PublicKey a(Context context) {
        InputStream byteArrayInputStream;
        KeyFactory instance;
        Throwable th;
        Certificate certificate;
        Throwable th2;
        try {
            CertificateFactory instance2;
            byteArrayInputStream = new ByteArrayInputStream(new byte[]{(byte) 48, (byte) -126, (byte) 2, (byte) -98, (byte) 48, (byte) -126, (byte) 2, (byte) 7, (byte) -96, (byte) 3, (byte) 2, (byte) 1, (byte) 2, (byte) 2, (byte) 9, (byte) 0, (byte) -99, C0374dh.m, (byte) 119, (byte) 58, (byte) 44, (byte) -19, (byte) -105, (byte) -40, (byte) 48, C0374dh.k, (byte) 6, (byte) 9, (byte) 42, (byte) -122, (byte) 72, (byte) -122, (byte) -9, C0374dh.k, (byte) 1, (byte) 1, (byte) 5, (byte) 5, (byte) 0, (byte) 48, (byte) 104, (byte) 49, C0374dh.i, (byte) 48, (byte) 9, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 6, (byte) 19, (byte) 2, (byte) 67, (byte) 78, (byte) 49, (byte) 19, (byte) 48, (byte) 17, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 8, C0374dh.j, (byte) 10, (byte) 83, (byte) 111, (byte) 109, (byte) 101, (byte) 45, (byte) 83, (byte) 116, (byte) 97, (byte) 116, (byte) 101, (byte) 49, C0374dh.n, (byte) 48, C0374dh.l, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 7, C0374dh.j, (byte) 7, (byte) 66, (byte) 101, (byte) 105, (byte) 106, (byte) 105, (byte) 110, (byte) 103, (byte) 49, (byte) 17, (byte) 48, C0374dh.m, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 10, C0374dh.j, (byte) 8, (byte) 65, (byte) 117, (byte) 116, (byte) 111, (byte) 110, (byte) 97, (byte) 118, (byte) 105, (byte) 49, (byte) 31, (byte) 48, (byte) 29, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 3, C0374dh.j, (byte) 22, (byte) 99, (byte) 111, (byte) 109, (byte) 46, (byte) 97, (byte) 117, (byte) 116, (byte) 111, (byte) 110, (byte) 97, (byte) 118, (byte) 105, (byte) 46, (byte) 97, (byte) 112, (byte) 105, (byte) 115, (byte) 101, (byte) 114, (byte) 118, (byte) 101, (byte) 114, (byte) 48, (byte) 30, (byte) 23, C0374dh.k, (byte) 49, (byte) 51, (byte) 48, (byte) 56, (byte) 49, (byte) 53, (byte) 48, (byte) 55, (byte) 53, (byte) 54, (byte) 53, (byte) 53, (byte) 90, (byte) 23, C0374dh.k, (byte) 50, (byte) 51, (byte) 48, (byte) 56, (byte) 49, (byte) 51, (byte) 48, (byte) 55, (byte) 53, (byte) 54, (byte) 53, (byte) 53, (byte) 90, (byte) 48, (byte) 104, (byte) 49, C0374dh.i, (byte) 48, (byte) 9, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 6, (byte) 19, (byte) 2, (byte) 67, (byte) 78, (byte) 49, (byte) 19, (byte) 48, (byte) 17, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 8, C0374dh.j, (byte) 10, (byte) 83, (byte) 111, (byte) 109, (byte) 101, (byte) 45, (byte) 83, (byte) 116, (byte) 97, (byte) 116, (byte) 101, (byte) 49, C0374dh.n, (byte) 48, C0374dh.l, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 7, C0374dh.j, (byte) 7, (byte) 66, (byte) 101, (byte) 105, (byte) 106, (byte) 105, (byte) 110, (byte) 103, (byte) 49, (byte) 17, (byte) 48, C0374dh.m, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 10, C0374dh.j, (byte) 8, (byte) 65, (byte) 117, (byte) 116, (byte) 111, (byte) 110, (byte) 97, (byte) 118, (byte) 105, (byte) 49, (byte) 31, (byte) 48, (byte) 29, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 3, C0374dh.j, (byte) 22, (byte) 99, (byte) 111, (byte) 109, (byte) 46, (byte) 97, (byte) 117, (byte) 116, (byte) 111, (byte) 110, (byte) 97, (byte) 118, (byte) 105, (byte) 46, (byte) 97, (byte) 112, (byte) 105, (byte) 115, (byte) 101, (byte) 114, (byte) 118, (byte) 101, (byte) 114, (byte) 48, (byte) -127, (byte) -97, (byte) 48, C0374dh.k, (byte) 6, (byte) 9, (byte) 42, (byte) -122, (byte) 72, (byte) -122, (byte) -9, C0374dh.k, (byte) 1, (byte) 1, (byte) 1, (byte) 5, (byte) 0, (byte) 3, (byte) -127, (byte) -115, (byte) 0, (byte) 48, (byte) -127, (byte) -119, (byte) 2, (byte) -127, (byte) -127, (byte) 0, (byte) -15, (byte) -27, Byte.MIN_VALUE, (byte) -56, (byte) 118, (byte) -59, (byte) 62, (byte) -127, (byte) 79, (byte) 125, (byte) -36, (byte) 121, (byte) 0, (byte) 63, (byte) -125, (byte) -30, (byte) 118, (byte) 5, (byte) -85, (byte) -121, (byte) 91, (byte) 39, (byte) 90, (byte) 123, (byte) 72, (byte) -126, (byte) -83, (byte) -41, (byte) -45, (byte) -77, (byte) -42, (byte) -120, (byte) -81, (byte) 23, (byte) -2, (byte) -121, (byte) -29, (byte) 123, (byte) -7, (byte) 22, (byte) -114, (byte) -20, (byte) -25, (byte) 74, (byte) 67, (byte) -43, (byte) 65, (byte) 124, (byte) -7, C0374dh.i, (byte) -72, (byte) 38, (byte) -123, C0374dh.n, (byte) -58, (byte) 80, (byte) 32, (byte) 58, (byte) -33, C0374dh.l, C0374dh.i, (byte) 36, (byte) 60, C0374dh.k, (byte) -121, (byte) 100, (byte) 105, (byte) -32, (byte) 123, (byte) -31, (byte) 114, (byte) -101, (byte) -41, C0374dh.j, (byte) 100, (byte) 33, (byte) -120, (byte) 63, a.ac, (byte) -123, (byte) 48, (byte) 55, (byte) 80, (byte) -116, (byte) 28, (byte) -10, (byte) 125, (byte) 59, (byte) -41, (byte) -95, (byte) -126, (byte) 118, (byte) -70, (byte) 43, (byte) -127, (byte) 9, (byte) 93, (byte) -100, (byte) 81, (byte) -19, (byte) -114, (byte) -41, (byte) 85, (byte) -103, (byte) -37, (byte) -116, (byte) 118, (byte) 72, (byte) 86, (byte) 125, (byte) -43, (byte) -92, (byte) -11, (byte) 63, (byte) 69, (byte) -38, (byte) -10, (byte) -65, a.ac, (byte) -53, (byte) -115, (byte) 60, (byte) 62, (byte) -86, (byte) -80, (byte) 1, (byte) 39, (byte) 19, (byte) 2, (byte) 3, (byte) 1, (byte) 0, (byte) 1, (byte) -93, (byte) 80, (byte) 48, (byte) 78, (byte) 48, (byte) 29, (byte) 6, (byte) 3, (byte) 85, (byte) 29, C0374dh.l, (byte) 4, (byte) 22, (byte) 4, j.ap, (byte) -29, (byte) 63, (byte) 48, (byte) -79, (byte) -113, (byte) -13, (byte) 26, (byte) 85, (byte) 22, (byte) -27, (byte) 93, (byte) -5, (byte) 122, (byte) -103, (byte) -109, C0374dh.l, (byte) -18, (byte) 6, (byte) -13, (byte) -109, (byte) 48, (byte) 31, (byte) 6, (byte) 3, (byte) 85, (byte) 29, (byte) 35, (byte) 4, (byte) 24, (byte) 48, (byte) 22, Byte.MIN_VALUE, j.ap, (byte) -29, (byte) 63, (byte) 48, (byte) -79, (byte) -113, (byte) -13, (byte) 26, (byte) 85, (byte) 22, (byte) -27, (byte) 93, (byte) -5, (byte) 122, (byte) -103, (byte) -109, C0374dh.l, (byte) -18, (byte) 6, (byte) -13, (byte) -109, (byte) 48, C0374dh.j, (byte) 6, (byte) 3, (byte) 85, (byte) 29, (byte) 19, (byte) 4, (byte) 5, (byte) 48, (byte) 3, (byte) 1, (byte) 1, (byte) -1, (byte) 48, C0374dh.k, (byte) 6, (byte) 9, (byte) 42, (byte) -122, (byte) 72, (byte) -122, (byte) -9, C0374dh.k, (byte) 1, (byte) 1, (byte) 5, (byte) 5, (byte) 0, (byte) 3, (byte) -127, (byte) -127, (byte) 0, (byte) -32, (byte) -74, (byte) 55, (byte) -125, (byte) -58, Byte.MIN_VALUE, C0374dh.m, (byte) -62, (byte) 100, (byte) -60, (byte) 3, (byte) -86, (byte) 81, (byte) 112, (byte) -61, (byte) -56, (byte) -69, (byte) -126, (byte) 8, (byte) 99, (byte) -100, (byte) -38, (byte) -108, (byte) -56, (byte) -122, (byte) 125, (byte) 19, (byte) -64, (byte) -61, (byte) 90, (byte) 85, (byte) -47, (byte) -8, (byte) -123, (byte) -103, (byte) 105, (byte) 77, (byte) -32, (byte) -65, (byte) -62, (byte) -28, (byte) 67, (byte) -28, (byte) -78, (byte) 116, (byte) -49, (byte) 120, (byte) -2, (byte) 33, C0374dh.k, (byte) 47, (byte) 46, (byte) -5, (byte) -112, (byte) 3, (byte) -101, (byte) -125, (byte) -115, (byte) 92, (byte) -124, (byte) 58, (byte) 80, (byte) 107, (byte) -67, (byte) 82, (byte) 6, (byte) -63, (byte) 39, (byte) -90, (byte) -1, (byte) 85, (byte) -58, (byte) 82, (byte) -115, (byte) 119, C0374dh.k, (byte) -4, (byte) -32, (byte) 0, (byte) -98, (byte) 100, (byte) -41, (byte) 94, (byte) -75, (byte) 75, (byte) -103, a.ac, (byte) -80, (byte) 85, (byte) 40, (byte) -27, (byte) 60, (byte) 105, (byte) 28, (byte) -27, (byte) -21, (byte) -15, (byte) -98, (byte) 103, (byte) -88, (byte) -109, (byte) 35, (byte) -119, (byte) -27, (byte) -26, (byte) -122, (byte) 113, (byte) 63, (byte) 35, (byte) -33, (byte) 70, (byte) 23, (byte) 33, (byte) -23, (byte) 66, (byte) 108, (byte) 56, (byte) 112, (byte) 46, (byte) -85, (byte) -123, (byte) -123, (byte) 33, (byte) 118, (byte) 27, (byte) 96, (byte) -7, (byte) -103});
            try {
                instance2 = CertificateFactory.getInstance("X.509");
                instance = KeyFactory.getInstance("RSA");
            } catch (Throwable th3) {
                th = th3;
                instance = null;
                try {
                    th.printStackTrace();
                    if (byteArrayInputStream != null) {
                        certificate = null;
                    } else {
                        byteArrayInputStream.close();
                        certificate = null;
                    }
                    return certificate == null ? null : null;
                } catch (Throwable th4) {
                    th2 = th4;
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    throw th2;
                }
            }
            try {
                certificate = instance2.generateCertificate(byteArrayInputStream);
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
            } catch (Throwable th5) {
                th = th5;
                th.printStackTrace();
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                    certificate = null;
                } else {
                    certificate = null;
                }
                if (certificate == null) {
                }
            }
        } catch (Throwable th6) {
            byteArrayInputStream = null;
            th2 = th6;
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            throw th2;
        }
        if (certificate == null && instance != null) {
            return instance.generatePublic(new X509EncodedKeySpec(certificate.getPublicKey().getEncoded()));
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            return f(bArr);
        } catch (Throwable e) {
            az.a(e, "Utils", "gZip");
            e.printStackTrace();
            return new byte[0];
        } catch (Throwable e2) {
            az.a(e2, "Utils", "gZip");
            e2.printStackTrace();
            return new byte[0];
        }
    }

    public static byte[] b(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ZipOutputStream zipOutputStream;
        Throwable th;
        az b;
        az b2;
        Throwable th2;
        byte[] bArr2 = null;
        if (!(bArr == null || bArr.length == 0)) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
                } catch (Throwable th3) {
                    zipOutputStream = bArr2;
                    th2 = th3;
                    if (zipOutputStream != null) {
                        zipOutputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th2;
                }
                try {
                    zipOutputStream.putNextEntry(new ZipEntry("log"));
                    zipOutputStream.write(bArr);
                    zipOutputStream.closeEntry();
                    zipOutputStream.finish();
                    bArr2 = byteArrayOutputStream.toByteArray();
                    if (zipOutputStream != null) {
                        try {
                            zipOutputStream.close();
                        } catch (Throwable th32) {
                            b = az.b();
                            if (b != null) {
                                b.b(th32, "Utils", "zip1");
                            }
                            th32.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th4) {
                            th32 = th4;
                            b2 = az.b();
                            if (b2 != null) {
                                b2.b(th32, "Utils", "zip2");
                            }
                            th32.printStackTrace();
                            return bArr2;
                        }
                    }
                } catch (Throwable th5) {
                    th32 = th5;
                    th32.printStackTrace();
                    az.a(th32, "Utils", "zip");
                    if (zipOutputStream != null) {
                        zipOutputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return bArr2;
                }
            } catch (Throwable th322) {
                byteArrayOutputStream = bArr2;
                zipOutputStream = bArr2;
                th2 = th322;
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th2;
            }
        }
        return bArr2;
    }

    static String c(byte[] bArr) {
        try {
            return e(bArr);
        } catch (Throwable th) {
            az.a(th, "Utils", "HexString");
            th.printStackTrace();
            return null;
        }
    }

    static String d(byte[] bArr) {
        try {
            return e(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String e(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        if (bArr == null) {
            return null;
        }
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & HeartRateInfo.HR_EMPTY_VALUE);
            if (toHexString.length() == 1) {
                toHexString = '0' + toHexString;
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }

    private static byte[] f(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        IOException e;
        Throwable th;
        Throwable th2;
        byte[] bArr2 = null;
        if (bArr != null) {
            ByteArrayOutputStream byteArrayOutputStream;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream.write(bArr);
                        gZIPOutputStream.finish();
                        bArr2 = byteArrayOutputStream.toByteArray();
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            throw e;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        throw th;
                    }
                } catch (IOException e3) {
                    IOException iOException = e3;
                    gZIPOutputStream = null;
                    e = iOException;
                    throw e;
                } catch (Throwable th5) {
                    th2 = th5;
                    gZIPOutputStream = null;
                    th = th2;
                    if (gZIPOutputStream != null) {
                        gZIPOutputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e32) {
                byteArrayOutputStream = null;
                e = e32;
                gZIPOutputStream = null;
                throw e;
            } catch (Throwable th52) {
                byteArrayOutputStream = null;
                th = th52;
                gZIPOutputStream = null;
                if (gZIPOutputStream != null) {
                    gZIPOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        }
        return bArr2;
    }
}
