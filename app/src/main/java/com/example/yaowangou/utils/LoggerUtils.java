package com.example.yaowangou.utils;

import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2017/4/19/019.
 */

public class LoggerUtils {

    public static int LOGGER_V = 1;
    public static int LOGGER_D = 2;
    public static int LOGGER_I = 3;
    public static int LOGGER_W = 4;
    public static int LOGGER_E = 5;
    public static int LOGGER_NO_MESSEGE = 6;

    public static void V(String messege) {
        if (LOGGER_NO_MESSEGE <= 1) {
            Logger.v(messege);
        }
    }

    public static void V2(String messege, Object... o) {
        if (LOGGER_NO_MESSEGE <= 1) {
            Logger.v(messege, o);
        }
    }

    public static void D(String messege) {
        if (LOGGER_NO_MESSEGE <= 2) {
            Logger.d(messege);
        }
    }

    public static void D2(String messege, Object... objects) {
        if (LOGGER_NO_MESSEGE <= 2) {
            Logger.d(messege, objects);
        }
    }

    public static void I(String messege) {
        if (LOGGER_NO_MESSEGE <= 3) {
            Logger.i(messege);
        }
    }

    public static void I2(String messege,Object... objects) {
        if (LOGGER_NO_MESSEGE <= 3) {
            Logger.w(messege,objects);
        }
    }

    public static void W(String messege,Object... objects) {
        if (LOGGER_NO_MESSEGE <= 4) {
            Logger.w(messege,objects);
        }
    }

    public static void E(String messege) {
        if (LOGGER_NO_MESSEGE <= 5) {
            Logger.e(messege);
        }
    }

    public static void E2(String messege,Object... objects) {
        if (LOGGER_NO_MESSEGE <= 5) {
            Logger.e(messege,objects);
        }
    }

}
