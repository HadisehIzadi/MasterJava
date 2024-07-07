package Plan;

public class AllRisks extends Risk{

    @Override
    public float getCoverage() {
        return 0.75f;
    }

    @Override
    public float getCeilling() {
        return 1f;
    }

    @Override
    public float getPrimuim() {
        return 10f;
    }

    public String[] ObligatoryRiskCoverd = {"Fire",
            "Robbery",
            "Third Party Damage",
            "Vehicle Damage",
            "Driver Damage",
            "Transport",
            "Car Replacement"};
}
