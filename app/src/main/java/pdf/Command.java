package pdf;

public class Command implements Instruction{
    String description, syntax, opCode;

    public Command(String description, String syntax, String opCode){
        this.description = description;
        this.syntax = syntax;
        this.opCode = opCode;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getSyntax() {
        return syntax;
    }

    @Override
    public String getOpCode() {
        return opCode;
    }
    
    @Override
    public String toString() {
        return description + "\n" + syntax + "\n" + opCode;
    }
}
