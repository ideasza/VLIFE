package teerayut.dev.vlife.api.request;

/**
 * Created by teerayut.k on 9/4/2017.
 */

public class RequestAuth {

    private String access_token;
    private String expire;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }
}
