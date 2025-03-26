import React, { useEffect } from 'react'
import Navbar from '../../Components/Navbar'
import TodaysSurgery from '../../Components/TodaySurgery'

const Home = () => {
  
  return (
    <div className='flex flex-col h-screen w-screen bg-gray-200 items-center'>
        <Navbar />
        <TodaysSurgery />   
      
    </div>
)
}

export default Home