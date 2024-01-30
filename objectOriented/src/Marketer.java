public class Marketer extends Employee {

    // this method is only for marketer
    public boolean insideMarket(){
        return true;
    }

    // change the working hours of marketer from 40 to 50

    @Override
    public int getHours() {
        return 50;
    }

    @Override
    public int getVacationDays() {
        return 20;
    }

    @Override
    public double getSalary() {
        return 5500;
    }

    @Override
    public String GetName() {
       String marketername = "hadi";
        return marketername;
    }
}
