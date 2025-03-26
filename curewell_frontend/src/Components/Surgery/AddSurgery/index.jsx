import React, { useEffect, useState } from "react";
import * as Yup from "yup";
import { useFormik } from "formik";
import { useNavigate } from "react-router-dom";
import Navbar from "../../../Components/Navbar/index";
import apiClient from "../../../Client/ApiCLient";

const AddComponent = () => {
  const [requestResponse, SetRequestResponse] = useState({
    message: "",
    alertClassname: "",
  });

  const navigate = useNavigate();

  const initialValues = {
    surgerydate: "",
    starttime: "",
    endtime: "",
    doctorId: "",
    surgeryCode: "",
  };

  const validationSchema = Yup.object({
    surgerydate: Yup.string().required("Date is required"),
    starttime: Yup.string().required("Start Time is required"),
    endtime: Yup.string().required("End Time is required"),
    doctorId: Yup.string().required("Doctor ID is required"),
    surgeryCode: Yup.string().required("Surgery Code is required"),
  });

  const onSubmit = async (values) => {
    apiClient.post("/surgery",values)
    .then(
        (response)=>{
            SetRequestResponse({
                message:"Surgery Added Sucessfully",
                alertClassname:"bg-teal-100 border-t-4 border-teal-500 rounded-lg text-teal-900 px-4  shadow-md px-12 mb-4"
            })

            setTimeout(() => {
                navigate("/surgery")
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
  };

  const formik = useFormik({
    initialValues,
    onSubmit,
    validationSchema,
    validateOnMount: true,
  });

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
            <h1 className="text-xl font-bold mb-4">Add Surgery</h1>
            <div>
              <label className="block">Surgery Date</label>
              <input
                type="date"
                name="surgerydate"
                className="border p-2 rounded-lg w-full"
                value={formik.values.surgerydate}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
              />
            </div>


            <div>
              <label className="block">Surgery Code</label>
              <input
                type="text"
                name="surgeryCode"
                className="border p-2 rounded-lg w-full"
                value={formik.values.surgeryCode}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
              />
            </div>

            <div>
              <label className="block">Doctor ID</label>
              <input
                type="text"
                name="doctorId"
                className="border p-2 rounded-lg w-full"
                value={formik.values.doctorId}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
              />
            </div>

            {/* Start Time */}
            <div>
              <label className="block">Start Time</label>
              <input
                type="time"
                name="starttime"
                className="border p-2 rounded-lg w-full"
                value={formik.values.starttime}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
              />
            </div>

            {/* End Time */}
            <div>
              <label className="block">End Time</label>
              <input
                type="time"
                name="endtime"
                className="border p-2 rounded-lg w-full"
                value={formik.values.endtime}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
              />
            </div>

            <button
              type="submit"
              className="w-full bg-black text-white p-2 rounded-lg mt-4"
            >
              Add Surgery
            </button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default AddComponent;
