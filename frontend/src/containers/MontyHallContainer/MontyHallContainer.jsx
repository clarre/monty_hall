import React, { useState } from "react";
import axios from "axios";

import SimulatorResult from "../../components/SimulatorResult/SimulatorResult";
import SimulatorSettings from "../../components/SimulatorSettings/SimulatorSettings";

function MontyHallContainer() {

    const [result, setResult] = useState([]);
    const [errorMessage, setErrorMessage] = useState("");

    const runSimulation = (changeDoor, numberOfSimulations) => {
        setErrorMessage("")
        setResult([])
        axios.get(`simulate/change/${changeDoor}/times/${numberOfSimulations}`)
            .then(res => {
                if (res.status === 200) {
                    setResult(res.data);
                } else {
                    setErrorMessage("Something went wrong, please rerun simulation");
                }
            })
            .catch(res => {
                setErrorMessage("Something went wrong, please rerun simulation");
            });
    }

    return (
        <div className="MontyHallContainer">
            <SimulatorSettings submit={runSimulation} />
            <SimulatorResult results={result} errorMessage={errorMessage} />
        </div>
    );
}

export default MontyHallContainer;
