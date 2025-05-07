public class Loan {
    private double interestRate;
    private String customer;
    private String lender;

    public static Loan createLoan(String lender) {
        Loan loan = new Loan();
        loan.lender = lender;
        return loan;
    }

    public static Loan createLoan(String lender, double interestRate) {
        Loan loan = new Loan();
        loan.lender = lender;
        loan.interestRate = interestRate;
        return loan;
    }

    @Override
    public String toString() {
        return "customer "+this.customer+" \n"+
        "interestrate: "+this.interestRate+"\n"+
        "lender: "+this.lender+"\n";
    }
    public int number(int a){
     return a*a;
    }

}
