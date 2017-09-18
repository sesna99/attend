package trycatch.yj.sj.attend.util;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import trycatch.yj.sj.attend.model.AttendCheck;
import trycatch.yj.sj.attend.model.AttendCheck2;
import trycatch.yj.sj.attend.model.AttendInfo;

/**
 * Created by trycatch on 2017. 9. 10..
 */

public interface RetrofitService {
    @FormUrlEncoded
    @POST("/api/login_access")
    Call<ResponseBody> login(@Field("idno") String idno, @Field("pass") String pass, @Field("uuid") String uuid);

    @POST("/api/track_list")
    Call<ResponseBody> getTrack(@QueryMap Map<String, String> query);

    @FormUrlEncoded
    @POST("/api/atdc_info")
    Call<AttendInfo> getAtdcInfo(@Field("idno") String idno, @Field("date") String date);

    @FormUrlEncoded
    @POST("/api/atdc_chk")
    Call<AttendCheck> getAtdcChk(@Field("idno") String idno, @Field("psco") String psco, @Field("sjco") String sjco, @Field("iden") String iden, @Field("mac") String mac, @Field("date") String date, @Field("uuid") String uuid, @Field("check") String check);

    @FormUrlEncoded
    @POST("/api/atdc_chk2")
    Call<AttendCheck2> getAtdcChk2(@Field("idno") String idno, @Field("psco") String psco, @Field("sjco") String sjco, @Field("iden") String iden, @Field("mac") String mac, @Field("date") String date, @Field("uuid") String uuid, @Field("check") String check, @Field("count") String count);

}
