package trycatch.yj.sj.attend.util;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import trycatch.yj.sj.attend.model.AttendCheck;
import trycatch.yj.sj.attend.model.AttendCheck2;
import trycatch.yj.sj.attend.model.AttendCheck2Event;
import trycatch.yj.sj.attend.model.AttendCheckEvent;
import trycatch.yj.sj.attend.model.AttendInfo;
import trycatch.yj.sj.attend.model.AttendInfoEvent;
import trycatch.yj.sj.attend.model.LoginInfo;
import trycatch.yj.sj.attend.model.LoginInfoEvent;

/**
 * Created by trycatch on 2017. 9. 18..
 */

public class Util {
    public static Util instance = new Util();
    private Retrofit retrofit;
    private RetrofitService retrofitService;
    private SimpleDateFormat simpleDateFormat;
    private String date;
    private String id;

    private Util() {
        retrofit = new Retrofit.Builder().baseUrl("https://smart.hansung.ac.kr").addConverterFactory(GsonConverterFactory.create()).build();
        retrofitService = retrofit.create(RetrofitService.class);

        simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
        date = null;
    }

    public void getCurDate(){
        try {
            date = simpleDateFormat.format(Calendar.getInstance().getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void login(String login_id, String login_pw){
        Call<LoginInfo> login = retrofitService.login(login_id, login_pw, "");
        login.enqueue(new Callback<LoginInfo>() {
            @Override
            public void onResponse(Call<LoginInfo> call, Response<LoginInfo> response) {
                Log.i("Retrofit", response.isSuccessful() + "");
                if(response.isSuccessful()){
                    LoginInfo loginInfo = response.body();
                    EventBus.getDefault().post(new LoginInfoEvent(true, loginInfo));
                    id = loginInfo.getIdno();
                }
                else{
                    EventBus.getDefault().post(new LoginInfoEvent(false, new LoginInfo()));
                }
            }

            @Override
            public void onFailure(Call<LoginInfo> call, Throwable t) {
                EventBus.getDefault().post(new LoginInfoEvent(false, new LoginInfo()));
            }
        });
    }

    public void atdcInfo(){
        getCurDate();
        Call<AttendInfo> atdcInfo = retrofitService.getAtdcInfo(id, date);
        atdcInfo.enqueue(new Callback<AttendInfo>() {
            @Override
            public void onResponse(Call<AttendInfo> call, Response<AttendInfo> response) {
                Log.i("RetrofitAtdc", response.isSuccessful() + "");
                if(response.isSuccessful()){
                    EventBus.getDefault().post(new AttendInfoEvent(true, response.body()));
                }
                else{
                    EventBus.getDefault().post(new AttendInfoEvent(false, response.body()));
                }
            }

            @Override
            public void onFailure(Call<AttendInfo> call, Throwable t) {
                Log.i("RetrofitAtdc", t.toString());
                EventBus.getDefault().post(new AttendInfoEvent(false, new AttendInfo()));
            }
        });
    }

    public void atdcChk(final AttendInfo info){
        getCurDate();
        AttendInfo.Data data = info.getData();
        Call<AttendCheck> atdcChk = retrofitService.getAtdcChk(id, data.getPsco(), data.getSjco(), data.getIden(), info.getResult().get(0).getMsc(), date, "", "1");
        atdcChk.enqueue(new Callback<AttendCheck>() {
            @Override
            public void onResponse(Call<AttendCheck> call, Response<AttendCheck> response) {
                Log.i("RetrofitChk", response.isSuccessful() + "");
                Log.i("RetrofitChk", response.code() + "");
                if(response.isSuccessful()){
                    try {
                        AttendCheck attendCheck = response.body();
                        Log.i("message", attendCheck.getMessage());
                        EventBus.getDefault().post(new AttendCheckEvent(true, attendCheck));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    try {
                        Log.i("RetrofitChk", response.errorBody().string() + "");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    EventBus.getDefault().post(new AttendCheckEvent(false, new AttendCheck()));
                }
            }

            @Override
            public void onFailure(Call<AttendCheck> call, Throwable t) {
                EventBus.getDefault().post(new AttendCheckEvent(false, new AttendCheck()));
            }
        });
    }

    public void atdcChk2(AttendInfo info){
        getCurDate();
        AttendInfo.Data data = info.getData();
        Call<AttendCheck2> atdcChk2 = retrofitService.getAtdcChk2(id, data.getPsco(), data.getSjco(), data.getIden(), info.getResult().get(0).getMsc(), date, "", "1", "0");
        atdcChk2.enqueue(new Callback<AttendCheck2>() {
            @Override
            public void onResponse(Call<AttendCheck2> call, Response<AttendCheck2> response) {
                Log.i("RetrofitChk2", response.isSuccessful() + "");
                Log.i("RetrofitChk2", response.code() + "");
                if(response.isSuccessful()){
                    try {
                        AttendCheck2 attendCheck = response.body();
                        EventBus.getDefault().post(new AttendCheck2Event(true, attendCheck));
                        Log.i("message", attendCheck.getMessage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    try {
                        Log.i("RetrofitChk", response.errorBody().string() + "");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    EventBus.getDefault().post(new AttendCheck2Event(false, new AttendCheck2()));
                }
            }

            @Override
            public void onFailure(Call<AttendCheck2> call, Throwable t) {
                EventBus.getDefault().post(new AttendCheck2Event(false, new AttendCheck2()));
            }
        });
    }

    public static Util getInstance() {
        return instance;
    }
}
