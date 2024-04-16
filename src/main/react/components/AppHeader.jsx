

import React from 'react'

export default function AppHeader() {
  return (
    <header id="header" className="header fixed-top d-flex align-items-center">

      <div className="d-flex align-items-center">
        <a href="/welcome" className="logo2 d-flex align-items-center justify-content-center">
          <img src="/img/logo2.png" alt="" />
        </a>
      </div>

      <nav className="header-nav ms-auto">
        <ul className="d-flex align-items-center">
          <li className="nav-item dropdown pe-3">

            <a className="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
              <img src="/img/usuario.png" alt="Profile" className="rounded-circle" />
              <span className="d-none d-md-block dropdown-toggle ps-2">Jorge Morla</span>
            </a>

            <ul className="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
              <li className="dropdown-header">
                <h6>Jorge Morla</h6>
                <span>Administrador</span>
              </li>
              <li>
                <hr className="dropdown-divider" />
              </li>
              <li>
                <form method="post" action="/logout" className='dropdown-item d-flex align-items-center'>
                  <i className="bi bi-box-arrow-right"></i>
                  <button className='logout-button' type="submit">Cerrar Sesion</button>
                </form>
              </li>

            </ul>
          </li>
        </ul>
      </nav>
    </header>
  )
}
