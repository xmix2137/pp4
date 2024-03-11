package pl.ksikora.creditcard;

import java.math.BigDecimal;

public class CreditCard {

    private BigDecimal creditLimit;
    private BigDecimal balance;

    public void assignCredit(BigDecimal creditLimit){
        if (this.creditLimit != null){
            throw new CreditCantBeReassignedException();
        }
        if (isCreditBelowThreshold(creditLimit)){
            throw new CreditBelowThresholdException();
        }
    }


    private static boolean isCreditBelowThreshold(BigDecimal creditLimit) {
        return BigDecimal.valueOf(100).compareTo(creditLimit) > 0;
    }


    public BigDecimal getBalance() {
        return creditLimit;
    }

    public void pay(BigDecimal money) {
        if (!canAfford(money)){
            throw new NotEnoughMoneyException();
        }

        this.balance = this.balance.subtract(money);
    }

    private boolean canAfford(BigDecimal money){
        return this.balance.subtract(money).compareTo(BigDecimal.ZERO) > 0;
    }
}
