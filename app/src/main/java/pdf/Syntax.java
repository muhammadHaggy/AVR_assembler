package pdf;

abstract class Syntax {
    String syntax, opCode;
    
    public Syntax(String syntax, String opcode) {
        this.syntax = syntax;
        this.opCode = opcode;
    }

    String getSyntax() {
        return syntax;
    }

    String getOpcode() {
        return opCode;
    }

    abstract String toMachineCode(String instr);

    @Override
    public String toString() {
        return "Syntax: " + syntax + "\t\t\t" + "Opcode: " + opCode;
    }
}
