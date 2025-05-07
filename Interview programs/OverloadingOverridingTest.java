
public class OverloadingOverridingTest {

    public static void main(String[] args) {

        // Example of method overloading in Java
        Loan cheapLoan = Loan.createLoan("HSBC");
        Loan veryCheapLoan = Loan.createLoan("Citibank", 8.5);
        System.out.println(cheapLoan);
        System.out.println(veryCheapLoan);
        //in overloading which method will be called is simply decided at the compile time by identifying the signature of the method, ie type, numbers, order of the arguements
        // Example of method overriding in Java
        Loan personalLoan = new PersonalLoan();
       System.out.println( personalLoan.number(4));
       System.out.println(new Loan().number(4));
// while calling a overriden a method, the oject of whichever class is calling the method , the method of that class will get called,
//for ex here personalLoan is object of class PersonalLoan so method of class personalLoan will get called and not the method of Loan class
// to call overriden method number() of Loan class we will call it using object of Loan class 
    }

}




