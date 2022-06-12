package pdf;

public class Syntax1Args extends Syntax{
    Argument firstArgument;

    public Syntax1Args(String syntax, String opcode, Argument argument) {
        super(syntax, opcode);
        firstArgument = argument;
    }

    @Override
    String toMachineCode(String instr) {
        String[] args = instr.split("\s")[1].split(",");
        if (args.length != 1){
            return null;
        }
        return firstArgument.toMachineCode(opCode, firstArgument.argToOpcode(args[0]));
    }
    
}
