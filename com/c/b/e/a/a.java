package com.c.b.e.a;

import a.a.a.B;
import android.support.v4.media.h;
import android.support.v4.view.a.C0113o;
import cn.com.smartdevices.bracelet.Constant;
import cn.com.smartdevices.bracelet.eventbus.weight.EventScaleStatus;
import cn.com.smartdevices.bracelet.gps.model.RunningReminderInfo;
import cn.com.smartdevices.bracelet.gps.services.I;
import cn.com.smartdevices.bracelet.honor.a.d;
import cn.com.smartdevices.bracelet.j.n;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.ui.BaseActivity;
import cn.com.smartdevices.bracelet.ui.MainUIActivity;
import cn.com.smartdevices.bracelet.upgrade.i;
import cn.com.smartdevices.bracelet.weight.WeightGoalSetActivity;
import com.c.b.c.b;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.huami.android.widget.share.m;
import com.sina.weibo.sdk.constant.WBConstants;
import com.xiaomi.channel.b.v;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

final class a {
    private static final int[][] a = new int[][]{new int[]{121, 120, h.j, h.i, 133, 132, 139, 138, 145, 144, 151, kankan.wheel.widget.a.ap, 157, 156, 163, 162, 169, 168, 175, 174, 181, cn.com.smartdevices.bracelet.gps.c.a.i, 187, 186, 193, 192, 199, 198, -2, -2}, new int[]{123, 122, 129, C0113o.h, 135, 134, 141, 140, 147, 146, 153, 152, 159, 158, 165, 164, 171, kankan.wheel.widget.a.aC, 177, 176, 183, 182, 189, 188, 195, 194, v.D, v.C, 816, -3}, new int[]{125, 124, 131, h.k, 137, 136, 143, 142, 149, 148, 155, 154, 161, 160, 167, 166, 173, 172, 179, 178, 185, 184, 191, 190, 197, 196, 203, 202, 818, 817}, new int[]{283, 282, 277, 276, 271, 270, i.c, i.b, 259, PersonInfo.INCOMING_CALL_DEFAULT, 253, 252, 247, 246, 241, RunningReminderInfo.b, 235, 234, 229, 228, 223, 222, 217, 216, 211, 210, 205, 204, 819, -3}, new int[]{285, 284, 279, 278, cn.com.smartdevices.bracelet.weight.family.h.d, WeightGoalSetActivity.c, 267, 266, 261, 260, HeartRateInfo.HR_EMPTY_VALUE, HeartRateInfo.NO_HR_VALUE, 249, 248, 243, 242, 237, 236, 231, kankan.wheel.widget.a.an, 225, 224, 219, 218, 213, 212, 207, 206, 821, 820}, new int[]{287, 286, 281, 280, 275, 274, 269, 268, i.a, 262, EventScaleStatus.SCALE_FOUNDED, PersonInfo.INCOMING_CALL_DISABLE_BIT, 251, 250, 245, 244, com.xiaomi.hm.health.bt.profile.a.a.ac, 238, 233, 232, 227, 226, HeartRateInfo.MAX_HR_VALUE, cn.com.smartdevices.bracelet.gps.c.a.f, 215, 214, 209, 208, 822, -3}, new int[]{289, 288, 295, 294, 301, m.n, 307, 306, 313, 312, 319, 318, PullToRefreshBase.SMOOTH_SCROLL_LONG_DURATION_MS, 324, 331, 330, 337, 336, 343, 342, 349, 348, 355, 354, 361, cn.com.smartdevices.bracelet.gps.c.a.e, 367, 366, 824, 823}, new int[]{291, 290, 297, 296, 303, 302, 309, 308, 315, 314, 321, kankan.wheel.widget.a.by, 327, 326, 333, 332, 339, 338, 345, 344, 351, 350, 357, 356, 363, 362, 369, 368, 825, -3}, new int[]{293, 292, 299, 298, 305, 304, 311, 310, 317, 316, 323, 322, 329, 328, 335, 334, 341, 340, 347, 346, 353, 352, 359, 358, 365, 364, 371, 370, 827, 826}, new int[]{409, 408, 403, 402, 397, 396, 391, 390, 79, 78, -2, -2, 13, 12, 37, 36, 2, -1, 44, 43, 109, 108, 385, 384, 379, 378, 373, 372, 828, -3}, new int[]{411, 410, 405, 404, 399, 398, 393, 392, 81, 80, 40, -2, 15, 14, 39, 38, 3, -1, -1, 45, 111, 110, 387, 386, 381, 380, 375, 374, 830, 829}, new int[]{413, 412, 407, 406, 401, 400, 395, 394, 83, 82, 41, -3, -3, -3, -3, -3, 5, 4, 47, 46, 113, 112, 389, 388, 383, 382, 377, 376, 831, -3}, new int[]{415, 414, 421, 420, 427, 426, ShareData.SHARE_TYPE_LAB_SITUP_ACCUMULATE, ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD, 55, 54, 16, -3, -3, -3, -3, -3, -3, -3, 20, 19, 85, 84, 433, 432, 439, 438, 445, 444, 833, 832}, new int[]{417, 416, 423, 422, 429, 428, B.n, d.e, 57, 56, -3, -3, -3, -3, -3, -3, -3, -3, 22, 21, 87, 86, 435, 434, 441, BaseActivity.MI_NOTE_ORIGINAL_DPI, 447, 446, 834, -3}, new int[]{419, 418, 425, 424, 431, 430, B.p, B.o, 59, 58, -3, -3, -3, -3, -3, -3, -3, -3, -3, 23, 89, 88, 437, 436, 443, 442, 449, 448, 836, 835}, new int[]{481, kankan.wheel.widget.a.ax, 475, 474, 469, 468, 48, -2, 30, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 0, 53, 52, 463, 462, 457, 456, 451, 450, 837, -3}, new int[]{483, 482, 477, 476, 471, 470, 49, -1, -2, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -2, -1, 465, 464, 459, 458, 453, 452, 839, 838}, new int[]{485, 484, 479, 478, 473, 472, 51, 50, 31, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 1, -2, 42, 467, 466, 461, kankan.wheel.widget.a.aA, 455, 454, 840, -3}, new int[]{487, 486, 493, 492, 499, 498, 97, 96, 61, 60, -3, -3, -3, -3, -3, -3, -3, -3, -3, 26, 91, 90, 505, 504, 511, 510, 517, 516, 842, 841}, new int[]{489, 488, 495, 494, 501, kankan.wheel.widget.a.aB, 99, 98, 63, 62, -3, -3, -3, -3, -3, -3, -3, -3, 28, 27, 93, 92, 507, 506, 513, C0113o.j, 519, 518, 843, -3}, new int[]{491, 490, 497, 496, 503, 502, ShareData.SHARE_TYPE_LAB_ROPE_SKIPPING_ACCUMULATE, 100, 65, 64, 17, -3, -3, -3, -3, -3, -3, -3, 18, 29, 95, 94, 509, 508, 515, 514, 521, MainUIActivity.c, 845, 844}, new int[]{559, 558, 553, 552, 547, I.d, 541, 540, 73, 72, 32, -3, -3, -3, -3, -3, -3, 10, 67, 66, 115, 114, 535, 534, 529, 528, 523, 522, 846, -3}, new int[]{561, 560, 555, 554, 549, 548, 543, 542, 75, 74, -2, -1, 7, 6, 35, 34, 11, -2, 69, 68, 117, 116, 537, 536, 531, 530, 525, 524, 848, 847}, new int[]{563, 562, 557, 556, 551, cn.com.smartdevices.bracelet.chart.util.a.h, 545, WeightGoalSetActivity.d, 77, 76, -2, 33, 9, 8, 25, 24, -1, -2, 71, 70, 119, 118, 539, 538, 533, 532, 527, 526, 849, -3}, new int[]{565, 564, 571, 570, 577, 576, 583, 582, 589, 588, 595, 594, 601, cn.com.smartdevices.bracelet.chart.util.a.b, 607, 606, 613, 612, 619, 618, 625, 624, 631, 630, 637, 636, 643, 642, 851, 850}, new int[]{567, 566, 573, 572, 579, 578, 585, 584, 591, 590, 597, 596, 603, 602, 609, 608, 615, 614, 621, 620, 627, 626, 633, 632, 639, 638, 645, 644, 852, -3}, new int[]{569, 568, 575, 574, 581, 580, 587, 586, 593, 592, 599, 598, 605, 604, 611, 610, 617, 616, 623, 622, 629, 628, 635, Constant.at, 641, 640, 647, 646, 854, 853}, new int[]{727, 726, 721, 720, 715, 714, 709, 708, 703, 702, 697, 696, 691, 690, 685, 684, 679, 678, 673, 672, 667, n.e, 661, 660, 655, 654, 649, 648, 855, -3}, new int[]{729, 728, 723, 722, 717, 716, 711, 710, 705, 704, 699, 698, 693, 692, 687, 686, 681, 680, 675, 674, 669, 668, 663, 662, 657, 656, 651, cn.com.smartdevices.bracelet.chart.util.a.g, 857, 856}, new int[]{731, 730, 725, 724, 719, 718, 713, 712, 707, 706, 701, 700, 695, 694, 689, 688, 683, 682, 677, 676, 671, 670, 665, 664, 659, 658, 653, 652, 858, -3}, new int[]{733, 732, 739, 738, 745, 744, 751, 750, 757, 756, 763, 762, 769, 768, 775, 774, 781, 780, 787, 786, 793, 792, 799, 798, 805, 804, 811, 810, 860, 859}, new int[]{735, 734, 741, 740, 747, 746, 753, 752, 759, 758, WBConstants.SDK_ACTIVITY_FOR_RESULT_CODE, 764, 771, 770, 777, 776, 783, 782, 789, 788, 795, 794, 801, cn.com.smartdevices.bracelet.chart.util.a.d, 807, 806, 813, 812, 861, -3}, new int[]{737, 736, 743, 742, 749, 748, 755, 754, 761, 760, 767, 766, 773, 772, 779, 778, 785, 784, 791, 790, 797, 796, 803, 802, 809, 808, 815, 814, 863, 862}};
    private final b b;

    a(b bVar) {
        this.b = bVar;
    }

    byte[] a() {
        byte[] bArr = new byte[144];
        int g = this.b.g();
        int f = this.b.f();
        int i = 0;
        while (i < g) {
            int[] iArr = a[i];
            int i2 = 0;
            while (i2 < f) {
                int i3 = iArr[i2];
                if (i3 >= 0 && this.b.a(i2, i)) {
                    int i4 = i3 / 6;
                    bArr[i4] = (byte) (((byte) (1 << (5 - (i3 % 6)))) | bArr[i4]);
                }
                i2++;
            }
            i++;
        }
        return bArr;
    }
}
