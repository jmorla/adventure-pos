import React, { useEffect, useRef, useState } from 'react'
import { Button, Modal } from 'react-bootstrap'
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { InputText } from 'primereact/inputtext';
import { fetchCategories, updateCategory } from '../api/categories';
import useMutation from '../hooks/useMutation';
import { useQuery } from '../hooks/useQuery';
import { Messages } from 'primereact/messages';
import { confirmPopup, ConfirmPopup } from 'primereact/confirmpopup';

const FieldEditor = (options) => {
    return <InputText size="sm" value={options.value || ""} onChange={(e) => options.editorCallback(e.target.value)} />
}

function buildSuccessUpdateMessage(e) {
    const { data, newData } = e;
    if (data.name === newData.name && data.description === newData.description) {
        return `La categoria "${data.name}" fue actualizada`
    }

    if (data.name === newData.name && data.description !== newData.description) {
        return `La description de la categoria "${data.name}" fue actualizada`
    }

    if (data.name !== newData.name) {
        return `la categoria "${data.name}" cambio a "${newData.name}"`
    }
}

export default function CategoryModal({ show, onHide }) {
    const { data, loading: fetchCategoryLoading, fetch } = useQuery(fetchCategories);
    const { mutate, loading: categoryUpdateLoading } = useMutation(updateCategory);
    const [selectedProduct, setSelectedProduct] = useState(null);
    const messagesRef = useRef();

    const onEditComplete = (e) => {
        mutate(e.newData)
        messagesRef.current.show([
            {
                life: 3000, sticky: false, severity: 'success', summary: 'Categoria Actualizada', closable: false,
                detail: buildSuccessUpdateMessage(e)
            }
        ])
    }

    const confirmDeleteCategory = (e) => {
        confirmPopup({
            target: e.currentTarget,
            message: `Todos los productos asociados perderán su categorización.`,
            icon: 'pi pi-exclamation-triangle',
            defaultFocus: 'reject',
            accept: () => console.log("Delete"),
            reject: () => console.log("Reject"),
            acceptLabel: "Eliminar",
            rejectLabel: "Descartar",
            acceptClassName: "btn btn-danger"
        })
    }

    const showEdit = () =>
        selectedProduct == null;

    useEffect(() => {
        if (!categoryUpdateLoading) {
            fetch();
        }
        return () => setSelectedProduct(null);
    }, [show, categoryUpdateLoading])

    return (
        <Modal show={show} onHide={onHide} size='lg' backdrop="static">
            <Modal.Header closeButton>
                <Modal.Title>Categorias de productos</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Messages ref={messagesRef} />
                <DataTable onRowEditComplete={onEditComplete} editMode="row"
                    dataKey="id" value={data} loading={fetchCategoryLoading} scrollable scrollHeight="400px"
                    selection={selectedProduct} onSelectionChange={(e) => setSelectedProduct(e.value)}>
                    <Column selectionMode="single" style={{ width: '1rem' }}></Column>
                    <Column header="Nombre" style={{ width: '20%' }} editor={options => <FieldEditor {...options} />} field="name"></Column>
                    <Column header="descripcion" style={{ width: '60%' }} editor={options => <FieldEditor {...options} />} field="description"></Column>
                    <Column rowEditor={showEdit} headerStyle={{ width: '10%', minWidth: '8rem' }} bodyStyle={{ textAlign: 'center' }}></Column>
                </DataTable>
            </Modal.Body>
            <Modal.Footer>
                <ConfirmPopup style={{ zIndex: "1100" }} />
                {selectedProduct ? (<Button onClick={confirmDeleteCategory} variant="danger"><i className='bi bi-trash'></i> Eliminar</Button>) :
                    (<Button variant="primary"><i className='bi bi-plus'></i> Agregar Categoria</Button>)}
                <Button variant="secondary" onClick={onHide}>Cerrar</Button>
            </Modal.Footer>
        </Modal>
    )
}
