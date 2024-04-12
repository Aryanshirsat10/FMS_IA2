import { useState } from 'react'
import './App.css'
import api from './api/axiosConfig';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from './login'
import Dashboard from './Dashboard'
import Navbar from './components/Navbar'
import Orders from './Orders';

function App() {
  const [user, setUser] = useState({});
  const getUser = async () =>{
    try
    {

      const response = await api.get("/");
      console.log(response)
      setUser(response.data);

    } 
    catch(err)
    {
      console.log(err);
    }
  }
  return (
    <Router>
      <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/dashboard" element={<Dashboard/>} />
          <Route path='/orders' element={<Orders />} />
        </Routes>
    </Router>
  )
}

export default App
