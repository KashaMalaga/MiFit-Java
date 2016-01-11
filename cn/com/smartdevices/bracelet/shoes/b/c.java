package cn.com.smartdevices.bracelet.shoes.b;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.relation.db.Friend;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.dataprocess.UserInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class c {
    private static final String a = "KeeperReflection";

    public static UserInfo a() {
        try {
            Method method = Class.forName("cn.com.smartdevices.bracelet.Keeper").getMethod("readPersonInfoBase", new Class[0]);
            if (method == null) {
                return null;
            }
            Object invoke = method.invoke(null, new Object[0]);
            if (invoke == null) {
                return null;
            }
            Class cls = Class.forName("cn.com.smartdevices.bracelet.model.PersonInfo");
            if (cls == null) {
                return null;
            }
            UserInfo userInfo = new UserInfo();
            Field declaredField = cls.getDeclaredField(f.C);
            if (declaredField != null) {
                userInfo.height = declaredField.getInt(invoke);
            }
            declaredField = cls.getDeclaredField(Friend.d);
            if (declaredField != null) {
                userInfo.weight = declaredField.getFloat(invoke);
            }
            Field declaredField2 = cls.getDeclaredField(f.B);
            if (declaredField != null) {
                userInfo.gender = declaredField2.getInt(invoke);
            }
            Method declaredMethod = cls.getDeclaredMethod("getDaySportGoalSteps", new Class[0]);
            if (declaredMethod != null) {
                userInfo.goal = ((Integer) declaredMethod.invoke(invoke, new Object[0])).intValue();
            } else {
                C0596r.d(a, "Failed to get goal");
            }
            return userInfo;
        } catch (Exception e) {
            C0596r.d(a, e.getMessage());
            return null;
        }
    }

    public static void a(Context context) {
        try {
            try {
                Method method = Class.forName("cn.com.smartdevices.bracelet.Utils").getMethod("handleUUID", new Class[]{Context.class});
                if (method == null) {
                    throw new IllegalArgumentException("cn.com.smartdevices.bracelet.Utils handleUUID is gone");
                }
                method.invoke(null, new Object[]{context});
            } catch (Exception e) {
                C0596r.a(a, e.getMessage());
            }
        } catch (ClassNotFoundException e2) {
            throw new IllegalArgumentException("cn.com.smartdevices.bracelet.Utils is gone");
        }
    }

    public static float b() {
        try {
            Method method = Class.forName("cn.com.smartdevices.bracelet.Keeper").getMethod("readPersonInfoBase", new Class[0]);
            if (method == null) {
                return 0.0f;
            }
            Object invoke = method.invoke(null, new Object[0]);
            if (invoke == null) {
                return 0.0f;
            }
            Class cls = Class.forName("cn.com.smartdevices.bracelet.model.PersonInfo");
            if (cls == null) {
                return 0.0f;
            }
            Field declaredField = cls.getDeclaredField(f.C);
            return declaredField != null ? (float) declaredField.getInt(invoke) : 0.0f;
        } catch (Exception e) {
            C0596r.d(a, e.getMessage());
            return 0.0f;
        }
    }

    public static String b(Context context) {
        Object h = h();
        if (!TextUtils.isEmpty(h)) {
            return h;
        }
        if (context == null) {
            return a.f;
        }
        a(context);
        return h();
    }

    public static int c() {
        try {
            return Class.forName("cn.com.smartdevices.bracelet.Constant").getDeclaredField("UNIT_BRITISH").getInt(null);
        } catch (Exception e) {
            C0596r.d(a, e.getMessage());
            return 0;
        }
    }

    public static int d() {
        try {
            return Class.forName("cn.com.smartdevices.bracelet.Constant").getDeclaredField("LENGTH_UNIT_METRIC").getInt(null);
        } catch (Exception e) {
            C0596r.d(a, e.getMessage());
            return 0;
        }
    }

    public static int e() {
        try {
            Method method = Class.forName("cn.com.smartdevices.bracelet.Keeper").getMethod("readPersonInfoBase", new Class[0]);
            if (method == null) {
                return 0;
            }
            Object invoke = method.invoke(null, new Object[0]);
            if (invoke == null) {
                return 0;
            }
            Class cls = Class.forName("cn.com.smartdevices.bracelet.model.PersonInfo");
            if (cls == null) {
                return 0;
            }
            Method declaredMethod = cls.getDeclaredMethod("getDaySportGoalSteps", new Class[0]);
            if (declaredMethod != null) {
                return ((Integer) declaredMethod.invoke(invoke, new Object[0])).intValue();
            }
            C0596r.d(a, "Failed to get goal");
            return 0;
        } catch (Exception e) {
            C0596r.d(a, e.getMessage());
            return 0;
        }
    }

    public static float f() {
        float f = 0.0f;
        try {
            Method method = Class.forName("cn.com.smartdevices.bracelet.Keeper").getMethod("readPersonInfoBase", new Class[0]);
            if (method != null) {
                Object invoke = method.invoke(null, new Object[0]);
                if (invoke != null) {
                    Class cls = Class.forName("cn.com.smartdevices.bracelet.model.PersonInfo");
                    if (cls != null) {
                        Field declaredField = cls.getDeclaredField(Friend.d);
                        if (declaredField != null) {
                            f = declaredField.getFloat(invoke);
                        }
                    }
                }
            }
        } catch (Exception e) {
            C0596r.d(a, e.getMessage());
        }
        return f;
    }

    public static int g() {
        int i = -1;
        try {
            Object j = j();
            if (j != null) {
                Class cls = Class.forName("cn.com.smartdevices.bracelet.model.PersonInfo");
                if (cls != null) {
                    Field declaredField = cls.getDeclaredField("miliConfig");
                    if (declaredField != null) {
                        i = Class.forName("cn.com.smartdevices.bracelet.model.MiliConfig").getDeclaredField("unit").getInt(declaredField.get(j));
                    }
                }
            }
        } catch (Exception e) {
            C0596r.d(a, e.getMessage());
        }
        return i;
    }

    public static String h() {
        try {
            try {
                Method method = Class.forName("cn.com.smartdevices.bracelet.Keeper").getMethod("readUUID", new Class[0]);
                if (method == null) {
                    throw new IllegalArgumentException("cn.com.smartdevices.bracelet.Keeper readUUID is gone");
                }
                Object invoke = method.invoke(null, new Object[0]);
                return invoke != null ? (String) invoke : null;
            } catch (Exception e) {
                C0596r.d(a, e.getMessage());
                throw new IllegalArgumentException("cn.com.smartdevices.bracelet.Keeper readUUID failed to invoke");
            }
        } catch (ClassNotFoundException e2) {
            throw new IllegalArgumentException("cn.com.smartdevices.bracelet.Keeper is gone");
        }
    }

    public static int i() {
        int i = -1;
        try {
            Object j = j();
            if (j != null) {
                Class cls = Class.forName("cn.com.smartdevices.bracelet.model.PersonInfo");
                if (cls != null) {
                    Field declaredField = cls.getDeclaredField("miliConfig");
                    if (declaredField != null) {
                        i = Class.forName("cn.com.smartdevices.bracelet.model.MiliConfig").getDeclaredField("weightUnit").getInt(declaredField.get(j));
                    }
                }
            }
        } catch (Exception e) {
            C0596r.d(a, e.getMessage());
        }
        return i;
    }

    private static Object j() {
        try {
            Method method = Class.forName("cn.com.smartdevices.bracelet.Keeper").getMethod("readPersonInfoBase", new Class[0]);
            return method == null ? Float.valueOf(0.0f) : method.invoke(null, new Object[0]);
        } catch (ClassNotFoundException e) {
            C0596r.d(a, e.getMessage());
            return null;
        }
    }
}
