import React, { useEffect, useState } from 'react'
import * as Yup from 'yup';
import { useFormik } from 'formik';
import { useNavigate,Link } from 'react-router-dom';
import axios from 'axios';
import Navbar from "../../../Components/Navbar/index"
import apiClient from '../../../Client/ApiCLient';
const AddComponent = () => {
  const [requestResponse,SetRequestResponse]=useState({
          message:"",
          alertClassname:""
  
      });
      const navigate = useNavigate();
      const initialValues={
        code:"",
          name:""
      }
      const onSubmit= async (values)=>{
         apiClient.post("/specialization",values)
          .then(
              (response)=>{
                  SetRequestResponse({
                      message:"Specialization Added Sucessfully",
                      alertClassname:"bg-teal-100 border-t-4 border-teal-500 rounded-lg text-teal-900 px-4  shadow-md px-12 mb-4"
                  })
     
                  setTimeout(() => {
                      navigate("/specialization")
                  }, 1000);
              },
              (error)=>{
                  console.log(error);
                  SetRequestResponse({
                      message:error.response.data.message,
                      alertClassname:"border border-t-0 border-red-400  bg-red-100 px-4 text-red-700 px-12 rounded-lg mb-4 "
                  })
              }
          )
          .catch((error)=>console.log(error));
  
  
      }
      useEffect(()=>{
  
      },[requestResponse])
      const validationSchema = Yup.object({
          name: Yup.string().required("name is required"),
          code: Yup.string().required("code is required")
      })
      const formik = useFormik({
          initialValues,
          onSubmit,
          validationSchema,
          validateOnMount:true,
      });
  return (
    <div>
      <Navbar />
      <div className='h-screen bg-gray-500 flex flex-col justify-center items-center'>
   <div> <div className={requestResponse.alertClassname} role='alert'><p>{requestResponse.message}</p></div>

    </div>
    <div className='flex justify-center items-center'>
        <form className="p-6 bg-white shadow-md rounded-lg" onSubmit={formik.handleSubmit}>
            <div>
                <h1>Add Specialization</h1>

            </div>
            <div className='flex flex-col'>
                <input className='my-4 border-s-2
                border-gray-700 text-black 
                focus:outline-none px-2' 
                type='text'
                name='code'
                placeholder='code'
                value={formik.values.code}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}/>
                <input className='my-4 border-s-2
                border-gray-700 text-black 
                focus:outline-none px-2' 
                type='text'
                name='name'
                placeholder='name'
                value={formik.values.name}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}/>
                
                 <button  type="submit" className='w-36 bg-black text-white my-4  '>Add specialization</button>
                       
            </div>

        </form>
    </div>
    </div>
    </div>
  )
}

export default AddComponent