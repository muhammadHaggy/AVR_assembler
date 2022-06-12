package pdf;

import java.util.regex.PatternSyntaxException;

public class Syntax0Args extends Syntax{

    public Syntax0Args(String syntax, String opcode) {
        super(syntax, opcode);
    }

    @Override
    String toMachineCode(String instr) {
        try {
            if (!instr.split("\s")[1].equals("NONE")) {
                return null;
            }
        } catch (IndexOutOfBoundsException|PatternSyntaxException e) {
        }
        return opCode;
    }
    
}
