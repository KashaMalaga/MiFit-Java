package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Map;

class C0025al {
    C0025al() {
    }

    public static Object a(Object obj) {
        return obj != null ? ((Transition) obj).clone() : obj;
    }

    public static Object a(Object obj, View view, ArrayList<View> arrayList, Map<String, View> map) {
        if (obj == null) {
            return obj;
        }
        C0025al.b((ArrayList) arrayList, view);
        if (map != null) {
            arrayList.removeAll(map.values());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        C0025al.b((Transition) obj, (ArrayList) arrayList);
        return obj;
    }

    public static Object a(Object obj, Object obj2, Object obj3, boolean z) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition == null || transition2 == null) {
            z = true;
        }
        TransitionSet transitionSet;
        if (z) {
            transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.addTransition(transition);
            }
            if (transition2 != null) {
                transitionSet.addTransition(transition2);
            }
            if (transition3 == null) {
                return transitionSet;
            }
            transitionSet.addTransition(transition3);
            return transitionSet;
        }
        Transition transition4 = null;
        if (transition2 != null && transition != null) {
            transition4 = new TransitionSet().addTransition(transition2).addTransition(transition).setOrdering(1);
        } else if (transition2 != null) {
            transition4 = transition2;
        } else if (transition != null) {
            transition4 = transition;
        }
        if (transition3 == null) {
            return transition4;
        }
        transitionSet = new TransitionSet();
        if (transition4 != null) {
            transitionSet.addTransition(transition4);
        }
        transitionSet.addTransition(transition3);
        return transitionSet;
    }

    public static String a(View view) {
        return view.getTransitionName();
    }

    private static void a(Transition transition, C0030aq c0030aq) {
        if (transition != null) {
            transition.setEpicenterCallback(new C0028ao(c0030aq));
        }
    }

    public static void a(View view, View view2, Object obj, ArrayList<View> arrayList, Object obj2, ArrayList<View> arrayList2, Object obj3, ArrayList<View> arrayList3, Object obj4, ArrayList<View> arrayList4, Map<String, View> map) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        Transition transition4 = (Transition) obj4;
        if (transition4 != null) {
            view.getViewTreeObserver().addOnPreDrawListener(new C0029ap(view, transition, view2, arrayList, transition2, arrayList2, transition3, arrayList3, map, arrayList4, transition4));
        }
    }

    public static void a(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public static void a(Object obj, View view) {
        ((Transition) obj).setEpicenterCallback(new C0026am(C0025al.c(view)));
    }

    public static void a(Object obj, View view, boolean z) {
        ((Transition) obj).excludeTarget(view, z);
    }

    public static void a(Object obj, Object obj2, View view, ar arVar, View view2, C0030aq c0030aq, Map<String, String> map, ArrayList<View> arrayList, Map<String, View> map2, ArrayList<View> arrayList2) {
        if (obj != null || obj2 != null) {
            Transition transition = (Transition) obj;
            if (transition != null) {
                transition.addTarget(view2);
            }
            if (obj2 != null) {
                C0025al.b((Transition) obj2, (ArrayList) arrayList2);
            }
            if (arVar != null) {
                view.getViewTreeObserver().addOnPreDrawListener(new C0027an(view, arVar, map, map2, transition, arrayList));
            }
            C0025al.a(transition, c0030aq);
        }
    }

    public static void a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            transition.removeTarget((View) arrayList.get(i));
        }
    }

    public static void a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    C0025al.a((Map) map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public static void b(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            transition.addTarget((View) arrayList.get(i));
        }
    }

    private static void b(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.isTransitionGroup()) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                C0025al.b((ArrayList) arrayList, viewGroup.getChildAt(i));
            }
            return;
        }
        arrayList.add(view);
    }

    private static Rect c(View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        return rect;
    }
}
