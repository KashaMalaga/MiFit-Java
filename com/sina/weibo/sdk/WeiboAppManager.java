package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import com.g.a.b.b;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class WeiboAppManager {
    private static final String SDK_INT_FILE_NAME = "weibo_for_sdk.json";
    private static final String TAG = WeiboAppManager.class.getName();
    private static final String WEIBO_IDENTITY_ACTION = "com.sina.weibo.action.sdkidentity";
    private static final Uri WEIBO_NAME_URI = Uri.parse("content://com.sina.weibo.sdkProvider/query/package");
    private static WeiboAppManager sInstance;
    private Context mContext;

    public class WeiboInfo {
        private String mPackageName;
        private int mSupportApi;

        private void setPackageName(String str) {
            this.mPackageName = str;
        }

        private void setSupportApi(int i) {
            this.mSupportApi = i;
        }

        public String getPackageName() {
            return this.mPackageName;
        }

        public int getSupportApi() {
            return this.mSupportApi;
        }

        public boolean isLegal() {
            return !TextUtils.isEmpty(this.mPackageName) && this.mSupportApi > 0;
        }

        public String toString() {
            return "WeiboInfo: PackageName = " + this.mPackageName + ", supportApi = " + this.mSupportApi;
        }
    }

    private WeiboAppManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static synchronized WeiboAppManager getInstance(Context context) {
        WeiboAppManager weiboAppManager;
        synchronized (WeiboAppManager.class) {
            if (sInstance == null) {
                sInstance = new WeiboAppManager(context);
            }
            weiboAppManager = sInstance;
        }
        return weiboAppManager;
    }

    private WeiboInfo queryWeiboInfoByAsset(Context context) {
        Intent intent = new Intent(WEIBO_IDENTITY_ACTION);
        intent.addCategory("android.intent.category.DEFAULT");
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            return null;
        }
        WeiboInfo weiboInfo = null;
        for (ResolveInfo resolveInfo : queryIntentServices) {
            if (!(resolveInfo.serviceInfo == null || resolveInfo.serviceInfo.applicationInfo == null || TextUtils.isEmpty(resolveInfo.serviceInfo.applicationInfo.packageName))) {
                WeiboInfo parseWeiboInfoByAsset = parseWeiboInfoByAsset(resolveInfo.serviceInfo.applicationInfo.packageName);
                if (parseWeiboInfoByAsset != null) {
                    if (weiboInfo == null) {
                        weiboInfo = parseWeiboInfoByAsset;
                    } else if (weiboInfo.getSupportApi() < parseWeiboInfoByAsset.getSupportApi()) {
                        weiboInfo = parseWeiboInfoByAsset;
                    }
                }
            }
        }
        return weiboInfo;
    }

    private WeiboInfo queryWeiboInfoByProvider(Context context) {
        Exception e;
        Throwable th;
        Cursor query;
        try {
            query = context.getContentResolver().query(WEIBO_NAME_URI, null, null, null, null);
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            try {
                int columnIndex = query.getColumnIndex("support_api");
                int columnIndex2 = query.getColumnIndex(b.b);
                if (query.moveToFirst()) {
                    int i = -1;
                    try {
                        columnIndex = Integer.parseInt(query.getString(columnIndex));
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                        columnIndex = i;
                    }
                    String string = query.getString(columnIndex2);
                    if (!TextUtils.isEmpty(string) && ApiUtils.validateWeiboSign(context, string)) {
                        WeiboInfo weiboInfo = new WeiboInfo();
                        weiboInfo.setPackageName(string);
                        weiboInfo.setSupportApi(columnIndex);
                        if (query == null) {
                            return weiboInfo;
                        }
                        query.close();
                        return weiboInfo;
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    LogUtil.e(TAG, e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            return null;
        } catch (Exception e4) {
            e = e4;
            query = null;
            LogUtil.e(TAG, e.getMessage());
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private WeiboInfo queryWeiboInfoInternal(Context context) {
        Object obj = 1;
        WeiboInfo queryWeiboInfoByProvider = queryWeiboInfoByProvider(context);
        WeiboInfo queryWeiboInfoByAsset = queryWeiboInfoByAsset(context);
        Object obj2 = queryWeiboInfoByProvider != null ? 1 : null;
        if (queryWeiboInfoByAsset == null) {
            obj = null;
        }
        return (obj2 == null || obj == null) ? obj2 == null ? obj != null ? queryWeiboInfoByAsset : null : queryWeiboInfoByProvider : queryWeiboInfoByProvider.getSupportApi() >= queryWeiboInfoByAsset.getSupportApi() ? queryWeiboInfoByProvider : queryWeiboInfoByAsset;
    }

    public synchronized WeiboInfo getWeiboInfo() {
        return queryWeiboInfoInternal(this.mContext);
    }

    public WeiboInfo parseWeiboInfoByAsset(String str) {
        InputStream open;
        IOException e;
        NameNotFoundException e2;
        JSONException e3;
        Exception e4;
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArr = new byte[ChartData.d];
            open = this.mContext.createPackageContext(str, 2).getAssets().open(SDK_INT_FILE_NAME);
            try {
                StringBuilder stringBuilder = new StringBuilder();
                while (true) {
                    int read = open.read(bArr, 0, ChartData.d);
                    if (read == -1) {
                        break;
                    }
                    stringBuilder.append(new String(bArr, 0, read));
                }
                if (!TextUtils.isEmpty(stringBuilder.toString()) && ApiUtils.validateWeiboSign(this.mContext, str)) {
                    int optInt = new JSONObject(stringBuilder.toString()).optInt("support_api", -1);
                    WeiboInfo weiboInfo = new WeiboInfo();
                    weiboInfo.setPackageName(str);
                    weiboInfo.setSupportApi(optInt);
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e5) {
                            LogUtil.e(TAG, e5.getMessage());
                        }
                    }
                    return weiboInfo;
                } else if (open == null) {
                    return null;
                } else {
                    try {
                        open.close();
                        return null;
                    } catch (IOException e6) {
                        LogUtil.e(TAG, e6.getMessage());
                        return null;
                    }
                }
            } catch (NameNotFoundException e7) {
                e2 = e7;
            } catch (IOException e8) {
                e6 = e8;
            } catch (JSONException e9) {
                e3 = e9;
            } catch (Exception e10) {
                e4 = e10;
            }
        } catch (NameNotFoundException e11) {
            e2 = e11;
            open = null;
            try {
                LogUtil.e(TAG, e2.getMessage());
                if (open == null) {
                    return null;
                }
                try {
                    open.close();
                    return null;
                } catch (IOException e62) {
                    LogUtil.e(TAG, e62.getMessage());
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e622) {
                        LogUtil.e(TAG, e622.getMessage());
                    }
                }
                throw th;
            }
        } catch (IOException e12) {
            e622 = e12;
            open = null;
            LogUtil.e(TAG, e622.getMessage());
            if (open == null) {
                return null;
            }
            try {
                open.close();
                return null;
            } catch (IOException e6222) {
                LogUtil.e(TAG, e6222.getMessage());
                return null;
            }
        } catch (JSONException e13) {
            e3 = e13;
            open = null;
            LogUtil.e(TAG, e3.getMessage());
            if (open == null) {
                return null;
            }
            try {
                open.close();
                return null;
            } catch (IOException e62222) {
                LogUtil.e(TAG, e62222.getMessage());
                return null;
            }
        } catch (Exception e14) {
            e4 = e14;
            open = null;
            LogUtil.e(TAG, e4.getMessage());
            if (open == null) {
                return null;
            }
            try {
                open.close();
                return null;
            } catch (IOException e622222) {
                LogUtil.e(TAG, e622222.getMessage());
                return null;
            }
        } catch (Throwable th3) {
            open = null;
            th = th3;
            if (open != null) {
                open.close();
            }
            throw th;
        }
    }
}
