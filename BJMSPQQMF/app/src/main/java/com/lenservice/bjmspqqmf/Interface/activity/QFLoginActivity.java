package com.lenservice.bjmspqqmf.Interface.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lenservice.bjmspqqmf.common.CommonUtils;
import com.lenservice.bjmspqqmf.MainActivity;
import com.lenservice.bjmspqqmf.R;

/**
 * Created by len on 16/12/27.
 */

public class QFLoginActivity extends Activity implements View.OnClickListener {

    private Button wx_changebtn;
    private Button phone_changebtn;
    private Button phonecode_btn;
    private TextView phonenum_tv;
    private Button phone_logininbtn;

    private LinearLayout wx_changelogin;
    private LinearLayout phone_changelogin;

    private EditText phone_et;
    private EditText password_et;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initBaseViews();
    }

    private void initBaseViews() {

        wx_changebtn = (Button) this.findViewById(R.id.login_changewxbtn);
        phone_changebtn = (Button) this.findViewById(R.id.login_changephonebtn);
        wx_changelogin = (LinearLayout) this.findViewById(R.id.qm_ll_wxlogin);
        phone_changelogin = (LinearLayout) this.findViewById(R.id.qm_ll_phonelogin);
        phonecode_btn = (Button) this.findViewById(R.id.btn_yanzheng);
        phonenum_tv = (TextView) this.findViewById(R.id.tv_yanzheng);
        phone_et = (EditText) this.findViewById(R.id.login_phone_et);
        password_et = (EditText) this.findViewById(R.id.login_password_et);
        phone_logininbtn = (Button) this.findViewById(R.id.login_phoneinbtn);
        wx_changebtn.setOnClickListener(this);
        phone_changebtn.setOnClickListener(this);
        phonecode_btn.setOnClickListener(this);
        phone_logininbtn.setOnClickListener(this);
        //设置隐藏
        phone_changelogin.setVisibility(View.INVISIBLE);
    }

    private Integer code = 60;
    private Handler codeHander = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.i("QFLoginActivity", "<<<<<<<<<<wx");
            phonenum_tv.setText(--code + "");
            if (code == 0) {
                code = 60;
                phonecode_btn.setVisibility(View.VISIBLE);
                phonenum_tv.setText("59");
            }
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_changewxbtn:
                Log.i("QFLoginActivity", "<<<<<<<<<<wx");
                wx_changelogin.setVisibility(View.INVISIBLE);
                phone_changelogin.setVisibility(View.VISIBLE);
                break;
            case R.id.login_changephonebtn:
                Log.i("QFLoginActivity", "<<<<<<<<<<phone");
                wx_changelogin.setVisibility(View.VISIBLE);
                phone_changelogin.setVisibility(View.INVISIBLE);
                break;
            case R.id.btn_yanzheng:

//                if (!CommonUtils.isMobileNO(phone_et.getText().toString())) {
//                    CommonUtils.toastView(this,"输入的手机号有误");
//                    return;
//                }
//                CommonUtils.progressBarStyleLarge(this,phone_changelogin);
                phonecode_btn.setVisibility(View.INVISIBLE);
                new Thread() {
                    @Override
                    public void run() {
                        while (code > 1) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            codeHander.sendEmptyMessage(0);
                        }
                    }
                }.start();
                break;
            case R.id.login_phoneinbtn:
//                if ((!CommonUtils.isMobileNO(phone_et.getText().toString()))|| password_et.getText().equals("")) {
//                    CommonUtils.toastView(this,"输入的手机号或密码错误");
//                    return;
//                }
                Intent intent = new Intent(this, MainActivity.class);
                this.startActivity(intent);
                break;
        }
    }

}
