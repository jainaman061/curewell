import React, { useEffect, useState  } from 'react'
import { Link,useNavigate } from 'react-router-dom'

const Navbar = () => {
  const navigate=useNavigate();
  const[isLoggedin,SetIsLoggedin]=useState('false')
  useEffect(()=>{
    const token =localStorage.getItem("curewell_token");
    if(!token){SetIsLoggedin(false)}
    else{SetIsLoggedin(true)}
  },[isLoggedin])
  const onLogoutHandler=()=>{
    localStorage.removeItem("curewell_token");
    SetIsLoggedin(false);
    navigate("/login");
  }
  return (
    <div className="bg-gray-500 justify-center items-center py-2 w-screen ">
      <div className='flex justify-between'>
      <h1 className='ml-12'><Link  to={"/"} >Cure Well</Link></h1>
      <ul className='flex mr-12'>
        
        <li className='px-4'><Link to="/doctor">doctor</Link></li>
        <li className='px-4'><Link to="/specialization">specializations</Link></li>
        <li className='px-4'><Link to="/doctorSpecialization">Doctor_specializations</Link></li>
        <li className='px-4'><Link to="/surgery">Surgery</Link></li>
        <li className='px-4 text-red-900  bg-white rounded-sm  text-center  '>{!isLoggedin ? (
            <Link className="btn btn-primary" to={"/login"}>
              Login
            </Link>
          ) : (
            <button className="btn btn-danger" onClick={onLogoutHandler}>
              Logout
            </button>
          )}</li>


      </ul>
      
    </div>
   
    </div>
  )
}

export default Navbar