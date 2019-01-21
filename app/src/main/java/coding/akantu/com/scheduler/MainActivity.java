package coding.akantu.com.scheduler;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import coding.akantu.com.scheduler.api.APIClient;
import coding.akantu.com.scheduler.api.APIService;
import coding.akantu.com.scheduler.models.FlightSchedule;
import coding.akantu.com.scheduler.models.Schedule;
import coding.akantu.com.scheduler.models.ScheduleResource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText txtOrigin, txtDestination;
    private String origin, destination;
    private ProgressDialog mProgressDialog;
    private Button btnLoad;
    private List<Schedule> scheduleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressDialog = new ProgressDialog(this);
        txtOrigin = findViewById(R.id.origin);
        txtDestination = findViewById(R.id.destination);
        btnLoad = findViewById(R.id.load);
        scheduleList = new ArrayList<>();
        Log.d("CURRENT_DATE", getDate());
        // get the origin and destination
        origin = txtOrigin.getText().toString();
        Log.d("ORIGIN", origin);
        destination = txtDestination.getText().toString();
        Log.d("DESTINATION", origin);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(txtOrigin.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please enter origin", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(txtDestination.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please enter destination!", Toast.LENGTH_SHORT).show();
                    return;
                }

                mProgressDialog.setMessage("Loading schedules...Please wait");
                mProgressDialog.setCancelable(false);
                mProgressDialog.setIndeterminate(true);
                mProgressDialog.show();

                //loading all scedules as per the AIRPORT codes provided for the origin and destination.
                getSchedules();


    }

    public void getSchedules(){
        APIService apiService = APIClient.getClient().create(APIService.class);
        Call<FlightSchedule> call = apiService.getSchedules(txtOrigin.getText().toString(), txtDestination.getText().toString(), getDate(),1);
        Log.d("URL",call.request().url().toString());
        Log.d("HEADERS",call.request().headers().toString());

        call.enqueue(new Callback<FlightSchedule>() {
            @Override
            public void onResponse(Call<FlightSchedule> call, Response<FlightSchedule> response) {
                //If call is successful
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "SERVER ERROR CODE: " + response.code(), Toast.LENGTH_LONG).show();
                    mProgressDialog.dismiss();
                    return;
                }

                Log.d("RESPONSE", response.body().toString());
                scheduleList = response.body().getScheduleResource().getSchedule();
                if (!scheduleList.equals(null) && scheduleList.size()>0) {

                    Log.d("ARRIVALCODE",scheduleList.get(0).getFlight().getArrival().getAirportCode());
                    Log.d("FLIGHTNUMBER",scheduleList.get(0).getFlight().getMarketingCarrier().getFlightNumber().toString());
                    Log.d("CURRENT_DATE", getDate());

                    Intent intent = new Intent(getApplicationContext(),ScheduleActivity.class);
                    intent.putExtra("schedules",(Serializable) scheduleList);
                    startActivity(intent);

                }


               mProgressDialog.dismiss();
              Toast.makeText(getApplicationContext(), "Schedules loaded sucessfully", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<FlightSchedule> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
                t.printStackTrace();


                Toast.makeText(getApplicationContext(), "SERVER ERROR: " + t.getMessage(), Toast.LENGTH_LONG).show();
                mProgressDialog.dismiss();
            }
        });
    }

        });

    }
// get date to be used in API method call
    public String getDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(calendar.getTime());

    }
}
