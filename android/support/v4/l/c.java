package android.support.v4.l;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class c {
    private final File a;
    private final File b;

    public c(File file) {
        this.a = file;
        this.b = new File(file.getPath() + ".bak");
    }

    static boolean c(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }

    public File a() {
        return this.a;
    }

    public void a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            c(fileOutputStream);
            try {
                fileOutputStream.close();
                this.b.delete();
            } catch (Throwable e) {
                Log.w("AtomicFile", "finishWrite: Got exception:", e);
            }
        }
    }

    public void b() {
        this.a.delete();
        this.b.delete();
    }

    public void b(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            c(fileOutputStream);
            try {
                fileOutputStream.close();
                this.a.delete();
                this.b.renameTo(this.a);
            } catch (Throwable e) {
                Log.w("AtomicFile", "failWrite: Got exception:", e);
            }
        }
    }

    public FileOutputStream c() {
        if (this.a.exists()) {
            if (this.b.exists()) {
                this.a.delete();
            } else if (!this.a.renameTo(this.b)) {
                Log.w("AtomicFile", "Couldn't rename file " + this.a + " to backup file " + this.b);
            }
        }
        try {
            return new FileOutputStream(this.a);
        } catch (FileNotFoundException e) {
            if (this.a.getParentFile().mkdir()) {
                try {
                    return new FileOutputStream(this.a);
                } catch (FileNotFoundException e2) {
                    throw new IOException("Couldn't create " + this.a);
                }
            }
            throw new IOException("Couldn't create directory " + this.a);
        }
    }

    public FileInputStream d() {
        if (this.b.exists()) {
            this.a.delete();
            this.b.renameTo(this.a);
        }
        return new FileInputStream(this.a);
    }

    public byte[] e() {
        int i = 0;
        FileInputStream d = d();
        try {
            Object obj = new byte[d.available()];
            while (true) {
                int read = d.read(obj, i, obj.length - i);
                if (read <= 0) {
                    break;
                }
                Object obj2;
                read += i;
                i = d.available();
                if (i > obj.length - read) {
                    obj2 = new byte[(i + read)];
                    System.arraycopy(obj, 0, obj2, 0, read);
                } else {
                    obj2 = obj;
                }
                obj = obj2;
                i = read;
            }
            return obj;
        } finally {
            d.close();
        }
    }
}
