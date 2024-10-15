

let strjson = `{
    "Title": "I Am Legend",
    "Year": "2007",
    "Rated": "PG-13",
    "Released": "14 Dec 2007",
    "Runtime": "101 min",
    "Genre": "Drama, Horror, Sci-Fi",
    "Director": "Francis Lawrence",
    "Writer": "Mark Protosevich (screenplay), Akiva Goldsman (screenplay), Richard Matheson (novel), John William Corrington, Joyce Hooper Corrington",
    "Actors": ["Will Smith", "Alice Braga", "Charlie Tahan", "Salli Richardson-Whitfield"],
    "Plot": "Years after a plague kills most of humanity and transforms the rest into monsters, the sole survivor in New York City struggles valiantly to find a cure.",
    "Language": "English",
    "Country": "USA",
    "Awards": "9 wins & 21 nominations.",
    "Poster": "https://static1.srcdn.com/wordpress/wp-content/uploads/2021/02/I-Am-Legend-Cropped.jpg?q=50&fit=crop&w=1140&h=&dpr=1.5",
    "Metascore": "65",
    "imdbRating": "7.2",
    "imdbVotes": "533,874",
    "imdbID": "tt0480249",
    "Type": "movie",
    "Response": "True",
    "Images": [
      "https://images-na.ssl-images-amazon.com/images/M/MV5BMTI0NTI4NjE3NV5BMl5BanBnXkFtZTYwMDA0Nzc4._V1_.jpg",
      "https://images-na.ssl-images-amazon.com/images/M/MV5BMTIwMDg2MDU4M15BMl5BanBnXkFtZTYwMTA0Nzc4._V1_.jpg",
      "https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5MDM1OTU5OV5BMl5BanBnXkFtZTYwMjA0Nzc4._V1_.jpg",
      "https://images-na.ssl-images-amazon.com/images/M/MV5BMTA0MTI2NjMzMzFeQTJeQWpwZ15BbWU2MDMwNDc3OA@@._V1_.jpg"
    ]
}`;

let obj = JSON.parse(strjson);
console.log(obj);

document.getElementById("title").innerHTML = obj.Title;
document.getElementById("poster").src = obj.Poster;
document.getElementsByClassName("contenuto")[0].innerHTML = obj.Plot;
document.getElementsByClassName("contenuto")[1].innerHTML += obj.Awards;
document.getElementsByClassName("contenuto")[2].innerHTML += obj.Metascore;
document.getElementsByClassName("contenuto")[3].innerHTML += obj.Director;

for (let i = 0; i < obj.Actors.length; i++) {
document.getElementsByClassName("name")[i].innerHTML = obj.Actors[i];
document.getElementsByTagName("img")[i + 1].src = obj.Images[i]
}






