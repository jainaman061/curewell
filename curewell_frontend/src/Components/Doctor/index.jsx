import React, { useEffect, useState } from 'react'
import apiClient from '../../Client/ApiCLient';
import { Link, useNavigate } from 'react-router-dom';
// import AddDoctor from './Addcomponent';
// import UpdateDoctor from './UpdateDoctor';
import Popup from 'reactjs-popup';

const DoctorList = () => {
    const [doctors,SetDoctors] = useState([]);
    const [refresh, setRefresh] = useState(false);
    const navigate = useNavigate();
    useEffect(()=>{
        apiClient.get("/doctor")
        .then(
            (response)=>{
                SetDoctors(response.data);
                console.log(response.data);
                
            },
            (error)=>{
                console.log(error)
            }
        )
        .catch((error)=>console.log(error));
        
    },[])
    const deletecontent=async(values)=>{
      apiClient.delete(`/doctor/${values}`)
      .then(
        (response)=>{
           navigate('/doctor')
           setRefresh(true);
            console.log(response.data);
            
        },
        (error)=>{
            console.log(error)
        }
    )
    .catch((error)=>console.log(error));
      console.log(values);
      
    }
    useEffect(() => {
      if (refresh) {
        window.location.reload();
      }
    }, [refresh]);
  
  return (
   <div className='w-screen flex flex-col items-center justify-center'>
    <Link className='border-2 border-black mt-4 px-2 hover:bg-blue-200' to={'/addDoctor'}>Add Doctor</Link>
     <table className='border-4 w-1/3  border-blue-700 mt-8'>
        <tr >
      
            <th className='border-2 border-blue-700'>Doctor Id</th>
            <th className='border-2 border-blue-700'>Doctor name</th>
            <th className='border-2 border-blue-700'>Update Doctor</th>
            <th className='border-2 border-blue-700'>Delete Doctor</th>
         
            
        </tr>
        {
          doctors.map((doctor,index)=>(
           
            
            <tr key={index} className='items-center justify-center'>

             
              <td className='text-center'>{doctor.id}</td>
              <td className='text-center'>{doctor.name}</td>
            <td className='text-center'> <button className='border-2 border-blue-400 m-2 bg-blue-400' onClick={() => navigate(`/doctor/${doctor.id}`,{state:{doctor:{id:doctor.id,name:doctor.name}}}) }>update doctor</button></td>
              <td className='text-center'> 
              <Popup  
  trigger={<button className="border-2 border-red-400 m-2 bg-red-400 "> Delete Doctor </button>} 
  modal 
  nested 
> 
  {close => (
    <div className="absolute top-0 right-0 w-96 h-40 bg-white shadow-lg rounded-lg p-6 border">
      <div className="text-lg font-semibold mb-4">
        This will delete <span className="text-red-600">{doctor.name}</span> and their surgeries.
      </div>
      
      <div className="flex justify-end gap-4">
        
        <button 
          className="border-2 border-gray-400 bg-gray-300 px-4 py-2 rounded-md" 
          onClick={close}
        >
          Cancel
        </button>

        
        <button 
          className="border-2 border-red-500 bg-red-500 text-white px-4 py-2 rounded-md" 
          onClick={() => {deletecontent(doctor.id)}}
        >
          Delete
        </button>
      </div>
    </div>
  )}
</Popup>
</td>
            </tr>

          ))
        }
       
    </table>
    
   </div>
  )
}

export default DoctorList