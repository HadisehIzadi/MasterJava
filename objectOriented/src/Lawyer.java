public class Lawyer extends Employee{

    // Add this method only for lawyers
    public char getLawyerPosition(){
        return 'm';
    }

    @Override
    public double getSalary() {
        return super.getSalary() + 500;
    }
}
