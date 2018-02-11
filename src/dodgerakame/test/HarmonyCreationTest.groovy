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

    void testConstrutors(){
        Assert.assertNotNull(harmony);
        Assert.assertNotNull(harmony.getParser());
        Assert.assertNotNull(harmony.getParser().getContent());
        Assert.assertNotNull(harmony.getUst());
    }

    void testProcessHarmonyCreation() {
        Assert.assertNotNull(harmony.ProcessHarmonyCreation("3"));
        Assert.assertNotNull(harmony.ProcessHarmonyCreation("5"));
        Assert.assertNotNull(harmony.ProcessHarmonyCreation("-3"));
        Assert.assertNotNull(harmony.ProcessHarmonyCreation("-5"));
        Assert.assertNotNull(harmony.ProcessHarmonyCreation("NotesRangeLower2"));
        Assert.assertNull(harmony.ProcessHarmonyCreation(""));
    }


    void testProcessWithRange2() {
       List<String> destRange2 = new ArrayList<String>();
        destRange2 = harmony.ProcessWithRangeLower2();

        Assert.assertNotNull(destRange2);
        Assert.assertNotEquals(destRange2, harmony.getParser().getContent());
    }

    void testProcessWithNumber() {
        List<String> destNum1 = new ArrayList<String>();
        destNum1 = harmony.ProcessWithNumber(3)

        Assert.assertNotNull(destNum1);
        Assert.assertNotEquals(destNum1, harmony.getParser().getContent());
    }
}
