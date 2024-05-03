import React, { useState } from 'react'
import { Button, Modal } from 'react-bootstrap'
import useFetch from '../hooks/useFetch';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';

const ActionButtons = ({id}) => <div><Button size='sm' variant='success' className='bi bi-pencil mx-1'></Button>
    <Button size='sm' variant='danger' className='bi bi-trash'></Button></div>

export default function CategoryModal({ show, onHide }) {
    const { data, loading } = useFetch("/api/categories");
    
    return (
        <Modal show={show} onHide={onHide}>
            <Modal.Header closeButton>
                <Modal.Title>Categorias de productos</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <DataTable editMode="row" dataKey="id" value={data} loading={loading}>
                    <Column header="Nombre" field="name"></Column>
                    <Column header="descripcion" field="description"></Column>
                    <Column body={(category) => <ActionButtons id={category.id} />}></Column>
                </DataTable>
            </Modal.Body>
            <Modal.Footer>
                <Button variant="primary"><i className='bi bi-plus'></i> Agregar Categoria</Button>
                <Button variant="secondary" onClick={onHide}>Cerrar</Button>
            </Modal.Footer>
        </Modal>
    )
}
