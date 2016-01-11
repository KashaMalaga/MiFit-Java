package com.xiaomi.hm.health.bt.c;

import android.bluetooth.BluetoothGatt;
import android.support.v4.view.a.C0113o;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Constant;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.xiaomi.hm.health.bt.model.e;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.lang.reflect.Field;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import kankan.wheel.widget.a;
import kankan.wheel.widget.a.b;
import kankan.wheel.widget.l;

public final class y {
    public static final UUID a = a("2902");
    public static final UUID b = a("2901");
    public static UUID c = new UUID(303230942, 1523193452336828707L);
    public static UUID d = new UUID(-1152921504534413312L, -5764607523034234880L);
    private static final String e = "GattUtils";
    private static final String f = "0000%4s-0000-1000-8000-00805f9b34fb";
    private static final String g = String.format(f, new Object[]{"...."});
    private static final long h = 4096;
    private static final long i = -9223371485494954757L;
    private static final int[] j = new int[]{0, 49345, 49537, a.by, 49921, 960, 640, 49729, 50689, 1728, 1920, 51009, 1280, 50625, 50305, 1088, 52225, 3264, 3456, 52545, 3840, 53185, 52865, 3648, 2560, 51905, 52097, 2880, 51457, 2496, 2176, 51265, 55297, 6336, 6528, 55617, 6912, 56257, 55937, 6720, 7680, 57025, 57217, a.bS, 56577, 7616, 7296, 56385, 5120, 54465, 54657, 5440, 55041, 6080, 5760, 54849, 53761, 4800, 4992, 54081, ChartData.e, 53697, 53377, 4160, 61441, 12480, 12672, 61761, 13056, 62401, 62081, 12864, 13824, 63169, 63361, 14144, 62721, 13760, 13440, 62529, 15360, 64705, 64897, 15680, z.h, 16320, 16000, 65089, 64001, 15040, 15232, 64321, 14592, 63937, 63617, 14400, 10240, 59585, 59777, 10560, 60161, 11200, 10880, 59969, 60929, 11968, 12160, 61249, 11520, 60865, 60545, 11328, 58369, 9408, 9600, 58689, 9984, 59329, 59009, 9792, 8704, 58049, 58241, 9024, 57601, 8640, 8320, 57409, 40961, 24768, 24960, 41281, 25344, 41921, 41601, 25152, 26112, 42689, 42881, 26432, 42241, 26048, 25728, 42049, 27648, 44225, 44417, 27968, 44801, 28608, 28288, 44609, 43521, 27328, 27520, 43841, 26880, 43457, 43137, 26688, 30720, 47297, 47489, 31040, 47873, 31680, 31360, 47681, 48641, 32448, 32640, 48961, Constant.di, 48577, 48257, 31808, 46081, 29888, 30080, 46401, 30464, 47041, 46721, 30272, 29184, 45761, 45953, 29504, 45313, 29120, 28800, 45121, 20480, 37057, 37249, 20800, 37633, 21440, 21120, 37441, 38401, 22208, 22400, 38721, 21760, 38337, 38017, 21568, 39937, 23744, 23936, 40257, 24320, 40897, 40577, 24128, 23040, 39617, 39809, 23360, 39169, 22976, 22656, 38977, 34817, 18624, 18816, 35137, 19200, 35777, 35457, 19008, 19968, 36545, 36737, 20288, 36097, 19904, 19584, 35905, 17408, 33985, 34177, 17728, 34561, 18368, 18048, 34369, 33281, 17088, 17280, 33601, 16640, 33217, 32897, 16448};
    private static final byte k = (byte) 1;
    private static final byte l = (byte) 2;
    private static final byte m = (byte) 3;
    private static final byte n = (byte) 6;
    private static final byte o = (byte) 7;
    private static final byte p = (byte) 8;
    private static final byte q = (byte) 9;
    private static final byte r = (byte) 10;
    private static final byte s = (byte) 20;
    private static final byte t = (byte) 21;
    private static final byte u = (byte) 22;
    private static final byte v = (byte) -1;
    private static Field w = null;

    public static int a(int i, byte[] bArr, int i2, int i3) {
        while (i2 < i3) {
            int i4 = (((i >>> 8) | (i << 8)) & android.support.v4.e.a.a.a) ^ (bArr[i2] & HeartRateInfo.HR_EMPTY_VALUE);
            i4 ^= (i4 & HeartRateInfo.HR_EMPTY_VALUE) >> 4;
            i4 ^= (i4 << 12) & android.support.v4.e.a.a.a;
            i = i4 ^ (((i4 & HeartRateInfo.HR_EMPTY_VALUE) << 5) & android.support.v4.e.a.a.a);
            i2++;
        }
        return i;
    }

    public static int a(BluetoothGatt bluetoothGatt) {
        if (w == null) {
            try {
                w = BluetoothGatt.class.getDeclaredField("mClientIf");
                w.setAccessible(true);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        try {
            return w.getInt(bluetoothGatt);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return -1;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return -1;
        }
    }

    public static int a(byte[] bArr, int i) {
        return c(bArr, i, 4);
    }

    public static UUID a(int i) {
        return new UUID(((((long) i) & 4294967295L) << 32) | h, i);
    }

    public static UUID a(String str) {
        return UUID.fromString(String.format(f, new Object[]{str}));
    }

    public static UUID a(UUID uuid, int i) {
        return a(uuid, (short) i);
    }

    public static UUID a(UUID uuid, short s) {
        return new UUID((uuid.getMostSignificantBits() & -281470681743361L) | ((((long) s) & 65535) << 32), uuid.getLeastSignificantBits());
    }

    public static UUID a(short s) {
        return a(android.support.v4.e.a.a.a & s);
    }

    public static UUID a(byte[] bArr) {
        switch (bArr.length) {
            case a.k /*2*/:
                return a(String.format("%02x%02x", new Object[]{Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1])}));
            case a.bp /*16*/:
                StringBuilder stringBuilder = new StringBuilder(C0113o.h);
                stringBuilder.append(String.format("%02x%02x%02x%02x", new Object[]{Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])}));
                stringBuilder.append(String.format("-%02x%02x-%02x%02x", new Object[]{Byte.valueOf(bArr[4]), Byte.valueOf(bArr[5]), Byte.valueOf(bArr[6]), Byte.valueOf(bArr[7])}));
                stringBuilder.append(String.format("-%02x%02x-%02x%02x", new Object[]{Byte.valueOf(bArr[8]), Byte.valueOf(bArr[9]), Byte.valueOf(bArr[10]), Byte.valueOf(bArr[11])}));
                stringBuilder.append(String.format("%02x%02x%02x%02x", new Object[]{Byte.valueOf(bArr[12]), Byte.valueOf(bArr[13]), Byte.valueOf(bArr[14]), Byte.valueOf(bArr[15])}));
                return b(stringBuilder.toString());
            default:
                return null;
        }
    }

    public static short a(UUID uuid) {
        return (short) b(uuid);
    }

    public static void a(byte[] bArr, int i, int i2) {
        int i3 = i + 1;
        bArr[i] = (byte) ((i2 >> 0) & HeartRateInfo.HR_EMPTY_VALUE);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >> 8) & HeartRateInfo.HR_EMPTY_VALUE);
        i3 = i4 + 1;
        bArr[i4] = (byte) ((i2 >> 16) & HeartRateInfo.HR_EMPTY_VALUE);
        i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >> 24) & HeartRateInfo.HR_EMPTY_VALUE);
    }

    public static void a(byte[] bArr, int i, short s) {
        int i2 = i + 1;
        bArr[i] = (byte) ((s >> 0) & HeartRateInfo.HR_EMPTY_VALUE);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((s >> 8) & HeartRateInfo.HR_EMPTY_VALUE);
    }

    public static boolean a(byte[] bArr, UUID[] uuidArr) {
        C0596r.a(bArr.length == 62);
        int i = 0;
        while (i < 62) {
            int i2 = i + 1;
            byte b = bArr[i];
            if (b == (byte) 0 || b + i2 > 62) {
                break;
            }
            i = i2 + 1;
            byte b2 = bArr[i2];
            int i3;
            int i4;
            if (b2 == m || b2 == l) {
                i2 = 0;
                while (i2 < b - 1) {
                    r5 = new byte[2];
                    i3 = i + 1;
                    r5[0] = bArr[i];
                    i4 = i3 + 1;
                    r5[1] = bArr[i3];
                    String format = String.format("%02x%02x", new Object[]{Byte.valueOf(r5[1]), Byte.valueOf(r5[0])});
                    for (UUID c : uuidArr) {
                        if (c(c).equals(format)) {
                            return true;
                        }
                    }
                    i2 += 2;
                    i = i4;
                }
                continue;
            } else if (b2 == o || b2 == n) {
                int i5 = 0;
                while (i5 < b - 1) {
                    byte[] bArr2 = new byte[16];
                    i2 = i;
                    i = 0;
                    while (i < 16) {
                        i4 = i2 + 1;
                        bArr2[i] = bArr[i2];
                        i++;
                        i2 = i4;
                    }
                    String format2 = String.format("%02x%02x%02x%02x-%02x%02x-%02x%02x-%02x%02x-%02x%02x%02x%02x%02x%02x", new Object[]{Byte.valueOf(bArr2[15]), Byte.valueOf(bArr2[14]), Byte.valueOf(bArr2[13]), Byte.valueOf(bArr2[12]), Byte.valueOf(bArr2[11]), Byte.valueOf(bArr2[10]), Byte.valueOf(bArr2[9]), Byte.valueOf(bArr2[8]), Byte.valueOf(bArr2[7]), Byte.valueOf(bArr2[6]), Byte.valueOf(bArr2[5]), Byte.valueOf(bArr2[4]), Byte.valueOf(bArr2[3]), Byte.valueOf(bArr2[2]), Byte.valueOf(bArr2[1]), Byte.valueOf(bArr2[0])});
                    for (UUID c2 : uuidArr) {
                        C0596r.a(c2.toString() + "==" + format2);
                        if (c(c2).equals(format2)) {
                            return true;
                        }
                    }
                    i5 += 16;
                    i = i2;
                }
                continue;
            } else {
                i += b - 1;
            }
        }
        return false;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            Cipher instance = Cipher.getInstance("AES/ECB/NoPadding");
            instance.init(1, new SecretKeySpec(bArr, "AES"));
            return instance.doFinal(bArr2);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
            return null;
        } catch (BadPaddingException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static int b(UUID uuid) {
        long mostSignificantBits = uuid.getMostSignificantBits();
        return (uuid.getLeastSignificantBits() == i && (4294967295L & mostSignificantBits) == h) ? (int) (mostSignificantBits >> 32) : 0;
    }

    public static int b(byte[] bArr, int i, int i2) {
        if (i >= bArr.length || i > i2) {
            return 0;
        }
        int i3 = android.support.v4.e.a.a.a;
        while (i < i2) {
            i3 = (((i3 << 8) | (i3 >>> 8)) & android.support.v4.e.a.a.a) ^ (bArr[i] & HeartRateInfo.HR_EMPTY_VALUE);
            i3 ^= (i3 & HeartRateInfo.HR_EMPTY_VALUE) >> 4;
            i3 ^= (i3 << 12) & android.support.v4.e.a.a.a;
            i3 ^= ((i3 & HeartRateInfo.HR_EMPTY_VALUE) << 5) & android.support.v4.e.a.a.a;
            i++;
        }
        return i3 & android.support.v4.e.a.a.a;
    }

    public static String b(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        if ((i & 1) > 0) {
            stringBuilder.append("BROADCAST ");
        }
        if ((i & C0113o.h) > 0) {
            stringBuilder.append("EXTENDED_PROPS ");
        }
        if ((i & 32) > 0) {
            stringBuilder.append("INDICATE ");
        }
        if ((i & 16) > 0) {
            stringBuilder.append("NOTIFY ");
        }
        if ((i & 2) > 0) {
            stringBuilder.append("READ ");
        }
        if ((i & 64) > 0) {
            stringBuilder.append("SIGNED_WRITE ");
        }
        if ((i & 8) > 0) {
            stringBuilder.append("WRITE ");
        }
        if ((i & 4) > 0) {
            stringBuilder.append("WRITE_NO_RESPONSE ");
        }
        return stringBuilder.toString();
    }

    public static String b(byte[] bArr) {
        C0596r.a((Object) bArr);
        if (bArr == null || bArr.length == 0) {
            return com.xiaomi.e.a.f;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(String.format("%02x ", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    public static UUID b(String str) {
        return UUID.fromString(str);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        try {
            Cipher instance = Cipher.getInstance("AES/ECB/NoPadding");
            instance.init(2, new SecretKeySpec(bArr, "AES"));
            return instance.doFinal(bArr2);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
            return null;
        } catch (BadPaddingException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static int c(byte[] bArr) {
        int i = android.support.v4.e.a.a.a;
        for (byte b : bArr) {
            i = (((i << 8) | (i >>> 8)) & android.support.v4.e.a.a.a) ^ (b & HeartRateInfo.HR_EMPTY_VALUE);
            i ^= (i & HeartRateInfo.HR_EMPTY_VALUE) >> 4;
            i ^= (i << 12) & android.support.v4.e.a.a.a;
            i ^= ((i & HeartRateInfo.HR_EMPTY_VALUE) << 5) & android.support.v4.e.a.a.a;
        }
        return i & android.support.v4.e.a.a.a;
    }

    public static int c(byte[] bArr, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            i4 |= (bArr[i + i3] & HeartRateInfo.HR_EMPTY_VALUE) << (i3 * 8);
            i3++;
        }
        return i4;
    }

    public static String c(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        if ((i & 1) > 0) {
            stringBuilder.append("READ ");
        }
        if ((i & 2) > 0) {
            stringBuilder.append("READ_ENCRYPTED ");
        }
        if ((i & 4) > 0) {
            stringBuilder.append("READ_ENCRYPTED_MITM ");
        }
        if ((i & 16) > 0) {
            stringBuilder.append("WRITE ");
        }
        if ((i & 32) > 0) {
            stringBuilder.append("WRITE_ENCRYPTED ");
        }
        if ((i & 64) > 0) {
            stringBuilder.append("WRITE_ENCRYPTED_MITM ");
        }
        if ((i & C0113o.h) > 0) {
            stringBuilder.append("WRITE_SIGNED ");
        }
        if ((i & PersonInfo.INCOMING_CALL_DISABLE_BIT) > 0) {
            stringBuilder.append("WRITE_SIGNED_MITM ");
        }
        return stringBuilder.toString();
    }

    public static String c(UUID uuid) {
        String uuid2 = uuid.toString();
        return uuid2.matches(g) ? uuid2.substring(4, 8) : uuid2;
    }

    public static int d(byte[] bArr) {
        int i = 0;
        for (byte b : bArr) {
            i ^= b & HeartRateInfo.HR_EMPTY_VALUE;
            for (int i2 = 0; i2 < 8; i2++) {
                i = (i & 1) != 0 ? ((i >> 1) & HeartRateInfo.HR_EMPTY_VALUE) ^ 140 : (i >> 1) & HeartRateInfo.HR_EMPTY_VALUE;
            }
        }
        return i;
    }

    public static e e(byte[] bArr) {
        C0596r.a(bArr.length == 62);
        e eVar = new e();
        int i = 0;
        while (i < 62) {
            int i2 = i + 1;
            byte b = bArr[i];
            if (b != (byte) 0 && b + i2 <= 62) {
                int i3 = i2 + 1;
                byte[] bArr2;
                String b2;
                StringBuilder stringBuilder;
                int i4;
                byte[] bArr3;
                switch (bArr[i2]) {
                    case b.a /*-1*/:
                        bArr2 = new byte[(b - 1)];
                        i = i3;
                        i3 = 0;
                        while (i3 < b - 1) {
                            i2 = i + 1;
                            bArr2[i3] = bArr[i];
                            i3++;
                            i = i2;
                        }
                        b2 = b(bArr2);
                        eVar.m = b2;
                        C0596r.a("    manufact: " + b2);
                        break;
                    case l.a /*1*/:
                        C0596r.a(b == l);
                        i = i3 + 1;
                        eVar.c = bArr[i3];
                        C0596r.a("        flag: " + String.format("%02x", new Object[]{Byte.valueOf(r1)}));
                        break;
                    case a.k /*2*/:
                        stringBuilder = new StringBuilder();
                        i4 = 0;
                        i = i3;
                        while (i4 < b - 1) {
                            bArr3 = new byte[2];
                            i3 = i;
                            i = 0;
                            while (i < 2) {
                                i2 = i3 + 1;
                                bArr3[i] = bArr[i3];
                                i++;
                                i3 = i2;
                            }
                            eVar.e.add(String.format("%02x%02x", new Object[]{Byte.valueOf(bArr3[1]), Byte.valueOf(bArr3[0])}));
                            stringBuilder.append(b(bArr3));
                            stringBuilder.append("; ");
                            i4 += 2;
                            i = i3;
                        }
                        C0596r.a("   (*)serv16: " + stringBuilder.toString());
                        break;
                    case a.l /*3*/:
                        stringBuilder = new StringBuilder();
                        i4 = 0;
                        i = i3;
                        while (i4 < b - 1) {
                            bArr3 = new byte[2];
                            i3 = i;
                            i = 0;
                            while (i < 2) {
                                i2 = i3 + 1;
                                bArr3[i] = bArr[i3];
                                i++;
                                i3 = i2;
                            }
                            eVar.d.add(String.format("%02x%02x", new Object[]{Byte.valueOf(bArr3[1]), Byte.valueOf(bArr3[0])}));
                            stringBuilder.append(b(bArr3));
                            stringBuilder.append("; ");
                            i4 += 2;
                            i = i3;
                        }
                        C0596r.a("      serv16: " + stringBuilder.toString());
                        break;
                    case a.bt /*6*/:
                        stringBuilder = new StringBuilder();
                        i4 = 0;
                        i = i3;
                        while (i4 < b - 1) {
                            bArr3 = new byte[16];
                            i3 = i;
                            i = 0;
                            while (i < 16) {
                                i2 = i3 + 1;
                                bArr3[i] = bArr[i3];
                                i++;
                                i3 = i2;
                            }
                            eVar.g.add(String.format("%02x%02x%02x%02x-%02x%02x-%02x%02x-%02x%02x-%02x%02x%02x%02x%02x%02x", new Object[]{Byte.valueOf(bArr3[15]), Byte.valueOf(bArr3[14]), Byte.valueOf(bArr3[13]), Byte.valueOf(bArr3[12]), Byte.valueOf(bArr3[11]), Byte.valueOf(bArr3[10]), Byte.valueOf(bArr3[9]), Byte.valueOf(bArr3[8]), Byte.valueOf(bArr3[7]), Byte.valueOf(bArr3[6]), Byte.valueOf(bArr3[5]), Byte.valueOf(bArr3[4]), Byte.valueOf(bArr3[3]), Byte.valueOf(bArr3[2]), Byte.valueOf(bArr3[1]), Byte.valueOf(bArr3[0])}));
                            stringBuilder.append(b(bArr3));
                            stringBuilder.append("; ");
                            i4 += 16;
                            i = i3;
                        }
                        C0596r.a("  (*)serv128: " + stringBuilder.toString());
                        break;
                    case a.bc /*7*/:
                        stringBuilder = new StringBuilder();
                        i4 = 0;
                        i = i3;
                        while (i4 < b - 1) {
                            bArr3 = new byte[16];
                            i3 = i;
                            i = 0;
                            while (i < 16) {
                                i2 = i3 + 1;
                                bArr3[i] = bArr[i3];
                                i++;
                                i3 = i2;
                            }
                            eVar.f.add(String.format("%02x%02x%02x%02x-%02x%02x-%02x%02x-%02x%02x-%02x%02x%02x%02x%02x%02x", new Object[]{Byte.valueOf(bArr3[15]), Byte.valueOf(bArr3[14]), Byte.valueOf(bArr3[13]), Byte.valueOf(bArr3[12]), Byte.valueOf(bArr3[11]), Byte.valueOf(bArr3[10]), Byte.valueOf(bArr3[9]), Byte.valueOf(bArr3[8]), Byte.valueOf(bArr3[7]), Byte.valueOf(bArr3[6]), Byte.valueOf(bArr3[5]), Byte.valueOf(bArr3[4]), Byte.valueOf(bArr3[3]), Byte.valueOf(bArr3[2]), Byte.valueOf(bArr3[1]), Byte.valueOf(bArr3[0])}));
                            stringBuilder.append(b(bArr3));
                            stringBuilder.append("; ");
                            i4 += 16;
                            i = i3;
                        }
                        C0596r.a("     serv128: " + stringBuilder.toString());
                        break;
                    case a.ba /*8*/:
                        bArr2 = new byte[(b - 1)];
                        i = i3;
                        i3 = 0;
                        while (i3 < b - 1) {
                            i2 = i + 1;
                            bArr2[i3] = bArr[i];
                            i3++;
                            i = i2;
                        }
                        b2 = new String(bArr2);
                        eVar.k = b2;
                        C0596r.a("     (*)name: " + b2);
                        break;
                    case a.bo /*9*/:
                        bArr2 = new byte[(b - 1)];
                        i = i3;
                        i3 = 0;
                        while (i3 < b - 1) {
                            i2 = i + 1;
                            bArr2[i3] = bArr[i];
                            i3++;
                            i = i2;
                        }
                        b2 = new String(bArr2);
                        eVar.j = b2;
                        C0596r.a("        name: " + b2);
                        break;
                    case a.bd /*10*/:
                        bArr2 = new byte[(b - 1)];
                        i = i3;
                        i3 = 0;
                        while (i3 < b - 1) {
                            i2 = i + 1;
                            bArr2[i3] = bArr[i];
                            i3++;
                            i = i2;
                        }
                        b2 = b(bArr2);
                        eVar.l = b2;
                        C0596r.a("    tx level: " + b2);
                        break;
                    case a.aF /*20*/:
                        stringBuilder = new StringBuilder();
                        i4 = 0;
                        i = i3;
                        while (i4 < b - 1) {
                            bArr3 = new byte[2];
                            i3 = i;
                            i = 0;
                            while (i < 2) {
                                i2 = i3 + 1;
                                bArr3[i] = bArr[i3];
                                i++;
                                i3 = i2;
                            }
                            stringBuilder.append(b(bArr3));
                            stringBuilder.append("; ");
                            i4 += 2;
                            i = i3;
                        }
                        eVar.h = stringBuilder.toString();
                        C0596r.a("   solicit16: " + stringBuilder.toString());
                        break;
                    case com.xiaomi.hm.health.bt.profile.a.a.Z /*21*/:
                        stringBuilder = new StringBuilder();
                        i4 = 0;
                        i = i3;
                        while (i4 < b - 1) {
                            bArr3 = new byte[16];
                            i3 = i;
                            i = 0;
                            while (i < 16) {
                                i2 = i3 + 1;
                                bArr3[i] = bArr[i3];
                                i++;
                                i3 = i2;
                            }
                            stringBuilder.append(b(bArr3));
                            stringBuilder.append("; ");
                            i4 += 16;
                            i = i3;
                        }
                        eVar.i = stringBuilder.toString();
                        C0596r.a("  solicit128: " + stringBuilder.toString());
                        break;
                    case com.xiaomi.hm.health.bt.profile.a.a.aa /*22*/:
                        Object obj = new byte[(b - 1)];
                        i = i3;
                        i3 = 0;
                        while (i3 < b - 1) {
                            i2 = i + 1;
                            obj[i3] = bArr[i];
                            i3++;
                            i = i2;
                        }
                        if (obj.length != 12) {
                            eVar.n = com.xiaomi.hm.health.bt.profile.a.a(obj, false, false);
                            break;
                        }
                        if (!com.xiaomi.hm.health.bt.profile.Weight.a.y_.equals(a(String.format("%02X%02X", new Object[]{Byte.valueOf(obj[1]), Byte.valueOf(obj[0])})))) {
                            C0596r.d(e, "UUID is not UUID_SERVICE_WEIGHT_SCALE_SERVICE<181D>!!!");
                            break;
                        }
                        Object obj2 = new byte[(obj.length - 2)];
                        System.arraycopy(obj, 2, obj2, 0, obj2.length);
                        eVar.n = com.xiaomi.hm.health.bt.profile.a.a(obj2, false, false);
                        break;
                    default:
                        byte[] bArr4 = new byte[(b - 1)];
                        i = i3;
                        i3 = 0;
                        while (i3 < b - 1) {
                            i2 = i + 1;
                            bArr4[i3] = bArr[i];
                            i3++;
                            i = i2;
                        }
                        eVar.o = String.format("[0x%02x]", new Object[]{Byte.valueOf(r3)}) + ": " + b(bArr4);
                        C0596r.a("      " + String.format("[0x%02x]", new Object[]{Byte.valueOf(r3)}) + ": " + b(bArr4));
                        break;
                }
            }
            return eVar;
        }
        return eVar;
    }

    private static int f(byte[] bArr) {
        int i = 0;
        int length = bArr.length;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 >>> 8;
            i2 = j[(i2 ^ bArr[i]) & HeartRateInfo.HR_EMPTY_VALUE] ^ i3;
            i++;
        }
        return i2;
    }
}
