
var timer = null;
$('#Searchbox').keydown(function(){
       clearTimeout(timer); 
       timer = setTimeout(Search, 500)
});



function Search(){
    
    var movie=document.getElementById("Searchbox").value;
    var link='http://www.omdbapi.com/?apikey=e29f9474&t='+movie;
    console.log(link);
   
    $.getJSON(link).then(function(response){
      console.log(response);
      if(response.Response=="False"){
        document.getElementById("btn").style.opacity="0";
        document.getElementById("btn").disabled = true;

        var target=document.getElementsByClassName("results");
        for(var i=0;i<target.length;i++){
            target[i].style.opacity="0";
        }
        var array=document.getElementsByClassName("results2");
     for(var i=0;i<array.length;i++){
         array[i].style.opacity="0";
     }
    }else{

        var array=document.getElementsByClassName("results2");
     for(var i=0;i<array.length;i++){
         array[i].style.opacity="0";
     }

       

        
        var target=document.getElementsByClassName("results");
        for(var i=0;i<target.length;i++){
            target[i].style.opacity="1";
        }



        if(response.Poster=="N/A"){
                document.getElementById("poster").style.opacity="0";}else{
                    document.getElementById("poster").style.opacity="1";
                }
       document.getElementById("btn").style.opacity="1";
       document.getElementById("btn").disabled = false;
       document.getElementById("poster").src=response.Poster;
       document.getElementById("desc").innerHTML="Description:"+response.Plot;
       document.getElementById("runtime").innerHTML="Runtime:"+response.Runtime;
       document.getElementById("year").innerHTML="Release date:"+response.Released;
       document.getElementById("title").innerHTML="Title:"+response.Title;
       document.getElementById("country").innerHTML="Country/Countries:"+response.Country;
       document.getElementById("actors").innerHTML="Actor(s):"+response.Actors;
       document.getElementById("director").innerHTML="Director(s):"+response.Director;
       document.getElementById("rating").innerHTML="Imdb rating:"+response.imdbRating;
       document.getElementById("writer").innerHTML="Writer(s):"+response.Writer;
       document.getElementById("awards").innerHTML="Awards:"+response.Awards;
       document.getElementById("movieTitle").value=response.Title;
       

      

    }
          
      }
    )
    
  }

  var button = document.getElementById("btn").addEventListener('click',function(){
     var array=document.getElementsByClassName("results2");
     for(var i=0;i<array.length;i++){
         array[i].style.opacity="1";
     }

     


  })