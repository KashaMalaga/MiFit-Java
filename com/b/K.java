package com.b;

import com.d.a.a.C1012a;
import com.xiaomi.e.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.BitSet;

public final class K {
    private RandomAccessFile a;
    private C0927l b;
    private String c = a.f;
    private File d = null;

    protected K(C0927l c0927l) {
        this.b = c0927l;
    }

    protected final synchronized void a(long j, byte[] bArr) {
        int i = 0;
        synchronized (this) {
            this.d = this.b.a(j);
            if (this.d != null) {
                try {
                    this.a = new RandomAccessFile(this.d, "rw");
                    byte[] bArr2 = new byte[this.b.a()];
                    int readInt = this.a.read(bArr2) == -1 ? 0 : this.a.readInt();
                    BitSet b = C0927l.b(bArr2);
                    int a = (this.b.a() + 4) + (readInt * C1012a.d);
                    if (readInt < 0 || readInt > (this.b.a() << 3)) {
                        this.a.close();
                        this.d.delete();
                        if (this.a != null) {
                            try {
                                this.a.close();
                            } catch (IOException e) {
                            }
                        }
                    } else {
                        this.a.seek((long) a);
                        byte[] a2 = C0927l.a(bArr);
                        this.a.writeInt(a2.length);
                        this.a.writeLong(j);
                        this.a.write(a2);
                        b.set(readInt, true);
                        this.a.seek(0);
                        this.a.write(C0927l.a(b));
                        readInt++;
                        if (readInt != (this.b.a() << 3)) {
                            i = readInt;
                        }
                        this.a.writeInt(i);
                        if (!this.c.equalsIgnoreCase(this.d.getName())) {
                            this.c = this.d.getName();
                        }
                        this.d.length();
                        if (this.a != null) {
                            try {
                                this.a.close();
                            } catch (IOException e2) {
                            }
                        }
                        this.d = null;
                    }
                } catch (FileNotFoundException e3) {
                    if (this.a != null) {
                        try {
                            this.a.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (IOException e5) {
                    if (this.a != null) {
                        try {
                            this.a.close();
                        } catch (IOException e6) {
                        }
                    }
                } catch (Throwable th) {
                    if (this.a != null) {
                        try {
                            this.a.close();
                        } catch (IOException e7) {
                        }
                    }
                }
            }
        }
        return;
    }
}
