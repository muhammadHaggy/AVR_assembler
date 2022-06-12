package pdf;

abstract class Argument {
    char charInOpcode;

    public Argument(char charInOpcode) {
        this.charInOpcode = charInOpcode;
    }

    String toMachineCode(String opCode, String value){
        if (value == null){
            return opCode;
        }
        
        int valueLength = 0;
        for (Character character : opCode.toLowerCase().toCharArray()) {
            if (character == charInOpcode){
                valueLength++;
            }
        }

        while (value.length() < valueLength) {
            value = "0" + value;
        }

        while (value.length() > valueLength) {
            value = value.substring(1);
        }


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

    abstract String argToOpcode(String arg);
}

/**
 * Rd
 */
class Rd extends Argument{

    public Rd() {
        super('d');
    }

    @Override
    String argToOpcode(String arg) {
        if (!arg.startsWith("R")){
            return null;
        }
        try {
            int registerNumber = Integer.parseInt(arg.substring(1));
            String argOpcode = Integer.toBinaryString(registerNumber);
            return argOpcode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
}

/**
 * Rr
 */
class Rr extends Argument{

    public Rr() {
        super('r');
    }

    @Override
    String argToOpcode(String arg) {
        if (!arg.startsWith("R")){
            return null;
        }
        try {
            int registerNumber = Integer.parseInt(arg.substring(1));
            String argOpcode = Integer.toBinaryString(registerNumber);
            return argOpcode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}

class K extends Argument{

    public K() {
        super('k');
    }

    @Override
    String argToOpcode(String arg) {
        try {
            return Integer.toBinaryString(Integer.parseInt(arg));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

}


class RegisterPairArgument extends Argument{
    boolean preDecrement, postIncrement;
    public RegisterPairArgument(char charInOpcode, boolean preDecrement, boolean postIncrement) {
        super(charInOpcode);
        this.preDecrement = preDecrement;
        this.postIncrement = postIncrement;
    }
    @Override
    String argToOpcode(String arg) {
        return null;
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