package pdf;

public class Syntax1Args extends Syntax{
    Argument firstArgument;

    public Syntax1Args(String syntax, String opcode) {
        super(syntax, opcode);
    }

    @Override
    String toMachineCode(String instr) {
        return null;
    }
    
}
