package Entity;

import java.sql.Date;

public class CreditCard {
    private String accountNumber,cardNumber,cvv2,password;
    private Date date;
    private TypeAccount typeAccount;

    public CreditCard(String accountNumber, String cardNumber, String cvv2, String password, Date date, TypeAccount typeAccount) {
        this.accountNumber = accountNumber;
        this.cardNumber = cardNumber;
        this.cvv2 = cvv2;
        this.password = password;
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

    public Date getDate() {
        return date;
    }

    public TypeAccount getTypeAccount() {
        return typeAccount;
    }


}
