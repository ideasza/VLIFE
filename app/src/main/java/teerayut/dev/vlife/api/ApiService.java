package teerayut.dev.vlife.api;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import teerayut.dev.vlife.api.request.RequestAuth;
import teerayut.dev.vlife.api.result.ProductItemResultGroup;

import static teerayut.dev.vlife.api.ApiURL.AUTH_URL;
import static teerayut.dev.vlife.api.ApiURL.PRODUCT_URL;

/**
 * Created by teerayut.k on 7/17/2017.
 */

public interface ApiService {

    @FormUrlEncoded
    @POST( AUTH_URL )
    Call<RequestAuth> getAuthToken(@Field("auth_user") String user, @Field("auth_pass") String pass);


    @POST( PRODUCT_URL )
    Call<ProductItemResultGroup> getAllProduct(@Header("Authorization") String token);
}
