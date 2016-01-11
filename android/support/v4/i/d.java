package android.support.v4.i;

import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.d.a.a.O;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class d extends a {
    private File b;

    d(a aVar, File file) {
        super(aVar);
        this.b = file;
    }

    private static boolean b(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    z &= b(file2);
                }
                if (!file2.delete()) {
                    Log.w("DocumentFile", "Failed to delete " + file2);
                    z = false;
                }
            }
        }
        return z;
    }

    private static String d(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(lastIndexOf + 1).toLowerCase());
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return O.a;
    }

    public Uri a() {
        return Uri.fromFile(this.b);
    }

    public a a(String str) {
        File file = new File(this.b, str);
        return (file.isDirectory() || file.mkdir()) ? new d(this, file) : null;
    }

    public a a(String str, String str2) {
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        if (extensionFromMimeType != null) {
            str2 = str2 + "." + extensionFromMimeType;
        }
        File file = new File(this.b, str2);
        try {
            file.createNewFile();
            return new d(this, file);
        } catch (IOException e) {
            Log.w("DocumentFile", "Failed to createFile: " + e);
            return null;
        }
    }

    public String b() {
        return this.b.getName();
    }

    public String c() {
        return this.b.isDirectory() ? null : d(this.b.getName());
    }

    public boolean c(String str) {
        File file = new File(this.b.getParentFile(), str);
        if (!this.b.renameTo(file)) {
            return false;
        }
        this.b = file;
        return true;
    }

    public boolean e() {
        return this.b.isDirectory();
    }

    public boolean f() {
        return this.b.isFile();
    }

    public long g() {
        return this.b.lastModified();
    }

    public long h() {
        return this.b.length();
    }

    public boolean i() {
        return this.b.canRead();
    }

    public boolean j() {
        return this.b.canWrite();
    }

    public boolean k() {
        b(this.b);
        return this.b.delete();
    }

    public boolean l() {
        return this.b.exists();
    }

    public a[] m() {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = this.b.listFiles();
        if (listFiles != null) {
            for (File dVar : listFiles) {
                arrayList.add(new d(this, dVar));
            }
        }
        return (a[]) arrayList.toArray(new a[arrayList.size()]);
    }
}
