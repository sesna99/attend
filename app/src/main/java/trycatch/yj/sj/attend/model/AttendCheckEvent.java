package trycatch.yj.sj.attend.model;

/**
 * Created by trycatch on 2017. 9. 18..
 */

public class AttendCheckEvent {
    private boolean result;
    private AttendCheck attendCheck;

    public AttendCheckEvent(boolean result, AttendCheck attendCheck) {
        this.result = result;
        this.attendCheck = attendCheck;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public AttendCheck getAttendCheck() {
        return attendCheck;
    }

    public void setAttendCheck(AttendCheck attendCheck) {
        this.attendCheck = attendCheck;
    }
}
