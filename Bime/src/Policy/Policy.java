package Policy;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Policy implements Serializable {
    static int policyNB = 0 ;
    Vehicle vehicle;
    List<String> risksCoverdList = new ArrayList<>();
    List<Float> premiumList = new ArrayList<>();
    List<Float> coverageList = new ArrayList<>();
    List<Float> ceillingList = new ArrayList<>();

    int ValidityYear;
    LocalDate policyDate;


    public Policy(Vehicle vehicle, List<String> risksCoverdList,
                  List<Float> premiumList, List<Float> coverageList,
                  List<Float> ceillingList, int validityYear,
                  LocalDate policyDate)
    {
        this.vehicle = vehicle;
        this.risksCoverdList = risksCoverdList;
        this.premiumList = premiumList;
        this.coverageList = coverageList;
        this.ceillingList = ceillingList;
        ValidityYear = validityYear;
        this.policyDate = policyDate;

        policyNB ++;
    }


    public static int getPolicyNB() {
        return policyNB;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public List<String> getRisksCoverdList() {
        return risksCoverdList;
    }

    public List<Float> getPremiumList() {
        return premiumList;
    }

    public List<Float> getCoverageList() {
        return coverageList;
    }

    public List<Float> getCeillingList() {
        return ceillingList;
    }

    public int getValidityYear() {
        return ValidityYear;
    }

    public LocalDate getPolicyDate() {
        return policyDate;
    }
}
