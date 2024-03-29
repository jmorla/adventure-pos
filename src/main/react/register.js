import React from 'react'
import ReactDOM from 'react-dom/client';

export function register (rootComponent, containerId = "root") {
    ReactDOM.createRoot(document.getElementById(containerId))
    .render(rootComponent);
}