import java.util.Date;

public  class Account  implements Comparable{


    static  int nextAccNo = 10;
    int accNo;
    String owner;
    City city;
    char gender;
    Date openDate;
    double balance;

    public Account(String owner, City city, char gender) {
        accNo = nextAccNo;
        nextAccNo += 10;
        this.owner = owner;
        this.city = city;
        this.gender = gender;
        this.balance = 0.0;
        this.openDate = null;
    }


    public Account(int accNo, String owner, City city, char gender, double balance) {
        this.accNo = accNo;
        this.owner = owner;
        this.city = city;
        this.gender = gender;
        SetBalance(balance);
    }

    void SetBalance(double b)
    {
        balance = b > 0.0 ? b : 0.0 ;
    }


    @Override
    public String toString() {
        return "Account{" +
                "accNo=" + accNo +
                ", owner='" + owner + '\'' +
                ", city=" + city +
                ", gender=" + gender +
                ", openDate=" + openDate +
                ", balance=" + balance +
                '}';
    }

    @Override
    public int compareTo(Object o) {

        return this.owner.compareTo(((Account) o) .owner);
    }

    void deposit(double amount)
    {
        if(amount >0 )
            SetBalance(balance + amount);
    }

    double withdraw(double amount)
    {
        if(amount > 0 )
        {
            if (amount < balance)
                SetBalance(balance - amount);
            else {
                amount = balance ;
                SetBalance(0.0);
            }

            return  amount;
        }

        return 0.0;
    }
}
