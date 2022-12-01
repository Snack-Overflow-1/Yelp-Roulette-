import React from 'react'
import '../../App.css'
import HeroSection from '../HeroSection';
import GenerateRestaurant from '../GenerateRestaurant';

function Home () {
    return (
        <>
            <HeroSection/>
            <div className="App">
                <body className="App-body">
                    <GenerateRestaurant/>
                    <br></br>
                    <div id='app'></div>
                </body>
            </div>
        </>
    )
}

export default Home;