<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }
  </style>
</head>
<body>

<div class="container">
  <!-- <h2>Activate Carousel with JavaScript</h2> -->
  <div id="myCarousel" class="carousel slide">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li class="item1 active"></li>
      <li class="item2"></li>
      <li class="item3"></li>
      <li class="item4"></li>
      <li class="item5"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">

      <div class="item active">
        <img src="<%=request.getContextPath()%>/images/avengers1.jpg" alt="Chania" width="460" height="345">
        <div class="carousel-caption">
         <!--  <h3>Chania</h3>
          <p>The atmosphere in Chania has a touch of Florence and Venice.</p> -->
        </div>
      </div>

      <div class="item">
        <img src="<%=request.getContextPath()%>/images/avengers2.jpg" alt="Chania" width="460" height="345">
        <div class="carousel-caption">
         <!--  <h3>Chania</h3>
          <p>The atmosphere in Chania has a touch of Florence and Venice.</p> -->
        </div>
      </div>
    
      <div class="item">
        <img src="<%=request.getContextPath()%>/images/avengers3.jpg" alt="Flower" width="460" height="345">
        <div class="carousel-caption">
          <!-- <h3>Flowers</h3>
          <p>Beautiful flowers in Kolymbari, Crete.</p> -->
        </div>
      </div>

      <div class="item">
        <img src="<%=request.getContextPath()%>/images/avengers4.jpg" alt="Flower" width="460" height="345">
        <div class="carousel-caption">
          <!-- <h3>Flowers</h3>
          <p>Beautiful flowers in Kolymbari, Crete.</p> -->
        </div>
      </div>
      
        <div class="item">
        <img src="<%=request.getContextPath()%>/images/avengers5.jpg" alt="Flower" width="460" height="345">
        <div class="carousel-caption">
        <!--   <h3>Flowers</h3>
          <p>Beautiful flowers in Kolymbari, Crete.</p> -->
        </div>
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a> 
  </div>
</div>

<script>
$(document).ready(function(){
    // Activate Carousel
    $("#myCarousel").carousel();
    
    // Enable Carousel Indicators
    $(".item1").click(function(){
        $("#myCarousel").carousel(0);
    });
    $(".item2").click(function(){
        $("#myCarousel").carousel(1);
    });
    $(".item3").click(function(){
        $("#myCarousel").carousel(2);
    });
    $(".item4").click(function(){
        $("#myCarousel").carousel(3);
    });
    
    // Enable Carousel Controls
    $(".left").click(function(){
        $("#myCarousel").carousel("prev");
    });
    $(".right").click(function(){
        $("#myCarousel").carousel("next");
    });
});
</script>

</body>
</html>