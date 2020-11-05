package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    Varasto varasto2;
    Varasto varasto3;
    Varasto varasto4;
    
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
        
        
        varasto4 = new Varasto(-10, 20);
        
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
        
    }
    
    @Test
    public void konstruktoriLuoNegVaraston() {
        varasto = new Varasto(-10);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
        
    }

    @Test
    public void konstruktoriLuoPieniVarstoSuuriSaldoVaraston() {
        varasto = new Varasto(10, 20);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
        
    }
    
    @Test
    public void konstruktoriLuoNeg1VarstoSuuriSaldoVaraston() {
        varasto = new Varasto(10, -20);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
        
    }
    
    @Test
    public void lisaaVarastostaNeg() {
        varasto = new Varasto(10,8);
        varasto.lisaaVarastoon(-1);
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
        
    }
    @Test
    public void otaVarastostaNeg() {
        varasto = new Varasto(10,8);
        varasto.otaVarastosta(-1);
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
        
    }

    @Test
    public void konstruktoriLuoNegVarstoSuuriSaldoVaraston() {
        assertEquals(-10, varasto4.getSaldo(), vertailuTarkkuus);
        
    }
    
    @Test
    public void konstruktoriLuoAlkuSaldoPienVarstoSuuriSaldoVaraston() {
        varasto = new Varasto(10, 1);
        assertEquals(1, varasto.getSaldo(), vertailuTarkkuus);
        
    }
    @Test
    public void toStringTest() {
    varasto = new Varasto(10, 1);

    String vastaus = varasto.toString();

    assertEquals("saldo = 1.0, vielä tilaa 9.0", vastaus);
}
    
    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    
    
    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    @Test
    public void varastonSaldoRiittää1() {
        varasto.otaVarastosta(10);

        double saatuMaara = varasto.otaVarastosta(12);

        assertEquals(0, saatuMaara, vertailuTarkkuus);
    }
     @Test
    public void varastonSaldoRiittää2() {
        varasto.lisaaVarastoon(10);

        varasto.lisaaVarastoon(10);

        assertEquals(0, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

}