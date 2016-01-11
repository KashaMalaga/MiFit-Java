package com.b;

import com.activeandroid.b;
import com.d.a.a.C1012a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.zip.GZIPInputStream;

public final class J {
    private RandomAccessFile a;
    private C0927l b;
    private File c = null;

    protected J(C0927l c0927l) {
        this.b = c0927l;
    }

    private static byte a(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            byte[] bArr3 = new byte[b.a];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = gZIPInputStream.read(bArr3, 0, bArr3.length);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr3, 0, read);
            }
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            gZIPInputStream.close();
            byteArrayInputStream.close();
        } catch (Exception e) {
        }
        return bArr2[0];
    }

    private static int a(int i, int i2, int i3) {
        int i4 = ((i3 - 1) * C1012a.d) + i;
        while (i4 >= i2) {
            i4 -= 1500;
        }
        return i4;
    }

    private int a(BitSet bitSet) {
        for (int i = 0; i < bitSet.length(); i++) {
            if (bitSet.get(i)) {
                return this.b.a() + ((i * C1012a.d) + 4);
            }
        }
        return 0;
    }

    private ArrayList a(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        while (i <= i2) {
            try {
                this.a.seek((long) i);
                int readInt = this.a.readInt();
                this.a.readLong();
                if (readInt <= 0 || readInt > C1012a.d) {
                    return null;
                }
                byte[] bArr = new byte[readInt];
                this.a.read(bArr);
                byte a = a(bArr);
                if (a != (byte) 3 && a != (byte) 4 && a != (byte) 41) {
                    return null;
                }
                arrayList.add(bArr);
                i += C1012a.d;
            } catch (IOException e) {
            }
        }
        return arrayList;
    }

    private BitSet b() {
        BitSet bitSet = null;
        byte[] bArr = new byte[this.b.a()];
        try {
            this.a.read(bArr);
            bitSet = C0927l.b(bArr);
        } catch (IOException e) {
        }
        return bitSet;
    }

    protected final int a() {
        int i = 0;
        synchronized (this) {
            this.c = this.b.b();
            try {
                if (this.c != null) {
                    this.a = new RandomAccessFile(this.b.b(), "rw");
                    byte[] bArr = new byte[this.b.a()];
                    this.a.read(bArr);
                    BitSet b = C0927l.b(bArr);
                    for (int i2 = 0; i2 < b.size(); i2++) {
                        if (b.get(i2)) {
                            i++;
                        }
                    }
                }
                if (this.a != null) {
                    try {
                        this.a.close();
                    } catch (IOException e) {
                    }
                }
            } catch (FileNotFoundException e2) {
                if (this.a != null) {
                    try {
                        this.a.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (IOException e4) {
                if (this.a != null) {
                    try {
                        this.a.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (NullPointerException e6) {
                if (this.a != null) {
                    try {
                        this.a.close();
                    } catch (IOException e7) {
                    }
                }
            } catch (Throwable th) {
                if (this.a != null) {
                    try {
                        this.a.close();
                    } catch (IOException e8) {
                    }
                }
            }
            this.c = null;
        }
        return i;
    }

    protected final synchronized C0926k a(int i) {
        C0926k c0926k = null;
        synchronized (this) {
            if (this.b != null) {
                synchronized (this) {
                    this.c = this.b.b();
                    if (this.c == null) {
                    } else {
                        C0926k c0926k2;
                        try {
                            this.a = new RandomAccessFile(this.c, "rw");
                            BitSet b = b();
                            if (b == null) {
                                this.c.delete();
                                if (this.a != null) {
                                    try {
                                        this.a.close();
                                    } catch (Exception e) {
                                    }
                                }
                            } else {
                                int a = a(b);
                                ArrayList a2 = a(a, a(a, (int) this.c.length(), i));
                                if (a2 == null) {
                                    this.c.delete();
                                    if (this.a != null) {
                                        try {
                                            this.a.close();
                                        } catch (Exception e2) {
                                        }
                                    }
                                } else {
                                    c0926k2 = new C0926k(this.c, a2, new int[]{((a - this.b.a()) - 4) / C1012a.d, ((r2 - this.b.a()) - 4) / C1012a.d});
                                    if (this.a != null) {
                                        try {
                                            this.a.close();
                                        } catch (Exception e3) {
                                        }
                                    }
                                    if (c0926k2 != null) {
                                        if (c0926k2.c() > 100 && c0926k2.c() < 5242880) {
                                            c0926k = c0926k2;
                                        }
                                    }
                                    this.c.delete();
                                    this.c = null;
                                }
                            }
                        } catch (FileNotFoundException e4) {
                            if (this.a != null) {
                                try {
                                    this.a.close();
                                    c0926k2 = null;
                                } catch (Exception e5) {
                                    c0926k2 = null;
                                }
                            }
                            c0926k2 = null;
                        } catch (Exception e6) {
                            if (this.a != null) {
                                try {
                                    this.a.close();
                                    c0926k2 = null;
                                } catch (Exception e7) {
                                    c0926k2 = null;
                                }
                            }
                            c0926k2 = null;
                        } catch (Throwable th) {
                            if (this.a != null) {
                                try {
                                    this.a.close();
                                } catch (Exception e8) {
                                }
                            }
                        }
                    }
                }
            }
        }
        return c0926k;
    }

    protected final synchronized void a(C0926k c0926k) {
        BitSet bitSet = null;
        synchronized (this) {
            synchronized (this) {
                this.c = c0926k.a;
                if (this.c == null) {
                } else {
                    try {
                        this.a = new RandomAccessFile(this.c, "rw");
                        byte[] bArr = new byte[this.b.a()];
                        this.a.read(bArr);
                        bitSet = C0927l.b(bArr);
                        if (c0926k.b()) {
                            for (int i = c0926k.b[0]; i <= c0926k.b[1]; i++) {
                                bitSet.set(i, false);
                            }
                            this.a.seek(0);
                            this.a.write(C0927l.a(bitSet));
                        }
                        if (this.a != null) {
                            try {
                                this.a.close();
                            } catch (IOException e) {
                            }
                        }
                    } catch (FileNotFoundException e2) {
                        if (this.a != null) {
                            try {
                                this.a.close();
                            } catch (IOException e3) {
                            }
                        }
                    } catch (IOException e4) {
                        if (this.a != null) {
                            try {
                                this.a.close();
                            } catch (IOException e5) {
                            }
                        }
                    } catch (Throwable th) {
                        if (this.a != null) {
                            try {
                                this.a.close();
                            } catch (IOException e6) {
                            }
                        }
                    }
                    if (bitSet.isEmpty()) {
                        this.c.delete();
                    }
                    this.c = null;
                }
            }
        }
        return;
    }
}
