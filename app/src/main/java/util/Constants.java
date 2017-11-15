package util;

import android.app.Application;

import com.androidlibrary.R;

import db.DBManager;

/**
 * 作者：wangchen on 2017/11/15 09:24
 * 邮箱：wangchen0338@163.com
 * 全局设置
 */
public class Constants
{
    public static final String FILE_SD = "file://";
    public static final String FILE_HTTP = "http://";
    public static final String FILE_HTTPS = "https://";
    // Image from assets "drawable://" + R.drawable.ic_launcher
    public static final String FILE_DRAWBLE = "drawable://";
    public static final String FILE_CONTENT = "content://";
    public static final String FILE_ASSETS = "assets://";
    // 图片格式
    public static final String IMG_PNG = "png";
    public static final String IMG_JPG = "jpg";
    // 缓存文件夹
    public static final String saveFolder = "wang";
    // 图片缓存文件夹
    public static final String imgCachePath = saveFolder + "/imgs";
    // 视频缓存目录
    public static final String videoCachePath = saveFolder + "/video";
    // 错误日志
    public static final String logCachePath = saveFolder + "/log";
    // 网络缓存
    public static final String httpCachePath = saveFolder + "/http";
    // 图片加载中的图片
    public static int  placeholderImgID  = R.mipmap.ic_launcher;
    // 图片加载错误的图片
    public static int errorImgID = R.mipmap.ic_launcher;

    public static class Config
    {
        public static final int DEVELOPER_MODE = LogUtil.LEVEL;// 是否是发布模式
        public static DBManager DBManager;//数据库操作对象
        public static boolean  IS_WRITE_EXTERNAL_STORAGE = false;//是否有读写磁盘的权限
        public static Application app;//上下文对象
    }
}
