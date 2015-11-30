package org.wangy.webtest.command;


import java.util.Collection;

/**
 * Created by Administrator on 2015/10/29.
 */
public class TreeJsonCommand<T> {
    private T data;

    public TreeJsonCommand(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
