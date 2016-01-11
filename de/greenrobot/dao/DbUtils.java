package de.greenrobot.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import com.d.a.a.h;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class DbUtils {
    public static int copyAllBytes(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[ChartData.d];
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i;
            }
            outputStream.write(bArr, 0, read);
            i += read;
        }
    }

    public static int executeSqlScript(Context context, SQLiteDatabase sQLiteDatabase, String str) {
        return executeSqlScript(context, sQLiteDatabase, str, true);
    }

    public static int executeSqlScript(Context context, SQLiteDatabase sQLiteDatabase, String str, boolean z) {
        String[] split = new String(readAsset(context, str), h.DEFAULT_CHARSET).split(";(\\s)*[\n\r]");
        int executeSqlStatementsInTx = z ? executeSqlStatementsInTx(sQLiteDatabase, split) : executeSqlStatements(sQLiteDatabase, split);
        DaoLog.i("Executed " + executeSqlStatementsInTx + " statements from SQL script '" + str + "'");
        return executeSqlStatementsInTx;
    }

    public static int executeSqlStatements(SQLiteDatabase sQLiteDatabase, String[] strArr) {
        int i = 0;
        for (String trim : strArr) {
            String trim2 = trim2.trim();
            if (trim2.length() > 0) {
                sQLiteDatabase.execSQL(trim2);
                i++;
            }
        }
        return i;
    }

    public static int executeSqlStatementsInTx(SQLiteDatabase sQLiteDatabase, String[] strArr) {
        sQLiteDatabase.beginTransaction();
        try {
            int executeSqlStatements = executeSqlStatements(sQLiteDatabase, strArr);
            sQLiteDatabase.setTransactionSuccessful();
            return executeSqlStatements;
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public static void logTableDump(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor query = sQLiteDatabase.query(str, null, null, null, null, null, null);
        try {
            DaoLog.d(DatabaseUtils.dumpCursorToString(query));
        } finally {
            query.close();
        }
    }

    public static byte[] readAllBytes(InputStream inputStream) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copyAllBytes(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] readAsset(Context context, String str) {
        InputStream open = context.getResources().getAssets().open(str);
        try {
            byte[] readAllBytes = readAllBytes(open);
            return readAllBytes;
        } finally {
            open.close();
        }
    }

    public static void vacuum(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("VACUUM");
    }
}
