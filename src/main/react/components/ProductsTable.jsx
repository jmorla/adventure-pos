import React from "react";
import { Column } from "primereact/column";
import { DataTable } from "primereact/datatable";
import { InputText } from "primereact/inputtext";
import { Button } from "primereact/button";
import useFetch from "../hooks/useFetch";


const TableHeader = () => {
    return (
        <div className="row">
            <div className="d-flex col justify-content-start">
                <span className="p-input-icon-left">
                    <InputText placeholder="Buscar productos" />
                </span>
                <button className="btn btn-primary mx-2"><i className="bi bi-search"></i></button>
            </div>
            <div className="d-flex col justify-content-end">
                <button className="btn btn-outline-secondary mx-2"><i className="bi bi-card-checklist"></i> Gestionar Categorias</button>
                <button className="btn btn-primary"><i className="bi bi-bag-plus"></i> Crear producto</button>
            </div>
        </div>
    );
};

const ActionsMenu = (row) => (
    <Button style={{ borderRadius: '4px' }} icon="pi pi-pencil" rounded outlined severity="success" />
)

const ProductName = (row) => (
    <div className="d-flex align-items-center justify-content-start">
        <img src={row.photoUrl || 'img/products.png'} className="img-thumbnail rounded product-image" />
        <span className="d-none d-md-block ps-2">{row.name}</span>
    </div>
)

const StatusBadge = (row) => {
    const isActive = (status) => (
        status != null && status.toLowerCase() === 'activo'
    );
    return <span className={"badge rounded-pill " + (isActive(row.status) ? 'bg-primary' : 'bg-secondary')}>{row.status}</span>
}

function ProductsTable() {
    const { data: products } = useFetch("/api/products");
    return (
        <DataTable header={TableHeader} paginator rows={7} rowsPerPageOptions={[7, 10, 25, 50]} size="small"
            value={products} tableStyle={{ minWidth: '50rem' }}
            paginatorTemplate="RowsPerPageDropdown FirstPageLink PrevPageLink CurrentPageReport NextPageLink LastPageLink">
            <Column style={{ width: '20%' }} body={(row) => <ProductName {...row} />} header="Nombre del Producto"></Column>
            <Column field="price" header="Precio"></Column>
            <Column field="quantity" header="Cantidad"></Column>
            <Column field="cost" header="Costo"></Column>
            <Column field="category" header="Categoria"></Column>
            <Column header="Status" body={(row) => <StatusBadge {...row} />}></Column>
            <Column header="Acciones" body={(row) => <ActionsMenu {...row} />} />
        </DataTable>
    );
}

export default ProductsTable;