package entity;

import android.content.Intent;

/**
 * 作者：wangchen on 2017/11/13 10:08
 * 邮箱：wangchen0338@163.com
 */
public class EventBusBean
{
    private Intent intent;

    public EventBusBean ()
    {
        super();
    }

    public EventBusBean(Intent intent)
    {
        super();
        this.intent = intent;
    }
    public Intent getIntent()
    {
        return intent;
    }

    public void setIntent(Intent intent)
    {
        this.intent = intent;
    }


}
