package coding.akantu.com.scheduler.api;

import coding.akantu.com.scheduler.models.AirportDetails;
import coding.akantu.com.scheduler.models.FlightSchedule;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {


    //return airline schedules
    @Headers({"Authorization: Bearer 482kgdebx4qkt7ewzzhddyk4","ContentType: application/json","Accept: application/json"})
    @GET("operations/schedules/{origin}/{destination}/{fromDateTime}")
    Call<FlightSchedule> getSchedules(@Path("origin") String origin, @Path("destination") String destination, @Path("fromDateTime") String fromDateTime,@Query("directFlights")int directFlights);

    //return origin coordinates
    @Headers({"Authorization: Bearer 482kgdebx4qkt7ewzzhddyk4","ContentType: application/json","Accept: application/json"})
    @GET("references/airports/{origin}")
            Call<AirportDetails> getOriginCoordinates(@Path("origin") String origin);

    //return destination coordinates
    @Headers({"Authorization: Bearer 482kgdebx4qkt7ewzzhddyk4","ContentType: application/json","Accept: application/json"})
    @GET("references/airports/{destination}")
    Call<AirportDetails> getDestCoordinates(@Path("destination") String destination);

}
