import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.List;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      List<Stylist> stylists = Stylist.all();
      model.put("stylists", stylists);
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/stylist-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String stylistName = request.queryParams("stylist-name");
      String stylistHours = request.queryParams("stylist-hours");
      String stylistSpecialties = request.queryParams("stylist-specialties");
      String stylistImagePath = request.queryParams("stylist-image");
      Stylist newStylist = new Stylist(stylistName, stylistHours, stylistSpecialties, stylistImagePath);
      newStylist.save();
      response.redirect("/");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:stylistID", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String stylistName = request.params(":stylistid");
      Stylist stylist = Stylist.findByName(stylistName);
      model.put("stylist", stylist);
      System.out.println("Stylist's clients are " + stylist.getClients());
      model.put("template", "templates/stylist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists/:stylistID", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String stylistID = request.queryParams("stylistid");
      String clientName = request.queryParams("client-name");
      String clientPhone = request.queryParams("client-phone");
      String clientAddress = request.queryParams("client-address");
      String clientEmail = request.queryParams("client-email");
      String clientSpecial = request.queryParams("client-special");
      String clientStylistPref = request.queryParams("client-stylistPreference");
      String clientEmergencyName = request.queryParams("client-emergency-name");
      String clientEmergencyPhone = request.queryParams("client-emergency-phone");
      String okTextString = request.queryParams("client-textOpt");
      boolean okText = Boolean.parseBoolean(okTextString);
      model.put("template", "templates/stylist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:stylistID/clients/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String stylistName = request.params(":stylistID");
      int stylistID = Stylist.findByName(stylistName).getId();
      model.put("stylistName", stylistID);
      model.put("stylistID", stylistID);
      model.put("template", "templates/client-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists/:stylistID/update", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String stylistName = request.queryParams("stylist-name");
      String stylistHours = request.queryParams("stylist-hours");
      String stylistSpecialties = request.queryParams("stylist-specialties");
      String stylistImagePath = request.queryParams("stylist-image");
      Stylist currentStylist = Stylist.findByName(stylistName);
      currentStylist.update(stylistName, stylistHours, stylistSpecialties, stylistImagePath);
      String url = String.format("/stylists/%s", stylistName);
      response.redirect(url);
      // model.put("template", "templates/stylist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
