import React, { useState } from 'react'
import { NavLink } from 'react-router-dom';
const Navbar = () => {
  const [activeLink, setActiveLink] = useState(0);

  const handleLinkClick = (index) => {
    setActiveLink(index);
  };
  return (
    <div className="flex items-center h-14 px-4 border-b bg-gray-100">
      <div className="flex w-1/2 items-center text-sm font-medium sm:w-64">
      <NavLink to="/dashboard" className={`link ${activeLink ? 'active' : ''}text-xl font-bold`} onClick={() => handleLinkClick(0)}>
          Chavs Bookstore
        </NavLink>
      </div>
      <div className="hidden w-1/2 sm:flex sm:items-center sm:gap-4 sm:justify-end sm:w-1/2">
        <div className="flex items-center space-x-4">
        <NavLink to="/dashboard" className={`link ${activeLink ? 'active' : ''} text-xl font-semibold`} onClick={() => handleLinkClick(0)}>
            Dashboard
          </NavLink>
          <NavLink to="/orders" className={`link ${activeLink ? 'active' : ''} text-xl font-semibold`} onClick={() => handleLinkClick(0)}>
            Orders
          </NavLink>
        </div>
      </div>
      <div className="w-1/2 ml-auto sm:hidden">
        <div className="relative group">
          <button aria-haspopup="menu" className="flex items-center justify-center w-10 h-10" id="options">
            <svg
              className="h-6 w-6"
              fill="none"
              stroke="currentColor"
              viewBox="0 0 24 24"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path d="M4 6h16M4 12h16m-7 6h7" strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} />
            </svg>
            <span className="sr-only">Options</span>
          </button>
          <div className="hidden group-hover:block absolute right-0 w-48 py-1 text-sm bg-white shadow-md rounded-md dark:bg-gray-950 dark:shadow-lg">
            <a className="block px-4 py-2 font-medium" href="#">
              Profile
            </a>
            <a className="block px-4 py-2 font-medium" href="#">
              Sign out
            </a>
          </div>
        </div>
      </div>
      <div className="hidden w-1/2 sm:flex sm:items-center sm:gap-4 sm:justify-end sm:w-1/2">
        <div className="flex items-center space-x-4">
          <a className="font-medium" href="#">
            Profile
          </a>
        </div>
      </div>
    </div>
  )
}

export default Navbar