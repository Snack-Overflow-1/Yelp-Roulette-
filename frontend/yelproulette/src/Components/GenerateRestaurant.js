import styled from 'styled-components';
import React, {useState} from 'react';

const theme = {
  blue: {
    default: "#3f51b5",
    hover: "#283593"
  },
  pink: {
    default: "#e91e63",
    hover: "#ad1457"
  }
};

const Button = styled.button`
  background-color: ${(props) => theme[props.theme].default};
  color: white;
  padding: 5px 15px;
  border-radius: 5px;
  outline: 0;
  text-transform: uppercase;
  margin: 10px 0px;
  cursor: pointer;
  box-shadow: 0px 2px 2px lightgray;
  transition: ease background-color 250ms;
  &:hover {
    background-color: ${(props) => theme[props.theme].hover};
  }
  &:disabled {
    cursor: default;
    opacity: 0.7;
  }
`;

Button.defaultProps = {
  theme: "blue"
};

var text = 'Click button to generate restaurant (text1)';
var text2 = 'Click button to generate restaurant (text2)';
const restaurant = ['Starbucks', 'Mcdonalds', 'Wendys', 'Subway', 'Red Lobster', 'Red Robin'];

const GenerateRestaurant = () => {

  fetch('/api/randomRestaurant')
      .then(response => response.text())
      .then(message => {
          text2 = message;
      });


  const [buttonText, setText] = useState(text);

  function generate() {
    var num = Math.floor(Math.random() * restaurant.length);
    text = ('#' + (num+1) + '. ' + restaurant[num]);
    //alert('#' + (num+1) + '. ' + restaurant[num]);
  }

  return (
    <div>
      <label>Address:   </label>
      <input type="text" id="name" name = "name" size="30"></input>
      <label>    Radius:   </label>
      <input type="number" step="1" size="1" required maxLength="3"></input><br></br>

      <Button onClick={() => {
        generate();   //Test function that uses hardcoded array of strings
        setText(text2);
      }}>Generate Restaurant</Button>
      <h2>{text}</h2>
      <h2>{text2}</h2>
    </div>
  );
  
  

};

export default GenerateRestaurant