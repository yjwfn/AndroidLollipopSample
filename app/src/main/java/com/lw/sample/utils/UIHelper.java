package com.lw.sample.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.lw.sample.transitions.SceneActivity;

/**
 * Created by yjwfn on 16-3-14.
 */
public class UIHelper {

    public static void startSceneActivity(Context context){
        startActivity(context, SceneActivity.class);
    }

    public static void startActivity(Context context, Class<? extends Activity> clz){
        ComponentName componentName = new ComponentName(context, clz);
        Intent  intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.setComponent(componentName);
        context.startActivity(intent);
    }


    public static boolean   sdkCompare(int min){
            return Build.VERSION.SDK_INT >= min;
    }
}
