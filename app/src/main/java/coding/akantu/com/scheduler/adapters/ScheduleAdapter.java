package coding.akantu.com.scheduler.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import coding.akantu.com.scheduler.R;
import coding.akantu.com.scheduler.models.Schedule;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    private List<Schedule> scheduleList = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_list_item,parent,false);

        return new ViewHolder(view);//pass view to and object of Viewholder
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txtFlight.setText(scheduleList.get(position).getFlight().getMarketingCarrier().getFlightNumber().toString());
        holder.txtOrigin.setText(scheduleList.get(position).getFlight().getDeparture().getAirportCode());
        holder.txtDestination.setText(scheduleList.get(position).getFlight().getArrival().getAirportCode());
    }

    @Override
    public int getItemCount() {
        return scheduleList.size();
    }

    public void loadScheduleList(List<Schedule> scheduleList){
        this.scheduleList=scheduleList;
        notifyDataSetChanged();//retry the layout.
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtDestination, txtOrigin,txtFlight;
        private RelativeLayout scheduleItem;

        public ViewHolder(View itemView) {
            super(itemView);

            txtOrigin = itemView.findViewById(R.id.flight_origin);
            txtDestination = itemView.findViewById(R.id.flight_destination);
            txtFlight = itemView.findViewById(R.id.flight_number);

            scheduleItem = itemView.findViewById(R.id.list_item);

            scheduleItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener!=null&&getAdapterPosition()!=RecyclerView.NO_POSITION){
                       listener.onItemClick(scheduleList.get(getAdapterPosition()));
                    }

                }
            });

        }
    }

    public interface OnItemClickListener{
        void onItemClick(Schedule item);
    }

    public void setItemClickListener(OnItemClickListener listener){
        this.listener=listener;
    }
}
