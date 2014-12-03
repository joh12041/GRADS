package edu.umn.csci5801.model;

import java.util.List;

/**
 * Created by Justin on 12/2/2014.
 */
public class GradReqCheck {
    private List<GradReqCheck> reqChecks;
    private List<Requirement> reqList;

    public List<GradReqCheck> getReqChecks() {
        return reqChecks;
    }

    public List<Requirement> getReqList() {
        return reqList;
    }

    public List<Requirement> createReqList(Degree degree) {
        return reqList;
    }

    public void testReqList(List<Requirement> requirements) {

    }
}
