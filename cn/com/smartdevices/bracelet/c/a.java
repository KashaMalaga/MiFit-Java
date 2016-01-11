package cn.com.smartdevices.bracelet.c;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class a {
    protected final File a;

    public a(String str) {
        this.a = new File(str);
        if (!this.a.exists()) {
            this.a.mkdir();
        }
    }

    private File a(File file, String str) {
        String absolutePath = file.getAbsolutePath();
        return new File(absolutePath.substring(0, absolutePath.lastIndexOf(".")) + "." + str);
    }

    public ArrayList<File> a() {
        ArrayList<File> arrayList = new ArrayList();
        File[] listFiles = this.a.listFiles(new b("sbin"));
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        for (File file : listFiles) {
            Collection arrayList2 = new ArrayList();
            arrayList2.add(file);
            File file2 = a(file2, "zip");
            f.a(arrayList2, file2);
            arrayList.add(file2);
        }
        return arrayList;
    }

    public void a(ArrayList<File> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (file.exists()) {
                file.delete();
            }
            file = a(file, "sbin");
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
