import React, {useState} from 'react'
import '../../App.css'
import './Favorites.css';

var favorites = [];
var recents = [];

function Favorites () {
    const [recentImageURL, setRecentImageURL] = useState('/images/placeholder.jpg');
    const [recentURL, setRecentURL] = useState('');
    const [favoriteImageURL, setFavoriteImageURL] = useState('/images/placeholder.jpg');
    const [favoriteURL, setFavoriteURL] = useState('');

    //inserts options for each element in an array
    function optionArray(array){
        var result = [];
        
        for(var i = 0; i < array.length; i++){
        result[i] = <option value={array[i]}> {array[i]} </option>;
        }

        return result;
    }

    //inserts options for each element in an array (but for the api)
    function optionArray2(array){
        var result = [];
        
        for(var i = 0; i < array.length; i++){
        result[i] = <option value={i}> {array[i].name} </option>;
        
        }

        return result;
    }

    const updateFavorite = event => {
        var selected = favorites[event.target.value];
        console.log("clicked on " + selected.name);
        setFavoriteImageURL(selected.image_url);
        setFavoriteURL(selected.url);
    }

    const updateRecent = event => {
        var selected = recents[event.target.value];
        console.log("clicked on " + selected.name);
        setRecentImageURL(selected.image_url);
        setRecentURL(selected.url);
    }

    return (
        <>
            <div class = "color">
                <div class="favoritesGrid" >    
                    <h3 align="center" id="favoriteList" >
                        <h3 id='favLabel'>Favorites</h3>
                            <select name="favorites" size="20" class="favorites" onChange={updateFavorite}>
                            {optionArray2(favorites)} 
                            </select> 
                        <br></br>
                            <img src={favoriteImageURL} alt="favoriteImage" class="favorites"/>
                            <br></br>
                        
                        <a href={favoriteURL}>Yelp Link</a>
                    </h3>
                    
                    <h3 align="center" id="recentList">
                        <h3 id='recentLabel'>Recently Viewed</h3>
                        <select name="recents" size="20" class="recents" onChange={updateRecent}>
                            {optionArray2(recents)}
                        </select>
                        <br></br>
                        <img src={recentImageURL} alt="recentImage" class="recents"/>
                        <br></br>
                        <a href={recentURL}>Yelp Link</a>
                    </h3>
                    
                </div>
            </div>
        </>
    )
}


export function addFavorite(business){
    if(!containsDuplicates(business)){
        if(favorites.length >= 20){
            console.log(favorites.pop().name + " removed from recents")
        }
        favorites.unshift(business);
        console.log(business.name + " added to favorites")
        console.log("Favorites size: " + favorites.length)
    }
}


export function addRecent(business){
    if(recents.length >= 20){
        console.log(recents.pop().name + " removed from recents")
    }
    recents.unshift(business);
    console.log(business.name + " added to recents")
    console.log("Recents size: " + recents.length)
}

function containsDuplicates(business){
    for(var i = 0; i < favorites.length; i++){
        if(favorites[i].name === business.name){
            console.log("Duplicate found in favorites")
            return true;
        }
    }
    return false;
}

export default Favorites;