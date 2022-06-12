package pdf;

public class Syntax0Args extends Syntax{

    public Syntax0Args(String syntax, String opcode) {
        super(syntax, opcode);
    }

    @Override
    String toMachineCode(String instr) {
        return opCode;
    }
    
}
