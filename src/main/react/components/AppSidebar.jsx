import React from 'react'

function AppSidebar() {
  return (
    <aside id="sidebar" className="sidebar">

      <ul className="sidebar-nav" id="sidebar-nav">
        <li className="nav-item">
          <a className="nav-link collapsed" href="/appointments">
            <i className="bi bi-calendar-check"></i>
            <span>Check-In</span>
          </a>
        </li>

        <li className="nav-item">
          <a className="nav-link collapsed" href="/patients">
            <i className="bi bi-people"></i>
            <span>Pacientes</span>
          </a>
        </li>

        <li className="nav-item">
          <a className="nav-link collapsed" href="/appointments">
            <i className="bi bi-calendar3"></i>
            <span>Historial de Citas</span>
          </a>
        </li>
      </ul>

    </aside>
  )
}

export default AppSidebar