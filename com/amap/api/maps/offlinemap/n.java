package com.amap.api.maps.offlinemap;

import android.support.v4.view.a.C0113o;
import com.amap.api.mapcore.util.az;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

class n {
    n() {
    }

    private static void a(ZipInputStream zipInputStream, File file, l lVar, d dVar) {
        FileOutputStream fileOutputStream;
        Throwable th;
        Throwable e;
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        StringBuffer stringBuffer = new StringBuffer();
        long j = 0;
        while (nextEntry != null) {
            String name = nextEntry.getName();
            if (!nextEntry.isDirectory()) {
                stringBuffer.append(name).append(";");
            }
            File file2 = new File(file.getAbsolutePath() + "/" + name);
            if (nextEntry.isDirectory()) {
                file2.mkdirs();
            } else {
                file2.createNewFile();
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        byte[] bArr = new byte[C0113o.l];
                        int i = 0;
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                            long j2 = ((long) read) + j;
                            try {
                                int h = (int) ((62 * j2) / lVar.h());
                                if (h >= 100) {
                                    h = 100;
                                }
                                if (h != i) {
                                    dVar.a(lVar, 1, h);
                                }
                                i = h;
                                j = j2;
                            } catch (Throwable e2) {
                                th = e2;
                                j = j2;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (IOException e3) {
                        th = e3;
                        try {
                            az.a(th, "ZipEncrypt", "fileUnZip");
                            th.printStackTrace();
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            nextEntry = zipInputStream.getNextEntry();
                        } catch (Throwable th2) {
                            e2 = th2;
                        }
                    }
                } catch (IOException e4) {
                    th = e4;
                    fileOutputStream = null;
                    az.a(th, "ZipEncrypt", "fileUnZip");
                    th.printStackTrace();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    nextEntry = zipInputStream.getNextEntry();
                } catch (Throwable th3) {
                    e2 = th3;
                    fileOutputStream = null;
                }
            }
            nextEntry = zipInputStream.getNextEntry();
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        lVar.e(stringBuffer.toString());
        return;
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        throw e2;
    }

    public static boolean a(String str, String str2, l lVar, d dVar) {
        FileInputStream fileInputStream;
        Throwable th;
        Throwable th2;
        ZipInputStream zipInputStream = null;
        boolean z = false;
        try {
            fileInputStream = new FileInputStream(str2);
            try {
                ZipInputStream zipInputStream2 = new ZipInputStream(fileInputStream);
                try {
                    File file = new File(str);
                    file.mkdirs();
                    a(zipInputStream2, file, lVar, dVar);
                    z = true;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (zipInputStream2 != null) {
                        zipInputStream2.close();
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    zipInputStream = zipInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (zipInputStream != null) {
                        zipInputStream.close();
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                th = th4;
                az.a(th, "ZipEncrypt", "unZip");
                th.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (zipInputStream != null) {
                    zipInputStream.close();
                }
                return z;
            }
        } catch (Throwable th5) {
            th2 = th5;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (zipInputStream != null) {
                zipInputStream.close();
            }
            throw th2;
        }
        return z;
    }
}
