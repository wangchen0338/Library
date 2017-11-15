package util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * 作者：wangchen on 2017/11/14 10:11
 * 邮箱：wangchen0338@163.com
 */
public class GlideUtil
{
    public static GlideUtil instance;
    Context mContext;

    private GlideUtil()
    {

    }

    private GlideUtil(Context mContext)
    {
        this.mContext = mContext;
    }


    public static GlideUtil getInstance()
    {
        if(instance == null)
        {
            instance = new GlideUtil();
        }
        return instance;
    }

    /**
     * 加载普通的图片
     * @param url
     * @param imageView
     */
    public void loadImageView(String url, ImageView imageView)
    {
        if (Constants.Config.IS_WRITE_EXTERNAL_STORAGE)
        {
            Glide.with(mContext).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder
                    (Constants.placeholderImgID).error(Constants.errorImgID).into(imageView);
        }
        else
        {
            Glide.with(mContext).load(url).placeholder(Constants.placeholderImgID).error(Constants.errorImgID).into(imageView);
        }
    }

    /**
     * 清除缓存
     */
    public void clearCache()
    {
        clearMemoryCache();
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                clearDiskCache();
            }
        }).start();
    }

    /**
     * 清除内存缓存
     */
    public void clearMemoryCache()
    {
        Glide.get(mContext).clearMemory();
    }

    /**
     * 清除磁盘缓存
     */
    public void clearDiskCache()
    {
        Glide.get(mContext).clearDiskCache();
    }

}
