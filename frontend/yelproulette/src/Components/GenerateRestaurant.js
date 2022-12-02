import React, {useState} from 'react';
import Button from 'react-bootstrap/Button';
import '../App.css';
import {Button as Button2} from './Button';
import './GenerateRestaurant.css';
import {addRecent, addFavorite} from "./pages/Favorites";

var apiRestaurants = [''];  //Name of restaurants
var businesses = [];        //Actual object holding restaurant info
var chosenRestaurant, restaurantNum
const prices = ['$', '$$', '$$$', '$$$$'];
//const apiKey = 'aUUmAi731yi0X2gIQR2Y8ACDhPJSuPP6Y9Zsbn9stSBmluwa0vHYDYKh-HDYIcg4yPWhZ9FAwnYiXOCY2iI43ODZb7YFH5Ul6Mp1FB1GSWaPBvHfxQub3XGbi6BYY3Yx';
var inputs = [];  //[name, address, radius, price, open, vegan];
var curBusiness;
var day = new Date().getDay();

const GenerateRestaurant = () => 
{
  // const [radius, setRadius] = useState('');
  // const [buttonText, setText] = useState(text);
  const [errorText, setErrorText] = useState('');
  const [divRestaurants, setRestaurants] = useState(<div>Enter Address and Spin!</div>);
  const [address, setAddress] = useState('');
  const [price, setPrice] = useState('');
  const [phone, setPhone] = useState('');
  const [rating, setRating] = useState(0.0);
  const [categories, setCategories] = useState('');
  const [time, setTime] = useState('');
  const [url, setURL] = useState('');
  const [imageURL, setImageURL] = useState('/images/placeholder.png');
  const [dishPhoto1, setDishPhoto1] = useState('/images/placeholder.png');
  const [dishPhoto2, setDishPhoto2] = useState('/images/placeholder.png');

  const clearFields = () => 
  {
    document.getElementById("inputAddress").value = '';
    document.getElementById("inputRadius").value = '';
    document.getElementById("inputPrice").value = '';
    document.getElementById("inputOpenNow").checked = false;
    //document.getElementById("inputVegan").checked = false;
  }

  function getApiData(){
    inputs = [chosenRestaurant,                         //0
    document.getElementById("inputAddress").value,      //1
    document.getElementById("inputRadius").value,       //2
    document.getElementById("inputPrice").value,        //3
    document.getElementById("inputOpenNow").checked];   //4
    //document.getElementById("inputVegan").checked,    //5

    //Send data to backend
    var jsonData = {
      "address" : inputs[1],
      "radius" : inputs[2],
      "price" : inputs[3],
      "openNow" : inputs[4]
    }
    //fetch("http://localhost:8080/api/input", {
    fetch("http://ec2-34-222-81-234.us-west-2.compute.amazonaws.com:8080/api/input", {
      method: 'POST',
      mode: 'cors',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(jsonData)
    })


    // Cannot fetch from frontend code unfortunately...

    // var apiURL = 'https://api.yelp.com/v3/businesses/search?location=' + inputs[1]
    // if(inputs[2] !== "") apiURL += '&radius=' + inputs[2];
    // if(inputs[3] !== "") apiURL += '&price=' + inputs[3];
    // if(inputs[5] !== false) apiURL += '&open_now=' + inputs[5];

    //Get api data from yelp business search endpoint
    //fetch("http://localhost:8080/api/getURL", {
    fetch("http://ec2-34-222-81-234.us-west-2.compute.amazonaws.com:8080/api/getURL", { 
      //headers: {'Authorization': 'Bearer ' + apiKey}
    })
    .then(response => response.json())
    .then((apiData) => {
      if(apiData.total === 0){
        setErrorText("No restaurants found with current filters");  
      }
      apiRestaurants = ['']
      for(var i = 0; i < apiData.businesses.length; i++){
        apiRestaurants[i] = apiData.businesses[i].name;
      }
      //console.log(apiRestaurants);
      businesses = apiData.businesses;
      //console.log(businesses)
      setRestaurants(divArray(apiRestaurants))
    })
    .catch((err) => {
      console.log(err.message); 
      setErrorText("Address not found")});
  }

  async function getBusinessData(){
    var jsonData = {
      "id" : curBusiness.id
    }
    //fetch("http://localhost:8080/api/postID", {
    await fetch("http://ec2-34-222-81-234.us-west-2.compute.amazonaws.com:8080/api/postID", { 
      method: 'POST',
      mode: 'cors',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(jsonData)
    })

    //Get business data from yelp business endpoint
    //fetch("http://localhost:8080/api/getID", {
    await fetch("http://ec2-34-222-81-234.us-west-2.compute.amazonaws.com:8080/api/getID", { 
    })
    .then(response => response.json())
    .then((apiData) => {
      curBusiness = apiData;
      console.log(curBusiness)
      updateInfo2();
    })
    .catch((err) => {console.log(err.message)});

  }


  function debug() 
  {
    // var num = Math.floor(Math.random() * restaurant.length);
    // text = ('Test1(Hardcoded frontend) #' + (num+1) + '. ' + restaurant[num]);
    //alert('#' + (num+1) + '. ' + restaurant[num]);
    console.log(document.getElementById('display'));
    console.log(document.getElementById('container'));
    console.log(document.getElementById('container').children[0]);
    console.log("Generated");
    //getApiData();
  }

  //inserts divs for each element in an array
  function divArray(array){
    var result = [];
    
    for(var i = 0; i < array.length; i++){
      result[i] = <div> {array[i]} </div>;
    }

    return result;
  }

  /* SLOT ANIMATION CODE */
  let hovering = false;

  function slotText(){
    if(hovering) return;
    setTimeout(() => hovering = false, 500);
    moveContainer();
    hovering = true;
  }

  function moveContainer () {
    let choosenOption = getRandomOption();
    setTop(-choosenOption.offsetTop + 2);
  }

  function setTop (top) {
    document.getElementById('container').style.top = `${top}px`;
  }

  function getRandomOption () {
    let options = document.getElementById('container').children;
    let randomOption = Math.floor(Math.random() * (options.length));
    chosenRestaurant = apiRestaurants[randomOption];
    curBusiness = businesses[randomOption];
    let choosenOption = options[randomOption];
    //console.log(randomOption);
      
    return choosenOption;
  }
  /* END SLOT ANIMATION CODE */

  function printInput(){
    //exception checks
    // if(inputs[1].length === 0){
    //   console.log("EXCEPTION: Address Empty!");
    //   return false;
    // }
    if(inputs[2] > 25){
      console.log("EXCEPTION: Radius too large!")
      inputs[2] = 25;
      document.getElementById("inputRadius").value = 25;
    }
    else if(inputs[2] < 0){
      console.log("EXCEPTION: Radius too small!")
      inputs[2] = null;
      document.getElementById("inputRadius").value = '';
    }

    inputs[0] = chosenRestaurant;

    return true;
  }

  function milesToMeters(miles) {
    return miles * 1609.344;
  }

  //Updates info boxes with info based on the current business selected
  function updateInfo(){
    //address
    console.log(curBusiness)
    try{
      setAddress(curBusiness.location.display_address.join(", "));
    }
    catch(e){
      console.log(e)
      setAddress("Address not found")
    }

    //price
    switch(curBusiness.price){
      case '$' : setPrice('$ (under $10)'); break;
      case '$$' : setPrice('$$ ($11 - $30)'); break;
      case '$$$' : setPrice('$$$ ($31 - $60)'); break;
      case '$$$$' : setPrice('$$$$ (over $60)'); break;
      default : setPrice('Prices not found');
    }

    //phone
    setPhone(curBusiness.display_phone);

    //rating
    setRating(curBusiness.rating);

    //yelp url
    setURL(curBusiness.url);

    //image url
    setImageURL(curBusiness.image_url);

    //categories
    var categoriesText = []
    for(var i = 0; i < curBusiness.categories.length; i++)
      categoriesText.unshift(curBusiness.categories[i].title)
    setCategories(categoriesText.join(", "))

    //add to recents
    addRecent(curBusiness);
  }

  //another update function for since curBusiness doesn't update in time in updateInfo()
  function updateInfo2(){
    
    //time
    var times = []
    var timeText = ''
    for(var i = 0; i < curBusiness.hours[0].open.length; i++){
      if(curBusiness.hours[0].open[i].day === day)
        times.push(curBusiness.hours[0].open[i])
    }
    for(i = 0; i < times.length; i++){
      if(i === times.length-1)
        timeText += convertTime(times[i].start) + " - " + convertTime(times[i].end)
      else
        timeText += convertTime(times[i].start) + " - " + convertTime(times[i].end) + "\n" 
    }
    if(timeText === '')
      setTime("Not open today")
    else
      setTime(timeText)
    console.log(timeText)

    //dish photos
    setDishPhoto1(curBusiness.photos[1])
    setDishPhoto2(curBusiness.photos[2])
  }

  //Convert time to an AM/PM format (ex: 1425 = 2:25PM) 930 = 9:30AM
  function convertTime(timeStr){
    var time = parseInt(timeStr)
    if(time >= 1300){ 
      return parseInt((time / 100)) - 12 + ":" + timeStr.slice(-2) + "PM"
    }
    else if(time >= 0 && time < 100){
      return "12:" + timeStr.slice(-2) + "AM"
    }
    else{
      return parseInt((time / 100)) + ":" + timeStr.slice(-2) + "AM"
    }
  }

  return (
    <div>
      <p id="errorText">{errorText}</p>

      <div class="filter">
        <input 
          type="text" 
          id="inputAddress"
          name="address" 
          size="30"
          placeholder="Address"
          required
          class="inputs"
          />

        <input 
          type="number" 
          id="inputRadius"
          name="radius"
          placeholder="Radius"
          min = "1"
          max = "99"
          class="inputs"
          />

        <select name="prices" id="inputPrice" class="inputs">
          <option value="" selected>Price</option>
          <option value={1}>{prices[0]}</option>
          <option value={2}>{prices[1]}</option>
          <option value={3}>{prices[2]}</option>
          <option value={4}>{prices[3]}</option>
        </select>

        <input 
          type="checkbox" 
          id="inputOpenNow"
          value="openNow"
          name="openNow"
          class="inputs"/>
        <label for="openNow" class="inputText">Open Now</label>
      </div>

      <Button id="clearbtn" active size="lg" onClick={clearFields}>Clear</Button>

      <Button2 className='spinbtn' buttonStyle='btn--primary' active size="lg" onClick={() => {
          if(document.getElementById("inputAddress").value !== ''){
            setErrorText("");
            printInput();
            getApiData();
            slotText();
            getBusinessData(); 
            updateInfo();
          }
          else{
            console.log("EXCEPTION: Address Empty!");
            setErrorText("Please enter an address.")
            alert("Please enter an address.")
          };
      }}>  <i class="fa-solid fa-arrows-spin"/></Button2>

      <Button2 className='favoritebtn' buttonStyle='btn--outline' active size="lg" onClick={() => {
        addFavorite(curBusiness);
        alert(curBusiness.name + " added to favorites!")
      }}> <i class="fa-regular fa-heart"/></Button2>
      
      <br></br>
      
      <section id="display">
        <div id="container">
            {divRestaurants}
        </div>
      </section>

      <div class='restaurantInfo'>
        <img src={imageURL} alt="restaurantImage" class='image'/>
        <p class='info'>
          <p class='box'><i class="fa-solid fa-location-pin fa-l fa-fw"/> {address} </p>
          <p class='box'><i class="fa-solid fa-tag fa-l fa-fw"></i> {price} </p>
          <p class='box'><i class="fa-sharp fa-solid fa-square-phone fa-l fa-fw"/> {phone} </p>
        </p>
        <p class='rating'>
          <p class='box'>Rating: {rating}/5 </p>
          <p class='box'><i class="fa-solid fa-clock fa-l fa-fw"/> {time} </p>
          <p class='box'><i class="fa-solid fa-globe fa-fw"/>  <a href={url}>Yelp Link</a></p>
          <p class='box'><i class="fa-solid fa-utensils fa-l fa-fw"/> {categories} </p>
        </p>
        <p class='dishPhotos'>
          <img src={imageURL} alt="restaurantImage" class='dishImage'/>
          <img src={dishPhoto1} alt="restaurantImage" class='dishImage'/>
          <img src={dishPhoto2} alt="restaurantImage" class='dishImage'/>
        </p>
      </div>

      <br></br><br></br>

    </div>
  );
};

export default GenerateRestaurant

