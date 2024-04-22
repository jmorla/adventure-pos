import React from 'react'

function AppSidebar() {
  return (
    <aside id="sidebar" className="sidebar">

      <ul className="sidebar-nav" id="sidebar-nav">
        <li className="nav-item">
          <a className="nav-link collapsed" href="/appointments">
            <i className="bi bi-upc-scan"></i>
            <span>Punto de Venta</span>
          </a>
        </li>

        <li className="nav-item">
          <a className="nav-link collapsed" href="/appointments">
            <i className="bi bi-calculator"></i>
            <span>Reporte de Ventas</span>
          </a>
        </li>

        <li className="nav-item">
          <a className="nav-link collapsed" href="/products">
            <i className="bi bi-basket"></i>
            <span>Productos</span>
          </a>
        </li>

        <li className="nav-item">
          <a className="nav-link collapsed" href="/appointments">
            <i className="bi bi-calendar3"></i>
            <span>Recepción de Mercancía</span>
          </a>
        </li>
      </ul>

    </aside>
  )
}

export default AppSidebar