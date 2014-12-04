package edu.umn.csci5801.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin on 12/2/2014.
 */
public class GradRequirements {
    private List<GradReqCheck> reqChecks;
    private List<Requirement> reqList;
    private Degree degree;

    //constructors
    public GradRequirements() {}
    public GradRequirements(Degree deg){
        //TODO:place in try/catch clause
        createReqList(deg);
    }
    public GradRequirements(Degree deg, List<GradReqCheck> grc, Degree d){
        //createReqList(deg);  *****UNCOMMENT AND HANDLE EXCEPTION*****
        testReqList(reqList, grc);
        degree = d;
    }

    public void setReqChecks(List<GradReqCheck> list) { reqChecks = list; }
    public void addReqCheck(GradReqCheck grc) { reqChecks.add(grc); }
    public void setReqList(List<Requirement> list) { reqList = list; }
    public void addRequirement(Requirement r) { reqList.add(r); }
    public void setDegree(Degree d) { degree = d; }

    public List<GradReqCheck> getReqChecks() { return reqChecks; }
    public List<Requirement> getReqList() { return reqList; }
    public Degree getDegree() { return degree; }

    public List<Requirement> createReqList(Degree degree) throws Exception {
        List<Requirement> rList = new ArrayList<Requirement>();
        if(degree == Degree.MS_A) {
            MasterA MSA = new MasterA();
            rList = MSA.getReqList();
        }
        else if(degree == Degree.MS_B) {
            MasterB MSB = new MasterB();
            rList = MSB.getReqList();
        }
        else if(degree == Degree.MS_C) {
            MasterC MSC = new MasterC();
            rList = MSC.getReqList();
        }
        else if(degree == Degree.PHD) {
            PHD phd = new PHD();
            rList = phd.getReqList();
        }
        else {
            Exception e = new Exception();
            throw e;
        }
        this.reqList = rList;
        return reqList;
    }

    //TODO:test ReqList against student record contained in partially filled-in grc
    private void testReqList(List<Requirement> requirements, List<GradReqCheck> grc) {
    }
}
