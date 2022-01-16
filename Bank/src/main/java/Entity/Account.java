package Entity;
import java.math.BigInteger;

public class Account {
    private String codeBranck,nationalId,accountNumber;
    BigInteger budget;

    public Account(String codeBranck, String nationalId, String accountNumber, BigInteger budget) {
        this.codeBranck = codeBranck;
        this.nationalId = nationalId;
        this.accountNumber = accountNumber;
        this.budget = budget;
    }

    public String getCodeBranck() {
        return codeBranck;
    }

    public String getNationalId() {
        return nationalId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigInteger getBudget() {
        return budget;
    }
}
