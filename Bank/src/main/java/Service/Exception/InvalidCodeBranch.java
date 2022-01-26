package Service.Exception;

public class InvalidCodeBranch extends RuntimeException {

    public InvalidCodeBranch() {
    }

    public InvalidCodeBranch(String message) {
        super(message);
    }

    public InvalidCodeBranch(String message, Throwable cause) {
        super(message, cause);
    }

    public void codeBranchChecker(String codeBranch){
            if(codeBranch.length() > 10 )
                throw new InvalidCodeBranch("codeBranch can't more than ten number!");
            if(codeBranch.equals(""))
                throw new InvalidCodeBranch("dont enter space");
            for (Character ch:codeBranch.toCharArray()) {
                if(!Character.isDigit(ch))
                    throw new InvalidCodeBranch("code Branch have to be number!");
            }
        }

}
