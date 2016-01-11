package com.amap.api.mapcore.util;

import android.support.v4.view.a.C0113o;
import cn.com.smartdevices.bracelet.gps.model.RunningReminderInfo;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class aa {
    private static final char[] a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final byte[] b = new byte[C0113o.h];

    static {
        int i;
        for (i = 0; i < C0113o.h; i++) {
            b[i] = (byte) -1;
        }
        for (i = 65; i <= 90; i++) {
            b[i] = (byte) (i - 65);
        }
        for (i = 97; i <= 122; i++) {
            b[i] = (byte) ((i - 97) + 26);
        }
        for (i = 48; i <= 57; i++) {
            b[i] = (byte) ((i - 48) + 52);
        }
        b[43] = (byte) 62;
        b[47] = (byte) 63;
    }

    public static String a(String str) {
        return new String(b(str));
    }

    public static String a(byte[] bArr) {
        try {
            return c(bArr);
        } catch (Throwable th) {
            az.a(th, "Encrypt", "encodeBase64");
            th.printStackTrace();
            return null;
        }
    }

    static byte[] a(byte[] bArr, Key key) {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, key);
        return instance.doFinal(bArr);
    }

    static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            return b(bArr, bArr2);
        } catch (Throwable e) {
            az.a(e, "Encrypt", "aesEncrypt");
            e.printStackTrace();
            return null;
        } catch (Throwable e2) {
            az.a(e2, "Encrypt", "aesEncrypt");
            e2.printStackTrace();
            return null;
        } catch (Throwable e22) {
            az.a(e22, "Encrypt", "aesEncrypt");
            e22.printStackTrace();
            return null;
        } catch (Throwable e222) {
            az.a(e222, "Encrypt", "aesEncrypt");
            e222.printStackTrace();
            return null;
        } catch (Throwable e2222) {
            az.a(e2222, "Encrypt", "aesEncrypt");
            e2222.printStackTrace();
            return null;
        } catch (Throwable e22222) {
            az.a(e22222, "Encrypt", "aesEncrypt");
            e22222.printStackTrace();
            return null;
        }
    }

    public static String b(byte[] bArr) {
        try {
            return c(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static byte[] b(String str) {
        int i = 0;
        if (str == null) {
            return new byte[0];
        }
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        while (i < length) {
            while (true) {
                int i2 = i + 1;
                byte b = b[bytes[i]];
                byte b2;
                byte b3;
                byte b4;
                if (i2 >= length || b != (byte) -1) {
                    if (b != (byte) -1) {
                        while (true) {
                            i = i2 + 1;
                            b2 = b[bytes[i2]];
                            if (i >= length || b2 != (byte) -1) {
                                if (b2 == (byte) -1) {
                                    break;
                                }
                                byteArrayOutputStream.write((b << 2) | ((b2 & 48) >>> 4));
                                while (true) {
                                    i2 = i + 1;
                                    b3 = bytes[i];
                                    if (b3 != (byte) 61) {
                                        return byteArrayOutputStream.toByteArray();
                                    }
                                    b = b[b3];
                                    if (i2 >= length || b != (byte) -1) {
                                        if (b == (byte) -1) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(((b2 & 15) << 4) | ((b & 60) >>> 2));
                                        while (true) {
                                            i = i2 + 1;
                                            b4 = bytes[i2];
                                            if (b4 == (byte) 61) {
                                                return byteArrayOutputStream.toByteArray();
                                            }
                                            b4 = b[b4];
                                            if (i >= length || b4 != (byte) -1) {
                                                if (b4 == (byte) -1) {
                                                    break;
                                                }
                                                byteArrayOutputStream.write(b4 | ((b & 3) << 6));
                                            } else {
                                                i2 = i;
                                            }
                                        }
                                        if (b4 == (byte) -1) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(b4 | ((b & 3) << 6));
                                    } else {
                                        i = i2;
                                    }
                                }
                                if (b == (byte) -1) {
                                    byteArrayOutputStream.write(((b2 & 15) << 4) | ((b & 60) >>> 2));
                                    while (true) {
                                        i = i2 + 1;
                                        b4 = bytes[i2];
                                        if (b4 == (byte) 61) {
                                            b4 = b[b4];
                                            if (i >= length) {
                                                break;
                                            }
                                            break;
                                        }
                                        return byteArrayOutputStream.toByteArray();
                                        i2 = i;
                                    }
                                    if (b4 == (byte) -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(b4 | ((b & 3) << 6));
                                } else {
                                    break;
                                }
                            }
                            i2 = i;
                        }
                        if (b2 == (byte) -1) {
                            byteArrayOutputStream.write((b << 2) | ((b2 & 48) >>> 4));
                            while (true) {
                                i2 = i + 1;
                                b3 = bytes[i];
                                if (b3 != (byte) 61) {
                                    b = b[b3];
                                    if (i2 >= length) {
                                        break;
                                    }
                                    break;
                                }
                                return byteArrayOutputStream.toByteArray();
                                i = i2;
                            }
                            if (b == (byte) -1) {
                                break;
                            }
                            byteArrayOutputStream.write(((b2 & 15) << 4) | ((b & 60) >>> 2));
                            while (true) {
                                i = i2 + 1;
                                b4 = bytes[i2];
                                if (b4 == (byte) 61) {
                                    b4 = b[b4];
                                    if (i >= length) {
                                        break;
                                    }
                                    break;
                                }
                                return byteArrayOutputStream.toByteArray();
                                i2 = i;
                            }
                            if (b4 == (byte) -1) {
                                break;
                            }
                            byteArrayOutputStream.write(b4 | ((b & 3) << 6));
                        } else {
                            break;
                        }
                    }
                    break;
                }
                i = i2;
            }
            if (b != (byte) -1) {
                break;
            }
            while (true) {
                i = i2 + 1;
                b2 = b[bytes[i2]];
                if (i >= length) {
                    break;
                }
                break;
                i2 = i;
            }
            if (b2 == (byte) -1) {
                break;
            }
            byteArrayOutputStream.write((b << 2) | ((b2 & 48) >>> 4));
            while (true) {
                i2 = i + 1;
                b3 = bytes[i];
                if (b3 != (byte) 61) {
                    b = b[b3];
                    if (i2 >= length) {
                        break;
                    }
                    break;
                }
                return byteArrayOutputStream.toByteArray();
                i = i2;
            }
            if (b == (byte) -1) {
                byteArrayOutputStream.write(((b2 & 15) << 4) | ((b & 60) >>> 2));
                while (true) {
                    i = i2 + 1;
                    b4 = bytes[i2];
                    if (b4 == (byte) 61) {
                        b4 = b[b4];
                        if (i >= length) {
                            break;
                        }
                        break;
                    }
                    return byteArrayOutputStream.toByteArray();
                    i2 = i;
                }
                if (b4 == (byte) -1) {
                    break;
                }
                byteArrayOutputStream.write(b4 | ((b & 3) << 6));
            } else {
                break;
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] b(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
        instance.init(1, secretKeySpec);
        return instance.doFinal(bArr2);
    }

    private static String c(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            int i3 = bArr[i] & HeartRateInfo.HR_EMPTY_VALUE;
            if (i2 == length) {
                stringBuffer.append(a[i3 >>> 2]);
                stringBuffer.append(a[(i3 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i4 = i2 + 1;
            i2 = bArr[i2] & HeartRateInfo.HR_EMPTY_VALUE;
            if (i4 == length) {
                stringBuffer.append(a[i3 >>> 2]);
                stringBuffer.append(a[((i3 & 3) << 4) | ((i2 & RunningReminderInfo.b) >>> 4)]);
                stringBuffer.append(a[(i2 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            i = i4 + 1;
            i4 = bArr[i4] & HeartRateInfo.HR_EMPTY_VALUE;
            stringBuffer.append(a[i3 >>> 2]);
            stringBuffer.append(a[((i3 & 3) << 4) | ((i2 & RunningReminderInfo.b) >>> 4)]);
            stringBuffer.append(a[((i2 & 15) << 2) | ((i4 & 192) >>> 6)]);
            stringBuffer.append(a[i4 & 63]);
        }
        return stringBuffer.toString();
    }
}
