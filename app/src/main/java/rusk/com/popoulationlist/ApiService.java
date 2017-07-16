package rusk.com.popoulationlist;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kunal on 17-06-2017.
 */

public interface ApiService {

    @GET("jsonparsetutorial.txt")
    Call<WorldPopulationList> getMyJSON();
}