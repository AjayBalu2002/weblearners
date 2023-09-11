import React, { Component ,useState} from 'react';
import './Login.css';
import { useNavigate } from 'react-router-dom';
import {Button, Input} from '@mantine/core'
import { Link } from 'react-router-dom';
import axios from 'axios';


export default function Loginpage()
{





    const [userDetails,setuserdetails] = useState({email:"",password:""})    
    const nav = useNavigate()

function handleuserdetailsname(e)
{

  setuserdetails( { email:e.target.value,password:userDetails.password})

console.log(userDetails)

} 

function handleuserdetailspassword(e)
{
    setuserdetails( { email:userDetails.email,password:e.target.value})
    console.log(userDetails)
}

let redirect =false
function handlelogin() {
  if(userDetails.email!=""&&userDetails.password!="")
  {

  
    axios
      .post('http://localhost:5000/users/login',  userDetails)
      .then((response) => {
        const token = response.data.token.token;
        console.log(response.data.token)
        console.log(token)
        localStorage.setItem('token', token);
        redirect = true
        console.log('Login successful');
        if(token!=null)
        {
          handleuserinfo(token)
        }
      
      })
      .catch((error) => {
        console.error('Login failed:', error);
        redirect = false
      });
    }
  }


  function handleuserinfo(token) {
    const email = userDetails.email; // Assuming userDetails is defined somewhere
  
    axios.post('http://localhost:5000/users/getuserid', userDetails, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    })
    .then(res => {
      
      localStorage.setItem('userId', res.data.id);
      localStorage.setItem('userName', res.data.name);
      nav('/home');
    })
    .catch(error => {
      console.log(error);
      
    });
  }
  


    return(
        <div>
<div className='TotalLogin'>
    <div className='LoginCard'>
<label className='loginLabelss'  >email</label>
    <Input className='LoginInput' onChange={(e)=>handleuserdetailsname(e)}  ></Input>
<label className='loginLabels' >password</label>
    <Input  className='LoginInput' onChange={(e)=>handleuserdetailspassword(e)} ></Input>

    <Button style={{backgroundColor :'orange'}}   onClick={()=>handlelogin()}  >Login</Button>
 <label> don't have an account?</label> <a  style={{color:'black'}} onClick={()=>nav('/register')} >register now</a> 
 
    </div>

  
</div>
</div>
    )
}