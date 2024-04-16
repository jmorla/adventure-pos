

import React, { Fragment } from 'react'
import AppHeader from './AppHeader'
import AppSidebar from './AppSidebar'

function AdminLayout({ children }) {
  return (
    <Fragment>
        <AppHeader />
        <AppSidebar />
        {children}
    </Fragment>
  )
}

export default AdminLayout