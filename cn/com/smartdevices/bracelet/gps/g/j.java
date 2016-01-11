package cn.com.smartdevices.bracelet.gps.g;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.g;
import cn.com.smartdevices.bracelet.ui.AlarmActivity;
import com.activeandroid.b;
import com.d.a.a.C1012a;
import com.tencent.connect.common.Constants;
import com.xiaomi.account.openauth.h;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class j {
    private HashMap<String, String> a;

    public j() {
        this.a = null;
        this.a = d();
    }

    private List<String> a(String str) {
        char[] toCharArray = str.toCharArray();
        List<String> arrayList = new ArrayList();
        for (char valueOf : toCharArray) {
            arrayList.add(this.a.get(String.valueOf(valueOf)));
        }
        return arrayList;
    }

    private List<String> b(String str) {
        List<String> arrayList = new ArrayList();
        int parseInt = Integer.parseInt(str);
        int i = parseInt / C1012a.b;
        if (i > 0) {
            arrayList.add(this.a.get(String.valueOf(i)));
            arrayList.add(this.a.get("10000"));
        }
        i = (parseInt % C1012a.b) / h.E;
        if (i > 0) {
            arrayList.add(this.a.get(String.valueOf(i)));
            arrayList.add(this.a.get(Constants.DEFAULT_UIN));
        }
        i = (parseInt % h.E) / 100;
        if (i > 0) {
            arrayList.add(this.a.get(String.valueOf(i)));
            arrayList.add(this.a.get("100"));
        }
        int i2 = ((parseInt % h.E) % 100) / 10;
        parseInt = ((parseInt % h.E) % 100) % 10;
        if (i2 <= 0) {
            if (i > 0) {
                arrayList.add(this.a.get(Constants.VIA_RESULT_SUCCESS));
            }
            if (parseInt > 0) {
                arrayList.add(this.a.get(String.valueOf(parseInt)));
            }
        } else if (i2 == 1) {
            if (i > 0) {
                arrayList.add(this.a.get(Constants.VIA_TO_TYPE_QQ_GROUP));
            }
            arrayList.add(this.a.get(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
            if (parseInt != 0) {
                arrayList.add(this.a.get(String.valueOf(parseInt)));
            }
        } else {
            arrayList.add(this.a.get(String.valueOf(i2)));
            arrayList.add(this.a.get(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
            if (parseInt > 0) {
                arrayList.add(this.a.get(String.valueOf(parseInt)));
            }
        }
        return arrayList;
    }

    private List<String> c(String str) {
        List<String> arrayList = new ArrayList();
        int parseInt = Integer.parseInt(str);
        int i = parseInt / 3600;
        if (i > 0) {
            arrayList.addAll(b(String.valueOf(i)));
            arrayList.add(this.a.get(AlarmActivity.c));
        }
        i = (parseInt % 3600) / 60;
        if (i > 0) {
            arrayList.addAll(b(String.valueOf(i)));
            arrayList.add(this.a.get("minute"));
        }
        parseInt = (parseInt % 3600) % 60;
        if (parseInt > 0) {
            arrayList.addAll(b(String.valueOf(parseInt)));
            arrayList.add(this.a.get("second"));
        }
        return arrayList;
    }

    private HashMap<String, String> d() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put(Constants.VIA_RESULT_SUCCESS, "voice/0.mp3");
        hashMap.put(Constants.VIA_TO_TYPE_QQ_GROUP, "voice/1.mp3");
        hashMap.put(Constants.VIA_SSO_LOGIN, "voice/2.mp3");
        hashMap.put(Constants.VIA_TO_TYPE_QQ_DISCUSS_GROUP, "voice/3.mp3");
        hashMap.put(Constants.VIA_TO_TYPE_QZONE, "voice/4.mp3");
        hashMap.put(Constants.VIA_SHARE_TYPE_TEXT, "voice/5.mp3");
        hashMap.put(Constants.VIA_SHARE_TYPE_INFO, "voice/6.mp3");
        hashMap.put("7", "voice/7.mp3");
        hashMap.put("8", "voice/8.mp3");
        hashMap.put("9", "voice/9.mp3");
        hashMap.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "voice/10.mp3");
        hashMap.put("100", "voice/100.mp3");
        hashMap.put(Constants.DEFAULT_UIN, "voice/1000.mp3");
        hashMap.put("10000", "voice/10000.mp3");
        hashMap.put("dot", "voice/dot.mp3");
        hashMap.put("kilometer", "voice/kilometer.mp3");
        hashMap.put("near_kilometer_spent", "voice/near_kilometer_spent.mp3");
        hashMap.put("second", "voice/second.mp3");
        hashMap.put("minute", "voice/minute.mp3");
        hashMap.put(AlarmActivity.c, "voice/hour.mp3");
        hashMap.put("time_spent", "voice/time_spent.mp3");
        hashMap.put("already_run", "voice/already_run.mp3");
        hashMap.put("gps_lost", "voice/gps_lost.mp3");
        hashMap.put("gps_regained", "voice/gps_regained.mp3");
        hashMap.put("great", "voice/great.mp3");
        hashMap.put("hr_high", "voice/hr_high.mp3");
        hashMap.put("current_hr", "voice/current_hr.mp3");
        hashMap.put("per_minute", "voice/per_minute.mp3");
        hashMap.put(g.f, "voice/time.mp3");
        return hashMap;
    }

    File a(Context context, List<String> list) {
        SequenceInputStream sequenceInputStream;
        FileOutputStream fileOutputStream;
        Exception e;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        String str = context.getFilesDir() + File.separator + "sound.mp3";
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        AssetManager assets = context.getResources().getAssets();
        try {
            Collection arrayList = new ArrayList();
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(assets.open(str2));
                }
            }
            sequenceInputStream = new SequenceInputStream(Collections.enumeration(arrayList));
            try {
                fileOutputStream = new FileOutputStream(str);
                try {
                    byte[] bArr = new byte[b.a];
                    while (true) {
                        int read = sequenceInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        fileOutputStream.flush();
                    }
                    fileOutputStream.flush();
                    file = new File(str);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    if (sequenceInputStream == null) {
                        return file;
                    }
                    try {
                        sequenceInputStream.close();
                        return file;
                    } catch (IOException e3) {
                        return file;
                    }
                } catch (Exception e4) {
                    e = e4;
                    try {
                        C0596r.a("Player", e.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        if (sequenceInputStream != null) {
                            try {
                                sequenceInputStream.close();
                            } catch (IOException e6) {
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e7) {
                            }
                        }
                        if (sequenceInputStream != null) {
                            try {
                                sequenceInputStream.close();
                            } catch (IOException e8) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e9) {
                e = e9;
                fileOutputStream = null;
                C0596r.a("Player", e.getMessage());
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (sequenceInputStream != null) {
                    sequenceInputStream.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                if (sequenceInputStream != null) {
                    sequenceInputStream.close();
                }
                throw th;
            }
        } catch (Exception e10) {
            e = e10;
            fileOutputStream = null;
            sequenceInputStream = null;
            C0596r.a("Player", e.getMessage());
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (sequenceInputStream != null) {
                sequenceInputStream.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            sequenceInputStream = null;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            if (sequenceInputStream != null) {
                sequenceInputStream.close();
            }
            throw th;
        }
    }

    List<String> a(int i) {
        List<String> arrayList = new ArrayList();
        arrayList.add(this.a.get("hr_high"));
        arrayList.addAll(b(i));
        return arrayList;
    }

    List<String> a(h hVar) {
        String valueOf;
        List<String> arrayList = new ArrayList();
        if (hVar.a > 0.0f) {
            arrayList.add(this.a.get("already_run"));
            valueOf = String.valueOf((int) hVar.a);
            if (valueOf.indexOf(".") > 0) {
                String[] split = valueOf.split("\\.");
                if (split.length == 2) {
                    String str = split[0];
                    valueOf = split[1];
                    arrayList.addAll(b(str));
                    arrayList.add(this.a.get("dot"));
                    arrayList.addAll(a(valueOf));
                }
            } else {
                arrayList.addAll(b(valueOf));
            }
            arrayList.add(this.a.get("kilometer"));
        }
        if (hVar.c > 0) {
            valueOf = String.valueOf(hVar.c);
            arrayList.add(this.a.get("time_spent"));
            arrayList.addAll(c(valueOf));
        }
        if (hVar.b > 0.0f) {
            arrayList.add(this.a.get("near_kilometer_spent"));
            arrayList.addAll(c(String.valueOf((long) hVar.b)));
        }
        int i = hVar.e;
        if (HeartRateInfo.isHRValueValid(i)) {
            arrayList.addAll(b(i));
        }
        if (hVar.b <= 360.0f) {
            arrayList.add(this.a.get("great"));
        }
        return arrayList;
    }

    public void a() {
        if (this.a != null) {
            this.a.clear();
        }
    }

    List<String> b() {
        List<String> arrayList = new ArrayList();
        arrayList.add(this.a.get("gps_lost"));
        return arrayList;
    }

    List<String> b(int i) {
        List<String> arrayList = new ArrayList();
        arrayList.add(this.a.get("current_hr"));
        arrayList.add(this.a.get("per_minute"));
        arrayList.addAll(b(String.valueOf(i)));
        arrayList.add(this.a.get(g.f));
        return arrayList;
    }

    List<String> c() {
        List<String> arrayList = new ArrayList();
        arrayList.add(this.a.get("gps_regained"));
        return arrayList;
    }
}
