package com.longhengrui.oa.mvp.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.longhengrui.oa.R;
import com.longhengrui.oa.base.BaseActivity;
import com.longhengrui.oa.util.ActivityMangerUtil;
import com.longhengrui.oa.util.CountDownTimerUtils;


//注册页面
public class ReginActivity extends BaseActivity implements View.OnClickListener {
    private boolean flag = false;
    private ImageView mIvRegisterReturn;
    /**
     * 请输入手机号
     */
    private EditText mEdPhone;
    /**
     * 请输入您的验证码
     */
    private EditText mEdReginCode;
    /**
     * 发送验证码
     */
    private TextView mTvCode;
    /**
     * 需要勾选同意《OA系统协议》!
     */
    private TextView mTvAgreement;
    private ImageView mIvReginLogin;
    private Intent intent;


    @Override
    protected void initView() {
        mIvRegisterReturn = (ImageView) findViewById(R.id.iv_register_return);
        mEdPhone = (EditText) findViewById(R.id.ed_phone);
        mEdReginCode = (EditText) findViewById(R.id.ed_regin_code);
        mTvCode = (TextView) findViewById(R.id.tv_code);
        mTvAgreement = (TextView) findViewById(R.id.tv_agreement);
        mIvReginLogin = (ImageView) findViewById(R.id.iv_regin_login);
    }

    @Override
    protected void initListenner() {
        mIvRegisterReturn.setOnClickListener(this);
        mEdPhone.setOnClickListener(this);
        mEdReginCode.setOnClickListener(this);
        mTvCode.setOnClickListener(this);
        mTvAgreement.setOnClickListener(this);
        mIvReginLogin.setOnClickListener(this);

    }

    @Override
    protected void onViewCreated() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_regin_login:
                //手机号不能为空 长度要等于11
                   if(mEdPhone!=null&&mEdPhone.length()==11){
                Intent intent = new Intent(ReginActivity.this, LoginActivity.class);
                startActivity(intent);
                }else {
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
            //返回的图标
            case R.id.iv_register_return:
                ActivityMangerUtil.startActivity(this, HomepageActivity.class, false);
                break;
            //发送验证码
            case R.id.tv_code:
                CountDownTimerUtils mCountDownTimerUtils = new CountDownTimerUtils(mTvCode, 60000, 1000);
                mCountDownTimerUtils.start();
                // 请求验证码，其中country表示国家代码88888888，如“86”；phone表示手机号码，如“13800138000”
                // SMSSDK.getVerificationCode("86", mEdReginCode.getText().toString());
                break;
            //跳转到协议页面
            case R.id.tv_agreement:
                intent = new Intent(this, AgreementActivity.class);
                startActivity(intent);
                break;
            case R.id.ed_phone:
                break;
            case R.id.ed_regin_code:
                break;
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_regin;
    }



}
