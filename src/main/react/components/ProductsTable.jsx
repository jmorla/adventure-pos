import React from "react";
import { Column } from "primereact/column";
import { DataTable } from "primereact/datatable";
import { InputText } from "primereact/inputtext";
import { Button } from "primereact/button";

const products = [
    {
        name: "Cocacola 20-Oz",
        price: "RD$35.00",
        quantity: "60",
        cost: "RD$22.00",
        category: "Bebidas",
        status: "Activo",
        photo: '/img/cocacola.png'
    },
    {
        name: "Taqueritos Pequenos",
        price: "RD$25.00",
        quantity: "55",
        cost: "RD$17.00",
        category: "Snacks",
        status: "Activo",
        photo: '/img/taqueritos.png'
    },
    {
        name: "Caja Chocolate Mune",
        price: "RD$70.00",
        quantity: "35",
        cost: "RD$50.00",
        category: "Comida",
        status: "Inactivo",
    },
    {
        name: "Caja Chocolate Mune",
        price: "RD$70.00",
        quantity: "35",
        cost: "RD$50.00",
        category: "Comida",
        status: "Inactivo",
    },
    {
        name: "Caja Chocolate Mune",
        price: "RD$70.00",
        quantity: "35",
        cost: "RD$50.00",
        category: "Comida",
        status: "Inactivo",
    },    {
        name: "Caja Chocolate Mune",
        price: "RD$70.00",
        quantity: "35",
        cost: "RD$50.00",
        category: "Comida",
        status: "Inactivo",
    }
]

const TableHeader = () => {
    return (
        <div className="d-flex justify-content-start">
            <span className="p-input-icon-left">
                <InputText placeholder="Buscar productos" />
            </span>
        </div>
    );
};

const ActionsMenu = (row) => (
    <Button style={{ borderRadius: '4px' }} icon="pi pi-pencil" rounded outlined severity="success" />
)

const ProductName = (row) => (
    <div className="d-flex align-items-center justify-content-start">
        <img src={row.photo || 'img/products.png'} className="img-thumbnail rounded product-image" />
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