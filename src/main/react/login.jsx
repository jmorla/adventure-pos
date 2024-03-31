import React from "react";
import { register } from './register';
import 'bootstrap/dist/css/bootstrap.css';

function LoginPage({ _csrf }) {
  const params = new URLSearchParams(window.location.search);
  return (
    <div className="container">
      <section className="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
        <div className="container">
          <div className="row justify-content-center">
            <div className="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

              <div className="card mb-3 p-2">
                <div className="card-body">
                  <div className="d-flex justify-content-center py-4">
                    <a href="/signIn" className="logo d-flex align-items-center w-auto">
                      <img src="/img/logo2.png" alt="" />
                    </a>
                  </div>
                  {
                    params.has("logout") && (
                      <div class="alert alert-success alert-dismissible fade show" role="alert">
                      Has cerrado sesión exitosamente ¡Esperamos volver a verte pronto!
                      <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                    )
                  }
                  {params.has("error") && (
                  <div className="alert alert-danger bg-danger text-light border-0 alert-dismissible fade show" role="alert">
                    Usuario o contraseña invalidos
                  </div>)}
                  <form method="post" action="/login" className="row g-3 needs-validation">
                  <input type="hidden" name="_csrf" value={_csrf} />
                    <div className="col-12">
                      <label htmlFor="username" className="form-label">Nombre de usuario</label>
                      <div className="input-group has-validation">
                        <span className="input-group-text" id="inputGroupPrepend">@</span>
                        <input type="text" name="username" className="form-control" id="username" required />
                        <div className="invalid-feedback">Please enter your username.</div>
                      </div>
                    </div>

                    <div className="col-12">
                      <label htmlFor="password" className="form-label">Contraseña</label>
                      <input type="password" name="password" className="form-control" id="password" required />
                      <div className="invalid-feedback">Please enter your password!</div>
                    </div>

                    <div className="col-12">
                      <button className="btn btn-primary w-100" type="submit">Acceder</button>
                    </div>
                  </form>

                </div>
              </div>

              <div className="credits">
                Powered by <a href="https://bootstrapmade.com/">Bytetech Solutions</a>
              </div>

            </div>
          </div>
        </div>
      </section>
    </div>
  )
}

register((props) => <LoginPage {...props} />)