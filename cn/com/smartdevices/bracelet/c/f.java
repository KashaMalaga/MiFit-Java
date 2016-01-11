package cn.com.smartdevices.bracelet.c;

import com.c.b.c.l;
import com.xiaomi.e.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class f {
    private static final int a = 1048576;

    public static String a(ZipEntry zipEntry) {
        return new String(zipEntry.getComment().getBytes(l.b), "8859_1");
    }

    public static ArrayList<String> a(File file) {
        ArrayList<String> arrayList = new ArrayList();
        Enumeration b = b(file);
        while (b.hasMoreElements()) {
            arrayList.add(new String(b((ZipEntry) b.nextElement()).getBytes(l.b), "8859_1"));
        }
        return arrayList;
    }

    public static ArrayList<File> a(File file, String str, String str2) {
        ArrayList<File> arrayList = new ArrayList();
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdir();
        }
        ZipFile zipFile = new ZipFile(file);
        Enumeration entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            if (zipEntry.getName().contains(str2)) {
                InputStream inputStream = zipFile.getInputStream(zipEntry);
                file2 = new File(new String((str + File.separator + zipEntry.getName()).getBytes("8859_1"), l.b));
                if (!file2.exists()) {
                    File parentFile = file2.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    file2.createNewFile();
                }
                OutputStream fileOutputStream = new FileOutputStream(file2);
                byte[] bArr = new byte[a];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                inputStream.close();
                fileOutputStream.close();
                arrayList.add(file2);
            }
        }
        return arrayList;
    }

    public static void a(File file, String str) {
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        ZipFile zipFile = new ZipFile(file);
        Enumeration entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            file2 = new File(new String((str + File.separator + zipEntry.getName()).getBytes("8859_1"), l.b));
            if (!file2.exists()) {
                File parentFile = file2.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                file2.createNewFile();
            }
            OutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[a];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            inputStream.close();
            fileOutputStream.close();
        }
    }

    private static void a(File file, ZipOutputStream zipOutputStream, String str) {
        String str2 = new String((str + (str.trim().length() == 0 ? a.f : File.separator) + file.getName()).getBytes("8859_1"), l.b);
        if (file.isDirectory()) {
            for (File a : file.listFiles()) {
                a(a, zipOutputStream, str2);
            }
            return;
        }
        byte[] bArr = new byte[a];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), a);
        zipOutputStream.putNextEntry(new ZipEntry(str2));
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read != -1) {
                zipOutputStream.write(bArr, 0, read);
            } else {
                bufferedInputStream.close();
                zipOutputStream.flush();
                zipOutputStream.closeEntry();
                return;
            }
        }
    }

    public static void a(Collection<File> collection, File file) {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file), a));
        for (File a : collection) {
            a(a, zipOutputStream, a.f);
        }
        zipOutputStream.close();
    }

    public static void a(Collection<File> collection, File file, String str) {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file), a));
        for (File a : collection) {
            a(a, zipOutputStream, a.f);
        }
        zipOutputStream.setComment(str);
        zipOutputStream.close();
    }

    public static String b(ZipEntry zipEntry) {
        return new String(zipEntry.getName().getBytes(l.b), "8859_1");
    }

    public static Enumeration<?> b(File file) {
        return new ZipFile(file).entries();
    }
}
