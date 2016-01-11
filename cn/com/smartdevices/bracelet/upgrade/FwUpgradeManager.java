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

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean shoesFwUpgrade() {
        /*
        r7 = this;
        r2 = 0;
        r1 = 0;
        r0 = r7.mContextRef;
        r0 = r0.get();
        r0 = (android.content.Context) r0;
        if (r0 != 0) goto L_0x000e;
    L_0x000c:
        r0 = r1;
    L_0x000d:
        return r0;
    L_0x000e:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = android.os.Environment.getExternalStorageDirectory();
        r4 = r4.getPath();
        r3 = r3.append(r4);
        r4 = "/";
        r3 = r3.append(r4);
        r4 = "running.fw";
        r3 = r3.append(r4);
        r4 = r3.toString();
        r5 = new java.io.File;
        r5.<init>(r4);
        r3 = r5.exists();	 Catch:{ Exception -> 0x0081, all -> 0x009d }
        if (r3 == 0) goto L_0x003d;
    L_0x003a:
        r5.delete();	 Catch:{ Exception -> 0x0081, all -> 0x009d }
    L_0x003d:
        r3 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0081, all -> 0x009d }
        r3.<init>(r5);	 Catch:{ Exception -> 0x0081, all -> 0x009d }
        r0 = r0.getResources();	 Catch:{ Exception -> 0x00df, all -> 0x00d8 }
        r0 = r0.getAssets();	 Catch:{ Exception -> 0x00df, all -> 0x00d8 }
        r5 = "running.fw";
        r2 = r0.open(r5);	 Catch:{ Exception -> 0x00df, all -> 0x00d8 }
        r0 = r2.available();	 Catch:{ Exception -> 0x00e4, all -> 0x00d8 }
        r0 = new byte[r0];	 Catch:{ Exception -> 0x00e4, all -> 0x00d8 }
        r2.read(r0);	 Catch:{ Exception -> 0x00e4, all -> 0x00d8 }
        r3.write(r0);	 Catch:{ Exception -> 0x00e4, all -> 0x00d8 }
        r3.flush();	 Catch:{ Exception -> 0x00e4, all -> 0x00d8 }
        if (r3 == 0) goto L_0x0064;
    L_0x0061:
        r3.close();	 Catch:{ IOException -> 0x00cc, all -> 0x007d }
    L_0x0064:
        if (r2 == 0) goto L_0x0069;
    L_0x0066:
        r2.close();	 Catch:{ IOException -> 0x00ce, all -> 0x007f }
    L_0x0069:
        r0 = com.xiaomi.hm.health.bt.profile.c.d.a();
        r2 = com.xiaomi.hm.health.bt.b.c.SHOES;
        r0 = r0.a(r2);
        if (r0 == 0) goto L_0x007b;
    L_0x0075:
        r2 = r0.f();
        if (r2 != 0) goto L_0x00ae;
    L_0x007b:
        r0 = r1;
        goto L_0x000d;
    L_0x007d:
        r0 = move-exception;
        throw r0;
    L_0x007f:
        r0 = move-exception;
        throw r0;
    L_0x0081:
        r0 = move-exception;
        r3 = r2;
    L_0x0083:
        r4 = "FwUpgradeMananger";
        r0 = r0.getMessage();	 Catch:{ all -> 0x00da }
        cn.com.smartdevices.bracelet.C0596r.e(r4, r0);	 Catch:{ all -> 0x00da }
        if (r2 == 0) goto L_0x0091;
    L_0x008e:
        r2.close();	 Catch:{ IOException -> 0x00d0, all -> 0x0099 }
    L_0x0091:
        if (r3 == 0) goto L_0x0096;
    L_0x0093:
        r3.close();	 Catch:{ IOException -> 0x00d2, all -> 0x009b }
    L_0x0096:
        r0 = r1;
        goto L_0x000d;
    L_0x0099:
        r0 = move-exception;
        throw r0;
    L_0x009b:
        r0 = move-exception;
        throw r0;
    L_0x009d:
        r0 = move-exception;
        r3 = r2;
    L_0x009f:
        if (r3 == 0) goto L_0x00a4;
    L_0x00a1:
        r3.close();	 Catch:{ IOException -> 0x00d4, all -> 0x00aa }
    L_0x00a4:
        if (r2 == 0) goto L_0x00a9;
    L_0x00a6:
        r2.close();	 Catch:{ IOException -> 0x00d6, all -> 0x00ac }
    L_0x00a9:
        throw r0;
    L_0x00aa:
        r0 = move-exception;
        throw r0;
    L_0x00ac:
        r0 = move-exception;
        throw r0;
    L_0x00ae:
        r0.a(r4, r7);
        r0 = "FwUpgradeMananger";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "shoesFwUpgrade startFwUpgrade";
        r1 = r1.append(r2);
        r1 = r1.append(r4);
        r1 = r1.toString();
        cn.com.smartdevices.bracelet.C0596r.e(r0, r1);
        r0 = 1;
        goto L_0x000d;
    L_0x00cc:
        r0 = move-exception;
        goto L_0x0064;
    L_0x00ce:
        r0 = move-exception;
        goto L_0x0069;
    L_0x00d0:
        r0 = move-exception;
        goto L_0x0091;
    L_0x00d2:
        r0 = move-exception;
        goto L_0x0096;
    L_0x00d4:
        r1 = move-exception;
        goto L_0x00a4;
    L_0x00d6:
        r1 = move-exception;
        goto L_0x00a9;
    L_0x00d8:
        r0 = move-exception;
        goto L_0x009f;
    L_0x00da:
        r0 = move-exception;
        r6 = r2;
        r2 = r3;
        r3 = r6;
        goto L_0x009f;
    L_0x00df:
        r0 = move-exception;
        r6 = r3;
        r3 = r2;
        r2 = r6;
        goto L_0x0083;
    L_0x00e4:
        r0 = move-exception;
        r6 = r3;
        r3 = r2;
        r2 = r6;
        goto L_0x0083;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.smartdevices.bracelet.upgrade.FwUpgradeManager.shoesFwUpgrade():boolean");
    }

    private boolean weightFwUpgrade() {
        FileOutputStream fileOutputStream;
        Exception e;
        Throwable th;
        InputStream inputStream = null;
        String str = Environment.getExternalStorageDirectory().getPath() + "/weight.fw";
        File file = new File(str);
        InputStream inputStream2 = null;
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
        r4 = r5.a();	 Catch:{ Exception -> 0x0192, all -> 0x01a7 }
        if (r4 == 0) goto L_0x00f4;
    L_0x002e:
        r0 = r0.getResources();	 Catch:{ Exception -> 0x0192, all -> 0x01a7 }
        r0 = r0.getAssets();	 Catch:{ Exception -> 0x0192, all -> 0x01a7 }
        r4 = "Mili_hr.fw";
        r3 = r0.open(r4);	 Catch:{ Exception -> 0x0192, all -> 0x01a7 }
        r0 = "FwUpgradeMananger";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r4.<init>();	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r6 = "new fw length:";
        r4 = r4.append(r6);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r6 = r3.available();	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r4 = r4.append(r6);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        cn.com.smartdevices.bracelet.C0596r.e(r0, r4);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r0 = r3.available();	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r0 = new byte[r0];	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r3.read(r0);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r4 = com.xiaomi.hm.health.bt.profile.a.d(r0);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r0 = com.xiaomi.hm.health.bt.profile.a.e(r0);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r6 = "FwUpgradeMananger";
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r7.<init>();	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r8 = "assetsFwVersion: ";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r7 = r7.append(r4);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r8 = "---";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r8 = r5.k();	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r8 = "---";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r8 = r5.f;	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r7 = r7.toString();	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        cn.com.smartdevices.bracelet.C0596r.e(r6, r7);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r6 = "FwUpgradeMananger";
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r7.<init>();	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r8 = "assetsFwVersion2:  ";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r7 = r7.append(r4);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r8 = "---";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r8 = r5.p();	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r8 = "---";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r8 = r5.g;	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r7 = r7.toString();	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        cn.com.smartdevices.bracelet.C0596r.e(r6, r7);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r6 = r5.f;	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        if (r4 > r6) goto L_0x00d8;
    L_0x00d1:
        r6 = r5.g;	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        if (r0 <= r6) goto L_0x00d8;
    L_0x00d5:
        r6 = 1;
        r9.mIsExceptForHrFw = r6;	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
    L_0x00d8:
        r6 = r5.f;	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        if (r4 > r6) goto L_0x00e0;
    L_0x00dc:
        r4 = r5.g;	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        if (r0 <= r4) goto L_0x00ea;
    L_0x00e0:
        if (r3 == 0) goto L_0x00e5;
    L_0x00e2:
        r3.close();	 Catch:{ IOException -> 0x01b0, all -> 0x00e8 }
    L_0x00e5:
        r0 = r2;
        goto L_0x000a;
    L_0x00e8:
        r0 = move-exception;
        throw r0;
    L_0x00ea:
        if (r3 == 0) goto L_0x00ef;
    L_0x00ec:
        r3.close();	 Catch:{ IOException -> 0x01b3, all -> 0x00f2 }
    L_0x00ef:
        r0 = r1;
        goto L_0x000a;
    L_0x00f2:
        r0 = move-exception;
        throw r0;
    L_0x00f4:
        r4 = "Mili.fw";
        r6 = r5.b();	 Catch:{ Exception -> 0x0192, all -> 0x01a7 }
        if (r6 == 0) goto L_0x0117;
    L_0x00fc:
        r4 = "Mili_1a.fw";
        r6 = r5.f;	 Catch:{ Exception -> 0x0192, all -> 0x01a7 }
        r7 = 16845145; // 0x1010959 float:2.3700265E-38 double:8.3226074E-317;
        if (r6 != r7) goto L_0x0117;
    L_0x0105:
        r6 = r5.d;	 Catch:{ Exception -> 0x0192, all -> 0x01a7 }
        r6 = r6 & 255;
        r7 = 208; // 0xd0 float:2.91E-43 double:1.03E-321;
        if (r6 != r7) goto L_0x0117;
    L_0x010d:
        if (r3 == 0) goto L_0x0112;
    L_0x010f:
        r3.close();	 Catch:{ IOException -> 0x01b6, all -> 0x0115 }
    L_0x0112:
        r0 = r2;
        goto L_0x000a;
    L_0x0115:
        r0 = move-exception;
        throw r0;
    L_0x0117:
        r0 = r0.getResources();	 Catch:{ Exception -> 0x0192, all -> 0x01a7 }
        r0 = r0.getAssets();	 Catch:{ Exception -> 0x0192, all -> 0x01a7 }
        r3 = r0.open(r4);	 Catch:{ Exception -> 0x0192, all -> 0x01a7 }
        r0 = "FwUpgradeMananger";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r4.<init>();	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r6 = "new fw length:";
        r4 = r4.append(r6);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r6 = r3.available();	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r4 = r4.append(r6);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        cn.com.smartdevices.bracelet.C0596r.e(r0, r4);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r0 = com.xiaomi.hm.health.bt.profile.a.a(r3);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r4 = "FwUpgradeMananger";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r6.<init>();	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r7 = "new fw version:";
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r6 = r6.append(r0);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r7 = ",fw version:";
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r7 = r5.f;	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r7 = ",pcb version:";
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r7 = r5.d;	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        cn.com.smartdevices.bracelet.C0596r.e(r4, r6);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        r4 = r5.f;	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        if (r0 > r4) goto L_0x0188;
    L_0x0177:
        r0 = "FwUpgradeMananger";
        r2 = "bracelet firmware is the lastest,do nothing!";
        cn.com.smartdevices.bracelet.C0596r.e(r0, r2);	 Catch:{ Exception -> 0x01c4, all -> 0x01a7 }
        if (r3 == 0) goto L_0x0183;
    L_0x0180:
        r3.close();	 Catch:{ IOException -> 0x01b9, all -> 0x0186 }
    L_0x0183:
        r0 = r1;
        goto L_0x000a;
    L_0x0186:
        r0 = move-exception;
        throw r0;
    L_0x0188:
        if (r3 == 0) goto L_0x018d;
    L_0x018a:
        r3.close();	 Catch:{ IOException -> 0x01bb, all -> 0x0190 }
    L_0x018d:
        r0 = r2;
        goto L_0x000a;
    L_0x0190:
        r0 = move-exception;
        throw r0;
    L_0x0192:
        r0 = move-exception;
        r2 = r3;
    L_0x0194:
        r3 = "FwUpgradeMananger";
        r0 = r0.getMessage();	 Catch:{ all -> 0x01c1 }
        cn.com.smartdevices.bracelet.C0596r.e(r3, r0);	 Catch:{ all -> 0x01c1 }
        if (r2 == 0) goto L_0x01a2;
    L_0x019f:
        r2.close();	 Catch:{ IOException -> 0x01bd, all -> 0x01a5 }
    L_0x01a2:
        r0 = r1;
        goto L_0x000a;
    L_0x01a5:
        r0 = move-exception;
        throw r0;
    L_0x01a7:
        r0 = move-exception;
    L_0x01a8:
        if (r3 == 0) goto L_0x01ad;
    L_0x01aa:
        r3.close();	 Catch:{ IOException -> 0x01bf, all -> 0x01ae }
    L_0x01ad:
        throw r0;
    L_0x01ae:
        r0 = move-exception;
        throw r0;
    L_0x01b0:
        r0 = move-exception;
        goto L_0x00e5;
    L_0x01b3:
        r0 = move-exception;
        goto L_0x00ef;
    L_0x01b6:
        r0 = move-exception;
        goto L_0x0112;
    L_0x01b9:
        r0 = move-exception;
        goto L_0x0183;
    L_0x01bb:
        r0 = move-exception;
        goto L_0x018d;
    L_0x01bd:
        r0 = move-exception;
        goto L_0x01a2;
    L_0x01bf:
        r1 = move-exception;
        goto L_0x01ad;
    L_0x01c1:
        r0 = move-exception;
        r3 = r2;
        goto L_0x01a8;
    L_0x01c4:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0194;
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
            inputStream = context.getResources().getAssets().open(SHOES_FW_FILE_NAME);
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
