package teerayut.dev.vlife.api;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;


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


}
