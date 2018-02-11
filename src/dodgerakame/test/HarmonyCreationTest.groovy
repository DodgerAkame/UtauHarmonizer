package dodgerakame.test

import dodgerakame.controller.HarmonyCreation
import dodgerakame.model.UST
import org.junit.Assert

class HarmonyCreationTest extends groovy.util.GroovyTestCase {

    private UST ust;
    private HarmonyCreation harmony;

    @Override
    void setUp() {
        ust = new UST("src/dodgerakame/main.ust");
        harmony = new HarmonyCreation(ust);
    }

    void testProcessHarmonyCreation() {
        Assert.assertNotNull(harmony);
        Assert.assertNotNull(harmony.getParser());
        Assert.assertNotNull(harmony.getParser().getContent());
        Assert.assertNotNull(harmony.getUst());
    }

    void testProcessWithRange1() {
       /* List<String> destRange1 = new ArrayList<String>();
        destRange1 = harmony.ProcessWithRange1();

        Assert.assertNotNull(destRange1);
        Assert.assertNotEquals(destRange1, harmony.getParser().getContent());*/
    }

    void testProcessWithRange2() {
       /* List<String> destRange2 = new ArrayList<String>();
        destRange2 = harmony.ProcessWithRange2();

        Assert.assertNotNull(destRange2);
        Assert.assertNotEquals(destRange2, harmony.getParser().getContent());*/
    }

    void testProcessWithNumber() {
        List<String> destNum1 = new ArrayList<String>();
        destNum1 = harmony.ProcessWithRange1();

        Assert.assertNotNull(destNum1);
        Assert.assertNotEquals(destNum1, harmony.getParser().getContent());
    }
}
