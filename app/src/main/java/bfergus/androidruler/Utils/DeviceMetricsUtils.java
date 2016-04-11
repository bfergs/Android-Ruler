package bfergus.androidruler.Utils;


import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.text.DecimalFormat;

import bfergus.androidruler.AndroidRulerApplication;

public class DeviceMetricsUtils {

    public static String getTouchLocationString(float eventX) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) AndroidRulerApplication.getsInstance().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        return doubleToString(eventX/metrics.xdpi);

    }

    private static String doubleToString(double d) {
        DecimalFormat twoDFormat = new DecimalFormat("#.##"); //converts double to two decimal places
        return Double.valueOf(twoDFormat.format(d)).toString();
    }

}
