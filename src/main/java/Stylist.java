import org.sql2o.*;
import java.util.List;

public class Stylist {
  private int id;
  private String name;
  private String hours;
  private String specialties;

  public Stylist(String name, String hours, String specialties) {
    this.name = name;
    this.hours = hours;
    this.specialties = specialties;
  }

  // Add validate hours method

  public String getName(){
    return this.name;
  }

  public String getHours(){
    return this.hours;
  }

  public String getSpecialties(){
    return this.specialties;
  }

  public int getId(){
    return this.id;
  }

  public void setId(int id){
    this.id = id;
  }

  @Override
  public boolean equals(Object secondStylist){
    if(!(secondStylist instanceof Stylist)){
      return false;
    } else{
      Stylist newStylist = (Stylist) secondStylist;
      return newStylist.getName().equals(this.getName()) &&
      newStylist.getHours().equals(this.getHours()) &&
      newStylist.getSpecialties().equals(this.getSpecialties()) &&
      newStylist.getId() == this.getId();
    }
  }

  public void save(){
    String sqlCommand = "INSERT INTO stylists (name, hours, specialties) VALUES (:name, :hours, :specialties);";
    try(Connection con=DB.sql2o.open()){
      this.id = (int) con.createQuery(sqlCommand, true)
      .addParameter("name", this.name)
      .addParameter("hours", this.hours)
      .addParameter("specialties", this.specialties)
      .executeUpdate()
      .getKey();
    }
  }

  public static Stylist find(int id){
    String sqlCommand = "SELECT * FROM stylists WHERE id=:id;";
    try(Connection con = DB.sql2o.open()){
      Stylist result = con.createQuery(sqlCommand)
      .addParameter("id", id)
      .executeAndFetchFirst(Stylist.class);
      return result;
    }
  }

  public static List<Stylist> all(){
    String sqlCommand = "SELECT * FROM stylists;";
    try(Connection con = DB.sql2o.open()){
      List<Stylist> results = con.createQuery(sqlCommand)
      .executeAndFetch(Stylist.class);
      return results;
    }
  }

  public List<Client> getClients(){
    String sqlCommand = "SELECT * FROM clients WHERE stylistid=:stylistid;";
    try(Connection con = DB.sql2o.open()){
      List<Client> results = con.createQuery(sqlCommand)
      .addParameter("stylistid", this.id)
      .executeAndFetch(Client.class);
      return results;
    }
  }

  public void update(String name, String hours, String specialties){
    String sqlCommand = "UPDATE stylists SET name=:name, hours=:hours, specialties=:specialties WHERE id=:id;";
    try(Connection con=DB.sql2o.open()){
      con.createQuery(sqlCommand)
      .addParameter("name", name)
      .addParameter("hours", hours)
      .addParameter("specialties", specialties)
      .addParameter("id", this.id)
      .executeUpdate();
    }
  }

  public void delete(){
    String sqlCommand = "DELETE FROM stylists WHERE id=:id;";
    try(Connection con=DB.sql2o.open()){
      con.createQuery(sqlCommand)
        .addParameter("id", this.id)
        .executeUpdate();
    }
  }

}
