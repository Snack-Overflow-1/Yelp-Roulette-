import React from 'react'
import {Button} from './Button';
import '../App.css';
import './HeroSection.css';

function HeroSection() {
  return (
    <div className='hero-container'>
        <img src="https://s3-media2.fl.yelpcdn.com/bphoto/PwZENcqawD_hhkptkBD0dA/o.jpg" alt="restaurantImage" class='heroIMG'/>
        <h1>The search for your next meal starts here!</h1>
        <div classname="hero-btns">
            <Button className='btns' buttonStyle='btn--outline' buttonSize='btn--large' onClick={smoothScroll}>
                Get Started
            </Button>
        </div>
    </div>
  )
}

function smoothScroll(){
  var endScroll = 750;
  window.scrollTo({
    top: endScroll,
    behavior: 'smooth'
 });
}

export default HeroSection

