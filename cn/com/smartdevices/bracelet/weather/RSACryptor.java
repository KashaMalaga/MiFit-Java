package cn.com.smartdevices.bracelet.weather;

import android.util.Base64;
import com.activeandroid.b;
import com.d.a.a.h;
import com.tencent.connect.common.Constants;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class RSACryptor {
    private static final int MAXENCRYPTSIZE = 127;
    private static final String MODULUS = "91260911122270127234998794195592609888073958094373010756710379192625130836419604330763856136850049911413204124223615647519195442106322096484402456126786185173546280736241523122414918124588757446468517350617150284870882239165712536054685980495005286151635113622783814352878825904710689839570887752503335468013";
    private static final String PUBLIC_KEY = "65537";
    private static String sPrivateKey;

    public static String decode(String str) {
        try {
            if (sPrivateKey == null) {
                genRSAKey();
            }
            str = decode(str, MODULUS, sPrivateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String decode(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            return null;
        }
        BigInteger bigInteger = new BigInteger(str2);
        byte[] toByteArray = new BigInteger(str).modPow(new BigInteger(str3), bigInteger).toByteArray();
        return new String(toByteArray, 1, toByteArray.length - 1, h.DEFAULT_CHARSET);
    }

    public static String encode(String str) {
        try {
            str = encode(str, MODULUS, PUBLIC_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String encode(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null || str.getBytes(h.DEFAULT_CHARSET).length > MAXENCRYPTSIZE) {
            return null;
        }
        BigInteger bigInteger = new BigInteger(str2);
        return new String(Base64.encode(new BigInteger(Constants.VIA_RESULT_SUCCESS.concat(str).getBytes(h.DEFAULT_CHARSET)).modPow(new BigInteger(str3), bigInteger).toByteArray(), 8), h.DEFAULT_CHARSET);
    }

    public static void genRSAKey() {
        KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
        instance.initialize(b.a);
        KeyPair genKeyPair = instance.genKeyPair();
        RSAPublicKey rSAPublicKey = (RSAPublicKey) genKeyPair.getPublic();
        sPrivateKey = ((RSAPrivateKey) genKeyPair.getPrivate()).getPrivateExponent().toString();
    }

    public static void genRSAKeySafe() {
        try {
            genRSAKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
