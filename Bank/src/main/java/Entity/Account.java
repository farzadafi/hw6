package Entity;
import java.math.BigInteger;

public class Account {
    private String codeBranch,nationalId,accountNumber;
    BigInteger budget;
    TypeAccount typeAccount;

    public Account(String codeBranch, String nationalId, String accountNumber, BigInteger budget,TypeAccount typeAccount) {
        this.codeBranch = codeBranch;
        this.nationalId = nationalId;
        this.accountNumber = accountNumber;
        this.budget = budget;
        this.typeAccount = typeAccount;
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

    public TypeAccount getTypeAccount() {
        return typeAccount;
    }
}