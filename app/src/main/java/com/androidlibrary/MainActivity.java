package com.androidlibrary;

import android.os.Bundle;

import base.BaseActivity;

public class MainActivity extends BaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showDialogSingle(this,"提示","请检查用户名","确定");
    }


    @Override
    public void leftClickListener()
    {
        showTips("左边");
    }

    @Override
    public void rightClickListener()
    {
        showTips("右边");
    }
}
