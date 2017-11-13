package base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import app.MyApplication;
import entity.EventBusBean;
import util.StringUtils;
import util.TipToast;
import view.ConfirmCancelUtilDialog;

/**
 * 作者：wangchen on 2017/11/9 16:10
 * 邮箱：wangchen0338@163.com
 * Activity基类
 */
public abstract class BaseActivity extends AppCompatActivity implements ConfirmCancelUtilDialog.DialogClickListener
{
    public final String TAG = this.getClass().getName();
    protected TipToast tipsToast = null;// 提示框
    protected Activity aty;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        aty = this;
        EventBus.getDefault().register(this);
    }


    /**
     * 注册广播后 需要写个接收广播的地方 不然报错
     * @param msg
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void ploginOut(EventBusBean msg)
    {
        //EventBus.getDefault().post(new EventBusBean(new Intent()));
    }
    /**
     *
     * @Title: showTips
     * @Description:
     * @param @param iconResId 图片ID
     * @param @param tips 文字ID
     * @return void 返回类型
     * @throws
     */
    protected void showTips(int iconResId, String tips)
    {
        if (StringUtils.isEmpty(tipsToast))
        {
            tipsToast = TipToast.makeText(MyApplication.getInstance()
                    .getApplicationContext(), tips, Toast.LENGTH_SHORT);
        }
        else
        {
            tipsToast.setText(tips);
            tipsToast.setDuration(Toast.LENGTH_SHORT);
        }
        if (iconResId != 0)
        {
            // tipsToast.setIcon(iconR esId);
        }
        tipsToast.show();
    }

    /**
     *
     * @Title: showTips
     * @Description: 字符串提示
     * @param @param tips 字符串文字
     * @return void 返回类型
     * @throws
     */
    protected void showTips(String tips)
    {
        showTips(0, tips);
    }

    /**
     *
     * @Title: showTips
     * @Description: 文字资源 提示
     * @param @param tips 文件资源ID
     * @return void 返回类型
     * @throws
     */
    public void showTips(int tips)
    {
        showTips(getString(tips));
    }

    /**
     * 只展现一个确定按钮
     */
    public void showDialogSingle(BaseActivity context,final String strTitle,final String strMessage,final String strBtn)
    {
        ConfirmCancelUtilDialog dialog = ConfirmCancelUtilDialog.getInstance(context,
                new ConfirmCancelUtilDialog.DialogSetListener() {
                    @Override
                    public void setDialog(TextView title, TextView message, Button leftBtn, Button rightBtn) {
                        title.setText(strTitle);
                        message.setText(strMessage);
                        message.setGravity(Gravity.CENTER);
                        leftBtn.setText(strBtn);
                        rightBtn.setVisibility(View.GONE);
                    }
                });
        dialog.setDialogClickListener(context);
        dialog.show(getSupportFragmentManager(), "confirmCancelDialog");
    }

    /**
     * 取消和确定都存在
     * @param context
     * @param strTitle
     * @param strMessage
     * @param strLeftBtn
     * @param strrightBtn
     */
    public void showDialogAll(BaseActivity context,final String strTitle,final String strMessage,final String strLeftBtn,final String strrightBtn)
    {

        ConfirmCancelUtilDialog dialog = ConfirmCancelUtilDialog.getInstance(context,
                new ConfirmCancelUtilDialog.DialogSetListener() {
                    @Override
                    public void setDialog(TextView title, TextView message, Button leftBtn, Button rightBtn) {
                        title.setText(strTitle);
                        message.setText(strMessage);
                        leftBtn.setText(strLeftBtn);
                        rightBtn.setText(strrightBtn);
                    }
                });
        dialog.setDialogClickListener(context);
        dialog.show(getSupportFragmentManager(), "confirmCancelDialog");
    }









    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
