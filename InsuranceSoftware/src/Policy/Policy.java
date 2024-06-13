package Policy;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Policy implements Serializable {
    static int policyNB = 0;    // class variable
    Vehicle vehicle;
    List<String> risksCoveredLIST = new ArrayList<>();

    List<Float> premiumLIST = new ArrayList<>();
    List<Float> coverageLIST = new ArrayList<>();
    List<Float> ceilingLIST = new ArrayList<>();

    int validityYear;
    LocalDate policyDate;


    public Policy(Vehicle vehicle, List<String> risksCoveredLIST, List<Float> premiumLIST, List<Float> coverageLIST, List<Float> ceilingLIST, int validityYear, LocalDate policyDate) {
        this.vehicle = vehicle;
        this.risksCoveredLIST = risksCoveredLIST;
        this.premiumLIST = premiumLIST;
        this.coverageLIST = coverageLIST;
        this.ceilingLIST = ceilingLIST;
        this.validityYear = validityYear;
        this.policyDate = policyDate;
        policyNB +=1;
    }

    public static int getPolicyNB() {
        return policyNB;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public List<String> getRisksCoveredLIST() {
        return risksCoveredLIST;
    }

    public List<Float> getPremiumLIST() {
        return premiumLIST;
    }

    public List<Float> getCoverageLIST() {
        return coverageLIST;
    }

    public List<Float> getCeilingLIST() {
        return ceilingLIST;
    }

    public int getValidityYear() {
        return validityYear;
    }

    public LocalDate getPolicyDate() {
        return policyDate;
    }

    @Override
    public String toString() {
        return  "Policy NB: " + policyNB +
                "\n" + vehicle +
                "\nValidity Year: " + validityYear;

    }
}
