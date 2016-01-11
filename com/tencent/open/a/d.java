package com.tencent.open.a;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.text.SimpleDateFormat;

public class d {

    public final class a {
        public static final boolean a(int i, int i2) {
            return i2 == (i & i2);
        }
    }

    public final class b {
        public static boolean a(File file) {
            int i = 0;
            if (file == null) {
                return false;
            }
            if (file.isFile()) {
                if (file.delete()) {
                    return true;
                }
                file.deleteOnExit();
                return false;
            } else if (!file.isDirectory()) {
                return false;
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    return false;
                }
                int length = listFiles.length;
                while (i < length) {
                    a(listFiles[i]);
                    i++;
                }
                return file.delete();
            }
        }
    }

    public final class c {
        public static boolean a() {
            String externalStorageState = Environment.getExternalStorageState();
            return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
        }

        public static d b() {
            return !a() ? null : d.b(Environment.getExternalStorageDirectory());
        }
    }

    public class d {
        private File a;
        private long b;
        private long c;

        public static d b(File file) {
            d dVar = new d();
            dVar.a(file);
            StatFs statFs = new StatFs(file.getAbsolutePath());
            long blockSize = (long) statFs.getBlockSize();
            long availableBlocks = (long) statFs.getAvailableBlocks();
            dVar.a(((long) statFs.getBlockCount()) * blockSize);
            dVar.b(blockSize * availableBlocks);
            return dVar;
        }

        public File a() {
            return this.a;
        }

        public void a(long j) {
            this.b = j;
        }

        public void a(File file) {
            this.a = file;
        }

        public long b() {
            return this.b;
        }

        public void b(long j) {
            this.c = j;
        }

        public long c() {
            return this.c;
        }

        public String toString() {
            return String.format("[%s : %d / %d]", new Object[]{a().getAbsolutePath(), Long.valueOf(c()), Long.valueOf(b())});
        }
    }

    public final class e {
        @SuppressLint({"SimpleDateFormat"})
        public static SimpleDateFormat a(String str) {
            return new SimpleDateFormat(str);
        }
    }
}
