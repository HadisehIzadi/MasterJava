package Plan;

public abstract class Risk {


    float coverage;
    float ceilling;
    float primuim;

    public boolean isCovered(String[] risksCoverd , String[] claim )
    {

        int i = 0;
        int j = 0;
        for (i = 0 ; i < claim.length ; i++)
        {
            for (j = 0 ; j < risksCoverd.length ; j++)
            {
                if (claim[i] == risksCoverd[j])
                    break;
                if (j == risksCoverd.length)
                    return false;
            }
        }
        return true;

    }

    public float getCoverage() {
        return coverage;
    }

    public float getCeilling() {
        return ceilling;
    }

    public float getPrimuim() {
        return primuim;
    }
}
