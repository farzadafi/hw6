package Entity;
import java.math.BigInteger;

public class Account {
    private String codeBranch,nationalId,accountNumber;
    BigInteger budget;

    public Account(String codeBranch, String nationalId, String accountNumber, BigInteger budget) {
        this.codeBranch = codeBranch;
        this.nationalId = nationalId;
        this.accountNumber = accountNumber;
        this.budget = budget;
    }

    public String getCodeBranch() {
        return codeBranch;
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
