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

  @Test
  public void getClients_returns_listOfClients_true(){
    int stylistID = testStylist.getId();
    Client testClient1 = new Client(1, "Victoria Porkchop Parker", "6095779090", "1 Porkchop Avenue Portland, OR 97217", "thatNoseThough@gmail.com", "Make sure to say hey to her", "Naomi Smalls", "Bennett Bennettson", "6095779091", true);
    testClient1.setStylistId(stylistID);
    testClient1.save();
    Client testClient2 = new Client(1, "Jade Jolie", "6095778080", "1 Lippy Lane Gainesville, FL 97213", "tuna_on_a_platter@gmail.com", "Make sure her hips match her shoulders", "Kim Chi", "Rebecca Rebeccasdottir", "6095778081", true);
    testClient2.setStylistId(stylistID);
    testClient2.save();
    Client testClient3 = new Client(1, "Jade Jolie Clone", "6095778080", "1 Lippy Lane Gainesville, FL 97213", "tuna_on_a_platter@gmail.com", "Make sure her hips match her shoulders", "Kim Chi", "Rebecca Rebeccasdottir", "6095778081", true);
    testClient3.setStylistId(stylistID);
    testClient3.save();
    List<Client> results = testStylist.getClients();
    assertEquals(3, results.size());
    assertEquals(testClient3, results.get(2));
  }

  @Test
  public void update_changesTheValuesOfAStylistInDatabase_true(){
    Stylist retrievedStylist = Stylist.find(testStylist.getId());
    assertTrue(retrievedStylist.equals(testStylist));
    testStylist.update("JuJuBe", "08:00-16:00MSN", "hair, corn rows");
    assertFalse(retrievedStylist.equals(Stylist.find(testStylist.getId())));
  }

  @Test
  public void delete_removesEntryFromDatabase_true(){
    Stylist testStylist2 = new Stylist ("JuJuBe", "08:00-16:00MSN", "hair, corn rows");
    testStylist2.save();
    assertEquals(2, Stylist.all().size());
    testStylist2.delete();
    assertEquals(1, Stylist.all().size());
  }

}
