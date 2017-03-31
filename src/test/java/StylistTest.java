import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;

public class StylistTest {
  private Stylist testStylist;

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Before
  public void setUp() {
    testStylist = new Stylist ("Raven", "08:00-16:00MSN", "hair, corn rows");
    testStylist.save();
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

  @Test
  public void all_returnsListOfStylists_true(){
    Stylist testStylist2 = new Stylist ("Raven", "08:00-16:00MSN", "hair, corn rows");
    testStylist2.save();
    List<Stylist> results = Stylist.all();
    assertEquals(2, results.size());
    assertEquals(false, results.get(0).equals(results.get(1)));
  }

  @Test
  public void save_addsEntryToDatabase_true(){
    Stylist retrievedStylist = Stylist.find(testStylist.getId());
    assertEquals(testStylist, retrievedStylist);
  }

  @Test
  public void find_returnsSecondStylist_true(){
    Stylist testStylist2 = new Stylist ("Raven", "08:00-16:00MSN", "hair, corn rows");
    testStylist2.save();
    int Stylist2Id = testStylist2.getId();
    assertEquals(testStylist2, Stylist.find(Stylist2Id));
  }

  @Test
  public void equals_correctlyAssessesTheEqualityOfStylistObjects_true(){
    Stylist testStylist2 = new Stylist ("Raven", "08:00-16:00MSN", "hair, corn rows");
    testStylist2.setId(testStylist.getId());
    assertEquals(testStylist, testStylist2);
  }

}
