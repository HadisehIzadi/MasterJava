public class AssistanceRisk extends Risk{


    @Override
    public float getCoverage() {
        return 0.6f;
    }

    @Override
    public float getCeilling() {
        return 0.8f;
    }

    @Override
    public float getPrimuim() {
        return 8f;
    }


    public String[] AssistanceRiskCoverd = {"Fire" , "Robbery" , "Transport" , "Car replacement"};
}
