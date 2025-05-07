class singletonex {
    private static singletonex dbObject;
 
    private singletonex() {      
    }
 
    public static singletonex getInstance() {
 
       // create object if it's not already created
       if(dbObject == null) {
          dbObject = new singletonex();
       }
 
        // returns the singleton object
        return dbObject;
    }
 
    public void getConnection() {
        System.out.println("You are now connected to ths singletonex.");
    }
 }
 class Main {
    public static void main(String[] args) {
       Database db1;
 
       // refers to the only object of Database
       db1= Database.getInstance();
       
       db1.getConnection();
    }
 }
 