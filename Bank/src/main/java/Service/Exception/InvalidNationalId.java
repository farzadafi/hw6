package Service.Exception;

public class InvalidNationalId extends RuntimeException {
    public InvalidNationalId() {
    }

    public InvalidNationalId(String message) {
        super(message);
    }

    public InvalidNationalId(String message, Throwable cause) {
        super(message, cause);
    }

    public void nationalIdChecker(String nationalId){
        if(nationalId.length() > 10 )
            throw new InvalidNationalId("national Id can't more than ten number!");
        if(nationalId.equals(""))
            throw new InvalidNationalId("dont enter space!");
        for (Character ch:nationalId.toCharArray()) {
            if(!Character.isDigit(ch))
                throw new InvalidNationalId("national Id should be just number!");
        }
    }
}
