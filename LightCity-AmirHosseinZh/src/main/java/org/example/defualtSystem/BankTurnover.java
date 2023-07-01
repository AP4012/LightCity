package org.example.defualtSystem;

public class BankTurnover {
    private double withdraw  = 0;
    private double deposit = 0;

    /**
     * @param amount : Money amount
     * @param type : -1 for withdraw , +1 for deposit
     * */
    public void transfer(float amount,int type){
        if(type == 1)
            deposit=amount;
        else if (type==-1)
            withdraw+=amount;
    }
    public double calcTurnover(){
        return deposit-withdraw;
    }
}
