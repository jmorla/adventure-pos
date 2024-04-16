import React, { useState } from "react";
import { register } from "./register";
import AdminLayout from "./components/AdminLayout";
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Button } from "primereact/button";
import { InputText } from "primereact/inputtext";


const TableHeader = () => {
    return (
        <div className="d-flex justify-content-end">
            <span className="p-input-icon-left">
                <InputText placeholder="Buscar pacientes" />
            </span>
        </div>
    );
};

const PatientsPage = () => {
    const [products] = useState([
        {
            firstName: "Juan",
            lastName: "Pérez",
            dni: "000-0000000-0",
            phone: "123-456-7890",
            email: "juan.perez@example.com",
            sex: "masculino",
            DOB: "1990-05-15",
            createdAt: "2024-04-16T12:00:00Z"
        },
        {
            firstName: "María",
            lastName: "García",
            phone: "321-654-0987",
            dni: "000-0000000-0",
            email: "maria.garcia@example.com",
            sex: "femenino",
            DOB: "1985-10-20",
            createdAt: "2024-04-16T12:30:00Z"
        },
        {
            firstName: "Carlos",
            lastName: "López",
            phone: "555-123-4567",
            dni: "000-0000000-0",
            email: "carlos.lopez@example.com",
            sex: "masculino",
            DOB: "1982-02-28",
            createdAt: "2024-04-16T13:00:00Z"
        },
        {
            firstName: "Ana",
            lastName: "Martínez",
            phone: "111-222-3333",
            dni: "111-1111111-1",
            email: "ana.martinez@example.com",
            sex: "femenino",
            DOB: "1995-08-10",
            createdAt: "2024-04-16T14:00:00Z"
          },
          {
            firstName: "David",
            lastName: "González",
            phone: "444-555-6666",
            dni: "222-2222222-2",
            email: "david.gonzalez@example.com",
            sex: "masculino",
            DOB: "1988-11-20",
            createdAt: "2024-04-16T15:00:00Z"
          },
          {
            firstName: "Laura",
            lastName: "Rodríguez",
            phone: "777-888-9999",
            dni: "333-3333333-3",
            email: "laura.rodriguez@example.com",
            sex: "femenino",
            DOB: "1976-04-05",
            createdAt: "2024-04-16T16:00:00Z"
          },
          {
            firstName: "Pedro",
            lastName: "Sánchez",
            phone: "123-456-7890",
            dni: "444-4444444-4",
            email: "pedro.sanchez@example.com",
            sex: "masculino",
            DOB: "1992-12-15",
            createdAt: "2024-04-16T17:00:00Z"
          },
          {
            firstName: "Elena",
            lastName: "López",
            phone: "999-888-7777",
            dni: "555-5555555-5",
            email: "elena.lopez@example.com",
            sex: "femenino",
            DOB: "1980-07-25",
            createdAt: "2024-04-16T18:00:00Z"
          },
          {
            firstName: "Mario",
            lastName: "Hernández",
            phone: "666-777-8888",
            dni: "666-6666666-6",
            email: "mario.hernandez@example.com",
            sex: "masculino",
            DOB: "1987-09-03",
            createdAt: "2024-04-16T19:00:00Z"
          },
          {
            firstName: "Sofía",
            lastName: "Díaz",
            phone: "888-999-0000",
            dni: "777-7777777-7",
            email: "sofia.diaz@example.com",
            sex: "femenino",
            DOB: "1994-01-12",
            createdAt: "2024-04-16T20:00:00Z"
          }
    ]);

    return (
        <main id="main" className="main">
            <div className="pagetitle">
                <h1>Pacientes</h1>
                <nav>
                    <ol className="breadcrumb">
                        <li className="breadcrumb-item"><a href="/welcome">Check-in</a></li>
                        <li className="breadcrumb-item active">Pacientes</li>
                    </ol>
                </nav>
            </div>

            <section className="section">
                <div className="row">
                    <div className="col-lg-12">
                        <div className="card">
                            <div className="card-body py-4">
                                <DataTable header={TableHeader} paginator rows={7} rowsPerPageOptions={[7, 10, 25, 50]} size="small"  value={products} tableStyle={{ minWidth: '50rem' }}>
                                    <Column body={(row) => <span>{row.firstName + ' ' + row.lastName}</span>}
                                        header="Paciente"></Column>
                                    <Column field="dni" header="Cedula"></Column>
                                    <Column field="phone" header="Telefono"></Column>
                                    <Column field="DOB" header="Nacimiento"></Column>
                                    <Column field="email" header="Correo" style={{ width: '25%'}}></Column>
                                    <Column body={(row) => (<Button style={{ borderRadius: '4px' }} icon="pi pi-pencil" rounded outlined severity="success" />)} />
                                </DataTable>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </main>
    );
}

register((props) => <AdminLayout>
    <PatientsPage />
</AdminLayout>)