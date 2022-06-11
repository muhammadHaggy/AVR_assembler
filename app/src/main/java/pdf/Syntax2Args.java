package pdf;

public class Syntax2Args extends Syntax{
    Argument firstArgument, secondArgument;
    public Syntax2Args(String syntax, String opcode) {
        super(syntax, opcode);
    }

    @Override
    String toMachineCode(String instr) {
        return null;
    }

    
}