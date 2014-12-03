package edu.umn.csci5801.model;

import java.util.List;

/**
 * Created by Justin on 12/2/2014.
 */
public class GradRequirements {
    private List<GradReqCheck> reqChecks;
    private List<Requirement> reqList;

    //constructor
    public GradRequirements(Degree deg, List<GradReqCheck> grc){
        reqList = createReqList(deg);
        testReqList(reqList, grc);
    }

    public List<GradReqCheck> getReqChecks() {
        return reqChecks;
    }

    public List<Requirement> getReqList() {
        return reqList;
    }

    //TODO:create ReqList based off of degree - calls degreeRequirement interface/factory thinger
    private List<Requirement> createReqList(Degree degree) {
        return reqList;
    }

    //TODO:test ReqList against student record contained in partially filled-in grc
    private void testReqList(List<Requirement> requirements, List<GradReqCheck> grc) {
    }
}
