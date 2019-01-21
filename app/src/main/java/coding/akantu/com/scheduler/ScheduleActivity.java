package coding.akantu.com.scheduler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import coding.akantu.com.scheduler.adapters.ScheduleAdapter;
import coding.akantu.com.scheduler.models.Schedule;

public class ScheduleActivity extends Activity {

    public static final String API_KEY = "c58efe847557404582dff0f873a347d5";
    private RecyclerView recyclerView;
    private ScheduleAdapter scheduleAdapter;
    private List<Schedule> scheduleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        scheduleList = (ArrayList<Schedule>)getIntent().getSerializableExtra("schedules");
        setContentView(R.layout.schedule_list);
        recyclerView = findViewById(R.id.schedule);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);//if size wont change.
        scheduleAdapter = new ScheduleAdapter();
        scheduleAdapter.loadScheduleList(scheduleList);
        recyclerView.setAdapter(scheduleAdapter);



        scheduleAdapter.setItemClickListener(new ScheduleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Schedule item) {
               //load map when item clicked
               startActivity(new Intent(ScheduleActivity.this,MapsActivity.class));
            }
        });


    }
}
