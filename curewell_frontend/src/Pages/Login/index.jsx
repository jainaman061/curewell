import React, { useEffect, useState } from 'react'
import * as Yup from 'yup';
import { useFormik } from 'formik';
import { useNavigate,Link } from 'react-router-dom';
import axios from 'axios';
const Login = () => {
    const [requestResponse,SetRequestResponse]=useState({
        message:"",
        alertClassname:""

    });
    const navigate = useNavigate();
    const initialValues={
        usernameOrEmail:"",
        password:""
    }
    const onSubmit= async (values)=>{
        axios.post("http://localhost:8080/api/auth/login",values)
        .then(
            (response)=>{
                SetRequestResponse({
                    message:"User Logged in",
                    alertClassname:"bg-teal-100 border-t-4 border-teal-500 rounded-lg text-teal-900 px-4  shadow-md px-12 mb-4"
                })
                // console.log(response.data);
                localStorage.setItem("curewell_token",response.data);
                setTimeout(() => {
                    navigate("/")
                }, 1000);
            },
            (error)=>{
                console.log(error);
                SetRequestResponse({
                    message:"Invalid Credentials",
                    alertClassname:"border border-t-0 border-red-400  bg-red-100 px-4 text-red-700 px-12 rounded-lg mb-4 "
                })
            }
        )
        .catch((error)=>console.log(error));


    }
    useEffect(()=>{

    },[requestResponse])
    const validationSchema = Yup.object({
        usernameOrEmail: Yup.string().required("username or email is required"),
        password:Yup.string().required("password is required")
    })
    const formik = useFormik({
        initialValues,
        onSubmit,
        validationSchema,
        validateOnMount:true,
    });
  return (
    <div className='h-screen bg-gray-500 flex flex-col justify-center items-center'>
   <div> <div className={requestResponse.alertClassname} role='alert'><p>{requestResponse.message}</p></div>

    </div>
    <div className='flex justify-center items-center'>
        <form className="p-6 bg-white shadow-md rounded-lg" onSubmit={formik.handleSubmit}>
            <div>
                <h1>Curewell</h1>

            </div>
            <div className='flex flex-col'>
                <input className='my-4 border-s-2
                border-gray-700 text-black 
                focus:outline-none px-2' 
                type='text'
                name='usernameOrEmail'
                placeholder='usernameOrEmail'
                value={formik.values.usernameOrEmail}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}/>
                <input className='my-4 border-s-2
                border-gray-700 text-black 
                focus:outline-none px-2' 
                type='password'
                name='password'
                placeholder='password'
                value={formik.values.password}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}/>
                 <button  type="submit" className='w-20 bg-black text-white my-4  '>Login</button>
                        <span>create a new Account ? <Link to="/register" className='text text-blue-600'>?<u>Register</u></Link></span>
            </div>

        </form>
    </div>
    </div>
  )
}

export default Login