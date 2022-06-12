package pdf;

public class Syntax2Args extends Syntax{
    Argument firstArgument, secondArgument;
    public Syntax2Args(String syntax, String opcode, Argument firstArgument, Argument secondArgument) {
        super(syntax, opcode);
        this.firstArgument = firstArgument;
        this.secondArgument = secondArgument;
    }

    @Override
    String toMachineCode(String instr) {
        String[] arg = instr.split("\s")[1].split(",");
        if (arg.length != 2){
            return null;
        }
        String firstOpcode = firstArgument.toMachineCode(opCode, firstArgument.argToOpcode(arg[0]));
        if (firstOpcode == null){
            return null;
        }
        return secondArgument.toMachineCode(firstOpcode, secondArgument.argToOpcode(arg[1]));
    }

    
}