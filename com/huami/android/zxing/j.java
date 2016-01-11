package com.huami.android.zxing;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.c.b.e;
import com.tencent.connect.common.Constants;
import com.xiaomi.e.a;
import com.xiaomi.mipush.sdk.f;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

final class j {
    private static final String a = j.class.getSimpleName();
    private static final Pattern b = Pattern.compile(f.i);

    private j() {
    }

    static Map<e, Object> a(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null || extras.isEmpty()) {
            return null;
        }
        Map<e, Object> enumMap = new EnumMap(e.class);
        for (e eVar : e.values()) {
            if (!(eVar == e.CHARACTER_SET || eVar == e.NEED_RESULT_POINT_CALLBACK || eVar == e.POSSIBLE_FORMATS)) {
                String name = eVar.name();
                if (extras.containsKey(name)) {
                    if (eVar.a().equals(Void.class)) {
                        enumMap.put(eVar, Boolean.TRUE);
                    } else {
                        Object obj = extras.get(name);
                        if (eVar.a().isInstance(obj)) {
                            enumMap.put(eVar, obj);
                        } else {
                            Log.w(a, "Ignoring hint " + eVar + " because it is not assignable from " + obj);
                        }
                    }
                }
            }
        }
        Log.i(a, "Hints from the Intent: " + enumMap);
        return enumMap;
    }

    static Map<e, ?> a(Uri uri) {
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null || encodedQuery.isEmpty()) {
            return null;
        }
        Map a = a(encodedQuery);
        Map<e, ?> enumMap = new EnumMap(e.class);
        for (e eVar : e.values()) {
            if (!(eVar == e.CHARACTER_SET || eVar == e.NEED_RESULT_POINT_CALLBACK || eVar == e.POSSIBLE_FORMATS)) {
                CharSequence charSequence = (String) a.get(eVar.name());
                if (charSequence != null) {
                    if (eVar.a().equals(Object.class)) {
                        enumMap.put(eVar, charSequence);
                    } else if (eVar.a().equals(Void.class)) {
                        enumMap.put(eVar, Boolean.TRUE);
                    } else if (eVar.a().equals(String.class)) {
                        enumMap.put(eVar, charSequence);
                    } else if (eVar.a().equals(Boolean.class)) {
                        if (charSequence.isEmpty()) {
                            enumMap.put(eVar, Boolean.TRUE);
                        } else if (Constants.VIA_RESULT_SUCCESS.equals(charSequence) || "false".equalsIgnoreCase(charSequence) || "no".equalsIgnoreCase(charSequence)) {
                            enumMap.put(eVar, Boolean.FALSE);
                        } else {
                            enumMap.put(eVar, Boolean.TRUE);
                        }
                    } else if (eVar.a().equals(int[].class)) {
                        Object obj;
                        if (!charSequence.isEmpty() && charSequence.charAt(charSequence.length() - 1) == ',') {
                            charSequence = charSequence.substring(0, charSequence.length() - 1);
                        }
                        String[] split = b.split(charSequence);
                        Object obj2 = new int[split.length];
                        int i = 0;
                        while (i < split.length) {
                            try {
                                obj2[i] = Integer.parseInt(split[i]);
                                i++;
                            } catch (NumberFormatException e) {
                                Log.w(a, "Skipping array of integers hint " + eVar + " due to invalid numeric value: '" + split[i] + '\'');
                                obj = null;
                            }
                        }
                        obj = obj2;
                        if (obj != null) {
                            enumMap.put(eVar, obj);
                        }
                    } else {
                        Log.w(a, "Unsupported hint type '" + eVar + "' of type " + eVar.a());
                    }
                }
            }
        }
        Log.i(a, "Hints from the URI: " + enumMap);
        return enumMap;
    }

    private static Map<String, String> a(String str) {
        Map<String, String> hashMap = new HashMap();
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '&') {
                i++;
            } else {
                int indexOf = str.indexOf(38, i);
                int indexOf2 = str.indexOf(61, i);
                if (indexOf < 0) {
                    Object decode;
                    Object obj;
                    if (indexOf2 < 0) {
                        decode = Uri.decode(str.substring(i).replace('+', ' '));
                        obj = a.f;
                    } else {
                        decode = Uri.decode(str.substring(i, indexOf2).replace('+', ' '));
                        obj = Uri.decode(str.substring(indexOf2 + 1).replace('+', ' '));
                    }
                    if (!hashMap.containsKey(decode)) {
                        hashMap.put(decode, obj);
                    }
                    return hashMap;
                } else if (indexOf2 < 0 || indexOf2 > indexOf) {
                    r0 = Uri.decode(str.substring(i, indexOf).replace('+', ' '));
                    if (!hashMap.containsKey(r0)) {
                        hashMap.put(r0, a.f);
                    }
                    i = indexOf + 1;
                } else {
                    r0 = Uri.decode(str.substring(i, indexOf2).replace('+', ' '));
                    String decode2 = Uri.decode(str.substring(indexOf2 + 1, indexOf).replace('+', ' '));
                    if (!hashMap.containsKey(r0)) {
                        hashMap.put(r0, decode2);
                    }
                    i = indexOf + 1;
                }
            }
        }
        return hashMap;
    }
}
