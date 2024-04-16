import React from 'react';
import { register } from './register';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap';
import 'bootstrap-icons/font/bootstrap-icons.css';
import AdminLayout from './components/AdminLayout';


const WelcomePage = () => {
    return (
        <main id="main" className="main">
            <div className="pagetitle">
                <h1>Bienvenido</h1>
                <nav>
                    <ol className="breadcrumb">
                        <li className="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                        <li className="breadcrumb-item active">Bienvenido</li>
                    </ol>
                </nav>
            </div>

            <section className="section">
                <div className="row">
                    <div className="col-lg-12">
                        <div className="card">
                            <div className="card-body">
                                <h5 className="card-title">Example Card</h5>
                                <p>This is an examle page with no contrnt. You can use it as a starter for your custom pages.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </main>
    )
}

register((props) => <AdminLayout>
    <WelcomePage />
</AdminLayout>)