package cn.com.smartdevices.bracelet.chart.util;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import java.util.ArrayList;
import java.util.Iterator;

public class q {
    private static Animator a;
    private static ArrayList<Animator> b = new ArrayList();

    private q() {
    }

    public static AnimatorSet a() {
        AnimatorSet animatorSet = new AnimatorSet();
        Builder play = animatorSet.play(a);
        Iterator it = b.iterator();
        while (it.hasNext()) {
            play.with((Animator) it.next());
        }
        b();
        return animatorSet;
    }

    public static void a(Animator animator) {
        a = animator;
    }

    public static void a(Animator animator, long j) {
        animator.setDuration(j);
        a = animator;
    }

    public static void a(Animator animator, long j, long j2) {
        animator.setStartDelay(j2);
        if (j > 0) {
            animator.setDuration(j);
        }
        b.add(animator);
    }

    private static void b() {
        a = null;
        b.clear();
    }

    public static void b(Animator animator) {
        b.add(animator);
    }

    public static void b(Animator animator, long j) {
        animator.setDuration(j);
        b.add(animator);
    }
}
