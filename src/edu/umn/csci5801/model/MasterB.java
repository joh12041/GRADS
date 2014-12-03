package edu.umn.csci5801.model;

import java.util.List;

/**
 * Created by Justin on 12/2/2014.
 */
public class MasterB {
    private List<Requirement> reqList;
    public List<Requirement> getReqList() {
        if(reqList == null) {
            setReqList();
        }
        return reqList;
    }
    //TODO: This is where the Requirements for Masters B get inputted into a List
    private void setReqList() {
        //See MasterA.java for format
    }
}
