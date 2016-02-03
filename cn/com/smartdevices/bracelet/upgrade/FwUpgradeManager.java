package cn.com.smartdevices.bracelet.upgrade;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.util.SparseArray;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.ui.FwUpgradeActivity;
import cn.com.smartdevices.bracelet.ui.SettingContainerActivity;
import com.xiaomi.hm.health.bt.b.c;
import com.xiaomi.hm.health.bt.bleservice.a;
import com.xiaomi.hm.health.bt.d.b;
import com.xiaomi.hm.health.bt.model.BraceletBtInfo;
import com.xiaomi.hm.health.bt.model.h;
import com.xiaomi.hm.health.bt.model.i;
import com.xiaomi.hm.health.bt.profile.Weight.f;
import com.xiaomi.hm.health.bt.profile.c.d;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import de.greenrobot.event.EventBus;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FwUpgradeManager implements h, b {
    public static boolean FORCE_UPDATE_MILI_FW = false;
    public static boolean FORCE_UPDATE_SHOES_FW = false;
    public static boolean FORCE_UPDATE_WEIGHT_FW = false;
    private static final String MILI_1A_FW_FILEN_NAME = "Mili_1a.fw";
    private static final String MILI_1S_FW_FILEN_NAME = "Mili_hr.fw";
    private static final String MILI_FW_FILEN_NAME = "Mili.fw";
    private static final String SHOES_FW_FILE_NAME = "running.fw";
    private static final String SHOES_QQ_FW_FILE_NAME = "HM05.fw";
    private static final String TAG = "FwUpgradeMananger";
    public static final int UPGRADE_FOR_MILI = 0;
    public static final int UPGRADE_FOR_SHOES = 2;
    public static final int UPGRADE_FOR_WEIGHT = 1;
    public static final String WEIGHT_FW_LASTEST_VERSION = "V0.5.8";
    private static volatile FwUpgradeManager mDefaultInstance;
    private final a mBackgroundPoster;
    private final WeakReference<Context> mContextRef;
    private int mCurrentProgress;
    private int mCurrentShoesVersion = -1;
    private int mCurrentUpgradeType;
    private final ExecutorService mExecutorService;
    private boolean mIsExceptForHrFw = false;
    private int mLastestShoesVersion = -1;
    private int mMaxProgress;
    private int mResult = UPGRADE_FOR_MILI;
    private boolean mShowUI;
    private final Object mUpgradeLock = new Object();
    private boolean mUpgradeStarting = true;
    private SparseArray<Boolean> mUpgradeStates = new SparseArray();

    private FwUpgradeManager(Context context) {
        this.mContextRef = new WeakReference(context);
        this.mExecutorService = Executors.newSingleThreadExecutor();
        this.mBackgroundPoster = new a(this, this);
    }

    private boolean fwUpgradeByType(int i) {
        return this.mCurrentUpgradeType == 0 ? miliFwUpgrade() : this.mCurrentUpgradeType == UPGRADE_FOR_WEIGHT ? weightFwUpgrade() : this.mCurrentUpgradeType == UPGRADE_FOR_SHOES ? shoesFwUpgrade() : false;
    }

    public static FwUpgradeManager getDefault(Context context) {
        if (mDefaultInstance == null) {
            synchronized (FwUpgradeManager.class) {
                if (mDefaultInstance == null) {
                    context.getApplicationContext();
                    mDefaultInstance = new FwUpgradeManager(context);
                }
            }
        }
        return mDefaultInstance;
    }

    private static int getVersionCodeFromVersionName(String str) {
        String[] split = str.substring(UPGRADE_FOR_WEIGHT).split("\\.");
        if (split.length != 3) {
            return -1;
        }
        int parseInt = Integer.parseInt(split[UPGRADE_FOR_MILI]);
        int parseInt2 = Integer.parseInt(split[UPGRADE_FOR_WEIGHT]);
        return (Integer.parseInt(split[UPGRADE_FOR_SHOES]) & HeartRateInfo.HR_EMPTY_VALUE) | (((parseInt & HeartRateInfo.HR_EMPTY_VALUE) << 16) | ((parseInt2 & HeartRateInfo.HR_EMPTY_VALUE) << 8));
    }

    private boolean miliFwUpgrade() {
        Context context = (Context) this.mContextRef.get();
        if (context == null) {
            return false;
        }
        BraceletBtInfo readBraceletBtInfo = Keeper.readBraceletBtInfo();
        InputStream inputStream = null;
        try {
            String str = MILI_FW_FILEN_NAME;
            h f = a.f();
            if (f.a()) {
                str = MILI_1S_FW_FILEN_NAME;
            } else if (f.b()) {
                str = MILI_1A_FW_FILEN_NAME;
            }
            inputStream = context.getResources().getAssets().open(str);
            C0596r.e(TAG, "new fw length:" + inputStream.available());
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
            new com.xiaomi.hm.health.bt.a.h(readBraceletBtInfo.b, bArr, this).f();
            C0596r.e(TAG, "miliFwUpgrade BleFwUpgradeNewTask");
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            C0596r.e(TAG, e2.getMessage());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                }
            }
            return false;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
        }
    }

    private boolean shoesFwUpgrade() {
        Exception e;
        FileOutputStream fileOutputStream;
        Throwable th;
        InputStream inputStream = null;
        Context context = (Context) this.mContextRef.get();
        if (context == null) {
            return false;
        }
        com.xiaomi.hm.health.bt.profile.c.a a = d.a().a(c.SHOES);
        if (a == null || !a.f()) {
            return false;
        }
        i e2 = a.e();
        if (e2 == null) {
            return false;
        }
        String str = e2.d.b == 5 ? SHOES_QQ_FW_FILE_NAME : SHOES_FW_FILE_NAME;
        String str2 = Environment.getExternalStorageDirectory().getPath() + "/" + str;
        File file = new File(str2);
        FileOutputStream fileOutputStream2;
        try {
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream2 = new FileOutputStream(file);
            try {
                inputStream = context.getResources().getAssets().open(str);
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e3) {
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                    }
                }
                a.a(str2, (b) this);
                C0596r.e(TAG, "shoesFwUpgrade startFwUpgrade" + str2);
                return true;
            } catch (Exception e5) {
                e = e5;
                fileOutputStream = fileOutputStream2;
                try {
                    C0596r.e(TAG, e.getMessage());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e7) {
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e8) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e9) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Exception e10) {
            e = e10;
            fileOutputStream = null;
            C0596r.e(TAG, e.getMessage());
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream2 = null;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    private boolean weightFwUpgrade() {
        Exception e;
        Throwable th;
        InputStream inputStream = null;
        String str = Environment.getExternalStorageDirectory().getPath() + "/weight.fw";
        File file = new File(str);
        InputStream inputStream2 = null;
        FileOutputStream fileOutputStream;
        try {
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
            try {
                Context context = (Context) this.mContextRef.get();
                if (context == null) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    if (UPGRADE_FOR_MILI != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e3) {
                        }
                    }
                    return false;
                }
                inputStream = context.getResources().getAssets().open("weight.fw");
                C0596r.e(TAG, "new fw length:" + inputStream.available());
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e4) {
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                    }
                }
                f i = a.i();
                if (i == null) {
                    C0596r.e(TAG, "WeightProfile is null");
                    return false;
                }
                i.a(str, (b) this);
                C0596r.e(TAG, "weightFwUpgrade runFwUpgradeTask" + str);
                return true;
            } catch (Exception e6) {
                e = e6;
                try {
                    C0596r.e(TAG, e.getMessage());
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
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e9) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e10) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e11) {
            e = e11;
            fileOutputStream = null;
            C0596r.e(TAG, e.getMessage());
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return false;
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
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean checkMiliFwUpgrade() {
        /*
        r9 = this;
        r2 = 1;
        r1 = 0;
        r9.mIsExceptForHrFw = r1;
        r0 = FORCE_UPDATE_MILI_FW;
        if (r0 == 0) goto L_0x000b;
    L_0x0008:
        r0 = FORCE_UPDATE_MILI_FW;
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = r9.mContextRef;
        r0 = r0.get();
        r0 = (android.content.Context) r0;
        if (r0 != 0) goto L_0x0017;
    L_0x0015:
        r0 = r1;
        goto L_0x000a;
    L_0x0017:
        r3 = com.xiaomi.hm.health.bt.bleservice.a.c();
        if (r3 != 0) goto L_0x001f;
    L_0x001d:
        r0 = r1;
        goto L_0x000a;
    L_0x001f:
        r5 = com.xiaomi.hm.health.bt.bleservice.a.f();
        if (r5 != 0) goto L_0x0027;
    L_0x0025:
        r0 = r1;
        goto L_0x000a;
    L_0x0027:
        r3 = 0;
        r4 = r5.a();	 Catch:{ Exception -> 0x01a2, all -> 0x01b7 }
        if (r4 == 0) goto L_0x00f4;
    L_0x002e:
        r0 = r0.getResources();	 Catch:{ Exception -> 0x01a2, all -> 0x01b7 }
        r0 = r0.getAssets();	 Catch:{ Exception -> 0x01a2, all -> 0x01b7 }
        r4 = "Mili_hr.fw";
        r3 = r0.open(r4);	 Catch:{ Exception -> 0x01a2, all -> 0x01b7 }
        r0 = "FwUpgradeMananger";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r4.<init>();	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r6 = "new fw length:";
        r4 = r4.append(r6);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r6 = r3.available();	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r4 = r4.append(r6);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        cn.com.smartdevices.bracelet.C0596r.e(r0, r4);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r0 = r3.available();	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r0 = new byte[r0];	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r3.read(r0);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r4 = com.xiaomi.hm.health.bt.profile.a.d(r0);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r0 = com.xiaomi.hm.health.bt.profile.a.e(r0);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r6 = "FwUpgradeMananger";
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r7.<init>();	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r8 = "assetsFwVersion: ";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r7 = r7.append(r4);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r8 = "---";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r8 = r5.l();	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r8 = "---";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r8 = r5.f;	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r7 = r7.toString();	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        cn.com.smartdevices.bracelet.C0596r.e(r6, r7);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r6 = "FwUpgradeMananger";
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r7.<init>();	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r8 = "assetsFwVersion2:  ";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r7 = r7.append(r4);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r8 = "---";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r8 = r5.q();	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r8 = "---";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r8 = r5.g;	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r7 = r7.toString();	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        cn.com.smartdevices.bracelet.C0596r.e(r6, r7);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r6 = r5.f;	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        if (r4 > r6) goto L_0x00d8;
    L_0x00d1:
        r6 = r5.g;	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        if (r0 <= r6) goto L_0x00d8;
    L_0x00d5:
        r6 = 1;
        r9.mIsExceptForHrFw = r6;	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
    L_0x00d8:
        r6 = r5.f;	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        if (r4 > r6) goto L_0x00e0;
    L_0x00dc:
        r4 = r5.g;	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        if (r0 <= r4) goto L_0x00ea;
    L_0x00e0:
        if (r3 == 0) goto L_0x00e5;
    L_0x00e2:
        r3.close();	 Catch:{ IOException -> 0x01c0, all -> 0x00e8 }
    L_0x00e5:
        r0 = r2;
        goto L_0x000a;
    L_0x00e8:
        r0 = move-exception;
        throw r0;
    L_0x00ea:
        if (r3 == 0) goto L_0x00ef;
    L_0x00ec:
        r3.close();	 Catch:{ IOException -> 0x01c3, all -> 0x00f2 }
    L_0x00ef:
        r0 = r1;
        goto L_0x000a;
    L_0x00f2:
        r0 = move-exception;
        throw r0;
    L_0x00f4:
        r4 = r5.c();	 Catch:{ Exception -> 0x01a2, all -> 0x01b7 }
        if (r4 == 0) goto L_0x0104;
    L_0x00fa:
        if (r3 == 0) goto L_0x00ff;
    L_0x00fc:
        r3.close();	 Catch:{ IOException -> 0x01c6, all -> 0x0102 }
    L_0x00ff:
        r0 = r2;
        goto L_0x000a;
    L_0x0102:
        r0 = move-exception;
        throw r0;
    L_0x0104:
        r4 = "Mili.fw";
        r6 = r5.b();	 Catch:{ Exception -> 0x01a2, all -> 0x01b7 }
        if (r6 == 0) goto L_0x0127;
    L_0x010c:
        r4 = "Mili_1a.fw";
        r6 = r5.f;	 Catch:{ Exception -> 0x01a2, all -> 0x01b7 }
        r7 = 16845145; // 0x1010959 float:2.3700265E-38 double:8.3226074E-317;
        if (r6 != r7) goto L_0x0127;
    L_0x0115:
        r6 = r5.d;	 Catch:{ Exception -> 0x01a2, all -> 0x01b7 }
        r6 = r6 & 255;
        r7 = 208; // 0xd0 float:2.91E-43 double:1.03E-321;
        if (r6 != r7) goto L_0x0127;
    L_0x011d:
        if (r3 == 0) goto L_0x0122;
    L_0x011f:
        r3.close();	 Catch:{ IOException -> 0x01c9, all -> 0x0125 }
    L_0x0122:
        r0 = r2;
        goto L_0x000a;
    L_0x0125:
        r0 = move-exception;
        throw r0;
    L_0x0127:
        r0 = r0.getResources();	 Catch:{ Exception -> 0x01a2, all -> 0x01b7 }
        r0 = r0.getAssets();	 Catch:{ Exception -> 0x01a2, all -> 0x01b7 }
        r3 = r0.open(r4);	 Catch:{ Exception -> 0x01a2, all -> 0x01b7 }
        r0 = "FwUpgradeMananger";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r4.<init>();	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r6 = "new fw length:";
        r4 = r4.append(r6);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r6 = r3.available();	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r4 = r4.append(r6);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        cn.com.smartdevices.bracelet.C0596r.e(r0, r4);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r0 = com.xiaomi.hm.health.bt.profile.a.a(r3);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r4 = "FwUpgradeMananger";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r6.<init>();	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r7 = "new fw version:";
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r6 = r6.append(r0);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r7 = ",fw version:";
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r7 = r5.f;	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r7 = ",pcb version:";
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r7 = r5.d;	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        cn.com.smartdevices.bracelet.C0596r.e(r4, r6);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        r4 = r5.f;	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        if (r0 > r4) goto L_0x0198;
    L_0x0187:
        r0 = "FwUpgradeMananger";
        r2 = "bracelet firmware is the lastest,do nothing!";
        cn.com.smartdevices.bracelet.C0596r.e(r0, r2);	 Catch:{ Exception -> 0x01d7, all -> 0x01b7 }
        if (r3 == 0) goto L_0x0193;
    L_0x0190:
        r3.close();	 Catch:{ IOException -> 0x01cc, all -> 0x0196 }
    L_0x0193:
        r0 = r1;
        goto L_0x000a;
    L_0x0196:
        r0 = move-exception;
        throw r0;
    L_0x0198:
        if (r3 == 0) goto L_0x019d;
    L_0x019a:
        r3.close();	 Catch:{ IOException -> 0x01ce, all -> 0x01a0 }
    L_0x019d:
        r0 = r2;
        goto L_0x000a;
    L_0x01a0:
        r0 = move-exception;
        throw r0;
    L_0x01a2:
        r0 = move-exception;
        r2 = r3;
    L_0x01a4:
        r3 = "FwUpgradeMananger";
        r0 = r0.getMessage();	 Catch:{ all -> 0x01d4 }
        cn.com.smartdevices.bracelet.C0596r.e(r3, r0);	 Catch:{ all -> 0x01d4 }
        if (r2 == 0) goto L_0x01b2;
    L_0x01af:
        r2.close();	 Catch:{ IOException -> 0x01d0, all -> 0x01b5 }
    L_0x01b2:
        r0 = r1;
        goto L_0x000a;
    L_0x01b5:
        r0 = move-exception;
        throw r0;
    L_0x01b7:
        r0 = move-exception;
    L_0x01b8:
        if (r3 == 0) goto L_0x01bd;
    L_0x01ba:
        r3.close();	 Catch:{ IOException -> 0x01d2, all -> 0x01be }
    L_0x01bd:
        throw r0;
    L_0x01be:
        r0 = move-exception;
        throw r0;
    L_0x01c0:
        r0 = move-exception;
        goto L_0x00e5;
    L_0x01c3:
        r0 = move-exception;
        goto L_0x00ef;
    L_0x01c6:
        r0 = move-exception;
        goto L_0x00ff;
    L_0x01c9:
        r0 = move-exception;
        goto L_0x0122;
    L_0x01cc:
        r0 = move-exception;
        goto L_0x0193;
    L_0x01ce:
        r0 = move-exception;
        goto L_0x019d;
    L_0x01d0:
        r0 = move-exception;
        goto L_0x01b2;
    L_0x01d2:
        r1 = move-exception;
        goto L_0x01bd;
    L_0x01d4:
        r0 = move-exception;
        r3 = r2;
        goto L_0x01b8;
    L_0x01d7:
        r0 = move-exception;
        r2 = r3;
        goto L_0x01a4;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.smartdevices.bracelet.upgrade.FwUpgradeManager.checkMiliFwUpgrade():boolean");
    }

    public boolean checkShoesFwUpgrade() {
        if (FORCE_UPDATE_SHOES_FW) {
            return FORCE_UPDATE_SHOES_FW;
        }
        Context context = (Context) this.mContextRef.get();
        if (context == null) {
            return false;
        }
        com.xiaomi.hm.health.bt.profile.c.a a = d.a().a(c.SHOES);
        if (a == null || !a.f()) {
            return false;
        }
        i e = a.e();
        if (e == null || e.c == null) {
            return false;
        }
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open(e.d.b == 5 ? SHOES_QQ_FW_FILE_NAME : SHOES_FW_FILE_NAME);
            String versionNameFromFwStream = getVersionNameFromFwStream(inputStream);
            this.mLastestShoesVersion = getVersionCodeFromVersionName(versionNameFromFwStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
            }
            String str = e.c;
            this.mCurrentShoesVersion = getVersionCodeFromVersionName(str);
            C0596r.e(TAG, "new shoes fw version name:" + versionNameFromFwStream + ",shoes fw version name:" + str);
            C0596r.e(TAG, "new shoes fw version code:" + this.mLastestShoesVersion + ",shoes fw version code:" + this.mCurrentShoesVersion);
            return (this.mLastestShoesVersion == -1 || this.mCurrentShoesVersion == -1 || this.mLastestShoesVersion <= this.mCurrentShoesVersion) ? false : true;
        } catch (Exception e3) {
            C0596r.e(TAG, e3.getMessage());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
            return false;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
        }
    }

    public boolean checkUpgradeState(int i) {
        boolean booleanValue;
        synchronized (this.mUpgradeStates) {
            booleanValue = ((Boolean) this.mUpgradeStates.get(i, Boolean.valueOf(true))).booleanValue();
        }
        return booleanValue;
    }

    public boolean checkWeightFwUpgrade() {
        if (FORCE_UPDATE_WEIGHT_FW) {
            return FORCE_UPDATE_WEIGHT_FW;
        }
        f i = a.i();
        if (i == null || !i.u()) {
            return false;
        }
        String str = WEIGHT_FW_LASTEST_VERSION;
        int versionCodeFromVersionName = getVersionCodeFromVersionName(str);
        i z = i.z();
        if (z == null || z.c == null) {
            return false;
        }
        String str2 = z.c;
        int versionCodeFromVersionName2 = getVersionCodeFromVersionName(str2);
        C0596r.e(TAG, "new weight fw version name:" + str + ",weight fw version name:" + str2);
        C0596r.e(TAG, "new weight fw version code:" + versionCodeFromVersionName + ",weight fw version code:" + versionCodeFromVersionName2);
        return (versionCodeFromVersionName == -1 || versionCodeFromVersionName2 == -1 || versionCodeFromVersionName <= versionCodeFromVersionName2) ? false : true;
    }

    public void clean(Activity activity) {
        EventBus.getDefault().unregister(activity);
        setShowUI(false);
    }

    public void enableFwUpgrade() {
        synchronized (this.mUpgradeStates) {
            this.mUpgradeStates.clear();
        }
    }

    public int getCurrentProgress() {
        return this.mCurrentProgress;
    }

    public int getCurrentUpgradeType() {
        return this.mCurrentUpgradeType;
    }

    public ExecutorService getExecutorService() {
        return this.mExecutorService;
    }

    public int getMaxProgress() {
        return this.mMaxProgress;
    }

    public int getResult() {
        return this.mResult;
    }

    public String getVersionNameFromFwStream(InputStream inputStream) {
        byte[] bArr = new byte[6];
        inputStream.skip(1056);
        inputStream.read(bArr, UPGRADE_FOR_MILI, 6);
        return new String(bArr);
    }

    public boolean isExceptForHrFw() {
        return this.mIsExceptForHrFw;
    }

    public boolean isOldShoesVersion() {
        return checkShoesFwUpgrade() && this.mCurrentShoesVersion < getVersionCodeFromVersionName("v0.2.3");
    }

    public boolean isShowUI() {
        return this.mShowUI;
    }

    public void onFinish(ConcurrentLinkedQueue<Integer> concurrentLinkedQueue) {
        EventBus.getDefault().post(b.b);
        setUpgradeState(this.mCurrentUpgradeType, false);
        C0596r.d(TAG, "onFinish " + concurrentLinkedQueue.isEmpty());
    }

    public void onStart(int i) {
        C0596r.d(TAG, "Bluetooth module callback start state " + i);
        this.mResult = UPGRADE_FOR_MILI;
    }

    public void onStop(int i) {
        C0596r.d(TAG, "Bluetooth module callback end state  " + (i == 0 ? "success" : "failed"));
        this.mResult = i;
        synchronized (this.mUpgradeLock) {
            this.mUpgradeStarting = false;
            this.mUpgradeLock.notifyAll();
        }
        EventBus.getDefault().post(new cn.com.smartdevices.bracelet.upgrade.a.a(this.mCurrentUpgradeType, this.mResult));
    }

    public void onUpgrade(int i) {
        C0596r.d(TAG, "onUpgrade " + i);
        this.mCurrentUpgradeType = i;
        Context context = (Context) this.mContextRef.get();
        if (context != null) {
            if (fwUpgradeByType(i)) {
                if (this.mShowUI && this.mCurrentUpgradeType != i) {
                    EventBus.getDefault().post(b.c);
                }
                if (!this.mShowUI) {
                    Intent intent = new Intent();
                    intent.setClass(context, FwUpgradeActivity.class);
                    intent.setFlags(268435456);
                    intent.putExtra(SettingContainerActivity.a, i);
                    context.startActivity(intent);
                    C0596r.e(TAG, "start upgrade activity");
                }
                synchronized (this.mUpgradeLock) {
                    this.mUpgradeStarting = true;
                    while (this.mUpgradeStarting) {
                        try {
                            this.mUpgradeLock.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                }
                C0596r.d(TAG, "End onUpgrade " + i);
                return;
            }
            C0596r.d(TAG, "onUpgrade cancel");
        }
    }

    public void register(Activity activity) {
        EventBus.getDefault().register(activity);
        setShowUI(true);
    }

    public void report(int i) {
        this.mCurrentProgress = i;
        C0596r.e(TAG, "report progress" + i);
        EventBus.getDefault().post(b.a);
    }

    public void setMax(int i) {
        C0596r.e(TAG, "setMax " + i);
        this.mMaxProgress = i;
    }

    public void setShowUI(boolean z) {
        this.mShowUI = z;
    }

    public void setUpgradeState(int i, boolean z) {
        synchronized (this.mUpgradeStates) {
            this.mUpgradeStates.put(i, Boolean.valueOf(z));
        }
    }

    public void upgrade(int i) {
        upgrade(i, false);
    }

    public void upgrade(int i, boolean z) {
        C0596r.e(TAG, "fwUpgrade " + i);
        if (i == 0) {
            h f = a.f();
            if (f != null && f.a()) {
                z = true;
            }
        }
        if (z || checkUpgradeState(i)) {
            this.mBackgroundPoster.a(Integer.valueOf(i), this);
        } else {
            C0596r.e(TAG, "Check the upgrade does not receive the " + i + "type task, return to exit");
        }
    }
}
