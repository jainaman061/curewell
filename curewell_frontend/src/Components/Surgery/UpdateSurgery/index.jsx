import React, { useEffect, useState } from 'react'
import { useLocation, useNavigate } from 'react-router-dom';
import apiClient from '../../../Client/ApiCLient';
import * as Yup from "yup"
import Navbar from '../../Navbar';
import { useFormik } from 'formik';
const Updatesurgery = (props) => {
 
    const location = useLocation();
  const surgery = location.state.surgery; 
    console.log(surgery);
    
  const [requestResponse,SetRequestResponse]=useState({
          message:"",
          alertClassname:""
  
      });
      const navigate = useNavigate();
      const initialValues={
        endTime:surgery.endTime,
        startTime:surgery.startTime
        
      }
      const onSubmit=async(values)=>{
        apiClient.put(`/surgery/${surgery.id}`,values)
        .then(
          (response)=>{
            SetRequestResponse({
              message:"Surgery updated Sucessfully",
              alertClassname:"bg-teal-100 border-t-4 border-teal-500 rounded-lg text-teal-900 px-4  shadow-md px-12 mb-4"
              
              
            })
            console.log(response);
            
            setTimeout(() => {
              navigate("/surgery")
            }, 1000);
          },
          (error)=>{
            console.log(error);
            SetRequestResponse({
              message:"Invalid Credentials",
              alertClassname:"border border-t-0 border-red-400  bg-red-100 px-4 text-red-700 px-12 rounded-lg mb-4 "
          })
          
            
          }
        ).catch((error)=>console.log(error));
      }
      useEffect(()=>{

      },requestResponse)
      const validationSchema = Yup.object({
              startTime: Yup.string().required("start time is required"),
              endTime: Yup.string().required("end time is required")
              
          })
      const formik = useFormik({
        initialValues,
        onSubmit,
        validationSchema,
        validateOnMount:true
      })
  return (
    <div>
      <Navbar />
      <div className="h-screen bg-gray-500 flex flex-col justify-center items-center">
        <div>
          <div className={requestResponse.alertClassname} role="alert">
            <p>{requestResponse.message}</p>
          </div>
        </div>
        <div className="flex w-80 justify-center items-center">
          <form
            className="p-6 w-screen bg-white shadow-md rounded-lg"
            onSubmit={formik.handleSubmit}
          >
            <h1 className="text-xl font-bold mb-4">Update Surgery</h1>
            




            {/* Start Time */}
            <div>
              <label className="block">Start Time</label>
              <input
                type="time"
                name="startTime"
                className="border p-2 rounded-lg w-full"
                value={formik.values.startTime}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
              />
            </div>

            {/* End Time */}
            <div>
              <label className="block">End Time</label>
              <input
                type="time"
                name="endTime"
                className="border p-2 rounded-lg w-full"
                value={formik.values.endTime}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
              />
            </div>

            <button
              type="submit"
              className="w-full bg-black text-white p-2 rounded-lg mt-4"
            >
              Update  Surgery
            </button>
          </form>
        </div>
      </div>
    </div>
  )
}

export default Updatesurgery