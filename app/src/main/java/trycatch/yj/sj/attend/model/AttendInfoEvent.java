package trycatch.yj.sj.attend.model;

import trycatch.yj.sj.attend.model.AttendInfo;

/**
 * Created by trycatch on 2017. 9. 18..
 */

public class AttendInfoEvent {
    private boolean result;
    private AttendInfo attendInfo;

    public AttendInfoEvent(boolean result, AttendInfo attendInfo) {
        this.result = result;
        this.attendInfo = attendInfo;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public AttendInfo getAttendInfo() {
        return attendInfo;
    }

    public void setAttendInfo(AttendInfo attendInfo) {
        this.attendInfo = attendInfo;
    }
}
