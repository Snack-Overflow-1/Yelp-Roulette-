import React from 'react';


var text = 'Default';

export function ChangeText(string) {
  text = string;
  return (
    <div> {text} </div>
  );
}

const RestaurantText = () => {

  return (
    <div> {text} </div>
  );
}

export default RestaurantText;