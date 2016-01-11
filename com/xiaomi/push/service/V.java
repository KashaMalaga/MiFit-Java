package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.channel.a.b.c;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class V {
    private static final Pattern a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");
    private static ThreadPoolExecutor b = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static void a() {
        if (b.getActiveCount() <= 0) {
            b.execute(new W());
        }
    }

    private static void b(String str) {
        Process exec;
        Throwable e;
        BufferedReader bufferedReader = null;
        c.a("Network Checkup: Begin to ping " + str);
        try {
            BufferedReader bufferedReader2;
            exec = Runtime.getRuntime().exec(String.format("ping -W 500 -i 0.2 -c 3 %s", new Object[]{str}));
            try {
                bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            } catch (IOException e2) {
                e = e2;
                try {
                    c.a(e);
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                    }
                    if (exec == null) {
                        exec.destroy();
                    }
                } catch (Throwable th) {
                    e = th;
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                    }
                    if (exec != null) {
                        exec.destroy();
                    }
                    throw e;
                }
            } catch (Exception e5) {
                e = e5;
                c.a(e);
                try {
                    bufferedReader.close();
                } catch (IOException e6) {
                }
                if (exec == null) {
                    exec.destroy();
                }
            }
            try {
                for (String readLine = bufferedReader2.readLine(); readLine != null; readLine = bufferedReader2.readLine()) {
                    c.a("Network Checkup:" + readLine);
                }
                exec.waitFor();
                try {
                    bufferedReader2.close();
                } catch (IOException e7) {
                }
                if (exec != null) {
                    exec.destroy();
                }
            } catch (IOException e8) {
                e = e8;
                bufferedReader = bufferedReader2;
                c.a(e);
                bufferedReader.close();
                if (exec == null) {
                    exec.destroy();
                }
            } catch (Exception e9) {
                e = e9;
                bufferedReader = bufferedReader2;
                c.a(e);
                bufferedReader.close();
                if (exec == null) {
                    exec.destroy();
                }
            } catch (Throwable th2) {
                e = th2;
                bufferedReader = bufferedReader2;
                bufferedReader.close();
                if (exec != null) {
                    exec.destroy();
                }
                throw e;
            }
        } catch (IOException e10) {
            e = e10;
            exec = null;
            c.a(e);
            bufferedReader.close();
            if (exec == null) {
                exec.destroy();
            }
        } catch (Exception e11) {
            e = e11;
            exec = null;
            c.a(e);
            bufferedReader.close();
            if (exec == null) {
                exec.destroy();
            }
        } catch (Throwable th3) {
            e = th3;
            exec = null;
            bufferedReader.close();
            if (exec != null) {
                exec.destroy();
            }
            throw e;
        }
    }

    private static String c() {
        Process exec;
        BufferedReader bufferedReader;
        Throwable th;
        Throwable e;
        String str;
        Throwable th2;
        String str2 = null;
        try {
            exec = Runtime.getRuntime().exec("ip route");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            } catch (Throwable e2) {
                bufferedReader = null;
                th = e2;
                str = null;
                th2 = th;
                try {
                    c.a(th2);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (exec != null) {
                        exec.destroy();
                    }
                    return str;
                } catch (Throwable th3) {
                    e2 = th3;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                        }
                    }
                    if (exec != null) {
                        exec.destroy();
                    }
                    throw e2;
                }
            } catch (Throwable e22) {
                bufferedReader = null;
                th = e22;
                str = null;
                th2 = th;
                c.a(th2);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                    }
                }
                if (exec != null) {
                    exec.destroy();
                }
                return str;
            } catch (Throwable th4) {
                e22 = th4;
                bufferedReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (exec != null) {
                    exec.destroy();
                }
                throw e22;
            }
            try {
                str = bufferedReader.readLine();
                if (TextUtils.isEmpty(str) || !str.startsWith("default via")) {
                    str = null;
                } else {
                    String[] split = str.split(" ");
                    int length = split.length;
                    int i = 0;
                    while (i < length) {
                        try {
                            CharSequence charSequence = split[i];
                            if (!a.matcher(charSequence).matches()) {
                                Object obj = str2;
                            }
                            i++;
                            CharSequence charSequence2 = charSequence;
                        } catch (Throwable e222) {
                            th = e222;
                            str = str2;
                            th2 = th;
                        } catch (Throwable e2222) {
                            th = e2222;
                            str = str2;
                            th2 = th;
                        }
                    }
                    exec.waitFor();
                    str = str2;
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                    }
                }
                if (exec != null) {
                    exec.destroy();
                }
            } catch (Throwable e22222) {
                th = e22222;
                str = null;
                th2 = th;
                c.a(th2);
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (exec != null) {
                    exec.destroy();
                }
                return str;
            } catch (Throwable e222222) {
                th = e222222;
                str = null;
                th2 = th;
                c.a(th2);
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (exec != null) {
                    exec.destroy();
                }
                return str;
            }
        } catch (Throwable e2222222) {
            exec = null;
            bufferedReader = null;
            th = e2222222;
            str = null;
            th2 = th;
            c.a(th2);
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (exec != null) {
                exec.destroy();
            }
            return str;
        } catch (Throwable e22222222) {
            exec = null;
            bufferedReader = null;
            th = e22222222;
            str = null;
            th2 = th;
            c.a(th2);
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (exec != null) {
                exec.destroy();
            }
            return str;
        } catch (Throwable th5) {
            e22222222 = th5;
            exec = null;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (exec != null) {
                exec.destroy();
            }
            throw e22222222;
        }
        return str;
    }
}
