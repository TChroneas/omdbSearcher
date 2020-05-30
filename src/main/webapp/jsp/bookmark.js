var buttons=document.getElementsByClassName("bookmark");


for (let i = 0, l = buttons.length; i < l; i++) {

    buttons[i].onclick=function () {
        var x = buttons[i].value;
        var link='http://www.omdbapi.com/?apikey=e29f9474&t='+x;

        $.getJSON(link).then(function(response) {
            console.log(response);
            document.getElementById("poster").src=response.Poster;
            var target=document.getElementsByClassName("results");
            for(var i=0;i<target.length;i++){
                target[i].style.opacity="1";
            }
            var array=document.getElementsByClassName("results2");
            for(var i=0;i<array.length;i++){
                array[i].style.opacity="1";
            }
            if(response.Poster=='N/A'){
                document.getElementById("poster").style.opacity="0";

            }else{
                document.getElementById("poster").style.opacity="1";
            }
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
















        })

    }


    }





