package Plan;

public class Obligatory extends Risk{


    @Override
    public float getCoverage() {
        return 4f;
    }

    @Override
    public float getCeilling() {
        return 0.6f;
    }

    @Override
    public float getPrimuim() {
        return 0.01f;
    }

    public String[] ObligatoryRiskCoverd = {"Third party Damage "};
}
