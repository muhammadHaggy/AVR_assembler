/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package pdf;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class App {
    private static PDDocument pdDocument;
    private static PDFTextStripper pdfStripper;
    private static Map<String, Integer> pageNumberMap = new HashMap<String, Integer>();
    private static Map<String, Instruction> instrMap = new HashMap<String, Instruction>();
    private static Scanner scanner = new Scanner(System.in);

    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        try {
            pdDocument = PDDocument.load(new File("app/src/main/resources/atmel-0856-avr-instruction-set-manual.pdf"));
            pdfStripper = new PDFTextStripper();
            pdfStripper.setSortByPosition(true);

            initPageNumberMap();
            initCommandMap();

            while (true) {
                System.out.println("Tekan 1 untuk menampilkan Summary Instruksi AVR");
                System.out.println("Tekan 2 untuk konversi ke Machine Code");
                System.out.println("Tekan 99 untuk exit.");
                String in = scanner.nextLine();
                if (in.equals("1")) {
                    System.out.print("Instruksi: ");
                    System.out.println(instrMap.get(scanner.nextLine().toUpperCase()));
                } else if (in.equals("2")){
                    System.out.print("Instruksi: ");
                    String masukan = scanner.nextLine().toUpperCase();
                    System.out.println(instrMap.get(masukan).toMachineCode(masukan));
                } else {
                    System.out.println("keluar dari program...");
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String extractSyntax(String text, String command) {
        Pattern pattern = Pattern.compile("\\(i\\)\\s(" + command + "\\s.+?)\\s");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return (matcher.group(1));
        }
        return null;
    }

    private static String extractOpCode(String text) {
        Pattern pattern = Pattern.compile("\\w{4}\\s\\w{4}\\s\\w{4}\\s\\w{4}");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return (matcher.group());
        }
        return null;
    }

    private static String extractDescription(String text) {
        Pattern pattern = Pattern.compile("Description\\n+([\\s\\S]+?)Operation:");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return (matcher.group(1).replace('\n', ' '));
        }
        return null;

    }

    private static void initCommandMap() throws IOException {
        for (var entry : pageNumberMap.entrySet()) {
            pdfStripper.setStartPage(entry.getValue());
            pdfStripper.setEndPage(entry.getValue());
            String text = pdfStripper.getText(pdDocument);
            instrMap.put(entry.getKey(), new Instruction(extractDescription(text))
                    .addSyntax(new Syntax0Args(extractSyntax(text, entry.getKey()), extractOpCode(text))));
        }
    }

    private static void initPageNumberMap() throws IOException {
        Pattern pattern = Pattern.compile("\\s\\d+\\.\\s.+?(\\d+)");
        pdfStripper.setStartPage(2);
        pdfStripper.setEndPage(12);
        String text = pdfStripper.getText(pdDocument);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            if (matcher.group().contains(" – ")) {
                String instr = matcher.group().split(" – ")[0].split("\\.")[1].strip().split("\\s")[0];
                pageNumberMap.put(instr, Integer.parseInt(matcher.group(1)));
            }
        }
    }
}