package org.wangy.webtest.command;


import org.wangy.webtest.model.User;

import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2015/10/29.
 */
public class JsonCommand<T> {
    private int total;
    private boolean success = true;
    private String msg;
    private Collection<T> data;

    public JsonCommand(Collection<T> data, int total, boolean success) {
        this.total = total;
        this.success = success;
        this.data = data;
    }

    public JsonCommand() {}

    public JsonCommand(Collection<T> data) {
        this.total = data.size();
        this.data = data;
    }

    public JsonCommand(Collection<T> data, int total1) {
        this.total=total1;
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Collection<T> getData() {
        return data;
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }
}
