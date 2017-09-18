package teerayut.dev.vlife.api;

import android.util.Log;
import android.util.LongSparseArray;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teerayut.dev.vlife.api.request.RequestAuth;
import teerayut.dev.vlife.api.result.ProductItemResultGroup;
import teerayut.dev.vlife.utils.Config;

import static teerayut.dev.vlife.api.ApiURL.BASE_URL;


/**
 * Created by teerayut.k on 7/17/2017.
 */

public class ServiceManager {

    private static ServiceManager instance;
    private static ApiService api;

    public interface ServiceManagerCallback<T>{
        void onSuccess(T result);

        void onFailure(Throwable t);
    }

    public static ServiceManager getInstance(){
        if( instance == null ){
            instance = new ServiceManager();
        }
        return instance;
    }

    private ServiceManager(){
    }

    public static void setApi( ApiService mockApi ){
        api = mockApi;
    }

    public Call<RequestAuth> requestAuthCall(String user, String pass) {
        return Service.newInstance( BASE_URL )
                .getApi( api )
                .getAuthToken(user, pass);
    }

    public Call<ProductItemResultGroup> requestProductCall(String token) {
        return Service.newInstance( BASE_URL )
                .getApi( api )
                .getAllProduct(token);
    }

    public void requestToken(final ServiceManagerCallback<RequestAuth> callback) {
        requestAuthCall("est@est?uSER", "est@est?pASS").enqueue(new Callback<RequestAuth>() {
            @Override
            public void onResponse(Call<RequestAuth> call, Response<RequestAuth> response) {
                Log.e("requestAuth token", response + "");
                if( callback != null ){
                    callback.onSuccess( response.body() );
                }
            }

            @Override
            public void onFailure(Call<RequestAuth> call, Throwable t) {
                Log.e("requestAuth token fail", t.getMessage() + "");
                if( !call.isCanceled() ){
                    if( callback != null ){
                        callback.onFailure( t );
                    }
                }
            }
        });
    }

    public void requestProduct(String token, final ServiceManagerCallback<ProductItemResultGroup> callback) {
        requestProductCall(token).enqueue(new Callback<ProductItemResultGroup>() {
            @Override
            public void onResponse(Call<ProductItemResultGroup> call, Response<ProductItemResultGroup> response) {
                if (callback != null) {
                    Log.e("request product", response + "\n" + response.body().getSTATUS());
                    if (requestProductChecker(response)) {
                        Log.e("product", response.body().getPRODUCT().get(0).getPRODUCT_NAME1());
                        callback.onSuccess(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<ProductItemResultGroup> call, Throwable t) {
                Log.e("request product fail", t.getMessage() + "");
                if( callback != null ){
                    callback.onFailure( t );
                }
            }
        });
    }

    public boolean requestProductChecker(Response<ProductItemResultGroup> response) {
        if (response.isSuccessful()) {
            ProductItemResultGroup group = response.body();
            return Config.SUCCESS.equals(group.getSTATUS());
        }
        return false;
    }
}
