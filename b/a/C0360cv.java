package b.a;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import kankan.wheel.widget.a;

public class C0360cv {
    private final cY a;
    private final C0377dn b;

    public C0360cv() {
        this(new cR());
    }

    public C0360cv(db dbVar) {
        this.b = new C0377dn();
        this.a = dbVar.a(this.b);
    }

    private Object a(byte b, byte[] bArr, cz czVar, cz... czVarArr) {
        try {
            cT j = j(bArr, czVar, czVarArr);
            if (j != null) {
                switch (b) {
                    case a.k /*2*/:
                        if (j.b == (byte) 2) {
                            Boolean valueOf = Boolean.valueOf(this.a.t());
                            this.b.e();
                            this.a.B();
                            return valueOf;
                        }
                        break;
                    case a.l /*3*/:
                        if (j.b == (byte) 3) {
                            Byte valueOf2 = Byte.valueOf(this.a.u());
                            this.b.e();
                            this.a.B();
                            return valueOf2;
                        }
                        break;
                    case a.aQ /*4*/:
                        if (j.b == (byte) 4) {
                            Double valueOf3 = Double.valueOf(this.a.y());
                            this.b.e();
                            this.a.B();
                            return valueOf3;
                        }
                        break;
                    case a.bt /*6*/:
                        if (j.b == (byte) 6) {
                            Short valueOf4 = Short.valueOf(this.a.v());
                            this.b.e();
                            this.a.B();
                            return valueOf4;
                        }
                        break;
                    case a.ba /*8*/:
                        if (j.b == (byte) 8) {
                            Integer valueOf5 = Integer.valueOf(this.a.w());
                            this.b.e();
                            this.a.B();
                            return valueOf5;
                        }
                        break;
                    case a.bd /*10*/:
                        if (j.b == (byte) 10) {
                            Long valueOf6 = Long.valueOf(this.a.x());
                            this.b.e();
                            this.a.B();
                            return valueOf6;
                        }
                        break;
                    case a.aW /*11*/:
                        if (j.b == C0374dh.i) {
                            String z = this.a.z();
                            this.b.e();
                            this.a.B();
                            return z;
                        }
                        break;
                    case a.ar /*100*/:
                        if (j.b == C0374dh.i) {
                            ByteBuffer A = this.a.A();
                            this.b.e();
                            this.a.B();
                            return A;
                        }
                        break;
                }
            }
            this.b.e();
            this.a.B();
            return null;
        } catch (Throwable e) {
            throw new C0339cy(e);
        } catch (Throwable th) {
            this.b.e();
            this.a.B();
        }
    }

    private cT j(byte[] bArr, cz czVar, cz... czVarArr) {
        int i = 0;
        this.b.a(bArr);
        cz[] czVarArr2 = new cz[(czVarArr.length + 1)];
        czVarArr2[0] = czVar;
        for (int i2 = 0; i2 < czVarArr.length; i2++) {
            czVarArr2[i2 + 1] = czVarArr[i2];
        }
        this.a.j();
        cT cTVar = null;
        while (i < czVarArr2.length) {
            cTVar = this.a.l();
            if (cTVar.b == (byte) 0 || cTVar.c > czVarArr2[i].a()) {
                return null;
            }
            if (cTVar.c != czVarArr2[i].a()) {
                C0369dc.a(this.a, cTVar.b);
                this.a.m();
            } else {
                i++;
                if (i < czVarArr2.length) {
                    this.a.j();
                }
            }
        }
        return cTVar;
    }

    public Boolean a(byte[] bArr, cz czVar, cz... czVarArr) {
        return (Boolean) a((byte) 2, bArr, czVar, czVarArr);
    }

    public void a(cq cqVar, String str) {
        a(cqVar, str.getBytes());
    }

    public void a(cq cqVar, String str, String str2) {
        try {
            a(cqVar, str.getBytes(str2));
            this.a.B();
        } catch (UnsupportedEncodingException e) {
            throw new C0339cy("JVM DOES NOT SUPPORT ENCODING: " + str2);
        } catch (Throwable th) {
            this.a.B();
        }
    }

    public void a(cq cqVar, byte[] bArr) {
        try {
            this.b.a(bArr);
            cqVar.a(this.a);
        } finally {
            this.b.e();
            this.a.B();
        }
    }

    public void a(cq cqVar, byte[] bArr, cz czVar, cz... czVarArr) {
        try {
            if (j(bArr, czVar, czVarArr) != null) {
                cqVar.a(this.a);
            }
            this.b.e();
            this.a.B();
        } catch (Throwable e) {
            throw new C0339cy(e);
        } catch (Throwable th) {
            this.b.e();
            this.a.B();
        }
    }

    public Byte b(byte[] bArr, cz czVar, cz... czVarArr) {
        return (Byte) a((byte) 3, bArr, czVar, czVarArr);
    }

    public Double c(byte[] bArr, cz czVar, cz... czVarArr) {
        return (Double) a((byte) 4, bArr, czVar, czVarArr);
    }

    public Short d(byte[] bArr, cz czVar, cz... czVarArr) {
        return (Short) a((byte) 6, bArr, czVar, czVarArr);
    }

    public Integer e(byte[] bArr, cz czVar, cz... czVarArr) {
        return (Integer) a((byte) 8, bArr, czVar, czVarArr);
    }

    public Long f(byte[] bArr, cz czVar, cz... czVarArr) {
        return (Long) a((byte) 10, bArr, czVar, czVarArr);
    }

    public String g(byte[] bArr, cz czVar, cz... czVarArr) {
        return (String) a((byte) C0374dh.i, bArr, czVar, czVarArr);
    }

    public ByteBuffer h(byte[] bArr, cz czVar, cz... czVarArr) {
        return (ByteBuffer) a((byte) 100, bArr, czVar, czVarArr);
    }

    public Short i(byte[] bArr, cz czVar, cz... czVarArr) {
        try {
            if (j(bArr, czVar, czVarArr) != null) {
                this.a.j();
                Short valueOf = Short.valueOf(this.a.l().c);
                this.b.e();
                this.a.B();
                return valueOf;
            }
            this.b.e();
            this.a.B();
            return null;
        } catch (Throwable e) {
            throw new C0339cy(e);
        } catch (Throwable th) {
            this.b.e();
            this.a.B();
        }
    }
}
