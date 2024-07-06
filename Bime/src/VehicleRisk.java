public class VehicleRisk extends Risk{

    @Override
    public float getCoverage() {
        return 0.9f;
    }

    @Override
    public float getCeilling() {
        return 0.7f;
    }

    @Override
    public float getPrimuim() {
        return 0.05f;
    }

    public String[] vehicleRiskCoverd = {"Vehicle Risk"};
}
