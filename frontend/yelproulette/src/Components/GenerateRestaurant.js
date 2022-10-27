import React, {useState} from 'react';
import Button from 'react-bootstrap/Button';
import '../App.css';

var text = 'Click button to generate restaurant (text1)';
var text2 = 'Click button to generate restaurant (text2)';
const restaurant = ['Starbucks', 'McDonalds', 'Wendys', 'Subway', 'Red Lobster', 'Red Robin'];
const restaurantDiv = [<div>Starbucks</div>, <div>McDonalds</div>, <div>Wendys</div>, <div>Subway</div>, <div>Red Lobster</div>, <div>Red Robin</div>];

const GenerateRestaurant = () => 
{

  const [address, setAddress] = useState('');
  const [radius, setRadius] = useState('');
  const [buttonText, setText] = useState(text);

  const changeAddress = event => 
  {
    setAddress(event.target.value);
  }

  const changeRadius = event => 
  {
    setRadius(event.target.value);
  }

  const clearFields = () => 
  {
    setAddress('');
    setRadius('');
  }

  fetch('/api/randomRestaurant')
      .then(response => response.text())
      .then(message => {
          text2 = message;
      });

  function generate() 
  {
    var num = Math.floor(Math.random() * restaurant.length);
    text = ('Test1(Hardcoded frontend) #' + (num+1) + '. ' + restaurant[num]);
    //alert('#' + (num+1) + '. ' + restaurant[num]);
  }

  return (
    <div>
      <label id="filterTitle">Filters</label>
      <br></br><br></br>
      <label id="addressLabel">Address:</label>
      <input 
        type="text" 
        id="inputAddress"
        name="address" 
        size="20"
        onChange={changeAddress}
        value={address}/>
      <br></br><br></br>

      <label id="radiusLabel">Radius:</label>
      <input 
        type="number" 
        id="inputRadius"
        name="radius"
        step="1" 
        size="1"
        onChange={changeRadius}
        value={radius}
        required maxLength="3" />
      <br></br><br></br>

      <label id="veganLabel">Vegan?</label>

      <input 
        type="radio" 
        id="yesVegan"
        value="Yes"
        name="vOption"/>
      <label id="yesVeganLabel">Yes</label>

      <input 
        type="radio" 
        id="noVegan"
        value="No"
        name="vOption"/>
      <label id="noVeganLabel">No</label>
      <br></br><br></br>

      <Button id="clearbtn" active size="lg" onClick={clearFields}>Clear Fields</Button>

      <Button id="generatebtn" variant="success" active size="lg" onClick={() => {
        generate();   //Test function that uses hardcoded array of strings
        setText(text2);
        slotText();
      }}>Generate Restaurant</Button>
      <br></br><br></br><br></br>
      <h2>{text}</h2>
      <h2>Test2(Hardcoded backend) {text2}</h2>

      Test3 (Slot Animation)
      <section id="display">
        <div id="container">
          {restaurantDiv}
        </div>
      </section>
    </div>
  );
};

export default GenerateRestaurant

let display = document.getElementById('display');
let container = document.getElementById('container');
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
  container.style.top = `${top}px`;
}

function getRandomOption () {
  let options = container.children;
  let randomOption = Math.floor(Math.random() * (options.length));  
  let choosenOption = options[randomOption];
    
  return choosenOption;
}