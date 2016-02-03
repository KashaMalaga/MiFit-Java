package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.gps.model.RunningReminderInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import kankan.wheel.widget.a;

public class ResourceManager {
    private static final String DRAWABLE = "drawable";
    private static final String DRAWABLE_HDPI = "drawable-hdpi";
    private static final String DRAWABLE_LDPI = "drawable-ldpi";
    private static final String DRAWABLE_MDPI = "drawable-mdpi";
    private static final String DRAWABLE_XHDPI = "drawable-xhdpi";
    private static final String DRAWABLE_XXHDPI = "drawable-xxhdpi";
    private static final String[] PRE_INSTALL_DRAWBLE_PATHS = new String[]{DRAWABLE_XXHDPI, DRAWABLE_XHDPI, DRAWABLE_HDPI, DRAWABLE_MDPI, DRAWABLE_LDPI, DRAWABLE};
    private static final String TAG = ResourceManager.class.getName();

    public static ColorStateList createColorStateList(int i, int i2) {
        int[] iArr = new int[]{i2, i2, i2, i};
        int[][] iArr2 = new int[4][];
        iArr2[0] = new int[]{16842919};
        iArr2[1] = new int[]{16842913};
        iArr2[2] = new int[]{16842908};
        iArr2[3] = StateSet.WILD_CARD;
        return new ColorStateList(iArr2, iArr);
    }

    public static StateListDrawable createStateListDrawable(Context context, String str, String str2) {
        Drawable ninePatchDrawable = str.indexOf(".9") > -1 ? getNinePatchDrawable(context, str) : getDrawable(context, str);
        Drawable ninePatchDrawable2 = str2.indexOf(".9") > -1 ? getNinePatchDrawable(context, str2) : getDrawable(context, str2);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, ninePatchDrawable2);
        stateListDrawable.addState(new int[]{16842913}, ninePatchDrawable2);
        stateListDrawable.addState(new int[]{16842908}, ninePatchDrawable2);
        stateListDrawable.addState(StateSet.WILD_CARD, ninePatchDrawable);
        return stateListDrawable;
    }

    public static int dp2px(Context context, int i) {
        return (int) (((double) (context.getResources().getDisplayMetrics().density * ((float) i))) + 0.5d);
    }

    private static Drawable extractDrawable(Context context, String str) {
        InputStream open = context.getAssets().open(str);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TypedValue typedValue = new TypedValue();
        typedValue.density = displayMetrics.densityDpi;
        Drawable createFromResourceStream = Drawable.createFromResourceStream(context.getResources(), typedValue, open, str);
        open.close();
        return createFromResourceStream;
    }

    private static View extractView(Context context, String str, ViewGroup viewGroup) {
        return ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(context.getAssets().openXmlResourceParser(str), viewGroup);
    }

    private static String getAppropriatePathOfDrawable(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            LogUtil.e(TAG, "id is NOT correct!");
            return null;
        }
        String currentDpiFolder = getCurrentDpiFolder(context);
        LogUtil.d(TAG, "find Appropriate path...");
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        while (i < PRE_INSTALL_DRAWBLE_PATHS.length) {
            if (PRE_INSTALL_DRAWBLE_PATHS[i].equals(currentDpiFolder)) {
                i2 = i;
            }
            String stringBuilder = new StringBuilder(String.valueOf(PRE_INSTALL_DRAWBLE_PATHS[i])).append("/").append(str).toString();
            if (isFileExisted(context, stringBuilder)) {
                if (i2 != i) {
                    if (i2 >= 0) {
                        break;
                    }
                    i3 = i;
                } else {
                    return stringBuilder;
                }
            }
            i++;
        }
        i = -1;
        if (i3 <= 0 || i <= 0) {
            if (i3 <= 0 || i >= 0) {
                if (i3 >= 0 || i <= 0) {
                    LogUtil.e(TAG, "Not find the appropriate path for drawable");
                    i3 = -1;
                } else {
                    i3 = i;
                }
            }
        } else if (Math.abs(i2 - i) <= Math.abs(i2 - i3)) {
            i3 = i;
        }
        if (i3 >= 0) {
            return new StringBuilder(String.valueOf(PRE_INSTALL_DRAWBLE_PATHS[i3])).append("/").append(str).toString();
        }
        LogUtil.e(TAG, "Not find the appropriate path for drawable");
        return null;
    }

    private static String getCurrentDpiFolder(Context context) {
        int i = context.getResources().getDisplayMetrics().densityDpi;
        return i <= 120 ? DRAWABLE_LDPI : (i <= 120 || i > 160) ? (i <= 160 || i > RunningReminderInfo.b) ? (i <= RunningReminderInfo.b || i > a.by) ? DRAWABLE_XXHDPI : DRAWABLE_XHDPI : DRAWABLE_HDPI : DRAWABLE_MDPI;
    }

    public static Drawable getDrawable(Context context, String str) {
        return getDrawableFromAssert(context, getAppropriatePathOfDrawable(context, str), false);
    }

    private static Drawable getDrawableFromAssert(Context context, String str, boolean z) {
        InputStream open;
        Drawable ninePatchDrawable;
        IOException e;
        InputStream inputStream;
        Throwable th;
        try {
            open = context.getAssets().open(str);
            if (open != null) {
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(open);
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    if (z) {
                        ninePatchDrawable = new NinePatchDrawable(new Resources(context.getAssets(), displayMetrics, context.getResources().getConfiguration()), decodeStream, decodeStream.getNinePatchChunk(), new Rect(0, 0, 0, 0), null);
                    } else {
                        decodeStream.setDensity(displayMetrics.densityDpi);
                        ninePatchDrawable = new BitmapDrawable(context.getResources(), decodeStream);
                    }
                } catch (IOException e2) {
                    e = e2;
                    inputStream = open;
                    try {
                        e.printStackTrace();
                        if (inputStream != null) {
                            return null;
                        }
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        open = inputStream;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (open != null) {
                        open.close();
                    }
                    throw th;
                }
            }
            ninePatchDrawable = null;
            if (open == null) {
                return ninePatchDrawable;
            }
            try {
                open.close();
                return ninePatchDrawable;
            } catch (IOException e42) {
                e42.printStackTrace();
                return ninePatchDrawable;
            }
        } catch (IOException e5) {
            e3 = e5;
            inputStream = null;
            e3.printStackTrace();
            if (inputStream != null) {
                return null;
            }
            inputStream.close();
            return null;
        } catch (Throwable th4) {
            th = th4;
            open = null;
            if (open != null) {
                open.close();
            }
            throw th;
        }
    }

    public static Locale getLanguage() {
        Locale locale = Locale.getDefault();
        return (Locale.SIMPLIFIED_CHINESE.equals(locale) || Locale.TRADITIONAL_CHINESE.equals(locale)) ? locale : Locale.ENGLISH;
    }

    public static Drawable getNinePatchDrawable(Context context, String str) {
        return getDrawableFromAssert(context, getAppropriatePathOfDrawable(context, str), true);
    }

    public static String getString(Context context, String str, String str2, String str3) {
        Locale language = getLanguage();
        return Locale.SIMPLIFIED_CHINESE.equals(language) ? str2 : Locale.TRADITIONAL_CHINESE.equals(language) ? str3 : str;
    }

    private static boolean isFileExisted(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            LogUtil.d(TAG, "file [" + str + "] existed");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return true;
        } catch (IOException e2) {
            LogUtil.d(TAG, "file [" + str + "] NOT existed");
            if (inputStream == null) {
                return false;
            }
            try {
                inputStream.close();
                return false;
            } catch (IOException e3) {
                e3.printStackTrace();
                return false;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e32) {
                    e32.printStackTrace();
                }
            }
        }
    }
}
