package mobileshop.edu.huatec.com.jxxy_ljn.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mobileshop.edu.huatec.com.jxxy_ljn.R;
import mobileshop.edu.huatec.com.jxxy_ljn.common.BaseActivity;
import mobileshop.edu.huatec.com.jxxy_ljn.http.ProgressDialogSubscriber;
import mobileshop.edu.huatec.com.jxxy_ljn.http.entity.MemberEntity;
import mobileshop.edu.huatec.com.jxxy_ljn.http.presenter.MemberPresenter;
import mobileshop.edu.huatec.com.jxxy_ljn.utils.SystemCofig;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    public int getContentViewId(){
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_back)
    void close(){
        finish();
    }
    @OnClick(R.id.bt_login)
    void login(){
        String userName = etUsername.getText().toString().trim();
        String pwd = etPwd.getText().toString().trim();
        if (TextUtils.isEmpty(userName)){
            toastShort("请输入用户名");
            return;
        }
        if (TextUtils.isEmpty(pwd)){
            toastShort("请输入密码");
            return;
        }
        MemberPresenter.login(new ProgressDialogSubscriber<MemberEntity>(this){
            public void onNext(MemberEntity memberEntity){
                SystemCofig.setLogin(true);
                toastShort("登录成功");
                SystemCofig.setLoginUserName(memberEntity.uname);
                SystemCofig.setLoginUserEmail(memberEntity.email);
                SystemCofig.setLoginUserHead(memberEntity.image);
                setResult(RESULT_OK);
                finish();
            }
        }, userName, pwd);
    }
}