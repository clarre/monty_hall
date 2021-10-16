import React, {useState} from "react";

import './SimulatorSettings.css';

function SimulatorSettings(props) {
    const [changeDoor, setChangeDoor] = useState(true);
    const [numberOfSimulations, setnumberOfSimulations] = useState(0);

    const handleChange = () => {
        setChangeDoor(!changeDoor);
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        props.submit(changeDoor, numberOfSimulations);
    }

    return (
        <div className="SimulatorSettings">
            <p>Run simulator with the following values:</p>

            <form onSubmit={handleSubmit} >
                <label>
                    Change door
                    <input type="checkbox" checked={changeDoor} onChange={handleChange} />
                </label>
                <label>
                    How many simulations (Between 0 to 1000)
                    <br/>
                    <input type="number" min="0" max="1000" value={numberOfSimulations} onChange={e => setnumberOfSimulations(e.target.value)} />
                </label>
                <input type="submit" value="Run simulations" />
            </form>
        </div>
    );
}

export default SimulatorSettings;
