package pdf;

abstract class Argument {
    char charInOpcode;

    public Argument(char charInOpcode) {
        this.charInOpcode = charInOpcode;
    }

    String toMachineCode(String opCode, String value){
        int valueIndex = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (Character character : opCode.toLowerCase().toCharArray()) {
            if (character == charInOpcode){
                stringBuffer.append(value.charAt(valueIndex));
                valueIndex++;
            } else {
                stringBuffer.append(character);
            }
        }
        return stringBuffer.toString();
    }

    static Argument getArgument(String arg){
        if (arg.toUpperCase().equals("K")){
            return new K();
        } else if (arg.toUpperCase().equals("RD")){
            return new Rd();
        } else if (arg.toUpperCase().equals("RR")){
            return new Rr();
        }
        return null;
    }
}

/**
 * Rd
 */
class Rd extends Argument{

    public Rd() {
        super('d');
    }

    
}

/**
 * Rr
 */
class Rr extends Argument{

    public Rr() {
        super('r');
    }
    
}

class K extends Argument{

    public K() {
        super('k');
    }

}


class RegisterPairArgument extends Argument{
    boolean preDecrement, postIncrement;
    public RegisterPairArgument(char charInOpcode, boolean preDecrement, boolean postIncrement) {
        super(charInOpcode);
        this.preDecrement = preDecrement;
        this.postIncrement = postIncrement;
    }

}

class Z extends RegisterPairArgument{

    public Z(char charInOpcode, boolean preDecrement, boolean postIncrement) {
        super(charInOpcode, preDecrement, postIncrement);
    }
    
}

class Y extends RegisterPairArgument{

    public Y(char charInOpcode, boolean preDecrement, boolean postIncrement) {
        super(charInOpcode, preDecrement, postIncrement);
    }



}

class X extends RegisterPairArgument{

    public X(char charInOpcode, boolean preDecrement, boolean postIncrement) {
        super(charInOpcode, preDecrement, postIncrement);
    }



}