package edu.umn.csci5801.model;

import java.util.List;

/**
 * Created by zihong on 12/2/14.
 */
public class PHD {
    private List<Requirement> reqList;
    public List<Requirement> getReqList() {
        if(reqList == null) {
            setReqList();
        }
        return reqList;
    }
    //TODO: This is where the Requirements for Masters PHD get inputted into a List
    private void setReqList() {
        //See MasterA.java for format
    }
}
