// src/websocketService.js

import { Client } from '@stomp/stompjs';
import SockJS from 'sockjs-client';

const SOCKET_URL = 'http://localhost:8080/ws'; // WebSocket endpoint

export const client = new Client({
    brokerURL: SOCKET_URL,
    connectHeaders: {
        login: 'user',
        passcode: 'password',
    },
    webSocketFactory: () => new SockJS(SOCKET_URL),
    debug: function (str) {
        console.log(str);
    },
    onConnect: (frame) => {
        console.log('Connected: ' + frame);
    },
    onDisconnect: (frame) => {
        console.log('Disconnected: ' + frame);
    }
});

export const connectWebSocket = (onMessage) => {
    client.onConnect = () => {
        client.subscribe('/topic/numberUpdate', (message) => {
            if (onMessage) {
                onMessage(JSON.parse(message.body));
            }
        });
    };
    client.activate();
};

export const sendMessage = (destination, body) => {
    client.publish({ destination, body });
};
