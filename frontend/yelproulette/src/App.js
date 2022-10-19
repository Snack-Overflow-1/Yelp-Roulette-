import React from 'react';
import './App.css';
import HelloWorld from './Components/HelloWorld';
import GenerateRestaurant from './Components/GenerateRestaurant';


function App() {
  return (
    <div className="App">
      <header className="App-header">

      </header>

      <body className="App-body">
        <HelloWorld />
        <GenerateRestaurant/>
        <br></br>
        <div id='app'></div>

      </body>

    </div>
  );
}

export default App;