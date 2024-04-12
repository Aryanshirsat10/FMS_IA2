import React from 'react'

const login = () => {
  return (
    <div>
      <div className="p-4">
        <h2 className="text-2xl">Login</h2>
        <p>Enter your email below to login to your account.</p>
      </div>
      <div className="space-y-4 p-4">
        <div className="space-y-2">
          <label className="text-sm font-medium" htmlFor="email">
            Email
          </label>
          <input
            className="w-full p-2 border border-gray-200 rounded-md focus:outline-none focus:ring focus:ring-gray-300"
            id="email"
            placeholder="m@example.com"
            required
            type="email"
          />
        </div>
        <div className="space-y-2">
          <label className="text-sm font-medium" htmlFor="password">
            Password
          </label>
          <input
            className="w-full p-2 border border-gray-200 rounded-md focus:outline-none focus:ring focus:ring-gray-300"
            id="password"
            required
            type="password"
          />
        </div>
      </div>
      <div className="p-4">
        <button className="w-full bg-gray-900 text-white rounded-md py-2 hover:bg-gray-800 focus:outline-none">
          Sign in
        </button>
      </div>
    </div>
  )
}

export default login