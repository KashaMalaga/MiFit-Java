package com.c.a.b;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class C0971b {
    static final Type[] a = new Type[0];

    private C0971b() {
    }

    private static int a(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    private static Class<?> a(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        return genericDeclaration instanceof Class ? (Class) genericDeclaration : null;
    }

    public static GenericArrayType a(Type type) {
        return new C0972c(type);
    }

    public static ParameterizedType a(Type type, Type type2, Type... typeArr) {
        return new C0973d(type, type2, typeArr);
    }

    public static Type a(Type type, Class<?> cls) {
        Type b = C0971b.b(type, cls, Collection.class);
        if (b instanceof WildcardType) {
            b = ((WildcardType) b).getUpperBounds()[0];
        }
        return b instanceof ParameterizedType ? ((ParameterizedType) b).getActualTypeArguments()[0] : Object.class;
    }

    static Type a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i] == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(interfaces[i])) {
                    return C0971b.a(cls.getGenericInterfaces()[i], interfaces[i], (Class) cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            Class cls3;
            while (cls3 != Object.class) {
                Class superclass = cls3.getSuperclass();
                if (superclass == cls2) {
                    return cls3.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return C0971b.a(cls3.getGenericSuperclass(), superclass, (Class) cls2);
                }
                cls3 = superclass;
            }
        }
        return cls2;
    }

    public static Type a(Type type, Class<?> cls, Type type2) {
        Type type3 = type2;
        while (type3 instanceof TypeVariable) {
            type3 = (TypeVariable) type3;
            type2 = C0971b.a(type, (Class) cls, (TypeVariable) type3);
            if (type2 == type3) {
                return type2;
            }
            type3 = type2;
        }
        Type componentType;
        Type a;
        if ((type3 instanceof Class) && ((Class) type3).isArray()) {
            Class cls2 = (Class) type3;
            componentType = cls2.getComponentType();
            a = C0971b.a(type, (Class) cls, componentType);
            return componentType != a ? C0971b.a(a) : cls2;
        } else if (type3 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type3;
            componentType = genericArrayType.getGenericComponentType();
            a = C0971b.a(type, (Class) cls, componentType);
            return componentType != a ? C0971b.a(a) : genericArrayType;
        } else if (type3 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type3;
            componentType = parameterizedType.getOwnerType();
            Type a2 = C0971b.a(type, (Class) cls, componentType);
            int i = a2 != componentType ? 1 : 0;
            r4 = parameterizedType.getActualTypeArguments();
            int length = r4.length;
            int i2 = i;
            r1 = r4;
            for (int i3 = 0; i3 < length; i3++) {
                Type a3 = C0971b.a(type, (Class) cls, r1[i3]);
                if (a3 != r1[i3]) {
                    if (i2 == 0) {
                        r1 = (Type[]) r1.clone();
                        i2 = 1;
                    }
                    r1[i3] = a3;
                }
            }
            return i2 != 0 ? C0971b.a(a2, parameterizedType.getRawType(), r1) : parameterizedType;
        } else if (!(type3 instanceof WildcardType)) {
            return type3;
        } else {
            WildcardType wildcardType = (WildcardType) type3;
            r1 = wildcardType.getLowerBounds();
            r4 = wildcardType.getUpperBounds();
            if (r1.length == 1) {
                a = C0971b.a(type, (Class) cls, r1[0]);
                return a != r1[0] ? C0971b.c(a) : wildcardType;
            } else if (r4.length != 1) {
                return wildcardType;
            } else {
                componentType = C0971b.a(type, (Class) cls, r4[0]);
                return componentType != r4[0] ? C0971b.b(componentType) : wildcardType;
            }
        }
    }

    static Type a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class a = C0971b.a((TypeVariable) typeVariable);
        if (a == null) {
            return typeVariable;
        }
        Type a2 = C0971b.a(type, (Class) cls, a);
        if (!(a2 instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) a2).getActualTypeArguments()[C0971b.a(a.getTypeParameters(), (Object) typeVariable)];
    }

    static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean a(Type type, Type type2) {
        boolean z = true;
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            if (!(C0971b.a(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments()))) {
                z = false;
            }
            return z;
        } else if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            return C0971b.a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
        } else if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            if (!(Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds()))) {
                z = false;
            }
            return z;
        } else if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        } else {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            if (!(typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName()))) {
                z = false;
            }
            return z;
        }
    }

    private static int b(Object obj) {
        return obj != null ? obj.hashCode() : 0;
    }

    static Type b(Type type, Class<?> cls, Class<?> cls2) {
        C0970a.a(cls2.isAssignableFrom(cls));
        return C0971b.a(type, (Class) cls, C0971b.a(type, (Class) cls, (Class) cls2));
    }

    public static WildcardType b(Type type) {
        return new C0974e(new Type[]{type}, a);
    }

    public static Type[] b(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type b = C0971b.b(type, cls, Map.class);
        if (b instanceof ParameterizedType) {
            return ((ParameterizedType) b).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    public static WildcardType c(Type type) {
        return new C0974e(new Type[]{Object.class}, new Type[]{type});
    }

    public static Type d(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new C0972c(C0971b.d(cls.getComponentType())) : cls;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new C0973d(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            return new C0972c(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            return new C0974e(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
    }

    public static Class<?> e(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            C0970a.a(rawType instanceof Class);
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(C0971b.e(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return C0971b.e(((WildcardType) type).getUpperBounds()[0]);
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
        }
    }

    public static String f(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static Type g(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    private static void i(Type type) {
        boolean z = ((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true;
        C0970a.a(z);
    }
}
