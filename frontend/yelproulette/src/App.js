import React from 'react';
import Navbar from './Components/Navbar';
import {HashRouter as Router, Routes, Route, Link } from 'react-router-dom';
import './App.css';
import Home from './Components/pages/Home';
import Favorites from './Components/pages/Favorites';
import Login from './Components/pages/Login';


function App() {
  return (
    <>
      <Navbar />
      <Routes>
        <Route path='/' exact element={<Home/>} />
        <Route path='/Favorites' exact element={<Favorites/>} />
        <Route path='/About' element ={<About/>}/>
        <Route path='/Login' element={<Login/>}/>
      </Routes>
    </>
  );
}

export default App;


function About() {
  // 👇️ redirect to external URL
  window.location.replace('http://cs480-projects.github.io/teams-fall2022/SnackOverflow/index.html');

  return null;
}