package pdf;

abstract class Argument {
    char charInOpcode;

    public Argument(char charInOpcode) {
        this.charInOpcode = charInOpcode;
    }

    String toMachineCode(String opCode, String value){
        int valueIndex = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (Character character : opCode.toCharArray()) {
            if (character == charInOpcode){
                stringBuffer.append(value.charAt(valueIndex));
                valueIndex++;
            } else {
                stringBuffer.append(character);
            }
        }
        return stringBuffer.toString();
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
        super('K');
    }

}