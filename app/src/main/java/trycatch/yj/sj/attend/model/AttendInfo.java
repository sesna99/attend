package trycatch.yj.sj.attend.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by trycatch on 2017. 9. 12..
 */

public class AttendInfo {
    @SerializedName("result")
    private ArrayList<Result> result;
    @SerializedName("data")
    private Data data;
    @SerializedName("type")
    private String type;
    @SerializedName("ssid")
    private ArrayList<Object> ssid;
    @SerializedName("atrs")
    private String atrs;
    @SerializedName("date")
    private String date;
    @SerializedName("msg")
    private String msg;
    @SerializedName("idno")
    private String idno;

    public ArrayList<Result> getResult() {
        return result;
    }

    public Data getData() {
        return data;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Object> getSsid() {
        return ssid;
    }

    public String getAtrs() {
        return atrs;
    }

    public String getDate() {
        return date;
    }

    public String getMsg() {
        return msg;
    }

    public String getIdno() {
        return idno;
    }

    public class Result {
        @SerializedName("SSID")
        private String ssid;

        @SerializedName("±¸ºÐ")
        private String object;

        @SerializedName("MSC")
        private String msc;

        public String getSsid() {
            return ssid;
        }

        public String getObject() {
            return object;
        }

        public String getMsc() {
            return msc;
        }
    }

    public class Data {
        @SerializedName("idx")
        private Object idx;
        @SerializedName("yyse")
        private String yyse;
        @SerializedName("camp")
        private String camp;
        @SerializedName("psco")
        private String psco;
        @SerializedName("sjco")
        private String sjco;
        @SerializedName("sjnm")
        private String sjnm;
        @SerializedName("iden")
        private String iden;
        @SerializedName("prco")
        private String prco;
        @SerializedName("prnm")
        private String prnm;
        @SerializedName("pont")
        private String pont;
        @SerializedName("hour")
        private String hour;
        @SerializedName("date")
        private String date;
        @SerializedName("rmco")
        private String rmco;
        @SerializedName("rmnm")
        private String rmnm;
        @SerializedName("path")
        private Object path;
        @SerializedName("cnt")
        private String cnt;
        @SerializedName("time")
        private Object time;
        @SerializedName("type")
        private String type;

        public Object getIdx() {
            return idx;
        }

        public String getYyse() {
            return yyse;
        }

        public String getCamp() {
            return camp;
        }

        public String getPsco() {
            return psco;
        }

        public String getSjco() {
            return sjco;
        }

        public String getSjnm() {
            return sjnm;
        }

        public String getIden() {
            return iden;
        }

        public String getPrco() {
            return prco;
        }

        public String getPrnm() {
            return prnm;
        }

        public String getPont() {
            return pont;
        }

        public String getHour() {
            return hour;
        }

        public String getDate() {
            return date;
        }

        public String getRmco() {
            return rmco;
        }

        public String getRmnm() {
            return rmnm;
        }

        public Object getPath() {
            return path;
        }

        public String getCnt() {
            return cnt;
        }

        public Object getTime() {
            return time;
        }

        public String getType() {
            return type;
        }
    }
}
