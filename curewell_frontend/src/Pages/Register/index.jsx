import axios from 'axios';
import { useFormik } from 'formik';
import * as Yup from 'yup';
import React, { useEffect, useState } from 'react'
import { Link,useNavigate } from 'react-router-dom'
const Register = () => {
    const [requestresponse,SetRequestresponse]= useState({
        message:"",
        alertClasname:""
    });
    const navigate=useNavigate();
    const initialValues={
        username:"",
        email:"",
        password:"",
        name:""
    }
    const onSubmit = async (values) => {
       
      
           axios.post("http://localhost:8080/api/auth/register",values)
            .then(
                (response)=>{
                    SetRequestresponse({
                        message:"User Registerd Sucessfully Redirecting to login",
                        alertClasname:" bg-teal-100 border-t-4 border-teal-500 rounded-lg text-teal-900 px-4  shadow-md px-12 mb-4"
                    })
                    console.log(response);
                    setTimeout(() => {
                        navigate("/login");    
                    }, 1500);
                    
                   
                },
                (error)=>{
                    console.log(error);
                    
                    SetRequestresponse({
                        message:error.response.data.message,
                        alertClasname:"border border-t-0 border-red-400  bg-red-100 px-4 text-red-700 px-12 rounded-lg mb-4 "
                    })
                }
            )
            .catch((error)=>console.log(error));
            

       
        // border border-t-0 border-red-400 rounded-b bg-red-100 px-4 py-3 text-red-700
        
    }
    useEffect(() => {
        // console.log(requestresponse);
    }, [requestresponse]);
    const validationSchema = Yup.object({
        username:  Yup.string().required("Username is required"),
        email: Yup.string().email("invalid email fromat").required("email is required"),
        name: Yup.string().required("name is required"),
        password:Yup.string().required("password is required").min(6,"minimum 6 characters are required")

    })
    const formik = useFormik({
        initialValues,
        onSubmit,
        validationSchema,
        validateOnMount:true,
    });
    // useEffect(()=>{
    //     if(localStorage.getItem("curewell-token")){
    //         navigate('/')
    //     }
    // },[])
    
  return (
   <div className='h-screen bg-gray-500 flex flex-col justify-center items-center'> <div >
    <div className={requestresponse.alertClasname } role="alert">
   <p>{ requestresponse.message } </p>
 </div>
   </div>
      <div className='flex justify-center items-center'>
        
      <form className="p-6 bg-white shadow-md rounded-lg " onSubmit={formik.handleSubmit}>
        <div>
            <h1>CureWell</h1>
        </div>
        <div className='flex flex-col'>
        <input className='my-4 border-s-2  border-gray-700 text-black focus:outline-none px-2' 
        type='text' 
        placeholder='name' 
        name='name' 
        value={formik.values.name}
        onChange={formik.handleChange}
        onBlur={formik.handleBlur}/>
        <input className='my-4 border-s-2 border-gray-700 text-black focus:outline-none px-2' type='text' placeholder='username' name='username' 
        value={formik.values.username}
        onChange={formik.handleChange}
        onBlur={formik.handleBlur}/>
        <input   className='my-4 border-s-2 border-gray-700 text-black focus:outline-none px-2' type='email' placeholder='email' name='email'
        value={formik.values.email}
        onChange={formik.handleChange}
        onBlur={formik.handleBlur} />
        <input className='my-4 border-s-2 border-gray-700 text-black focus:outline-none px-2' type='password' placeholder='password' name='password'
        value={formik.values.password}
        onChange={formik.handleChange}
        onBlur={formik.handleBlur}/>
        <button  type="submit" className='w-20 bg-black text-white my-4 '>Register</button>
        <span>already have an account ? <Link to="/login" className='text text-blue-600'><u>Login</u></Link></span>
        </div>
      </form>
      {/* <div role="alert">
  
  <div class="border border-t-0 border-red-400 rounded-b bg-red-100 px-4 py-3 text-red-700">
    <p>Something not ideal might be happening.</p>
  </div>
</div>
<div class="bg-teal-100 border-t-4 border-teal-500 rounded-b text-teal-900 px-4 py-3 shadow-md" role="alert">

   
      
      <p class="text-sm">Make sure you know how these changes affect you.</p>
 
  
</div> */}
      </div>
      </div>
  )
}

export default Register