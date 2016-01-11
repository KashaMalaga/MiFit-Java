package com.amap.api.mapcore.util;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

class bb extends bj {
    private String[] a = new String[10];
    private int b = 0;
    private boolean c = false;
    private int d = 0;
    private a e;

    class a implements bo {
        final /* synthetic */ bb a;
        private al b;

        private a(bb bbVar, al alVar) {
            this.a = bbVar;
            this.b = alVar;
        }

        public void a(String str) {
            try {
                this.b.b(str, this.a.a());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    bb() {
    }

    private void b(String str) {
        try {
            if (this.b > 9) {
                this.b = 0;
            }
            this.a[this.b] = str;
            this.b++;
        } catch (Throwable th) {
            az.a(th, "ANRWriter", "addData");
            th.printStackTrace();
        }
    }

    private String c() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            int i = this.b;
            while (i < 10 && i <= 9) {
                stringBuilder.append(this.a[i]);
                i++;
            }
            for (i = 0; i < this.b; i++) {
                stringBuilder.append(this.a[i]);
            }
        } catch (Throwable th) {
            az.a(th, "ANRWriter", "getLogInfo");
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }

    protected int a() {
        return 2;
    }

    protected bo a(al alVar) {
        try {
            if (this.e == null) {
                this.e = new a(alVar);
            }
        } catch (Throwable th) {
            az.a(th, "ANRWriter", "getListener");
            th.printStackTrace();
        }
        return this.e;
    }

    protected String a(String str) {
        return ab.b(str);
    }

    protected String a(List<ad> list) {
        bp bpVar;
        InputStream inputStream;
        Throwable e;
        IOException iOException;
        InputStream inputStream2 = null;
        bp bpVar2 = null;
        InputStream fileInputStream;
        try {
            File file = new File("/data/anr/traces.txt");
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    bpVar2 = new bp(fileInputStream, bq.a);
                    Object obj = null;
                    while (true) {
                        try {
                            String str;
                            Object obj2;
                            String a = bpVar2.a();
                            if (a.contains("pid")) {
                                while (!a.contains("\"main\"")) {
                                    a = bpVar2.a();
                                }
                                str = a;
                                obj2 = 1;
                            } else {
                                str = a;
                                obj2 = obj;
                            }
                            obj = str.equals(com.xiaomi.e.a.f) ? null : obj2;
                            if (obj != null) {
                                b(str);
                                if (this.d == 5) {
                                    break;
                                } else if (this.c) {
                                    this.d++;
                                } else {
                                    for (ad adVar : list) {
                                        this.c = a(adVar.f(), str);
                                        if (this.c) {
                                            a(adVar);
                                        }
                                    }
                                }
                            }
                        } catch (EOFException e2) {
                        } catch (FileNotFoundException e3) {
                            bpVar = bpVar2;
                            inputStream = fileInputStream;
                        } catch (IOException e4) {
                            e = e4;
                        }
                    }
                    if (bpVar2 != null) {
                        try {
                            bpVar2.close();
                        } catch (Throwable e5) {
                            az.a(e5, "ANRWriter", "initLog1");
                            e5.printStackTrace();
                        } catch (Throwable e52) {
                            az.a(e52, "ANRWriter", "initLog2");
                            e52.printStackTrace();
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e6) {
                            e52 = e6;
                            az.a(e52, "ANRWriter", "initLog3");
                            iOException.printStackTrace();
                            return this.c ? null : c();
                        } catch (Throwable th) {
                            e52 = th;
                            az.a(e52, "ANRWriter", "initLog4");
                            e52.printStackTrace();
                            if (this.c) {
                            }
                        }
                    }
                } catch (FileNotFoundException e7) {
                    bpVar = null;
                    inputStream = fileInputStream;
                    if (bpVar != null) {
                        try {
                            bpVar.close();
                        } catch (Throwable e522) {
                            az.a(e522, "ANRWriter", "initLog1");
                            e522.printStackTrace();
                        } catch (Throwable e5222) {
                            az.a(e5222, "ANRWriter", "initLog2");
                            e5222.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e8) {
                            iOException = e8;
                            az.a((Throwable) iOException, "ANRWriter", "initLog3");
                            iOException.printStackTrace();
                            if (this.c) {
                            }
                        } catch (Throwable th2) {
                            e5222 = th2;
                            az.a(e5222, "ANRWriter", "initLog4");
                            e5222.printStackTrace();
                            if (this.c) {
                            }
                        }
                    }
                    if (this.c) {
                    }
                } catch (IOException e9) {
                    e5222 = e9;
                    bpVar2 = null;
                    try {
                        az.a(e5222, "ANRWriter", "initLog");
                        e5222.printStackTrace();
                        if (bpVar2 != null) {
                            try {
                                bpVar2.close();
                            } catch (Throwable e52222) {
                                az.a(e52222, "ANRWriter", "initLog1");
                                e52222.printStackTrace();
                            } catch (Throwable e522222) {
                                az.a(e522222, "ANRWriter", "initLog2");
                                e522222.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e10) {
                                e522222 = e10;
                                az.a(e522222, "ANRWriter", "initLog3");
                                iOException.printStackTrace();
                                if (this.c) {
                                }
                            } catch (Throwable th3) {
                                e522222 = th3;
                                az.a(e522222, "ANRWriter", "initLog4");
                                e522222.printStackTrace();
                                if (this.c) {
                                }
                            }
                        }
                        if (this.c) {
                        }
                    } catch (Throwable th4) {
                        e522222 = th4;
                        if (bpVar2 != null) {
                            try {
                                bpVar2.close();
                            } catch (Throwable e11) {
                                az.a(e11, "ANRWriter", "initLog1");
                                e11.printStackTrace();
                            } catch (Throwable e112) {
                                az.a(e112, "ANRWriter", "initLog2");
                                e112.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e1122) {
                                az.a(e1122, "ANRWriter", "initLog3");
                                e1122.printStackTrace();
                            } catch (Throwable e11222) {
                                az.a(e11222, "ANRWriter", "initLog4");
                                e11222.printStackTrace();
                            }
                        }
                        throw e522222;
                    }
                } catch (Throwable th5) {
                    e522222 = th5;
                    bpVar2 = null;
                    if (bpVar2 != null) {
                        bpVar2.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e522222;
                }
                if (this.c) {
                }
            }
            if (null != null) {
                try {
                    bpVar2.close();
                } catch (Throwable e12) {
                    az.a(e12, "ANRWriter", "initLog1");
                    e12.printStackTrace();
                } catch (Throwable e122) {
                    az.a(e122, "ANRWriter", "initLog2");
                    e122.printStackTrace();
                }
            }
            if (null != null) {
                try {
                    inputStream2.close();
                } catch (Throwable e5222222) {
                    az.a(e5222222, "ANRWriter", "initLog3");
                    e5222222.printStackTrace();
                } catch (Throwable e52222222) {
                    az.a(e52222222, "ANRWriter", "initLog4");
                    e52222222.printStackTrace();
                }
            }
            return null;
        } catch (FileNotFoundException e13) {
            bpVar = null;
            inputStream = null;
            if (bpVar != null) {
                bpVar.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (this.c) {
            }
        } catch (IOException e14) {
            e52222222 = e14;
            bpVar2 = null;
            fileInputStream = null;
            az.a(e52222222, "ANRWriter", "initLog");
            e52222222.printStackTrace();
            if (bpVar2 != null) {
                bpVar2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (this.c) {
            }
        } catch (Throwable th6) {
            e52222222 = th6;
            bpVar2 = null;
            fileInputStream = null;
            if (bpVar2 != null) {
                bpVar2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e52222222;
        }
    }

    protected String b() {
        return bg.d;
    }
}
