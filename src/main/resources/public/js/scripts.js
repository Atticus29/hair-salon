$(function(){
  $("#stylist-reveal").click(function(){
    event.preventDefault();
    $("#about-content").hide();
    $("#main-content").show();
  });

  $("#about-reveal").click(function(){
    event.preventDefault();
    $("#main-content").hide();
    $("#about-content").show();
  });
});
