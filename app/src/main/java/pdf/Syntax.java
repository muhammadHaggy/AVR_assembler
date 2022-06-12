package pdf;

abstract class Syntax {
    String syntax, opcode;
    
    public Syntax(String syntax, String opcode) {
        this.syntax = syntax;
        this.opcode = opcode;
    }

    String getSyntax() {
        return syntax;
    }

    String getOpcode() {
        return opcode;
    }

    abstract String toMachineCode(String instr);

    @Override
    public String toString() {
        return "Syntax: " + syntax + "\t\t\t" + "Opcode: " + opcode;
    }
}
