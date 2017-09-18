package trycatch.yj.sj.attend.model;

/**
 * Created by trycatch on 2017. 9. 18..
 */

public class AttendCheck2Event {
    private boolean result;
    private AttendCheck2 attendCheck;

    public AttendCheck2Event(boolean result, AttendCheck2 attendCheck) {
        this.result = result;
        this.attendCheck = attendCheck;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public AttendCheck2 getAttendCheck() {
        return attendCheck;
    }

    public void setAttendCheck(AttendCheck2 attendCheck) {
        this.attendCheck = attendCheck;
    }
}
