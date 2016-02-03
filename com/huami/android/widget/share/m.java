package com.huami.android.widget.share;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.honor.a.d;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.huami.android.view.b;
import com.sina.weibo.sdk.ApiUtils;
import com.sina.weibo.sdk.api.BaseMediaObject;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WeiboMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.api.share.BaseRequest;
import com.sina.weibo.sdk.api.share.BaseResponse;
import com.sina.weibo.sdk.api.share.IWeiboHandler.Response;
import com.sina.weibo.sdk.api.share.IWeiboShareAPI;
import com.sina.weibo.sdk.api.share.SendMessageToWeiboRequest;
import com.sina.weibo.sdk.api.share.SendMultiMessageToWeiboRequest;
import com.sina.weibo.sdk.api.share.WeiboShareSDK;
import com.tencent.connect.share.QzoneShare;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.open.SocialConstants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.xiaomi.channel.b.o;
import com.xiaomi.channel.b.q;
import com.xiaomi.channel.b.r;
import com.xiaomi.channel.b.s;
import com.xiaomi.channel.b.t;
import com.xiaomi.channel.b.v;
import com.xiaomi.channel.b.x;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.a.e;
import com.xiaomi.hm.health.a.h;
import com.xiaomi.hm.health.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class m implements Response, IWXAPIEventHandler {
    public static final String a = "we_chat";
    public static final String b = "weibo";
    public static final String c = "qq";
    public static final String d = "qzone";
    public static final String e = "miliao";
    public static final String f = "line";
    public static final String g = "facebook";
    public static final String h = "twitter";
    public static final String i = "com.tencent.mm";
    public static final String j = "wxe37a18fe0ec64b4c";
    public static final String k = "1103177325";
    public static final String l = "1445984418";
    public static final float m = 102400.0f;
    public static final int n = 300;
    private static final String o = "ShareManager";
    private static final String p = "com.sina.weibo";
    private static final String q = "com.qzone";
    private static final String r = "com.tencent.mobileqq";
    private static final String s = "jp.naver.line.android";
    private static final String t = "com.facebook.katana";
    private static final String u = "com.twitter.android";
    private static final String v = "com.tencent.mobileqq.activity.JumpActivity";
    private static final String w = "com.tencent.mm.ui.tools.ShareImgUI";
    private static final String x = "com.tencent.mm.ui.tools.ShareToTimeLineUI";
    private r A;
    private IWeiboShareAPI B;
    private final Activity C;
    private boolean D;
    private ShareDataManager E;
    private p F;
    private final IUiListener G;
    private final IUiListener H;
    private Tencent y;
    private IWXAPI z;

    public m(Activity activity) {
        this(activity, false);
    }

    public m(Activity activity, boolean z) {
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.D = false;
        this.G = new n(this);
        this.H = new o(this);
        if (activity == null) {
            throw new IllegalArgumentException("activity is null");
        }
        this.E = ShareDataManager.a();
        this.C = activity;
        this.D = z;
        Intent intent = activity.getIntent();
        this.z = WXAPIFactory.createWXAPI(activity, j);
        this.z.registerApp(j);
        this.z.handleIntent(intent, this);
        this.B = WeiboShareSDK.createWeiboAPI(activity, l);
        this.B.registerApp();
        this.B.handleWeiboResponse(intent, this);
        this.A = new r(activity);
        this.y = Tencent.createInstance(k, activity);
    }

    @SuppressLint({"NewApi"})
    private Bitmap a(File file) {
        if (file == null) {
            return null;
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getPath(), options);
        if (options.outWidth <= 0 || options.outHeight <= 0) {
            return null;
        }
        int i = (options.outHeight * options.outWidth) * 4;
        if (((float) i) > m) {
            options.inSampleSize = Math.round(((float) i) / m);
        }
        boolean z = options.inSampleSize > 4;
        if (z) {
            options.inSampleSize = 4;
        }
        options.inJustDecodeBounds = false;
        Bitmap decodeFile = BitmapFactory.decodeFile(file.getPath(), options);
        int i2 = n;
        int i3 = n;
        if (decodeFile.getWidth() > decodeFile.getHeight()) {
            i3 = (int) ((((float) decodeFile.getHeight()) / ((float) decodeFile.getWidth())) * BitmapDescriptorFactory.HUE_MAGENTA);
        } else {
            i2 = (int) ((((float) decodeFile.getWidth()) / ((float) decodeFile.getHeight())) * BitmapDescriptorFactory.HUE_MAGENTA);
        }
        return z ? ThumbnailUtils.extractThumbnail(decodeFile, i2, i3) : decodeFile;
    }

    private static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return a.f;
        }
        Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("fr", str2);
        return buildUpon.build().toString();
    }

    private boolean a(String str, Bitmap bitmap) {
        C0596r.d(o, "sendMultiMessage:" + str);
        ImageObject imageObject = new ImageObject();
        imageObject.setImageObject(bitmap);
        TextObject textObject = new TextObject();
        textObject.text = str;
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        weiboMultiMessage.textObject = textObject;
        weiboMultiMessage.imageObject = imageObject;
        BaseRequest sendMultiMessageToWeiboRequest = new SendMultiMessageToWeiboRequest();
        sendMultiMessageToWeiboRequest.transaction = String.valueOf(System.currentTimeMillis());
        sendMultiMessageToWeiboRequest.multiMessage = weiboMultiMessage;
        return this.B.sendRequest(this.C, sendMultiMessageToWeiboRequest);
    }

    private boolean a(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(str3)) {
            bundle.putInt(QzoneShare.SHARE_TO_QZONE_KEY_TYPE, 5);
        } else {
            bundle.putInt(QzoneShare.SHARE_TO_QZONE_KEY_TYPE, 1);
        }
        bundle.putString(SocialConstants.PARAM_TITLE, str);
        bundle.putString(SocialConstants.PARAM_SUMMARY, str2);
        bundle.putString(SocialConstants.PARAM_TARGET_URL, a(str3, c));
        bundle.putString(SocialConstants.PARAM_APPNAME, this.C.getString(h.app_name));
        bundle.putString(QzoneShare.SHARE_TO_QQ_IMAGE_LOCAL_URL, str4);
        this.y.shareToQQ(this.C, bundle, this.G);
        return true;
    }

    private boolean a(String str, String str2, String str3, String str4, boolean z) {
        int i = 0;
        if (!this.z.isWXAppInstalled()) {
            return false;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.setThumbImage(a(new File(str3)));
        IMediaObject wXImageObject;
        if (TextUtils.isEmpty(str4)) {
            wXImageObject = new WXImageObject();
            wXImageObject.imageData = a(str3);
            wXMediaMessage.mediaObject = wXImageObject;
        } else {
            wXImageObject = new WXWebpageObject();
            wXImageObject.webpageUrl = a(str4, a);
            wXMediaMessage.mediaObject = wXImageObject;
        }
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        BaseReq req = new Req();
        req.transaction = String.valueOf(System.currentTimeMillis());
        req.message = wXMediaMessage;
        if (z) {
            i = 1;
        }
        req.scene = i;
        return this.z.sendReq(req);
    }

    private byte[] a(String str) {
        InputStream fileInputStream;
        FileNotFoundException e;
        IOException e2;
        Throwable th;
        if (str == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(str);
            } catch (FileNotFoundException e3) {
                e = e3;
                fileInputStream = null;
                try {
                    e.printStackTrace();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e222) {
                            e222.printStackTrace();
                        }
                    }
                    return byteArrayOutputStream != null ? null : byteArrayOutputStream.toByteArray();
                } catch (Throwable th2) {
                    th = th2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e2222) {
                            e2222.printStackTrace();
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e22222) {
                            e22222.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e22222 = e4;
                fileInputStream = null;
                e22222.printStackTrace();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e222222) {
                        e222222.printStackTrace();
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2222222) {
                        e2222222.printStackTrace();
                    }
                }
                if (byteArrayOutputStream != null) {
                }
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[PersonInfo.INCOMING_CALL_DISABLE_BIT];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e22222222) {
                        e22222222.printStackTrace();
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e222222222) {
                        e222222222.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                e.printStackTrace();
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                }
            } catch (IOException e6) {
                e222222222 = e6;
                e222222222.printStackTrace();
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                }
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            fileInputStream = null;
            byteArrayOutputStream = null;
            e.printStackTrace();
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (byteArrayOutputStream != null) {
            }
        } catch (IOException e8) {
            e222222222 = e8;
            fileInputStream = null;
            byteArrayOutputStream = null;
            e222222222.printStackTrace();
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (byteArrayOutputStream != null) {
            }
        } catch (Throwable th32) {
            fileInputStream = null;
            byteArrayOutputStream = null;
            th = th32;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        if (byteArrayOutputStream != null) {
        }
    }

    private void b(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString(SocialConstants.PARAM_TITLE, str);
        bundle.putString(SocialConstants.PARAM_SUMMARY, str2);
        bundle.putString(SocialConstants.PARAM_APPNAME, this.C.getString(h.app_name));
        bundle.putString(SocialConstants.PARAM_TARGET_URL, a(str3, d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str4);
        bundle.putStringArrayList(SocialConstants.PARAM_IMAGE_URL, arrayList);
        this.y.shareToQzone(this.C, bundle, this.H);
    }

    private boolean b(String str, Bitmap bitmap) {
        C0596r.d(o, "sendSingleMessage:" + str);
        WeiboMessage weiboMessage = new WeiboMessage();
        BaseMediaObject imageObject = new ImageObject();
        imageObject.setImageObject(bitmap);
        BaseMediaObject textObject = new TextObject();
        textObject.text = str;
        weiboMessage.mediaObject = textObject;
        weiboMessage.mediaObject = imageObject;
        BaseRequest sendMessageToWeiboRequest = new SendMessageToWeiboRequest();
        sendMessageToWeiboRequest.transaction = String.valueOf(System.currentTimeMillis());
        sendMessageToWeiboRequest.message = weiboMessage;
        return this.B.sendRequest(this.C, sendMessageToWeiboRequest);
    }

    private boolean b(String str, String str2) {
        C0596r.d(o, "shareToWeibo:" + str + ",path:" + str2);
        try {
            if (this.B.isWeiboAppSupportAPI()) {
                Bitmap decodeFile = BitmapFactory.decodeFile(str2);
                return this.B.getWeiboAppSupportAPI() >= ApiUtils.BUILD_INT_VER_2_2 ? a(str, decodeFile) : b(str, decodeFile);
            } else {
                C0596r.d(o, "shareToWeibo isWeiboAppSupportAPI false");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            C0596r.d(o, "shareToWeibo Exception:" + e.getMessage());
        }
    }

    private List<ResolveInfo> f() {
        Intent intent = new Intent("android.intent.action.SEND", null);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setType("image/*");
        return this.C.getPackageManager().queryIntentActivities(intent, 0);
    }

    public List<u> a() {
        List<u> arrayList = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        u uVar = new u(e.share_weixin_selector, h.share_weixin_label, C0401a.cA);
        arrayList.add(uVar);
        sparseArray.put(e.share_weixin_selector, uVar);
        uVar = new u(e.share_pengyouquan_selector, h.share_pengyouquan_label, C0401a.cB);
        arrayList.add(uVar);
        sparseArray.put(e.share_pengyouquan_selector, uVar);
        Locale locale = Locale.getDefault();
        if (locale.toString().equals(Locale.SIMPLIFIED_CHINESE.toString())) {
            uVar = new u(e.share_miliao_selector, h.share_miliao_label, C0401a.cC);
            arrayList.add(uVar);
            sparseArray.put(e.share_miliao_selector, uVar);
            uVar = new u(e.share_weibo_selector, h.share_weibo_label, C0401a.cD);
            arrayList.add(uVar);
            sparseArray.put(e.share_weibo_selector, uVar);
            uVar = new u(e.share_qq_zone_selector, h.share_qq_zone_label, C0401a.cz);
            arrayList.add(uVar);
            sparseArray.put(e.share_qq_zone_selector, uVar);
            uVar = new u(e.share_qq_selector, h.share_qq_label, C0401a.cy);
            arrayList.add(uVar);
            sparseArray.put(e.share_qq_selector, uVar);
        } else if (locale.toString().equals(Locale.TRADITIONAL_CHINESE.toString())) {
            uVar = new u(e.share_miliao_selector, h.share_miliao_label, C0401a.cC);
            arrayList.add(uVar);
            sparseArray.put(e.share_miliao_selector, uVar);
            uVar = new u(e.share_weibo_selector, h.share_weibo_label, C0401a.cD);
            arrayList.add(uVar);
            sparseArray.put(e.share_weibo_selector, uVar);
            uVar = new u(e.share_line_selector, h.share_line_label, C0401a.cE);
            arrayList.add(uVar);
            sparseArray.put(e.share_line_selector, uVar);
            uVar = new u(e.share_facebook_selector, h.share_facebook_label, C0401a.cF);
            arrayList.add(uVar);
            sparseArray.put(e.share_facebook_selector, uVar);
            uVar = new u(e.share_twitter_selector, h.share_twitter_label, C0401a.cG);
            arrayList.add(uVar);
            sparseArray.put(e.share_twitter_selector, uVar);
        } else {
            uVar = new u(e.share_line_selector, h.share_line_label, C0401a.cE);
            arrayList.add(uVar);
            sparseArray.put(e.share_line_selector, uVar);
            uVar = new u(e.share_facebook_selector, h.share_facebook_label, C0401a.cF);
            arrayList.add(uVar);
            sparseArray.put(e.share_facebook_selector, uVar);
            uVar = new u(e.share_twitter_selector, h.share_twitter_label, C0401a.cG);
            arrayList.add(uVar);
            sparseArray.put(e.share_twitter_selector, uVar);
        }
        a(sparseArray);
        return arrayList;
    }

    public void a(int i) {
        b.a(this.C, this.C.getString(i), 1).show();
    }

    public void a(SparseArray<u> sparseArray) {
        u uVar = null;
        for (ResolveInfo resolveInfo : f()) {
            String str = resolveInfo.activityInfo.applicationInfo.packageName;
            C0596r.e(o, "packageName: " + str);
            String str2 = resolveInfo.activityInfo.name;
            if (p.equalsIgnoreCase(str)) {
                uVar = (u) sparseArray.get(e.share_weibo_selector);
            } else if (i.equalsIgnoreCase(str)) {
                if (x.equalsIgnoreCase(str2)) {
                    uVar = (u) sparseArray.get(e.share_pengyouquan_selector);
                } else if (w.equalsIgnoreCase(str2)) {
                    uVar = (u) sparseArray.get(e.share_weixin_selector);
                }
            } else if (q.equalsIgnoreCase(str)) {
                uVar = (u) sparseArray.get(e.share_qq_zone_selector);
            } else if (r.equalsIgnoreCase(str)) {
                if (v.equalsIgnoreCase(str2)) {
                    uVar = (u) sparseArray.get(e.share_qq_selector);
                }
            } else if (s.equalsIgnoreCase(str)) {
                uVar = (u) sparseArray.get(e.share_line_selector);
            } else if (t.equalsIgnoreCase(str)) {
                uVar = (u) sparseArray.get(e.share_facebook_selector);
            } else if (u.equalsIgnoreCase(str)) {
                uVar = (u) sparseArray.get(e.share_twitter_selector);
            }
            if (uVar != null) {
                uVar.d = resolveInfo;
                uVar.c = true;
            }
        }
        if (x.b(this.C)) {
            u uVar2 = (u) sparseArray.get(e.share_miliao_selector);
            if (uVar2 != null) {
                uVar2.c = true;
            }
        }
    }

    public void a(p pVar) {
        this.F = pVar;
    }

    public void a(u uVar, l lVar, boolean z, int i) {
        if (uVar != null) {
            String str = lVar.a;
            String str2 = lVar.c;
            String str3 = lVar.e;
            String str4 = null;
            String str5 = lVar.b;
            if (!z) {
                str4 = lVar.d;
            }
            if (uVar.a == e.share_weixin_selector) {
                if (a(str, str2, str3, str4, false)) {
                    C0596r.e(o, "share_weixin_selector");
                    if (this.F != null) {
                        this.F.b(1);
                    }
                    this.E.a(this.C, 1);
                }
            } else if (uVar.a == e.share_pengyouquan_selector) {
                if (a(str, str2, str3, str4, true)) {
                    C0596r.e(o, "share_pengyouquan_selector");
                    if (this.F != null) {
                        this.F.b(2);
                    }
                    this.E.a(this.C, 2);
                }
            } else if (uVar.a == e.share_weibo_selector) {
                if (b(str5 + str2 + a(str4, b), str3)) {
                    C0596r.e(o, "share_weibo_selector");
                    if (this.F != null) {
                        this.F.b(4);
                    }
                    this.E.a(this.C, 4);
                }
            } else if (uVar.a == e.share_qq_selector) {
                a(str, str2, str4, str3);
                if (this.F != null) {
                    this.F.b(6);
                }
                this.E.a(this.C, 6);
            } else if (uVar.a == e.share_qq_zone_selector) {
                if (z || TextUtils.isEmpty(str4)) {
                    a(uVar, str, str2, str3);
                } else {
                    b(str, str2, str4, str3);
                }
                if (this.F != null) {
                    this.F.b(5);
                }
                this.E.a(this.C, 5);
            } else if (uVar.a == e.share_miliao_selector) {
                a(i, str, str2, a(str4, e), str3);
            } else if (uVar.a == e.share_facebook_selector) {
                a(uVar, str, str5 + str2 + a(str4, g), str3);
                if (this.F != null) {
                    this.F.b(8);
                }
                this.E.a(this.C, 8);
            } else if (uVar.a == e.share_twitter_selector) {
                a(uVar, str, str5 + str2 + a(str4, h), str3);
                if (this.F != null) {
                    this.F.b(9);
                }
                this.E.a(this.C, 9);
            } else if (uVar.a == e.share_line_selector) {
                a(uVar, str, str5 + str2 + a(str4, f), str3);
                if (this.F != null) {
                    this.F.b(7);
                }
                this.E.a(this.C, 7);
            }
        }
    }

    public void a(u uVar, String str, String str2, String str3) {
        if (uVar != null) {
            ResolveInfo resolveInfo = uVar.d;
            try {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
                intent.setType("image/*");
                intent.putExtra("android.intent.extra.SUBJECT", str);
                intent.putExtra("android.intent.extra.TEXT", str2);
                intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str3)));
                intent.setFlags(268435456);
                this.C.startActivity(intent);
            } catch (Exception e) {
                C0596r.b(o, "share error");
            }
        }
    }

    public boolean a(int i, String str, String str2, String str3, String str4) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str4);
        this.A.a(this.C.getPackageName(), this.C.getString(h.app_name));
        s sVar = new s();
        sVar.d = new q(decodeFile);
        sVar.d.e = 2097152;
        sVar.c = str;
        sVar.a = str3;
        sVar.b = str2;
        o tVar = new t(v.F, sVar, i);
        if (this.F != null) {
            this.F.b(3);
        }
        this.E.a(this.C, 3);
        try {
            this.A.a(tVar, false);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<u> b() {
        List<u> arrayList = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        u uVar = new u(e.share_weixin_selector, h.share_weixin_label, C0401a.cA);
        arrayList.add(uVar);
        sparseArray.put(e.share_weixin_selector, uVar);
        if (!this.D) {
            uVar = new u(e.share_pengyouquan_selector, h.share_pengyouquan_label, C0401a.cB);
            arrayList.add(uVar);
            sparseArray.put(e.share_pengyouquan_selector, uVar);
        }
        Locale locale = Locale.getDefault();
        if (locale.toString().equals(Locale.SIMPLIFIED_CHINESE.toString())) {
            if (!this.D) {
                uVar = new u(e.share_miliao_selector, h.share_miliao_label, C0401a.cC);
                arrayList.add(uVar);
                sparseArray.put(e.share_miliao_selector, uVar);
                uVar = new u(e.share_weibo_selector, h.share_weibo_label, C0401a.cD);
                arrayList.add(uVar);
                sparseArray.put(e.share_weibo_selector, uVar);
                uVar = new u(e.share_qq_zone_selector, h.share_qq_zone_label, C0401a.cz);
                arrayList.add(uVar);
                sparseArray.put(e.share_qq_zone_selector, uVar);
            }
            uVar = new u(e.share_qq_selector, h.share_qq_label, C0401a.cy);
            arrayList.add(uVar);
            sparseArray.put(e.share_qq_selector, uVar);
        } else if (locale.toString().equals(Locale.TRADITIONAL_CHINESE.toString())) {
            if (!this.D) {
                uVar = new u(e.share_miliao_selector, h.share_miliao_label, C0401a.cC);
                arrayList.add(uVar);
                sparseArray.put(e.share_miliao_selector, uVar);
                uVar = new u(e.share_weibo_selector, h.share_weibo_label, C0401a.cD);
                arrayList.add(uVar);
                sparseArray.put(e.share_weibo_selector, uVar);
                uVar = new u(e.share_line_selector, h.share_line_label, C0401a.cE);
                arrayList.add(uVar);
                sparseArray.put(e.share_line_selector, uVar);
                uVar = new u(e.share_facebook_selector, h.share_facebook_label, C0401a.cF);
                arrayList.add(uVar);
                sparseArray.put(e.share_facebook_selector, uVar);
                uVar = new u(e.share_twitter_selector, h.share_twitter_label, C0401a.cG);
                arrayList.add(uVar);
                sparseArray.put(e.share_twitter_selector, uVar);
            }
        } else if (!this.D) {
            uVar = new u(e.share_line_selector, h.share_line_label, C0401a.cE);
            arrayList.add(uVar);
            sparseArray.put(e.share_line_selector, uVar);
            uVar = new u(e.share_facebook_selector, h.share_facebook_label, C0401a.cF);
            arrayList.add(uVar);
            sparseArray.put(e.share_facebook_selector, uVar);
            uVar = new u(e.share_twitter_selector, h.share_twitter_label, C0401a.cG);
            arrayList.add(uVar);
            sparseArray.put(e.share_twitter_selector, uVar);
        }
        a(sparseArray);
        return arrayList;
    }

    public boolean c() {
        int a = x.a(this.C);
        if (a == com.xiaomi.channel.gamesdk.a.a) {
            a(h.share_uninstall_client);
            return false;
        } else if (a != com.xiaomi.channel.gamesdk.a.b) {
            return true;
        } else {
            a(h.share_miliao_too_old);
            return false;
        }
    }

    public void d() {
        if (this.C != null) {
            Intent intent = new Intent();
            intent.putExtra("moudle", d.e);
            intent.putExtra("shares", d.e);
            this.C.sendBroadcast(intent, c.b);
            return;
        }
        C0596r.e(o, "shareSuccessNofity context is null");
    }

    public p e() {
        return this.F;
    }

    public void onReq(BaseReq baseReq) {
    }

    public void onResp(BaseResp baseResp) {
    }

    public void onResponse(BaseResponse baseResponse) {
        C0596r.b(o, baseResponse.errMsg + "|" + baseResponse.errCode);
    }
}
