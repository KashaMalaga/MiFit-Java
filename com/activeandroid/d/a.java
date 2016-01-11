package com.activeandroid.d;

import android.database.Cursor;
import java.io.Closeable;

public class a {
    public static void a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable e) {
                b.e("Couldn't close cursor.", e);
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                b.e("Couldn't close closeable.", e);
            }
        }
    }
}
