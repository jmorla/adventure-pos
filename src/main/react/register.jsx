import React from 'react'
import ReactDOM from 'react-dom/client';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap';
import 'bootstrap-icons/font/bootstrap-icons.css';
import "primereact/resources/themes/lara-light-cyan/theme.css";
import 'primeicons/primeicons.css';

export function register(RootComponent, containerId = "root") {
    const container = document.getElementById(containerId);
    const attributes = container.attributes;

    const dataAttributes = {};
    
    for (let i = 0; i < attributes.length; i++) {
        const { name, value } = attributes[i];
        if (name.startsWith("data-prop-")) {
            const propName = name.replace(/^data-prop-/, "").replace(/-([a-z])/g, (g) =>
                g[1].toUpperCase()
            );
            dataAttributes[propName] = value;
        }
    }

    ReactDOM.createRoot(container).render(RootComponent(dataAttributes));
}

