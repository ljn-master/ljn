package mobileshop.edu.huatec.com.jxxy_ljn.http.entity;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class HttpResult<T> implements Serializable {
    private int status;
    private String msg;
    private T data;

    public int getStaus() {
        return status;
    }

    public void setStaus(int staus) {
        this.status = staus;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @NonNull
    @Override
    public String toString() {
        return "HttpResult{" +
                "data="+ data +
                ", status=" + status +
                ", msg=‘"+ msg + '\'' +
                '}';
    }
}
