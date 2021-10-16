import React from "react";
import './SimulatorResult.css';

function SimulatorResult(props) {

    const countWinsAndLosses = () => {
        return props.results.reduce((acc, result) => {
            if(result.win) {
                acc.wins++;
            } else {
                acc.losses++
            }

            return acc

        }, {wins: 0, losses: 0})
    }

    if(props.errorMessage !== "") {
        return (
            <div className="SimulatorResultError">
                {props.errorMessage}!
            </div>
        )
    }

    const gameResult = countWinsAndLosses()

    return (
        <div className="SimulatorResult">
            <h2>Result of simulations</h2>

            <div className="score">
                <div>Wins: {gameResult.wins}</div>
                <div>Losses: {gameResult.losses}</div>
            </div>

            <table>
                <thead>
                    <tr>
                        <th>Doors</th>
                        <th>Chosen door</th>
                        <th>Shown door</th>
                        <th>Change door</th>
                        <th>Win</th>
                    </tr>
                </thead>
                <tbody>
                    {props.results.map((result, index) => {
                        return (
                            <tr key={index}>
                                <td>{result.doors.join(' ')}</td>
                                <td>{result.playerChoosesDoor}</td>
                                <td>{result.hostShowsDoor}</td>
                                <td>{result.playerChangingDoor.toString()}</td>
                                <td>{result.win.toString()}</td>
                            </tr>                            
                        )
                    })}
                </tbody>
            </table>
        </div>
    );
}

export default SimulatorResult;
