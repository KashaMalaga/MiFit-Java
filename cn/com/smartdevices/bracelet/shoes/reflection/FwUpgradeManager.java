package cn.com.smartdevices.bracelet.shoes.reflection;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FwUpgradeManager {
    private static final String TAG = "FwUpgradeManagerReflection";
    public static final int UPGRADE_FOR_MILI = 0;
    public static final int UPGRADE_FOR_SHOES = 2;
    public static final int UPGRADE_FOR_WEIGHT = 1;
    private static Class<?> mFwUpgradeManangerClazz;

    static {
        mFwUpgradeManangerClazz = null;
        try {
            mFwUpgradeManangerClazz = Class.forName("cn.com.smartdevices.bracelet.upgrade.FwUpgradeManager");
        } catch (ClassNotFoundException e) {
            C0596r.a(TAG, e.getMessage());
        }
    }

    public static void checkFwUpgrade(Context context, int i, a aVar) {
        checkFwUpgrade(getDefault(context), i, aVar);
    }

    public static void checkFwUpgrade(Object obj, int i, a aVar) {
        Boolean valueOf = Boolean.valueOf(false);
        if (i == 0) {
            try {
                valueOf = (Boolean) mFwUpgradeManangerClazz.getMethod("checkMiliFwUpgrade", new Class[UPGRADE_FOR_MILI]).invoke(obj, new Object[UPGRADE_FOR_MILI]);
            } catch (Exception e) {
                C0596r.a(TAG, e.getMessage());
            }
        }
        if (i == UPGRADE_FOR_WEIGHT) {
            valueOf = (Boolean) mFwUpgradeManangerClazz.getMethod("checkWeightFwUpgrade", new Class[UPGRADE_FOR_MILI]).invoke(obj, new Object[UPGRADE_FOR_MILI]);
        }
        valueOf = i == UPGRADE_FOR_SHOES ? (Boolean) mFwUpgradeManangerClazz.getMethod("checkShoesFwUpgrade", new Class[UPGRADE_FOR_MILI]).invoke(obj, new Object[UPGRADE_FOR_MILI]) : valueOf;
        if (aVar != null) {
            aVar.a(valueOf.booleanValue());
        }
    }

    public static void forceUpdateShoes(Object obj) {
        try {
            Field field = mFwUpgradeManangerClazz.getField("FORCE_UPDATE_SHOES_FW");
            field.setAccessible(true);
            field.set(null, obj);
        } catch (Exception e) {
            C0596r.a(TAG, e.getMessage());
        }
    }

    public static Object getDefault(Context context) {
        Object obj = null;
        try {
            Class[] clsArr = new Class[UPGRADE_FOR_WEIGHT];
            clsArr[UPGRADE_FOR_MILI] = Context.class;
            Method method = mFwUpgradeManangerClazz.getMethod("getDefault", clsArr);
            Object[] objArr = new Object[UPGRADE_FOR_WEIGHT];
            objArr[UPGRADE_FOR_MILI] = context;
            obj = method.invoke(null, objArr);
        } catch (Exception e) {
            C0596r.a(TAG, e.getMessage());
        }
        return obj;
    }

    public static boolean isOldShoesVersion(Context context) {
        Boolean bool;
        try {
            bool = (Boolean) mFwUpgradeManangerClazz.getMethod("isOldShoesVersion", new Class[UPGRADE_FOR_MILI]).invoke(getDefault(context), new Object[UPGRADE_FOR_MILI]);
        } catch (Exception e) {
            C0596r.a(TAG, e.getMessage());
            bool = null;
        }
        return bool == null ? false : bool.booleanValue();
    }

    public static void setUpgradeState(Context context, boolean z) {
        try {
            Object obj = getDefault(context);
            Class[] clsArr = new Class[UPGRADE_FOR_WEIGHT];
            clsArr[UPGRADE_FOR_MILI] = Boolean.TYPE;
            Method method = mFwUpgradeManangerClazz.getMethod("setUpgradeState", clsArr);
            Object[] objArr = new Object[UPGRADE_FOR_WEIGHT];
            objArr[UPGRADE_FOR_MILI] = Boolean.valueOf(z);
            method.invoke(obj, objArr);
        } catch (Exception e) {
            C0596r.a(TAG, e.getMessage());
        }
    }

    public static boolean shoesFwUpgradeReslut(Context context) {
        try {
            return !((Boolean) mFwUpgradeManangerClazz.getMethod("checkShoesFwUpgrade", new Class[UPGRADE_FOR_MILI]).invoke(getDefault(context), new Object[UPGRADE_FOR_MILI])).booleanValue();
        } catch (Exception e) {
            C0596r.a(TAG, e.getMessage());
            return true;
        }
    }

    public static void upgrade(Context context, int i, boolean z) {
        try {
            Object obj = getDefault(context);
            Class[] clsArr = new Class[UPGRADE_FOR_SHOES];
            clsArr[UPGRADE_FOR_MILI] = Integer.TYPE;
            clsArr[UPGRADE_FOR_WEIGHT] = Boolean.TYPE;
            Method method = mFwUpgradeManangerClazz.getMethod("upgrade", clsArr);
            Object[] objArr = new Object[UPGRADE_FOR_SHOES];
            objArr[UPGRADE_FOR_MILI] = Integer.valueOf(i);
            objArr[UPGRADE_FOR_WEIGHT] = Boolean.valueOf(z);
            method.invoke(obj, objArr);
        } catch (Exception e) {
            C0596r.a(TAG, e.getMessage());
        }
    }
}
