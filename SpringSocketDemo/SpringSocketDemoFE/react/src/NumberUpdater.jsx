// src/NumberUpdater.jsx

import React, { useEffect, useState } from 'react';
import { client, connectWebSocket, sendMessage } from './websocketService';

const NumberUpdater = () => {
    const [number, setNumber] = useState(0);

    useEffect(() => {
        connectWebSocket((updatedNumber) => {
            setNumber(updatedNumber.value);
        });

        // Clean up on unmount
        return () => {
            client.deactivate();
        };
    }, []);

    const updateNumber = () => {
        sendMessage('/app/incrementNumber', '');
    };

    return (
        <div>
            <h1>Current Number: {number}</h1>
            <button onClick={updateNumber}>Update Number</button>
        </div>
    );
};

export default NumberUpdater;
