package com.xiaomi.hm.health.bt.a;

import cn.com.smartdevices.bracelet.C0596r;
import com.tencent.connect.common.Constants;
import com.xiaomi.hm.health.bt.model.h;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class C1116c extends C {
    public C1116c(d dVar) {
        super(dVar);
    }

    public void a(d dVar) {
        boolean a;
        NoSuchAlgorithmException e;
        int i = 0;
        if (dVar != null) {
            dVar.c();
        }
        h j_ = this.q.j_();
        if (j_ != null) {
            String str = "gh_f65f9f1aa87a";
            String str2 = "gh_f65f9f1aa87a" + j_.a;
            try {
                byte[] digest = MessageDigest.getInstance("MD5").digest(str2.getBytes());
                a = this.q.a(digest);
                try {
                    StringBuilder stringBuilder = new StringBuilder(digest.length * 2);
                    int length = digest.length;
                    while (i < length) {
                        byte b = digest[i];
                        if ((b & HeartRateInfo.HR_EMPTY_VALUE) < 16) {
                            stringBuilder.append(Constants.VIA_RESULT_SUCCESS);
                        }
                        stringBuilder.append(Integer.toHexString(b & HeartRateInfo.HR_EMPTY_VALUE));
                        i++;
                    }
                    C0596r.e(p, "string:" + str2 + ",md5:" + stringBuilder.toString());
                } catch (NoSuchAlgorithmException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (dVar == null) {
                        dVar.c(Boolean.valueOf(a));
                    }
                }
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                a = false;
                e.printStackTrace();
                if (dVar == null) {
                    dVar.c(Boolean.valueOf(a));
                }
            }
            if (dVar == null) {
                dVar.c(Boolean.valueOf(a));
            }
        } else if (dVar != null) {
            dVar.c(Boolean.valueOf(false));
        }
    }
}
