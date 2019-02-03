$(document).ready(function(){
  $.ajax
  ({
      type:"GET",
      url:"/api/overview/demo",
      success:function(data)
      {
        window.location.href = "/menu.html"
      }
    })
  })
