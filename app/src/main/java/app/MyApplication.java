package app;

import android.app.Application;

/**
 * 作者：wangchen on 2017/11/13 09:29
 * 邮箱：wangchen0338@163.com
 */
public class MyApplication extends Application
{
    private static final String TAG = "MyApplication";
    private static MyApplication mInstance = null;

    @Override
    public void onCreate()
    {
        super.onCreate();
        mInstance = this;
    }

    public synchronized static MyApplication getInstance()
    {
        return mInstance;
    }
}
