import React from "react";
import { register } from "./register";
import AdminLayout from "./components/AdminLayout";
import ProductsTable from "./components/ProductsTable";

const ProductsPage = () => {
    return (
        <main id="main" className="main">
            <div className="pagetitle">
                <h1>Productos</h1>
                <nav>
                    <ol className="breadcrumb">
                        <li className="breadcrumb-item"><a href="/welcome">Dashboard</a></li>
                        <li className="breadcrumb-item active">Productos</li>
                    </ol>
                </nav>
            </div>

            <section className="section">
                <div className="row">
                    <div className="col-lg-12">
                        <div className="card">
                            <div className="card-body py-3">
                                <ProductsTable />
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </main>
    );
}

register((props) => <AdminLayout>
    <ProductsPage />
</AdminLayout>)