package org.wangy.webtest.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/25.
 */
public class TreeData implements Serializable {
    private String id;
    private Boolean leaf;
    private Boolean expanded;
    private String text;
    private List<TreeData> data = new ArrayList<TreeData>();

    public TreeData(String id, Boolean leaf, String text) {
        this(id, leaf, text, null);
    }

    public TreeData() {
    }

    public TreeData(String id, Boolean leaf, String text, Boolean expanded) {
        this.id = id;
        this.leaf = leaf;
        this.text = text;
        this.expanded = expanded;
    }

//    public List<TreeData> getData() {
//        return data;
//    }

    public void addChild(TreeData child) {
        this.data.add(child);
    }

    public Boolean getExpanded() {
        return expanded;
    }

    public String getId() {
        return id;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public String getText() {
        return text;
    }
}
