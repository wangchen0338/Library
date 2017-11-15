package app;

import android.app.Application;

import db.DBManager;
import util.Constants;

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
        Constants.Config.app = this;//框架用到上下文对象
        Constants.Config.DBManager = DBManager.getInstance(mInstance,"wang.db",true);

    }

    public synchronized static MyApplication getInstance()
    {
        return mInstance;
    }
}
