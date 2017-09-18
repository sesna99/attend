package trycatch.yj.sj.attend.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import trycatch.yj.sj.attend.model.AttendCheck2Event;
import trycatch.yj.sj.attend.model.AttendCheckEvent;
import trycatch.yj.sj.attend.model.AttendInfoEvent;
import trycatch.yj.sj.attend.R;
import trycatch.yj.sj.attend.model.AttendInfo;
import trycatch.yj.sj.attend.util.Util;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.profile)
    ImageView profile;

    @BindView(R.id.lec_name)
    TextView lec_name;

    @BindView(R.id.lec_room)
    TextView lec_room;

    @BindView(R.id.lec_time)
    TextView lec_time;

    @BindView(R.id.lec_pro)
    TextView lec_pro;

    @BindView(R.id.btn_attend)
    Button btn_attend;

    private AttendInfo attendInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Util.getInstance().atdcInfo();

        btn_attend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Util.getInstance().atdcChk(attendInfo);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Util.getInstance().atdcInfo();
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void AttendInfoEvent(AttendInfoEvent attendInfoEvent){
        if(attendInfoEvent.isResult()){
            attendInfo = attendInfoEvent.getAttendInfo();
            if(attendInfo.getMsg().split(":")[0].trim().equals("Y")){
                AttendInfo.Data data = attendInfo.getData();
                String imgUrl = "https://smart.hansung.ac.kr/profile_image?u=" + data.getPrco();
                Glide.with(this).load(imgUrl).into(profile);
                lec_name.setText(data.getSjnm());
                lec_room.setText(data.getRmnm());
                lec_time.setText(data.getDate());
                lec_pro.setText(data.getPrnm());
            }
            else{
                Toast.makeText(MainActivity.this, "수업 정보가 없습니다.", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "오류가 발생하였습니다.", Toast.LENGTH_SHORT).show();
        }
    }

    @Subscribe
    public void AttendCheckEvent(AttendCheckEvent attendCheckEvent){
        if(attendCheckEvent.isResult()){
            Toast.makeText(this, attendCheckEvent.getAttendCheck().getMessage(), Toast.LENGTH_SHORT).show();
            Util.getInstance().atdcChk2(attendInfo);
        }
        else{
            Toast.makeText(this, "오류가 발생하였습니다.", Toast.LENGTH_SHORT).show();
        }
    }

    @Subscribe
    public void AttendCheck2Event(AttendCheck2Event attendCheckEvent){
        if(attendCheckEvent.isResult()){
            Toast.makeText(this, attendCheckEvent.getAttendCheck().getMessage(), Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "오류가 발생하였습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
