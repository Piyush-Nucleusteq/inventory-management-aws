import React from 'react'

// Compound Component Design Pattern

const SideBar = ({ children, ...restProps }) => {
  return (
    <div {...restProps}>
      {children}
    </div>
  )
}

{/* <SideBar className='cbisbc' onSubmit={} onChange={}/> */}

SideBar.Item = function SideBarItem({ children, ...restProps }) {
    return (
        <div {...restProps}>{children}</div>
    )
}

export default SideBar