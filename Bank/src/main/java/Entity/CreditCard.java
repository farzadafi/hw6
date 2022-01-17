package Entity;

import java.sql.Date;

public class CreditCard {
    private String accountNumber,cardNumber,cvv2,password,date;
    private TypeAccount typeAccount;

    public CreditCard(String accountNumber, String cardNumber, String cvv2, String date, TypeAccount typeAccount) {
        this.accountNumber = accountNumber;
        this.cardNumber = cardNumber;
        this.cvv2 = cvv2;
        this.date = date;
        this.typeAccount = typeAccount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvv2() {
        return cvv2;
    }

    public String getPassword() {
        return password;
    }

    public String getDate() {
        return date;
    }

    public TypeAccount getTypeAccount() {
        return typeAccount;
    }


}
