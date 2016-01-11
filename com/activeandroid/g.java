package com.activeandroid;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.activeandroid.b.a;
import com.activeandroid.b.e;
import com.activeandroid.content.ContentProvider;
import com.activeandroid.d.b;
import com.activeandroid.d.d;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class g {
    private static final int HASH_PRIME = 739;
    private final String idName = this.mTableInfo.c();
    private Long mId = null;
    private final j mTableInfo = b.a(getClass());

    public static void delete(Class<? extends g> cls, long j) {
        j a = b.a((Class) cls);
        new a().a(cls).a(a.c() + "=?", Long.valueOf(j)).d();
    }

    public static <T extends g> T load(Class<T> cls, long j) {
        j a = b.a((Class) cls);
        return new e().a(cls).a(a.c() + "=?", Long.valueOf(j)).e();
    }

    public final void delete() {
        b.d().delete(this.mTableInfo.b(), this.idName + "=?", new String[]{getId().toString()});
        b.c(this);
        b.f().getContentResolver().notifyChange(ContentProvider.a(this.mTableInfo.a(), this.mId), null);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g) || this.mId == null) {
            return this == obj;
        } else {
            g gVar = (g) obj;
            return this.mId.equals(gVar.mId) && this.mTableInfo.b().equals(gVar.mTableInfo.b());
        }
    }

    public final Long getId() {
        return this.mId;
    }

    protected final <T extends g> List<T> getMany(Class<T> cls, String str) {
        return new e().a(cls).a(b.c((Class) cls) + "." + str + "=?", getId()).d();
    }

    public int hashCode() {
        return (((this.mId == null ? super.hashCode() : this.mId.hashCode()) * HASH_PRIME) + HASH_PRIME) + (this.mTableInfo.b().hashCode() * HASH_PRIME);
    }

    public final void loadFromCursor(Cursor cursor) {
        List arrayList = new ArrayList(Arrays.asList(cursor.getColumnNames()));
        for (Field field : this.mTableInfo.d()) {
            String a = this.mTableInfo.a(field);
            Class type = field.getType();
            int indexOf = arrayList.indexOf(a);
            if (indexOf >= 0) {
                field.setAccessible(true);
                try {
                    Field field2;
                    Object obj;
                    boolean isNull = cursor.isNull(indexOf);
                    com.activeandroid.c.e b = b.b(type);
                    if (b != null) {
                        type = b.b();
                    }
                    if (isNull) {
                        field2 = null;
                        obj = null;
                    } else if (type.equals(Byte.class) || type.equals(Byte.TYPE)) {
                        field2 = field;
                        r0 = Integer.valueOf(cursor.getInt(indexOf));
                    } else if (type.equals(Short.class) || type.equals(Short.TYPE)) {
                        field2 = field;
                        r0 = Integer.valueOf(cursor.getInt(indexOf));
                    } else if (type.equals(Integer.class) || type.equals(Integer.TYPE)) {
                        field2 = field;
                        r0 = Integer.valueOf(cursor.getInt(indexOf));
                    } else if (type.equals(Long.class) || type.equals(Long.TYPE)) {
                        field2 = field;
                        Long valueOf = Long.valueOf(cursor.getLong(indexOf));
                    } else if (type.equals(Float.class) || type.equals(Float.TYPE)) {
                        field2 = field;
                        Float valueOf2 = Float.valueOf(cursor.getFloat(indexOf));
                    } else if (type.equals(Double.class) || type.equals(Double.TYPE)) {
                        field2 = field;
                        Double valueOf3 = Double.valueOf(cursor.getDouble(indexOf));
                    } else if (type.equals(Boolean.class) || type.equals(Boolean.TYPE)) {
                        field2 = field;
                        Boolean valueOf4 = Boolean.valueOf(cursor.getInt(indexOf) != 0);
                    } else if (type.equals(Character.class) || type.equals(Character.TYPE)) {
                        field2 = field;
                        Character valueOf5 = Character.valueOf(cursor.getString(indexOf).charAt(0));
                    } else if (type.equals(String.class)) {
                        field2 = field;
                        String string = cursor.getString(indexOf);
                    } else if (type.equals(Byte[].class) || type.equals(byte[].class)) {
                        field2 = field;
                        obj = cursor.getBlob(indexOf);
                    } else if (d.a(type)) {
                        g a2 = b.a(type, cursor.getLong(indexOf));
                        if (a2 == null) {
                            a2 = new e().a(type).a(this.idName + "=?", Long.valueOf(r8)).e();
                        }
                        g gVar = a2;
                        field2 = field;
                        g gVar2 = gVar;
                    } else if (d.a(type, Enum.class)) {
                        field2 = field;
                        Enum valueOf6 = Enum.valueOf(type, cursor.getString(indexOf));
                    } else {
                        field2 = field;
                        obj = null;
                    }
                    if (!(b == null || isNull)) {
                        obj = b.c(obj);
                    }
                    if (obj != null) {
                        field2.set(this, obj);
                    }
                } catch (Throwable e) {
                    b.e(e.getClass().getName(), e);
                } catch (Throwable e2) {
                    b.e(e2.getClass().getName(), e2);
                } catch (Throwable e22) {
                    b.e(e22.getClass().getName(), e22);
                }
            }
        }
        if (this.mId != null) {
            b.b(this);
        }
    }

    public final Long save() {
        SQLiteDatabase d = b.d();
        ContentValues contentValues = new ContentValues();
        for (Field field : this.mTableInfo.d()) {
            String a = this.mTableInfo.a(field);
            Class type = field.getType();
            field.setAccessible(true);
            try {
                Object obj = field.get(this);
                if (obj != null) {
                    com.activeandroid.c.e b = b.b(type);
                    if (b != null) {
                        obj = b.d(obj);
                        if (obj != null) {
                            type = obj.getClass();
                            if (!type.equals(b.b())) {
                                b.d(String.format("TypeSerializer returned wrong type: expected a %s but got a %s", new Object[]{b.b(), type}));
                            }
                        }
                    }
                }
                if (obj == null) {
                    contentValues.putNull(a);
                } else if (type.equals(Byte.class) || type.equals(Byte.TYPE)) {
                    contentValues.put(a, (Byte) obj);
                } else if (type.equals(Short.class) || type.equals(Short.TYPE)) {
                    contentValues.put(a, (Short) obj);
                } else if (type.equals(Integer.class) || type.equals(Integer.TYPE)) {
                    contentValues.put(a, (Integer) obj);
                } else if (type.equals(Long.class) || type.equals(Long.TYPE)) {
                    contentValues.put(a, (Long) obj);
                } else if (type.equals(Float.class) || type.equals(Float.TYPE)) {
                    contentValues.put(a, (Float) obj);
                } else if (type.equals(Double.class) || type.equals(Double.TYPE)) {
                    contentValues.put(a, (Double) obj);
                } else if (type.equals(Boolean.class) || type.equals(Boolean.TYPE)) {
                    contentValues.put(a, (Boolean) obj);
                } else if (type.equals(Character.class) || type.equals(Character.TYPE)) {
                    contentValues.put(a, obj.toString());
                } else if (type.equals(String.class)) {
                    contentValues.put(a, obj.toString());
                } else if (type.equals(Byte[].class) || type.equals(byte[].class)) {
                    contentValues.put(a, (byte[]) obj);
                } else if (d.a(type)) {
                    contentValues.put(a, ((g) obj).getId());
                } else if (d.a(type, Enum.class)) {
                    contentValues.put(a, ((Enum) obj).name());
                }
            } catch (Throwable e) {
                b.e(e.getClass().getName(), e);
            } catch (Throwable e2) {
                b.e(e2.getClass().getName(), e2);
            }
        }
        if (this.mId == null) {
            this.mId = Long.valueOf(d.insert(this.mTableInfo.b(), null, contentValues));
        } else {
            d.update(this.mTableInfo.b(), contentValues, this.idName + "=" + this.mId, null);
        }
        b.f().getContentResolver().notifyChange(ContentProvider.a(this.mTableInfo.a(), this.mId), null);
        return this.mId;
    }

    public String toString() {
        return this.mTableInfo.b() + "@" + getId();
    }
}
