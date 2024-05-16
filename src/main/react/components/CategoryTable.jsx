


import { Column } from 'primereact/column'
import { DataTable } from 'primereact/datatable'
import React, { useEffect, useRef, useState } from 'react'
import { useQuery } from '../hooks/useQuery'
import { fetchCategories } from '../api/categories'

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

export default function CategoryTable({ loading }) {
    const { data, loading: fetchCategoryLoading, fetch } = useQuery(fetchCategories);

    const [selectedCategory, setSelectedCategory] = useState(null);
    const [loading, setLoading] = useState(loading);
    const messagesRef = useRef();

    const onEditComplete = async (e) => {
        setLoading(true);
        updateCategory(e.newData).then(() => {
            messagesRef.current.show([
                {
                    life: 3000, sticky: false, severity: 'success', summary: 'Categoria Actualizada', closable: false,
                    detail: buildSuccessUpdateMessage(e)
                }
            ]);
        }).finally(() => setLoading(false));
    }

    const showEdit = () =>
        selectedCategory == null;

    useEffect(() => {
        if (!loading) {
            fetch();
        }
        return () => setSelectedCategory(null);
    }, [loading])

    return (
        <DataTable onRowEditComplete={onEditComplete} editMode="row"
            dataKey="id" value={data} loading={fetchCategoryLoading} scrollable scrollHeight="400px"
            selection={selectedCategory} onSelectionChange={(e) => setSelectedCategory(e.value)}>
            <Column selectionMode="single" style={{ width: '1rem' }}></Column>
            <Column header="Nombre" style={{ width: '20%' }} editor={options => <FieldEditor {...options} />} field="name"></Column>
            <Column header="descripcion" style={{ width: '60%' }} editor={options => <FieldEditor {...options} />} field="description"></Column>
            <Column rowEditor={showEdit} headerStyle={{ width: '10%', minWidth: '8rem' }} bodyStyle={{ textAlign: 'center' }}></Column>
        </DataTable>
  )
}
