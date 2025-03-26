import React, { useEffect, useState } from 'react'
import apiClient from '../../Client/ApiCLient';
import { Link, useNavigate } from 'react-router-dom';
// import AddDoctor from './Addcomponent';
// import UpdateDoctor from './UpdateDoctor';
import Popup from 'reactjs-popup';

const SurgeryList = () => {
    const [surgery,SetSurgery] = useState([]);
    const [refresh, setRefresh] = useState(false);
    const navigate = useNavigate();
    useEffect(()=>{
        apiClient.get("/surgery")
        .then(
            (response)=>{
                SetSurgery(response.data);
                console.log(response.data);
                
            },
            (error)=>{
                console.log(error)
            }
        )
        .catch((error)=>console.log(error));
        
    },[])
    const deletecontent=async(values)=>{
      apiClient.delete(`/surgery/${values}`)
      .then(
        (response)=>{
           navigate('/surgery')
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
    <Link className='border-2 border-black mt-4 px-2 hover:bg-blue-200' to={'/addSurgery'}>Add Surgery</Link>
     <table className='border-4 w-2/3  border-blue-700 mt-8'>
     <tr >
            <th className='border-2 border-blue-700'>Date</th>
            <th className='border-2 border-blue-700'>SurgeryId</th>
            <th className='border-2 border-blue-700'>Surgery name</th>
            <th className='border-2 border-blue-700'>Doctor Id</th>
            <th className='border-2 border-blue-700'>Doctor name</th>
            <th className='border-2 border-blue-700'>Start time</th>
            <th className='border-2 border-blue-700'>End time</th>
            <th className='border-2 border-blue-700'>update</th>
            <th className='border-2 border-blue-700'>delete</th>
            
        </tr>
        {
          surgery.map((surgery,index)=>(
           
            
            <tr key={index} className='items-center justify-center'>

              <td className='text-center'>{surgery.surgeryDate}</td>
              <td className='text-center'>{surgery.surgeryId}</td>
              <td className='text-left pl-3'>{surgery.specialization.name}</td>
              <td className='text-center'>{surgery.doctor.id}</td>
              <td className='text-center'>{surgery.doctor.name}</td>
              <td className='text-center'>{surgery.startTime}</td>
              <td className='text-center'>{surgery.endTime}</td>

              
        
             <td className='text-center'> <button className='border-2 border-blue-400 m-2 bg-blue-400' onClick={() => navigate(`/addsurgery/${surgery.surgeryId}`,{state:{surgery:{id:surgery.surgeryId,startTime:surgery.startTime,endTime:surgery.endTime}}}) }>update surgery</button></td>
              <td className='text-center'> 
              <Popup  
  trigger={<button className="border-2 border-red-400 m-2 bg-red-400 "> Delete Surgery </button>} 
  modal 
  nested 
> 
  {close => (
    <div className="absolute top-0 right-0 w-96 h-40 bg-white shadow-lg rounded-lg p-6 border">
      <div className="text-lg font-semibold mb-4">
        This will delete surgery<span className="text-red-600">{surgery.surgeryId}</span>.
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
          onClick={() => {deletecontent(surgery.surgeryId)}}
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

export default SurgeryList