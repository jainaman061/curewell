import React from 'react'
import Navbar from "../../Components/Navbar"
import DoctorList from '../../Components/Doctor'
const Doctor = () => {
  return (
    <div className='flex flex-col h-screen w-screen bg-gray-200 items-center'>
        <Navbar />
        <DoctorList />
    </div>
  )
}

export default Doctor