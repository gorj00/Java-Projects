package WordFinder;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProhledavacSlov {
    final private Scanner scanner = new Scanner(System.in);

    private String umisteni = null;
    private String slovo = null;
    private int pocetRadku =  0;

    /**
     * Vstup od uživatele: cesta k textovému souboru
     */
    private void zadejUmisteni() {
        System.out.print("Umístění souboru: ");
        umisteni = scanner.nextLine();
    }

    /**
     * Vstup od uživatele: hledané slovo v textovém souboru
     */
    private void zadejSlovo() {
        System.out.print("Hledané slovo: ");
        slovo = scanner.nextLine();
    }

    /**
     * Testuje, zda daný řádek obsahuje přesnou shodu se slovem
     *
     * @param radek          řádek .txt souboru testovaný pro shodu se slovem
     * @param hledaneSlovo   slovo, se kterým se bude hledat shoda v řádku
     *
     * @return true          shoda nalezena
     *         false         shoda nenalezena
     */
    public boolean obsahujeSlovo(String radek, String hledaneSlovo) {
        String regex = "\\b" + hledaneSlovo + "\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(radek);
        return matcher.matches();
    }

    /**
     * Přijímá dva vstupy pro načtení textového souboru a testování
     * jeho řádků pro shodu se zadaným slovem.
     *
     * Následně do konzole vypisuje počet řádků, ve kterých byla
     * nalezena shoda s hledaným slovem.
     *
     * @see #zadejUmisteni()
     * @see #zadejSlovo()
     * @see #obsahujeSlovo(String, String)
     */
    public void vyhledejSlovo () {
        try {
            // Vstupy
            zadejUmisteni();
            zadejSlovo();

            // Načtení souboru
            FileInputStream fis = new FileInputStream(umisteni);
            DataInputStream dos = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(dos));

            // Aktuální testovaný řádek
            String testovanyRadek;

            // Testování celého textového souboru a navyšování počtu shod
            while ((testovanyRadek = br.readLine()) != null) {
                if (obsahujeSlovo(testovanyRadek, slovo)) {
                    pocetRadku++;
                }
            }

            // Po dokončení testování vypiš počet řádků se shodou
            System.out.println("Počet řádků se slovem \"" + slovo + "\" je: "
                    + pocetRadku);
            dos.close();
            fis.close();
        } catch (FileNotFoundException error) {
            System.out.println("Soubor nenalazen!");
            error.printStackTrace();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
