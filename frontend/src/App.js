import React from 'react';
import monty from './monty.jpg';
import './App.css';
import BackendHealth from './components/BackendHealth/BackendHealth';
import MontyHallContainer from './containers/MontyHallContainer/MontyHallContainer';

function App() {
    return (
        <div className="App">
            <header className="App-header">
                <BackendHealth/>
                <img src={monty} className="App-monty" alt="logo"/>
                <h1 className="App-title">Welcome to the Monty Hall Simulator</h1>
            </header>
            <MontyHallContainer />
        </div>
    );
}

export default App;
