package trycatch.yj.sj.attend.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by trycatch on 2017. 9. 18..
 */

public class AttendCheck {
    @SerializedName("message")
    private String message;
    @SerializedName("check")
    private String check;
    @SerializedName("psco")
    private String psco;
    @SerializedName("state")
    private String state;
    @SerializedName("mac")
    private String mac;
    @SerializedName("uuid")
    private String uuid;
    @SerializedName("date")
    private String date;
    @SerializedName("msg")
    private String msg;
    @SerializedName("iden")
    private String iden;
    @SerializedName("sjco")
    private String sjco;

    public String getMessage() {
        return message;
    }

    public String getCheck() {
        return check;
    }

    public String getPsco() {
        return psco;
    }

    public String getState() {
        return state;
    }

    public String getMac() {
        return mac;
    }

    public String getUuid() {
        return uuid;
    }

    public String getDate() {
        return date;
    }

    public String getMsg() {
        return msg;
    }

    public String getIden() {
        return iden;
    }

    public String getSjco() {
        return sjco;
    }
}
