package util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.androidlibrary.R;

/**
 * 作者：wangchen on 2017/11/13 09:33
 * 邮箱：wangchen0338@163.com
 * 自定义提示Toast
 */
public class TipToast extends Toast
{
    private static Toast result = null;
    public TipToast(Context context)
    {
        super(context);
    }

    public static TipToast makeText(Context context, CharSequence text,
                                    int duration)
    {
        if (null == result)
        {
            result = new TipToast(context);
        }
        LayoutInflater inflate = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflate.inflate(R.layout.view_toast, null);
        //v.getBackground().setAlpha(180);
        TextView tv = (TextView) v.findViewById(R.id.tips_msg);
        tv.getBackground().setAlpha((int)(255*0.8));
        tv.setText(text);
        result.setView(v);
        // setGravity方法用于设置位置，此处为垂直居中
        result.setGravity(Gravity.CENTER, 0, 0);
        result.setDuration(duration);
        updateToastAnim(result);
        return (TipToast) result;
    }

    public static TipToast makeText(Context context, int resId, int duration)
            throws Resources.NotFoundException
    {
        return makeText(context, context.getResources().getText(resId),
                duration);
    }

//	public void setIcon(int iconResId)
//	{
//		if(getView() == null)
//		{
//			throw new RuntimeException(
//					"This Toast was not created with Toast.makeText()");
//		}
//		ImageView iv = (ImageView) getView().findViewById(R.id.tips_icon);
//		if(iv == null)
//		{
//			throw new RuntimeException(
//					"This Toast was not created with Toast.makeText()");
//		}
//		iv.setImageResource(iconResId);
//	}

    /**
     *
     * @Title: updateToastAnim
     * @Description: 统一 Toast 动画，使 Toast 动画不再因不同系统而产生差异
     * @param @param toast 参数说明
     * @return void 返回类型
     * @throws
     */
    private static void updateToastAnim(Toast toast)
    {
        if(toast != null)
        {
            // Toast 动画
            try
            {
                Object mTN = ReflectUtils.getField(toast, "mTN");
                if(mTN != null)
                {
                    Object mParams = ReflectUtils.getField(mTN, "mParams");
                    if(mParams != null
                            && mParams instanceof WindowManager.LayoutParams)
                    {
                        WindowManager.LayoutParams params = (WindowManager.LayoutParams) mParams;
                        setParams(params);
                    }
                }
            }
            catch (Exception e)
            {
                //e.printStackTrace();
            }
        }
    }

    private static void setParams(WindowManager.LayoutParams params)
    {
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.windowAnimations = R.style.anim_view;
        params.format = PixelFormat.TRANSLUCENT;
        params.windowAnimations = R.style.anim_view;// 设置进入退出动画效果
        params.type = WindowManager.LayoutParams.TYPE_TOAST;
        params.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.y = 250;
    }

    @Override
    public void setText(CharSequence s)
    {
        if(getView() == null)
        {
            throw new RuntimeException(
                    "This Toast was not created with Toast.makeText()");
        }
        TextView tv = (TextView) getView().findViewById(R.id.tips_msg);
        if(tv == null)
        {
            throw new RuntimeException(
                    "This Toast was not created with Toast.makeText()");
        }
        tv.setText(s);
    }

}
