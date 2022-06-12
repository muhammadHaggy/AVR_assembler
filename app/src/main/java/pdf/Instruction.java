package pdf;

import java.util.ArrayList;

class Instruction {
    String description;
    ArrayList<Syntax> syntaxList = new ArrayList<Syntax>();

    String getDescription() {
        return description;
    }

    public Instruction(String description){
        this.description = description;
    }

    Instruction addSyntax(Syntax newSyntax){
        syntaxList.add(newSyntax);
        return this;
    }

    String toMachineCode(String instr){
        for (Syntax syntax : syntaxList) {
            String result = syntax.toMachineCode(instr);
            if (result != null){
                return result;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String result = "Description: " + description + "\n";
        for (Syntax syntax : syntaxList) {
            result += syntax + "\n";
        }
        return result;
    }
}
