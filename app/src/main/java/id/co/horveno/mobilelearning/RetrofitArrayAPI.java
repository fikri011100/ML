package id.co.horveno.mobilelearning;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by fikriimaduddin on 8/28/17.
 */

public interface RetrofitArrayAPI {
    @GET("api/RetrofitAndroidArrayResponse")
    Call<List<Model>>getModelDetails();
}
