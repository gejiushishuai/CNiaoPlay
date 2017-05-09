package com.chhd.per_library.util;

import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;

/**
 * Created by Andy on 2016/10/31.
 */

public class ShakeUitl {

    private ShakeUitl() {
    }

    public static void on(View view) {
        TranslateAnimation animation = new TranslateAnimation(0, UiUtil.dp2px(3), 0, 0);
        animation.setDuration(500);
        animation.setInterpolator(new CycleInterpolator(3));
        view.startAnimation(animation);
    }
}
