import React from 'react'

const surgerytable = (props) => {
  const surgeries =props.data;
  console.log(surgeries);
  
  
  
  return (

      <table className='border-4 w-10/12 border-blue-700 mt-8'>
        <tr >
            <th className='border-2 border-blue-700'>Date</th>
            <th className='border-2 border-blue-700'>SurgeryId</th>
            <th className='border-2 border-blue-700'>Surgery name</th>
            <th className='border-2 border-blue-700'>Doctor Id</th>
            <th className='border-2 border-blue-700'>Doctor name</th>
            <th className='border-2 border-blue-700'>Start time</th>
            <th className='border-2 border-blue-700'>End time</th>
            
        </tr>
        {
          surgeries.map((surgery,index)=>(
           
            
            <tr key={index} className='items-center justify-center'>

              <td className='text-center'>{surgery.surgeryDate}</td>
              <td className='text-center'>{surgery.surgeryId}</td>
              <td className='text-left pl-3'>{surgery.specialization.name}</td>
              <td className='text-center'>{surgery.doctor.id}</td>
              <td className='text-center'>{surgery.doctor.name}</td>
              <td className='text-center'>{surgery.startTime}</td>
              <td className='text-center'>{surgery.endTime}</td>

              
            </tr>

          ))
        }
       
    </table>
   
  )
}

export default surgerytable