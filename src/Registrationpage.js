import React, { Component, useState } from 'react';
import './Registration.css'
import { Button, ColorSwatch, Input } from '@mantine/core';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
export default function Registrationpage()
{

const [userDetails,setuserdetails] = useState({name:"",email:"",password:""})    
    const nav = useNavigate()

function handetailsname(e)
{

  setuserdetails( { name:e.target.value,email:userDetails.email ,password:userDetails.password})

console.log(userDetails)

} 

function handleuserdetailspassword(e)
{
    setuserdetails( { name:userDetails.name,email:userDetails.email ,password:e.target.value})
    console.log(userDetails)
}


function handleuserdetailsemail(e)
{
    setuserdetails( { name:userDetails.name,email:e.target.value ,password:userDetails.password})
}


function handleregister()
{
    if(userDetails.email!=''&&userDetails.password!=''&&userDetails.name!='')
    {

    
    axios.post("http://localhost:5000/users/new",userDetails).then( res => console.log(res))
    nav('/')
    }
}
    return(

<div>
<div>

<div className='TotalRegister'>


    <div className='RegisterCard'>
    <label className='RegisterLabels'>name</label>
    <Input onChange={(e)=>handetailsname(e)}  ></Input>
    <label className='RegisterLabelsss' >email</label>
    <Input onChange={(e)=>handleuserdetailsemail(e)}  ></Input>


<label className='RegisterLabelsss' >password</label>
    <Input onChange={(e)=>handleuserdetailspassword(e)}  ></Input>

    <Button style={{backgroundColor:'orange'}} onClick={()=>handleregister()}  >register</Button>
 
    </div>

  
</div>
</div>
</div>



    )
}