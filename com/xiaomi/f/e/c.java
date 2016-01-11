package com.xiaomi.f.e;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.lab.sportmode.GroupItemBaseInfo;
import cn.com.smartdevices.bracelet.partner.NativeInterface;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import cn.com.smartdevices.bracelet.tencent.QQLogin;
import com.amap.api.location.LocationManagerProxy;
import com.huami.android.widget.f;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.xiaomi.account.openauth.h;
import com.xiaomi.f.c.a;
import com.xiaomi.f.c.b;
import com.xiaomi.f.c.d;
import com.xiaomi.f.c.e;
import com.xiaomi.f.c.g;
import com.xiaomi.f.c.i;
import com.xiaomi.f.c.j;
import com.xiaomi.f.c.k;
import com.xiaomi.f.l;
import com.xiaomi.f.y;
import com.xiaomi.f.z;
import com.xiaomi.push.service.C1149o;
import com.xiaomi.push.service.D;
import com.xiaomi.push.service.X;
import com.xiaomi.push.service.Z;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class c {
    private static XmlPullParser a = null;

    public static a a(String str, String str2, XmlPullParser xmlPullParser) {
        Object a = com.xiaomi.f.d.c.a().a(QQLogin.PERMISSION_ALL, "xm:chat");
        return (a == null || !(a instanceof D)) ? null : ((D) a).b(xmlPullParser);
    }

    public static b a(XmlPullParser xmlPullParser, l lVar) {
        String attributeValue = xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, SyncShoesDataService.d);
        String attributeValue2 = xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, "to");
        String attributeValue3 = xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, QQLogin.KEY_FROM);
        String attributeValue4 = xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, "chid");
        com.xiaomi.f.c.c a = com.xiaomi.f.c.c.a(xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, SocialConstants.PARAM_TYPE));
        Object obj = null;
        k kVar = null;
        b bVar = null;
        while (obj == null) {
            Object obj2;
            b bVar2;
            k kVar2;
            Object obj3;
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals(h.P)) {
                    kVar = e(xmlPullParser);
                } else {
                    bVar = new b();
                    bVar.a(a(name, namespace, xmlPullParser));
                }
                obj2 = obj;
                bVar2 = bVar;
                kVar2 = kVar;
                obj3 = obj2;
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                bVar2 = bVar;
                kVar2 = kVar;
                int i = 1;
            } else {
                obj2 = obj;
                bVar2 = bVar;
                kVar2 = kVar;
                obj3 = obj2;
            }
            obj2 = obj3;
            kVar = kVar2;
            bVar = bVar2;
            obj = obj2;
        }
        if (bVar == null) {
            if (com.xiaomi.f.c.c.a == a || com.xiaomi.f.c.c.b == a) {
                e dVar = new d();
                dVar.k(attributeValue);
                dVar.m(attributeValue3);
                dVar.n(attributeValue2);
                dVar.a(com.xiaomi.f.c.c.d);
                dVar.l(attributeValue4);
                dVar.a(new k(com.xiaomi.f.c.l.e));
                lVar.a(dVar);
                com.xiaomi.channel.a.b.c.c("iq usage error. send packet in packet parser.");
                return null;
            }
            bVar = new e();
        }
        bVar.k(attributeValue);
        bVar.m(attributeValue2);
        bVar.l(attributeValue4);
        bVar.n(attributeValue3);
        bVar.a(a);
        bVar.a(kVar);
        return bVar;
    }

    public static e a(XmlPullParser xmlPullParser) {
        String attributeValue;
        boolean z;
        if (Constants.VIA_TO_TYPE_QQ_GROUP.equals(xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, GroupItemBaseInfo.KEY_START_TIME))) {
            attributeValue = xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, "chid");
            String attributeValue2 = xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, SyncShoesDataService.d);
            String attributeValue3 = xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, QQLogin.KEY_FROM);
            String attributeValue4 = xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, "to");
            String attributeValue5 = xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, SocialConstants.PARAM_TYPE);
            Z b = X.a().b(attributeValue, attributeValue4);
            Z b2 = b == null ? X.a().b(attributeValue, attributeValue3) : b;
            if (b2 == null) {
                throw new com.xiaomi.f.D("the channel id is wrong while receiving a encrypted message");
            }
            z = false;
            e eVar = null;
            while (!z) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    if (!GroupItemBaseInfo.KEY_START_TIME.equals(xmlPullParser.getName())) {
                        throw new com.xiaomi.f.D("error while receiving a encrypted message with wrong format");
                    } else if (xmlPullParser.next() != 4) {
                        throw new com.xiaomi.f.D("error while receiving a encrypted message with wrong format");
                    } else {
                        String text = xmlPullParser.getText();
                        if (Constants.VIA_SHARE_TYPE_TEXT.equals(attributeValue) || Constants.VIA_SHARE_TYPE_INFO.equals(attributeValue)) {
                            eVar = new d();
                            eVar.l(attributeValue);
                            eVar.b(true);
                            eVar.n(attributeValue3);
                            eVar.m(attributeValue4);
                            eVar.k(attributeValue2);
                            eVar.f(attributeValue5);
                            a aVar = new a(GroupItemBaseInfo.KEY_START_TIME, null, (String[]) null, (String[]) null);
                            aVar.b(text);
                            eVar.a(aVar);
                            return eVar;
                        }
                        a(C1149o.b(C1149o.a(b2.i, attributeValue2), text));
                        a.next();
                        eVar = a(a);
                    }
                } else if (next == 3 && xmlPullParser.getName().equals(f.a)) {
                    z = true;
                }
            }
            if (eVar != null) {
                return eVar;
            }
            throw new com.xiaomi.f.D("error while receiving a encrypted message with wrong format");
        }
        Object attributeValue6;
        Object attributeValue7;
        e dVar = new d();
        String attributeValue8 = xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, SyncShoesDataService.d);
        if (attributeValue8 == null) {
            attributeValue8 = "ID_NOT_AVAILABLE";
        }
        dVar.k(attributeValue8);
        dVar.m(xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, "to"));
        dVar.n(xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, QQLogin.KEY_FROM));
        dVar.l(xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, "chid"));
        dVar.a(xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, SocialConstants.PARAM_APP_ID));
        try {
            attributeValue6 = xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, "transient");
        } catch (Exception e) {
            attributeValue6 = null;
        }
        try {
            attributeValue = xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, "seq");
            if (!TextUtils.isEmpty(attributeValue)) {
                dVar.b(attributeValue);
            }
        } catch (Exception e2) {
        }
        try {
            attributeValue7 = xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, "mseq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                dVar.c(attributeValue7);
            }
        } catch (Exception e3) {
        }
        try {
            attributeValue7 = xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, "fseq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                dVar.d(attributeValue7);
            }
        } catch (Exception e4) {
        }
        try {
            attributeValue7 = xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, LocationManagerProxy.KEY_STATUS_CHANGED);
            if (!TextUtils.isEmpty(attributeValue7)) {
                dVar.e(attributeValue7);
            }
        } catch (Exception e5) {
        }
        z = !TextUtils.isEmpty(attributeValue6) && attributeValue6.equalsIgnoreCase("true");
        dVar.a(z);
        dVar.f(xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, SocialConstants.PARAM_TYPE));
        attributeValue8 = g(xmlPullParser);
        if (attributeValue8 == null || com.xiaomi.e.a.f.equals(attributeValue8.trim())) {
            e.u();
        } else {
            dVar.j(attributeValue8);
        }
        attributeValue8 = null;
        boolean z2 = false;
        while (!z2) {
            int next2 = xmlPullParser.next();
            if (next2 == 2) {
                attributeValue = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (TextUtils.isEmpty(namespace)) {
                    namespace = "xm";
                }
                if (attributeValue.equals("subject")) {
                    if (g(xmlPullParser) == null) {
                        dVar.g(f(xmlPullParser));
                    } else {
                        dVar.g(f(xmlPullParser));
                    }
                } else if (attributeValue.equals("body")) {
                    Object attributeValue9 = xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, "encode");
                    attributeValue = f(xmlPullParser);
                    if (TextUtils.isEmpty(attributeValue9)) {
                        dVar.h(attributeValue);
                    } else {
                        dVar.a(attributeValue, attributeValue9);
                    }
                } else if (attributeValue.equals("thread")) {
                    if (attributeValue8 == null) {
                        attributeValue8 = xmlPullParser.nextText();
                    }
                } else if (attributeValue.equals(h.P)) {
                    dVar.a(e(xmlPullParser));
                } else {
                    dVar.a(a(attributeValue, namespace, xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals(f.a)) {
                z2 = true;
            }
        }
        dVar.i(attributeValue8);
        return dVar;
    }

    private static void a(byte[] bArr) {
        if (a == null) {
            try {
                a = XmlPullParserFactory.newInstance().newPullParser();
                a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
        }
        a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
    }

    public static g b(XmlPullParser xmlPullParser) {
        i iVar = i.available;
        String attributeValue = xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, SocialConstants.PARAM_TYPE);
        if (!(attributeValue == null || attributeValue.equals(com.xiaomi.e.a.f))) {
            try {
                iVar = i.valueOf(attributeValue);
            } catch (IllegalArgumentException e) {
                System.err.println("Found invalid presence type " + attributeValue);
            }
        }
        g gVar = new g(iVar);
        gVar.m(xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, "to"));
        gVar.n(xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, QQLogin.KEY_FROM));
        gVar.l(xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, SyncShoesDataService.d);
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        gVar.k(attributeValue2);
        int i = 0;
        while (i == 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals(LocationManagerProxy.KEY_STATUS_CHANGED)) {
                    gVar.a(xmlPullParser.nextText());
                } else if (name.equals("priority")) {
                    try {
                        gVar.a(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException e2) {
                    } catch (IllegalArgumentException e3) {
                        gVar.a(0);
                    }
                } else if (name.equals("show")) {
                    name = xmlPullParser.nextText();
                    try {
                        gVar.a(com.xiaomi.f.c.h.valueOf(name));
                    } catch (IllegalArgumentException e4) {
                        System.err.println("Found invalid presence mode " + name);
                    }
                } else if (name.equals(h.P)) {
                    gVar.a(e(xmlPullParser));
                } else {
                    gVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                i = 1;
            }
        }
        return gVar;
    }

    public static y c(XmlPullParser xmlPullParser) {
        y yVar = new y();
        String attributeValue = xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, SyncShoesDataService.d);
        String attributeValue2 = xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, "to");
        String attributeValue3 = xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, QQLogin.KEY_FROM);
        String attributeValue4 = xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, "chid");
        z a = z.a(xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, SocialConstants.PARAM_TYPE));
        yVar.k(attributeValue);
        yVar.m(attributeValue2);
        yVar.n(attributeValue3);
        yVar.l(attributeValue4);
        yVar.a(a);
        Object obj = null;
        k kVar = null;
        while (obj == null) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals(h.P)) {
                    kVar = e(xmlPullParser);
                }
            } else if (next == 3 && xmlPullParser.getName().equals(NativeInterface.BIND)) {
                obj = 1;
            }
        }
        yVar.a(kVar);
        return yVar;
    }

    public static j d(XmlPullParser xmlPullParser) {
        j jVar = null;
        Object obj = null;
        while (obj == null) {
            int next = xmlPullParser.next();
            if (next == 2) {
                jVar = new j(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals(h.P)) {
                obj = 1;
            }
        }
        return jVar;
    }

    public static k e(XmlPullParser xmlPullParser) {
        String attributeValue;
        String attributeValue2;
        String str = "urn:ietf:params:xml:ns:xmpp-stanzas";
        str = WeiboAuthException.DEFAULT_AUTH_ERROR_CODE;
        List arrayList = new ArrayList();
        String str2 = null;
        String str3 = null;
        String str4 = str;
        int i = 0;
        while (i < xmlPullParser.getAttributeCount()) {
            attributeValue = xmlPullParser.getAttributeName(i).equals(com.xiaomi.channel.gamesdk.b.a) ? xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, com.xiaomi.channel.gamesdk.b.a) : str4;
            attributeValue2 = xmlPullParser.getAttributeName(i).equals(SocialConstants.PARAM_TYPE) ? xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, SocialConstants.PARAM_TYPE) : str3;
            if (xmlPullParser.getAttributeName(i).equals("reason")) {
                str2 = xmlPullParser.getAttributeValue(com.xiaomi.e.a.f, "reason");
            }
            i++;
            str3 = attributeValue2;
            str4 = attributeValue;
        }
        Object obj = null;
        attributeValue2 = null;
        attributeValue = null;
        while (obj == null) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("text")) {
                    attributeValue = xmlPullParser.nextText();
                } else {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(namespace)) {
                        attributeValue2 = name;
                    } else {
                        arrayList.add(a(name, namespace, xmlPullParser));
                    }
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals(h.P)) {
                    obj = 1;
                }
            } else if (next == 4) {
                attributeValue = xmlPullParser.getText();
            }
        }
        return new k(Integer.parseInt(str4), str3 == null ? f.b : str3, str2, attributeValue2, attributeValue, arrayList);
    }

    private static String f(XmlPullParser xmlPullParser) {
        String str = com.xiaomi.e.a.f;
        int depth = xmlPullParser.getDepth();
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    private static String g(XmlPullParser xmlPullParser) {
        int i = 0;
        while (i < xmlPullParser.getAttributeCount()) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if ("xml:lang".equals(attributeName) || (cn.com.smartdevices.bracelet.j.f.e.equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i)))) {
                return xmlPullParser.getAttributeValue(i);
            }
            i++;
        }
        return null;
    }
}
