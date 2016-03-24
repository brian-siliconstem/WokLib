package com.siliconstem.wok.woklib;

/**
 * Created by HP ENVY on 3/23/2016.
 */
public class Util {
    public static String getMethodName()
    {
        //String[] parts=Thread.currentThread().getStackTrace()[3].getMethodName().split(".");
        //return parts[parts.length-1];
        return getMethodName(1);

        //int depth=0;
        //final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        //return ste[ste.length - 1 - depth].getMethodName();
    }
    public static String getMethodName(int d)
    {
        //String[] parts=Thread.currentThread().getStackTrace()[3].getMethodName().split(".");
        //return parts[parts.length-1];
        return Thread.currentThread().getStackTrace()[3+d].getMethodName();

        //int depth=0;
        //final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        //return ste[ste.length - 1 - depth].getMethodName();
    }
}
