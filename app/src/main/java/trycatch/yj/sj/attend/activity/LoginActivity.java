package trycatch.yj.sj.attend.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import trycatch.yj.sj.attend.R;
import trycatch.yj.sj.attend.model.LoginInfoEvent;
import trycatch.yj.sj.attend.util.Util;

/**
 * Created by trycatch on 2017. 9. 19..
 */

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.edit_id)
    EditText edit_id;

    @BindView(R.id.edit_pw)
    EditText edit_pw;

    @BindView(R.id.btn_login)
    Button btn_login;

    private String id;
    private String pw;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = edit_id.getText().toString();
                pw = edit_pw.getText().toString();
                Util.getInstance().login(id, pw);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void LoginInfoEvent(LoginInfoEvent loginInfoEvent){
        if(loginInfoEvent.isResult() && loginInfoEvent.getLoginInfo().getState().equals("T")){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "아이디, 비번을 확인해주세요.", Toast.LENGTH_SHORT).show();
        }
    }
}
