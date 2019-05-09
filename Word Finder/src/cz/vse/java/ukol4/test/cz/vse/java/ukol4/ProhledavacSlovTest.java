package cz.vse.java.ukol4;

import org.junit.Assert;
import org.junit.Test;

public class ProhledavacSlovTest {


    @Test
    public void obsahujeSlovo() {
        ProhledavacSlov hledac = new ProhledavacSlov();
        String[] radky = new String[3];
        String slovo = "let";
        radky[0] = "let";
        radky[1] = "letadlo";
        radky[2] = "ULETÍ";
        Assert.assertTrue(hledac.obsahujeSlovo(radky[0], slovo));
        Assert.assertFalse(hledac.obsahujeSlovo(radky[1], slovo));
        Assert.assertFalse(hledac.obsahujeSlovo(radky[2], slovo));
    }
}
