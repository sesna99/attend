package trycatch.yj.sj.attend.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by trycatch on 2017. 9. 19..
 */

public class LoginInfo {
    @SerializedName("moco")
    private String moco;
    @SerializedName("data")
    private Data data;
    @SerializedName("state")
    private String state;
    @SerializedName("msg")
    private String msg;
    @SerializedName("idno")
    private String idno;
    @SerializedName("pass")
    private String pass;
    @SerializedName("info")
    private String info;

    public String getMoco() {
        return moco;
    }

    public Data getData() {
        return data;
    }

    public String getState() {
        return state;
    }

    public String getMsg() {
        return msg;
    }

    public String getIdno() {
        return idno;
    }

    public String getPass() {
        return pass;
    }

    public String getInfo() {
        return info;
    }

    public class Data{
        @SerializedName("idno")
        private String idno;
        @SerializedName("camp")
        private String camp;
        @SerializedName("iddi")
        private String iddi;
        @SerializedName("idco")
        private String idco;
        @SerializedName("sdco")
        private String sdco;
        @SerializedName("name")
        private String name;
        @SerializedName("unnm")
        private String unnm;
        @SerializedName("psco")
        private String psco;
        @SerializedName("psnm")
        private String psnm;
        @SerializedName("dmre")
        private String dmre;
        @SerializedName("phno")
        private String phno;
        @SerializedName("mjor")
        private String mjor;
        @SerializedName("mobc")
        private String mobc;
        @SerializedName("mobd")
        private String mobd;
        @SerializedName("mols")
        private String mols;
        @SerializedName("uuid")
        private String uuid;
        @SerializedName("moco")
        private String moco;
        @SerializedName("plat")
        private String plat;
        @SerializedName("isdt")
        private String isdt;
        @SerializedName("wknm")
        private String wknm;
        @SerializedName("updt")
        private String updt;
        @SerializedName("cmnt")
        private String cmnt;
        @SerializedName("byps")
        private String byps;
        @SerializedName("priv")
        private String priv;
        @SerializedName("time")
        private String time;
        @SerializedName("total")
        private String total;

        public String getIdno() {
            return idno;
        }

        public String getCamp() {
            return camp;
        }

        public String getIddi() {
            return iddi;
        }

        public String getIdco() {
            return idco;
        }

        public String getSdco() {
            return sdco;
        }

        public String getName() {
            return name;
        }

        public String getUnnm() {
            return unnm;
        }

        public String getPsco() {
            return psco;
        }

        public String getPsnm() {
            return psnm;
        }

        public String getDmre() {
            return dmre;
        }

        public String getPhno() {
            return phno;
        }

        public String getMjor() {
            return mjor;
        }

        public String getMobc() {
            return mobc;
        }

        public String getMobd() {
            return mobd;
        }

        public String getMols() {
            return mols;
        }

        public String getUuid() {
            return uuid;
        }

        public String getMoco() {
            return moco;
        }

        public String getPlat() {
            return plat;
        }

        public String getIsdt() {
            return isdt;
        }

        public String getWknm() {
            return wknm;
        }

        public String getUpdt() {
            return updt;
        }

        public String getCmnt() {
            return cmnt;
        }

        public String getByps() {
            return byps;
        }

        public String getPriv() {
            return priv;
        }

        public String getTime() {
            return time;
        }

        public String getTotal() {
            return total;
        }
    }
}
