import org.sql2o.*;

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

}
