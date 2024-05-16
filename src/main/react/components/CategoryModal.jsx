import React, { useEffect, useRef, useState } from 'react'
import { Button, Modal } from 'react-bootstrap'
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { InputText } from 'primereact/inputtext';
import { deleteCategory, fetchCategories, updateCategory } from '../api/categories';
import { useQuery } from '../hooks/useQuery';
import { Messages } from 'primereact/messages';
import { confirmPopup, ConfirmPopup } from 'primereact/confirmpopup';
import CategoryForm from './CategoryForm';
import CategoryTable from './CategoryTable';

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
    const [selectedCategory, setSelectedCategory] = useState(null);
    const [loading, setLoading] = useState(false);
    const messagesRef = useRef();
    const [showForm, setShowForm] = useState(false);


    const handleClose = () => {
        setShowForm(false);
        onHide();
    }
    const onDeleteCategory = () => {
        setLoading(true);
        deleteCategory(selectedCategory.id).then(() => (
            messagesRef.current.show([
                {
                    life: 3000, sticky: false, severity: 'success', summary: 'Categoria Eliminada', closable: false,
                    detail: "La categoria ha sido eliminada con exito"
                }
            ])
        )).finally(() => setLoading(false));

    }

    const confirmDeleteCategory = (e) => {
        confirmPopup({
            target: e.currentTarget,
            message: `Todos los productos asociados perderán su categorización.`,
            icon: 'pi pi-exclamation-triangle',
            defaultFocus: 'reject',
            acceptLabel: "Eliminar",
            rejectLabel: "Descartar",
            acceptClassName: "btn btn-danger",
            reject: () => setSelectedCategory(null),
            accept: onDeleteCategory
        })
    }

    return (
        <Modal show={show} onHide={handleClose} size='lg' backdrop="static">
            <Modal.Header closeButton>
                <Modal.Title>Categorias de productos</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Messages ref={messagesRef} />
                {showForm ? <CategoryForm /> : <CategoryTable loading={loading} />}
            </Modal.Body>
            <Modal.Footer>
                {
                    showForm ? (<>
                        <Button variant="primary" onClick={handleClose}><i className='bi bi-plus'></i> Guardar</Button>
                        <Button variant="secondary" onClick={handleClose}>Cancelar</Button>
                    </>) : (
                        <>
                            <ConfirmPopup style={{ zIndex: "1100" }} />
                            {selectedCategory ? (<Button onClick={confirmDeleteCategory} variant="danger"><i className='bi bi-trash'></i> Eliminar</Button>) :
                                (<Button variant="primary" onClick={() => setShowForm(true)}><i className='bi bi-plus'></i> Agregar Categoria</Button>)}
                            <Button variant="secondary" onClick={handleClose}>Cerrar</Button>
                        </>
                    )
                }
            </Modal.Footer>
        </Modal>
    )
}
