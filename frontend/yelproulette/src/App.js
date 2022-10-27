import React from 'react';
import './App.css';
import GenerateRestaurant from './Components/GenerateRestaurant';


function App() {
  return (
    <div className="App">
      <header className="App-header">
      <img src="https://www.freepnglogos.com/uploads/yelp-logo-27.png" alt="Yelp Logo" height="50" align="left"></img>
      </header>

      <body className="App-body">
        <GenerateRestaurant/>
        <br></br>
        <div id='app'></div>

      </body>

    </div>
  );
}

export default App;