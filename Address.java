class Address
 {
    int pin;
    String city;
 
      Address(String city,int pin)
        {
            this.pin=pin;
            this.city=city;
        }
     public void displayAddress()
     {
        System.out.println("City"+city);
        System.out.println("Pincode"+pin);
     }
 }