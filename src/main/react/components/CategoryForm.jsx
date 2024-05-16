


import React from 'react'
import { Form } from 'react-bootstrap'

export default function CategoryForm() {
  return (
      <Form>
          <Form.Group className='mb-3'>
              <Form.Label className='fw-bold'>Nombre</Form.Label>
              <Form.Control type='text'></Form.Control>
          </Form.Group>
          <Form.Group className='mb-3'>
              <Form.Label><span className='fw-bold'>Descripcion corta</span><small> (maximo 50 caracteres)</small></Form.Label>
              <Form.Control></Form.Control>
          </Form.Group>
    </Form>
  )
}
