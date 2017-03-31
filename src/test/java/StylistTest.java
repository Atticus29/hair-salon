import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {
  private Stylist testStylist;

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Before
  public void setUp() {
    testStylist = new Stylist ("Raven", "08:00-16:00MSN", "hair, corn rows");
  }

  @Test
  public void stylist_instantiatesCorrectly_true(){
    assertTrue(testStylist instanceof Stylist);
  }

  @Test
  public void getters_returnWhatTheyreSupposedTo_true(){
    assertEquals("Raven", testStylist.getName());
    assertEquals("08:00-16:00MSN", testStylist.getHours());
    assertEquals("hair, corn rows", testStylist.getSpecialties());
  }

}
