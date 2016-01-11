package com.c.b.a;

import com.c.b.a.b.a;
import com.c.b.c;
import com.c.b.e;
import com.c.b.h;
import com.c.b.n;
import com.c.b.q;
import com.c.b.s;
import com.c.b.t;
import com.c.b.u;
import com.c.b.v;
import java.util.List;
import java.util.Map;

public final class b implements q {
    public s a(c cVar) {
        return a(cVar, null);
    }

    public s a(c cVar, Map<e, ?> map) {
        a a;
        u[] e;
        com.c.b.c.e a2;
        n nVar;
        n e2;
        com.c.b.c.e eVar;
        u[] uVarArr;
        v vVar;
        s sVar;
        List c;
        String d;
        h e3;
        h hVar;
        h hVar2 = null;
        a aVar = new a(cVar.c());
        try {
            a = aVar.a(false);
            e = a.e();
            try {
                a2 = new com.c.b.a.a.a().a(a);
                nVar = null;
            } catch (n e4) {
                e2 = e4;
                nVar = e2;
                a2 = null;
                if (a2 == null) {
                    eVar = a2;
                    uVarArr = e;
                } else {
                    try {
                        a = aVar.a(true);
                        eVar = new com.c.b.a.a.a().a(a);
                        uVarArr = a.e();
                    } catch (n e5) {
                        e2 = e5;
                        if (nVar != null) {
                            throw nVar;
                        } else if (hVar2 == null) {
                            throw hVar2;
                        } else {
                            throw e2;
                        }
                    } catch (h e6) {
                        e2 = e6;
                        if (nVar != null) {
                            throw nVar;
                        } else if (hVar2 == null) {
                            throw e2;
                        } else {
                            throw hVar2;
                        }
                    }
                }
                if (map != null) {
                    vVar = (v) map.get(e.NEED_RESULT_POINT_CALLBACK);
                    if (vVar != null) {
                        for (u a3 : uVarArr) {
                            vVar.a(a3);
                        }
                    }
                }
                sVar = new s(eVar.b(), eVar.a(), uVarArr, com.c.b.a.AZTEC);
                c = eVar.c();
                if (c != null) {
                    sVar.a(t.BYTE_SEGMENTS, c);
                }
                d = eVar.d();
                if (d != null) {
                    sVar.a(t.ERROR_CORRECTION_LEVEL, d);
                }
                return sVar;
            } catch (h e7) {
                e3 = e7;
                nVar = null;
                hVar = e3;
                a2 = null;
                hVar2 = hVar;
                if (a2 == null) {
                    a = aVar.a(true);
                    eVar = new com.c.b.a.a.a().a(a);
                    uVarArr = a.e();
                } else {
                    eVar = a2;
                    uVarArr = e;
                }
                if (map != null) {
                    vVar = (v) map.get(e.NEED_RESULT_POINT_CALLBACK);
                    if (vVar != null) {
                        while (r1 < r5) {
                            vVar.a(a3);
                        }
                    }
                }
                sVar = new s(eVar.b(), eVar.a(), uVarArr, com.c.b.a.AZTEC);
                c = eVar.c();
                if (c != null) {
                    sVar.a(t.BYTE_SEGMENTS, c);
                }
                d = eVar.d();
                if (d != null) {
                    sVar.a(t.ERROR_CORRECTION_LEVEL, d);
                }
                return sVar;
            }
        } catch (n e8) {
            e2 = e8;
            e = null;
            nVar = e2;
            a2 = null;
            if (a2 == null) {
                eVar = a2;
                uVarArr = e;
            } else {
                a = aVar.a(true);
                eVar = new com.c.b.a.a.a().a(a);
                uVarArr = a.e();
            }
            if (map != null) {
                vVar = (v) map.get(e.NEED_RESULT_POINT_CALLBACK);
                if (vVar != null) {
                    while (r1 < r5) {
                        vVar.a(a3);
                    }
                }
            }
            sVar = new s(eVar.b(), eVar.a(), uVarArr, com.c.b.a.AZTEC);
            c = eVar.c();
            if (c != null) {
                sVar.a(t.BYTE_SEGMENTS, c);
            }
            d = eVar.d();
            if (d != null) {
                sVar.a(t.ERROR_CORRECTION_LEVEL, d);
            }
            return sVar;
        } catch (h e9) {
            e3 = e9;
            e = null;
            nVar = null;
            hVar = e3;
            a2 = null;
            hVar2 = hVar;
            if (a2 == null) {
                a = aVar.a(true);
                eVar = new com.c.b.a.a.a().a(a);
                uVarArr = a.e();
            } else {
                eVar = a2;
                uVarArr = e;
            }
            if (map != null) {
                vVar = (v) map.get(e.NEED_RESULT_POINT_CALLBACK);
                if (vVar != null) {
                    while (r1 < r5) {
                        vVar.a(a3);
                    }
                }
            }
            sVar = new s(eVar.b(), eVar.a(), uVarArr, com.c.b.a.AZTEC);
            c = eVar.c();
            if (c != null) {
                sVar.a(t.BYTE_SEGMENTS, c);
            }
            d = eVar.d();
            if (d != null) {
                sVar.a(t.ERROR_CORRECTION_LEVEL, d);
            }
            return sVar;
        }
        if (a2 == null) {
            a = aVar.a(true);
            eVar = new com.c.b.a.a.a().a(a);
            uVarArr = a.e();
        } else {
            eVar = a2;
            uVarArr = e;
        }
        if (map != null) {
            vVar = (v) map.get(e.NEED_RESULT_POINT_CALLBACK);
            if (vVar != null) {
                while (r1 < r5) {
                    vVar.a(a3);
                }
            }
        }
        sVar = new s(eVar.b(), eVar.a(), uVarArr, com.c.b.a.AZTEC);
        c = eVar.c();
        if (c != null) {
            sVar.a(t.BYTE_SEGMENTS, c);
        }
        d = eVar.d();
        if (d != null) {
            sVar.a(t.ERROR_CORRECTION_LEVEL, d);
        }
        return sVar;
    }

    public void a() {
    }
}
