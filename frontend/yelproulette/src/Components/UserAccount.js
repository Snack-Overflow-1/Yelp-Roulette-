import React, {useState} from 'react'
import {Button} from './Button';
import './UserAccount.css';
import { Link } from 'react-router-dom';
import './w3CSS.css';

var inputs = [];  //[username, password];

const UserAccount = () =>
{
  const [userExists, setUserExists] = useState(false);

  async function getUserInfo()
  {
    inputs = [
    document.getElementById("inputUsername").value,         //0
    document.getElementById("inputPassword").value];        //1

    var jsonData = {
      "email" : inputs[0], // This is the username
      "password" : inputs[1],
      "firstName" : "",
      "lastName" : ""
    }
    //send user/pass to backend
    await fetch("http://ec2-3-94-78-198.compute-1.amazonaws.com:8080/api/register", {
      method: 'POST',
      mode: 'cors',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(jsonData)
    })

    //setUserExists(false)

    var exists = await getUserExists()
    console.log(exists);
    
    if(exists){
      //check password of existing user
      fetch("http://ec2-3-94-78-198.compute-1.amazonaws.com:8080/api/getUser", { 
      })
      .then(response => response.text())
      .then((password) => {
        console.log("Password: " + password)
        if(inputs[1] === password){
          alert("Password matches :)")
          //Route back to home or favorites
          window.location.replace('http://ec2-3-94-78-198.compute-1.amazonaws.com');
        }
        else{
          alert("Incorrect password :(")
        }
      })
      .catch((err) => {console.log(err.message)})
    }
    else{
      console.log(inputs[0] + " not in database")
      alert("User created")
    }


  }

  function getUserExists(){
    return new Promise((resolve, reject) =>{
      //check if user exists in database
      fetch("http://ec2-3-94-78-198.compute-1.amazonaws.com:8080/api/userExists", { 
      })
      .then(response => response.text())
      .then((bool) => {
        setUserExists(bool === 'true');
        resolve(bool === 'true');
        return bool === 'true'
      })
      .catch((err) => {
        console.log(err.message)});
    })
  }


  return (
    <div class='user-login'>
      <div class="w3-container">
          <p id="header-text">Login to an existing account, or create a new one.</p>
        
          <input 
            type="text" 
            id="inputUsername"
            name="username" 
            size="30"
            placeholder="Username"
            required
          />

          <br></br>
          <br></br>

          <input 
            type="text" 
            id="inputPassword"
            name="password" 
            size="30"
            placeholder="Password"
            required
          />

          <br></br>
          <br></br>

          <button id="loginbtn" onClick = {getUserInfo}>Login</button>
        </div>
    </div>
  )
}

export default UserAccount

