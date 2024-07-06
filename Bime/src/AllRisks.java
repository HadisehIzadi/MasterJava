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

    public String[] ObligatoryRiskCoverd = {"Third party Damage" , "Fire" , "Driver Damage"};
}
