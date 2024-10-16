fetch("data.json")
  .then(risposta => risposta.json())
  .then(valori => {
  
    document.getElementById("title").innerHTML = valori.Title;
    document.getElementById("poster").src = valori.Poster;
    document.getElementsByClassName("contenuto")[0].innerHTML = valori.Plot;
    document.getElementsByClassName("contenuto")[1].innerHTML += valori.Awards;
    document.getElementsByClassName("contenuto")[2].innerHTML += valori.Metascore;
    document.getElementsByClassName("contenuto")[3].innerHTML += valori.Director;
    document.getElementById("footer").innerHTML += valori.Writer;
  
    for (let i = 0; i < valori.Actors.length; i++) {
      document.getElementsByClassName("name")[i].innerHTML = valori.Actors[i];
      document.getElementsByTagName("img")[i + 1].src = valori.Images[i]
    }
  
  })
  











