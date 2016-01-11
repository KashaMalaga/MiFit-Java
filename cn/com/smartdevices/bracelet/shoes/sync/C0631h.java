package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import android.support.v4.media.h;
import cn.com.smartdevices.bracelet.shoes.model.i;
import com.xiaomi.hm.health.bt.model.d;
import com.xiaomi.hm.health.dataprocess.DaySportData;
import com.xiaomi.hm.health.dataprocess.DaySportData.SummaryEntity;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import com.xiaomi.hm.health.dataprocess.SportData;
import java.util.ArrayList;
import java.util.List;

class C0631h {
    private C0631h() {
    }

    private static SportData a(int i, d dVar) {
        int i2;
        int i3 = 0;
        int d = dVar.d();
        int a = dVar.a();
        if (d >= h.k) {
            i2 = 2;
            i3 = -76;
        } else if (d > 15) {
            i2 = 1;
            i3 = 120;
        } else {
            i2 = 0;
        }
        return new SportData(i, ((byte) ((i2 & 15) | ((a & 15) << 4))) & HeartRateInfo.HR_EMPTY_VALUE, i3 & HeartRateInfo.HR_EMPTY_VALUE, d & HeartRateInfo.HR_EMPTY_VALUE);
    }

    private static List<SportData> a(Context context, String str, int i, int i2) {
        if (context == null || i < 0 || i2 > DaySportData.DAY_SPORT_LEN || i > i2) {
            throw new IllegalArgumentException();
        }
        cn.com.smartdevices.bracelet.shoes.model.h a = C0635l.a(context).a(str, null, false);
        if (a == null) {
            return new ArrayList(0);
        }
        List<SportData> arrayList = new ArrayList((i2 - i) + 1);
        while (i <= i2) {
            d a2 = a.a(i);
            if (a2 != null) {
                arrayList.add(C0631h.a(i, a2));
            }
            i++;
        }
        return arrayList;
    }

    public static void a(SummaryEntity summaryEntity, i iVar) {
        if (summaryEntity == null || iVar == null) {
            throw new IllegalArgumentException();
        }
        summaryEntity.setSteps(iVar.l());
        summaryEntity.setStepWalkDuration(iVar.r());
        summaryEntity.setStepRunDuration(iVar.i());
        summaryEntity.setStepDuration(iVar.r());
        summaryEntity.setStepDistance(iVar.c());
        summaryEntity.setStepRunDistance(iVar.g());
        summaryEntity.setStepWalkDistance(iVar.q());
        summaryEntity.setStepCalories(iVar.b());
        summaryEntity.setStepRunCalories(iVar.f());
        summaryEntity.setStepWalkCalories(iVar.p());
        summaryEntity.setDayStepGoal(iVar.e());
    }
}
