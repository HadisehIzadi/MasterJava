public class DriverDamage extends Risk{

    @Override
    public float getCoverage() {
       return  0.05f;
    }

    @Override
    public float getCeilling() {
        return 0.7f;
    }

    @Override
    public float getPrimuim() {
        return 6f;
    }


    public String[] DriverRiskCoverd = {"Driver Damage "};
}
