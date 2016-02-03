package com.amap.api.mapcore.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class bk {
    public static String a(long j) {
        String str = null;
        try {
            str = new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS").format(new Date(j));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str;
    }

    static synchronized String a(Throwable th) {
        Writer stringWriter;
        PrintWriter printWriter;
        Throwable th2;
        String str = null;
        synchronized (bk.class) {
            Throwable cause;
            try {
                stringWriter = new StringWriter();
                try {
                    printWriter = new PrintWriter(stringWriter);
                    try {
                        th.printStackTrace(printWriter);
                        for (cause = th.getCause(); cause != null; cause = cause.getCause()) {
                            cause.printStackTrace(printWriter);
                        }
                        str = stringWriter.toString().replaceAll("\n", "<br/>");
                        if (stringWriter != null) {
                            try {
                                stringWriter.close();
                            } catch (Throwable cause2) {
                                cause2.printStackTrace();
                            }
                        }
                        if (printWriter != null) {
                            try {
                                printWriter.close();
                            } catch (Throwable cause22) {
                                cause22.printStackTrace();
                            }
                        }
                    } catch (Throwable th3) {
                        cause22 = th3;
                        try {
                            cause22.printStackTrace();
                            if (stringWriter != null) {
                                try {
                                    stringWriter.close();
                                } catch (Throwable cause222) {
                                    cause222.printStackTrace();
                                }
                            }
                            if (printWriter != null) {
                                try {
                                    printWriter.close();
                                } catch (Throwable cause2222) {
                                    cause2222.printStackTrace();
                                }
                            }
                            return str;
                        } catch (Throwable th4) {
                            th2 = th4;
                            if (stringWriter != null) {
                                try {
                                    stringWriter.close();
                                } catch (Throwable cause22222) {
                                    cause22222.printStackTrace();
                                }
                            }
                            if (printWriter != null) {
                                try {
                                    printWriter.close();
                                } catch (Throwable cause222222) {
                                    cause222222.printStackTrace();
                                }
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable cause2222222) {
                    printWriter = null;
                    th2 = cause2222222;
                    if (stringWriter != null) {
                        stringWriter.close();
                    }
                    if (printWriter != null) {
                        printWriter.close();
                    }
                    throw th2;
                }
            } catch (Throwable cause22222222) {
                printWriter = null;
                stringWriter = null;
                th2 = cause22222222;
                if (stringWriter != null) {
                    stringWriter.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
                throw th2;
            }
        }
        return str;
    }
}
