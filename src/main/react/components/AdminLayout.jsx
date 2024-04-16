

import React, { Fragment } from 'react'
import AppHeader from './AppHeader'
import AppSidebar from './AppSidebar'
import { PrimeReactProvider } from 'primereact/api';

function AdminLayout({ children }) {
  return (
    <PrimeReactProvider>
        <AppHeader />
        <AppSidebar />
        {children}
    </PrimeReactProvider>
  )
}

export default AdminLayout